<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subject.css">
	
	<!-- 금학기 -->
<style>
.sub--list--table th {
	padding: 1px 25px;
}

.sub--list--name {
	padding: 1px 20px 1px 9px !important;
}
</style>
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display:flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>성적</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/grade/thisSemester"
						class="selected--menu">금학기 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/semester">학기별 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/total">누계 성적</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>금학기 성적 조회</h1>
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
				<p class="no--list--p">강의 신청 및 수강 이력 확인 바랍니다.</p>
			</c:when>
		</c:choose> 
	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</div>
</body>
</html>