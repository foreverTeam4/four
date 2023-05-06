package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Level;
import com.hlkw.cafe.entity.Member;
import lombok.*;
@Getter
@ToString
@EqualsAndHashCode
public class MyInfoUpdateDto {
    private final String pw;
    private final String addr;
    private final String phoneNum;
    private final String email;
    private final String nickname;

    public MyInfoUpdateDto(Member member) {
        this.pw = member.getPw();
        this.addr = member.getAddr();
        this.phoneNum = member.getPhoneNum();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
    }

}
