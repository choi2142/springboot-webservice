package com.choi.springwebservice.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace.NONE;

import com.choi.springwebservice.domain.Posts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class PostsRepositoryTest {

    @Autowired
    private PostsRepostitory postsRepostitory;

    @BeforeEach
    public void setUp() {
        // 초기 데이터 설정
        Posts post = Posts.builder()
                .title("Test Title")
                .content("Test Content")
                .build();
        postsRepostitory.save(post);
    }

    @Test
    public void testFindById() {
        // 게시글 조회 테스트
        Posts foundPost = postsRepostitory.findById(1L).orElse(null);
        assertThat(foundPost).isNotNull();
        assertThat(foundPost.getTitle()).isEqualTo("Test Title");
    }
}