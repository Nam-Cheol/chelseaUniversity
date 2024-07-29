<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">

<style>
/* Custom styles for better presentation */
h1 {
    color: #001489;
    border-bottom: 1px solid #ddd;
    padding: 20px 0;
}

main {
    padding: 20px;
    flex: 1;
}

button {
    border: none;
    padding: 10px 20px;
    color: #fff;
    background-color: #001489;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #0036a0;
}
</style>

<!-- Sidebar Menu and Main Content -->
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <!-- Sidebar Menu -->
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>학사관리</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tbody>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/studentList">학생 명단 조회</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/professorList">교수 명단 조회</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/student">학생 등록</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/professor">교수 등록</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/staff">교직원 등록</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/tuition/bill" class="selected--menu">등록금 고지서 발송</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/break/list/staff">휴학 처리</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/sugang/period">수강신청 기간 설정</a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Main Content -->
    <main>
    
        <h1>등록금 고지서 발송</h1>
		<br>
        <!-- Form for Sending Tuition Bills -->
        <form action="${pageContext.request.contextPath}/tuition/create" method="post">
            <button type="submit">등록금 고지서 발송</button>
        </form>

        <!-- Alert for Successful Operation -->
        <c:if test="${not empty insertCount}">
            <script>
                alert('${insertCount}개의 등록금 고지서가 생성되었습니다.');
                history.back();
            </script>
        </c:if>
    </main>
</div>
