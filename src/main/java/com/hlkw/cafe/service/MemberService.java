package com.hlkw.cafe.service;

import com.hlkw.cafe.entity.Level;
import com.hlkw.cafe.entity.Member;
import com.hlkw.cafe.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Member findOneById(String id) {
        return mapper.findOneById(id);
    }

    public String findNicknameByCommentNum(long commentNum) {
        return mapper.findNicknameByCommentNum(commentNum);
    }


    public boolean changeMemberLevel(Level level, String id){
        return mapper.levelChange(level, id);
    }
    public List<Member> findMemberList(){
        return mapper.findAll();
    }
}
