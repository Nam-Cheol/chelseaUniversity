<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
			<tbody>
				<tr>
					<td><a href=${pageContext.request.contextPath}/subject/list>전체 강의 조회</a></td>
					<td><a href=${pageContext.request.contextPath}/professor/subject>내 강의 조회</a></td>
					<td><a href=${pageContext.request.contextPath}/evaluation/read>내 강의 평가</a></td>
				</tr>
			</tbody>
		</table>
		<table border="1">
			<tbody>
				<tr>
					<th>연도/학기</th>
					<th>단과대학</th>
					<th>개설학과</th>
					<th>학수번호</th>
					<th>강의구분</th>
					<th>강의명</th>
					<th>담당교수</th>
					<th>학점</th>
					<th>수강인원</th>
					<th>정원</th>
					<th>강의계획서</th>
				</tr>
				<c:forEach var="subject"  items="${subjectList}">
					<tr>
						<th></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>