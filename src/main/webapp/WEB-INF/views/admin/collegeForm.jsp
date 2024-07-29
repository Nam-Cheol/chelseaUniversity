<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main>
    
    <div class="form-container">
        <h3>단과대학 생성</h3>
        <form action="${pageContext.request.contextPath}/admin/collegeAdd" method="post">
            <label for="college-name">단과이름:</label>
            <input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학" required="required">
            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>
    
    <div class="form-container">
        <h3>단과대학 수정</h3>
        <form action="${pageContext.request.contextPath}/admin/collegeEdit" method="post">
            <label for="college-id">수정할 id:</label>
            <input type="text" id="college-id" name="college-id" placeholder="1, 2, 3..." required="required">
            
            <label for="college-name">단과이름:</label>
            <input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학" required="required">
            
            <button type="submit" class="btn-edit">수정</button>
        </form>
    </div>
</main>