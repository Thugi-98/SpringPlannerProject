package com.example.springplannerproject.dto;

import lombok.Getter;

@Getter
public class CreatePlanResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String writer;
    private final String password;
//    private final Date postDate;
//    private final Date editDate;

    public CreatePlanResponse(Long id, String title, String contents, String writer, String password) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.password = password;
    }
}
