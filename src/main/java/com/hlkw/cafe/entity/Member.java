package com.hlkw.cafe.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Component @Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private String id;
    private String pw;
    private String addr;
    private int age;
    private String phoneNum;
    private Gender gender;
    private String email;
    private String nickname;
    private Level level;
    private Board board;
}
