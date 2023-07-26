package com.shekhovtsov.library.converter;


import com.shekhovtsov.library.dto.CommentDto;
import com.shekhovtsov.library.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentConverter {

    public CommentDto entityToDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getBook().getName(),comment.getAuthorName(), comment.getComment());
    }

}
