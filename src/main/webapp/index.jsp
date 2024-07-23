<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</div>
<div class="notice">
	<h2>공지사항</h2>
	<hr width ="90%" align ="left" color = blue>
	<c:forEach var="notice" items="${notice}">
	<p>${notice.category} ${notice.title} ${notice.createdTime}</p>
	</c:forEach>
</div>
<div class="schedule">
	<h2>학사일정</h2>
	<hr width ="80%" align ="left" color = blue>
</div>
<div class="interface">
	<p>${principal.name}님,환영합니다.</p>
</div>
</div>
</body>
</html>