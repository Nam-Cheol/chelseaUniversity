<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/home/staffHeader.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/pagination.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="d-flex justify-content-center align-items-start" style="display:flex; min-width: 100em;">
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
                    <td><a href="${pageContext.request.contextPath}/admin/subject" class="selected--menu">강의</a></td>
                </tr>
                <tr>
                    <td><a href="${pageContext.request.contextPath}/admin/tuition">단대별 등록금</a></td>
                </tr>
            </table>
        </div>
    </div>

    <main style="width: 100%; padding: 20px;">
        <h1>강의 등록</h1>
         <div class="split--div"></div>	
        <div class="sub--filter">
        <form action="${pageContext.request.contextPath}/admin/subject/create-subject" method="post">
          <table class="table-container">
                    <tr>
                        <td><label for="type">강의이름<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="subject-name" name="subject-name" placeholder="강의이름을 입력해주세요" required="required"></td>
                    </tr>
                    <tr>
                        <td><label for="type">교수사번<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="professor-id" name="professor-id" placeholder="교수사번을 입력해주세요" required="required"></td>
                    </tr>
                    <tr>
                        <td><label for="type">강의실id<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="romm-id" name="romm-id" placeholder="강의실id를 입력해주세요" required="required"></td>
                    </tr>
                    <tr>
                        <td><label for="type">학과id<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="dept-id" name="dept-id" placeholder="학과id를 입력해주세요" required="required"></td>
                    </tr>
                    <tr>
                        <td><label>구분<span class="essential-sign">&#42;</span></label></td>
                        <td>
                            <label for="type">전공</label>
                            <input type="radio" id="type" name="type" value="전공" required="required">
                            <label for="type">교양</label>
                            <input type="radio" id="type" name="type" value="교양">
                        </td>
                    </tr>
                    <tr>
                        <td><label for="type">강의연도<span class="essential-sign">&#42;</span></label></td>
                        <td>
	                        <select id="subject-year" name="subject-year" required="required">
								<option value="2024">2024</option>
								<option value="2023">2023</option>
								<option value="2022">2022</option>
								<option value="2021">2021</option>
								<option value="2020">2020</option>
								<option value="2019">2019</option>
								<option value="2018">2018</option>
								<option value="2017">2017</option>
								<option value="2016">2016</option>
								<option value="2015">2015</option>
								<option value="2014">2014</option>
								<option value="2013">2013</option>
								<option value="2012">2012</option>
								<option value="2011">2011</option>
								<option value="2010">2010</option>
								<option value="2009">2009</option>
								<option value="2008">2008</option>
								<option value="2007">2007</option>
								<option value="2006">2006</option>
								<option value="2005">2005</option>
								<option value="2004">2004</option>
								<option value="2003">2003</option>
								<option value="2002">2002</option>
								<option value="2001">2001</option>
								<option value="2000">2000</option>
							</select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="type">학기<span class="essential-sign">&#42;</span></label></td>
                        <td>
                        	<label for="type">1</label>
                            <input type="radio" id="semester" name="semester" value="1" required="required">
                            <label for="type">2</label>
                           	<input type="radio" id="semester" name="semester" value="2">
						</td>
                    </tr>
                    <tr>
                        <td><label for="type">요일<span class="essential-sign">&#42;</span></label></td>
                        <td>
	                        <select id="subject-day" name="subject-day" required="required">
								<option value="월">월</option>
								<option value="화">화</option>
								<option value="수">수</option>
								<option value="목">목</option>
								<option value="금">금</option>
								<option value="토">토</option>
								<option value="일">일</option>
							</select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="type">시작시간<span class="essential-sign">&#42;</span></label></td>
                        <td>
                        <select id="start-time" name="start-time" required="required">
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
							</select>
							</td>
                    </tr>
                    <tr>
                    <td><label for="type">종료시간<span class="essential-sign">&#42;</span></label></td>
                        <td>
                        <select id="end-time" name="end-time" required="required">
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
							</select>
							</td>
                    </tr>
                     <tr>
                        <td><label for="type">학년<span class="essential-sign">&#42;</span></label></td>
                         <td>
                        	<label for="type">1</label>
                            <input type="radio" id="grades" name="grades" value="1" required="required">
                            <label for="type">2</label>
                           	<input type="radio" id="grades" name="grades" value="2">
                            <label for="type">3</label>
                           	<input type="radio" id="grades" name="grades" value="3">
                            <label for="type">4</label>
                           	<input type="radio" id="grades" name="grades" value="4">
						</td>
                    </tr>
                    <tr>
                        <td><label for="type">최대정원<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="capacity" name="capacity" placeholder="20" required="required"></td>
                    </tr>
                    <tr>
                        <td><label for="type">현재인원<span class="essential-sign">&#42;</span></label></td>
                        <td><input type="text" id="number-of-student" name="number-of-student" placeholder="5" required="required"></td>
                    </tr>
                </table>
			<button type="submit">생성</button>
        </form> 
        </div>
        	      
        <br>
        <p>강의 목록</p>
        <br>
        <div>
             <table class="table table-striped sub--list--table">
              <thead>
                <tr>
                    <th>강의id</th>
                    <th>강의이름</th>
                    <th>교수id</th>
                    <th>강의실id</th>
                    <th>학과id</th>
                    <th>구분</th>
                    <th>강의연도</th>
                    <th>학기</th>
                    <th>요일</th>
                    <th>시작시간</th>
                    <th>종료시간</th>
                    <th>학년</th>
                    <th>최대정원</th>
                    <th>현재인원</th>
                </tr>
                </thead>
                 <tbody>
                <c:forEach var="subject" items="${subjectList}">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.name}</td>
                    <td>${subject.professorId}</td>
                    <td>${subject.roomId}</td>
                    <td>${subject.deptId}</td>
                    <td>${subject.type}</td>
                    <td>${subject.subYear}</td>
                    <td>${subject.semester}</td>
                    <td>${subject.subDay}</td>
                    <td>${subject.startTime}</td>
                    <td>${subject.endTime}</td>
                    <td>${subject.grades}</td>
                    <td>${subject.capacity}</td>
                    <td>${subject.numOfStudent}</td>
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
			                <span class="page-item"><a href="${pageContext.request.contextPath}/admin/subject?page=${i}" class="page-link">${i}</a></span>
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			</div>
        </div>
    </main>
</div>

<%@ include file="footer.jsp"%>

