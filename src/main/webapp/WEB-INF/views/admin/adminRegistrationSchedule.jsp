<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp"%>

<div class="d-flex justify-content-center align-items-start">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>등록</h2>
        </div>
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/chelseaUniversity/notice/list?page=0">공지사항</a></td>
				</tr>
				<tr>
					<td><a href="/chelseaUniversity/schedule/list">학사일정</a></td>
				</tr>
				<c:if test="${user.userRole eq 'staff'}">
					<tr>
						<td><a href="/chelseaUniversity/notice/createNotice"> 공지사항 등록</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/admin/schedule" class="selected--menu">학사일정 등록</a></td>
					</tr>
				</c:if>
			</table>
		</div>
    </div>
    
    <main class="main-content">
        <h1 class="sub--title">학사일정</h1>
        <div class="split--div"></div>
        <a href="${pageContext.request.contextPath}/admin/scheduleAdd" class="btn-edit" onclick="window.open(this.href, '_blank', 'width=720, height=1000'); return false;">학사일정 등록</a>
        <br>
        <div class="table-container">
            <table class="table table-striped sub--list--table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>교직원id</th>
                        <th>시작날짜</th>
                        <th>종료날짜</th>
                        <th>일정내용</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="schedule" items="${scheduleList}">
                        <tr>
                            <td>${schedule.id}</td>
                            <td>${schedule.staffId}</td>
                            <td>${schedule.startDay}</td>
                            <td>${schedule.endDay}</td>
                            <td>${schedule.information}</td>
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
                            <span class="page-item"><a href="${pageContext.request.contextPath}/admin/schedule?page=${i}" class="page-link">${i}</a></span>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </div>
    </main>
</div>

<%@ include file="footer.jsp"%>