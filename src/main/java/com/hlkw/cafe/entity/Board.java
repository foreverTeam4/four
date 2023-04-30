package com.hlkw.cafe.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Board {
    private long boardNo;
    private String title;
    private  String content;
    private  int viewCount;
    private  Member member;
    private Comment comment;
    private LocalDateTime writtenDate;

}
