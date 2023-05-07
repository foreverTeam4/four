package com.hlkw.cafe.entity;

import com.hlkw.cafe.dto.BoardSaveDto;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    private long boardNo;
    private String title;
    private String content;
    private int viewCount;
    private String id;
    private LocalDateTime writtenDate;
    private int distinguish;
    private Category category;

    public Board(BoardSaveDto dto) {
        this.title = dto.getTitle();
        this.content= dto.getContent();
        this.id = dto.getId();
//        this.category = Category.HORROR;
        this.category = dto.getCategory();
    }


}
