package com.hlkw.cafe.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class WriteDto {
    private long boardNo;
    private String title;
    private String content;
}
