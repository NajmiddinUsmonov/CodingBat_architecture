package com.example.lesson2m_1task2.Service;

import com.example.lesson2m_1task2.Repository.CompSolutionRepository;
import com.example.lesson2m_1task2.Repository.TaskRepository;
import com.example.lesson2m_1task2.entity.CompSolution;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.CompSolutionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompSolutionService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CompSolutionRepository compSolutionRepository;

    public ApiResponse add(CompSolutionDto compSolutionDto){
        boolean exists = taskRepository.existsById(compSolutionDto.getTaskID());
        if (!exists)
            return new ApiResponse("Task not found",false);
        CompSolution compSolution=new CompSolution();
        compSolution.setSolution_content(compSolutionDto.getSolution_content());
        compSolution.setTask(taskRepository.getById(compSolutionDto.getTaskID()));
        CompSolution save = compSolutionRepository.save(compSolution);
        return new ApiResponse("Added!",true);
    }

    public ApiResponse get(Integer id){
        boolean exists = compSolutionRepository.existsById(id);
        if (!exists)
            return new ApiResponse("CompSolution not found",false);
        CompSolution solution = compSolutionRepository.getById(id);
        return new ApiResponse("Done!",true,solution);
    }

    public ApiResponse edit(CompSolutionDto compSolutionDto,Integer id){
        boolean exists = taskRepository.existsById(compSolutionDto.getTaskID());
        if (!exists)
            return new ApiResponse("Task not found",false);
        boolean compSolution1 = compSolutionRepository.existsById(id);
        if (!compSolution1)
            return new ApiResponse("CompSolution not found",false);

        CompSolution compSolution = compSolutionRepository.getById(id);
        compSolution.setSolution_content(compSolutionDto.getSolution_content());
        compSolution.setTask(taskRepository.getById(compSolutionDto.getTaskID()));
        CompSolution save = compSolutionRepository.save(compSolution);
        return new ApiResponse("Edit!",true);
    }
    public ApiResponse delete(Integer id){
        boolean exists = compSolutionRepository.existsById(id);
        if (!exists)
            return new ApiResponse("CompSolution not found",false);
        compSolutionRepository.deleteById(id);
        return new  ApiResponse("Deleted!",true);
    }

}
