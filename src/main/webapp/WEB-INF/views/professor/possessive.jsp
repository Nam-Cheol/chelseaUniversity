<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/professorHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/myinfo.css">
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>수업</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/subject/list"
						class="selected--menu">전체 강의 조회</a></td>
				</tr>
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/professor/subject"
							class="selected--menu">내 강의 조회</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/professor/evaluationList"
							class="selected--menu">내 강의 평가</a></td>
					</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>내 강의 조회</h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->

		<!-- 필터 및 검색 -->

		<h4>
			<span style="font-weight: 600;">강의 목록</span>
		</h4>
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>학수번호</th>
					<th style="width: 200px;">강의명</th>
					<th>강의시간</th>
					<th>강의계획서</th>
					<th>학생 목록</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="subject" items="${classesList}">
					<tr>
						<td><c:out value="${subject.id}"></c:out></td>
						<td><c:out value="${subject.name}"></c:out></td>
						<td><c:out value="${subject.subDay} ${subject.startTime}:00-${subject.endTime}:00 (${subject.roomId})"></c:out></td>
						<td><a href="${pageContext.request.contextPath}/syllabus/info?id=${subject.id}">강의계획서</a></td>
						<td><a href="${pageContext.request.contextPath}/professor/studentList?id=${subject.id}">학생 목록</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</div>
</body>
</html>