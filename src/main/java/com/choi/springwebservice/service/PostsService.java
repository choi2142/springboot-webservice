package com.choi.springwebservice.service;

import com.choi.springwebservice.domain.Posts;
import com.choi.springwebservice.dto.SaveRequestDto;
import com.choi.springwebservice.dto.ResponseDto;
import com.choi.springwebservice.repository.PostsRepostitory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class PostsService {

    private final PostsRepostitory postsRepostitory;

    @Builder
    public PostsService(PostsRepostitory postsRepostitory) {
        this.postsRepostitory = postsRepostitory;
    }

    @Transactional
    public void savePost(SaveRequestDto saveRequestDto) {
        Posts post = new Posts(saveRequestDto.getTitle(), saveRequestDto.getContent());
        postsRepostitory.save(post);
    }

    public List<ResponseDto> getAllPosts() {
        return postsRepostitory.findAll().stream()
                .map(post -> new ResponseDto(post.getId(), post.getTitle(), post.getContent()))
                .collect(Collectors.toList());
    }
}