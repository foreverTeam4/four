package com.hlkw.cafe.service;


import com.hlkw.cafe.dto.*;
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

    public String getCategoryByboardNo(long boardNo){
        return boardMapper.getCategoryByboardNo(boardNo);
    };

    public SimpleDateBoardDto findOne(long boardNo){
        return new SimpleDateBoardDto(boardMapper.findOne(boardNo));
    }

    public SimpleDateBoardDto boardDetail(long boardNo) {
        boardMapper.addViewCount(boardNo);
        return new SimpleDateBoardDto(boardMapper.findOne(boardNo));
    }

    public boolean boardUpdate(WriteDto dto) {
        return boardMapper.modify(dto);
    }

    public void removeBoard(long boardNo) {
        boardMapper.remove(boardNo);
    }

    public List<SimpleDateBoardDto> boardSearch(String searchBy, String word) {
        return boardMapper.search(searchBy, word).stream()
                .map(SimpleDateBoardDto::new)
                .collect(toList());
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


    public boolean adminSave(BoardSaveDto dto) {
        if(dto.getTitle() != "" && dto.getContent() != ""){
            System.out.println("저장 성공");
            boardMapper.save(new Board(dto));
            return true;
        }
        return false;
    }
}
