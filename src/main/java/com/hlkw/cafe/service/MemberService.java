package com.hlkw.cafe.service;

import com.hlkw.cafe.entity.Member;
import com.hlkw.cafe.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberMapper memberRepository;

//    public Member login(String id, String pw){
//
//    }
    public boolean signUp(Member member){
        return true;
    }
}
