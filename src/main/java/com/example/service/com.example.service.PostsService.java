package com.example.service;

import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.repository.PostsRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private PostsRepostitory postsRepository;

    public Posts findPostById(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.updateViews();
        return post;
    }
}