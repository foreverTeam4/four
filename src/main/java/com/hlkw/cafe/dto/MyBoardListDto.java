package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Board;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EqualsAndHashCode

public class MyBoardListDto {

    private final long boardNo;
    private final String shortTitle;
    private final String id;
    private final String date;
    private final int viewCount;

    //마이페이지 내 보여질 게시글 목록
    public MyBoardListDto(Board board) {
        this.boardNo = board.getBoardNo();
        this.id=board.getId();
        this.shortTitle = makeShortTitle(board.getTitle());
        this.date = makeDate(board.getWrittenDate());
        this.viewCount = board.getViewCount();

    }

    private String makeDate(LocalDateTime writtenDate) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return pattern.format(writtenDate);

    }

    private String makeShortContent(String content ) {

        return sliceString(content,15);
    }


    // 동우 게시판 목록 제목 줄이기
    private String makeShortTitle(String realTitle) {
        return sliceString(realTitle,10);
    }


    // 동우 게시판 목록 제목 줄이기 글자 자르기
    private String sliceString(String realTitle, int titleLength) {
        return (realTitle.length() > titleLength)
                ? realTitle.substring(0,titleLength)+"..."
                :realTitle;
    }

}
