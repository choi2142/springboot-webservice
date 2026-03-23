package com.choi.springwebservice.web;

import com.choi.springwebservice.service.PostsService;
import com.choi.springwebservice.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class WebRestController {
    private static final Logger logger = LoggerFactory.getLogger(WebRestController.class);
    private final PostsService postsService;

    // Other existing methods...

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getPostById(@PathVariable Long id) {
        Posts post = postsService.getDetail(id);
        logger.info("Post [{}] view updated. Total: [{}]", id, post.getViews());
        return ResponseEntity.ok(new ResponseDto(post));
    }
}