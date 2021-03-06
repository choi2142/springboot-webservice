package com.choi.springwebservice.dto.posts;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.choi.springwebservice.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
		private Long id;
	    private String title;
	    private String author;
	    private String modifiedDate;
	    private String content;

	    public PostsMainResponseDto(Posts entity) {
	        id = entity.getId();
	        title = entity.getTitle();
	        author = entity.getAuthor();
	        content= entity.getContent();
	        modifiedDate = toStringDateTime(entity.getModifiedDate());
	    }

	    private String toStringDateTime(LocalDateTime localDateTime){
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        return Optional.ofNullable(localDateTime)
	                .map(formatter::format)
	                .orElse("");
	    }

	    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
	        if(localDateTime == null){
	            return "";
	        }

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        return formatter.format(localDateTime);
	    }
}
