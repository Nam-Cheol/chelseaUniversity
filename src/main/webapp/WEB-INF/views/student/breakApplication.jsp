<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/document.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">

<style>
.document--layout h3 {
	font-weight: 600;
	margin-bottom: 30px;
}

.document--layout tr:last-of-type td {
	padding: 18px 8px 2px;
}

.form-container {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.form-container form {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.form-container button {
    margin-top: 20px; /* Adjust the margin as needed */
}

.demon--slayer {
	width: 80px;
	margin: 20px;
	margin-top: 30px;
	background-color: #33688F;
	border-color: #33688F;
	border-radius: 5px;
	border: none;
	padding: 5px; 
	color: white;
}
</style>
		
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
				<tbody><tr>
					<td><a href="/chelseaUniversity/user/myinfo">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/user/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/break/application" class="selected--menu">휴학 신청</a></td>
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
			</tbody></table>
				</div>
			</div>
			
		<c:choose>
			
			<c:when test="${application}">
			
				<c:if test="${not empty message}">
        			<script type="text/javascript">
            			alert("${message}");
					     window.location.href = 'list';
			        </script>
			    </c:if>
				
				 <script type='text/javascript'>
				 	 alert('이미 휴학 신청 내역이 존재합니다');
				     window.location.href = 'list';
				 </script>
			
			</c:when>
			
			<c:otherwise>
		
			<!-- 메인 div -->
			<main>
				<h1>휴학 신청</h1>
				<div class="split--div"></div>
				
				<div class="form-container">
					<form action="/chelseaUniversity/break/application" method="post" class="d-flex flex-column align-items-center">
						<div class="document--layout">
							<h3>휴학 신청서</h3>
							<table border="1">
								<tbody>
								<tr>
									<th>단 과 대</th>
									<td>${principal.collegeName}</td>
									<th>학 과</th>
									<td>${principal.deptName}</td>
								</tr>
								<tr>
									<th>학 번</th>
									<td>${principal.id}</td>
									<th>학 년</th>
									<td>${principal.grade}학년
										<input type="hidden" name="studentGrade" value="${principal.grade}">
									</td>
								</tr>
								<tr>
									<th>전 화 번 호</th>
									<td>${principal.tel}</td>
									<th>성 명</th>
									<td>${principal.name}</td>
								</tr>
								<tr>
									<th>주 소</th>
									<td colspan="3">${principal.address}</td>
								</tr>
								<tr>
									<th>기 간</th>
									<td colspan="3">
										2024년도 1학기부터
										<select name="toYear">
											<option value="2024" selected="">2024</option>
											<option value="2025">2025</option>
											<option value="2026">2026</option>
										</select>년도
										<select name="toSemester">
											<option value="1">1</option>
											<option value="2" selected="">2</option>
										</select>학기까지
									</td>
								</tr>
								<tr>
									<th>휴 학 구 분</th>
									<td colspan="3">
										<input type="radio" name="type" value="일반" id="일반" checked=""> <label for="일반" style="margin: 0">일반휴학</label>
										&nbsp;
										<input type="radio" name="type" value="임신·출산·육아" id="임신"> <label for="임신" style="margin: 0">임신·출산·육아휴학</label>
										&nbsp;
										<input type="radio" name="type" value="질병" id="질병"> <label for="질병" style="margin: 0">질병휴학</label>
										&nbsp;
										<input type="radio" name="type" value="창업" id="창업"> <label for="창업" style="margin: 0">창업휴학</label>
										&nbsp;
										<input type="radio" name="type" value="군입대" id="군입대"> <label for="군입대" style="margin: 0">군입대휴학</label>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<p>위와 같이 휴학하고자 하오니 허가하여 주시기 바랍니다.</p>									
										<br>
										<p>2024년 07월 19일</p>
									</td>
								</tr>
							</tbody></table>
						</div>
						<button type="submit" class="demon--slayer" onclick="return confirm('휴학을 신청하시겠습니까?')">신청하기</button>
					</form>
				</div>
			</main>
		</div>
		</c:otherwise>
		
		</c:choose>
	
  		<footer>
			<!-- 필요 시 -->
		</footer>

</div>
</body>
</html>
