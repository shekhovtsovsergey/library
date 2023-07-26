package com.shekhovtsov.library.converter;


import com.shekhovtsov.library.dto.GenreDto;
import com.shekhovtsov.library.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreConverter {

    public GenreDto entityToDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

}
