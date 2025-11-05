package com.example.springplannerproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetPlanResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String writer;
    private final LocalDateTime postWhen;
    private final LocalDateTime editWhen;

    public GetPlanResponse(Long id, String title, String contents, String writer, LocalDateTime postWhen, LocalDateTime editWhen) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.postWhen = postWhen;
        this.editWhen = editWhen;
    }
}
