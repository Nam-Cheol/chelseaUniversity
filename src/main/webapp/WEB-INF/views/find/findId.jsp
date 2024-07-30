<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/findUser.css" type="text/css">
</head>
<body>
	<c:if test="${param.id eq 'fail'}"><script>alert("존재하지않는 이름 혹은 이메일입니다.")</script></c:if>
	<div class="formbox">
	<h2>아이디 찾기</h2>
	<form action="${pageContext.request.contextPath}/user/findid"method="post">
		<b>이름</b>  <input type="text" id="name" name="name">
		<br>
		<b>이메일</b>  <input type="email" id="email" name="email">
		<br>
		<input type="submit" value="아이디 찾기">
	</form>
	</div>
	
</body>
</html>