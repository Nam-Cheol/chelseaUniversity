<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">

	<h2>강의 계획서 수정</h2>
	<form action="${pageContext.request.contextPath}/syllabus/submit?id=${param.id}" method="post">
		<a>강의 개요</a>
		<br>
		<input type="text" id="overview" name="overview" value="${syllabusInfo.overview}">
		<br>
		<a>수업 목표</a>
		<br>
		<input type="text" id="objective" name="objective" value="${syllabusInfo.objective}">
		<br>
		<a>교재</a>
		<br>
		<input type="text" id="textbook" name="textbook" value="${syllabusInfo.textbook}">
		<br>
		<a>주별 계획</a>
		<br>
		<input type="text" id="program" name="program" value="${syllabusInfo.program}">
		<button class="btn btn-edit" type="submit">수정</button>
	</form>
</body>
</html>