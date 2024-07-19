<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>

<section>
	<h1>학생 명단 조회</h1>

	<!-- 검색 -->
	<div>
		<form action="${pageContext.request.contextPath}/user/studentList" method="get">
			<!-- <input type="text" name="limit" value="20"> -->
			<label for="dept_id">학과 번호</label> <input type="search" id="dept_id"> <label for="stu_id">학번</label> <input type="search" id="stu_id">
			<button type="submit">
				<div class="">
					<p>조회</p>
					<div>
						<img alt="" src="">
					</div>
				</div>
			</button>
			<button type="submit">
				<div class="">
					<p>새학기 적용</p>
				</div>
			</button>
		</form>
	</div>

	<!-- 학생 리스트 테이블 -->
	<div>

		<table border="1">
			<thead>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>주소</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>학과번호</th>
					<th>학년</th>
					<th>학기</th>
					<th>입학일</th>
					<th>졸업일(졸업예정일)</th>
				</tr>
			</thead>
			<c:forEach var="allStudentList" items="${allStudentList}">
				<tbody>
					<tr>
						<td>${allStudentList.id}</td>
						<td>${allStudentList.name}</td>
						<td>${allStudentList.birthDate}</td>
						<td>${allStudentList.gender}</td>
						<td>${allStudentList.address}</td>
						<td>${allStudentList.tel}</td>
						<td>${allStudentList.email}</td>
						<td>${allStudentList.deptId}</td>
						<td>${allStudentList.grade}</td>
						<td>${allStudentList.semester}</td>
						<td>${allStudentList.entranceDate}</td>
						<td>${allStudentList.graduationDate}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>

		<div class="pagination">
			<!-- index for  -->
			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${i == currentPage}">
						<span class="current-page">${i}</span>
					</c:when>
					<c:otherwise>
						<span><a href="${pageContext.request.contextPath}/user/studentList?stu_list_page=${i}">${i}</a></span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>

</section>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>