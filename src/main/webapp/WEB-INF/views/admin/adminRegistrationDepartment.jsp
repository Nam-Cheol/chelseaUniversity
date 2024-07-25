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
	
    <h2 class="college-registration-top">학과 등록</h2>
        <br>
		<form action="${pageContext.request.contextPath}/admin/department/create-department" method="post">
			<table border=1 class="create-department-table">
				<tr>
					<th>학과이름 : </th>
					<th><input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ학과"></th>
				</tr>
				<tr>
					<th>단과id : </th>
					<th><input type="text" id="college-id" name="college-id" placeholder=" 1 , 2 , 3 , 4 ...."></th>
				</tr>
			</table>
			<button type="submit">생성</button>
		</form>
		
		<br>
		<form action="${pageContext.request.contextPath}/admin/department/edit-department" method="post">
			<table border=1 class="edit-department-table">
				<tr>
					<th>id : </th>
					<th><input type="text" id="department-id" name="department-id" placeholder=" 1,2,3 .... "></th>
				</tr>
				<tr>
					<th>학과이름 : </th>
					<th><input type="text" id="department-name" name="department-name" placeholder="ㅇㅇ학과"></th>
				</tr>
				<tr>
					<th>단과id : </th>
					<th><input type="text" id="college-id" name="college-id" placeholder=" 1,2,3 .... "></th>
				</tr>
			</table>
			<button type="submit">수정</button>
		</form>        
		<br><br>
	
        <p>학과 목록</p>
        <br>
        <table border="1" class="college-list">
                <tr>
                    <th>id</th>
                    <th>학과이름</th>
                    <th>단과id</th>
                </tr>
                <c:forEach var="department" items="${departmentList}">
                <tr>
                    <th>${department.id}</th>
                    <th>${department.name}</th>
                    <th>${department.collegeId}</th>
                </tr>
                </c:forEach>
        </table>

</div>
</div>
</section>

<%@ include file="footer.jsp"%>;