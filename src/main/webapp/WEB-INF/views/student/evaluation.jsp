<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.send == true}"><script>window.close();</script></c:if>
	<main>
		<div class="title--row">
			<h1>강의 평가</h1>
		</div>
		<hr>
		<form action="/chelseaUniversity/grade/evaluation?subjectId=${subId}" method="post">
			<ul class="radio--check">
				<li>1.&nbsp;강의 내용은 자신에게 학습 욕구를 불러일으킬 만큼 적절한 수준이었는가?</li>
				<li>&nbsp;<input type="radio" name="answer1" value="5" id="a11">
					<label for="a11"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="4" id="a12">
					<label for="a12"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="3" id="a13">
					<label for="a13"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="2" id="a14">
					<label for="a14"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="1" id="a15">
					<label for="a15"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>2.&nbsp;이 강의를 통하여 다른 강의에서는 접할 수 없는 새로운 내용을 배울 수 있었는가?</li>
				<li>&nbsp;<input type="radio" name="answer2" value="5" id="a21">
					<label for="a21"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="4" id="a22">
					<label for="a22"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="3" id="a23">
					<label for="a23"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="2" id="a24">
					<label for="a24"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="1" id="a25">
					<label for="a25"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>3.&nbsp;강의를 통하여 해당 교과목에 대한 이해(실기 능력과 기능)가 개선되었는가?</li>
				<li>&nbsp;<input type="radio" name="answer3" value="5" id="a31">
					<label for="a31"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="4" id="a32">
					<label for="a32"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="3" id="a33">
					<label for="a33"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="2" id="a34">
					<label for="a34"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="1" id="a35">
					<label for="a35"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>4.&nbsp;교수는 주요 주제들간의 관계가 드러나도록 내용을 구조화 하여 전달하였는가?</li>
				<li>&nbsp;<input type="radio" name="answer4" value="5" id="a41">
					<label for="a41"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="4" id="a42">
					<label for="a42"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="3" id="a43">
					<label for="a43"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="2" id="a44">
					<label for="a44"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="1" id="a45">
					<label for="a45"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>5.&nbsp;교수는 열정을 갖고 수업을 진행하였는가?</li>
				<li>&nbsp;<input type="radio" name="answer5" value="5" id="a51">
					<label for="a51"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="4" id="a52">
					<label for="a52"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="3" id="a53">
					<label for="a53"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="2" id="a54">
					<label for="a54"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="1" id="a55">
					<label for="a55"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>6.&nbsp;수업시간은 제대로 이루어졌는가?</li>
				<li>&nbsp;<input type="radio" name="answer6" value="5" id="a61">
					<label for="a61"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="4" id="a62">
					<label for="a62">그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="3" id="a63">
					<label for="a63">보통</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="2" id="a64">
					<label for="a64">그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="1" id="a65">
					<label for="a65">전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>7.&nbsp;강의 내용이 과목명에 부합하는가?</li>
				<li><input type="radio" name="answer7" value="5" id="a71">
					<label for="a71">매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="4" id="a72">
					<label for="a72">그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="3" id="a73">
					<label for="a73">보통</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="2" id="a74">
					<label for="a74">그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="1" id="a75">
					<label for="a75">전혀 그렇지 않다</label></li>
			</ul>
			<ul class="etc--row">
				<li><span>기타</span></li>
				<li><textarea cols="80" rows="5" name="improvements"> </textarea></li>
			</ul>
			<div class="button--row">
				<button class="btn btn-dark update--button" onclick="submit()">제출하기</button>
			</div>
			<script>
			function submit() {
				let form = document.forms[0];
				form.submit();
			}
			</script>
		</form>
	</main>

</body>
</html>