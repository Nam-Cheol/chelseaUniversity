<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>


		<!-- 세부 메뉴 + 메인 -->
		<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
			<!-- 세부 메뉴 div-->
			<div class="sub--menu">
				<div class="sub--menu--top">
					<h2>MY</h2>
				</div>
				<!-- 메뉴 -->
				<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
				<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tbody><tr>
					<td><a href="/chelseaUniversity/user/studentList">학생 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/professorList">교수 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/student">학생 등록</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/professor">교수 등록</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/bill">등록금 고지서 발송</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/list/staff">휴학 처리</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/period">수강신청 기간 설정</a></td>
				</tr>
			</tbody></table>
				</div>
			</div>

<h1>휴학 처리</h1>

<table>
	<tr>
		<th>단과대</th>
		<td>${college.name}</td>
		<th>학과</th>
		<td>${deptInfo.name}</td>
	</tr>
	<tr>
		<th>학번</th>
		<td>${studentInfo.id}</td>
		<th>학년</th>
		<td>${studentInfo.grade}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${studentInfo.tel}</td>
		<th>성명</th>
		<td>${studentInfo.name}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${studentInfo.address}</td>
	</tr>
	<tr>
		<th>기간</th>
		<td>${breakApp.fromYear}년도${breakApp.fromSemester}학기부터${breakApp.toYear}년도 ${breakApp.toSemester}학기까지</td>
	</tr>
	<tr>
		<th>휴학 구분</th>
		<td>${breakApp.type}휴학</td>
	</tr>
	<tr>
		<p>위와 같이 휴학하고자 하오니 허가하여 주시기 바랍니다.</p>
	</tr>
</table>

<form action="${pageContext.request.contextPath}/break/update?id=${breakApp.id}" method="post">
	<input type="hidden" name="status" value="승인">
	<button type=submit>승인하기</button>
</form>

<form action="${pageContext.request.contextPath}/break/update?id=${breakApp.id}" method="post">
	<input type="hidden" name="status" value="반려">
	<button type=submit>반려하기</button>
</form>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>