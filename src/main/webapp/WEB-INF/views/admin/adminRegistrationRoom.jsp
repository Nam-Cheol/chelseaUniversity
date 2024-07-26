<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
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
			<tr>	
				<td><a href="${pageContext.request.contextPath}/admin/schedule">학사일정</a></td>
			</tr>
		</table>
	</div>
	<div class="college-registration-right-container">
	
    <h2 class="college-registration-top">강의실 등록</h2>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <!-- 세부 메뉴 div-->
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>MY</h2>
        </div>
        <!-- 메뉴 -->
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/college">단과대학</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/department">학과</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/room" class="selected--menu">강의실</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/subject">강의</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/tuition">단대별 등록금</a></td>
                </tr>
            </table>
        </div>
    </div>

    <!-- 메인 div -->
    <main>
        <h2>강의실 등록</h2>
>>>>>>> main
        <br>
        <form action="${pageContext.request.contextPath}/admin/room/create-room" method="post">
            <table border="1" class="create-room-table">
                <tr>
                    <th>강의실id :</th>
                    <th><input type="text" id="room-id" name="room-id" placeholder="A001"></th>
                </tr>
                <tr>
                    <th>단과대id :</th>
                    <th><input type="text" id="college-id" name="college-id" placeholder="1, 2, 3, 4 ..."></th>
                </tr>
            </table>
            <button type="submit">생성</button>
        </form>

        <form action="${pageContext.request.contextPath}/admin/room/edit-room" method="post">
            <table border="1" class="edit-room-table">
                <tr>
                    <th>강의실id :</th>
                    <th><input type="text" id="room-id" name="room-id" placeholder="A001"></th>
                </tr>
                <tr>
                    <th>단과대id :</th>
                    <th><input type="text" id="college-id" name="college-id" placeholder="1, 2, 3, 4 ..."></th>
                </tr>
            </table>
            <button type="submit">수정</button>
        </form>

        <p>강의실 목록</p>
        <br>

        <div>
            <table>
                <tr>
                    <th>강의실id</th>
                    <th>단과대id</th>
                </tr>
                <c:forEach var="room" items="${roomList}">
                    <tr>
                        <th>${room.id}</th>
                        <th>${room.collegeId}</th>
                    </tr>
                </c:forEach>
            </table>
            <div class="pagination">
			    <c:forEach begin="1" end="${totalPages}" var="i">
			        <c:choose>
			            <c:when test="${i == page}">
			                <span class="page-item current-page">${i}</span>
			            </c:when>
			            <c:otherwise>
			                <span class="page-item"><a href="${pageContext.request.contextPath}/user/studentList?page=${i}" class="page-link">${i}</a></span>
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			</div>
        </div>
    </main>
</div>

<%@ include file="footer.jsp"%>
