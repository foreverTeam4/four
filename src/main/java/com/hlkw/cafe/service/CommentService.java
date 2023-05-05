package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.SimpleDateCommentDto;
import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.repository.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper mapper;

    //코멘트 리스트를 SimpleDateCommentDto로 변환하여 리스트 반환
    public List<SimpleDateCommentDto> getBoardCommentList (long boardNo) {
        return mapper.getBoardCommentList(boardNo).stream()
                .map(SimpleDateCommentDto::new)
                .collect(Collectors.toList());
    }

}