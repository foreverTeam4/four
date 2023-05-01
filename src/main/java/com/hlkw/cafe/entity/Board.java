package com.hlkw.cafe.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component @Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Board {
    private long boardNo;
    private String title;
    private  String content;
    private  int viewCount;
    private  Member member;
    private Comment comment;
    private LocalDateTime writtenDate;

}
