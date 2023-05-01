package com.hlkw.cafe.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component @Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Comment {
    private Member member;
    private String content;
    private int like;
    private int dislike;
}
