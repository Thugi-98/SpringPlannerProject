package com.example.springplannerproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatePlanResponse {

    private final Long id;
    private final String title;
    private final String writer;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreatePlanResponse(Long id, String title, String writer, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
