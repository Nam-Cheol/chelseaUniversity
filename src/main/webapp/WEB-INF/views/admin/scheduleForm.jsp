<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main class="main-content">
    <!-- Form for Schedule Registration -->
    <div class="form-container">
        <h3>일정 등록</h3>
        <form action="${pageContext.request.contextPath}/admin/scheduleAdd" method="post">
            <input type="hidden" name="page" value="1">

			<c:set var="user" value="${sessionScope.user}" />
            <input type="hidden" id="staff-id" name="staff-id" value="${user.id}">

            <label for="start-date">시작날짜:</label>
            <input type="date" id="start-date" name="start-date" placeholder="2024-01-01" required>

            <label for="end-date">종료날짜:</label>
            <input type="date" id="end-date" name="end-date" placeholder="2024-01-01" required>

            <label for="schedule-information">일정내용:</label>
            <input type="text" id="schedule-information" name="schedule-information" placeholder="예비수강신청" required>

            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>

    <div class="line--div"></div>

    <div class="form-container">
        <h3>일정 수정</h3>
        <form action="${pageContext.request.contextPath}/admin/scheduleEdit" method="post">
            <input type="hidden" name="page" value="1">

            <label for="schedule-id">id:</label>
            <select id="schedule-id" name="schedule-id" required="required">
            	<c:forEach var="schedule" items="${scheduleList}">
            		<option value="${schedule.id}">${schedule.id}</option>
            	</c:forEach>
            </select>

			<c:set var="user" value="${sessionScope.user}" />
            <input type="hidden" id="staff-id" name="staff-id" value="${user.id}">

            <label for="start-date">시작날짜:</label>
            <input type="date" id="start-date" name="start-date" min="2024-01-01" max="2024-12-31" value="2024-01-01" required>

            <label for="end-date">종료날짜:</label>
            <input type="date" id="end-date" name="end-date" min="2024-01-01" max="2024-12-31" value="2024-01-01" required>

            <label for="schedule-information">일정내용:</label>
            <input type="text" id="schedule-information" name="schedule-information" placeholder="일정내용을 입력하세요" required>

            <button type="submit" class="btn-edit">변경</button>
        </form>
    </div>
</main>
