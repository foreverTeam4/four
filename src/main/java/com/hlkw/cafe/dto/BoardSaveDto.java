package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Category;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class BoardSaveDto {
    private String title;
    private String content;
    private String id;
    private Category category;
}
