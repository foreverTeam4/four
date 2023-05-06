<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/css/board-common.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/admin.css">
</head>

<body>
    <div class="admin-container">
        <header class="top-header">
            <!-- logo,burger-btn태그 onclick 이벤트 추가 필요 -->
            <img class="logo" src="/assets/jpg/logo_yellow.png" alt="">
            <div class="logo-text">Space Dust</div>
            <img class="burger-btn" src="/assets/jpg/button.png" alt="">
        </header>

        <div class="today-container">
            <section class="today-wrapper">
                <div class="today-title">
                    오늘 게시물
                </div>
                <div class="today-count-wrapper">
                    <span class="today-count">20</span>
                    <span>회</span>
                </div>
            </section>
            <section class="today-wrapper">
                <div class="today-title">
                    댓글
                </div>
                <div class="today-count-wrapper">
                    <span class="today-count">01</span>
                    <span>회</span>
                </div>
            </section>
        </div>

        <!-- button 영역 -->
        <section class="btn-wrapper">
            <div class="admin-btn" onclick="location.href='/dust/notice'">
                <div class="btn-title">공지작성</div>
                <div class="btn-content">NOTICE</div>
                <img class="add-btn2" src="/assets/jpg/than2.png" alt="than">
            </div>
            <div class="admin-btn" onclick="location.href='/dust/member'">
                <div class="btn-title">회원관리</div>
                <div class="btn-content">LEVEL</div>
                <img class="add-btn2" src="/assets/jpg/than2.png" alt="than">
            </div>
            <div class="admin-btn" onclick="location.href='/dust/notice'">
                <div class="btn-title">TOP 조회수, 댓글</div>
                <div class="btn-content">VIEWS</div>
                <img class="add-btn2" src="/assets/jpg/than2.png" alt="than">
            </div>
        </section>

        <!-- admin 영역 -->
        <section class="recent-admin">
            <div class="admin-main-wrapper">
                <div class="admin-main-title">최근 공지</div>
                <div class="add-wrapper">
                    <a href="" class="posts-add-btn">
                        <div class="posts-add">더보기</div>
                        <img src="/assets/jpg/than.png" alt="than">
                    </a>
                </div>
            </div>
            <c:forEach var="am" items="${admin}">
                <div class="admin-wrapper">
                    <div class="admin-boardNo">${am.boardNo}</div>
                    <div class="admin-category">${am.category}</div>
                    <div class="admin-title">${am.title}</div>
                    <div class="admin-nickname">관리자</div>
                    <div class="admin-write-date">${am.writtenDate}</div>
                    <div class="admin-view-count">${am.viewCount}</div>
                </div>
            </c:forEach>
        </section>

        <!-- posts 영역 -->
        <section class="recent-posts">
            <div class="posts-main-wrapper">
                <div class="posts-main-title">최근 글</div>
                <div class="add-wrapper">
                    <a href="" class="posts-add-btn">
                        <div class="posts-add">더보기</div>
                        <img src="/assets/jpg/than.png" alt="than">
                    </a>
                </div>
            </div>
            <c:forEach var="m" items="${member}">
                <div class="posts-wrapper">
                    <div class="posts-boardNo">${m.boardNo}</div>
                    <div class="posts-category">${m.category}</div>
                    <div class="posts-title">${m.title}</div>
                    <div class="posts-nickname">이동우</div>
                    <div class="posts-write-date">${m.writtenDate}</div>
                    <div class="posts-view-count">${m.viewCount}</div>
                </div>
            </c:forEach>
        </section>

        <!-- comment 영역 -->
        <section class="recent-comments">
            <div class="comments-main-wrapper">
                <div class="comments-main-title">최근 댓글</div>
                <div class="add-wrapper">
                    <a href="" class="posts-add-btn">
                        <div class="posts-add">더보기</div>
                        <img src="/assets/jpg/than.png" alt="than">
                    </a>
                </div>
            </div>
            <c:forEach var="b" items="${board}">
            <div class="comments-wrapper">
                <div class="comments-boardNo">${b.boardNo}</div>
                <div class="comments-category">HORROR</div>
                <div class="comments-title">${b.content}</div>
                <div class="comments-nickname">이동우</div>
                <div class="comments-write-date">${b.writtenDate}</div>
                <div class="comments-view-count">0</div>
            </div>
            </c:forEach>
            <div class="comments-wrapper">
                <div class="comments-boardNo">9999</div>
                <div class="comments-category">HORROR</div>
                <div class="comments-title">대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.</div>
                <div class="comments-nickname">이동우</div>
                <div class="comments-write-date">2023.04.30</div>
                <div class="comments-view-count">0</div>
            </div>
            <div class="comments-wrapper">
                <div class="comments-boardNo">9999</div>
                <div class="comments-category">HORROR</div>
                <div class="comments-title">대한민국의 주권은 국민에게 있고, 모든 권력은 국민으로부터 나온다.</div>
                <div class="comments-nickname">이동우</div>
                <div class="comments-write-date">2023.04.30</div>
                <div class="comments-view-count">0</div>
            </div>


        </section>
    </div>
</body>

</html>