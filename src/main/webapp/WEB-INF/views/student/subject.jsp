<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:if test="${principal == null}">
	<%
	response.sendRedirect(request.getContextPath() + "/user/signin");
	%>
</c:if>
<c:choose>
	<c:when test="${user.userRole eq 'staff'}">
		<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>
	</c:when>
	<c:when test="${user.userRole eq 'professor'}">
		<%@ include file="/WEB-INF/views/home/professorHeader.jsp"%>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
	</c:otherwise>
</c:choose>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pagination.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/subject.css">
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>수업</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="${pageContext.request.contextPath}/subject/list"
						class="selected--menu">전체 강의 조회</a></td>
				</tr>
				<c:if test="${user.userRole eq 'professor'}">
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/professor/subject">내 강의 조회</a></td>
					</tr>
					<tr>
						<td><a
							href="${pageContext.request.contextPath}/professor/evaluationList">내 강의 평가</a></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1 class="sub--title">전체 강의 조회</h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->

		<!-- 필터 및 검색 -->
		<div class="sub--filter">
			<form action="${pageContext.request.contextPath}/subject/search?"
				method="get">
				<div>
					<!-- 개설연도 숫자 -->
					<label for="subYear">연도 </label> <input type="number" value="2023"
						name="subYear" id="subYear" min="2005" max="2023">
					<!-- 개설학기 콤보박스-->
					<label for="subSemester">학기 </label> <select name="semester"
						id="subSemester">
						<option value="1">1학기</option>
						<option value="2">2학기</option>
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

					<!-- 검색 버튼 -->
					<button type="submit" class="btn btn-primary mx-2">조회</button>
				</div>
			</form>
		</div>


		<h4>
			<span style="font-weight: 600;">강의 목록</span>&nbsp; <span
				style="color: gray; font-size: 18px;"><c:out
					value="[총 ${rowCount}건]" /></span>
		</h4>
		<table border="1" class="table table-striped sub--list--table">
			<thead>
				<tr>
					<th>연도/학기</th>
					<th>단과대학</th>
					<th>개설학과</th>
					<th>학수번호</th>
					<th>강의구분</th>
					<th style="width: 200px;">강의명</th>
					<th>담당교수</th>
					<th>학점</th>
					<th>수강인원</th>
					<th>정원</th>
					<th>강의계획서</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="subject" items="${classesList}">
					<tr>
						<td><c:out value="${subject.subYear}-${subject.semester}학기"></c:out></td>
						<td><c:choose>
								<c:when test="${fn:startsWith(subject.roomId, 'E')}">
									<c:out value="공과대학"></c:out>
								</c:when>
								<c:when test="${fn:startsWith(subject.roomId, 'H')}">
									<c:out value="인문대학"></c:out>
								</c:when>
								<c:when test="${fn:startsWith(subject.roomId, 'S')}">
									<c:out value="사회과학대학"></c:out>
								</c:when>
								<c:when test="${fn:startsWith(subject.roomId, 'C')}">
									<c:out value="상경대학"></c:out>
								</c:when>
							</c:choose></td>
						<td><c:out value="${subject.deptName}"></c:out></td>
						<td><c:out value="${subject.id}"></c:out></td>
						<td><c:out value="${subject.type}"></c:out></td>
						<td class="sub--list--name"><c:out value="${subject.name}"></c:out></td>
						<td><c:out value="${subject.professorName}"></c:out></td>
						<td><c:out value="${subject.grades}"></c:out></td>
						<td><c:out value="${subject.numOfStudent}"></c:out></td>
						<td><c:out value="${subject.capacity}"></c:out></td>
						<td><a
							href="${pageContext.request.contextPath}/syllabus/info?id=${subject.id}"
							onclick="window.open(this.href, '_blank', 'width=720, height=1000'); return false;">
						<img alt="강의계획서" src="${pageContext.request.contextPath}/resources/img/subjectDetail.png" style="width:40px;height:40px;">
						</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<c:if test="${isSearch ne true}">
			<div class="pagination">
				<span class="page-item"> <a
					href="${pageContext.request.contextPath}/subject/list?page=1"
					class="page-link">1</a>
				</span> <span class="page-item"> <a
					href="${pageContext.request.contextPath}/subject/list?page=2"
					class="page-link">2</a>
				</span> <span class="page-item"> <a
					href="${pageContext.request.contextPath}/subject/list?page=3"
					class="page-link">3</a>
				</span> <span class="page-item"> <a
					href="${pageContext.request.contextPath}/subject/list?page=4"
					class="page-link">4</a>
				</span>
			</div>
		</c:if>
	</main>
</div>

<footer>
	<!-- 필요 시 -->
</footer>

</body>
</html>
