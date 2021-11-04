<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/taglib.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Mountaineers | 그룹 메인 </title>
	<jsp:include page="../common/head.jsp"></jsp:include>
	<link href="../../resources/css/member/login.css" rel="stylesheet" type="text/css">
	<jsp:include page="../common/script.jsp"></jsp:include>
	<script type="text/javascript" src="../../resources/js/member/login.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<div class="container mt-4">
		<div class="mb-3" id="logo">
			<a><img src="/resources/img/TheMountaineers.png"></a>
		</div>
		<div id="login-content">
			<form action="/login" method="post">
				<div class="mb-4">
					<span class="box">
						<input type="text" id="username" name="username" class="int" maxlength="30"
						placeholder="아이디 입력">
					</span>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<span class="box">
						<input type="password" id="password" name="password" class="int" maxlength="30"
						placeholder="비밀번호 입력">
					</span>
					<div class="error_next_box">
						<c:if test="${not empty loginFailMessage }">
							<c:out value = "${loginFailMessage }" /> 
						</c:if>
					</div>
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
				<a href="/member/join">회원가입</a>
			</div>
			<div>
				<hr>
			</div>
		</div>
	</div>
</body>
</html>