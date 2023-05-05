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
<div class="notice-container">
    <header class="top-header">
        <!-- logo,burger-btn태그 onclick 이벤트 추가 필요 -->
        <img class="logo" src="/jpg/logo_yellow.png" alt="">
        <div class="logo-text">Space Dust</div>
        <img class="burger-btn" src="/jpg/button.png" alt="">
    </header>

    <div class="notice-main-title">태근이 공지 작성 완료되면 가져다 쓸거임 ~~~~~</div>
    <header class="notice-btn-wrapper">
        <div class="text-title">Category</div>
        <div class="category-wrapper">
            <button>Horror</button>
            <button>Romance</button>
            <button>Action</button>
            <button>SF</button>
        </div>
    </header>
    <div class="notice-text-wrapper">
        <div class="text-title">Title</div>
        <textarea rows="1" name="" id="" class="title-area"></textarea>
        <div class="text-title">Content</div>
        <textarea rows="1" name="" id="" class="content-area"></textarea>
    </div>

    <div class="notice-confirm-wrapper">
        <button>등록</button>
        <button>취소</button>
    </div>
</div>

<script>
    const $btns = document.querySelector('.category-wrapper').children;
    let prevSelected = null; //이전에 선택된 버튼을 저장할 변수

    for (const btnlist of $btns) {
        btnlist.onclick = () => {
            console.log("onclick 이벤트 발생");
            btnlist.classList.add('btn-click');

            if (prevSelected !== null && prevSelected !== btnlist) {
                prevSelected.classList.remove('btn-click');
            }
            prevSelected = btnlist
        };
    }
</script>
</body>

</html>