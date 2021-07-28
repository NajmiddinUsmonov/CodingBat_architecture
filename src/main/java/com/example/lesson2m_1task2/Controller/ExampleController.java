package com.example.lesson2m_1task2.Controller;

import com.example.lesson2m_1task2.Service.ExampleService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.ExampleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody ExampleDto exampleDto){
        ApiResponse add = exampleService.add(exampleDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = exampleService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@Valid @RequestBody ExampleDto exampleDto,@PathVariable Integer id){
        ApiResponse edit = exampleService.edit(exampleDto, id);
        return ResponseEntity.status(edit.isSuccess()?200:409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = exampleService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:409).body(delete);
    }
}
