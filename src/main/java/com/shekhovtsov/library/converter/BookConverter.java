package com.shekhovtsov.library.converter;


import com.shekhovtsov.library.dto.BookDto;
import com.shekhovtsov.library.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookConverter {

    public BookDto entityToDto(Book book) {
        return new BookDto(book.getId(), book.getName(),book.getAuthor().getId(),book.getGenre().getId());
    }

}
