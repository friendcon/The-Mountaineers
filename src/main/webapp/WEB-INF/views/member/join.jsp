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
		</div>
	</div>
	<div class="join_content">
		<div class="row">
			아이디 : <input type="text" name="mem_id"><br>
			비밀번호 : <input type="password" name="mem_pwd"><br>
			이메일 : <input type="text" name="mem_email"><br>
			생년월일 : <input type="text" name="mem_id"><br>
			<button>일반 회원가입</button>
		</div>
	</div>
	<div class="row">
		<div>
			<button>카카오톡으로 회원가입</button>
		</div>
	</div>
</body>
</html>