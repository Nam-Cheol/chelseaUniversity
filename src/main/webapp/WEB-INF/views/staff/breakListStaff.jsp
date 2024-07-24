<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>

<main>
	<h1>휴학 처리</h1>

	<table>
		<thead>
			<tr>
				<th>신청일자</th>
				<th>신청자 학번</th>
				<th>구분</th>
				<th>시작학기</th>
				<th>종료학기</th>
				<th>신청서 확인</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="breakAppList" items="${breakAppList}">
				<tr>
					<td>${breakAppList.appDate}</td>
					<td>${breakAppList.studentId}</td>
					<td>${breakAppList.type}휴학</td>
					<td>${breakAppList.fromYear}년도${breakAppList.fromSemester}학기</td>
					<td>${breakAppList.toYear}년도${breakAppList.toSemester}학기</td>
					<td><a href="${pageContext.request.contextPath}/break/breakDetail?id=${breakAppList.id}">Click</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:if test="${not empty acceptBreak}">
		<%
		out.println(
				"<script>alert('" + request.getAttribute("acceptBreak") + "휴학 승인처리 되었습니다.'); history.back(); </script>");
		%>
	</c:if>

</main>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>