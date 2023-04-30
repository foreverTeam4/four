package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public Member findOne(String id, String pw);

    public boolean save(Member member);
}
