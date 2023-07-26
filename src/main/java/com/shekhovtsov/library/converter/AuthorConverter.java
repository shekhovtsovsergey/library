package com.shekhovtsov.library.converter;


import com.shekhovtsov.library.dto.AuthorDto;
import com.shekhovtsov.library.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorConverter {

    public AuthorDto entityToDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

}
