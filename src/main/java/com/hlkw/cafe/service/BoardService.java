package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.writeDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BoardService {
    private final BoardMapper boardRepository;

    public boolean write(writeDto dto){
        return true;
    }
//    public Board boardView(int boardNo){
//
//
//    }
    public boolean boardUpdate(writeDto dto){
        return true;
    }
    public boolean removeBoard(int boardNo){
        return true;
    }




}
