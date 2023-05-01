package com.hlkw.cafe.controller;

import com.hlkw.cafe.dto.CafeListResponseDTO;
import com.hlkw.cafe.dto.writeDTO;
import com.hlkw.cafe.entity.Member;
import com.hlkw.cafe.service.BoardService;
import com.hlkw.cafe.service.CommentService;
import com.hlkw.cafe.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
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

    @GetMapping("/boardView")
    public String boardView(Model model) {
        List<CafeListResponseDTO> responseDTOS = boardService.getList();
        model.addAttribute("cfList", responseDTOS);
        return "cafe/boardView";
    }

    @GetMapping("/signUp")
    public boolean signUp(Member member){



        return true;
    }




}
