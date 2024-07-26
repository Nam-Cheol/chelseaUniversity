<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myinfo.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
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
					<td><a href="/chelseaUniversity/user/password">비밀번호 변경</a></td>
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
					<td><a href="/chelseaUniversity/tuition/payment"
						class="selected--menu">등록금 납부 고지서</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<c:choose>
			<c:when test="${checkTuition}">
			<h1>등록금 납부 고지서</h1>
			<div class="split--div"></div>

			<div class="d-flex flex-column align-items-center"
				style="width: 100%">
				<div class="document--layout">
					<h3>등록금 고지서</h3>
					<p>2023년도 1학기</p>
					<table class="tuition--payment--table" border="1">
						<thead>
							<tr>
								<th>단 과 대</th>
								<td>${principal.collegeName}</td>
								<!-- 여기 고쳐야 함 !  -->
								<th>학 과</th>
								<td>${principal.deptName}</td>
								<!-- 여기 고쳐야 함 !  -->
							</tr>
							<tr>
								<th>학 번</th>
								<td>${principal.id}</td>
								<th>성 명</th>
								<td>${principal.name}</td>
								<!-- 여기 고쳐야 함 !  -->
							</tr>
						</thead>
						<tbody>
							<tr>
								<th colspan="2">장 학 유 형</th>
								<td colspan="2">${tuition.schType}유형</td>
							</tr>
							<tr>
								<th colspan="2">등 록 금</th>
								<td colspan="2">${tuition.tuiFormat()}</td>
							</tr>
							<tr>
								<th colspan="2">장 학 금</th>
								<td colspan="2">${tuition.schFormat()}</td>
							</tr>
							<tr>
								<th colspan="2">납 부 금</th>
								<td colspan="2">${tuition.paymentFormat()}</td>
							</tr>
							<tr>
								<th colspan="2">납 부 계 좌</th>
								<td colspan="2">그린은행 483-531345-536</td>
							</tr>
							<tr>
								<th colspan="2">납 부 기 간</th>
								<td colspan="2">~ 2023.05.02</td>
							</tr>

						</tbody>
					</table>
				</div>
				
				<c:choose>

				<c:when test="${tuition.status == false}">
				<form action="/chelseaUniversity/tuition/payment?tuiYear=${tuition.tuiYear}&semester=${tuition.semester}" method="post">
					<button type="submit" class="btn btn-dark"
						onclick="return confirm('등록금을 납부하시겠습니까?')">납부하기</button>
				</form>
				</c:when>
				<c:otherwise>
						<p class="no--list--p">이번 학기 등록금 납부가 완료되었습니다.</p>
				</c:otherwise>
				</c:choose>
			</div>
			</c:when>
			<c:otherwise>
				 <script type='text/javascript'>
				 	 alert('등록금 납부 기한이 아닙니다.');
				     window.location.href = 'list';
				 </script>
			</c:otherwise>
		</c:choose>
	</main>
</div>



<footer>
	<!-- 필요 시 -->
</footer>

</div>

</body>
</html>
