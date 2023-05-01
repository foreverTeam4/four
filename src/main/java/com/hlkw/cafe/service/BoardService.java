package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;


    public Board boardDetail(int boardNo) {
        return boardMapper.findOne(boardNo);
    }

    public boolean boardUpdate(WriteDto dto) {
        return boardMapper.modify(dto);
    }

    public void removeBoard(int boardNo) {
        boardMapper.remove(boardNo);
    }

    public List<Board> boardSearch(String searchBy, String word) {
        return boardMapper.search(searchBy, word);
    }
}
