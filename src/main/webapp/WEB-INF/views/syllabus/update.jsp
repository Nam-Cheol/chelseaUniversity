<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/info.css">

<main>
    <h1>강의 계획서 수정</h1>
    <div class="form-container">
        <form action="${pageContext.request.contextPath}/syllabus/submit?id=${param.id}" method="post">
            <table class="form-table">
                <tr>
                    <td><label for="overview">강의 개요:</label></td>
                    <td><input type="text" id="overview" name="overview" value="${syllabusInfo.overview}" class="form-input" maxlength="255"></td>
                </tr>
                <tr>
                    <td><label for="objective">수업 목표:</label></td>
                    <td><input type="text" id="objective" name="objective" value="${syllabusInfo.objective}" class="form-input" maxlength="255"></td>
                </tr>
                <tr>
                    <td><label for="textbook">교재:</label></td>
                    <td><input type="text" id="textbook" name="textbook" value="${syllabusInfo.textbook}" class="form-input" maxlength="30"></td>
                </tr>
                <tr>
                    <td><label for="program">주별 계획:</label></td>
                    <td><input type="text" id="program" name="program" value="${syllabusInfo.program}" class="form-input"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <button class="btn btn-edit" type="submit">수정</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</main>
</body>
</html>
