<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/info.css">

<main>
    <h1>강의 계획서 조회</h1>
    <table border="1" class="list--table">
    	<tr>
            <th colspan="4">교과목 정보</th>
    	</tr>
        <tr>
            <th class="sub--th">수업 번호</th>
            <td><c:out value="${info.id}"></c:out></td>
            <th class="sub--th">학점</th>
            <td><c:out value="${info.grades}"></c:out></td>
        </tr>
        <tr>
            <th class="sub--th">수업 연도</th>
            <td><c:out value="${info.subYear}"></c:out></td>
            <th class="sub--th">강의 시간</th>
            <td><c:out value="${info.subDay} ${info.startTime}:00-${info.endTime}:00"></c:out></td>
        </tr>
        <tr>
            <th class="sub--th">교과목 명</th>
            <td><c:out value="${info.name}"></c:out></td>
            <th class="sub--th">이수 구분</th>
            <td><c:out value="${info.type}"></c:out></td>
        </tr>
        <tr>
            <th class="sub--th">수업 학기</th>
            <td><c:out value="${info.semester}학기"></c:out></td>
            <th class="sub--th">강의실</th>
            <td><c:out value="${info.roomId}"></c:out></td>
        </tr>
    </table>
    <br> <br>
    <table border="1" class="list--table">
    	<tr>
            <th colspan="4">교강사 정보</th>
    	</tr>
        <tr>
            <th class="sub--th">소속</th>
            <td><c:out value="${professorInfo.deptName}"></c:out></td>
            <th class="sub--th">성명</th>
            <td><c:out value="${professorInfo.name}"></c:out></td>
        </tr>
        <tr>
            <th class="sub--th">연락처</th>
            <td><c:out value="${professorInfo.tel}"></c:out></td>
            <th class="sub--th">email</th>
            <td><c:out value="${professorInfo.email}"></c:out></td>
        </tr>
    </table>
    <br> <br>
    <table border="1" class="list--table table-with-custom-width">
        <tr>
            <th class="sub--th">강의 개요</th>
            <td><c:out value="${syllabusInfo.overview}"></c:out></td>
        </tr>
        <tr>
            <th class="sub--th">강의 목표</th>
            <td><c:out value="${syllabusInfo.objective}"></c:out></td>
        </tr>
        <tr>
            <th class="sub--th">교재 정보</th>
            <td><c:out value="${syllabusInfo.textbook}"></c:out></td>
        </tr>
        <tr>
            <th class="sub--th">주간 계획</th>
            <td><c:out value="${syllabusInfo.program}"></c:out></td>
        </tr>
    </table>
    <br> <br>
    <c:if test="${principal.id == professorInfo.id}">
        <form action="${pageContext.request.contextPath}/syllabus/update?id=${info.id}" method="post">
            <button class="btn btn-edit">수정</button>
        </form>
    </c:if>
</main>
