package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.CafeListResponseDTO;
import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;


    public List<CafeListResponseDTO> getList() {
        boardMapper.findAll();

        return boardMapper.findAll();
    }
}
