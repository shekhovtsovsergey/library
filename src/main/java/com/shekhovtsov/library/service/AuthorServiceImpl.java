package com.shekhovtsov.library.service;

import com.shekhovtsov.library.converter.AuthorConverter;
import com.shekhovtsov.library.dao.AuthorDao;
import com.shekhovtsov.library.dto.AuthorDto;
import com.shekhovtsov.library.exception.AuthorNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService{

    private final AuthorDao authorDao;
    private final AuthorConverter authorConverter;

    @Override
    public List<AuthorDto> getAllAuthore() throws AuthorNotFoundException {
        return authorDao.findAll().stream().map(authorConverter::entityToDto).collect(Collectors.toList());
    }

}
