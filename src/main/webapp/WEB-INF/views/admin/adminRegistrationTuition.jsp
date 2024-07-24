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
	
    <h2 class="college-registration-top">단대별 등록금</h2>
        <br>
		<form action="${pageContext.request.contextPath}/admin/tuition/create-tuition-name" method="post">
	        <label for="college-name">단과이름:</label>
			<input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학">
			<button type="submit">생성</button>
		</form>       
		<br>
		
		<form action="${pageContext.request.contextPath}/admin/tuition/create-tuition-amount" method="post">
			<label for="college-id">id:</label>
			<input type="text" id="college-id" name="college-id" placeholder="1, 2, 3 .....">
			<label for="college-tuition-amount">금액:</label>
			<input type="text" id="college-tuition-amount" name="college-tuition-amount" placeholder="4000000">
			<button type="submit">생성</button>
		</form>
		
		<br>
		
		<form action="${pageContext.request.contextPath}/admin/tuition/edit-tuition" method="post">
			<label for="tuition-id">id:</label>
			<input type="text" id="tuition-id" name="tuition-id" placeholder="1, 2, 3 ....">
	        <label for="college-tuition-amount">금액:</label>
			<input type="text" id="college-tuition-amount" name="college-tuition-amount" placeholder="4000000">
			<button type="submit">수정</button>
		</form>        
		<br><br>
	
        <p>단대별 등록금 목록</p>
        <br>
        <table border="1" class="college-list">
                <tr>
                    <th>id</th>
                    <th>단과이름</th>
                    <th>금액</th>
                </tr>
                <c:forEach var="tuition" items="${tuitionList}">
                <tr>
                    <th>${tuition.id}</th>
                    <th>${tuition.name}</th>
                    <th>${tuition.amount}</th>
                </tr>
                </c:forEach>
        </table>

</div>
</div>
</section>

<%@ include file="footer.jsp"%>;