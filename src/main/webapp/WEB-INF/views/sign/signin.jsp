<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첼시대학교</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signIn.css">
</head>
<body>
<!-- s : header-->
    <header>
        <div >
            <img src="${pageContext.request.contextPath}/resources/img/Chelsea_FC_Logo_Big.svg.png" alt="">
        </div>
    </header>
    <!-- e : header-->

    <!-- s : login_box-->
    <section class="login_wrapper">
        <h3 class="titles">로그인</h3>
        <div class="login">
            <form action="" method="post">
                <input type="text" id="" name="" placeholder="아이디를 입력하세요.">
                <input type="password" id="" name="" placeholder="비밀번호를 입력하세요.">
                <button type="submit">LOGIN</button>
                <input type="radio" name="" id="login-btn" > 
                <label for="login-btn">아이디 저장</label>
                <a href=""><p>아이디 찾기</p></a>
                <a href=""><p>비밀번호 찾기</p></a>
            </form>
        </div>

    </section>
    <!-- e : -->
<%@ include file="footer.jsp" %>