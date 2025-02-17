<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${principal == null}"><% response.sendRedirect(request.getContextPath() + "/user/signin"); %></c:if>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/password.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<c:choose>
    <c:when test="${param.change eq 'true'}"><script>alert("비밀번호가 변경되었습니다!!")</script></c:when>
    <c:when test="${param.change eq 'false'}"><script>alert("비밀번호 변경에 실패하였습니다")</script></c:when>
    <c:when test="${param.change eq 'overlap'}"><script>alert("이전 비밀번호와 같은 비밀번호는 사용할 수 없습니다.")</script></c:when>
    <c:when test="${param.pass eq 'false'}"><script>alert("현재 비밀번호가 틀렸습니다.")</script></c:when>
</c:choose>
<div class="d-flex justify-content-start align-items-start" style="display:flex; min-width: 100em;">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>MY</h2>
        </div>
        <!-- 메뉴 -->
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="/chelseaUniversity/user/myinfo">내 정보 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/chelseaUniversity/user/password" class="selected--menu">비밀번호 변경</a></td>
                </tr>
                <c:if test="${user.userRole ne 'professor'}">
                <c:if test="${user.userRole ne 'staff'}">
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
                </c:if>
                </c:if>
            </table>
        </div>
    </div>

    <!-- 메인 div -->
    <main>
        <h1 class="sub--title">비밀번호 변경</h1>
        <div class="split--div"></div>
        <div class="changeBox">
            <form action="${pageContext.request.contextPath}/user/changepassword" method="post">
                <table border="1" class="input--table">
                    <tr>
                        <th>현재 비밀번호</th>
                        <td><input type="password" id="original" name="original"></td>
                    </tr>
                    <tr>
                        <th>변경 하실 비밀번호</th>
                        <td><input type="password" id="first"></td>
                    </tr>
                    <tr>
                        <th>변경 비밀번호 확인</th>
                        <td><input type="password" name="password" id="second"></td>
                    </tr>
                </table>
                <div class="button-group">
                    <input type="submit" value="변경하기" disabled class="change demon--slayer" style="background-color:gray">
                    <input type="button" value="확인하기" onclick="checkPassword()" class="checkPass demon--slayer">
                </div>
                <script>
                    function checkPassword() {
                        let original = document.getElementById("original");
                        let first = document.getElementById("first");
                        let second = document.getElementById("second");
                        if (first.value === "" || second.value === "" || original.value === "") {
                            alert("비밀번호를 입력해주세요");
                        } else if (first.value === second.value) {
                            let pass = document.getElementsByClassName("change");
                            pass[0].disabled = false;
                            pass[0].style.backgroundColor = "blue";
                            console.log("하이");
                        } else {
                            alert("비밀번호가 맞지 않습니다.");
                        }
                    }
                </script>
            </form>
        </div>
    </main>
</div>
</body>
</html>
