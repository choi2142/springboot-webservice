package com.choi.springwebservice.web;

import com.choi.springwebservice.dto.ResponseDto;
import com.choi.springwebservice.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class WebRestController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<ResponseDto> getComments() {
        // Logic to get comments
        return ResponseEntity.ok(new ResponseDto());
    }

    @PostMapping
    public ResponseEntity<ResponseDto> saveComment(@RequestBody SaveRequestDto saveRequestDto) {
        // Logic to save comment
        return ResponseEntity.ok(new ResponseDto());
    }
}