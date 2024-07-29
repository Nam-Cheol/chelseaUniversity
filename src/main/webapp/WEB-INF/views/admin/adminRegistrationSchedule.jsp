<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>

	<div class="d-flex justify-content-center align-items-start" style="display: flex; min-width: 100em;">
		<div class="sub--menu">
			<div class="sub--menu--top">
				<h2>등록</h2>
			</div>
			<div class="sub--menu--mid">
				<table class="sub--menu--table" border="1">
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
						<td><a href="${pageContext.request.contextPath}/admin/schedule" class="selected--menu">학사일정</a></td>
					</tr>
				</table>
			</div>
		</div>
		
			 <main style="width: 100%; padding: 20px;">
				<h1>학사일정</h1>
			  <div class="split--div"></div>
       		 <div class="sub--filter" >
				<form action="${pageContext.request.contextPath}/admin/schedule/create-schedule" method="post">
				 <table class="table-container">
                     <tr>
                        <td><label for="type">교직원사번<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="staff-id" name="staff-id" placeholder="교직원사번을 입력하세요" required="required"></td>
                    </tr>
                     <tr>
                        <td><label for="type">시작날짜<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="date" id="start-date" name="start-date" min="2024-01-01" max="2024-12-31" value="2024-01-01" required></td>
                    </tr>
                     <tr>
                        <td><label for="type">종료날짜<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="date" id="end-date" name="end-date" min="2024-01-01" max="2024-12-31" value="2024-01-01" required></td>
                    </tr>
                    <tr>
                        <td><label for="type">일정내용<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="schedule-information" name="schedule-information" placeholder="일정내용을 입력하세요" required="required"></td>
                    </tr>
                  </table>
					<button type="submit">생성</button>
				</form>
				
				<form action="${pageContext.request.contextPath}/admin/schedule/edit-schedule" method="post">
				<table class="table-container">
                     <tr>
                        <td><label for="type">수정할id<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="schedule-id" name="schedule-id" placeholder="id을 입력하세요" required="required"></td>
                    </tr>
                     <tr>
                        <td><label for="type">교직원사번<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="staff-id" name="staff-id" placeholder="교직원사번을 입력하세요" required="required"></td>
                    </tr>
                     <tr>
                        <td><label for="type">시작날짜<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="date" id="start-date" name="start-date" min="2024-01-01" max="2024-12-31" value="2024-01-01" required></td>
                    </tr>
                     <tr>
                        <td><label for="type">종료날짜<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="date" id="end-date" name="end-date" min="2024-01-01" max="2024-12-31" value="2024-01-01" required></td>
                    </tr>
                    <tr>
                        <td><label for="type">일정내용<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="schedule-information" name="schedule-information" placeholder="일정내용을 입력하세요" required="required"></td>
                    </tr>
                  </table>
					<button type="submit">변경</button>
				</form>
				
				</div>
				
				<p>단과 대학 리스트</p>
				<br>
				<div>
            		<table class="table table-striped sub--list--table">
            		 <thead>
						<tr>
							<th>id</th>
							<th>교직원id</th>
							<th>시작날짜</th>
							<th>종료날짜</th>
							<th>일정내용</th>
						</tr>
						  </thead>
                		<tbody>
						<c:forEach var="schedule" items="${scheduleList}">
							<tr>
								<th>${schedule.id}</th>
								<th>${schedule.staffId}</th>
								<th>${schedule.startDay}</th>
								<th>${schedule.endDay}</th>
								<th>${schedule.information}</th>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<div class="pagination">
					<c:forEach begin="1" end="${totalPages}" var="i">
						<c:choose>
							<c:when test="${i == page}">
								<span class="page-item current-page">${i}</span>
							</c:when>
							<c:otherwise>
								<span class="page-item"><a href="${pageContext.request.contextPath}/admin/schedule?page=${i}" class="page-link">${i}</a></span>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
				</div>
			</main>
		</div>

<%@ include file="footer.jsp"%>
