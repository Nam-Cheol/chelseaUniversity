<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">
<style>

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
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>학사관리</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/user/studentList" class="selected--menu">학생 명단 조회</a></td>
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
                        <td><a href="${pageContext.request.contextPath}/tuition/bill">등록금 고지서 발송</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/break/list/staff">휴학 처리</a></td>
                    </tr>
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/sugang/period">수강신청 기간 설정</a></td>
                    </tr>
            </table>
        </div>
    </div>

       <main style="width: 100%; padding: 20px;">
        <h1 class="sub--title">학생 명단 조회</h1>
        <div class="split--div"></div>
        <br>
       		 <div class="sub--filter">	
            <form action="${pageContext.request.contextPath}/user/studentList" method="get">
            	 <div>
	                <label for="dept_id">학과 번호 <input type="search" id="dept_id" name="dept_id"></label>
	                <label for="stu_id">학번 <input type="search" id="stu_id" name="stu_id"></label>
					<button type="submit" class="submit-btn">조회</button>
       			 </div>
            </form>
		</div>
		
            <form action="">
                <button type="submit" class="submit-btn">새학기 적용</button>
            </form>


            <table class="table table-striped sub--list--table">
                <thead>
                    <tr>
                        <th>학번</th>
                        <th>이름</th>
                        <th>생년월일</th>
                        <th>성별</th>
                        <th>주소</th>
                        <th>전화번호</th>
                        <th>이메일</th>
                        <th>학과번호</th>
                        <th>학년</th>
                        <th>학기</th>
                        <th>입학일</th>
                        <th>졸업일(졸업예정일)</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${studentList}">
                        <tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.birthDate}</td>
                            <td>${student.gender}</td>
                            <td>${student.address}</td>
                            <td>${student.tel}</td>
                            <td>${student.email}</td>
                            <td>${student.deptId}</td>
                            <td>${student.grade}</td>
                            <td>${student.semester}</td>
                            <td>${student.entranceDate}</td>
                            <td>${student.graduationDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

			<div class="pagination">
			    <c:forEach begin="1" end="${totalPages}" var="i">
			        <c:choose>
			            <c:when test="${i == page}">
			                <span class="page-item current-page">${i}</span>
			            </c:when>
			            <c:otherwise>
			                <span class="page-item"><a href="${pageContext.request.contextPath}/user/studentList?page=${i}" class="page-link">${i}</a></span>
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			</div>
			</main>
			</div>
<%@ include file="footer.jsp"%>;
