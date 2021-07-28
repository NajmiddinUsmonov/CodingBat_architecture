package com.example.lesson2m_1task2.Controller;


import com.example.lesson2m_1task2.Service.SolutionService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.SolutionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/solution")
public class SolutionController {

    @Autowired
    SolutionService solutionService;
    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody SolutionDto solutionDto){
        ApiResponse add = solutionService.add(solutionDto);
        return ResponseEntity.status(add.isSuccess()?200:409).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = solutionService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@Valid @RequestBody SolutionDto solutionDto,Integer id){
        ApiResponse edit = solutionService.edit(solutionDto, id);
        return ResponseEntity.status(edit.isSuccess()?200:409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = solutionService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?202:409).body(delete);
    }
}
