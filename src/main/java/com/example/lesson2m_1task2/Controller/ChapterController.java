package com.example.lesson2m_1task2.Controller;


import com.example.lesson2m_1task2.Service.ChapterService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.ChapterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/chapter")
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody ChapterDto chapterDto){
        ApiResponse add = chapterService.add(chapterDto);
        return ResponseEntity.status(add.isSuccess()?201:409).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = chapterService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@Valid @PathVariable Integer id, @RequestBody ChapterDto chapterDto){
        ApiResponse edit = chapterService.edit(chapterDto, id);
        return ResponseEntity.status(edit.isSuccess()?200:409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = chapterService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:409).body(delete);
    }
}
