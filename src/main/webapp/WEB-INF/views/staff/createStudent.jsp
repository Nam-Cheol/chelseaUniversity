<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">

<!-- Custom CSS for this page -->
<style>
h1 {
	color: #001489;
	border-bottom: 1px solid #ddd;
	padding: 20px 0;
}

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

<section>
    <div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
        <!-- Sidebar Menu -->
        <div class="sub--menu">
            <div class="sub--menu--top">
                <h2>MY</h2>
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
                            <td><a href="${pageContext.request.contextPath}/user/student" class="selected--menu">학생 등록</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/user/professor">교수 등록</a></td>
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

        <!-- Main Content -->
        <main>
            <h1>학생 등록</h1>
            <form action="${pageContext.request.contextPath}/user/student" method="post">
                <table class="table-container">
                    <tr>
                        <td><label for="name">이름<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="name" name="name" placeholder="학생 이름을 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="birth">생년월일<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="date" id="birth" name="birth" placeholder="생년월일을 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label>성별<span class="essential-sign">&#42;</span></label></td>
                        <td>
                            <label for="male">남성</label>
                            <input type="radio" id="male" name="gender" value="남성" required>
                            <label for="female">여성</label>
                            <input type="radio" id="female" name="gender" value="여성">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="address">주소<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="address" name="address" placeholder="주소를 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="tel">전화번호<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="tel" name="tel" maxlength="13" pattern="^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$" title="하이픈(-)포함하여 숫자 13자리 입력" placeholder="전화번호를 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="email">이메일<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="email" id="email" name="email" placeholder="이메일을 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="dept-id">학과ID<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="dept-id" name="deptId" pattern="^[0-9]{3}$" title="999 이하 숫자만 입력" placeholder="학과ID를 입력하세요." required></td>
                    </tr>
                    <tr>
                        <td><label for="entranceDate">입학일<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="date" id="entranceDate" name="entranceDate" placeholder="입학일을 입력하세요." required></td>
                    </tr>
                </table>
                <button type="submit" class="submit-btn">입력하기</button>
            </form>

            <c:if test="${not empty createStudentDto}">
                <%
                out.println("<script>alert('학생 정보 등록에 성공했습니다.'); history.back(); </script>");
                %>
            </c:if>
        </main>
    </div>
</section>