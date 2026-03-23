package com.choi.springwebservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Posts {
    @Id
    private Long id;
    private String title;
    private String content;
    private long views = 0;

    @Builder
    public Posts(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void updateViews() {
        this.views++;
    }
}