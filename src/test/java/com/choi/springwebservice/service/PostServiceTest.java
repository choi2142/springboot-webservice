package com.choi.springwebservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.domain.posts.PostsRepostitory;
import com.choi.springwebservice.dto.posts.PostsSaveRequestDto;
import com.choi.springwebservice.dto.posts.PostsUpdateRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepostitory postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void Dto데이터가_posts테이블에_저장된다() {
		//given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("choi2142@naver.com")
				.content("테스트")
				.title("테스트 타이틀")
				.build();
		
		//when
		postsService.save(dto);
		
		//then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
	
//	@Test
//	public void Dto데이터가_posts테이블에_수정된다() {
//		//given
//		
//		Long id = (long) 1;
//		
//		PostsUpdateRequestDto dto = PostsUpdateRequestDto.builder()
//				.id(id)
//				.author("choi2142@naver.com")
//				.content("테스트")
//				.title("테스트 타이틀")
//				.build();
//
//		//when
//		postsService.update(dto);
//		
//		//then
//		Posts posts = postsRepository.findAll().get(0);
//		assertThat(posts.getTitle()).isEqualTo("테스트 타이틀");
//	}
	

}
