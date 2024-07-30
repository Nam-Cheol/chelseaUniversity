<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/professorHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/myinfo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
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
		<h1 class="sub--title"><c:out value="[${subject.name}] 학생 리스트 조회"></c:out></h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->

		<!-- 필터 및 검색 -->
		<c:choose>
	<c:when test="${not empty studentList}">
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>학생 번호</th>
					<th>이름</th>
					<th>소속</th>
					<th>결석</th>
					<th>지각</th>
					<th>과제점수</th>
					<th>중간시험</th>
					<th>기말시험</th>
					<th>환산점수</th>
					<th>점수 기입</th>
				</tr>
			</thead>

			<tbody>
			<c:forEach var="student" items="${studentList}">
				<tr>
						<td><c:out value="${student.id}"></c:out></td>
						<td><c:out value="${student.name}"></c:out></td>
						<td><c:out value="${student.deptName}"></c:out></td>
						<td><c:out value="${student.absent}"></c:out></td>
						<td><c:out value="${student.lateness}"></c:out></td>
						<td><c:out value="${student.homework}"></c:out></td>
						<td><c:out value="${student.midExam}"></c:out></td>
						<td><c:out value="${student.finalExam}"></c:out></td>
						<td><c:out value="${student.convertedMark}"></c:out></td>
						<td><a href="${pageContext.request.contextPath}/professor/manageStudent?id=${student.id}" >점수 기입</a></td>
				</tr>
			</c:forEach>
			
					</tbody>
				</table>
			</c:when>
 			<c:when test="${empty studentList}">
				<h3 style="color: grey;">해당 강의를 수강하는 학생이 존재하지 않습니다.</h3>
			</c:when>
		</c:choose>
	</main>
</div>
</body>
</html>