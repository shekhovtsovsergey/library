package com.shekhovtsov.library.controller;

import com.shekhovtsov.library.dto.AuthorDto;
import com.shekhovtsov.library.exception.AuthorNotFoundException;
import com.shekhovtsov.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping("/api/v1/author")
    public List<AuthorDto> getAuthoreList() throws AuthorNotFoundException {
        return authorService.getAllAuthore();
    }

    @ExceptionHandler({AuthorNotFoundException.class})
    private ResponseEntity<String> handleNotFound(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
