<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<h1><c:out value="내 강의 평가"></c:out></h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->

		<!-- 필터 및 검색 -->
		<c:choose>
		<c:when test="${not empty evaluationList}">
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>과목 이름</th>
					<th>총 평가 점수</th>
					<th>건의 사항</th>
				</tr>
			</thead>

			<tbody>
			<c:forEach var="evaluation" items="${evaluationList}">
				<tr>
						<td><c:out value="${evaluation.subjectName}"></c:out></td>
						<td><fmt:formatNumber value="${evaluation.totalScore/7}" type="number" maxFractionDigits="1" /></td>
						<td><c:out value="${evaluation.suggestions}"></c:out></td>
				</tr>
			</c:forEach>
			
					</tbody>
				</table>
			</c:when>
 			<c:when test="${empty evaluationList}">
				<h3 style="color: grey;">조회할 강의 평가가 존재하지 않습니다.</h3>
			</c:when>
		</c:choose> 
	</main>
</div>
</body>
</html>