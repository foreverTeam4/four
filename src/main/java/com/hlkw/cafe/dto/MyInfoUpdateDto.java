package com.hlkw.cafe.dto;

import com.hlkw.cafe.entity.Level;
import com.hlkw.cafe.entity.Member;
import lombok.*;
@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class MyInfoUpdateDto {
    private final String id;
    private final String pw;
    private final String addr;
    private final String phoneNum;
    private final String email;
    private final String nickname;

    public MyInfoUpdateDto(Member member) {
        this.id = member.getId();
        this.pw = member.getPw();
        this.addr = member.getAddr();
        this.phoneNum = member.getPhoneNum();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
    }

    public Member toEntity(){
        return Member.builder()
                .id(this.id)
                .pw(this.pw)
                .addr(this.addr)
                .phoneNum(this.phoneNum)
                .email(this.email)
                .nickname(this.nickname)
                .build();
    }


}
