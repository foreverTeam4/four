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
public class CafeListResponseDTO {

    private final long boardNo;
    private final String shortTitle; // 5자 이상 줄임
    private final String date; // 날짜패턴 yyyy-MM-dd HH:mm
    private final int viewCount;

    public CafeListResponseDTO(Board board) {
        this.boardNo = (long) board.getBoardNo();
        this.shortTitle = makeShortTitle(board.getTitle());
        this.date = makePrettierDateString(board.getWrittenDate());
        this.viewCount = board.getViewCount();
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

    private String makeShortTitle(String originTitle) {
        return sliceString(originTitle, 20);
    }

    private static String sliceString(String targetString, int wishLength) {
        return (targetString.length() > wishLength)
                ? targetString.substring(0, wishLength) + "..."
                : targetString
                ;
    }

}
