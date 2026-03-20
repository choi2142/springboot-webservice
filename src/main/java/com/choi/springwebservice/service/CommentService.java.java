package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.comment.Comment;
import com.choi.springwebservice.domain.comment.CommentRepository;
import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.domain.posts.PostsRepostitory;
import com.choi.springwebservice.dto.comment.CommentResponseDto;
import com.choi.springwebservice.dto.comment.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostsRepostitory postsRepository;

    @Transactional
    public Long save(Long postId, CommentSaveRequestDto requestDto) {
        Posts post = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID: " + postId));
        Comment comment = requestDto.toEntity(post);
        return commentRepository.save(comment).getId();
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId).stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }
}