package com.hlkw.cafe.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component @Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private long commentNum;
    private String id;
    private String content;
    private int likeIt;
    private LocalDateTime writtenDate;
    private long boardNo;
}
