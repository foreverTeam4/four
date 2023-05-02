package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.CafeListResponseDTO;
import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    Board findOne(int boardNo);

    boolean modify(WriteDto dto);

    boolean remove(int boardNo);

     List<Board> search(String searchBy, String word);

    List<CafeListResponseDTO> findAll();
}
