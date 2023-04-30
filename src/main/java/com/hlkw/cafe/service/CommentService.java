package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.addCommentDto;
import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.repository.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CommentService {
    private final CommentMapper commentRepository;

    public boolean addComment(addCommentDto dto){
        return true;
    }
    public boolean modifyComment(addCommentDto dto){
        return true;
    }
    public boolean removeComment(Comment comment){
        return true;
    }


}
