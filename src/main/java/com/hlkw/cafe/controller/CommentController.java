package com.hlkw.cafe.controller;

import com.hlkw.cafe.dto.AddCommentDto;
import com.hlkw.cafe.dto.AddLikeDto;
import com.hlkw.cafe.dto.SimpleDateCommentDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.service.BoardService;
import com.hlkw.cafe.service.CommentService;
import com.hlkw.cafe.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies")
public class CommentController {

    private final CommentService commentService;
    private final MemberService memberService;

    @GetMapping("/{boardNo}")
    public ResponseEntity<?> replyList(
            @PathVariable long boardNo
    ){
        List<List> cList = new ArrayList<>();
        log.info("/comment/{} : GET", boardNo);

        List<SimpleDateCommentDto> commentList = commentService.getBoardCommentList(boardNo);

        for (SimpleDateCommentDto dto : commentList) {
            String nickname = memberService.findNicknameByCommentNum(dto.getCommentNum());
            cList.add(List.of(dto, nickname));
        }
        return ResponseEntity.ok().body(cList);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> addReply(
            @Validated @RequestBody AddCommentDto dto
            , BindingResult result
    ) {
        log.info("코멘트 컨트롤러 " + dto.getContent());
        if (result.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(result.toString());
        }
        try {
            boolean flag = commentService.addComment(dto);
            List<SimpleDateCommentDto> commentList = commentService.getBoardCommentList(dto.getBoardNo());
            //성공시 클라이언트에 응답하기
            return ResponseEntity.ok().body(commentList);
        } catch (Exception e) {
            //문제 발생상황을 클라이언트에게 전달
            log.warn("500 Status code response! caused by {}", e.getMessage());
            return ResponseEntity.internalServerError()
                    .body(e.getMessage());
        }
    }

    @PostMapping(value = "/like")
    public void addLike(
            @Validated @RequestBody AddLikeDto dto

    ) {
        log.info("코멘트 컨트롤러 " + dto);

        try {
            boolean flag = commentService.addLike(dto);
        } catch (Exception e) {
            log.warn("500 Status code response! caused by {}", e.getMessage());
        }
    }
}
