<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/css/board-common.css">
    <link rel="stylesheet" href="/assets/css/loading.css">
</head>

<body>
    <div class="ani-wrapper">
        <div class="img-wrapper">
            <img src="/assets/jpg/ani1.png" alt="" class="ani1">
            <img src="/assets/jpg/ani2.png" alt="" class="ani2">
            <img src="/assets/jpg/ani3.png" alt="" class="ani3">
            <img src="/assets/jpg/ani4.png" alt="" class="ani4">
        </div>
        <div class="title none">From DUST, To SPACE</div>
        <form id="end-loading" method="post" action="/dust/main">
            <input type="hidden" name="id" value="${id}">
            <input type="hidden" name="pw" value="${pw}">
        </form>

    </div>

    <script>
        setTimeout(function () {
            document.getElementById("end-loading").submit();
            console.log("실행");
        }, 5000);

        //Title 2초 뒤 보이게
        setTimeout(function () {
            document.querySelector('.title').classList.remove('none');
        }, 2000)

        // setTimeout(function () {
        //     document.querySelectorAll('.img-wrapper img').forEach(function (img) {
        //         img.classList.remove('none');
        //     });
        // }, 2000);
    </script>
</body>

</html>