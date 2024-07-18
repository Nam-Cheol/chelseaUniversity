<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/info/student" class="selected--menu">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/break/application">휴학 신청</a></td>
				</tr>
				<tr>
					<td><a href="/break/list">휴학 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/list">등록금 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/payment">등록금 납부 고지서</a></td>
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
					<th>학번</th>
					<td></td>
					<th>소속</th>
					<td>1</td>
				</tr>
				<tr>
					<th>학년</th>
					<td></td>
					<th>학기</th>
					<td></td>
				</tr>
				<tr>
					<th>입학일</th>
					<td></td>
					<th>졸업일(졸업예정일)</th>
					<td></td>
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
					<td></td>
					<th>생년월일</th>
					<td></td>
				</tr>
				<tr>
					<th>성별</th>
					<td></td>
					<th>주소</th>
					<td></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td></td>
					<th>email</th>
					<td></td>
				</tr>
			</table>
			<button type="button" onclick="location.href='/update'" class="btn btn-dark update--button">수정하기</button>
			<hr>
			<h4>
				<span style="font-weight: 600;">학적 변동 내역</span>
			</h4>
			<table border="1" class="stat--table">
				<thead>
					<tr>
						<th>변동 일자</th>
						<th>변동 구분</th>
						<th>세부</th>
						<th>승인 여부</th>
						<th>복학 예정 연도/학기</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			
	</main>
</div>



  		<footer>
			<!-- 필요 시 -->
		</footer>

</div>
</body>
</html>