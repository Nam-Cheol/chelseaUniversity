<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subject.css">

<c:if test="${not empty message}">
	<script type="text/javascript">
		alert("${message}");
	</script>
</c:if>

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
					<td><a href="/chelseaUniversity/sugang/pre?page=1"
						class="selected--menu">예비 수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/appList?page=1">수강
							신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/list?page=1">수강 신청
							내역 조회</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>예비 수강 신청</h1>
		<div class="split--div"></div>

		<a href="/chelseaUniversity/sugang/preAppList">
			<button class="preStuSubList--button">신청 내역</button>
		</a>

		<!-- 필터 및 검색 -->
		<div class="sub--filter">
			<form action="${pageContext.request.contextPath}/sugang/pre"
				method="get">
				<div>
					<input type="hidden" name="page" value="1">
					<!-- 강의구분 콤보박스 -->
					<label for="type">강의구분</label> <select name="type" id="type">
						<option value="전체">전체</option>
						<option value="전공">전공</option>
						<option value="교양">교양</option>
					</select>
					<!-- 대상학과 콤보박스 -->
					<label for="deptId">개설학과</label> <select name="deptId" id="deptId">
						<option value="-1">전체</option>

						<option value="101">컴퓨터공학과</option>

						<option value="102">전자공학과</option>

						<option value="103">화학공학과</option>

						<option value="104">기계공학과</option>

						<option value="105">신소재공학과</option>

						<option value="106">철학과</option>

						<option value="107">국사학과</option>

						<option value="108">언어학과</option>

						<option value="109">국어국문학과</option>

						<option value="110">영어영문학과</option>

						<option value="111">심리학과</option>

						<option value="112">정치외교학과</option>

						<option value="113">사회복지학과</option>

						<option value="114">언론정보학과</option>

						<option value="115">인류학과</option>

						<option value="116">경영학과</option>

						<option value="117">경제학과</option>

						<option value="118">회계학과</option>

						<option value="119">농업경영학과</option>

						<option value="120">무역학과</option>

					</select>
					<!-- 강의 검색 -->
					<label for="subName">강의명</label> <input type="text" name="name"
						list="subName">
					<datalist id="subName">

						<option value="데이터통신">
						<option value="딥러닝의 기초">
						<option value="컴퓨터의 개념 및 실습">
						<option value="컴퓨터 프로그래밍">
						<option value="공학설계 입문">
						<option value="반도체 공학">
						<option value="융합전자연구">
						<option value="기초 전기실험">
						<option value="물리화학">
						<option value="반응공학">
						<option value="사고와 표현">
						<option value="과학과 기술">
						<option value="고체역학">
						<option value="자유정의진리">
						<option value="정보적 사고">
						<option value="CAD기초">
						<option value="에너지재료">
						<option value="나노재료합성">
						<option value="신소재공학개론">
						<option value="신소재기초실습">
						<option value="칸트철학">
						<option value="불교철학사">
						<option value="대륙합리론">
						<option value="심리철학">
						<option value="역사학개론">
						<option value="동아시아사">
						<option value="한국근대사">
						<option value="한국사입문">
						<option value="의미론">
						<option value="형태론">
						<option value="컴퓨터언어학">
						<option value="이태리어">
						<option value="고전문학연습">
						<option value="국어정서법">
						<option value="한국현대작가론">
						<option value="국문학개론">
						<option value="중세영문학">
						<option value="영어발달사">
						<option value="현대영국소설론">
						<option value="영문학입문">
						<option value="일반심리학">
						<option value="적응심리학">
						<option value="성격심리학">
						<option value="인지심리학">
						<option value="비교정치론">
						<option value="외교정책론">
						<option value="국제정치경제론">
						<option value="한국정치론">
						<option value="현대사회심리">
						<option value="인간행동과 사회환경">
						<option value="사회복지학개론">
						<option value="사회복지행정론">
						<option value="언론정보학개론">
						<option value="방송의이해">
						<option value="광고의이해">
						<option value="한국언론사">
						<option value="문화인류학">
						<option value="세계화와 다문화주의">
						<option value="의료인류학">
						<option value="도시와문화">
						<option value="기업경영의이해">
						<option value="경영학원론">
						<option value="마케팅의 이해">
						<option value="마케팅 조사론">
						<option value="경제학원론">
						<option value="미시경제학">
						<option value="거시경제학">
						<option value="신자유주의 경제학">
						<option value="재무회계">
						<option value="회계감사">
						<option value="원가회계">
						<option value="관리회계">
						<option value="농업생산경제학">
						<option value="농산물 가격분석">
						<option value="농산물 유통학">
						<option value="농업 정책론">
						<option value="무역상무론">
						<option value="국제경영학">
						<option value="국제무역론 입문">
						<option value="한국무역법">
					</datalist>
					<!-- 검색 버튼 -->
					<button type="submit" class="btn btn-primary mx-2">조회</button>
				</div>
			</form>
		</div>

		<h4>
			<span style="font-weight: 600;">강의 목록</span>&nbsp; <span
				style="color: gray; font-size: 18px;">[총 ${totalCount}건]</span>
		</h4>
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>단과대학</th>
					<th>개설학과</th>
					<th>학수번호</th>
					<th>강의구분</th>
					<th style="width: 200px;">강의명</th>
					<th>담당교수</th>
					<th>학점</th>
					<th>요일시간 (강의실)</th>
					<th>현재인원</th>
					<th>정원</th>
					<th>수강신청</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="subject" items="${subjectList}">
					<tr>
						<td>${subject.collegeName}</td>
						<td>${subject.deptName}</td>
						<td>${subject.id}</td>
						<td>${subject.type}</td>
						<td class="sub--list--name">${subject.name}</td>
						<td>${subject.professorName}</td>
						<td>${subject.grades}</td>
						<td>${subject.subDay}&nbsp;${subject.startTime}:00-${subject.endTime}:00&nbsp;(${subject.roomId})</td>
						<td>${subject.numOfStudent}</td>
						<td>${subject.capacity}</td>
						<td><c:set var="isEnrolled" value="false" /> <c:forEach
								var="subjectId" items="${subjectIdList}">
								<c:if test="${subjectId == subject.id}">
									<c:set var="isEnrolled" value="true" />
								</c:if>
							</c:forEach> <c:choose>
								<c:when test="${isEnrolled}">
									<form action="/chelseaUniversity/sugang/delete" method="get">
										<button type="submit" name="id" value="${subject.id}"
											onclick="return confirm('수강신청을 취소하시겠습니까?');"
											style="background-color: #a7a7a7;">취소</button>
									</form>
								</c:when>
								<c:otherwise>
									<form action="/chelseaUniversity/sugang/regist" method="get">
										<input type="hidden" name="subId" value="${subject.id}">
										<input type="hidden" name="subGrade" value="${subject.grades}">
										<input type="hidden" name="subType" value="${subject.type}">
										<input type="hidden" name="subDay" value="${subject.subDay}">
										<input type="hidden" name="startTime"
											value="${subject.startTime}"> <input type="hidden"
											name="endTime" value="${subject.endTime}">
										<button type="submit" name="id" value="${subject.id}"
											onclick="return confirm('해당 강의를 수강신청하시겠습니까?');"
											style="background-color: #548AC2;">신청</button>
									</form>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<ul class="page--list">

			<%
			int totalPage = (int) request.getAttribute("totalPage");
			for (int i = 1; i <= totalPage; i++) {
			%>
			<%
			if (request.getParameter("page") != null) {
				if (Integer.parseInt(request.getParameter("page")) == i) {
			%>
			<li><a
				href="${pageContext.request.contextPath}/sugang/pre?page=<%=i%>"
				style="font-weight: 700; color: #007bff"><%=i%></a> <%
 } else {
 %>
			<li><a
				href="${pageContext.request.contextPath}/sugang/pre?page=<%=i%>"><%=i%></a>
				<%
				}
				}
				}
				%>
		</ul>

	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</div>
</body>
</html>