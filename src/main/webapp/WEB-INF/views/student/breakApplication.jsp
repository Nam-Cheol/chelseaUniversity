<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/document.css">

<style>
.document--layout h3 {
	font-weight: 600;
	margin-bottom: 30px;
}

.document--layout tr:last-of-type td {
	padding: 18px 8px 2px;
}
</style>

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
					<td><a href="/chelseaUniversity/student/info">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/application" class="selected--menu">휴학 신청</a></td>
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
			</tbody></table>
				</div>
			</div>
			
			<!-- 메인 div -->
			<main>
				<h1>휴학 신청</h1>
				<div class="split--div"></div>
				
				<div class="d-flex flex-column align-items-center" style="width: 100%">
					<form action="/break/application" method="post" class="d-flex flex-column align-items-center">
						<div class="document--layout">
							<h3>휴학 신청서</h3>
							<table border="1">
								<tbody><tr>
									<th>단 과 대</th>
									<td>공과대학</td>
									<th>학 과</th>
									<td>컴퓨터공학과</td>
								</tr>
								<tr>
									<th>학 번</th>
									<td>2023000001</td>
									<th>학 년</th>
									<td>1학년
										<input type="hidden" name="studentGrade" value="1">
									</td>
								</tr>
								<tr>
									<th>전 화 번 호</th>
									<td>010-5267-1815</td>
									<th>성 명</th>
									<td>박시우</td>
								</tr>
								<tr>
									<th>주 소</th>
									<td colspan="3">부산시 남구</td>
								</tr>
								<tr>
									<th>기 간</th>
									<td colspan="3">
										2023년도 1학기부터
										&nbsp;
										<select name="toYear">
											<option value="2023" selected="">2023
											</option><option value="2024">2024
											</option><option value="2025">2025
										</option></select>년도
										<select name="toSemester">
											<option value="1">1
											</option><option value="2" selected="">2
										</option></select>학기까지
									</td>
								</tr>
								<tr>
									<th>휴 학 구 분</th>
									<td colspan="3">
										<input type="radio" name="type" value="일반" id="일반" checked=""> <label for="일반" style="margin: 0">일반휴학</label>
										&nbsp;
										<input type="radio" name="type" value="임신·출산·육아" id="임신"> <label for="임신" style="margin: 0">임신·출산·육아휴학</label>
										&nbsp;
										<input type="radio" name="type" value="질병" id="질병"> <label for="질병" style="margin: 0">질병휴학</label>
										&nbsp;
										<input type="radio" name="type" value="창업" id="창업"> <label for="창업" style="margin: 0">창업휴학</label>
										&nbsp;
										<input type="radio" name="type" value="군입대" id="군입대"> <label for="군입대" style="margin: 0">군입대휴학</label>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<p>위와 같이 휴학하고자 하오니 허가하여 주시기 바랍니다.</p>									
										<br>
										<p>2024년 07월 19일</p>
									</td>
								</tr>
							</tbody></table>
						</div>
						<button type="submit" class="btn btn-dark" onclick="return confirm('휴학을 신청하시겠습니까?')">신청하기</button>
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