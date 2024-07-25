<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
<c:when test="${user.userRole eq 'staff'}">
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
</c:when>
<c:when test="${user.userRole eq 'professor'}">
<%@ include file="/WEB-INF/views/home/professorHeader.jsp" %>
</c:when>
<c:otherwise>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>
</c:otherwise>
</c:choose>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myinfo.css">
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/user/myinfo" class="selected--menu">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/password">비밀번호 변경</a></td>
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
		<h1>내 정보 조회</h1>
		<div class="split--div"></div>
			<table border="1" class="input--table" >
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
			<c:choose>
			<c:when test="${user.userRole eq 'student'}">
				<tr>
					<th>학번</th>
					<td>${principal.id}</td>
					<th>소속</th>
					<td>${principal.deptName}</td>
				</tr>
				<tr>
					<th>학년</th>
					<td>${principal.grade}</td>
					<th>학기</th>
					<td>${principal.semester}</td>
				</tr>
				<tr>
					<th>입학일</th>
					<td>${principal.entranceDate}</td>
					<th>졸업일(졸업예정일)</th>
					<td>${principal.graduationDate}</td>
				</tr>
			</c:when>
			<c:when test="${user.userRole eq 'professor'}">
				<tr>
					<th>ID</th>
					<td>${principal.id}</td>
					<th>소속</th>
					<td>${principal.deptName}</td>
				</tr>
			</c:when>
			<c:when test="${user.userRole eq 'staff'}">
				<tr>
					<th>ID</th>
					<td>${principal.id}</td>
					<th>입사 날짜</th>
					<td>${principal.hireDate}</td>
				</tr>
			</c:when>
			</c:choose>
			</table>
			<form id="data" action="${pageContext.request.contextPath}/user/update" method="post">
			<table border="1" class="input--table" style="margin-left:-30px">
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
				<tr>
     	 			<th>성명</th>
      				<td>${principal.name}</td>
     	 			<th>생년월일</th>
      				<td>${principal.birthDate}</td>
    			</tr>
   				 <tr>
      				<th>성별</th>
      				<td>${principal.gender}</td>
      				<th>주소</th>
     				 <td id="addressField">${principal.address}</td>
    			</tr>
    			<tr>
     				 <th>연락처</th>
     				 <td id="telField">${principal.tel}</td>
      				<th>email</th>
      				<td id="emailField">${principal.email}</td>
    			</tr>
			</table>
			</form>
			<button type="submit" onclick="openCheckWindow()" class="btn btn-dark send--button" style="visibility:hidden" >변경하기</button>
			<button type="button" onclick="update()" class="btn btn-dark update--button">수정하기</button>
			<script>
				let checkWindow;
				
				function openCheckWindow() {
					checkWindow = window.open('${pageContext.request.contextPath}/user/check','checkWindow','width=600,height=400');
				}
				
				// 메시지를 받기 위한 이벤트 리스너 추가
				  window.addEventListener('message', function(event) {
				    if (event.data === 'taskCompleted') {
				      // 작업 완료 메시지를 받으면 폼을 제출
				      document.getElementById('data').submit();
				    }
				  }, false);
				
				function update() {
					let updateButton = document.querySelector(".update--button");
					let sendButton = document.querySelector(".send--button");
					sendButton.style.visibility = "visible";
					updateButton.style.visibility = "hidden";
					// 필드 정의
				    const fields = [
				      { id: "addressField", value: "${principal.address}", name: "address" },
				      { id: "telField", value: "${principal.tel}", name: "tel" },
				      { id: "emailField", value: "${principal.email}", name: "email" }
				    ];

				    // 각 필드를 입력 필드로 변경
				    fields.forEach(field => {
				      const element = document.getElementById(field.id);
				      element.innerHTML = ""; // 기존 텍스트 제거
				      const input = document.createElement("input");
				      input.type = "text";
				      input.name = field.name;
				      input.value = field.value;
				      input.classList.add("form-control");
				      element.appendChild(input);
				    });
				}
			</script>
			<hr>
			<h4>
				<span style="font-weight: 600;">학적 변동 내역</span>
			</h4>
			<table border="1" class="stat--table">
				<thead>
					<tr>
						<th>변동 일자</th>
						<th>변동 구분</th>
						<th>세부</th>
						<th>승인 여부</th>
						<th>복학 예정 연도/학기</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			
	</main>
</div>



  		<footer>
			<!-- 필요 시 -->
		</footer>

</div>
</body>
</html>