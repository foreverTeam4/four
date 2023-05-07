package com.hlkw.cafe.controller;

import com.hlkw.cafe.dto.AddCommentDto;
import com.hlkw.cafe.dto.SimpleDateCommentDto;
import com.hlkw.cafe.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies")
public class CommentController {

    private final CommentService commentService;
    private final CafeController cafeController;

    @GetMapping("/{boardNo}")
    public ResponseEntity<?> replyList(
            @PathVariable long boardNo
    ){
        log.info("/comment/{} : GET", boardNo);
        List<SimpleDateCommentDto> commentList = commentService.getBoardCommentList(boardNo);
        Map<SimpleDateCommentDto, String> commentMap = cafeController.getCommentMap(commentList);
        return ResponseEntity.ok().body(commentMap);
    }

    @PostMapping(value = "/new",
        consumes = "application/json",
        produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<?> addReply(
            @RequestBody AddCommentDto dto
    ){
        boolean flag = commentService.addComment(dto);
        if(flag) {
            return new ResponseEntity<>("success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
