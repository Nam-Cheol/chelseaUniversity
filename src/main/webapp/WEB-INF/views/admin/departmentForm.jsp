<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main>
    <div class="form-container">
        <h3>학과 생성</h3>
        <form action="${pageContext.request.contextPath}/admin/departmentAdd" method="post">
            <label for="dept-name">학과이름:</label>
            <input type="text" id="dept-name" name="dept-name" placeholder="학과 이름을 입력하세요" required>
            
            <label for="college-id">단과id:</label>
            <select id="college-id" name="college-id" required>
                <c:forEach var="college" items="${collegeList}">
                    <option value="${college.id}">${college.id} - ${college.name}</option>
                </c:forEach>
            </select>
            
            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>
    
    <div class="form-container">
        <h3>학과 수정</h3>
        <form action="${pageContext.request.contextPath}/admin/departmentEdit" method="post">
            <label for="dept-id">수정할 id:</label>
            <select id="dept-id" name="dept-id" required="required">
            	<c:forEach var="dept" items="${departmentList}">
            		<option value="${dept.id}">${dept.id} - ${dept.name}</option>
            	</c:forEach>
            </select>
            
            <label for="dept-name">학과이름:</label>
            <input type="text" id="dept-name" name="dept-name" placeholder="학과 이름을 입력하세요" required>
            
            <label for="college-id">단과id:</label>
            <select id="college-id" name="college-id" required>
                <c:forEach var="college" items="${collegeList}">
                    <option value="${college.id}">${college.id} - ${college.name}</option>
                </c:forEach>
            </select>
            
            <button type="submit" class="btn-edit">수정</button>
        </form>
    </div>
</main>
