package com.example.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Posts {
    @Id
    private Long id;
    private String title;
    private String content;
    private long views = 0; // 초기값 설정

    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateViews() {
        this.views++; // 조회수 증가
    }
}