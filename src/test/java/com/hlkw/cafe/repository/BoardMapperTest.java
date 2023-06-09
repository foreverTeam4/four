package com.hlkw.cafe.repository;

import com.hlkw.cafe.dto.BoardSaveDto;
import com.hlkw.cafe.dto.WriteDto;
import com.hlkw.cafe.entity.Board;
import com.hlkw.cafe.entity.Category;
import com.hlkw.cafe.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.hlkw.cafe.entity.Category.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;
    @Autowired
    CommentMapper commentMapper;

    @Test
    @DisplayName("게시글을 저장할 수 있따")
    void save(){

        for (int i = 0; i < 10; i++) {
            BoardSaveDto dto = new BoardSaveDto("제발요" + i, "저장좀ㅠㅠ" + i, "test" + i, HORROR);
            boardMapper.save(new Board(dto));
        }

    }

    @Test
    @DisplayName("작성자가 '관리자'인 게시물을 조회하면 admin 계정이 작성한 게시글을 불러온다")
    void search(){
        //given
//        String searchBy = "writer";
//        String word = "관리자";
//        List<Board> list = boardMapper.search(searchBy, word);
//        System.out.println(list);
//        //when
//        assertEquals(1, list.size());

        //then

        //태근 관리자 테스트
        //given
        String searchByAdmin= "distinguish";
        String wordAdmin = "0";
        List<Board> adminList = boardMapper.search(searchByAdmin, wordAdmin);
        System.out.println("adminList = " + adminList);
        System.out.println(adminList.size());
        System.out.println();
        System.out.println();
    }

    @Test
    @DisplayName("보드넘버 1로 게시물을 조회했을 때 게시물이 반환되어야 한다")
    void findOne(){
        long boardNo = 10;
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

    @Test
    @DisplayName("save는 id='admin'일때는 distinguish가 0으로 입력되고, 나머지 id는 1로 입력된다.")
    void adminSaveTest(){
        //given
        Board p = new Board().builder()
                .title("안녕하세요")
                .content("노트입니다.")
                .id("test2")
                .category(HORROR)
                .build();

        //when
        boolean save = boardMapper.save(p);

        //then
        System.out.println("p의 distinguish : "+p.getDistinguish());
    }

    //동우
    @Test
    @DisplayName("보드 아이디 admin으로 게시글을 조회했을 때 내가 쓴 게시글이 반환되어야 한다")
    void myBoardList() {
        String id = "admin";

        List<Board> list = boardMapper.myBoardList(id);
        for (Board board : list) {
            System.out.println("comment.getId() = " + board.getId() + " " + board.getContent());
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            assertEquals("admin", list.get(i).getId());
        }

    }


        @Test
    @DisplayName("글제목이 test2title2인 글을 조회하면 게시글 2개가 조회된다.")
    void searchTest(){
        //given
        String searchBy = "title";
        String word = "test2title2";
        List<Board> list = boardMapper.search(searchBy, word);
        System.out.println(list);
        //when
        assertEquals(2, list.size());

        //then
    }

    @Test
    @DisplayName("오늘 날짜에 해당하는 게시물 개수가 반환되어야 한다.")
    void todayBoardTest(){
        //given
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMdd");

        //when
        int i = boardMapper.todayCountBoard(dtf.format(now));

        System.out.println("i = " + i);
    }

    @Test
    @DisplayName("댓글이 달린 게시물을 삭제할 수 있따")
    @Transactional @Rollback
    void deleteTest(){
        long boardNo = 10L;
        commentMapper.removeComment(boardNo);
        boolean flag = boardMapper.remove(boardNo);
        assertTrue(flag);

    }

}