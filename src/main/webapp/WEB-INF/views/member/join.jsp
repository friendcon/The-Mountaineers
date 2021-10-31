<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>The Mountaineers | 회원가입 </title>
	<jsp:include page="../common/head.jsp"></jsp:include>
	<link href="../../resources/css/member/join.css" rel="stylesheet" type="text/css">
	<jsp:include page="../common/script.jsp"></jsp:include>
	<script type="text/javascript" src="../../resources/js/member/joinpage.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<div class="container mt-5">
		<div id="logo" >
			<a><img src="/resources/img/greenlogo.JPG"></a>
		</div>
		<div id="join-content" class="content center-block mb-5">
			<form action="/member/new" method="post">
				<div>
					<h3>
						<label for="mem_id">아이디</label>
					</h3>
					<span class="box int_id">
						<input type="text" id="mem_id" name="mem_id" class="int" maxlength="30">
						<span class="step_url">@themountaineers.com</span>
					</span>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<h3>
						<label for="mem_pwd">비밀번호</label>
					</h3>
					<span class="box">
						<input type="password" id="mem_pwd" name="mem_pwd" class="int" maxlength="30">
					</span>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<h3>
						<label for="mem_pwd_check">비밀번호 확인</label>
					</h3>
					<span class="box">
						<input type="password" id="mem_pwd_check" name="mem_pwd_check" class="int" maxlength="30">
					</span>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<h3>
						<label for="mem_name">이름</label>
					</h3>
					<span class="box">
						<input type="text" id="mem_name" name="mem_name" class="int" maxlength="30">
					</span>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<h3>
						<label for="mem_birth">생년월일</label>
					</h3>
					<div class="birth_wrap">
						<div class="birth_year">
							<span class="box">
								<input type="text" id="mem_birth" name="mem_birth" class="int" maxlength="4"
								placeholder="년(4자)">
							</span>
						</div>
						<div class="birth_month">
							<span class="box">
								<select id="mem_month" name="mem_month">
									<option>월</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
							</span>
						</div>
						<div class="birth_day">
							<span class="box">
								<input type="text" id="mem_day" name="mem_day" class="int" maxlength="2"
								placeholder="일">
							</span>
						</div>
					</div>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<h3>
						<label for="mem_phone">전화번호</label>
					</h3>
					<span class="box">
						<input type="text" id="mem_phone" name="mem_phone" class="int" maxlength="13"
						placeholder="전화번호 입력(010-0000-0000 형식으로 입력하세요)">
					</span>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<h3>
						<label for="mem_email">이메일</label>
					</h3>
					<span class="box">
						<input type="text" id="mem_email" name="mem_email" class="int" maxlength="50"
						placeholder="이메일 입력">
					</span>
					<div class="error_next_box"></div>
				</div>
				
				<div>
					<h3>
						<label for="mem_address">주소</label>
					</h3>
					<span class="box">
						<input type="text" id="mem_address" name="mem_address" class="int" maxlength="50"
						placeholder="주소 입력">
					</span>
					<div class="error_next_box"></div>
				</div>
				
				
				<div>
					<h3>
						<label for="mem_profile">프로필사진</label>
					</h3>
					<div class="profile_wrap">
						<div class="profile_path">
							<span class="box">
								<input type="text" id="mem_profile" name="mem_img" class="int">
							</span>
						</div>
						<div class="profile_button">
							<span>
								<label class="int" for="file_hidden" id="file_button">프로필 사진 첨부</label>
								<input class="int" id="file_hidden" type="file" multiple>
							</span>
						</div>
					</div>
					<div class="error_next_box"></div>
				</div>
				
				<div class="btn_area">
					<button type="submit" id="joinButton">
						<span>회원가입하기</span>
					</button>
				</div>
			</form>
		</div>
	</div>

</body>
</html>