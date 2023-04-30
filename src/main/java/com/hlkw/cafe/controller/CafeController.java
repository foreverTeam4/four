package com.hlkw.cafe.controller;

import com.hlkw.cafe.dto.addCommentDto;
import com.hlkw.cafe.dto.writeDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Comment;
import com.hlkw.cafe.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class CafeController {
    Service boardService;

//    public Member login(String id, String pw){
//
//    }
    public void signUpPage(){

    }
    public boolean signUp(Member member){
    return true;
    }
    public boolean write(writeDto dto){
        return true;
    };
//    public Board boardView(int boardNo){
//
//    }
    public boolean boardUpdate(writeDto dto){
        return true;
    }
    public boolean removeBoard(int boardNo){
        return true;
    }
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
