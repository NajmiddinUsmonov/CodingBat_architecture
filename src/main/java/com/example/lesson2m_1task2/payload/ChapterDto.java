package com.example.lesson2m_1task2.payload;


import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class ChapterDto {

    @NotNull(message = "Name should not be empty")
    private String name;

    @NotNull(message = "Description should not be empty")
    private String description;


    @NotNull(message = "Language'Ids should not be empty")
    private Integer languageId;
}
