package com.shekhovtsov.library.service;

import com.shekhovtsov.library.converter.CommentConverter;
import com.shekhovtsov.library.dao.BookDao;
import com.shekhovtsov.library.dto.CommentDto;
import com.shekhovtsov.library.exception.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService{

    private final BookDao bookDao;
    private final CommentConverter commentConverter;

    @Override
    @Transactional
    public List<CommentDto> getAllCommentsByBook(Long id) throws BookNotFoundException {
        return  bookDao.findById(id).orElseThrow(() -> new BookNotFoundException(id)).getComments().stream().map(commentConverter::entityToDto).collect(Collectors.toList());
    }
}
