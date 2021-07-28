package com.example.lesson2m_1task2.Service;

import com.example.lesson2m_1task2.Repository.SolutionRepository;
import com.example.lesson2m_1task2.Repository.TaskRepository;
import com.example.lesson2m_1task2.Repository.UserRepository;
import com.example.lesson2m_1task2.entity.Solution;
import com.example.lesson2m_1task2.entity.Task;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.SolutionDto;
import com.example.lesson2m_1task2.payload.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolutionService {

    @Autowired
    SolutionRepository solutionRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    public ApiResponse add(SolutionDto solutionDto){
        boolean exists = taskRepository.existsById(solutionDto.getTaskId());
        boolean user = userRepository.existsById(solutionDto.getUserId());
        if (!user)
            return new ApiResponse("User not found",false);

        if (!exists)
            return new ApiResponse("Task not found",false);

        Solution solution=new Solution();
        solution.setSolution_content(solutionDto.getSolution_content());
        solution.setTask(taskRepository.getById(solutionDto.getTaskId()));
        solution.setUser(userRepository.getById(solutionDto.getUserId()));
        solutionRepository.save(solution);
        return new ApiResponse("Added",true);
    }

    public ApiResponse get(Integer id){
        boolean exists = solutionRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Task not found",false);

        Solution solution = solutionRepository.getById(id);
        return new ApiResponse("Done!",true,solution);
    }

    public ApiResponse edit(SolutionDto solutionDto,Integer id){
        boolean exists = taskRepository.existsById(solutionDto.getTaskId());
        boolean solution = solutionRepository.existsById(id);
        boolean user = userRepository.existsById(solutionDto.getUserId());
        if (!user)
            return new ApiResponse("User not found",false);

        if (!exists)
            return new ApiResponse("Task not found",false);

        if (!solution)
            return new ApiResponse("Solution not found",false);

        Solution solution1 = solutionRepository.getById(id);
        solution1.setSolution_content(solutionDto.getSolution_content());
        solution1.setTask(taskRepository.getById(solutionDto.getTaskId()));
        solution1.setUser(userRepository.getById(solutionDto.getUserId()));
        solutionRepository.save(solution1);

        return new ApiResponse("Edit!",true);
    }

    public ApiResponse delete(Integer id){
        boolean exists = solutionRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Task not found",false);
        solutionRepository.deleteById(id);
        return new ApiResponse("Delete!",true);
    }
}
