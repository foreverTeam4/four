package com.hlkw.cafe.controller;

import com.hlkw.cafe.entity.Member;
import com.hlkw.cafe.service.BoardService;
import com.hlkw.cafe.service.CommentService;
import com.hlkw.cafe.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class CafeController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final CommentService commentService;

    @PostMapping()
    public String login(String id, String pw, Model model){
        Member mbr = memberService.login(id, pw);
        model.addAttribute("m", mbr);
        if(mbr == null){
            return "";
        } else {
            return "";
        }
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("test성공!");
        return "test";
    }
}
