<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subject.css">

<!-- 금학기 -->
<style>
.sub--list--table th {
	padding: 1px 25px;
}

.sub--list--name {
	padding: 1px 20px 1px 9px !important;
}
</style>
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>성적</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/grade/thisSemester"
						class="selected--menu">금학기 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/semester">학기별 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/total">누계 성적</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>

		<h1>금학기 성적 조회</h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->

		<%-- <<<<<<< HEAD
		<!-- 필터 및 검색 -->
		<c:choose>
		<c:when test="${not empty evaluationList}">
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>연도</th>
					<th>학기</th>
					<th>과목번호</th>
					<th>과목명</th>
					<th>강의구분</th>
					<th>이수학점</th>
					<th>성적</th>
					<th>강의평가</th>
				</tr>
			</thead>

			<tbody>
			<c:forEach var="list" items="${stuSubDetail}">
				<tr>
						<td><c:out value="${list.subYear}"></c:out></td>
						<td><c:out value="${list.semester}"></c:out></td>
						<td><c:out value="${list.subjectId}"></c:out></td>
						<td><c:out value="${list.subjectName}"></c:out></td>
						<td><c:out value="${list.type}"></c:out></td>
						<td><c:out value="${list.grades}"></c:out></td>
						<td><c:out value="${list.grade}"></c:out></td>
						<td><a href="강의평가"></a></td>
				</tr>
			</c:forEach>
			
					</tbody>
				</table>
			</c:when>
 			<c:when test="${empty evaluationList}">
				<p class="no--list--p">강의 신청 및 수강 이력 확인 바랍니다.</p>
			</c:when>
		</c:choose> 
	</main>
======= --%>


		<div>
			<h4 style="font-weight: 600">과목별 성적</h4>
			<c:if test="${gradeList != null}">
			<table border="1" class="sub--list--table">
				<thead>
					<tr>
						<th>연도</th>
						<th>학기</th>
						<th>과목번호</th>
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
						<td>${grade.subjectId}</td>
						<td class="sub--list--name">${grade.name}</td>
						<td>${grade.type}</td>
						<td>${grade.grade}</td>
						<td>${grade.gradeValue}</td>
						<td><a
							href="/chelseaUniversity/grade/evaluation?subjectId=${grade.subjectId}"
							onclick="window.open(this.href, '_blank', 'width=720, height=1000'); return false;">Click</a>
						</td>
					</tr>
			</c:forEach>
				</tbody>
			</table>
				</c:if>
				<c:if test="${gradeList == null}">
					<br><h3>금학기 들은 과목이 없습니다.</h3><br>
				</c:if>
			<p style="color: #888; margin-bottom: 40px;">※ 강의 평가 후 성적 조회 가능</p>
		</div>
		<hr>
		<br>
		<div>
			<h4 style="font-weight: 600">누계 성적</h4>
			<c:if test="${myGrade != null}">
			<table border="1" class="sub--list--table">
				<thead>
					<tr>
						<th>연도</th>
						<th>학기</th>
						<th>신청학점</th>
						<th>취득학점</th>
						<th>평점평균</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${myGrade.subYear}</td>
						<td>${myGrade.semester}</td>
						<td>${myGrade.sumGrades}</td>
						<td>${myGrade.myGrades}</td>
						<td>${myGrade.average}</td>
					</tr>
				</tbody>
			</table>
					</c:if>
			<c:if test="${myGrade == null}">
					<br><h3>금학기 들은 과목이 없습니다.</h3><br>
					</c:if>
		</div>


		<!-- <h1>금학기 성적 조회</h1>
		<div class="split--div"></div>

		<p class="no--list--p">강의 신청 및 수강 이력 확인 바랍니다.</p> -->
	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</body>
</html>