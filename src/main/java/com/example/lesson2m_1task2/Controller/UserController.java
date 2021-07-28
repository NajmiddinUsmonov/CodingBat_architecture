package com.example.lesson2m_1task2.Controller;


import com.example.lesson2m_1task2.Service.UserService;
import com.example.lesson2m_1task2.payload.ApiResponse;
import com.example.lesson2m_1task2.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody UserDto userDto){
        ApiResponse add = userService.add(userDto);
        return ResponseEntity.status(add.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(add);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Integer id){
        ApiResponse apiResponse = userService.get(id);
        return ResponseEntity.status(apiResponse.isSuccess()?202:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> edit(@Valid @PathVariable Integer id,@RequestBody UserDto userDto){
        ApiResponse edit = userService.edit(userDto, id);
        return ResponseEntity.status(edit.isSuccess()?200:409).body(edit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer id){
        ApiResponse delete = userService.delete(id);
        return ResponseEntity.status(delete.isSuccess()?200:409).body(delete);
    }

}
