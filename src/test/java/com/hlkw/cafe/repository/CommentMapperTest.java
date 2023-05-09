package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.AddCommentDto;
import com.hlkw.cafe.dto.AddLikeDto;
import com.hlkw.cafe.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentMapperTest {

    @Autowired
    CommentMapper mapper;

    @Test
    @DisplayName("boarNo이 0일 때 댓글의 전체 목록이 조회되어야 한다.")
    void saveAdminTest() {
        //given
        long boardNo = 0L;

        //when
        List<Comment> list = mapper.getBoardCommentList(boardNo);
        for (Comment comment : list) {
            System.out.println("comment = " + comment.getContent());
        }
        //then
        assertEquals(3, list.size());
    }


    //아이디로 내가쓴 댓글 list 찾기
    @Test
    @DisplayName("보드 아이디 admin으로 댓글을 조회했을 때 내가 쓴 댓글이 반환되어야 한다")
    void myCommentList() {
        String id = "admin";

        List<Comment> list = mapper.myCommentList(id);
        for (Comment comment : list) {
            System.out.println("comment.getId() = " + comment.getId() + " " + comment.getContent());
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            assertEquals("admin", list.get(i).getId());
        }


    }

    @Test
    @DisplayName("boarNo이 0일 때 댓글의 전체 목록이 조회되어야 한다.")
    void topBoardTest() {
        //given
        long boardNo = 0L;

        //when
        List<Comment> list = mapper.getBoardCommentList(0);
        Optional<Comment> maxComment = list.stream()
                .max(Comparator.comparing(comment -> comment.getLikeIt()));

        System.out.println("maxComment = " + maxComment);
        //then

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

    @Test
    @DisplayName("코멘트 번호로 좋아요 수를 늘릴 수 있다.")
    void like(){
        AddLikeDto dto = AddLikeDto.builder()
                .commentNum(10L).build();
        mapper.addLike(dto);

    }
}