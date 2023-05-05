package com.hlkw.cafe.service;

import com.hlkw.cafe.entity.Member;
import com.hlkw.cafe.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberMapper mapper;

    public Member login(String id, String pw) {
        return mapper.findOne(id, pw);
    }


    //동우 마이페이지 업데이트
    public Member mypageUpdate(Member member) {
        return mapper.mypageUpdate(new Member());

    }


}
