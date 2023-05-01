package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.CafeListResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 전체 목록 조회
    List<CafeListResponseDTO> findAll();
}
