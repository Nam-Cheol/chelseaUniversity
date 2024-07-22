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
				<td>단과대학</td>
			</tr>
			<tr>
				<td>학과</td>
			</tr>
			<tr>
				<td>강의실</td>
			</tr>
			<tr>	
				<td>강의</td>
			</tr>
			<tr>
				<td>단대별 등록금</td>
			</tr>
		</table>
	</div>
	<div class="college-registration-right-container">
    <h2 class="college-registration-top">단과대학 등록</h2>
    <form action="create-college" method="post">
        <label for="college-name">단과이름:</label>
        <input type="text" id="college-name" name="college-name" value="ㅇㅇ대학">
        <br>
        <button type="submit">등록</button>
        <button type="submit">삭제</button>    
    </form>
    <br><br>
    

<%
    try
    {
        //JDBC 드라이버 연결
        Class.forName("com.mysql.jdbc.Driver");
        String address = "jdbc:mysql://192.168.0.145:3306/university";
        String username = "university";
        String password = "1234";
        Connection connection = DriverManager.getConnection(address, username, password);
		
        String Query = " SELECT * FROM college_tb ORDER BY id asc ";
				
        PreparedStatement psmt = connection.prepareStatement(Query);
        
			
        ResultSet result = psmt.executeQuery();%>
        
        <p>단과 대학 리스트</p>
        <br>
        <table border="1">
	        <thead>
                <tr>
                    <th>id</th>
                    <th>단과이름</th>
                </tr>
    	    </thead>
     <% while(result.next()) {%>
            <tbody>
                <tr>
                    <td><%=result.getString("id") %></td>
                    <td><%=result.getString("name") %></td>
                </tr>
            </tbody>
        </table>
    <%} %>
    
    <%
    }
    catch(Exception ex)
    {
    	out.print("리스트 연결 실패");
    }%>

</div>
</div>
</section>

<%@ include file="footer.jsp"%>