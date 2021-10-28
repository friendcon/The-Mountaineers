<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Mountaineers | 로그인 </title>
	<jsp:include page="../common/head.jsp"></jsp:include>
	<link href="../../resources/css/member/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<div class="container mt-5">
		<div class="mb-5" id="logo">
			<a><img src="/resources/img/greenlogo.JPG"></a>
		</div>
		<div id="login-content">
			<form action="/login" method="post">
			
				<div class="mb-4">
					<span class="box">
						<input type="text" id="username" name="username" class="int" maxlength="30"
						placeholder="아이디">
					</span>
					<span class="error_next_box"></span>
				</div>
				
				<div>
					<span class="box">
						<input type="password" id="password" name="password" class="int" maxlength="30"
						placeholder="비밀번호">
					</span>
					<span class="error_next_box"></span>
				</div>
				
				<div class="btn_area">
					<button type="submit" id="loginButton">
						<span>로그인</span>
					</button>
				</div>
				
			</form>
			<div class="find_info">
				<a>아이디 찾기</a>
				<span>|</span>
				<a>비밀번호 찾기</a>
				<span>|</span>
				<a>회원가입</a>
			</div>
			<div>
				<hr>
			</div>
		</div>
	</div>
	
	
	
	<!-- <form action="/login" method="post">
		아이디 : <input type="text" name="username"><br>
		비밀번호 : <input type="password" name="password"><br>
		<button type="submit">로그인</button>
	</form> -->
</body>
</html>