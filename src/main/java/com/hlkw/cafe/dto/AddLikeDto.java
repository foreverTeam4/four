package com.hlkw.cafe.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddLikeDto {
    private long commentNum;
}
