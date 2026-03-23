package com.choi.springwebservice.dto.comment;

import com.choi.springwebservice.domain.comment.Comment;
import com.choi.springwebservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentSaveRequestDto {

    private String content;
    private String author;

    @Builder
    public CommentSaveRequestDto(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public Comment toEntity(Posts post) {
        return Comment.builder()
                .post(post)
                .content(content)
                .author(author)
                .build();
    }
}