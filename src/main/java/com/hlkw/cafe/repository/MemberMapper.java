package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Level;
import com.hlkw.cafe.dto.MyInfoUpdateDto;
import com.hlkw.cafe.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    void save(Member mbr);

    Member findOne(String id, String pw);
    Member findOneById(String id);

//동우 마이페이지 업데이트
    boolean mypageUpdate(Member member);

    String findNicknameByCommentNum(long commentNum);

    boolean levelChange(Level level, String id);

    //전체 멤버 출력
    List<Member> findAll();
}
