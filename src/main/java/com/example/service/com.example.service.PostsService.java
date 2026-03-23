package com.example.service;

import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.repository.PostsRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Autowired
    private PostsRepostitory postsRepository;

    public Posts getDetail(Long id) {
        Posts post = postsRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.updateViews();
        postsRepository.save(post); // 변경된 Posts 객체를 저장
        return post;
    }
}