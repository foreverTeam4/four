package com.hlkw.cafe.controller;

import com.hlkw.cafe.dto.MyBoardListDto;
import com.hlkw.cafe.dto.MyCommentListDto;
import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Comment;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/dust")
public class CafeController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final CommentService commentService;

    /*
        param1 : id 아이디
        param2 : pw 패스워드
        param3 : Model
        - id, pw 일치하는 멤버객체 반환받기
        - 멤벅개체 아이디가 admin이라면 관리자 메인으로 이동
        - 멤버객체가 일반 회원이라면 메인화면으로 이동
        - 멤버객체가 null이라면 로그인 페이지로 이동
     */

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @PostMapping("/main")
    public String login(String id, String pw, Model model) {
        Member mbr = memberService.login(id, pw);
        model.addAttribute("m", mbr);
        if (mbr == null) {
            return "/loginfail"; //
        } else if (mbr.getId().equals("admin")) {
            return "/admin_main"; // 태근이 관리자 메인 jsp
        } else {
            return "/main"; //석빈이 메인 페이지 jsp
        }

    }

    //게시글 디테일 조회
    //게시글 번호로 Board 객체 반환받아 jsp에 전달
    @GetMapping("/detail")
    public String boardDetail(int boardNo, Model model) {
        Board board = boardService.boardDetail(boardNo);
        List<Comment> commentList = commentService.getBoardCommentList (boardNo);
        model.addAttribute("b", board);
        model.addAttribute("c", commentList);
        return "detail"; //세진 상세페이지 jsp
    }

    //게시글 상세페이지에서 수정하기 페이지로 연결
    @GetMapping("modify")
    public String boardUpdate(int boardNo){
        return "modify"; //세진 수정페이지 jsp
    }
    //게시글 수정내역 전달
    //게시글 번호, 제목, 내용 전달받아서 디비 업뎃 후 리다이렉트 처리
    @GetMapping("/modified")
    public String boardUpdated(WriteDto dto){
        boardService.boardUpdate(dto);
        return "redirect:/dust/detail";
    }

    //게시글 삭제
    @GetMapping("/remove")
    public String removeBoard(int boardNo){
        boardService.removeBoard(boardNo);
        return "redirect:/main"; //석빈이 메인 페이지 jsp
    }

    //게시글 검색
    @GetMapping
    public String boardSearch(
            @RequestParam(defaultValue = "content") String searchBy
            , String word, Model model
    ){
        List<Board> filteresList = boardService.boardSearch(searchBy, word);
        model.addAttribute("list", filteresList);
        return "searchList"; //세진 검색된 글 리스트 jsp
    }

    @GetMapping("/admin")
    public String adminList(){
        commentService.getBoardCommentList(0);
        return "admin";
    }

    // 동우 마이페이지 내 내가 작성한글 목록 조회
    @GetMapping("/myboardList")
    public String myboardlist(Model model, Board board) {
        List<MyBoardListDto> myPageTitleList = boardService.myPageTitleList(board);
        model.addAttribute("myPageList", myPageTitleList);
        return "";
    }

    //동우 마이페이지 내 내가 작성한 댓글 조회
    @GetMapping("/myCommentList")
    public String mycommentlist(Model model, Comment comment) {
        List<MyCommentListDto> mycommentlist = boardService.myCommentListDtoList(comment);
        model.addAttribute("myCommentList", mycommentlist);
        return "";
    }



    //동우 마이페이지 내 내정보 수정
    @GetMapping("/mypageUpdate")
    public String mypageUpdate(Member member){
        memberService.mypageUpdate(member);

        return "";
    }
}