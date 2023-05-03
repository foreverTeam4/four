package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import com.hlkw.cafe.dto.BoardListDTO;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public final BoardMapper boardRepository;

    //마이페이지에 보여질 내가 쓴글 전체 list 목록(줄인 제목으로)
    public List<BoardListDTO> myPageTitleList(Board board){
    public Board boardDetail(int boardNo) {
        return boardMapper.findOne(boardNo);
    }

    public boolean boardUpdate(WriteDto dto) {
        return boardMapper.modify(dto);
    }
        return boardRepository.myFindAll(board)
                .stream()
                .map(BoardListDTO::new)
                .collect(toList())
                ;

    }

    public void removeBoard(int boardNo) {
        boardMapper.remove(boardNo);
    }

    public List<Board> boardSearch(String searchBy, String word) {
        return boardMapper.search(searchBy, word);
    }
}
