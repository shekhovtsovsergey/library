package com.shekhovtsov.library.service;

import com.shekhovtsov.library.converter.GenreConverter;
import com.shekhovtsov.library.dao.GenreDao;
import com.shekhovtsov.library.dto.GenreDto;
import com.shekhovtsov.library.exception.GenreNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreServiceImpl implements GenreService{

    private final GenreDao genreDao;
    private final GenreConverter genreConverter;

    public List<GenreDto> getAllGenre() throws GenreNotFoundException {
        return genreDao.findAll().stream().map(genreConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    public GenreDto getGenreById(Long id) throws GenreNotFoundException {
            return genreConverter.entityToDto(genreDao.findById(id).orElseThrow(() -> new GenreNotFoundException(id)));
    }
}
