<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/noticeDetail.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
    style="display: flex; min-width: 100em;">
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2>학사정보</h2>
        </div>
        <!-- 메뉴 -->
        <!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
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
                        <td><a href="/chelseaUniversity/notice/createNotice" class="selected--menu"> 공지사항 등록</a></td>
                    </tr>
                    <tr>
						<td><a href="${pageContext.request.contextPath}/admin/schedule">학사일정 등록</a></td>
					</tr>
                    
                </c:if>
            </table>
        </div>
    </div>

    <main>
        <h1>공지사항</h1>
        <div class="split--div"></div>
        <hr style="border-color:#F4FFFF; height:1px; width:85%">
        <form action="${pageContext.request.contextPath}/notice/updateNotice" method="post">
 	       <div class="category">
				<select name="category" class="input--box">
					<option value="[일반]">[일반]</option>
					<option value="[학사]">[학사]</option>
					<option value="[장학]">[장학]</option>
				</select>
			</div>
            <p>&nbsp;제목&emsp;<input type="text" name="title" value="${notice.title}" required></p>
            <hr style="border-color:#F4FFFF; height:1px; width:85%">
            <div class="contentBox">
                <p>&nbsp;내용</p>
                <textarea name="content" rows="10" cols="80" required>${notice.content}</textarea>
            </div>
            <input type="hidden" name="id" value="${notice.id}">
            <div class="list">
                <button type="submit">저장</button>
                <button type="button" onclick="location.href='${pageContext.request.contextPath}/notice/list?page=0'">목록</button>
            </div>
        </form>
    </main>
</div>
</body>
</html>
