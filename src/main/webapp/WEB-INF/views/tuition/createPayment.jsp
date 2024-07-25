<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<td><a href="/chelseaUniversity/tuition/bill" class="selected--menu">등록금 고지서 발송</a></td>
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

<main>
	<h1>등록금 고지서</h1>

	<form action="${pageContext.request.contextPath}/tuition/create" method="post">
		<button type="submit">등록금 고지서 발송</button>
	</form>
	<c:if test="${not empty insertCount}">
		<%
		out.println(
				"<script>alert('" + request.getAttribute("insertCount") + "개의 등록금 고지서가 생성되었습니다.'); history.back(); </script>");
		%>
	</c:if>
</main>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>
