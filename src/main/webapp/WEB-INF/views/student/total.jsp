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
					<td><a href="/chelseaUniversity/grade/thisSemester">금학기
							성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/semester">학기별 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/grade/total"
						class="selected--menu">누계 성적</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>총 누계 성적</h1>
		<div class="split--div"></div>

		<p class="no--list--p">강의 신청 및 수강 이력 확인 바랍니다.</p>
		
		<!-- <h1>총 누계 성적</h1>
		<div class="split--div"></div>
		
			
				<h4 style="font-weight: 600">평점 평균</h4>
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
								<td>2023년</td>
								<td>1학기</td>
								<td>14</td>
								<td></td>
								<td>0.00</td>
							</tr>
						
					</tbody>
				</table> -->

	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</div>
</body>
</html>
