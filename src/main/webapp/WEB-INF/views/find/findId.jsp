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
	<c:choose>
	<c:when test="${param.id eq 'fail'}"><script>alert("존재하지않는 이름 혹은 이메일입니다.")</script></c:when>
	<c:when test="${param.id eq null}"></c:when>
	<c:otherwise><script>
	var id = "<%=request.getParameter("id")%>";
	alert("회원님의 ID는 " + id)</script></c:otherwise>
	</c:choose>
	<div class="formbox">
	<h2>아이디 찾기</h2>
	<form action="${pageContext.request.contextPath}/user/findid"method="post">
		이름 &nbsp;&nbsp;&nbsp;: <input type="text" id="name" name="name">
		<br>
		이메일 : <input type="email" id="email" name="email">
		<br>
		<input type="submit" value="아이디 찾기">
	</form>
	</div>
	
</body>
</html>