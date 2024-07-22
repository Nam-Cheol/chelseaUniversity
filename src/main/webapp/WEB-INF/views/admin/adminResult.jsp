<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단과 생성 결과</title>
</head>
<body>
	<h2>단과 생성 결과 페이지</h2>
	<%
	String message = request.getParameter("message");
	if("create-success".equals(message)){
		out.print("<p>단과 생성 완료</p>");
	} else {
		out.print("<p>생성 실패</p>");
	}
	%>
	
	<br>
	<br>

</body>
</html>