<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/board-common.css">
<link rel="stylesheet" href="/assets/css/header.css">
<link rel="stylesheet" href="/assets/css/mypage.css">
</head>
<body>
       <!-- 동우 마이페이지 내역 -->

       <section class="container">
        <header class="top-header">
            <!-- logo,burger-btn태그 onclick 이벤트 추가 필요 -->
            <img class="logo" src="/assets/jpg/logo_yellow.png" alt="logo_yellow">
            <div class="logo-text">Space Dust</div>
            <img class="burger-btn" src="/assets/jpg/button.png" alt="button">
        </header>


        <!-- 내 정보 영역 -->
        <div class="myInfo">
            <div class="myInfo-title">내 정보</div>
            <div class="whiteboard"> 
                <div class="whiteboard-class">
                    <div id="black"><img src="/assets/jpg/logo_black.png" alt="black"></div>
                    <div class="user-info"><span>이동우</span>님 반갑습니다</div>
                    <div class="user-info-bottom">
                        <div class="myInfo-content">
                            <a href="">
                                <div>개인 정보</div>
                            </a>
                            <a href="">
                                <div>수정하기 ></div>
                            </a>
                        </div>
                        <div class="section-name">
                            <div class="section1">
                                <div>이름 : 이동우</div>
                                <div>나이 : 29</div>
                                <div>성별 : 여</div>
                            </div>
                            <div class="section2">
                                <div>전화번호 : 010-1234-1234</div>
                                <div>주소 : 서울특별시 강남구 개포동 1169-8</div>
                                <div>email : loveJincu@naver.com</div>
                            </div>
                        </div>
                    </div> 
                </div>
                <div class="grade-count">    
                    <div class="grade">
                        <div>현재 등급</div>
                        <div class="circle"></div>
                        <div class="cosmos">COSMOS</div>
                        <div class="cosmos cos2">다음등급까지</div> 
                        <div class="cosmos cos2">00개 남았습니다</div>
                    </div>    
                    <div class="board-comment">
                        <div class="comment">
                            <div>작성한 글</div>
                            <div>작성 댓글</div>
                        </div>
                        <div class="count">
                            <div><span>10</span>건</div>
                            <div><span>07</span>건</div>
                        </div>
                    </div>     
                </div>    
            </div>

                

        </div>



        <!-- 동우 내가 작성한 글 조회 -->
        <section class="recent-posts">
            <div class="posts-main-wrapper">
                <div class="posts-main-title">내가 작성한 글 조회</div>
                <div class="add-wrapper">
                    <a href="" class="posts-add-btn">
                    <div class="posts-add">더보기</div>
                    <img src="/assets/jpg/than.png" alt="than"></a>
                </div>
            </div>
            <div class="posts-wrapper">
                <div class="posts-boardNo">1</div>
                <div class="posts-title">대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.</div>
                <div class="posts-nickname">이동우</div>
                <div class="posts-write-date">2023.04.30</div>
                <div class="posts-view-count">0</div>
            </div>
            <div class="posts-wrapper">
                <div class="posts-boardNo">2</div>

                
                <div class="posts-title">대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.</div>
                <div class="posts-nickname">이동우</div>
                <div class="posts-write-date">2023.04.30</div>
                <div class="posts-view-count">0</div>
            </div>
        </section>

        <!-- 동우 내가 작성한 댓글 조회 -->
        <section class="recent-posts">
            <div class="posts-main-wrapper">
                <div class="posts-main-title">내가 작성한 댓글 조회</div>
                <div class="add-wrapper">
                    <a href="" class="posts-add-btn">
                    <div class="posts-add">더보기</div>
                    <img src="/assets/jpg/than.png" alt="than"></a>
                </div>
            </div>
            <div class="posts-wrapper">
                <div class="posts-boardNo">1</div>
                <div class="posts-title">대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.</div>
                <div class="posts-nickname">이동우</div>
                <div class="posts-write-date">2023.04.30</div>
                <div class="posts-view-count">0</div>
            </div>
            <div class="posts-wrapper">
                <div class="posts-boardNo">2</div>
                <div class="posts-title">대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.</div>
                <div class="posts-nickname">이동우</div>
                <div class="posts-write-date">2023.04.30</div>
                <div class="posts-view-count">0</div>
            </div>
        </section>
    </section>
    
</body>
</html>