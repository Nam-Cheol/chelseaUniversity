<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%
	
%>
<div class="media">
<div class="main">
	<img src="${pageContext.request.contextPath}/resources/img/stampord.jpg" alt="스탬포드 브릿지"
	class="stampord">
<div class="notice">
	<h2>공지사항</h2>
	<hr width ="100%" align ="left" color = blue>
	<c:forEach var="notice" items="${notice}">
	<b><p>${notice.category} <a href="/schedule/detail?id=${notice.id}" class="title">${notice.title}</a></b> <fmt:formatDate value="${notice.createdTime}" pattern="YYYY-MM-dd" /></p>
	</c:forEach>
</div>
<div class="schedule">
	<h2>학사일정</h2>
	<hr width ="100%" align ="left" color = blue>
	<c:forEach var="schedule" items="${schedule}">
	<p><fmt:formatDate value="${schedule.startDay}" pattern="MM-dd" /> -
	<fmt:formatDate value="${schedule.endDay}" pattern="MM-dd" />
	<b><span class="information">${schedule.information}</span></b></p>
	</c:forEach>
</div>
	<c:choose>
	<c:when test="${user.userRole eq 'student'}">
	<div class="student">
	<p><img src="${pageContext.request.contextPath}/resources/img/man.png"> <b>${principal.name}님, 환영합니다.</b></p>
	<hr width ="100%" align = "left" color = blue size="0.5px">
	<p><span class="label">이메일</span>    <span class="status-container"><span class="status">${principal.email}</span></span></p>
	<p><span class="label">소속</span>    <span class="status-container"><span class="status">${principal.deptName}</span></span></p>
	<p><span class="label">학기</span>    <span class="status-container"><span class="status">${principal.grade}학년 ${principal.semester}학기</span></span></p>
	<p><span class="label">학적상태</span>  <span class="status-container"><span class="status">${status.status}</span></span></p>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/${user.userRole}/info'">마이페이지</button>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/user/signin?logout=true'">로그아웃</button>
	</div>
	</c:when>
	<c:when test="${user.userRole eq 'professor'}">
	<div class="professor">
	<p><img src="${pageContext.request.contextPath}/resources/img/man.png"> <b>${principal.name}님, 환영합니다.</b></p>
	<hr width ="100%" align = "left" color = blue size="0.5px">
	<p><span class="label">이메일</span>    <span class="status-container"><span class="status">${principal.email}</span></span></p>
	<p><span class="label">소속</span>    <span class="status-container"><span class="status">${deptname} 교수</span></span></p>
	</div>
	</c:when>
	<c:when test="${user.userRole eq 'staff'}">
	<div class="staff">
	<p><img src="${pageContext.request.contextPath}/resources/img/man.png"> <b>${principal.name}님, 환영합니다.</b></p>
	<hr width ="100%" align = "left" color = blue size="0.5px">
	<p><span class="label">이메일</span>    <span class="status-container"><span class="status">${principal.email}</span></span></p>
	<p><span class="label">소속</span>    <span class="status-container"><span class="status">교직원</span></span></p>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/${user.userRole}/info'">마이페이지</button>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/user/signin?logout=true'">로그아웃</button>
	</div>
	<div class="alarm">
	<p><img src="${pageContext.request.contextPath}/resources/img/man2.png"> <b>업무 알림</b>
	<p>처리해야 할 업무가 없습니다.</p>
	</div>
	</c:when>
	</c:choose>
</div>
</div>
</body>
</html>