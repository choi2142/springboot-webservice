package com.choi.springwebservice.web;

import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.choi.springwebservice.dto.posts.PostsMainResponseDto;
import com.choi.springwebservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	
	private PostsService postsService;
	
	@GetMapping("/")
	public String main(@PageableDefault Model model) {
//		model.addAttribute("posts",postsService.findAllDesc());
		model.addAttribute("posts",postsService.findByIdGreaterThanOrderByIdDesc());
		return "main";
		
	}
	
	@GetMapping("/scrollDown")
	public String pageScroll(@RequestBody PostsMainResponseDto dto , @PageableDefault Model model) {
		//model.addAttribute("posts",postsService.findAllDesc());
		model.addAttribute("posts",postsService.findByIdGreaterThanOrderByIdDesc(dto));
		return "pageScroll";
		
	}

}
