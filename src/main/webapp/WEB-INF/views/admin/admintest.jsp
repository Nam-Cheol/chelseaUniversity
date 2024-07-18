<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>어드민 테스트</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<h2>단과대학 등록</h2>
	<form action="create-college" method="post">
		<label for="title"> 단과이름 : </label>
		<input type="text" id="title" name="title" value="ㅇㅇ대학">
		<button type="submit">등록</button>
		<button type="submit">삭제</button>
	</form>
	<br>
	<a href="read-college">단과대학 목록</a>
	
</body>
</html>