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
    List<Board> myFindAll(Board board);

    // 동우 내가 작성한 댓글 list
    List<Comment> myCommentList(Comment comment);

    //태근
    boolean save(Board board);

    //태근 공지글 불러오기
    List<Board> findAdmin(int distinguish);

}


