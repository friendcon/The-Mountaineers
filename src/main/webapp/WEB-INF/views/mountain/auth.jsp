<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Mountaineers | Group Create</title>
<jsp:include page="../common/head.jsp"></jsp:include>
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
<link href="../../resources/css/group/groupcreate.css" rel="stylesheet" type="text/css">
<link href="../../resources/css/mountain/mountainauth.css" rel="stylesheet" type="text/css">
<jsp:include page="../common/script.jsp"></jsp:include>
<script type="text/javascript" src="../../resources/js/mountain/mountain_auth.js"></script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<!-- Offcanvas Menu Begin -->
	<div class="offcanvas-menu-overlay"></div>

	<!-- Breadcrumb Begin -->
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb__links">
						<a href="./index.html"><i class="fa fa-home"></i> Home</a> <span>Group</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb End -->

	<!-- Shop Section Begin -->
	<section class="shop spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-3">
				<jsp:include page="../group/groupside.jsp"></jsp:include>
			</div>
			<div class="col-lg-9 col-md-9">
				<div class="row create_header">
					<div class="col-lg-12">
						<h2>인증하기</h2>
						<h5 class="create_content">&nbsp;&nbsp;등산 인증을 위해 위치인증을 해주세요!</h5>
						<hr>
					</div>
				</div>
				
				<form role="form" action="/mountain/authPhoto" method="post" enctype="multipart/form-data">
					<input type="hidden" id="mountain_code" name= "mountain_code" value="${mountain_code}">
					<div class="positionCheckContainer">
						<input type="text" id="positionButton" class="btn btn-success btn-lg btn-block positionBtn" value="위치인증">
					</div>
					<div class="row group_input mt-2">
						<h3>
							<label for="group_profile">인증사진업로드</label>
						</h3>
						<div class="swiper mySwiper">
							<div class="swiper-wrapper" id="imgSrcCotainer">
							</div>
							<div class="swiper-pagination"></div>
						</div>
						<div class="error_next_box"></div>
						<div class="uploadResult"></div>
					</div>
					<div class="uploadBtnContainer">
						<div>
							<label id="fileBtnCss" for="fileBtn">인증사진업로드</label>
						</div>
						<input type="file" name="uploadFile" class="btn btn-primary btn-lg btn-block uploadBtn" id="fileBtn" value="인증 사진 업로드" multiple>
					</div>
					<div class="row group_input mb-4">
							<h3>
								<label for="group_content">내용</label>
							</h3>
							<span class="box int_id">
								<input type="text" id="group_content" name="climb_post_content" class="int" maxlength="30"
								placeholder="등산 인증 완료 소감을 입력하세요!">
							</span>
							<div class="error_next_box"></div>
					</div>
					
					<div class="btn_area">
						<button type="submit" class="authBtn" id="createButton" disabled>
							<span>등산인증하기</span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<!-- Shop Section End -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</body>
<jsp:include page="../common/script.jsp"></jsp:include>

</html>