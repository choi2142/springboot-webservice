package com.choi.springwebservice.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.service.PostsService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@AllArgsConstructor
@Slf4j
public class WebController {
	
	private PostsService postsService;
	
	@GetMapping("/")
	public String main(@PageableDefault Pageable pageable, Model model) {
		Page<Posts> boardList = postsService.getList(pageable);
		model.addAttribute("posts",boardList);
		
		log.info("총 element 수 : {}, 전체 page 수 : {}, 페이지에 표시할 element 수 : {}, 현재 페이지 index : {}, 현재 페이지의 element 수 : {}",
                boardList.getTotalElements(), boardList.getTotalPages(), boardList.getSize(),
                boardList.getNumber(), boardList.getNumberOfElements());
		return "main";
		
	}
	
}
