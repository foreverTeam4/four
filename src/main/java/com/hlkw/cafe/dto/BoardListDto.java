package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Board;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
@EqualsAndHashCode

public class BoardListDto {

    private final long boardNo;
    private final String shortTitle;
    private final String shortContent;
    private final LocalDateTime date;
    private final int viewCount;

    //마이페이지 내 보여질 게시글 목록
    public BoardListDto(Board board){
        this.boardNo=board.getBoardNo();
        this.shortContent=board.getTitle();
        this.shortTitle=board.getTitle();
        this.date=board.getWrittenDate();
        this.viewCount= board.getViewCount();

    }



}

