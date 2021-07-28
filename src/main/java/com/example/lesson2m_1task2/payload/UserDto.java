package com.example.lesson2m_1task2.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull(message = "Email should not be empty")
    private String email;

    @NotNull(message = "Password should not be empty")
    private String password;

}
