package com.example.controller;

import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.service.PostsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    private final PostsService postsService;
    private static final Logger logger = LoggerFactory.getLogger(WebRestController.class);

    public WebRestController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/posts/{id}")
    public Posts getPostById(@PathVariable Long id) {
        Posts post = postsService.findPostById(id);
        logger.info("Post " + id + " view count updated to " + post.getViews());
        return post;
    }
}