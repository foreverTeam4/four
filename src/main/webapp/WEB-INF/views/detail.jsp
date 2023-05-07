<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/assets/css/board-common.css">
    <link rel="stylesheet" href="/assets/css/detail.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</head>

<body>

<header class="top-header">
    <img class="logo" src="/assets/jpg/logo_yellow.png" alt="">
    <div class="logo-text">Space Dust</div>
    <img class="burger-btn" src="/assets/jpg/button.png" alt="">
</header>

<div class="detail-wrapper">

    <c:forEach var="b" items="${board}">
        <input class="bno" type="hidden" name="boardNo" value="1">
        <div class="detail-title-box">
            <h2 class="detail-board-category">${b.key.category}</h2>
            <h3 class="detail-board-title">${b.key.title}</h3>
            <div class="memberinfo-wrap">
                <div class="detail-board-member-info">
                    <h4 id="board-nickname">${b.value.nickname}</h4>
                    <h5 class="member-level">${b.value.level}</h5>
                </div>
                <div class="writtenDate-wrapper">
                    <div class="date-inner-wrap">
                        <div class="writtenDate">2023.05.04 23:11</div>
                        <div class="viewcount">조회 ${b.key.viewCount}</div>
                    </div>
                    <div class="mini-comment-count">댓글 ${comments.size}</div>
                </div>
            </div>
        </div>

        <div class="detail-content-box">
            <p class="content">${b.key.content}</p>
        </div>
        <div class="under-content-wrapper">
                <%--        <c:if test="${mbr.nickname ne b.value.nickname}">--%>
                <%--            <a href="#" class="viewMorePost">${b.value.nickname}님의 게시물 더 보기 &gt;</a>--%>
                <%--        </c:if>--%>
                <%--        <c:if test="${mbr.nickname eq b.value.nickname}">--%>
            <a href="/dust/modify?boardNo=${b.key.boardNo}" class="under-content modi-rmv">수정</a>
            <a href="/dust/remove?boardNo=${b.key.boardNo}" class="under-content modi-rmv">삭제</a>
                <%--        </c:if>--%>
        </div>
    </c:forEach>


    <div class="detail-comment-box">

        <div class="view-commentList">
            <c:forEach var="map" items="${comments}">
                <div class="written-comments">
                    <img class="white-star" src="/assets/jpg/logo_white.png">
                    <div class="comment-userinfo">
                        <h4 id="comment-nickname">${map.value}</h4>
                        <h6 class="comment-reg-date">${map.key.writtenDate}</h6>
                    </div>
                    <div class="comment-content">${map.key.content}</div>
                    <div class="comment-like">${map.key.likeIt}</div>
                </div>
            </c:forEach>
        </div>

        <div class="write-comment">
            <h4 id="write-comment-nickname">${mbr.nickname}</h4>
            <input type="hidden" class="mbr-id" value="admin">
            <textarea class="comment-content" id = "comment-content" name="content" placeholder="댓글을 남겨주세요"></textarea>
            <button class="regist-comment" id = "regist-comment">등록</button>
        </div>
    </div>
</div>
<script>

    $registComment = document.getElementById('regist-comment');
    $registComment.addEventListener("click", registCmt);

    function registCmt (){
        let id = document.querySelector('.mbr-id');
        const replyContent = document.getElementById('comment-content');
        let boardNo = document.querySelector('.bno');
        $.ajax({
            contentType: 'application/json',
            url : "/replies/new",
            data : JSON.stringify({
                "id" : id.value,
                "content" : replyContent.value,
                "boardNo" : boardNo.value
            }),
            type : "post",
            success : function (result) {
                if(result === "success") {
                    alert("댓글이 등록되었습니다");
                }
            },
            error : function ()
            {
                alert("등록 실패")
            }
        })
    }

</script>
</body>

</html>