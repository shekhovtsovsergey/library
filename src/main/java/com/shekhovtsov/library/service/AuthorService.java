package com.shekhovtsov.library.service;

import com.shekhovtsov.library.dto.AuthorDto;
import com.shekhovtsov.library.exception.AuthorNotFoundException;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthore() throws AuthorNotFoundException;

}
