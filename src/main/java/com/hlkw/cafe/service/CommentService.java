package com.hlkw.cafe.service;

import com.hlkw.cafe.dto.MyCommentListDto;
import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.repository.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper mapper;

    public List<Comment> getBoardCommentList(long boardNo) {
        return mapper.getBoardCommentList(boardNo);
    }


    //동우 마이페이지 내 내가 작성한 댓글 list
    public List<MyCommentListDto> myCommentListDtoList(Comment comment){
        return mapper.myCommentList(comment)
                .stream()
                .map(MyCommentListDto::new)
                .collect(toList())
                ;
    }

    //동우 내가 쓴 댓글 id로 찾아오기
    public Comment myCommentOne(String id) {
       return mapper.MyCommentOne(id);
    }

}