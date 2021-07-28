package com.example.lesson2m_1task2.Controller;

import com.example.lesson2m_1task2.Service.TaskService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody TaskDto taskDto){
        ApiResponse add = taskService.add(taskDto);
        return ResponseEntity.status(add.isSuccess()? 201:409).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = taskService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@Valid @RequestBody TaskDto taskDto,@PathVariable Integer id){
        ApiResponse edit = taskService.edit(taskDto, id);
        return ResponseEntity.status(edit.isSuccess()?202:409).body(edit);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = taskService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:409).body(delete);
    }

}
