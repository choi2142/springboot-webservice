package com.choi.springwebservice.web;

import com.choi.springwebservice.service.PostsService;
import com.choi.springwebservice.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WebRestController {
    private final PostsService postsService;
    private static final Logger logger = LoggerFactory.getLogger(WebRestController.class);

    public WebRestController(PostsService postsService) {
        this.postsService = postsService;
    }

    public ResponseEntity<ResponseDto> getPostById(@PathVariable Long id) {
        ResponseDto responseDto = postsService.getDetail(id);
        logger.info("Post [{}] view updated. Total: [{}]", id, responseDto.getViews());
        return ResponseEntity.ok(responseDto);
    }
}