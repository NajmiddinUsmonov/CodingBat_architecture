package com.example.lesson2m_1task2.Controller;

import com.example.lesson2m_1task2.Service.HintService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.HintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/hint")
public class HintController {

    @Autowired
    HintService hintService;

    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody HintDto hintDto){
        ApiResponse add = hintService.add(hintDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = hintService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@Valid @RequestBody HintDto hintDto,@PathVariable Integer id){
        ApiResponse edit = hintService.edit(hintDto, id);
        return ResponseEntity.status(edit.isSuccess()?200:409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = hintService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:409).body(delete);
    }
}
