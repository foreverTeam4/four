<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/board-common.css">
<link rel="stylesheet" href="/assets/css/login.css">
</head>
<body>

    <div class="container">
        <div class = "messageWrapper"><h1 class = "message">자유로운 의사소통을 위한 공간입니다<br>
            누구나 자신의 의견을 자유롭게 표현할 수 있으며,<br>
            서로의 생각을 나눌 수 있습니다.</h1>
        </div>
        
        <form action="/dust/main" method = "post" class = "loginBlock">
            <div class = "login"><h2 id = "id">ID</h2><div class = "inputwrapper"><input type="text" name = "id" autofocus></div></div>
            <div class = "login"><h2 id = "pw">PW</h2><div class = "inputwrapper"><input type="password" name = "pw"></div></div>
            <button type="submit">Login</button>
            <h3 class = "fail">※아이디 또는 비밀번호가 일치하지 않습니다. 정확한 아이디와 비밀번호를 입력해주세요. </h3>
        </form>
    </div>

</body>
</html>