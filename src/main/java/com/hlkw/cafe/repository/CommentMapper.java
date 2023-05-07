package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.AddCommentDto;
import com.hlkw.cafe.dto.AddLikeDto;
import com.hlkw.cafe.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    //admin
    int todayCountComment(String today);


    List<Comment> getBoardCommentList(long boardNo);




    // 동우 내가 작성한 댓글 list
    List<Comment> myCommentList(String id);

    boolean addComment(AddCommentDto dto);

    boolean addLike(AddLikeDto dto);
}
