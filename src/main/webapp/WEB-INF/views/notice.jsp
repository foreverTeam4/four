<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/board-common.css">
    <link rel="stylesheet" href="/assets/css/notice.css">
    <link rel="stylesheet" href="/assets/css/header.css">
</head>

<body>
    <form action="/dust/notice" method="post" id="formInput">
        <input type="hidden" name="id" id="id" value="${id}">
        <div class="notice-container">
            <header class="top-header">
                <!-- logo,burger-btn태그 onclick 이벤트 추가 필요 -->
                <img class="logo" src="/assets/jpg/logo_yellow.png" alt="">
                <div class="logo-text">Space Dust</div>
                <img class="burger-btn" src="/assets/jpg/button.png" alt="">
            </header>

            <div class="notice-main-title">공지 작성</div>
            <header class="notice-btn-wrapper">
                <div class="text-title">Category</div>
                <div class="category-wrapper">
                    <button name="category" value="HORROR">Horror</button>
                    <button name="category" value="ROMANCE">Romance</button>
                    <button name="category" value="ACTION">Action</button>
                    <button name="category" value="SF">SF</button>
                </div>
            </header>
            <!-- category값 넘기는 input -->
            <input type="hidden" name="category" id="category" value="">

            <div class="notice-text-wrapper">
                <div class="text-title">Title</div>
                <textarea rows="1" name="title" class="title-area"></textarea>
                <div class="text-title">Content</div>
                <textarea rows="1" name="content" class="content-area"></textarea>
            </div>


            <div class="notice-confirm-wrapper">
                <div class="back-wrapper" onclick="location.href='/dust/admin'">
                    <img src="/assets/jpg/back.png" alt="" class="back-btnImg">
                    <button class="back-btn">뒤로가기</button>
                </div>
                <button type="submit" class="confirm-btn">등록하기</button>

                <!-- <a onclick="location.href='/dust/admin'">취소</a> -->
            </div>
        </div>

        <!-- 실패시 알람 -->
        <c:if test="${param.result == 'false'}">
            <div id="false-alert" style="display: none;"></div>
        </c:if>
    </form>

    <script>
        const $btns = document.querySelector('.category-wrapper').children;
        let prevSelected = null; //이전에 선택된 버튼을 저장할 변수

        for (const btnlist of $btns) {
            btnlist.onclick = (e) => {
                e.preventDefault();
                // console.log("onclick 이벤트 발생");
                btnlist.classList.add('btn-click');

                if (prevSelected !== null && prevSelected !== btnlist) {
                    prevSelected.classList.remove('btn-click');
                }
                prevSelected = btnlist

                document.getElementById('category').value = prevSelected.value;
            };
        }
        // Title이나 Content가 빈 문자열일때 alert추가
        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById('false-alert').style.display = "block";
            alert("다시 입력해주세요");
        });
    </script>
</body>

</html>