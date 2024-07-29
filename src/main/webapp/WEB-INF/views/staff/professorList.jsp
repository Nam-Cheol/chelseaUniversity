<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">

<style>
h1 {
	color: #001489;
	border-bottom: 1px solid #ddd;
	padding: 20px 0;
}

.table-container {
	padding: 10px;
	border-spacing: 10px;
}

.table-container td {
	padding-right: 30px;
}

.table-container input {
	padding: 5px;
	outline: none;
}

.essential-sign {
	color: red;
}

.submit-btn {
	border: none;
	padding: 5px 10px;
	color: #fff;
	background-color: #001489;
	border-radius: 5px;
}

</style>

<!-- Sidebar Menu and Main Content -->
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <!-- Sidebar Menu -->
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>MY</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tbody>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/studentList">학생 명단 조회</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/professorList" class="selected--menu">교수 명단 조회</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/student">학생 등록</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/professor">교수 등록</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/tuition/bill">등록금 고지서 발송</a></td>
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
    <section>
        <h1>교수 명단 조회</h1>

        <!-- Search Form -->
        <div>
            <form action="${pageContext.request.contextPath}/user/professorList" method="get">
                <label for="dept_id">학과 번호</label>
                <input type="search" id="dept_id" name="dept_id">
                <label for="pro_id">사번</label>
                <input type="number" id="pro_id" name="pro_id">
                <button type="submit" class="submit-btn">
                    조회
                </button>
            </form>
        </div>

        <!-- Professor List Table -->
        <div>
            <table class="table-container" border="1">
                <thead>
                    <tr>
                        <th>사번</th>
                        <th>이름</th>
                        <th>생년월일</th>
                        <th>성별</th>
                        <th>주소</th>
                        <th>전화번호</th>
                        <th>이메일</th>
                        <th>학과번호</th>
                        <th>고용일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="professor" items="${professorList}">
                        <tr>
                            <td>${professor.id}</td>
                            <td>${professor.name}</td>
                            <td>${professor.birthDate}</td>
                            <td>${professor.gender}</td>
                            <td>${professor.address}</td>
                            <td>${professor.tel}</td>
                            <td>${professor.email}</td>
                            <td>${professor.deptId}</td>
                            <td>${professor.hireDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Pagination -->
<<<<<<< HEAD
			<div class="pagination">
			    <c:forEach begin="1" end="${totalPages}" var="i">
			        <c:choose>
			            <c:when test="${i == page}">
			                <span class="page-item current-page">${i}</span>
			            </c:when>
			            <c:otherwise>
			                <span class="page-item"><a href="${pageContext.request.contextPath}/user/professorList?page=${i}" class="page-link">${i}</a></span>
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			</div>
=======
<!-- Pagination -->

<ul class="page--list">
                <c:forEach begin="1" end="${totalPages}" var="i">
                    <c:choose>
                        <c:when test="${i == currentPage}">
                            <c:choose>
                                <c:when test="${deptId != null || proId != null}">
                                    <li><a href="${pageContext.request.contextPath}/user/professorList?page=${i}&dept_id=${deptId}&pro_id=${proId}" class="selected--page">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageContext.request.contextPath}/user/professorList?page=${i}" class="selected--page">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${deptId != null || proId != null}">
                                    <li><a href="${pageContext.request.contextPath}/user/professorList?page=${i}&dept_id=${deptId}&pro_id=${proId}">${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageContext.request.contextPath}/user/professorList?page=${i}">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                        
                    </c:choose>
        </c:forEach>

>>>>>>> main
        </div>
    </section>
</div>
