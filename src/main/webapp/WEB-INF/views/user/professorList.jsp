<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>


<section>
	<h1>교수 명단 조회</h1>

	<!-- 교수 사번과 학과 번호로 검색 -->
	<div>
		<form action="" method="get">
			<label for="dept_id">학과 번호</label> 
			<input type="search" id="dept_id" name="dept_id"> 
			<label for="pro_id">사번</label> 
			<input type="number" id="pro_id" name="pro_id">
			<button type="submit">
				<div class="">
					<p>조회</p>
					<div>
						<img alt="" src="">
					</div>
				</div>
			</button>
			<!-- <select name ="limit">
			<option value="20">20개씩</option>
			<option value="40">40개씩</option>
			<option value="60">60개씩</option>
			</select> -->
		</form>
	</div>

	<!-- 교수 리스트 테이블 -->
	<div>
		<table border="1">
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
				<c:forEach var="professorList" items="${professorList}">
					<tbody>
						<tr>
							<td>${professorList.id}</td>
							<td>${professorList.name}</td>
							<td>${professorList.birthDate}</td>
							<td>${professorList.gender}</td>
							<td>${professorList.address}</td>
							<td>${professorList.tel}</td>
							<td>${professorList.email}</td>
							<td>${professorList.deptId}</td>
							<td>${professorList.hireDate}</td>
						</tr>
					</tbody>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="pagination">
			<!-- index for  -->
			<c:forEach begin="1" end="${listCount}" var="i">
				<c:choose>
					<c:when test="${i == page}">
						<span class="current-page">${i}</span>
					</c:when>
					<c:otherwise>
						<span><a href="${pageContext.request.contextPath}/user/professorList?pro_list_page=${i}">${i}</a></span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>

</section>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>