<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>

	<section>
<div class="college-box">
<div class="registration-list-container">
		<div>
			<h2 class="registration-list-top">등록</h2>
		</div>
		<table class="registration-list">
			<tr>
				<td><a href="${pageContext.request.contextPath}/admin/college">단과대학</a></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/admin/department">학과</a></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/admin/room">강의실</a></td>
			</tr>
			<tr>	
				<td><a href="${pageContext.request.contextPath}/admin/subject">강의</a></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/admin/tuition">단대별 등록금</a></td>
			</tr>
			<tr>	
				<td><a href="${pageContext.request.contextPath}/admin/schedule">학사일정</a></td>
			</tr>
		</table>
	</div>
	<div class="college-registration-right-container">
	
    <h2 class="college-registration-top">학사일정 등록</h2>
        <br>
		<form action="${pageContext.request.contextPath}/admin/schedule/create-schedule" method="post">
			<table border=1 class="create-schedule-table">
				<tr>
					<th>교직원id : </th>
					<th><input type="text" id="staff-id" name="staff-id" placeholder="230001  fk"></th>
				</tr>
				<tr>
					<th>시작날짜 : </th>
					<th><input type="text" id="start-date" name="start-date" placeholder="2024-01-01"></th>
				</tr>
				<tr>
					<th>종료날짜 : </th>
					<th><input type="text" id="end-date" name="end-date" placeholder="2024-01-01"></th>
				</tr>
				<tr>
					<th>일정내용 : </th>
					<th><input type="text" id="schedule-information" name="schedule-information" placeholder="예비수강신청"></th>
				</tr>
			</table>
			<button type="submit">생성</button>
		</form>       
		
		<br>
		<form action="${pageContext.request.contextPath}/admin/schedule/edit-schedule" method="post">
				<table border=1 class="edit-schedule-table">
					<tr>
						<th>id : </th>
						<th><input type="text" id="schedule-id" name="schedule-id" placeholder="1 , 2 , 3 ...."></th>
					</tr>
					<tr>
					<th>교직원id : </th>
					<th><input type="text" id="staff-id" name="staff-id" placeholder="230001  fk"></th>
				</tr>
				<tr>
					<th>시작날짜 : </th>
					<th><input type="text" id="start-date" name="start-date" placeholder="2024-01-01"></th>
				</tr>
				<tr>
					<th>종료날짜 : </th>
					<th><input type="text" id="end-date" name="end-date" placeholder="2024-01-01"></th>
				</tr>
				<tr>
					<th>일정내용 : </th>
					<th><input type="text" id="schedule-information" name="schedule-information" placeholder="예비수강신청"></th>
				</tr>
				</table>
			<button type="submit">수정</button>
		</form>        
		<br><br>
	
        <p>단과 대학 리스트</p>
        <br>
        
        <div>
        <table border="1" class="college-list">
                <tr>
                    <th>id</th>
                    <th>교직원id</th>
                    <th>시작날짜</th>
                    <th>종료날짜</th>
                    <th>일정내용</th>
                </tr>
                <c:forEach var="schedule" items="${scheduleList}">
                <tr>
                    <th>${schedule.id}</th>
                    <th>${schedule.staffId}</th>
                    <th>${schedule.startDay}</th>
                    <th>${schedule.endDay}</th>
                    <th>${schedule.information}</th>
                </tr>
                </c:forEach>
        </table>
         <c:forEach begin="1" end="${totalPages}"  var="i" >
					<c:choose>
						<c:when test="${ i == currentPage }">
							<span class="current-page" >${i}</span>
						</c:when>
						<c:otherwise>
							<span><a href="${pageContext.request.contextPath}/admin/schedule?page=${i}">${i}</a></span>	
						</c:otherwise>
					</c:choose>
				</c:forEach>
</div>
</div>
</div>
</section>

<%@ include file="footer.jsp"%>;