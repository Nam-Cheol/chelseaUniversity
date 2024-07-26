<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">

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
                    <td><a href="${pageContext.request.contextPath}/admin/subject" class="selected--menu">강의</a></td>
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
            <main>
                <h2>강의 등록</h2>
                <br>
                <form action="${pageContext.request.contextPath}/admin/subject/create-subject" method="post">
                    <table border="1" class="create-table">
                        <tr>
                            <th>강의이름 :</th>
                            <td><input type="text" id="subject-name" name="subject-name" placeholder="데이터통신"></td>
                        </tr>
                        <tr>
                            <th>교수id :</th>
                            <td><input type="text" id="professor-id" name="professor-id" placeholder="23000001"></td>
                        </tr>
                        <tr>
                            <th>강의실id :</th>
                            <td><input type="text" id="room-id" name="room-id" placeholder="E601"></td>
                        </tr>
                        <tr>
                            <th>학과id :</th>
                            <td><input type="text" id="dept-id" name="dept-id" placeholder="101"></td>
                        </tr>
                        <tr>
                            <th>구분 :</th>
                            <td><input type="text" id="type" name="type" placeholder="전공 or 교양"></td>
                        </tr>
                        <tr>
                            <th>강의연도 :</th>
                            <td><input type="text" id="subject-year" name="subject-year" placeholder="2024"></td>
                        </tr>
                        <tr>
                            <th>학기 :</th>
                            <td><input type="text" id="semester" name="semester" placeholder="1 or 2"></td>
                        </tr>
                        <tr>
                            <th>요일 :</th>
                            <td><input type="text" id="subject-day" name="subject-day" placeholder="월"></td>
                        </tr>
                        <tr>
                            <th>시작시간 :</th>
                            <td><input type="text" id="start-time" name="start-time" placeholder="09:00"></td>
                        </tr>
                        <tr>
                            <th>종료시간 :</th>
                            <td><input type="text" id="end-time" name="end-time" placeholder="12:00"></td>
                        </tr>
                        <tr>
                            <th>학년 :</th>
                            <td><input type="text" id="grades" name="grades" placeholder="1,2,3,4"></td>
                        </tr>
                        <tr>
                            <th>최대정원 :</th>
                            <td><input type="text" id="capacity" name="capacity" placeholder="20"></td>
                        </tr>
                        <tr>
                            <th>현재인원 :</th>
                            <td><input type="text" id="number-of-student" name="number-of-student" placeholder="5"></td>
                        </tr>
                    </table>
                    <button type="submit">생성</button>
                </form>

                <br>
                <p>강의 목록</p>
                <br>
                <div>
                    <table border="1" class="list-table">
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
                                <td>${subject.id}</td>
                                <td>${subject.name}</td>
                                <td>${subject.professorId}</td>
                                <td>${subject.roomId}</td>
                                <td>${subject.deptId}</td>
                                <td>${subject.type}</td>
                                <td>${subject.subYear}</td>
                                <td>${subject.semester}</td>
                                <td>${subject.subDay}</td>
                                <td>${subject.startTime}</td>
                                <td>${subject.endTime}</td>
                                <td>${subject.grades}</td>
                                <td>${subject.capacity}</td>
                                <td>${subject.numOfStudent}</td>
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
                                    <span class="page-item"><a href="${pageContext.request.contextPath}/admin/subject?page=${i}" class="page-link">${i}</a></span>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                </div>
            </main>
        </div>
    </div>
</section>

<%@ include file="footer.jsp"%>
