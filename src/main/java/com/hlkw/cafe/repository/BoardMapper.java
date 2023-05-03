package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    Board findOne(long boardNo);

    boolean modify(WriteDto dto);

    boolean remove(long boardNo);

     List<Board> search(String searchBy, String word);
}
