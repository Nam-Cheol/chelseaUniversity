<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/professorHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/myinfo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>수업</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/subject/list"
						class="selected--menu">전체 강의 조회</a></td>
				</tr>
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/professor/subject"
							class="selected--menu">내 강의 조회</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/professor/evaluationList"
							class="selected--menu">내 강의 평가</a></td>
					</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1><c:out value="학생 성적 기입"></c:out></h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->
		<table border="1">
			<thead>
				<tr>
					<th>학생 번호</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${student.id}"></c:out></td>
					<td><c:out value="${student.name}"></c:out></td>
				</tr>
			</tbody>
		</table>
		<br><br>
		<form action="${pageContext.request.contextPath}/professor/manageStudent?id=${param.id}" method="post">
			<input type="hidden" name="subjectId" id="subjectId" value="${student.subjectId}">
			<table>
				<tbody>
					<tr>
						<td>결석</td>
						<td><input type="number" name="absent" id="absent" required="required"></td>
					</tr>
					<tr>
						<td>지각</td>
						<td><input type="number" name="lateness" id="lateness" required="required"></td>
					</tr>
					<tr>
						<td>과제점수</td>
						<td><input type="number" name="homework" id="homework" required="required"></td>						
					</tr>
					<tr>
						<td>중간시험</td>
						<td><input type="number" name="midExam" id="midExam" required="required"></td>
					</tr>
					<tr>
						<td>기말시험</td>
						<td><input type="number" name="finalExam" id="finalExam" required="required"></td>
					</tr>
					<tr>
						<td>환산점수</td>
						<td><input type="number" name="convertedMark" id="convertedMark" required="required"></td>
					</tr>
					<tr>
						<td>등급</td>
						<td><select name="grade">
							<option value="A+">A+</option>
							<option value="A0">A0</option>
							<option value="B+">B+</option>
							<option value="B0">B0</option>
							<option value="C+">C+</option>
							<option value="C0">C0</option>
							<option value="D+">D+</option>
							<option value="D0">D0</option>
							<option value="F">F</option>
						</select></td>
					</tr>
					<tr>
						<td><button class="btn btn-edit" type="submit">수정</button></td>
					</tr>
				</tbody>
			</table>
		</form>
		<!-- 필터 및 검색 -->
	</main>
</div>
</body>
</html>