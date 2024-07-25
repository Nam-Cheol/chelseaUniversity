<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		</table>
	</div>
	<div class="college-registration-right-container">
	
    <h2 class="college-registration-top">강의</h2>
        <br>
        
        
		<form action="${pageContext.request.contextPath}/admin/tuition/create-subject" method="post">
			<table border=1 class="create-subjet-table">
				<tr>
					<th>강의이름:</th>
					<th><input type="text" id="subject-name" name="subject-name" placeholder="데이터통신"></th>
				</tr>
				<tr>
					<th>교수id:</th>
					<th><input type="text" id="professor-id" name="professor-id" placeholder="23000001"></th>
				</tr>
				<tr>
					<th>강의실id:</th>
					<th><input type="text" id="romm-id" name="romm-id" placeholder="E601"></th>
				</tr>
				<tr>
					<th>학과id:</th>
					<th><input type="text" id="dept-id" name="dept-id" placeholder="101"></th>
				</tr>
				<tr>
					<th>구분:</th>
					<th><input type="text" id="type" name="type" placeholder="전공 or 교양"></th>
				</tr>
				<tr>
					<th>강의연도:</th>
					<th><input type="text" id="subject-year" name="subject-year" placeholder="2024"></th>
				</tr>
				<tr>
					<th>학기:</th>
					<th><input type="text" id="semester" name="semester" placeholder="1 or 2"></th>
				</tr>
				<tr>
					<th>요일:</th>
					<th><input type="text" id="subject-day" name="subject-day" placeholder="월 <--- 요일을 빼고 입력해주세요"></th>
				</tr>
				<tr>
					<th>시작시간:</th>
					<th><input type="text" id="start-time" name="start-time" placeholder="9 <--- 09:00 시작"></th>
				</tr>
				<tr>
					<th>종료시간:</th>
					<th><input type="text" id="end-time" name="end-time" placeholder="12 <--- 12:00 종료"></th>
				</tr>
				<tr>
					<th>학년:</th>
					<th><input type="text" id="grades" name="grades" placeholder="1,2,3,4"></th>
				</tr>
				<tr>
					<th>최대정원:</th>
					<th><input type="text" id="capacity" name="capacity" placeholder="20"></th>
				</tr>
				<tr>
					<th>현재인원:</th>
					<th><input type="text" id="number-of-student" name="number-of-student" placeholder="5"></th>
				</tr>
			</table>
			<button type="submit">생성</button>
		</form>       
		<br>
	
        <p>강의 목록</p>
        <br>
        <table border="1" class="subject-list">
                <tr>
                    <th>강의id</th>
                    <th>강의이름</th>
                    <th>교수id</th>
                    <th>강의실id</th>
                    <th>학과id</th>
                    <th>구분</th>
                    <th>강의연도</th>
                    <th>학기</th>
                    <th>요일</th>
                    <th>시작시간</th>
                    <th>종료시간</th>
                    <th>학년</th>
                    <th>최대정원</th>
                    <th>현재인원</th>
                </tr>
                <c:forEach var="subject" items="${subjectList}">
                <tr>
                    <th>${subject.id}</th>
                    <th>${subject.name}</th>
                    <th>${subject.professorId}</th>
                    <th>${subject.roomId}</th>
                    <th>${subject.deptId}</th>
                    <th>${subject.type}</th>
                    <th>${subject.subYear}</th>
                    <th>${subject.semester}</th>
                    <th>${subject.subDay}</th>
                    <th>${subject.startTime}</th>
                    <th>${subject.endTime}</th>
                    <th>${subject.grades}</th>
                    <th>${subject.capacity}</th>
                    <th>${subject.numOfStudent}</th>
                </tr>
                </c:forEach>
        </table>

</div>
</div>
</section>

<%@ include file="footer.jsp"%>;