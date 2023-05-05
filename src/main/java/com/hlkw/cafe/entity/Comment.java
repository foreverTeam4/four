package com.hlkw.cafe.entity;

import com.hlkw.cafe.service.MemberService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlkw.cafe.repository.MemberMapper;

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
