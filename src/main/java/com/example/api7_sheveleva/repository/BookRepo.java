package com.example.api7_sheveleva.repository;

import com.example.api7_sheveleva.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findBookByAuthorName(String authorName);
}
