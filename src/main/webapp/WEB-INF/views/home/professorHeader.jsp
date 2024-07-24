<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첼시대학교</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/media.css">
</head>
<body>

<header>

<p class="h-border-top"></p>
<div class="header-wrap">

<!-- s : user-utils -->
<div class="user-utils-wrap">
<ul class="user-utils">
<li>
	<a href="${pageContext.request.contextPath}/user/home">${principal.name} (${principal.id})</a>
</li>
<li>
	<a href="${pageContext.request.contextPath}/user/signin?logout=true">로그아웃</a>
</li>
</ul>
</div>
<!-- e : user-utils -->

<nav class="header-nav">
<h1 class="header-logo">
<a href="${pageContext.request.contextPath}/user/home">
<picture>
<source srcset="https://img.chelseafc.com/image/upload/f_auto,c_pad,ar_1,w_140,h_140,q_auto:best/Site%20Chelsea%20Badges/Main_Website_Badge_-_Colour.png" media="(min-width: 400px)" type="image/webp">
<img alt="첼시대학교" src="${pageContext.request.contextPath}/resources/img/Chelsea_FC_Logo.svg.png" >
</picture>
</a>
</h1>
<!-- s : gnb -->
<ul class="gnb">
<li>
<a href="${pageContext.request.contextPath}/user/home">홈</a>
</li>
<li>
<a href="${pageContext.request.contextPath}/professor/info">MY</a>
</li>
<li>
<a href="${pageContext.request.contextPath}/subject/list">수업</a>
</li>
<li>
<a href="${pageContext.request.contextPath}/notice/list">학사정보</a>
</li>
</ul>
<!-- e : gnb -->
<div class="menu-toggle-wrap">
	<button type="button" class="menu-toggle">
	<img alt="메뉴 더보기" src="${pageContext.request.contextPath}/resources/img/bars-solid.png" >
	</button>
</div>
</nav>

</div>

<div class="mobile-nav">
<p>X</p>
</div>
</header>

<body>
