package com.hlkw.cafe.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCommentDto {
    private String id;
    private String content;
    private long boardNo;
}
