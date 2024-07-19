<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어드민 테스트</title>
<style type="text/css">

    body {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
    }

    .college-box {
        height: 300px;
        width: 300px;
        background-color: #ffffff; 
        border-radius: 8px; 
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        padding: 20px;
        box-sizing: border-box;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    h2 {
        background-color: #003399; 
        color: #ffffff; 
        width: 100%;
        text-align: center;
        padding: 10px;
        border-radius: 5px;
        margin: -20px -20px 20px -20px; 
    }
    
    label, input, button, a {
        margin: 5px 0;
    }

    button {
        background-color: #0056b3; 
        color: #ffffff;
        border: none;
        padding: 10px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        margin: 20px;
    }

    button:hover {
        background-color: #004494;
    }

    a {
        color: #ffffff; 
        text-decoration: none;
        margin-top: 20px;
        display: block;
        font-size: 16px;
    }

    a:hover {
        text-decoration: underline;
    }

</style>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="college-box">
    <h2>단과대학 등록</h2>
    <form action="create-college" method="post">
        <label for="college-name">단과이름:</label>
        <input type="text" id="college-name" name="college-name" value="ㅇㅇ대학">
        <br>
        <button type="submit">등록</button>
        <button type="submit">삭제</button>    
    </form>
    <a href="read-college">단과대학 목록</a>
</div>
</body>
</html>
