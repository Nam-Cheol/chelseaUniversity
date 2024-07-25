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
					<td><a href="/chelseaUniversity/user/studentList" >학생 명단 조회</a></td>
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
					<td><a href="/chelseaUniversity/sugang/period" class="selected--menu">수강신청 기간 설정</a></td>
				</tr>
			</tbody></table>
				</div>
			</div>

<main>
	<h1>수강 신청 기간 설정</h1>
	<!-- 기본값 -->
	<c:if test="${SUGANG_PERIOD == 0}">
		<p>현재 예비 수강 신청 기간입니다.</p>
		<form action="${pageContext.request.contextPath}/sugang/updatePeriod1" method="post">
			<button type="submit">수강신청 기간 시작하기</button>
		</form>
	</c:if>

	<!-- 수강신청 시작 버튼 눌렀을 때 -->
	<c:if test="${SUGANG_PERIOD == 1}">
		<p>현재 수강 신청 기간입니다.</p>
		<form action="${pageContext.request.contextPath}/sugang/updatePeriod2" method="post">
			<button type="submit">수강신청 종료하기</button>
		</form>
	</c:if>

	<!-- 수강신청 종료 버튼 눌렀을 때 -->
	<c:if test="${SUGANG_PERIOD == 2}">
		<p>이번 학기 수강 신청 기간이 종료되었습니다. 예비 수강신청 기간을 시작하시겠습니까?</p>
		<form action="${pageContext.request.contextPath}/sugang/updatePeriod0" method="post">
			<button type="submit">예비수강신청 기간 시작하기</button>
		</form>
	</c:if>
</main>

</body>
</html>