package com.choi.springwebservice.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.dto.posts.PostsDeleteRequestDto;
import com.choi.springwebservice.dto.posts.PostsMainResponseDto;
import com.choi.springwebservice.dto.posts.PostsSaveRequestDto;
import com.choi.springwebservice.dto.posts.PostsUpdateRequestDto;
import com.choi.springwebservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsService postsService;
	private Environment env;
	
	@GetMapping("/hello")
	public String hello() {
		return"HelloWorld";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
	
	@PostMapping("/postsupdate")
	public void updatePosts(@RequestBody PostsUpdateRequestDto dto) {
		postsService.update(dto);
	}
	
	@PostMapping("/postsdelete")
	public void updatePosts(@RequestBody PostsDeleteRequestDto dto) {
		postsService.delete(dto);
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return Arrays.stream(env.getActiveProfiles())
					.findAny()
					.orElse("");
	}
	
	@GetMapping("/board/board_list_page")
	public Page<Posts> board_list_page(@PageableDefault Pageable pageable) throws IOException {
		Page<Posts> boardList = postsService.getList(pageable);
		
//		JSONPObject jsonobj = new JSONPObject("data", boardList);		
		
		return boardList;
		
	}
}
