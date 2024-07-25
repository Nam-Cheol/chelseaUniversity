<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/noticeDetail.css">
<!-- 세부 메뉴 + 메인 -->
	<!-- 세부 메뉴 div-->
	<div class="d-flex justify-content-center align-items-start"
	style="display: flex; min-width: 100em;">
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사정보</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/notice" class="selected--menu">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/schedule">학사일정</a></td>
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
		<h1>공지사항</h1>
		<div class="split--div"></div>
		<hr style="border-color:#F4FFFF; height:1px; width:85%">
		<p> &nbsp;제목&emsp; ${notice.category} ${notice.title}</p>
		<hr style="border-color:#F4FFFF; height:1px; width:85%">
		<div class="contentBox"><p> &nbsp;내용</p><div class="content">${notice.content}</div></div>
		<div class="list"><button onclick="location=`${pageContext.request.contextPath}/notice/list`">목록</button></div>
		</main>
		</div>
</body>
</html>




