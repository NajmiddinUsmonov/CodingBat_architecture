package com.example.lesson2m_1task2.Service;

import com.example.lesson2m_1task2.Repository.ExampleRepository;
import com.example.lesson2m_1task2.Repository.TaskRepository;
import com.example.lesson2m_1task2.entity.Example;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.ExampleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ExampleRepository exampleRepository;

    public ApiResponse add(ExampleDto exampleDto){
        boolean exists = taskRepository.existsById(exampleDto.getTaskId());
        if (!exists)
            return new ApiResponse("Task not found",false);
        Example example=new Example();
        example.setTask(taskRepository.getById(exampleDto.getTaskId()));
        example.setExample_content(exampleDto.getExample_content());
        exampleRepository.save(example);
        return new ApiResponse("Added!",true);
    }

    public ApiResponse get(Integer id){
        boolean exists = exampleRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Example not found",false);
        Example example = exampleRepository.getById(id);
        return new ApiResponse("Added!",true,example);
    }

    public ApiResponse edit(ExampleDto exampleDto,Integer id){
        boolean exists = taskRepository.existsById(exampleDto.getTaskId());
        if (!exists)
            return new ApiResponse("Task not found",false);
        boolean exists2 = exampleRepository.existsById(id);
        if (!exists2)
            return new ApiResponse("Example not found",false);

        Example example = exampleRepository.getById(id);
        example.setExample_content(exampleDto.getExample_content());
        example.setTask(taskRepository.getById(exampleDto.getTaskId()));
        exampleRepository.save(example);
        return new ApiResponse("Edit!",true);
    }

    public ApiResponse delete(Integer id){
        boolean exists = exampleRepository.existsById(id);
        if (!exists)
            return new ApiResponse("Example not found",false);
        exampleRepository.deleteById(id);
        return new ApiResponse("Deleted!",true);
    }

}
