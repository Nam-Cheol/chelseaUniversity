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
    <h2 class="college-registration-top">단과대학 등록</h2>
    <form action="create-college" method="post">
        <label for="college-name">단과이름:</label>
        <input type="text" id="college-name" name="college-name" value="가나대학">
        <br>
        <button type="submit">등록</button>
    </form>
    <form action="">
        <button type="submit">삭제</button>    
    </form>
    <br><br>
    

        <p>단과 대학 리스트</p>
        <br>
        <table border="1" class="college-list">
                <tr>
                    <th>id</th>
                    <th>단과이름</th>
                </tr>
                <c:forEach var="college" items="${collegeList}">
                <tr>
                    <th>${college.id} </th>
                    <th>${college.name} </th>
                </tr>
                </c:forEach>
        </table>
    <%
    }
    catch(Exception exception)
    {
    	out.print("리스트 연결 실패");
    }%>

</div>
</div>
</section>

<%@ include file="footer.jsp"%>