<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subject.css">
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>수강신청</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/sugang/subjectList">강의
							시간표 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/pre"
						class="selected--menu">예비 수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/preAppList">수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/list">수강 신청 내역 조회</a></td>
				</tr>
			</table>
		</div>
	</div>


</div>
</body>
</html>