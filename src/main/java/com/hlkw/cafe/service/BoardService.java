package com.hlkw.cafe.service;


import com.hlkw.cafe.dto.BoardListDto;
import com.hlkw.cafe.dto.MyBoardListDto;
import com.hlkw.cafe.dto.MyCommentListDto;
import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public Board findOne(long boardNo){
        return boardMapper.findOne(boardNo);
    }
    public Board boardDetail(long boardNo) {
        return boardMapper.findOne(boardNo);
    }

    public boolean boardUpdate(WriteDto dto) {
        return boardMapper.modify(dto);
    }

    public void removeBoard(long boardNo) {
        boardMapper.remove(boardNo);
    }

    public List<Board> boardSearch(String searchBy, String word) {
        return boardMapper.search(searchBy, word);
    }

    // 동우 마이페이지 내 내가 작성한글 list
    public List<MyBoardListDto> myPageTitleList(Board board){

        return boardMapper.myFindAll(board)
                .stream()
                .map(MyBoardListDto::new)
                .collect(toList())
                ;

    }

    //동우 마이페이지 내 내가 작성한 댓글 list
    public List<MyCommentListDto> myCommentListDtoList(Comment comment){
        return boardMapper.myCommentList(comment)
                .stream()
                .map(MyCommentListDto::new)
                .collect(toList())
                ;
    }




}
