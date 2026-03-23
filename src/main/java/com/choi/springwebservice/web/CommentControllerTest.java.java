package com.choi.springwebservice.web;

import com.choi.springwebservice.dto.comment.CommentSaveRequestDto;
import com.choi.springwebservice.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CommentService commentService;

    private Long postId;

    @BeforeEach
    public void setup() {
        // Assuming a post with ID 1 exists for testing
        postId = 1L;
    }

    @Test
    public void saveComment() {
        // given
        CommentSaveRequestDto requestDto = CommentSaveRequestDto.builder()
                .content("Test comment")
                .author("test@domain.com")
                .build();

        String url = "/api/v1/posts/" + postId + "/comments";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
    }

    @Test
    public void getComments() {
        // given
        String url = "/api/v1/posts/" + postId + "/comments";

        // when
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, String.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).contains("Test comment");
    }
}