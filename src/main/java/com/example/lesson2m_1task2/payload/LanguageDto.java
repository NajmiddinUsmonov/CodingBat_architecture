package com.example.lesson2m_1task2.payload;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LanguageDto {

    @NotNull(message = "Name should not be empty")
    private String name;

}
