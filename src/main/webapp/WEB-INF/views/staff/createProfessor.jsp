<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">

<!-- Custom CSS for this page -->
<style>

.table-container {
	padding: 10px;
	border-spacing: 10px;
}

.table-container td {
	padding-right: 30px;
}

.table-container input {
	padding: 5px;
	outline: none;
}

.essential-sign {
	color: red;
}

.submit-btn {
	border: none;
	padding: 5px 10px;
	color: #fff;
	background-color: #001489;
	border-radius: 5px;
}
</style>

    <div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
        <!-- Sidebar Menu -->
        <div class="sub--menu">
            <div class="sub--menu--top">
                <h2>학사관리</h2>
            </div>
            <div class="sub--menu--mid">
                <table class="sub--menu--table" border="1">
                    <tbody>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/user/studentList">학생 명단 조회</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/user/professorList">교수 명단 조회</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/user/student">학생 등록</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/user/professor" class="selected--menu">교수 등록</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/tuition/bill">등록금 고지서 발송</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/break/list/staff">휴학 처리</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/sugang/period">수강신청 기간 설정</a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    <main style="width: 100%; padding: 20px;">
            <h1 class="sub--title">교수 등록</h1>
            <div class="split--div"></div>
            <form action="${pageContext.request.contextPath}/user/professor" method="post">
                <table class="table-container">
                    <tr>
                        <td><label for="name">이름<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="name" name="name" placeholder="교수 이름을 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="birth">생년월일</label><span class="essential-sign">&#42;</span></td>
                        <td><input type="date" id="birth" name="birth" placeholder="생년월일을 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label>성별</label><span class="essential-sign">&#42;</span></td>
                        <td>
                            <label for="male">남성</label> 
                            <input type="radio" id="male" name="gender" value="남성" required> 
                            <label for="female">여성</label> 
                            <input type="radio" id="female" name="gender" value="여성">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="address">주소</label><span class="essential-sign">&#42;</span></td>
                        <td><input type="text" id="address" name="address" placeholder="주소를 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="tel">전화번호</label><span class="essential-sign">&#42;</span></td>
                        <td><input type="tel" id="tel" name="tel" placeholder="전화번호를 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="email">이메일</label><span class="essential-sign">&#42;</span></td>
                        <td><input type="email" id="email" name="email" placeholder="이메일을 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="dept-id">과ID</label><span class="essential-sign">&#42;</span></td>
                        <td><input type="text" id="dept-id" name="deptId" placeholder="소속된 학과ID를 입력하세요." required></td>
                    </tr>
                </table>
                <button type="submit" class="submit-btn">입력하기</button>
            </form>
            
            <c:if test="${not empty createProfessorDto}">
                <%
                out.println("<script>alert('교수 정보 등록에 성공했습니다.'); history.back(); </script>");
                %>
            </c:if>
        </main>
    </div>
