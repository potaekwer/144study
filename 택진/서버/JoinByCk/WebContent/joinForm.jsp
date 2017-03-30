<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<style type="text/css">
.inline {
	border-left: 4px solid #00008B;
	padding: 3px;
}

tr {
	height: 20px;
}

div {
	display: table;
	margin-left: auto;
	margin-right: auto;
}
</style>






</head>
<body>
	<div>
		<header>
			<h3>유효성 검증(Validation)</h3>
		</header>

		<form action="javascript:alert('전송완료')" method="post">
			<table width="400">
				<tr>
					<td class="inline">이름(p)</td>
				</tr>
				<tr>
					<td><input type="text" id="name" name="name"
						onkeypress="InputOnWord"></td>
				</tr>
				<tr>
					<td class="inline">연락처</td>
				</tr>
				<tr>
					<td><input type="text" id="phoneNum" name="phoneNum"></td>
				</tr>
				<tr>
					<td class="inline">이메일</td>
				</tr>
				<tr>
					<td><input type="text" id="email" name="email"></td>
				</tr>
				<tr>
					<td class="inline">이메일(확인)</td>
				</tr>
				<tr>
					<td><input type="text" id="emailCheck" name="emailCheck"></td>
				</tr>
				<tr>
					<td class="inline" >재학 유무(p)</td>
				</tr>
				<tr>
					<td><input type="radio" name="enroll" value="y">유 &nbsp&nbsp
					<input type="radio"  name="enroll" value="n">무 <div id= "in"></div></td>
				</tr>
				<tr>
					<td class="inline">희망 수강 과목(p)</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="enrolls" value="jp">제이쿼리&nbsp&nbsp
					<input type="checkbox" name="enrolls" value="html">HTML 
						<input type="checkbox" name="enrolls" value="web">웹표준&nbsp&nbsp
						<input type="checkbox" name="enrolls" value="js">자바스크립트
						<div id = "put"></div>
						</td>
				</tr>
				<tr>
					<td class="inline">건의사항(p)</td>
				</tr>
				<tr>
					<td><input type="text" name="proposal" size="60"
						style="height: 60px"></td>
				</tr>
			</table>
			<br> <input type="submit" value="제출">
		</form>
	</div>
</body>

<script>
	$(document).ready(function() {$("form").submit(function() {
		if ($("input[name = 'name']").val() == "") {
												$("input[name = 'name']")
														.css("border",
																"1px solid red")
														.after(
																"<span>이름을 입력해 주세요</span>");
												$("span").css("color", "red")
														.fadeOut(2000);//2초 동안 span 보여주기
												return false;
											}
											if ($("input[name = 'enroll']:checked").val() == null) {
												$("div[id = 'in']").css("border","1px solid red").after("<span>재학유무를  체트해 주세요</span>");
												$("span").css("color", "red").fadeOut(2000);//2초 동안 span 보여주기
												return false;
											}
											if ($("input[name = 'enrolls']:checked").val() == null) {
												$("div[id = 'enrolls']").css("border","1px solid red").after(
																"<span>체크를  체트해 주세요</span>");
												$("span").css("color", "red")
														.fadeOut(2000);//2초 동안 span 보여주기
												return false;
											}
											if ($(
													"input[name = 'proposal']")
													.val() == "") {
												$("input[name = 'proposal']")
														.css("border",
																"1px solid red")
														.after(
																"<span>건의사항을 써 주세요</span>");
												$("span").css("color", "red")
														.fadeOut(2000);//2초 동안 span 보여주기
												return false;
											} 
										});
						$(":input").focus(function() {
							$(this).css("border", "2px red solid");
						}).blur(function() {
							$(this).css("border", "");
						});

						$(":text").focus(function() {
							$(this).after("<strong>필수 항목 입니다. </strong>")

						}).blur(function() {
							$("strong").remove();
						});

						$(":password").focus(function() {
							$(this).after("<strong>영문 숫자 조합 입니다. </strong>")

						}).blur(function() {
							$("strong").remove();
						});
						//라디오 버튼 선택시 폰트 변경
						//            $(":radio").click(function(){
						//                $("label").css("font-weight", "")
						//                $("label[for='" + $(this).attr("id") + "']").css("font-weight","bold");
						//            })

						$("label").click(function() {
							$("label").css("font-weight", "");
							$(this).css("font-weight", "bold");
						});
						$("button").click(function() {
							$(":checkbox").attr("checked", "checked");
							return false;
						})
						$(":submit").mouseover(function() {
							$(":reset").after("<p>회원 가입을 하시겠습니까?</p>");
							$("p").css("color", "blue");
						}).mouseout(function() {
							$("p").remove();
						})
						$(":reset").mouseover(function() {
							$(this).after("<p>다시 작성 하시겠습니까?</p>");
							$("p").css("color", "blue");

						}).mouseout(function() {
							$("p").remove();
						})
					});
</script>
</html>