package com.example.springplannerproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatePlanRequest {

    private String title;
    private String contents;
    private String writer;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
