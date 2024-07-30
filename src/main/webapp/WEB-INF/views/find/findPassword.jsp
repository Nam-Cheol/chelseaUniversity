<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/findUser.css" type="text/css">
</head>
<body>
	<c:if test="${param.password eq 'fail'}"><script>alert("존재하지않는 아이디 혹은 이름입니다.")</script></c:if>
	<div class="formbox">
	<h2>비밀번호 찾기</h2>
	<form action="${pageContext.request.contextPath}/user/findpassword"method="post">
		<b>아이디</b>  <input type="number" id="id" name="id">
		<br>
		<b>이름</b><input type="text" id="name" name="name">
		<br>
		<input type="submit" value="비밀번호 찾기">
	</form>
	</div>
</body>
</html>