package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {

    List<Comment> getBoardCommentList(long boardNo);
}
