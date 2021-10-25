<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>The Mountaineers</title>
	<jsp:include page="../common/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="row">
		<div>
			<h3>회원가입</h3>
			<a>일반 회원가입</a><br>
			<a>소셜회원가입</a><a href="/member/oauth/kakao" target="_blank">
			<img src="../../resources/img/button/kakao_login_medium_wide.png"></button>
		</div>
	</div>
	<div class="join_content">
		<div class="row">
		<form action="/member/new" method="post">
			아이디 : <input type="text" name="mem_id"><br>
			비밀번호 : <input type="password" name="mem_pwd"><br>
			이름: <input type="text" name="mem_name"><br>
			이메일 : <input type="text" name="mem_email"><br>
			생년월일 : <input type="text" name="mem_birth">
			<input type="text" name="mem_month"> 
			<input type="text" name="mem_day"><br>
			핸드폰번호 : <input type="text" name="mem_phone"><br>
			주소 : <input type="text" name="mem_address"><br>
			프로필사진 : <input type="text" name="mem_img"><br>
			<button type="submit">일반 회원가입</button>
		</form>
		</div>
	</div>
	<div class="row">
		<div>
			<button>카카오톡으로 회원가입</button>
		</div>
	</div>
</body>
</html>