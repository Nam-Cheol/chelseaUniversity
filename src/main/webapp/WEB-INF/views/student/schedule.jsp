<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/notice.css">
<style>
.select--button {
	margin-left: 350px;
}
</style>
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사정보</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/notice/list?page=0">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/schedule/list"
						class="selected--menu">학사일정</a></td>
				</tr>
				<%-- <c:if test="${principal.userRole.equals(\"staff\") }">
					<tr>
						<td><a href="/schedule/list"> 학사일정 등록</a></td>
					</tr>
				</c:if> --%>
			</table>
		</div>
	</div>

	<main>
		<h1>학사일정</h1>
		<div class="container">
			<div></div>

			<table class="room--table">
				<tbody>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">01-27~02-01</td>
						<td class="line">2023-1학기 예비수강신청</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">02-13~02-17</td>
						<td class="line">2023-1학기 수강신청</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">02-17~02-23</td>
						<td class="line">2023-1학기 등록</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">02-22~02-22</td>
						<td class="line">복학 접수 마감</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">02-26~02-26</td>
						<td class="line">졸업예배</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">02-27~02-27</td>
						<td class="line">학위수여식</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">03-01~03-01</td>
						<td class="line">삼일절</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">03-02~03-02</td>
						<td class="line">개강/교무위원회</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">03-06~03-08</td>
						<td class="line">수강신청 확인 및 변경</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">03-10~03-13</td>
						<td class="line">2023-1학기 추가등록</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">03-13~03-17</td>
						<td class="line">조기졸업 신청</td>
					</tr>

					<tr>
						<td class="month" width="100px;">월</td>
						<td class="line">03-15~03-15</td>
						<td class="line">미등록자 일반 휴학 접수 마감/ 등록금 전액반환 마감</td>
					</tr>

				</tbody>
			</table>
		</div>
	</main>



	<footer>
		<!-- 필요 시 -->
	</footer>

</div>

</body>
</html>

