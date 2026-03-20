package com.choi.springwebservice.web;

import com.choi.springwebservice.dto.comment.CommentResponseDto;
import com.choi.springwebservice.dto.comment.CommentSaveRequestDto;
import com.choi.springwebservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Long saveComment(@PathVariable Long postId, @RequestBody CommentSaveRequestDto requestDto) {
        return commentService.save(postId, requestDto);
    }

    @GetMapping
    public List<CommentResponseDto> getComments(@PathVariable Long postId) {
        return commentService.findByPostId(postId);
    }
}