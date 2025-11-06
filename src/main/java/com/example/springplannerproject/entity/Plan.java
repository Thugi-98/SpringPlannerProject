package com.example.springplannerproject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "plans")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plan extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String writer;
    private String password;

    public Plan(String title, String contents, String writer, String password) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.password = password;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContents(String contents) {
        this.contents = contents;
    }
}
