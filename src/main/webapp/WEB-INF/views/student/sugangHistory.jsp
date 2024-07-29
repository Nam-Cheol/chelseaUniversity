<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subject.css">
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2 style="color: white;">수강신청</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/sugang/subjectList?page=1">강의
							시간표 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/pre?page=1">예비 수강
							신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/appList?page=1">수강
							신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/list?page=1"
						class="selected--menu">수강 신청 내역 조회</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>수강 신청 내역 조회</h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->
		<div style="width: 100%">

			<c:if test="${!successCheck}">
				<h4>
					<span style="font-weight: 600;">신청 내역</span>&nbsp; <span
						style="color: gray; font-size: 18px;">[총 ${totalGrade}학점]</span>
				</h4>
				<table border="1" class="sub--list--table">
					<thead>
						<tr>
							<th>학수번호</th>
							<th style="width: 250px;">강의명</th>
							<th>담당교수</th>
							<th>학점</th>
							<th>요일시간 (강의실)</th>
							<th>현재인원</th>
							<th>정원</th>
							<th>수강신청</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="successSub" items="${successSubList}">
							<tr>
								<td>${successSub.id}</td>
								<td class="sub--list--name">${successSub.title}</td>
								<td>${successSub.professorName}</td>
								<td>${successSub.grades}</td>
								<td>${successSub.subDay}&nbsp;${successSub.startTime}:00-${successSub.endTime}:00&nbsp;(${successSub.roomId})</td>
								<td>${successSub.numOfStudent}</td>
								<td>${successSub.capacity}</td>
								<td class="sub--list--button--row">
									<form action="/chelseaUniversity/sugang/deleteSugang"
										method="get">
										<button type="submit" value="${successSub.id}" name="id"
											onclick="return confirm('수강신청을 취소하시겠습니까?');"
											style="background-color: #a7a7a7;">취소</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${successCheck}">
				<p
					style="font-size: 18px; color: #666666; font-weight: bold; text-align: center; margin-top: 20px; background-color: #f9f9f9; padding: 10px; border-radius: 5px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
					수강 신청 내역이 존재하지 않습니다.</p>
			</c:if>

		</div>

	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</div>
</body>
</html>