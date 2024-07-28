<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/studentHeader.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/subject.css">

<c:if test="${not empty message}">
    <script type="text/javascript">
        alert("${message}");
    </script>
</c:if>

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="display: flex; min-width: 100em;">
    <!-- 세부 메뉴 div-->
    <div class="sub--menu">
        <div class="sub--menu--top">
            <h2 style="color: white;">수강신청</h2>
        </div>
        <!-- 메뉴 -->
        <div class="sub--menu--mid">
            <table class="sub--menu--table" border="1">
                <tr>
                    <td><a href="/chelseaUniversity/sugang/subjectList?page=1">강의 시간표 조회</a></td>
                </tr>
                <tr>
                    <td><a href="/chelseaUniversity/sugang/pre?page=1">예비 수강 신청</a></td>
                </tr>
                <tr>
                    <td><a href="/chelseaUniversity/sugang/appList?page=1" class="selected--menu">수강 신청</a></td>
                </tr>
                <tr>
                    <td><a href="/chelseaUniversity/sugang/list?page=1">수강 신청 내역 조회</a></td>
                </tr>
            </table>
        </div>
    </div>

    <!-- 메인 div -->
    <main>
        <h1>수강 신청</h1>
        <div class="split--div"></div>

        <a href="/chelseaUniversity/sugang/appList">
            <button class="preStuSubList--button">신청 내역</button>
        </a>

        <!-- 필터 및 검색 -->
        <div class="sub--filter">
            <form action="${pageContext.request.contextPath}/sugang/application" method="get">
                <div>
                    <input type="hidden" name="page" value="1">
                    <!-- 강의구분 콤보박스 -->
                    <label for="type">강의구분</label>
                    <select name="type" id="type">
                        <option value="전체">전체</option>
                        <option value="전공">전공</option>
                        <option value="교양">교양</option>
                    </select>
                    <!-- 대상학과 콤보박스 -->
                    <label for="deptId">개설학과</label>
                    <select name="deptId" id="deptId">
                        <option value="-1">전체</option>
                        <!-- 학과 목록 -->
                        <c:forEach var="department" items="${departments}">
                            <option value="${department.id}">${department.name}</option>
                        </c:forEach>
                    </select>
                    <!-- 강의 검색 -->
                    <label for="subName">강의명</label>
                    <input type="text" name="name" list="subName">
                    <datalist id="subName">
                        <!-- 강의명 목록 -->
                        <c:forEach var="subject" items="${allSubjects}">
                            <option value="${subject}">${subject}</option>
                        </c:forEach>
                    </datalist>
                    <!-- 검색 버튼 -->
                   <button type="submit" class="btn btn-primary mx-2">조회</button>
                </div>
            </form>
        </div>

        <h4>
            <span style="font-weight: 600;">강의 목록</span>&nbsp;
            <span style="color: gray; font-size: 18px;">[총 ${totalCount}건]</span>
        </h4>
        <table border="1" class="sub--list--table">
            <thead>
                <tr>
                    <th>단과대학</th>
                    <th>개설학과</th>
                    <th>학수번호</th>
                    <th>강의구분</th>
                    <th style="width: 200px;">강의명</th>
                    <th>담당교수</th>
                    <th>학점</th>
                    <th>요일시간 (강의실)</th>
                    <th>현재인원</th>
                    <th>정원</th>
                    <th>수강신청</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="subject" items="${subjectList}">
                    <tr>
                        <td>${subject.collegeName}</td>
                        <td>${subject.deptName}</td>
                        <td>${subject.id}</td>
                        <td>${subject.type}</td>
                        <td class="sub--list--name">${subject.name}</td>
                        <td>${subject.professorName}</td>
                        <td>${subject.grades}</td>
                        <td>${subject.subDay}&nbsp;${subject.startTime}:00-${subject.endTime}:00&nbsp;(${subject.roomId})</td>
                        <td>${subject.numOfStudent}</td>
                        <td>${subject.capacity}</td>
                        <td>
                            <c:set var="isEnrolled" value="false" />
                            <c:forEach var="subjectId" items="${subjectIdList}">
                                <c:if test="${subjectId == subject.id}">
                                    <c:set var="isEnrolled" value="true" />
                                </c:if>
                            </c:forEach>
                            <c:choose>
                                <c:when test="${isEnrolled}">
                                    <form action="/chelseaUniversity/sugang/deleteSugang" method="get">
                                        <button type="submit" name="id" value="${subject.id}" onclick="return confirm('수강신청을 취소하시겠습니까?');" style="background-color: #a7a7a7;">취소</button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/chelseaUniversity/sugang/registrationSugang" method="get">
                                        <input type="hidden" name="subId" value="${subject.id}">
                                        <input type="hidden" name="subGrade" value="${subject.grades}">
                                        <input type="hidden" name="subType" value="${subject.type}">
                                        <input type="hidden" name="subDay" value="${subject.subDay}">
                                        <input type="hidden" name="startTime" value="${subject.startTime}">
                                        <input type="hidden" name="endTime" value="${subject.endTime}">
                                        <button type="submit" name="id" value="${subject.id}" onclick="return confirm('해당 강의를 수강신청하시겠습니까?');" style="background-color: #548AC2;">신청</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <ul class="page--list">
            <c:forEach begin="1" end="${totalPage}" var="i">
                <li>
                    <a href="${pageContext.request.contextPath}/sugang/application?page=${i}" class="${i == currentPage ? 'active' : ''}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </main>
</div>

<footer>
    <!-- 필요 시 -->
</footer>
</body>
</html>
