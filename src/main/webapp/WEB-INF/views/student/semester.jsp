<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subject.css">

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
					<td><a href="/chelseaUniversity/grade/thisSemester">금학기 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/semester" class="selected--menu">학기별
							성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/total">누계 성적</a></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 메인 div -->
	<main>
		<h1>학기별 성적 조회</h1>
		<form action="${pageContext.request.contextPath}/grade/semester" method="post">
		<div class="split--div"></div>
		<div class="search" style="margin-bottom:10px;">
		<select name="year">
			<option value="2021">2021년</option>
			<option value="2022">2022년</option>
			<option value="2023" selected>2023년</option>
			<option value="2024">2024년</option>
			</select>
		<select name="semester">
			<option value="1" selected>1학기</option>
			<option value="2">2학기</option>
			</select>
		<input type="submit" value="검색" style="width:40px">
		</div>
		</form>
		<div>
			<h4 style="font-weight: 600">과목별 성적</h4>
			<c:if test="${gradeList != null}">
			<table border="1" class="sub--list--table">
				<thead>
					<tr>
						<th>연도</th>
						<th>학기</th>
						<th>과목명</th>
						<th>강의구분</th>
						<th>이수학점</th>
						<th>성적
						<th>강의평가
					</tr>
				</thead>
				<tbody>
			<c:forEach var="grade" items="${gradeList}">
					<tr>
						<td>${grade.subYear}</td>
						<td>${grade.semester}</td>
						<td class="sub--list--name">${grade.name}</td>
						<td>${grade.type}</td>
						<td>${grade.grade}</td>
						<td>
						<c:set var="subjectExists" value="false" />
                	<c:forEach var="evaluation" items="${evaluation}">
                    <c:if test="${evaluation.subjectId == grade.subjectId}">
                        <c:set var="subjectExists" value="true" />
                    </c:if>
                	</c:forEach>
                	<c:choose>
                    <c:when test="${!subjectExists}">
                    </c:when>
                    <c:otherwise>
                    	${grade.gradeValue}
                    </c:otherwise>
                    </c:choose>
                    </td>
						<td>
                	<c:choose>
                    <c:when test="${!subjectExists}">
                        <a href="/chelseaUniversity/grade/evaluation?subjectId=${grade.subjectId}"
                            onclick="window.open(this.href, '_blank', 'width=720, height=1000'); return false;">Click</a>
                    </c:when>
                    <c:otherwise>
                    	평가완료
                    </c:otherwise>
                    </c:choose>
						</td>
					</tr>
			</c:forEach>
				</tbody>
			</table>
			</c:if>
			<c:if test="${gradeList == null}">
					<br><h3>해당하는 학기에 들은 과목이 없습니다.</h3><br>
				</c:if>
			</div>
	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</div>

</body>
</html>
