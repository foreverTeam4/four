<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/css/board-common.css">
    <link rel="stylesheet" href="/assets/css/adminView.css">
    <link rel="stylesheet" href="/assets/css/header.css">
</head>

<body>
    <header class="top-header">
        <!-- logo,burger-btn태그 onclick 이벤트 추가 필요 -->
        <img class="logo" src="/assets/jpg/logo_yellow.png" alt="">
        <div class="logo-text">Space Dust</div>
        <img class="burger-btn" src="/assets/jpg/button.png" alt="">
    </header>

    <div class="adminView-wrapper">
        <!-- top 조회수 -->

        <div class="detail-whiteBox">

            <div class="detail-wrapper">
                <div class="main-title">TOP 조회 게시물</div>
                <c:forEach var="tb" items="${TBboard}">
                    <input type="hidden" name="boardNo" value="${tb.key.boardNo}">
                    <div class="detail-title-box">
                        <h2 class="detail-board-category">${tb.key.category}</h2>
                        <h3 class="detail-board-title">${tb.key.title}</h3>
                        <div class="memberinfo-wrap">
                            <div class="detail-board-member-info">
                                <h4 id="board-nickname">${tb.value.nickname}</h4>
                                <h5 class="member-level">${tb.value.level}</h5>
                            </div>
                            <div class="writtenDate-wrapper">
                                <div class="date-inner-wrap">
                                    <div class="writtenDate">2023.05.04 23:11</div>
                                    <!-- <div class="viewcount">조회 0</div> -->
                                    <div class="viewcount">조회 ${tb.key.viewCount}</div>
                                </div>
                                <!-- <div class="mini-comment-count">댓글 0</div> -->
                                <div class="mini-comment-count">댓글 ${TBcomments.size}</div>
                            </div>
                        </div>
                    </div>

                    <div class="detail-content-box">
                        <p class="content">${tb.key.content}</p>
                    </div>
                    <div class="under-content-wrapper"></div>
                </c:forEach>


                <div class="detail-comment-box">

                    <c:forEach var="bmap" items="${TBcomments}">
                    <div class="written-comments">
                        <img class="white-star" src="/assets/jpg/logo_white.png">
                        <div class="comment-userinfo">
                            <h4 id="comment-nickname">${bmap.value}</h4>
                            <h6 class="comment-reg-date">${bmap.key.writtenDate}</h6>
                        </div>
                        <div class="comment-content">${bmap.key.content}</div>
                        <div class="comment-like">${bmap.key.likeIt}</div>
                    </div>
                    <!-- </c:forEach> -->

                    <form action="#" method="get" class="write-comment">
                        <h4 id="write-comment-nickname">${admin.nickname}</h4>
                        <textarea class="comment-content" name="content" placeholder="댓글을 남겨주세요"></textarea>
                        <button class="regist-comment" type="submit">등록</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- top 댓글 -->
        <div class="detail-whiteBox">
            <div class="detail-wrapper">
                <div class="main-title">TOP 좋아요 댓글</div>
                <c:forEach var="tc" items="${TCboard}">
                <input type="hidden" name="boardNo" value="${tc.key.boardNo}">
                <div class="detail-title-box">
                    <h2 class="detail-board-category">${tc.key.category}</h2>
                    <h3 class="detail-board-title">${tc.key.title}</h3>
                    <div class="memberinfo-wrap">
                        <div class="detail-board-member-info">
                            <h4 id="board-nickname">${tc.value.nickname}</h4>
                            <h5 class="member-level">${tc.value.level}</h5>
                        </div>
                        <div class="writtenDate-wrapper">
                            <div class="date-inner-wrap">
                                <div class="writtenDate">2023.05.04 23:11</div>
                                <!-- <div class="viewcount">조회 0</div> -->
                                <div class="viewcount">조회 ${tc.key.viewCount}</div>
                            </div>
                            <!-- <div class="mini-comment-count">댓글 0</div> -->
                            <div class="mini-comment-count">댓글 ${TCcomments.size}</div>
                        </div>
                    </div>
                </div>

                <div class="detail-content-box">
                    <p class="content">${tc.key.content}</p>
                </div>
                <div class="under-content-wrapper"></div>
                </c:forEach>


                <div class="detail-comment-box">

                    <c:forEach var="tcc" items="${TCcomments}">
                    <div class="written-comments">
                        <img class="white-star" src="/assets/jpg/logo_white.png">
                        <div class="comment-userinfo">
                            <h4 id="comment-nickname">${tcc.value}</h4>
                            <h6 class="comment-reg-date">${tcc.key.writtenDate}</h6>
                        </div>
                        <div class="comment-content">${tcc.key.content}</div>
                        <div class="comment-like">${tcc.key.likeIt}</div>
                    </div>
                    </c:forEach>

                    <form action="#" method="get" class="write-comment">
                        <h4 id="write-comment-nickname">${admin.nickname}</h4>
                        <textarea class="comment-content" name="content" placeholder="댓글을 남겨주세요"></textarea>
                        <button class="regist-comment" type="submit">등록</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>