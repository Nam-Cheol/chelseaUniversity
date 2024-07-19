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
<c:if test="${param.pass == false}">
	<script>
		alert("아이디 혹은 비밀번호가 틀렸습니다.")
	</script>
</c:if>
<c:set var="cookies" value="${pageContext.request.cookies}"/>
<!-- s : header-->
    <header>
        <div class="Logo">
            <img src="${pageContext.request.contextPath}/resources/img/Chelsea_FC_Logo_Big.svg.png" alt="">
        </div>
    </header>
    <!-- e : header-->
    <!-- s : login_box-->
    <section class="login_wrapper">
        <h3 class="titles">로그인</h3>
        <div class="login">
            <form action="${pageContext.request.contextPath}/user/signin" method="post">
                <input type="number" id="id" name="id" placeholder="아이디를 입력하세요." class="box" 
                value="${cookie.id.value}">
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." class="box">
                <button type="submit">LOGIN</button>
                <div class="options">
                    <input type="checkbox" name="save-login" id="login-btn" class="checkbox"> 
                    <label for="login-btn" class="save-id">아이디 저장</label>
                    <a href="">아이디 찾기</a>
                    <a href="">비밀번호 찾기</a>
                </div>
            </form>
        </div>
    </section>
    <!-- e : -->
<%@ include file="footer.jsp" %>