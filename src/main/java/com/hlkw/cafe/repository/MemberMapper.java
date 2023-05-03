package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member findOne(String id, String pw);

}
