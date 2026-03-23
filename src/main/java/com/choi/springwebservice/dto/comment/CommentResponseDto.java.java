package com.choi.springwebservice.dto.comment;

import com.choi.springwebservice.domain.comment.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private String author;
    private String createdDate;

    public CommentResponseDto(Comment entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.createdDate = entity.getCreatedDate().toString();
    }
}