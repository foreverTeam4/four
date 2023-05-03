package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;
    @Test
    @DisplayName("작성자가 '관리자'인 게시물을 조회하면 admin 계정이 작성한 게시글을 불러온다")
    void search(){
        //given
        String searchBy = "writer";
        String word = "관리자";
        List<Board> list = boardMapper.search(searchBy, word);
        System.out.println(list);
        //when
        assertEquals(1, list.size());

        //then
    }

    @Test
    @DisplayName("보드넘버 1로 게시물을 조회했을 때 게시물이 반환되어야 한다")
    void findOne(){
        long boardNo = 1;
        Board one = boardMapper.findOne(boardNo);
        System.out.println(one);
    }
    @Test
    @DisplayName("보드넘버 1번 게시물이 삭제되어야 한다")
    @Transactional @Rollback
    void remove(){
        long boardNo = 1;
        boolean flag = boardMapper.remove(boardNo);
        System.out.println(flag);
    }

    @Test
    @DisplayName("SearchBy는 'content',word는 ''빈문자열로 뒀을 때 모든 리스트가 출력되어야 한다.")
    void findAllTest(){

        //when
        List<Board> content = boardMapper.search("content", "");
        for (Board board : content) {
            System.out.println("board = " + board.getContent());
        }

    }

}