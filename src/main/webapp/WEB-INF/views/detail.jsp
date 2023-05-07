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
        <input class="bno" type="hidden" name="boardNo" value="${b.key.boardNo}">
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
                    <div class="mini-comment-count" id = "mini-comment-count"></div>
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

        <div class="view-commentList" id = "view-commentList">
<%--            <c:forEach var="map" items="${comments}">--%>
<%--                <div class="written-comments">--%>
<%--                    <img class="white-star" src="/assets/jpg/logo_white.png">--%>
<%--                    <div class="comment-userinfo">--%>
<%--                        <h4 id="comment-nickname">${map.value}</h4>--%>
<%--                        <h6 class="comment-reg-date">${map.key.writtenDate}</h6>--%>
<%--                    </div>--%>
<%--                    <div class="comment-content">${map.key.content}</div>--%>
<%--                    <div class="comment-like">${map.key.likeIt}</div>--%>
<%--            </c:forEach>--%>
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
    getReplyList();

    $registComment = document.getElementById('regist-comment');
    $registComment.addEventListener("click", registCmt);

    function registCmt (){
        let id = document.querySelector('.mbr-id');
        const replyContent = document.getElementById('comment-content');
        let board = document.querySelector('.bno');
        $.ajax({
            contentType: 'application/json',
            url : "/replies/new",
            data : JSON.stringify({
                "id" : id.value,
                "content" : replyContent.value,
                "boardNo" : board.value
            }),
            type : "post",
            success : function (result) {
                if(result === "success") {
                    // alert("댓글이 등록되었습니다");
                }
            },
            error : function ()
            {
                alert("등록 실패")
            }
        })
        document.getElementById('comment-content').value = "";
        getReplyList();
    }

    function getReplyList(){
        let board = document.querySelector('.bno');
        $.ajax({
            contentType: 'application/json',
            url : "/replies/" + board.value,
            data :{
                "boardNo" : board.value
            },
            type : "get",
            success : function(result){
                let $commentBlock = document.getElementById('view-commentList');
                $commentBlock.innerHTML = "";
                let $commentCnt = document.getElementById('mini-comment-count');
                $commentCnt.innerText = "댓글 " + result.length;
                if(result != null) {
                    console.log(result);
                    for (let x of result) {
                        const $reply = document.createElement("div");
                        $reply.classList.add('written-comments');
                        // let $reply = $("<div class='written-comments'>");
                        let $img = document.createElement("img");
                        $img.classList.add('white-star');
                        $img.src = "/assets/jpg/logo_white.png";
                        // let $img = $("<img class='white-star' src='/assets/jpg/logo_white.png'>");
                        let $userIf = document.createElement("div");
                        $userIf.classList.add('comment-userinfo');
                        // let $userIf = $("<div class='comment-userinfo'>");
                        let $nnm = document.createElement("h4");
                        $nnm.id = 'comment-nickname';
                        $nnm.innerText = x[1];
                        // let $nnm = $("<h4 id='comment-nickname'>").text(x.get(1)).append("</h4>");
                        let $date = document.createElement("h6");
                        $date.classList.add('comment-reg-date');
                        $date.innerText = x[0].writtenDate;
                        <%--let $date = $("<h6 class='comment-reg-date'>${x.get(0).writtenDate}</h6></div>");--%>
                        let $contt = document.createElement("div");
                        $contt.classList.add('comment-content');
                        $contt.innerText = x[0].content;
                        <%--let $contt = $("<div class='comment-content'>${x.get(0).content}</div>");--%>
                        let $like = document.createElement("div");
                        $like.classList.add('comment-like');
                        $like.innerText = x[0].likeIt;
                        <%--let $like = $("<div class='comment-like'>${x.get(0).likeIt}</div></div>");--%>

                        $commentBlock.appendChild($reply);
                        $reply.appendChild($img);
                        $reply.appendChild($userIf);
                        $userIf.appendChild($nnm);
                        $userIf.appendChild($date);
                        $reply.appendChild($contt);
                        $reply.appendChild($like);

                <%--<div class="written-comments">--%>
                <%--    <img class="white-star" src="/assets/jpg/logo_white.png">--%>
                <%--    <div class="comment-userinfo">--%>
                <%--        <h4 id="comment-nickname">${map.value}</h4>--%>
                <%--        <h6 class="comment-reg-date">${map.key.writtenDate}</h6>--%>
                <%--    </div>--%>
                <%--    <div class="comment-content">${map.key.content}</div>--%>
                <%--    <div class="comment-like">${map.key.likeIt}</div>--%>
                <%--</div>--%>

                    }
                }

            },
            error : function () {
                console.log("댓글 불러 오기 실패")
            }
        })
    }

</script>
</body>

</html>
