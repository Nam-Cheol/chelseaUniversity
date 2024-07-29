<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>등록</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/college">단과대학</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/department">학과</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/room">강의실</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/subject" class="selected--menu">강의</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/tuition">단대별 등록금</a></td>
                </tr>
                <tr>	
				<td><a href="${pageContext.request.contextPath}/admin/schedule">학사일정</a></td>
				</tr>
            </table>
        </div>
    </div>

    <main style="width: 100%; padding: 20px;">
        <h2>강의 등록</h2>
         <div class="split--div"></div>
        <div class="sub--filter">
        <form action="${pageContext.request.contextPath}/admin/subject/create-subject" method="post">
     	<div>
        	<input type="hidden" name="page" value="1">
			<label for="type">강의이름 <input type="text" id="subject-name" name="subject-name" placeholder="데이터통신"></label>
			<label for="type">교수id <input type="text" id="professor-id" name="professor-id" placeholder="23000001  foreign key"></label>
			<label for="type">강의실id <input type="text" id="romm-id" name="romm-id" placeholder="E601  foreign key"></label>
			<br>
			<label for="type">학과id <input type="text" id="dept-id" name="dept-id" placeholder="101  foreign key"></label>
			<label for="type">구분 <input type="text" id="type" name="type" placeholder="전공 or 교양"></label>
			<label for="type">강의연도 <input type="text" id="subject-year" name="subject-year" placeholder="2024"></label>
			<br>
			<label for="type">학기 <input type="text" id="semester" name="semester" placeholder="1 or 2"></label>
			<label for="type">요일 <input type="text" id="subject-day" name="subject-day" placeholder="월 <--- 요일을 빼고 입력해주세요"></label>
			<label for="type">시작시간 <input type="text" id="start-time" name="start-time" placeholder="9 <--- 09:00 시작"></label>
			<br>
			<label for="type">종료시간 <input type="text" id="end-time" name="end-time" placeholder="12 <--- 12:00 종료"></label>
			<label for="type">학년 <input type="text" id="grades" name="grades" placeholder="1,2,3,4"></label>
			<label for="type">최대정원 <input type="text" id="capacity" name="capacity" placeholder="20"></label>
			<br>
			<label for="type">현재인원 <input type="text" id="number-of-student" name="number-of-student" placeholder="5"></label>
			<button type="submit">생성</button>
        </div>
        </form> 
        </div>	      
        <br>
        <p>강의 목록</p>
        <br>
        <div>
             <table class="table table-striped sub--list--table">
              <thead>
                <tr>
                    <th>강의id</th>
                    <th>강의이름</th>
                    <th>교수id</th>
                    <th>강의실id</th>
                    <th>학과id</th>
                    <th>구분</th>
                    <th>강의연도</th>
                    <th>학기</th>
                    <th>요일</th>
                    <th>시작시간</th>
                    <th>종료시간</th>
                    <th>학년</th>
                    <th>최대정원</th>
                    <th>현재인원</th>
                </tr>
                </thead>
                 <tbody>
                <c:forEach var="subject" items="${subjectList}">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td>
                    <td>${subject.professorId}</td>
                    <td>${subject.roomId}</td>
                    <td>${subject.deptId}</td>
                    <td>${subject.type}</td>
                    <td>${subject.subYear}</td>
                    <td>${subject.semester}</td>
                    <td>${subject.subDay}</td>
                    <td>${subject.startTime}</td>
                    <td>${subject.endTime}</td>
                    <td>${subject.grades}</td>
                    <td>${subject.capacity}</td>
                    <td>${subject.numOfStudent}</td>
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
			                <span class="page-item"><a href="${pageContext.request.contextPath}/admin/subject?page=${i}" class="page-link">${i}</a></span>
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			</div>
        </div>
    </main>
</div>

<%@ include file="footer.jsp"%>

