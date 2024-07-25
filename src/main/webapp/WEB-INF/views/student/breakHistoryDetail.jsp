<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/myinfo.css">
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/user/myinfo">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/application">휴학 신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/list"
						class="selected--menu">휴학 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/list">등록금 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/payment">등록금 납부
							고지서</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>휴학 내역 조회</h1>
		<div class="split--div"></div>

		<div class="d-flex flex-column align-items-center" style="width: 100%">
			<div class="document--layout">
				<h3>휴학 신청서</h3>
				<table border="1">
					<tr>
						<th>단 과 대</th>
						<td>${principal.collegeName}</td>
						<th>학 과</th>
						<td>${principal.deptName}</td>
					</tr>
					<tr>
						<th>학 번</th>
						<td>${principal.id}</td>
						<th>학 년</th>
						<td>${principal.grade}학년</td>
					</tr>
					<tr>
						<th>전 화 번 호</th>
						<td>${principal.tel}</td>
						<th>성 명</th>
						<td>${principal.name}</td>
					</tr>
					<tr>
						<th>주 소</th>
						<td colspan="3">${principal.address}</td>
					</tr>
					<tr>
						<th>기 간</th>
						<td colspan="3">${app.fromYear}년도&nbsp;${app.fromSemester}학기부터&nbsp; ${app.toYear}년도&nbsp;${app.toSemester}학기까지</td>
					</tr>
					<tr>
						<th>휴 학 구 분</th>
						<td colspan="3">${app.type}휴학</td>
					</tr>
					<tr>
						<td colspan="4">
							<p>위와 같이 휴학하고자 하오니 허가하여 주시기 바랍니다.</p> <br>
							<p>${app.appDate}</p>
						</td>
					</tr>
				</table>
			</div>




			<form action="/chelseaUniversity/break/delete?id=${app.id}" method="post"
				class="d-flex flex-column align-items-center">
				<button type="submit" class="btn btn-dark"
					onclick="return confirm('신청을 취소하시겠습니까?')">취소하기</button>
			</form>





		</div>
	</main>
</div>



<footer>
	<!-- 필요 시 -->
</footer>

</div>
</body>
</html>