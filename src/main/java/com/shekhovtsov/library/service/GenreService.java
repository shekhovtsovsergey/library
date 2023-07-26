package com.shekhovtsov.library.service;

import com.shekhovtsov.library.dto.GenreDto;
import com.shekhovtsov.library.exception.GenreNotFoundException;

import java.util.List;

public interface GenreService {

    List<GenreDto> getAllGenre() throws GenreNotFoundException;
    GenreDto getGenreById(Long id) throws GenreNotFoundException;


}
