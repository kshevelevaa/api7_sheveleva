package com.example.api7_sheveleva.controllers;

import com.example.api7_sheveleva.entity.Book;
import com.example.api7_sheveleva.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @QueryMapping
    public List<Book> findAllBooks(){
        return bookRepo.findAll();
    }

    @QueryMapping
    public List<Book> findAllByAuthor(@Argument String author){
        return  bookRepo.findBookByAuthorName(author);
    }

    @MutationMapping
    public Book createBook (@Argument BookInput bookInput){
        Book book = new Book(bookInput.bookName, bookInput.genre, bookInput.authorName);
        return bookRepo.save(book);
    }

    record BookInput(String bookName, String genre, String authorName){};
}
