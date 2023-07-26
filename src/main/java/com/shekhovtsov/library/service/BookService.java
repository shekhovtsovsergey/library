package com.shekhovtsov.library.service;

import com.shekhovtsov.library.dto.BookDto;
import com.shekhovtsov.library.exception.AuthorNotFoundException;
import com.shekhovtsov.library.exception.BookNotFoundException;
import com.shekhovtsov.library.exception.GenreNotFoundException;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();
    List<BookDto> deleteBookById(Long id);
    BookDto createBook(BookDto bookDto) throws AuthorNotFoundException, GenreNotFoundException;
    BookDto updateBook(BookDto bookDto) throws AuthorNotFoundException, GenreNotFoundException;
    BookDto getBookById(Long id) throws BookNotFoundException;

}
