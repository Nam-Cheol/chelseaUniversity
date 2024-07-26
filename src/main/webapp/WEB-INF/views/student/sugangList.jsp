<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
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
					<td><a href="/chelseaUniversity/sugang/subjectList?page=1">강의
							시간표 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/pre?page=1">예비 수강
							신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/preAppList?page=1"
						class="selected--menu">수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/list?page=1">수강 신청 내역 조회</a></td>
				</tr>
			</table>
		</div>
	</div>
	
	<!-- 메인 div -->
	<main>
		<h1>수강 신청</h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->
		<div class="d-flex justify-content-between align-items-start"
			style="width: 100%">
			<div>

				<h4>
					<span style="font-weight: 600;"> 신청 미완료 강의 목록 </span>&nbsp;
				</h4>
				<!-- 
						 수강신청 해야되는 과목
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

						<tr>
							<td>10000</td>
							<td class="sub--list--name">데이터통신</td>
							<td>김근호</td>
							<td>3</td>
							<td>월 14:00-17:00&nbsp;(E601)</td>
							<td>0</td>
							<td>5</td>
							<td class="sub--list--button--row">



								<form action="/sugang/insertApp/10000?type=1" method="post">
									<button type="submit" style="background-color: #548AC2;">신청</button>
								</form>


							</td>
						</tr>

					</tbody>
				</table>
				<br>
				<br> -->


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
						<c:forEach var="hitory" items="${historyList}">
						<tr>
							<td>${hitory.id}</td>
							<td class="sub--list--name">${hitory.title}</td>
							<td>${hitory.professorName}</td>
							<td>${hitory.grades}</td>
							<td>${hitory.subDay}&nbsp;${hitory.startTime}:00-${hitory.endTime}:00&nbsp;(${hitory.roomId})</td>
							<td>${hitory.numOfStudent}</td>
							<td>${hitory.capacity}</td>
							<td class="sub--list--button--row">
								<form action="/chelseaUniversity/sugang/delete" method="get">
									<input type="hidden" name="_method" value="delete">
									<button type="submit"
										onclick="return confirm('수강신청을 취소하시겠습니까?');"
										style="background-color: #a7a7a7;">취소</button>
								</form>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<!-- 강의 검색으로 가기 -->

			<a href="/chelseaUniversity/sugang/application">
			<button class="preStuSubList--button">강의 검색</button>
			</a>
		</div>

	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</div>
</body>
</html>