<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
    <!-- 세부 메뉴 div-->
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>등록</h2>
        </div>
        <!-- 메뉴 -->
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/college">단과대학</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/department">학과</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/room" class="selected--menu">강의실</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/subject">강의</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/tuition">단대별 등록금</a></td>
                </tr>
            </table>
        </div>
    </div>

    <!-- 메인 div -->
    <main style="width: 100%; padding: 20px;">
        <h1>강의실 등록</h1>
        <div class="split--div"></div>
        <div class="sub--filter">
        <form action="${pageContext.request.contextPath}/admin/room/create-room" method="post">
        <div>
        	<input type="hidden" name="page" value="1">
			<label for="type">강의실id <input type="text" id="room-id" name="room-id" placeholder="A001"></label>
			<label for="type">단과대id <input type="text" id="college-id" name="college-id" placeholder="1, 2, 3, 4 ..."></label>
			<button type="submit">생성</button>
        </div>
        </form>
        </div>

		<div class="sub--filter">
        <form action="${pageContext.request.contextPath}/admin/room/edit-room" method="post">
         <div>
        	<input type="hidden" name="page" value="1">
			<label for="type">수정할 강의실id <input type="text" id="room-id" name="room-id" placeholder="A001"></label>
			<label for="type">단과대id <input type="text" id="college-id" name="college-id" placeholder="1, 2, 3, 4 ..."></label>
            <button type="submit">수정</button>
        </div>
        </form>
        </div>

        <p>강의실 목록</p>
        <br>

        <div>
            <table class="table table-striped sub--list--table">
             <thead>
                <tr>
                    <th>강의실id</th>
                    <th>단과대id</th>
                </tr>
               </thead>
                <tbody>
                <c:forEach var="room" items="${roomList}">
                    <tr>
                        <th>${room.id}</th>
                        <th>${room.collegeId}</th>
                    </tr>
                </c:forEach>
                 </tbody>
            </table>
            <div class="pagination">
			    <c:forEach begin="1" end="${totalPages}" var="i">
			        <c:choose>
			            <c:when test="${i == page}">
			                <span class="page-item current-page">${i}</span>
			            </c:when>
			            <c:otherwise>
			                <span class="page-item"><a href="${pageContext.request.contextPath}/admin/room?page=${i}" class="page-link">${i}</a></span>
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			</div>
        </div>
    </main>
</div>

<%@ include file="footer.jsp"%>