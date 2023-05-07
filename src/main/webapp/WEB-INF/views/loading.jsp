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
        <div class="title">From DUST, To SPACE</div>
        <form id="testForm" method="get" action="/dust/test">
            <input type="hidden" name="test" value="">
        </form>
        <iframe name="hframe" style="display:none;"></iframe>
    </div>

    <script>
        document.getElementById("testForm").target = "hframe"; //타겟을 iframe으로 한다
        setTimeout(function () {
            document.getElementById("testForm").submit();
            console.log("실행");
        }, 4000);
    </script>
</body>

</html>