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
    void findOne(){
        long boardNo = 1;
        Board one = boardMapper.findOne(boardNo);
        System.out.println(one);
    }
    @Test
    @Transactional @Rollback
    void remove(){
        long boardNo = 1;
        boolean flag = boardMapper.remove(boardNo);
        System.out.println(flag);
    }
}