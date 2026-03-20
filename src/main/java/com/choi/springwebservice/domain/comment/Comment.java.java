package com.choi.springwebservice.domain.comment;

import javax.persistence.*;
import com.choi.springwebservice.domain.BaseTimeEntity;
import com.choi.springwebservice.domain.posts.Posts;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Posts post;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Builder
    public Comment(Posts post, String content, String author) {
        this.post = post;
        this.content = content;
        this.author = author;
    }
}