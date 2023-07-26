package com.shekhovtsov.library.service;

import com.shekhovtsov.library.dto.CommentDto;
import com.shekhovtsov.library.exception.BookNotFoundException;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllCommentsByBook(Long id) throws BookNotFoundException;

}
