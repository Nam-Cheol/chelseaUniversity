<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<div class="d-flex justify-content-center align-items-start container">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>등록</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/college">단과대학</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/department">학과</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/room">강의실</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/subject">강의</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/tuition" class="selected--menu">단대별 등록금</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/schedule">학사일정</a></td>
                </tr>
            </table>
        </div>
    </div>

    <main class="main-content">
        <div class="form-container">
            <h1>단대별 등록금 목록</h1>
        	<div class="split--div"></div>
        	<a href="${pageContext.request.contextPath}/admin/tuitionAdd" class="btn-edit" onclick="window.open(this.href, '_blank', 'width=720, height=1000'); return false;">등록금 추가</a>
        	<br>
            <div class="table-container">
                <table class="table table-striped sub--list--table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>단대이름</th>
                            <th>금액</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tuition" items="${tuitionList}">
                            <tr>
                                <td>${tuition.id}</td>
                                <td>${tuition.name}</td>
                                <td>${tuition.amount}</td>
                            </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</div>

<%@ include file="footer.jsp"%>
