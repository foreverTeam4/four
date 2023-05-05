package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    Board findOne(long boardNo);

    boolean modify(WriteDto dto);

    boolean remove(long boardNo);

     List<Board> search(String searchBy, String word);



    // 동우 내가 작성한글 list
    List<Board> myFindAll(Board myBoardOne);

    //id로 내가 쓴글 찾기
    Board myBoardOne(String id);



    //태근
    boolean save(Board board);


    String getCategoryByboardNo(long boardNo);

    void addViewCount(long boardNo);
}


