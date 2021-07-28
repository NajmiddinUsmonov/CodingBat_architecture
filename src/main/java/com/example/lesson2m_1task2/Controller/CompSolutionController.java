package com.example.lesson2m_1task2.Controller;

import com.example.lesson2m_1task2.Service.CompSolutionService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.CompSolutionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/compSolution")
public class CompSolutionController {

    @Autowired
    CompSolutionService compSolutionService;

    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody CompSolutionDto compSolutionDto){
        ApiResponse add = compSolutionService.add(compSolutionDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = compSolutionService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@Valid @RequestBody CompSolutionDto compSolutionDto,@PathVariable Integer id){
        ApiResponse edit = compSolutionService.edit(compSolutionDto, id);
        return ResponseEntity.status(edit.isSuccess()?200:409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = compSolutionService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:409).body(delete);
    }

}
