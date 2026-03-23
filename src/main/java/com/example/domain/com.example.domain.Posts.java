package com.example.domain;

public class Posts {
    private Long id;
    private String title;
    private String content;
    private long views = 0; // 초기값 설정

    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getViews() {
        return views;
    }

    public void updateViews() {
        this.views++; // 조회수 증가
    }
}