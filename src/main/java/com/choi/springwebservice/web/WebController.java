package com.choi.springwebservice.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.dto.posts.PostsMainResponseDto;
import com.choi.springwebservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	
	private PostsService postsService;
	
	@GetMapping("/")
	public String main(@PageableDefault Pageable pageable, Model model) {
		
		return "main";
		
	}
	
	@GetMapping("/board/board_list")
	public String board_list(@PageableDefault Pageable pageable, Model model) {
		Page<Posts> boardList = postsService.getList(pageable);
		model.addAttribute("posts",boardList);
		
		return "board_list";
		
	}
	
	@GetMapping("/board/board_detail")
	public String board_detail(Model model, @RequestParam("id") Long id ) {
		Posts boardDetail = postsService.getDetail(id);
		model.addAttribute("detail",boardDetail);
		
		return "board_detail";
		
	}
	
}
