package com.example.lesson2m_1task2.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class HintDto {

    @NotNull(message = "Hint Content should not be empty")
    private String hint_content;
}
