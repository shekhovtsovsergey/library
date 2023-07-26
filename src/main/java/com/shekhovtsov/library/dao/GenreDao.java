package com.shekhovtsov.library.dao;

import com.shekhovtsov.library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Long> {

}