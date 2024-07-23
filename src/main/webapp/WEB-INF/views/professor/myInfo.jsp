<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myinfo.css">
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/student/info" class="selected--menu">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/password">비밀번호 변경</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>내 정보 조회</h1>
		<div class="split--div"></div>
			<table border="1" class="input--table" >
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
				<tr>
					<th>ID</th>
					<td>${principal.id}</td>
					<th>소속</th>
					<td>${principal.deptName}</td>
				</tr>
			</table>
			<table border="1" class="input--table" >
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
				<tr>
					<th>성명</th>
					<td>${principal.name}</td>
					<th>생년월일</th>
					<td>${principal.birthDate}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${principal.gender}</td>
					<th>주소</th>
					<td>${principal.address}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${principal.tel}</td>
					<th>email</th>
					<td>${principal.email}</td>
				</tr>
			</table>
			<button type="button" onclick="location.href='/update'" class="btn btn-dark update--button">수정하기</button>
			<hr>
	</main>
</div>



  		<footer>
			<!-- 필요 시 -->
		</footer>

</body>
</html>