<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main class="main-content">
    <!-- Form for Subject Registration -->
    <div class="form-container">
        <h3>강의 등록</h3>
        <form action="${pageContext.request.contextPath}/admin/subjectAdd" method="post">
            <input type="hidden" name="page" value="1">
            
            <label for="subject-name">강의이름:</label>
            <input type="text" id="subject-name" name="subject-name" placeholder="데이터통신" required>
            
            <label for="professor-id">교수id:</label>
            <input type="text" id="professor-id" name="professor-id" placeholder="23000001" required>
            
            <label for="room-id">강의실id:</label>
            <input type="text" id="room-id" name="room-id" placeholder="E601" required>
            
            <label for="dept-id">학과id:</label>
            <input type="text" id="dept-id" name="dept-id" placeholder="101" required>
            
            <label for="type">구분:</label>
            <input type="text" id="type" name="type" placeholder="전공 or 교양" required>
            
            <label for="subject-year">강의연도:</label>
            <input type="text" id="subject-year" name="subject-year" placeholder="2024" required>
            
            <label for="semester">학기:</label>
            <input type="text" id="semester" name="semester" placeholder="1 or 2" required>
            
            <label for="subject-day">요일:</label>
            <input type="text" id="subject-day" name="subject-day" placeholder="월" required>
            
            <label for="start-time">시작시간:</label>
            <input type="text" id="start-time" name="start-time" placeholder="09:00" required>
            
            <label for="end-time">종료시간:</label>
            <input type="text" id="end-time" name="end-time" placeholder="12:00" required>
            
            <label for="grades">학년:</label>
            <input type="text" id="grades" name="grades" placeholder="1,2,3,4" required>
            
            <label for="capacity">최대정원:</label>
            <input type="text" id="capacity" name="capacity" placeholder="20" required>
            
            <input type="hidden" id="number-of-student" name="number-of-student" value="0">
            
            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>
</main>
