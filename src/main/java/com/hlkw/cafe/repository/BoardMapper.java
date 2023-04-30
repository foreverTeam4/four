package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.writeDto;
import com.hlkw.cafe.entity.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    public boolean write(writeDto dto);

    public Board findOne(int boardNo);
    public boolean remove(int boardNo);



}
