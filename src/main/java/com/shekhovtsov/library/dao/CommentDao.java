package com.shekhovtsov.library.dao;

import com.shekhovtsov.library.model.Book;
import com.shekhovtsov.library.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {

    void deleteByBook(Book book);
}
