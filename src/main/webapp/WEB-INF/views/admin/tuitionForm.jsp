<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main>
    <div class="form-container">
        <h3>단대별 등록금 금액 생성</h3>
        <form action="${pageContext.request.contextPath}/admin/tuitionAddAmount" method="post">
            <label for="college-id">id:</label>
            <input type="text" id="college-id" name="college-id" placeholder="1, 2, 3 ...." required>
            <label for="college-tuition-amount">금액:</label>
            <input type="text" id="college-tuition-amount" name="college-tuition-amount" placeholder="4000000" required>
            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>

    <div class="form-container">
        <h3>단대별 등록금 수정</h3>
        <form action="${pageContext.request.contextPath}/admin/tuitionEdit" method="post">
            <label for="tuition-id">수정할 단대id:</label>
            <input type="text" id="tuition-id" name="tuition-id" placeholder="1, 2, 3 ...." required>
            <label for="college-tuition-amount">금액:</label>
            <input type="text" id="college-tuition-amount" name="college-tuition-amount" placeholder="4000000" required>
            <button type="submit" class="btn-edit">수정</button>
        </form>
    </div>
</main>
