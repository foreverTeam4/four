<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/assets/css/board-common.css">
<link rel="stylesheet" href="/assets/css/index.css">
</head>
<body>

    <div class="container">
        <div class = "messageWrapper"><h1 class = "message">자유로운 의사소통을 위한 공간입니다<br>
            누구나 자신의 의견을 자유롭게 표현할 수 있으며,<br>
            서로의 생각을 나눌 수 있습니다.</h1>
        </div>
        
        <div class = "indexBlock">
            <a href = "/dust/login" class = "selectBlock">
                <h2 id = "loginPage"><span class = "num">01</span> Log in</h2>
            </a>
            <a href = "#" class = "selectBlock">
                <h2 id = "signUpPage"><span class = "num">02</span> Sign up</h2>
            </a>
        </div>
    </div>

</body>
</html>