package com.example.lesson2m_1task2.payload;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CompSolutionDto {

    @NotNull(message = "Solution_Content should not be empty")
    private String solution_content;

    @NotNull(message = "Task's ID should not be empty")
    private Integer taskID;
}
