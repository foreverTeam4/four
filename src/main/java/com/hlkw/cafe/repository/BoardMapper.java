package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.BoardListDTO;
import com.hlkw.cafe.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {


    // 내가 작성한글 list
    List<Board> myFindAll(Board board);


}
