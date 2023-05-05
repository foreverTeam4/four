<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/board-common.css">
<link rel="stylesheet" href="/assets/css/member.css">
<link rel="stylesheet" href="/assets/css/header.css">
</head>
<body>
    <header class="top-header">
        <!-- logo,burger-btn태그 onclick 이벤트 추가 필요 -->
        <img class="logo" src="/jpg/logo_yellow.png" alt="">
        <div class="logo-text">Space Dust</div>
        <img class="burger-btn" src="/jpg/button.png" alt="">
    </header>

    <div class="member-container">

        <section class="member-header">
            <div class="title-mapper">
                <div class="title">멤버 관리</div>
                <div>Member Management</div>
            </div>
            <ul class="title-text">
                <li>아이디</li>
                <li>레벨</li>
                <li>주소</li>
                <li>나이</li>
                <li>전화번호</li>
                <li>성별</li>
                <li>이메일</li>
                <li>닉네임</li>
            </ul>
        </section>

        <section class="member-main">
            <ul class="member-text">
                <li>test1</li>
                <li><a class="member-level member-btn">DUST</a></li>
                <li>서울특별시 관악구 신림동 66길</li>
                <li>30</li>
                <li>010-333-3333</li>
                <li>M</li>
                <li>test@naver.com</li>
                <li>크크크</li>
            </ul>
            <ul class="member-text">
                <li>test1</li>
                <li><a class="member-level">COSMOS</a></li>
                <li>서울특별시 관악구 신림동 66길</li>
                <li>30</li>
                <li>010-333-3333</li>
                <li>M</li>
                <li>test@naver.com</li>
                <li>크크크</li>
            </ul>
            <ul class="member-text">
                <li>test1</li>
                <li><a class="member-level">GALAXY</a></li>
                <li>서울특별시 관악구 신림동 66길</li>
                <li>30</li>
                <li>010-333-3333</li>
                <li>M</li>
                <li>test@naver.com</li>
                <li>크크크</li>
            </ul>
            <ul class="member-text">
                <li>test1</li>
                <li><a class="member-level">NEBULA</a></li>
                <li>서울특별시 관악구 신림동 66길</li>
                <li>30</li>
                <li>010-333-3333</li>
                <li>M</li>
                <li>test@naver.com</li>
                <li>크크크</li>
            </ul>
            <ul class="member-text">
                <li>test1</li>
                <li><a class="member-level">DUST</a></li>
                <li>서울특별시 관악구 신림동 66길</li>
                <li>30</li>
                <li>010-333-3333</li>
                <li>M</li>
                <li>test@naver.com</li>
                <li>크크크</li>
            </ul>
        </section>
        <div class="back-wrapper">
            <img src="/jpg/back.png" alt="" class="back-btnImg">
            <button class="back-btn">뒤로가기</button>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal-wrapper">
        <div class="modal-container">
            <div class="modal-title">등급 변경</div>
            <div class="modal-choice">
                <div>DUST</div>
                <div>COSMS</div>
                <div>GALAXY</div>
                <div>NEBULA</div>
            </div>
            <div class="choice-btn-wrapper">
                <div class="choice-btn-back">
                    <img src="/jpg/back.png" alt="" class="choice-back-btnImg">
                    <div class="choice-back-btnText">Back</div>
                </div>
                <button class="confirm-btn">변경하기</button>
            </div>
        </div>
    </div>

    <script>
        const btnsOpenPopup = document.querySelectorAll('.member-level');
        const modal = document.querySelector('.modal-wrapper');
        const closeBtn = document.querySelector('.choice-btn-back');

        for (const btnOpenPopup of btnsOpenPopup) {
            btnOpenPopup.addEventListener('click', () => {
                console.log("btn-click발생");
                modal.style.display='block';
            });
        }

        closeBtn.addEventListener('click',() =>{
            modal.style.display = "none";
        });

        window.onclick = (e) =>{
            if(e.target == modal){
                modal.style.display = "none";
            }
        }
    </script>
</body>
</html>