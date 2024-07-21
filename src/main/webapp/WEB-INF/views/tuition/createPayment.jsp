<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>

<main>
	<h1>등록금 고지서</h1>

	<form action="${pageContext.request.contextPath}/tuition/create" method="post">
		<button type="submit">등록금 고지서 발송</button>
	</form>
	<c:if test="${not empty insertCount}">
		<%
		out.println(
				"<script>alert('" + request.getAttribute("insertCount") + "개의 등록금 고지서가 생성되었습니다.'); history.back(); </script>");
		%>
	</c:if>
</main>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>
