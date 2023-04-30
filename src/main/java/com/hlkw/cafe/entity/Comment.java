package com.hlkw.cafe.entity;

import org.springframework.stereotype.Component;

@Component
public class Comment {
    private Member member;
    private String content;
    private int like;
    private int dislike;
}
