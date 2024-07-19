<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<h4>강의 목록</h4>
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
				<c:forEach var="subject"  items="${classesList}">
					<tr>
						<td><c:out value="${subject.subYear}-${subject.semester}학기"></c:out></td>
						<td><c:choose>
							<c:when test="${fn:startsWith(subject.roomId, 'E')}">
								<c:out value="공과대학"></c:out>
							</c:when>
							<c:when test="${fn:startsWith(subject.roomId, 'H')}">
								<c:out value="인문대학"></c:out>
							</c:when>
							<c:when test="${fn:startsWith(subject.roomId, 'S')}">
								<c:out value="사회과학대학"></c:out>
							</c:when>
							<c:when test="${fn:startsWith(subject.roomId, 'C')}">
								<c:out value="상경대학"></c:out>
							</c:when>
						</c:choose></td>
						<td><c:out value="${subject.deptId}"></c:out></td>
						<td><c:out value="${subject.id}"></c:out></td>
						<td><c:out value="${subject.type}"></c:out></td>
						<td><c:out value="${subject.name}"></c:out></td>
						<td><c:out value="${subject.professorId}"></c:out></td>
						<td><c:out value="${subject.grades}"></c:out></td>
						<td><c:out value="${subject.numOfStudent}"></c:out></td>
						<td><c:out value="${subject.capacity}"></c:out></td>
						<td><a href="${pageContext.request.contextPath}/subject/syllabus/${subject.id}">강의계획서</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<br>
	<div class="pagination">
		<!-- index for  -->
		<c:forEach begin="1" end="${totalPages}"  var="i" >
			<c:choose>
				<c:when test="${ i == currentPage }">
					<span class="current-page" >${i}</span>
				</c:when>
				<c:otherwise>
					<span><a href="${pageContext.request.contextPath}/subject/list?page=${i}">${i}</a></span>	
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>
</body>
</html>