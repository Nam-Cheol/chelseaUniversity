<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">
<div class="d-flex justify-content-center align-items-start">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>등록</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table">
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
    </div>
    <main class="main-content">
        <h1>강의 목록</h1>
        <div class="split--div"></div>
        <a href="${pageContext.request.contextPath}/admin/subjectAdd" class="btn-edit" onclick="window.open(this.href, '_blank', 'width=720, height=1000'); return false;">강의 등록</a>
        <br>
        <div class="table-container">
            <table class="table table-striped sub--list--table">
                <thead>
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
                </thead>
                <tbody>
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
                            <td>${subject.startTime}:00</td>
                            <td>${subject.endTime}:00</td>
                            <td>${subject.grades}</td>
                            <td>${subject.capacity}</td>
                            <td>${subject.numOfStudent}</td>
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
                            <span class="page-item"><a href="${pageContext.request.contextPath}/admin/subject?page=${i}" class="page-link">${i}</a></span>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </div>
    </main>
</div>

<%@ include file="footer.jsp"%>