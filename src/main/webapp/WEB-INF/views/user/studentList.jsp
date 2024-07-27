<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>

		<!-- 세부 메뉴 + 메인 -->
		<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
			<!-- 세부 메뉴 div-->
			<div class="sub--menu">
				<div class="sub--menu--top">
					<h2>MY</h2>
				</div>
				<!-- 메뉴 -->
				<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
				<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tbody><tr>
					<td><a href="/chelseaUniversity/user/studentList" class="selected--menu">학생 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/professorList">교수 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/student">학생 등록</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/professor">교수 등록</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/bill">등록금 고지서 발송</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/list/staff">휴학 처리</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/sugang/period">수강신청 기간 설정</a></td>
				</tr>
			</tbody></table>
				</div>
			</div>


<section>
	<h1>학생 명단 조회</h1>

	<!-- 학생 학과 번호와 학번으로 검색 -->
	<div>
		<form action="${pageContext.request.contextPath}/user/studentList" method="get">
			<label for="dept_id">학과 번호</label> 
			<input type="search" id="dept_id" name="dept_id"> 
			<label for="stu_id">학번</label> 
			<input type="search" id="stu_id" name="stu_id">
			<button type="submit">
				<div class="">
					<p>조회</p>
					<div>
						<img alt="" src="">
					</div>
				</div>
			</button>
			
			<select name ="limit">
			<option value="20" selected="selected">20개씩</option>
			<option value="40">40개씩</option>
			<option value="60">60개씩</option>
			</select>
			
		</form>
		
		<form action="">
			<button type="submit">
				<div class="">
					<p>새학기 적용</p>
				</div>
			</button>
		</form>
	</div>

	<!-- 학생 리스트 테이블 -->
	<div>

		<table border="1">
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
			<c:forEach var="studentList" items="${studentList}">
				<tbody>
					<tr>
						<td>${studentList.id}</td>
						<td>${studentList.name}</td>
						<td>${studentList.birthDate}</td>
						<td>${studentList.gender}</td>
						<td>${studentList.address}</td>
						<td>${studentList.tel}</td>
						<td>${studentList.email}</td>
						<td>${studentList.deptId}</td>
						<td>${studentList.grade}</td>
						<td>${studentList.semester}</td>
						<td>${studentList.entranceDate}</td>
						<td>${studentList.graduationDate}</td>
					</tr>
				</tbody>
			</c:forEach>
			<c:if test="${not empty oneStudent }">
				<tbody>
					<tr>
						<td>${oneStudent.id}</td>
						<td>${oneStudent.name}</td>
						<td>${oneStudent.birthDate}</td>
						<td>${oneStudent.gender}</td>
						<td>${oneStudent.address}</td>
						<td>${oneStudent.tel}</td>
						<td>${oneStudent.email}</td>
						<td>${oneStudent.deptId}</td>
						<td>${oneStudent.grade}</td>
						<td>${oneStudent.semester}</td>
						<td>${oneStudent.entranceDate}</td>
						<td>${oneStudent.graduationDate}</td>
					</tr>
				</tbody>
			</c:if>
		</table>

		<div class="pagination">
			<!-- index for  -->
			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${i == currentPage}">
						<span class="current-page">${i}</span>
					</c:when>
					<c:otherwise>
						<span><a href="${pageContext.request.contextPath}/user/studentList?page=${i}">${i}</a></span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>

</section>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>