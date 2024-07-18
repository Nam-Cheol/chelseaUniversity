<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어드민 테스트</title>
<style type="text/css">

	body{
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100vh;
	}

	.college-box{
		background-color: #f4f4f4;
	}

	h2{
		background-color: gray;
	}
	
</style>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="college-box">
	<h2>단과대학 등록</h2>
	<form action="create-college" method="post">
		<label for="college-name"> 단과이름 : </label>
		<input type="text" id="college-name" name="college-name" value="ㅇㅇ대학">
		<br><br>
		<button type="submit">등록</button>
		<button type="submit">삭제</button>	
	</form>
	<br>
	<a href="read-college">단과대학 목록</a>
</div>
</body>
</html>