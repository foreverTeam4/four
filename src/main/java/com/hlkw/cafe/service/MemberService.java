package com.hlkw.cafe.service;

import com.hlkw.cafe.entity.Member;
import com.hlkw.cafe.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;

    public Member login(String id, String pw) {
        return mapper.findOne(id, pw);
    }
}
