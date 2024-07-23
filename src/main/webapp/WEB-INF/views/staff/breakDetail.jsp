<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<h1>휴학 처리</h1>
<
<table>
	<tr>
		<th>단과대</th>
		<td>${college.name}</td>
		<th>학과</th>
		<td>${deptInfo.name}</td>
	</tr>
	<tr>
		<th>학번</th>
		<td>${studentInfo.id}</td>
		<th>학년</th>
		<td>${studentInfo.grade}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${studentInfo.tel}</td>
		<th>성명</th>
		<td>${studentInfo.name}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${studentInfo.address}</td>
	</tr>
	<tr>
		<th>기간</th>
		<td>${breakApp.fromYear}년도${breakApp.fromSemester}학기부터${breakApp.toYear}년도 ${breakApp.toSemester}학기까지</td>
	</tr>
	<tr>
		<th>휴학 구분</th>
		<td>${breakApp.type}휴학</td>
	</tr>
	<tr>
		<p>위와 같이 휴학하고자 하오니 허가하여 주시기 바랍니다.</p>
	</tr>
</table>

<form action="" method="post">
	<button type=submit>승인하기</button>
</form>

<form action="" method="post">
	<button type=submit>반려하기</button>
</form>

<%@ include file="/WEB-INF/views/home/footer.jsp"%>