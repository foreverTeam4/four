package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Comment;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleDateCommentDto {
    private long commentNum;
    private String id;
    private String content;
    private int likeIt;
    private String writtenDate;
    private long boardNo;

    public SimpleDateCommentDto (Comment comment){
        this.commentNum = comment.getCommentNum();
        this.id = comment.getId();
        this.content = comment.getContent();
        this.likeIt = comment.getLikeIt();
        this.boardNo = comment.getBoardNo();
        this.writtenDate = getSimpleDate(comment.getWrittenDate());
    }

    public String getSimpleDate(LocalDateTime date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return dtf.format(date);
    }
}