<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첼시대학교</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/signIn.css" type="text/css">
</head>
<body>
<c:if test="${param.pass == false}">
    <script>
        alert("아이디 혹은 비밀번호가 틀렸습니다.")
    </script>
</c:if>
<!-- s : header-->
<script type="text/javascript">
    function findId(){
        window.open("<%= request.getContextPath() %>/user/findid","findid","width=640, height=550")
    }
    function findPassword(){
        window.open("<%= request.getContextPath() %>/user/findpassword","findpassword","width=640, height=550")
    }
</script>
<header>
    <div class="Logo">
        <img src="${pageContext.request.contextPath}/resources/img/Chelsea_FC_Logo_Big.svg.png" alt="첼시 유나이티드 로고">
    </div>
</header>
<!-- e : header-->
<!-- s : login_box-->
<section class="login_wrapper">
    <h3 class="titles">로그인</h3>
    <div class="login">
        <form action="${pageContext.request.contextPath}/user/signin" method="post">
            <input type="number" id="id" name="id" placeholder="아이디를 입력하세요." value="${cookie.id.value}">
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요." class="box">
            <button type="submit">LOGIN</button>
            <div class="options">
                <label for="login-btn" class="save-id">
                    <input type="checkbox" name="save-login" id="login-btn" class="checkbox"> 
                    아이디 저장
                </label>
                <a href="javascript:findId()">아이디 찾기</a>
                <a href="javascript:findPassword()">비밀번호 찾기</a>
            </div>
        </form>
    </div>
</section>
<!-- e : -->
<%@ include file="footer.jsp" %>
