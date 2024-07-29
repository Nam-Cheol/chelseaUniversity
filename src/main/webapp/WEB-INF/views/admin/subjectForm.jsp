<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminForm.css">

<main class="main-content">
    <!-- Form for Subject Registration -->
    <div class="form-container">
        <h3>강의 등록</h3>
        <form action="${pageContext.request.contextPath}/admin/subjectAdd" method="post">
            <input type="hidden" name="page" value="1">
            
            <label for="subject-name">강의이름:</label>
            <input type="text" id="subject-name" name="subject-name" placeholder="강의이름을 입력해주세요" required="required">
            
            <label for="professor-id">교수id:</label>
            <input type="text" id="professor-id" name="professor-id" placeholder="교수사번을 입력해주세요" required="required">
            
            <label for="room-id">강의실id:</label>
            <input type="text" id="romm-id" name="romm-id" placeholder="강의실id를 입력해주세요" required="required">
            
            <label for="dept-id">학과id:</label>
            <input type="text" id="dept-id" name="dept-id" placeholder="학과id를 입력해주세요" required="required">
            
            <label for="type">구분:</label>
            <label for="type">전공</label>
            <input type="radio" id="type" name="type" value="전공" required="required">
            <label for="type">교양</label>
            <input type="radio" id="type" name="type" value="교양">
            
            <label for="subject-year">강의연도:</label>
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
            
            <label for="semester">학기:</label>
            <label for="type">1</label>
            <input type="radio" id="semester" name="semester" value="1" required="required">
            <label for="type">2</label>
            <input type="radio" id="semester" name="semester" value="2">
            
            <label for="subject-day">요일:</label>
            <select id="subject-day" name="subject-day" required="required">
				<option value="월">월</option>
				<option value="화">화</option>
				<option value="수">수</option>
				<option value="목">목</option>
				<option value="금">금</option>
				<option value="토">토</option>
				<option value="일">일</option>
			</select>
            
            <label for="start-time">시작시간:</label>
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
			
            <label for="end-time">종료시간:</label>
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
			
            <label for="grades">학년:</label>
            <label for="type">1</label>
            <input type="radio" id="grades" name="grades" value="1" required="required">
            <label for="type">2</label>
            <input type="radio" id="grades" name="grades" value="2">
            <label for="type">3</label>
            <input type="radio" id="grades" name="grades" value="3">
            <label for="type">4</label>
            <input type="radio" id="grades" name="grades" value="4">
            
            <label for="capacity">최대정원:</label>
            <input type="text" id="capacity" name="capacity" placeholder="20" required="required">
            
            <input type="hidden" id="number-of-student" name="number-of-student" value="0">
            
            <button type="submit" class="btn-edit">생성</button>
        </form>
    </div>
</main>
