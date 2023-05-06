package com.hlkw.cafe.service;


import com.hlkw.cafe.dto.*;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public List<MyBoardListDto> myBoardListDto(String id){
        return boardMapper.myBoardList(id)
                .stream()
                .map(MyBoardListDto::new)
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

    public int todayBoardCount(String today){
        return boardMapper.todayCountBoard(today);
    }

    public long topBoardNo(){
        String distinguish = "distinguish";
        String adminDistinguish = "0";
        List<Board> list = boardMapper.search(distinguish, adminDistinguish);
        Optional<Board> maxComment = list.stream().max(Comparator.comparing(comment -> comment.getViewCount()));
        return maxComment.get().getBoardNo();
    }

    public Board findAdminById(String id){
        return boardMapper.findAdmin(id);
    }
}
