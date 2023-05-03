package com.hlkw.cafe.repository;

import com.hlkw.cafe.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

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