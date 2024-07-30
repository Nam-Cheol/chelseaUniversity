<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main>
    <div class="form-container">
        <h3>강의실 등록</h3>
        <form action="${pageContext.request.contextPath}/admin/roomAdd" method="post">
            <label for="room-id">강의실 ID:</label>
            <input type="text" id="room-id" name="room-id" placeholder="강의실 ID를 입력해주세요" required>
            
            <label for="college-id">단과대 ID:</label>
            <select id="college-id" name="college-id" required="required">
            	<c:forEach var="college" items="${collegeList}">
            		<option value="${college.id}">${college.id} - ${college.name}</option>
            	</c:forEach>
            </select>
            
            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>
    
    <div class="form-container">
        <h3>강의실 수정</h3>
        <form action="${pageContext.request.contextPath}/admin/roomEdit" method="post">
            <label for="room-id">수정할 강의실 ID:</label>
            <select id="room-id" name="room-id" required="required">
            	<c:forEach var="room" items="${roomList}">
            		<option value="${room.id}">${room.id}</option>
            	</c:forEach>
            </select>
            
            <label for="college-id">단과대 ID:</label>
            <select id="college-id" name="college-id" required="required">
            	<c:forEach var="college" items="${collegeList}">
            		<option value="${college.id}">${college.id} - ${college.name}</option>
            	</c:forEach>
            </select>
            
            <button type="submit" class="btn-edit">수정</button>
        </form>
    </div>
</main>