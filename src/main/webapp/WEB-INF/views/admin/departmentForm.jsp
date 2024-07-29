<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main>
    <div class="form-container">
        <h3>학과 생성</h3>
        <form action="${pageContext.request.contextPath}/admin/departmentAdd" method="post">
            <label for="department-name">학과이름:</label>
            <input type="text" id="department-name" name="department-name" placeholder="ㅇㅇ학과" required>
            
            <label for="college-id">단과id:</label>
            <input type="text" id="college-id" name="college-id" placeholder="1, 2, 3..." required>
            
            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>
    
    <div class="form-container">
        <h3>학과 수정</h3>
        <form action="${pageContext.request.contextPath}/admin/departmentEdit" method="post">
            <label for="department-id">수정할 id:</label>
            <input type="text" id="department-id" name="department-id" placeholder="1, 2, 3..." required>
            
            <label for="department-name">학과이름:</label>
            <input type="text" id="department-name" name="department-name" placeholder="ㅇㅇ학과" required>
            
            <label for="college-id">단과id:</label>
            <input type="text" id="college-id" name="college-id" placeholder="1, 2, 3..." required>
            
            <button type="submit" class="btn-edit">수정</button>
        </form>
    </div>
</main>
