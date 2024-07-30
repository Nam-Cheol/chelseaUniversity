<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${principal == null}"><% response.sendRedirect(request.getContextPath()+"/user/signin"); %></c:if>
<c:choose>
<c:when test="${user.userRole eq 'staff'}">
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
</c:when>
<c:when test="${user.userRole eq 'professor'}">
<%@ include file="/WEB-INF/views/home/professorHeader.jsp" %>
</c:when>
<c:otherwise>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>
</c:otherwise>
</c:choose>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/notice.css">
<style>
.select--button {
	margin-left: 350px;
}
</style>
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사정보</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/notice/list?page=0">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/schedule/list" class="selected--menu">학사일정</a></td>
				</tr>
				<c:if test="${user.userRole eq 'staff'}">
					<tr>
						<td><a href="/chelseaUniversity/notice/createNotice"> 공지사항 등록</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/admin/schedule">학사일정 등록</a></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>

	<main>
		<h1 class="sub--title">학사일정</h1>
			<div class="split--div"></div>
		<div class="container">
					<c:forEach var="schedule" items="${scheduleList}">
			<table class="room--table">
				<tbody>
					<tr>
						<td class="year" width="100px;">2024년</td>
						<td class="month"><fmt:formatDate value="${schedule.startDay}" pattern="MM-dd" />
						~<fmt:formatDate value="${schedule.endDay}" pattern="MM-dd" /></td>
						<td class="information"> ${schedule.information}</td>
					</tr>
				</tbody>
			</table>
					</c:forEach>
		</div>
	</main>




</div>

     <%@ include file="footer.jsp"%>
