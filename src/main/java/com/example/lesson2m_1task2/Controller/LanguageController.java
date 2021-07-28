package com.example.lesson2m_1task2.Controller;

import com.example.lesson2m_1task2.Service.LanguageService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody LanguageDto languageDto){
        ApiResponse add = languageService.add(languageDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = languageService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@PathVariable Integer id,@RequestBody LanguageDto languageDto){
        ApiResponse edit = languageService.edit(languageDto, id);
        return ResponseEntity.status(edit.isSuccess()?200:409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = languageService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:409).body(delete);
    }
}
