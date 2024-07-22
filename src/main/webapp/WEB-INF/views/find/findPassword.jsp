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
	<div class="formbox">
	<h2>비밀번호 찾기</h2>
	<form action="${pageContext.request.contextPath}/user/findpassword"method="post">
		아이디 : <input type="number" id="id" name="id">
		<br>
		이름 &nbsp;&nbsp;&nbsp;: <input type="text" id="name" name="name">
		<br>
		<input type="submit" value="비밀번호 찾기 찾기">
	</form>
	</div>
</body>
</html>