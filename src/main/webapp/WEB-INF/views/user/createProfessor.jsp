<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>

<h1>교수 등록</h1>

<div>
	<form action="${pageContext.request.contextPath}/user/professor" method="post">
		<label for="name">이름</label>
		<input type="text" id="name" name="name" placeholder="학생 이름을 입력하세요." required>
		
		<label for="birth">생년월일</label>
		<input type="date" id="birth" name="birth" placeholder="생년월일을 입력하세요." required>
		
		<label>성별</label>
		<label for="male">남성</label>
		<input type="radio" id="male" name="gender" required>
		<label for="female">여성</label>
		<input type="radio" id="female" name="gender">
		
		<label for="address">주소</label>
		<input type="text" id="address" name="address" placeholder="주소를 입력하세요." required>
		
		<label for="tel">전화번호</label>
		<input type="tel" id="tel" name="tel" placeholder="전화번호를 입력하세요." required>
		
		<label for="email">이메일</label>
		<input type="email" id="email" name="email" placeholder="이메일을 입력하세요." required>
		
		<label for="dept-id">과ID</label>
		<input type="number" id="dept-id" name="deptId" placeholder="학과ID를 입력하세요." required>
		
		<button type="submit">입력하기</button>
	</form>
</div>

<%@ include file="/WEB-INF/views/home/footer.jsp" %>