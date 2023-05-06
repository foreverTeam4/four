package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.AddCommentDto;
import com.hlkw.cafe.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> getBoardCommentList(long boardNo);

    boolean addComment(AddCommentDto dto);
}
