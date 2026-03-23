package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.repository.PostsRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private PostsRepostitory postsRepostitory;

    public Posts getDetail(Long id) {
        Posts post = postsRepostitory.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.updateViews(); // Increment view count
        return post;
    }
}