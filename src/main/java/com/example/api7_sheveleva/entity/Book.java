package com.example.api7_sheveleva.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String bookName;
    private String genre;
    private String authorName;

    public Book(String bookName, String genre, String authorName) {
        this.bookName = bookName;
        this.genre = genre;
        this.authorName = authorName;
    }
}
