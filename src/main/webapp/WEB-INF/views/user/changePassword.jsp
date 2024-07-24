<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/password.css">
<c:choose>
<c:when test="${param.change eq 'true'}"><script>alert("비밀번호가 변경되었습니다!!")</script></c:when>
<c:when test="${param.change eq 'false'}"><script>alert("비밀번호 변경에 실패하였습니다")</script></c:when>
<c:when test="${param.change eq 'overlap'}"><script>alert("이전 비밀번호와 같은 비밀번호는 사용할수없습니다.")</script></c:when>
<c:when test="${param.pass eq 'false'}"><script>alert("현재 비밀번호가 틀렸습니다.")</script></c:when>
</c:choose>
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/student/info" >내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/password" class="selected--menu">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/application">휴학 신청</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/list">휴학 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/list">등록금 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/tuition/payment">등록금 납부 고지서</a></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 메인 div -->
	<main>
		<h1>비밀번호 변경</h1>
		<div class="split--div"></div>
			<div class="changeBox">
			<form action="${pageContext.request.contextPath}/user/changepassword" method="post">
			<table border="1" class="input--table" >
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" id="original" name="original"></td>
				</tr>
				<tr>
					<th>변경 하실비밀번호</th>
					<td><input type="password" id="first"></td>
				</tr>
				<tr>
					<th>변경 비밀번호 확인</th>
					<td><input type="password" name="password" id="second"></td>
				</tr>
			</table>
			<input type="submit" value="변경하기" disabled value="변경하기" class="change">
			<script>
			function check() {
				let original = document.getElementById("original");
				let first = document.getElementById("first");
				let second = document.getElementById("second");
				if(first.value == "" && second.value == "" && original.value == "") {
					alert("비밀번호를 입력해주세요")
				} else if(first.value == second.value) {
					let pass = document.getElementsByClassName("change");
					pass[0].disabled = false;
					console.log(second.value);
				} 
				else {
					alert("비밀번호가 맞지않습니다.")
				}
			}
			</script>
			</form>
			</div>
			<input type="submit" value="확인하기" onclick='check()'/ class="checkPass">
	</main>
	</div>
</body>
</html>