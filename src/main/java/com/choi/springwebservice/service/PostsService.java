package com.choi.springwebservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.domain.posts.PostsRepostitory;
import com.choi.springwebservice.dto.posts.PostsDeleteRequestDto;
import com.choi.springwebservice.dto.posts.PostsMainResponseDto;
import com.choi.springwebservice.dto.posts.PostsSaveRequestDto;
import com.choi.springwebservice.dto.posts.PostsUpdateRequestDto;

import lombok.AllArgsConstructor;

import java.util.Collection;
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
		  	posts.ChangeContent(dto.getContent());
		  	
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
	  
	  @Transactional(readOnly = true)
	    public Page<Posts> getList(Pageable pageable) {
		  	int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
	     
		  	PageRequest req = new PageRequest(page,10, new Sort(Sort.Direction.DESC, "id"));		
			
	        pageable = req;
	        
	        return postsRepository.findAll(pageable);
	  }
	  	  
	  @Transactional(readOnly = true)
	    public Posts getDetail(Long id) {
		  	
	        return postsRepository.findDetail(id);
	  }
	  
}
