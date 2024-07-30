<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">
<style>
h1 {
	color: #001489;
}
</style>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="d-flex justify-content-center align-items-start" style="display: flex; min-width: 100em;">
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
					<td><a href="${pageContext.request.contextPath}/admin/department" class="selected--menu">학과</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/admin/room">강의실</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/admin/subject">강의</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/admin/tuition">단대별 등록금</a></td>
				</tr>
			</table>
		</div>
	</div>
	
	

	<main style="width: 100%; padding: 20px;">
		<h1 class="sub--title">학과 리스트</h1>
		<div class="split--div"></div>
		<a href="${pageContext.request.contextPath}/admin/departmentAdd" class="btn-edit" onclick="window.open(this.href, '_blank', 'width=720, height=1000'); return false;">학과 등록</a>
		<br>
		<div>
			 <table class="table table-striped sub--list--table">
			 <thead>
				<tr>
					<th>id</th>
					<th>학과이름</th>
					<th>단과id</th>
				</tr>
				</thead>
				  <tbody>
				<c:forEach var="department" items="${departmentList}">
					<tr>
						<td>${department.id}</td>
						<td>${department.name}</td>
						<td>${department.collegeId}</td>
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
							<span class="page-item"><a href="${pageContext.request.contextPath}/admin/department?page=${i}" class="page-link">${i}</a></span>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</main>
</div>
<%@ include file="footer.jsp"%>