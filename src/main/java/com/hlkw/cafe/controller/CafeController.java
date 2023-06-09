package com.hlkw.cafe.controller;

import com.hlkw.cafe.dto.*;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Level;
import com.hlkw.cafe.entity.Member;
import com.hlkw.cafe.service.BoardService;
import com.hlkw.cafe.service.CommentService;
import com.hlkw.cafe.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
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

    @PostMapping("loading")
    public String loading(String id, String pw, Model model){
        model.addAttribute("id",id);
        model.addAttribute("pw",pw);

        return "loading";
    }

    @PostMapping("/main")
    public String login(String id, String pw, Model model) {
        Member mbr = memberService.login(id, pw);
        model.addAttribute("m", mbr);
        if (mbr == null) {
            System.out.println("실패");
            return "/loginfail";
        } else if (mbr.getId().equals("admin")) {
            return "redirect:/dust/admin?&id=" + mbr.getId();
        } else {
            return "/test"; //석빈이 메인 페이지 jsp
        }
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("member", new Member());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("member") Member member) {
        memberService.save(member);
        return "redirect:/main";
    }




    //게시글 디테일 조회
    //게시글 번호로 Board 객체 반환받아 jsp에 전달
    @GetMapping("/detail")
    public String boardDetail(@ModelAttribute("mbr") Member mbr, long boardNo, Model model) {
        Map<SimpleDateBoardDto, Member> boardWithWriter = getBoardWithWriter(boardNo);
//        List<List> commentList = getCommentWithNickname(boardNo);

        model.addAttribute("board", boardWithWriter);
//        model.addAttribute("comments", commentList);
        return "/detail";
    }

    private Map<SimpleDateBoardDto, Member> getBoardWithWriter(long boardNo) {
        Map<SimpleDateBoardDto, Member> boardWithWriter = new HashMap<>();

        SimpleDateBoardDto board = boardService.boardDetail(boardNo);
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
    public Map<SimpleDateCommentDto, String> getCommentMap(List<SimpleDateCommentDto> commentList) {
        Map<SimpleDateCommentDto, String> commentMap = new HashMap<>();

        for (SimpleDateCommentDto comment : commentList) {
            String nickname = memberService.findNicknameByCommentNum(comment.getCommentNum());
            commentMap.put(comment, nickname);
        }
        return commentMap;
    }


    //게시글 상세페이지에서 수정하기 페이지로 연결
    @GetMapping("modify")
    public String boardUpdate(Member mbr, long boardNo, Model model) {
        model.addAttribute("mbr", mbr);
        model.addAttribute("b", boardService.findOne(boardNo));
        return "boardModify"; //세진 수정페이지 jsp
    }

    //게시글 수정내역 전달
    //게시글 번호, 제목, 내용 전달받아서 디비 업뎃 후 리다이렉트 처리
    @PostMapping ("/modified")
    public String boardUpdated(WriteDto dto, String id, Model model) {
        boardService.boardUpdate(dto);
        log.info(dto.getTitle());
//        log.info("/modified 매핑까지 이동");
        model.addAttribute("id", id);
        return "redirect:/dust/detail?boardNo=" + dto.getBoardNo();
    }

    //게시글 삭제
    @GetMapping("/remove")
    public String removeBoard(long boardNo) {
        commentService.removeComment(boardNo);
        boardService.removeBoard(boardNo);
        return "redirect:/main"; //석빈이 메인 페이지 jsp
    }

    //게시글 검색
    @GetMapping
    public String boardSearch(
            @RequestParam(defaultValue = "content") String searchBy
            , String word, Model model
    ) {
        List<SimpleDateBoardDto> filteresList = boardService.boardSearch(searchBy, word);
        model.addAttribute("list", filteresList);
        return "searchList"; //세진 검색된 글 리스트 jsp -> 석빈이 메인 사용
    }

    //관리자 메인 페이지
    @GetMapping("/admin")
    public String adminList(String id, Model model, Member mbr) {
        List<SimpleDateCommentDto> boardCommentList = commentService.getBoardCommentList(0);
//        System.out.println("boardCommentList = " + boardCommentList);

        //오늘 게시물의 갯수 출력
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMdd");
        String today = dtf.format(now);
        int todayBoardCount = boardService.todayBoardCount(today);
        int todayCommentCount = commentService.todayCommentCount(today);

        //0을 입력하면 관리자 공지글 List, 1을 입력하면 멤버의 공지글 List
        String distinguish = "distinguish";
        String adminDistinguish = "0";
        String memberDistinguish = "1";
        List<SimpleDateBoardDto> adminList = boardService.boardSearch(distinguish, adminDistinguish);
        List<SimpleDateBoardDto> memberList = boardService.boardSearch(distinguish, memberDistinguish);

        model.addAttribute("id", id);
        model.addAttribute("admin", adminList);
        model.addAttribute("member", memberList);
        model.addAttribute("board", boardCommentList);
        model.addAttribute("mbr", mbr);
        model.addAttribute("todayBoardCount", todayBoardCount);
        model.addAttribute("todayCommentCount", todayCommentCount);
//        System.out.println("mbr = " + mbr);
//        System.out.println("adminList = " + adminList);
//        System.out.println("memberList = " + memberList);
        return "admin";
    }


    //관리자 공지글 페이지로 이동
    @GetMapping("/notice")
    public String notice(String id, Model model) {
        model.addAttribute("id", id);
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
        } else {
            System.out.println("저장실패");
            return "redirect:/dust/notice?result=false";
        }
    }

    @GetMapping("/member")
    public String noticeMember(Model model) {
        System.out.println("GET맵핑 발생");
//        System.out.println("memberList = " + memberList);
        List<Member> memberList = memberService.findMemberList();
        model.addAttribute("member", memberList);
        return "member";
    }

    @PostMapping("/member")
    public String levelChange(String level, String id) {
//        System.out.println("level = " + level);
//        System.out.println("id = " + id);
        Level changeEnum = Level.valueOf(level);
        boolean flag = memberService.changeMemberLevel(changeEnum, id);
        return "redirect:/dust/member";
    }

    //관리자 TOP
    @GetMapping("/adminView")
    public String adminDetail(String id, Model model) {
        //admin nickname 찾기
        Board admin = boardService.findAdminById(id);
        model.addAttribute("admin",admin);

        //조회수가 가장 높은 게시물(TOP Board)
        long topBoardNo = boardService.topBoardNo();
        Map<SimpleDateBoardDto, Member> TBboardWithWriter = getBoardWithWriter(topBoardNo);
        Map<SimpleDateCommentDto, String> TBcommentMap = getCommentWithNickname(topBoardNo);

        model.addAttribute("TBboard", TBboardWithWriter);
        model.addAttribute("TBcomments", TBcommentMap);

        //좋아요가 가장 많은 댓글의 게시물(TOP Comment)
        long topCommentNo = commentService.topCommentNo();
        Map<SimpleDateBoardDto, Member> TCboardWithWriter = getBoardWithWriter(topCommentNo);
        Map<SimpleDateCommentDto, String> TCcommentMap = getCommentWithNickname(topCommentNo);

        model.addAttribute("TCboard", TCboardWithWriter);
        model.addAttribute("TCcomments", TCcommentMap);

        return "adminView";
    }


    //마이페이지
    @GetMapping("/mypage")
    public String mypage(String id, Model model){
        Map<MyBoardListDto, Member> myBoardListDtoMemberMap = myBoardList(id);
        Map<MyCommentListDto, Member> myCommentListDtoMemberMap = myCommentList(id);
        model.addAttribute("b",myBoardListDtoMemberMap);
        model.addAttribute("c",myCommentListDtoMemberMap);

        return "mypage";

    }


    //마이페이지 게시판 목록
    private Map<MyBoardListDto, Member> myBoardList(String id) {
        Map<MyBoardListDto, Member> boardWithWriter = new HashMap<>();

        List<MyBoardListDto> board = boardService.myBoardListDto(id);

        for (MyBoardListDto myBoardListDto : board) {
            Member boardWriter = memberService.findOneById(id);
            boardWithWriter.put(myBoardListDto, boardWriter);
        }

        return boardWithWriter;
    }

    //마이페이지 댓글 목록
    private Map<MyCommentListDto,Member> myCommentList(String id){
        Map<MyCommentListDto, Member> commentWithWriter = new HashMap<>();

        List<MyCommentListDto> comment = commentService.myCommentListDtoList(id);

        for (MyCommentListDto myCommentListDto : comment) {
            Member boardWriter = memberService.findOneById(id);
            commentWithWriter.put(myCommentListDto, boardWriter);
        }

        return commentWithWriter;
    }

    //동우 마이페이지 내 내정보 수정
    @GetMapping("/mypageUpdate")
    public void mypageUpdate(MyInfoUpdateDto myInfoUpdateDto) {
        memberService.mypageUpdate(myInfoUpdateDto);

    }


}