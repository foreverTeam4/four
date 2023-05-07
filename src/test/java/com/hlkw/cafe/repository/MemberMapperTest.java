package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.MyInfoUpdateDto;
import com.hlkw.cafe.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    CommentMapper commentMapper;

    @Test
    @DisplayName("멤버를 생성할 수 있다")
//    @Transactional @Rollback
    void save(){
        for (int i = 0; i < 20; i++) {
        Member mbr = new Member("test" + i, "1234", "서울", 30, "01000000000", Gender.F, "test@test.com", "test", Level.DUST);
        memberMapper.save(mbr);
        }

    }

    @Test
    @DisplayName("아이디와 비밀번호로 관리자를 조회할 수 있다")
    void findOne() {
        String id = "admin";
        String pw = "admin";
        Member mbr = memberMapper.findOne(id, pw);

        System.out.println(mbr);
    }

    @Test
    @DisplayName("아이디와 비밀번호로 멤버를 조회할 수 있다")
    void findMember() {
        String id = "test1";
        String pw = "2222";
        Member mbr = memberMapper.findOne(id, pw);

        System.out.println(mbr);
    }

    @Test
    @DisplayName("아이디와 비밀번호가 일치하지 않으면 mbr의 값이 null이다")
    void findNull() {
        String id = "test3";
        String pw = "3333";
        Member mbr = memberMapper.findOne(id, pw);

        System.out.println(mbr);

    }

    @Test
    @DisplayName("게시글이 가진 id필드로 멤버를 조회할 수 있다")
    void findOneById() {
        Board b = boardMapper.findOne(1);
        Member mbr = memberMapper.findOneById(b.getId());

        System.out.println(mbr);
    }

    @Test
    @DisplayName("코멘트번호로 코멘트 작성자 닉네임을 조회할 수 있다")
    void findNicknameByCommentNum() {
        Map<Comment, String> map = new HashMap<>();
        long boardNo = 2;
        List<Comment> commentList = commentMapper.getBoardCommentList(boardNo);
        for (Comment comment : commentList) {
            String nickname = memberMapper.findNicknameByCommentNum(comment.getCommentNum());
            System.out.println(nickname);
            map.put(comment, nickname);
        }

    }

    @Test
    @DisplayName("파라미터에 아무것도 입력하지 않을 시 멤버의 모든 정보가 나온다.")
    void findAllTest(){
        //then
        List<Member> all = memberMapper.findAll();
        for (Member member : all) {
            System.out.println("member = " + member);
        }

    }


    @Test
    @DisplayName("admin 아이디에 있는 정보 수정 후 재확인하면 회원 정보가 수정되어 있어야 한다")
    void mypageUpdate() {
        String memberId = "admin";
        String memberPw = "ehddn";
        String memberAddr = "서초동";
        String memberPhoneNum = "0104454974897";
        String memberEmail = "admin";
        String memberNick = "닉네임";
        Member m = Member.builder()
                .id(memberId)
                .pw(memberPw)
                .addr(memberAddr)
                .phoneNum(memberPhoneNum)
                .email(memberEmail)
                .nickname(memberNick)
                .build();

        boolean b = memberMapper.mypageUpdate(m);

        assertTrue(b);
        assertEquals(memberPw, memberMapper.findOne("admin","ehddn").getPw());
        System.out.println();
        System.out.println();
        System.out.println("m = " + m);

    }
}