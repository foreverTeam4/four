package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.dto.BoardListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    Board findOne(int boardNo);

    boolean modify(WriteDto dto);
    // 내가 작성한글 list
    List<Board> myFindAll(Board board);

    boolean remove(int boardNo);

     List<Board> search(String searchBy, String word);
}
