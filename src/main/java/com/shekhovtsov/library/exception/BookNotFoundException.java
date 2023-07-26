package com.shekhovtsov.library.exception;

public class BookNotFoundException extends ObjectNotFoundException {

    public BookNotFoundException(Long bookId) {
        super(String.format("Book id %s not found", bookId));
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
