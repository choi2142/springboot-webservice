package com.choi.springwebservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.choi.springwebservice.domain.posts.Posts;
import com.choi.springwebservice.domain.posts.PostsRepostitory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepostitory postsRepository;
	
//	@After
//	public void cleanup() {
//		/* 이후 테스트 코드에 영향을 미치지 않게 롤백 */
//		postsRepository.deleteAll();
//	}
	
	@Test
	public void 게시글저장_불러오기() {
		//given
		postsRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("choi2142@naver.com")
				.build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 본문"));
	}
		
	@Test
    public void testIdOrderByPaging() {
		
		PageRequest req = new PageRequest(0,16);		
		
        Pageable pageable = req;
        Page<Posts> posts = postsRepository.findAll(pageable);
        posts.forEach(board -> System.out.println(board.getContent()));
                
    }
	
//	@Test
//	public void BaseTimeEntity_등록() {
//		//given
//		LocalDateTime now = LocalDateTime.now();
//		postsRepository.save(Posts.builder()
//				.title("테스트 게시글")
//				.content("테스트 본문")
//				.author("choi2142@naver.com")
//				.build());
//		
//		//when
//		List<Posts> postsList = postsRepository.findAll();
//		
//		//then
//		Posts posts = postsList.get(0);
//		assertTrue(posts.getCreatedDate().isAfter(now));
//		assertTrue(posts.getModifiedDate().isAfter(now));
//	}


}
