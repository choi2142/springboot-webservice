package com.choi.springwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class WebRestController {

    private static final Logger logger = LoggerFactory.getLogger(WebRestController.class);

    @Autowired
    private PostsService postsService;

    @GetMapping("/{id}")
    public Posts getPost(@PathVariable Long id) {
        Posts post = postsService.getDetail(id);
        logger.info("Post [{}] view updated. Total: [{}]", id, post.getViews());
        return post;
    }
}