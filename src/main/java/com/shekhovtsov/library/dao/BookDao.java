package com.shekhovtsov.library.dao;

import com.shekhovtsov.library.model.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookDao extends JpaRepository<Book, Long> {

    @EntityGraph(attributePaths = "comments")
    Optional<Book> findById(Long id);

}