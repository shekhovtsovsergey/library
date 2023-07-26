package com.shekhovtsov.library.dao;

import com.shekhovtsov.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {

}
