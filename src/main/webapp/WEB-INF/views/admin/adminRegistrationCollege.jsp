<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section>
<div class="college-registration-top-box">
    <h2 class="college-registration-top">단과대학 등록</h2>
</div>
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>등록</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/college" class="selected--menu">단과대학</a></td>
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
    </div>

    <main>
        <h2>단과대학 등록</h2>
        <br>
        <form action="${pageContext.request.contextPath}/admin/create-college" method="post">
            <table border=1 class="create-table">
                <tr>
                    <th>단과이름 : </th>
                    <td><input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학"></td>
                </tr>
            </table>
            <button type="submit">생성</button>
        </form>       
        <br>
        <form action="${pageContext.request.contextPath}/admin/edit-college" method="post">
            <table border=1 class="edit-table">
                <tr>
                    <th>id : </th>
                    <td><input type="text" id="college-id" name="college-id" placeholder="1 , 2 , 3 ...."></td>
                </tr>
                <tr>
                    <th>단과이름 : </th>
                    <td><input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학"></td>
                </tr>
            </table>
            <button type="submit">수정</button>
        </form>        
        <br><br>
        <p>단과 대학 리스트</p>
        <br>
        <table border="1" class="list-table">
            <tr>
                <th>id</th>
                <th>단과이름</th>
            </tr>
            <c:forEach var="college" items="${collegeList}">
            <tr>
                <td>${college.id}</td>
                <td>${college.name}</td>
            </tr>
            </c:forEach>
        </table>
    </main>
</div>
</section>
