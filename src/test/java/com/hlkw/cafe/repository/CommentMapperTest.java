package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.AddCommentDto;
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
    @DisplayName("id, 댓글내용, boardNo로 댓글을 추가할 수 있다.")
    void addCommentTest(){
        String id = "admin";
        String content = "에드코멘트 테스트";
        long boardNo = 2L;
        AddCommentDto dto = AddCommentDto.builder()
                .id(id)
                .content(content)
                .boardNo(boardNo)
                .build();

        boolean flag = mapper.addComment(dto);

        assertTrue(flag);
    }
}