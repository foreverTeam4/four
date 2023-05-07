package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Category;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class WriteDto {
    private Category category;
    private long boardNo;
    private String title;
    private String content;
}
