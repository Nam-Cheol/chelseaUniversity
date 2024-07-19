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
					<td><a href="/chelseaUniversity/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/application">휴학 신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/list">휴학 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/list">등록금 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/payment">등록금 납부 고지서</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>휴학 내역 조회</h1>
		<div class="split--div"></div>

			
				
					<table border="1" class="list--table">
						<thead>
							<tr>
								<th>신청일자</th>
								<th>구분</th>
								<th>시작학기</th>
								<th>종료학기</th>
								<th>신청서 확인</th>
								<th>상태</th>
							</tr>
						</thead>

						<tbody>
							
								<tr>
									<td>2024-07-19</td>
									<td>일반휴학</td>
									<td>2023년도&nbsp;1학기</td>
									<td>2023년도&nbsp;2학기</td>
									<td><a href="/break/detail/2">Click</a></td>
									<td>
											
												<span style="color: #767676; font-weight: 600">처리중</span>
											
											
											
										</td>
								</tr>
							
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