<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기 결과</title>
<style>
body {
	width: 100%;
	height: 100vh;
	display: flex;
	justify-content: center;
}
.resultBox {
	display: flex;
	align-items: center;
	width: 40%;
	height: 100vh;
}
</style>
</head>
<body>
	<div class="resultBox">
	<c:choose>
	<c:when test="${param.result eq 'id'}"><h3>회원님의 아이디는 ${param.id} 입니다.</h3></c:when>
	<c:when test="${param.result eq 'password'}"><h3>회원님의 비밀번호는 ${param.password} 입니다.</h3></c:when>
	<c:otherwise><script>alert("잘못된 요청입니다.")</script></c:otherwise>
	</c:choose>
	</div>
</body>
</html>