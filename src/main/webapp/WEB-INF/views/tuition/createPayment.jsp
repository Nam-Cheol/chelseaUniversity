<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>

<section>
<h1>등록금 고지서</h1>

<form action="${pageContext.request.contextPath}/tuition/create" method="post">
<button type="submit">등록금 고지서 발송</button>
</form>
</section>

<%@ include file="/WEB-INF/views/home/footer.jsp" %>
