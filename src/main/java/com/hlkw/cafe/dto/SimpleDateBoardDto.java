package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Category;
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
public class SimpleDateBoardDto {
    private long boardNo;
    private String title;
    private  String content;
    private  int viewCount;
    private  String id;
    private String writtenDate;
    private int distinguish;
    private Category category;

    public SimpleDateBoardDto(Board board){
        this.boardNo = board.getBoardNo();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.viewCount = board.getViewCount();
        this.id = board.getId();
        this.writtenDate = getSimpleDate(board.getWrittenDate());
        this.distinguish = board.getDistinguish();
        this.category = board.getCategory();
    }

    public String getSimpleDate(LocalDateTime date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return dtf.format(date);
    }
}
