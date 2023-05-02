package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.BoardListDTO;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BoardService {

    public final BoardMapper boardRepository;

    //마이페이지에 보여질 내가 쓴글 전체 list 목록(줄인 제목으로)
    public List<BoardListDTO> myPageTitleList(Board board){

        return boardRepository.myFindAll(board)
                .stream()
                .map(BoardListDTO::new)
                .collect(toList())
                ;

    }

}
