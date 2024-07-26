<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">

<section>

    <div class="college-registration-right-container">
        <h2 class="college-registration-top">학과 등록</h2>

        <div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
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
                            <td><a href="${pageContext.request.contextPath}/admin/department" class="selected--menu">학과</a></td>
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
            </div>

            <main>
                <h2>학과 등록</h2>
                <br>
                <form action="${pageContext.request.contextPath}/admin/department/create-department" method="post">
                    <table border="1" class="create-table">
                        <tr>
                            <th>학과이름 :</th>
                            <td><input type="text" id="department-name" name="department-name" placeholder="ㅇㅇ학과"></td>
                        </tr>
                        <tr>
                            <th>단과id :</th>
                            <td><input type="text" id="college-id" name="college-id" placeholder="1, 2, 3, 4 ...."></td>
                        </tr>
                    </table>
                    <button type="submit">생성</button>
                </form>
                <br>
                <form action="${pageContext.request.contextPath}/admin/department/edit-department" method="post">
                    <table border="1" class="edit-table">
                        <tr>
                            <th>id :</th>
                            <td><input type="text" id="department-id" name="department-id" placeholder="1, 2, 3 ...."></td>
                        </tr>
                        <tr>
                            <th>학과이름 :</th>
                            <td><input type="text" id="department-name" name="department-name" placeholder="ㅇㅇ학과"></td>
                        </tr>
                        <tr>
                            <th>단과id :</th>
                            <td><input type="text" id="college-id" name="college-id" placeholder="1, 2, 3 ...."></td>
                        </tr>
                    </table>
                    <button type="submit">수정</button>
                </form>        
                <br><br>
                <p>학과 목록</p>
                <br>
                <div>
                    <table border="1" class="list-table">
                        <tr>
                            <th>id</th>
                            <th>학과이름</th>
                            <th>단과id</th>
                        </tr>
                        <c:forEach var="department" items="${departmentList}">
                        <tr>
                            <td>${department.id}</td>
                            <td>${department.name}</td>
                            <td>${department.collegeId}</td>
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
                                    <span class="page-item"><a href="${pageContext.request.contextPath}/admin/department?page=${i}" class="page-link">${i}</a></span>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </main>
        </div>
    </div>
</section>
