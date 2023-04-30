package com.hlkw.cafe.entity;

import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Component
public class Member {
    private String id;
    private String pw;
    private String addr;
    private int age;
    private String phoneNum;
    private Gender gender;
    private String email;
    private String nickName;
    private Level level;
}
