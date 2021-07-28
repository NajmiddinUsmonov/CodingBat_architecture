package com.example.lesson2m_1task2.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class SolutionDto {

    @NotNull(message = "Solution Content should not be empty")
    private String solution_content;

    @NotNull(message = "Task ID should not be empty")
    private Integer taskId;

    @NotNull(message = "User ID should not be empty")
    private Integer userId;
}
