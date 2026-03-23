package com.choi.springwebservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class Posts {
    private Long id;
    private String title;
    private String content;
}