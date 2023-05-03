package com.hlkw.cafe.dto;


import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode

public class MyCommentListDto {
    private final int commentNo;
    private final String content;
    private final String commentId;
    private final LocalDateTime localDateTime;


    public MyCommentListDto(Comment comment){
        this.commentNo = (int) comment.getCommentNum();
        this.content = comment.getContent();
        this.commentId = comment.getId();
        this.localDateTime = LocalDateTime.now();

    }
}