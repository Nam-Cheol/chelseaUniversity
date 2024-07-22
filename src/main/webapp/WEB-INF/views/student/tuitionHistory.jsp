<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<td><a href="/chelseaUniversity/student/info">내 정보 조회</a></td>
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
					<td><a href="/chelseaUniversity/tuition/list"
						class="selected--menu">등록금 내역 조회</a></td>
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
		<h1>등록금 내역 조회</h1>
		<c:choose>
			<c:when test="${check}">
				<table border="1" class="list--table">
					<thead>
						<tr>
							<th>등록연도</th>
							<th>등록학기</th>
							<th>장학금 유형</th>
							<th>등록금</th>
							<th>장학금</th>
							<th>납입금</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="tuition" items="${tuitionList}">
							<tr>
								<td>${tuition.tuiYear}년</td>
								<td>${tuition.semester}학기</td>
								<td>${tuition.schType}유형</td>
								<td>${tuition.tuiFormat()}</td>
								<td>${tuition.schFormat()}</td>
								<td>${tuition.paymentFormat()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="split--div"></div>

				<p class="no--list--p">등록금 납부 내역이 없습니다.</p>
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
