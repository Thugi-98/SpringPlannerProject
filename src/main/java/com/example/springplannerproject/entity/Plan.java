package com.example.springplannerproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "plans")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String writer;
    private String password;
    private LocalDateTime postWhen;
    private LocalDateTime editWhen;

    public Plan(String title, String contents, String writer, String password) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.password = password;
        postWhen = java.time.LocalDateTime.now();
        editWhen = java.time.LocalDateTime.now();
    }

    public void updateTitle(String title) {
        this.title = title;
        editWhen = java.time.LocalDateTime.now();
    }

    public void updateContents(String contents) {
        this.contents = contents;
        editWhen = java.time.LocalDateTime.now();
    }
}
