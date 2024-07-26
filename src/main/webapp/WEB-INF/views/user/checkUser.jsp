<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 비밀번호 확인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/findUser.css" type="text/css">
</head>
<body>
	<script>
  function completeTask() {
    // 부모 창으로 메시지 전송
    window.opener.postMessage('taskCompleted', '*');
    // 자식 창 닫기
    window.close();
  	}
  </script>
	<c:if test="${param.check eq 'fail'}"><script>alert("아이디 혹은 비밀번호가 틀렸습니다.")</script></c:if>
	<c:if test="${param.check eq 'success'}"><script>completeTask();</script></c:if>
	<div class="formbox">
	<h2>보안검사</h2>
	<form action="${pageContext.request.contextPath}/user/check"method="post">
		아이디 &nbsp;&nbsp;&nbsp;: <input type="text" id="id" name="id">
		<br>
		비밀번호 : <input type="password" id="password" name="password">
		<br>
		<input type="submit" value="확인">
	</form>
	</div>
	
	
	
	
  

</body>
</html>