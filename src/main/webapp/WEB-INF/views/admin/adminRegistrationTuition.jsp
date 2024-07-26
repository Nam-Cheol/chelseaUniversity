<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section>
    <div class="college-box">
        <div class="registration-list-container">
            <div>
                <h2 class="registration-list-top">등록</h2>
            </div>
            <table class="registration-list">
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

        <div class="college-registration-right-container">
            <main>
                <h2>단대별 등록금</h2>
                <br>

                <form action="${pageContext.request.contextPath}/admin/tuition/create-tuition-name" method="post">
                    <table border="1" class="create-table">
                        <tr>
                            <th>단과이름 :</th>
                            <td><input type="text" id="college-name" name="college-name" placeholder="ㅇㅇ대학"></td>
                        </tr>
                    </table>
                    <button type="submit">생성</button>
                </form>       
                <br>

                <form action="${pageContext.request.contextPath}/admin/tuition/create-tuition-amount" method="post">
                    <table border="1" class="create-table">
                        <tr>
                            <th>id :</th>
                            <td><input type="text" id="college-id" name="college-id" placeholder="1, 2, 3 ....."></td>
                        </tr>
                        <tr>
                            <th>금액 :</th>
                            <td><input type="text" id="college-tuition-amount" name="college-tuition-amount" placeholder="4000000"></td>
                        </tr>
                    </table>
                    <button type="submit">생성</button>
                </form>
                
                <br>

                <form action="${pageContext.request.contextPath}/admin/tuition/edit-tuition" method="post">
                    <table border="1" class="edit-table">
                        <tr>
                            <th>id :</th>
                            <td><input type="text" id="tuition-id" name="tuition-id" placeholder="1, 2, 3 ....."></td>
                        </tr>
                        <tr>
                            <th>금액 :</th>
                            <td><input type="text" id="college-tuition-amount" name="college-tuition-amount" placeholder="4000000"></td>
                        </tr>
                    </table>
                    <button type="submit">수정</button>
                </form>        
                <br><br>
                
                <p>단대별 등록금 목록</p>
                <br>
                <table border="1" class="list-table">
                    <tr>
                        <th>id</th>
                        <th>단과이름</th>
                        <th>금액</th>
                    </tr>
                    <c:forEach var="tuition" items="${tuitionList}">
                        <tr>
                            <td>${tuition.id}</td>
                            <td>${tuition.name}</td>
                            <td>${tuition.amount}</td>
                        </tr>
                    </c:forEach>
                </table>
            </main>
        </div>
    </div>
</section>
