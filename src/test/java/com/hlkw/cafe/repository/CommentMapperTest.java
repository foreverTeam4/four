package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentMapperTest {

    @Autowired
    CommentMapper mapper;

    @Test
    @DisplayName("boarNo이 0일 때 댓글의 전체 목록이 조회되어야 한다.")
    void saveAdminTest() {
        //given
        int boardNo = 0;

        //when
        List<Comment> list = mapper.getBoardCommentList(boardNo);
        for (Comment comment : list) {
            System.out.println("comment = " + comment.getContent());
        }
        //then
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("보드 아이디 admin으로 댓글을 조회했을 때 게시물이 반환되어야 한다")
    void myCommentOne(){
        String id="admin";
        Comment one = mapper.MyCommentOne(id);
        System.out.println("one = " + one);
        System.out.println();
        System.out.println();

    }
}