package com.hlkw.cafe.controller;

import com.hlkw.cafe.service.BoardService;
import com.hlkw.cafe.service.CommentService;
import com.hlkw.cafe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CafeController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final CommentService commentService;




}
