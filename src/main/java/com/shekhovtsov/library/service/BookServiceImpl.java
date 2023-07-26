package com.shekhovtsov.library.service;

import com.shekhovtsov.library.converter.BookConverter;
import com.shekhovtsov.library.dao.AuthorDao;
import com.shekhovtsov.library.dao.BookDao;
import com.shekhovtsov.library.dao.CommentDao;
import com.shekhovtsov.library.dao.GenreDao;
import com.shekhovtsov.library.dto.BookDto;
import com.shekhovtsov.library.exception.AuthorNotFoundException;
import com.shekhovtsov.library.exception.BookNotFoundException;
import com.shekhovtsov.library.exception.GenreNotFoundException;
import com.shekhovtsov.library.model.Author;
import com.shekhovtsov.library.model.Book;
import com.shekhovtsov.library.model.Genre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService{


    private final BookDao bookDao;
    private final CommentDao commentDao;
    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final BookConverter bookConverter;

    @Override
    public List<BookDto> getAllBooks() {
        return bookDao.findAll().stream().map(bookConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<BookDto> deleteBookById(Long id) {
        commentDao.deleteByBook(new Book(id,null, null,null,null));
        bookDao.deleteById(id);
        return bookDao.findAll().stream().map(bookConverter::entityToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BookDto createBook(BookDto bookDto) throws AuthorNotFoundException, GenreNotFoundException {
        Author author = authorDao.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Genre genre = genreDao.findById(bookDto.getGenre()).orElseThrow(() -> new GenreNotFoundException(bookDto.getGenre()));
        Book book = new Book(null, bookDto.getName(), author, genre, null);
        return bookConverter.entityToDto(bookDao.save(book));
    }

    @Override
    @Transactional
    public BookDto updateBook(BookDto bookDto) throws AuthorNotFoundException, GenreNotFoundException {
        Author author = authorDao.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Genre genre = genreDao.findById(bookDto.getGenre()).orElseThrow(() -> new GenreNotFoundException(bookDto.getGenre()));
        Book book = new Book(bookDto.getId(), bookDto.getName(), author, genre, null);
        return bookConverter.entityToDto(bookDao.save(book));
    }


    @Override
    public BookDto getBookById(Long id) throws BookNotFoundException {
        return bookConverter.entityToDto(bookDao.findById(id).orElseThrow(() -> new BookNotFoundException(id)));
    }
}
