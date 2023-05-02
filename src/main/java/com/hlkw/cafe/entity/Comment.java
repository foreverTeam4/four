package com.hlkw.cafe.entity;

import lombok.*;
import org.springframework.stereotype.Component;

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
    private long boardNo;
}
