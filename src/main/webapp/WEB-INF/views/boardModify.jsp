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
    <link rel="stylesheet" href="/assets/css/modify.css">
    <link rel="stylesheet" href="/assets/css/header.css">
</head>

<body>
<div class="modify-container">
    <header class="top-header">
        <img class="logo" src="/assets/jpg/logo_yellow.png" alt="">
        <div class="logo-text">Space Dust</div>
        <img class="burger-btn" src="/assets/jpg/button.png" alt="">
    </header>

    <header class="modify-btn-wrapper">
        <div class="text-title">Category</div>
        <div class="category-wrapper">
            <button class = "selectCategory">Horror</button>
            <button class = "selectCategory">Romance</button>
            <button class = "selectCategory">Action</button>
            <button class = "selectCategory">SF</button>
        </div>
    </header>

<form action = "/dust/modified" method = "post">
    <div class="modify-text-wrapper">
        <input type="hidden" name = "boardNo" value="${b.boardNo}">
        <input type="hidden" class = "category" name = "category" value = "${b.category}">
        <div class="text-title">Title</div>
        <textarea rows="1" name="title" id="title" class="title-area">${b.title}</textarea>
        <div class="text-title">Content</div>
        <textarea rows="1" name="content" id="content" class="content-area">${b.content}</textarea>
    </div>

    <div class="modify-confirm-wrapper">
        <button type = "submit" class = "modify">수정</button>
        <button onclick="history.back()" class = "back">취소</button>
    </div>
</div>
</form>

<%--<input type="hidden" name = "id" value="${mbr.id}">--%>

<script>
    const $setcategory = document.querySelector('.category-wrapper');
    $setcategory.addEventListener('click', selectCategory);

    function selectCategory(e) {
        const $catetory = document.querySelector('.category');
        const $selected = e.target.closest('.selectCategory');
        $catetory.value = $selected.innerText.toUpperCase();
    }


</script>
</body>

</html>