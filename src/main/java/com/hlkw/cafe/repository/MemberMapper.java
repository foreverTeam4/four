package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Level;
import com.hlkw.cafe.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void save(Member mbr);

    Member findOne(String id, String pw);
    Member findOneById(String id);

//동우 마이페이지 업데이트
    Member mypageUpdate(Member member);

    String findNicknameByCommentNum(long commentNum);

    boolean levelChange(Level level, String id);
}
