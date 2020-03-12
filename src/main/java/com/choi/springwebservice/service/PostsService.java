package com.choi.springwebservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.domain.posts.PostsRepostitory;
import com.choi.springwebservice.dto.posts.PostsDeleteRequestDto;
import com.choi.springwebservice.dto.posts.PostsMainResponseDto;
import com.choi.springwebservice.dto.posts.PostsSaveRequestDto;
import com.choi.springwebservice.dto.posts.PostsUpdateRequestDto;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepostitory postsRepository;
	
	  @Transactional
	    public Long save(PostsSaveRequestDto dto){
	        return postsRepository.save(dto.toEntity()).getId();
	    }
	  
	  @Transactional
	    public void update(PostsUpdateRequestDto dto){
		  	Posts posts = postsRepository.getOne(dto.getId());
		  	posts.ChangeTitle(dto.getContent());
		  	
	    }
	  
	  @Transactional
	    public void delete(PostsDeleteRequestDto dto){
		  postsRepository.delete(dto.toEntity());
		  	
	    }
	  	
	  @Transactional(readOnly = true)
	    public List<PostsMainResponseDto> findAllDesc() {
	        return postsRepository.findAllDesc()
	        		.map(PostsMainResponseDto::new)
	                .collect(Collectors.toList());
	    }
}
