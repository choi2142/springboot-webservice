package com.choi.springwebservice.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.choi.springwebservice.dto.posts.PostsDeleteRequestDto;
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
}
