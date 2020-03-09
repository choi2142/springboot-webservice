package com.choi.springwebservice.dto.posts;

import com.choi.springwebservice.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	
	@Builder
	public PostsUpdateRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
		
	}
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
