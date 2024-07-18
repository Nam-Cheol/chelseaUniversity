<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>

<section>
	<h1>학생 명단 조회</h1>
	
	<!-- 검색 -->
	<div>
	<form action="" method="get">
		<label for="">학과 번호</label>
		<input type="" >
		<label for="">학번</label>
		<input type="number" >
		<button type="submit">
			<div class="">
				<p>조회</p>
				<div>
					<img alt="" src="">
				</div>
			</div>
		</button>
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
		<tbody>
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
	</div>
	
</section>

<%@ include file="/WEB-INF/views/home/footer.jsp" %>