package com.hlkw.cafe.controller;

import com.hlkw.cafe.dto.BoardSaveDto;
import com.hlkw.cafe.dto.MyBoardListDto;
import com.hlkw.cafe.dto.MyCommentListDto;
import com.hlkw.cafe.dto.SimpleDateCommentDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String loginPage() {
        return "/login";
    }

    @PostMapping("/main")
    public String login(String id, String pw, Model model) {
        Member mbr = memberService.login(id, pw);
        model.addAttribute("m", mbr);
        if (mbr == null) {
            return "/loginfail";
        } else if (mbr.getId().equals("admin")) {
            return "redirect:/dust/admin";
        } else {
            return "/main"; //석빈이 메인 페이지 jsp
        }

    }

    //게시글 디테일 조회
    //게시글 번호로 Board 객체 반환받아 jsp에 전달
    @GetMapping("/detail")
    public String boardDetail(@ModelAttribute("mbr") Member mbr, long boardNo, Model model) {
        Map<Board, Member> boardWithWriter = getBoardWithWriter(boardNo);
        Map<SimpleDateCommentDto, String> commentMap = getCommentWithNickname(boardNo);

        model.addAttribute("board", boardWithWriter);
        model.addAttribute("comments", commentMap);
        return "detail";
    }

    private Map<Board, Member> getBoardWithWriter(long boardNo) {
        Map<Board, Member> boardWithWriter = new HashMap<>();

        Board board = boardService.boardDetail(boardNo);
        Member boardWriter = memberService.findOneById(board.getId());
        boardWithWriter.put(board, boardWriter);

        return boardWithWriter;
    }

    //게시글 번호로 코멘트 객체를 얻고
    // -> 코멘트 객체로 코멘트 작성자 닉네임 겟
    // -> <코멘트, 닉네임> 맵 반환
    private Map<SimpleDateCommentDto, String> getCommentWithNickname(long boardNo) {
        List<SimpleDateCommentDto> commentList = commentService.getBoardCommentList(boardNo);
        return getCommentMap(commentList);
    }

    //코멘트 리스트를 코멘트 작성자와 매핑하여 맵으로 반환
    private Map<SimpleDateCommentDto, String> getCommentMap(List<SimpleDateCommentDto> commentList) {
        Map<SimpleDateCommentDto, String> commentMap = new HashMap<>();

        for (SimpleDateCommentDto comment : commentList) {
            String nickname = memberService.findNicknameByCommentNum(comment.getCommentNum());
            commentMap.put(comment, nickname);
        }
        return commentMap;
    }

    //Map<<코멘트객체, 닉네임>, 카테고리> 반환 -> 메인 & 관리자용메인
    private Map<Map, String> getCommentWithCategory(List<SimpleDateCommentDto> commentList){
        Map<Map, String> commentWithCategory = new HashMap<>();
        Map<SimpleDateCommentDto, String> commentMap = getCommentMap(commentList);

        for (SimpleDateCommentDto comment : commentMap.keySet()) {
            String category = boardService.getCategoryByboardNo(comment.getBoardNo());
            commentWithCategory.put(commentMap, category);
        }
        return commentWithCategory;
    }



    //게시글 상세페이지에서 수정하기 페이지로 연결
    @GetMapping("modify")
    public String boardUpdate(Member mbr, long boardNo, Model model) {
        model.addAttribute("mbr", mbr);
        model.addAttribute("board", boardService.findOne(boardNo));
        return "modify"; //세진 수정페이지 jsp
    }

    //게시글 수정내역 전달
    //게시글 번호, 제목, 내용 전달받아서 디비 업뎃 후 리다이렉트 처리
    @GetMapping("/modified")
    public String boardUpdated(WriteDto dto) {
        boardService.boardUpdate(dto);
        return "redirect:/dust/detail";
    }

    //게시글 삭제
    @GetMapping("/remove")
    public String removeBoard(long boardNo) {
        boardService.removeBoard(boardNo);
        return "redirect:/main"; //석빈이 메인 페이지 jsp
    }

    //게시글 검색
    @GetMapping
    public String boardSearch(
            @RequestParam(defaultValue = "content") String searchBy
            , String word, Model model
    ) {
        List<Board> filteresList = boardService.boardSearch(searchBy, word);
        model.addAttribute("list", filteresList);
        return "searchList"; //세진 검색된 글 리스트 jsp -> 석빈이 메인 사용
    }

    //관리자 메인 페이지
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<SimpleDateCommentDto> commentList = commentService.getBoardCommentList(0);

        //0을 입력하면 관리자 공지글 List, 1을 입력하면 멤버의 공지글 List
        String distinguish = "distinguish";
        String adminDistinguish = "0";
        String memberDistinguish = "1";
        List<Board> adminList = boardService.boardSearch(distinguish, adminDistinguish);
        List<Board> memberList = boardService.boardSearch(distinguish, memberDistinguish);
        model.addAttribute("admin", adminList);
        model.addAttribute("member", memberList);
//        System.out.println("adminList = " + adminList);
//        System.out.println("memberList = " + memberList);
        return "admin";
    }

    //관리자 공지글 페이지로 이동
    @GetMapping("/notice")
    public String notice() {
        return "notice";
    }

    //관리자 공지글 작성
    @PostMapping("/notice")
    public String noticeWrite(BoardSaveDto dto) {
        System.out.println("/dust/notice POST맵핑 발생");
        System.out.println("dto = " + dto);
        boolean flag = boardService.adminSave(dto);
        if (flag) {
            System.out.println("저장성공");
            return "redirect:/dust/admin";
        }else {
            System.out.println("저장실패");
            return "redirect:/dust/notice?result=false";
        }
        //post로 받은 값을 저장
//        boardService.sa

    }


    //마이페이지 목록
    @GetMapping("/mypage")
    public String mypage(Model model, Board board){


        return "mypage";
    }

    // 동우 마이페이지 내 내가 작성한글 목록 조회
    @GetMapping("/myboardList")
    public String myboardlist(Model model, Board myBoardOne) {
        List<MyBoardListDto> myPageTitleList = boardService.myPageTitleList(myBoardOne);
        model.addAttribute("myPageList", myPageTitleList);
        return "";
    }

    //동우 아이디로 내가쓴 글 찾기
    public Board myBoardOne(Model model,String id){
        return boardService.myBoardOne(id);

    }
    //동우 아이디로 내가 쓴 댓글 찾기
    public Comment myCommentOne(Model model,String id){
        return commentService.myCommentOne(id);


    }



    //동우 마이페이지 내 내가 작성한 댓글 조회
    @GetMapping("/myCommentList")
    public String mycommentlist(Model model, Comment comment) {
        List<MyCommentListDto> mycommentlist = commentService.myCommentListDtoList(comment);
        model.addAttribute("myCommentList", mycommentlist);
        return "";
    }



    //동우 마이페이지 내 내정보 수정
    @GetMapping("/mypageUpdate")
    public String mypageUpdate(Member member) {
        memberService.mypageUpdate(member);

        return "";
    }
}