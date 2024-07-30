<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">

<style>
	main form button{
	padding: 10px;
	margin: 10px;
	}
	
	p {
	font-size: 22px;
	}
	
	
</style>
    <div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
        <div class="sub--menu">
            <div class="sub--menu--top">
                <h2>학사관리</h2>
            </div>
            <div class="sub--menu--mid">
                <table class="sub--menu--table" border="1">
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
                            <td><a href="${pageContext.request.contextPath}/user/professor">교수 등록</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/user/staff">교직원 등록</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/tuition/bill">등록금 고지서 발송</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/break/list/staff">휴학 처리</a></td>
                        </tr>
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/sugang/period" class="selected--menu">수강신청 기간 설정</a></td>
                        </tr>
                </table>
            </div>
        </div>

         <main style="width: 100%; padding: 20px;">
            <h1 class="sub--title">수강 신청 기간 설정</h1>
            <div class="split--div"></div>
            <c:if test="${SUGANG_PERIOD == 0}">
                <p>현재 예비 수강 신청 기간입니다.</p>
                <br>
                <form action="${pageContext.request.contextPath}/sugang/updatePeriod1" method="post">
                    <button type="submit">수강신청 기간 시작하기</button>
                </form>
            </c:if>

            <!-- 수강신청 시작 버튼 눌렀을 때 -->
            <c:if test="${SUGANG_PERIOD == 1}">
                <p>현재 수강 신청 기간입니다.</p>
                 <br>
                <form action="${pageContext.request.contextPath}/sugang/updatePeriod2" method="post">
                    <button type="submit">수강신청 종료하기</button>
                </form>
            </c:if>

            <!-- 수강신청 종료 버튼 눌렀을 때 -->
            <c:if test="${SUGANG_PERIOD == 2}">
                <p>이번 학기 수강 신청 기간이 종료되었습니다. 예비 수강신청 기간을 시작하시겠습니까?</p>
                 <br>
                <form action="${pageContext.request.contextPath}/sugang/updatePeriod0" method="post">
                    <button type="submit">예비수강신청 기간 시작하기</button>
                </form>
            </c:if>
        </main>
    </div>
  <%@ include file="footer.jsp"%>

