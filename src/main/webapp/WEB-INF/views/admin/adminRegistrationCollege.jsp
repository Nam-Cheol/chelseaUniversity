<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>등록</h2>
        </div>
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/college" class="selected--menu">단과대학</a></td>
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
                    <td><a href="${pageContext.request.contextPath}/admin/tuition">단대별 등록금</a></td>
                </tr>
                <tr>	
				<td><a href="${pageContext.request.contextPath}/admin/schedule">학사일정</a></td>
				</tr>
            </table>
        </div>
    </div>

    <main style="width: 100%; padding: 20px;">
        <h2>단과대학 등록</h2>
        <div class="split--div"></div>
       <div class="sub--filter">
        <form action="${pageContext.request.contextPath}/admin/create-college" method="post">
        
			<div>
			<input type="hidden" name="page" value="1">
			<label for="type">단과이름  <input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학"></label>
            <button type="submit">생성</button>
             </div>
        </form>
        </div>   
        <div class="sub--filter">
        <form action="${pageContext.request.contextPath}/admin/edit-college" method="post">
        <div>
        <label for="type">수정할 id  <input type="text" id="college-id" name="college-id" placeholder="1 , 2 , 3 ...."></label>
        <label for="type">단과이름  <input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학"></label>
        <button type="submit">수정</button>
        </div>
        </form>  
                </div>
     
        <p>단과 대학 리스트</p>
        
        <br>
        
        <table class="table table-striped sub--list--table">
        <thead>
            <tr>
                <th>id</th>
                <th>단과이름</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="college" items="${collegeList}">
            <tr>
                <td>${college.id}</td>
                <td>${college.name}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</div>

<%@ include file="footer.jsp"%>