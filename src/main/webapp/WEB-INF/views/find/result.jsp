<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기 결과</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f0f8ff;
    color: #333;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.resultBox {
    background-color: #ffffff;
    border: 2px solid #1e90ff;
    border-radius: 10px;
    padding: 30px;
    box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
    text-align: center;
    width: 40%;
}

h3 {
    color: #1e90ff;
    margin-bottom: 20px;
}

button {
    background-color: #1e90ff;
    color: white;
    border: none;
    padding: 10px 20px;
    text-transform: uppercase;
    font-weight: bold;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 10px;
}

button:hover {
    background-color: #1c86ee;
}
</style>
</head>
<body>
    <div class="resultBox">
        <c:choose>
            <c:when test="${param.result eq 'id'}">
                <h3>회원님의 아이디는 ${param.id} 입니다.</h3>
            </c:when>
            <c:when test="${param.result eq 'password'}">
                <h3>회원님의 비밀번호는 ${param.password} 입니다.</h3>
            </c:when>
            <c:otherwise>
                <script>alert("잘못된 요청입니다.")</script>
            </c:otherwise>
        </c:choose>
        <button onclick="window.close()">로그인</button>
    </div>
</body>
</html>