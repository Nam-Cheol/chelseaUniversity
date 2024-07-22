<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>강의 계획서 조회</h2>
	<a href="${pageContext.request.contextPath}/subject/list?page=1">돌아가기</a>
	<table border="1">
		<tr>
			<td rowspan="4">교과목 정보</td>
			<td>수업 번호</td>
			<td><c:out value="${info.id}"></c:out></td>
			<td>학점</td>
			<td><c:out value="${info.grades}"></c:out></td>
		</tr>
		<tr>
			<td>수업 연도</td>
			<td><c:out value="${info.subYear}"></c:out></td>
			<td>강의 시간</td>
			<td><c:out value="${info.subDay} ${info.startTime}:00-${info.endTime}:00"></c:out></td>
		</tr>
		<tr>
			<td>교과목 명</td>
			<td><c:out value="${info.name}"></c:out></td>
			<td>이수 구분</td>
			<td><c:out value="${info.type}"></c:out></td>
		</tr>
		<tr>
			<td>수업 학기</td>
			<td><c:out value="${info.semester}학기"></c:out></td>
			<td>강의실</td>
			<td><c:out value="${info.roomId}"></c:out></td>
		</tr>
	</table>
	<br>
	<br>
	<table border="1">
		<tr>
			<td rowspan="4">교강사 정보</td>
			<td>소속</td>
			<td><c:out value="${professorInfo.deptName}"></c:out></td>
			<td>성명</td>
			<td><c:out value="${professorInfo.name}"></c:out></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><c:out value="${professorInfo.tel}"></c:out></td>
			<td>email</td>
			<td><c:out value="${professorInfo.email}"></c:out></td>
		</tr>
	</table>
	<br>
	<br>
	<table border="1">
		<tr>
			<td>강의 개요</td>
			<td><c:out value="${syllabusInfo.overview}"></c:out></td>
		</tr>
		<tr>
			<td>강의 목표</td>
			<td><c:out value="${syllabusInfo.objective}"></c:out></td>
		</tr>
		<tr>
			<td>교재 정보</td>
			<td><c:out value="${syllabusInfo.textbook}"></c:out></td>
		</tr>
		<tr>
			<td>주간 계획</td>
			<td><c:out value="${syllabusInfo.program}"></c:out></td>
		</tr>
	</table>
	<br><br>
	<form action="${pageContext.request.contextPath}/syllabus/update?id=${info.id}" method="post">
		<button class="btn btn-edit">수정</button>
	</form>
</body>
</html>