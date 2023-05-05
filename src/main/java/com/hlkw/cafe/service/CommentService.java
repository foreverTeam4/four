package com.hlkw.cafe.service;

import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.repository.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper mapper;

    public List<Comment> getBoardCommentList (long boardNo) {
        return mapper.getBoardCommentList (boardNo);
    }
}