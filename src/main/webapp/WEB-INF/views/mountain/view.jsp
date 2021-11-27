<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../../resources/css/mountain/mountainInfo.css" rel="stylesheet" type="text/css">
	<link href="../../resources/css/group/groupview.css" rel="stylesheet" type="text/css">
	
	<link href="../../resources/fullcalendar/main.min.css" rel="stylesheet" type="text/css">
	<title>The Mountaineers</title>
	<jsp:include page="../common/head.jsp"></jsp:include>
	<jsp:include page="../common/script.jsp"></jsp:include>
	<script type="text/javascript" src="../../resources/js/group/group_view.js"></script>
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
				
				<div class="mountain_information row ml-0">
						<div class="schedule-here">
						</div>
						
						<input type="hidden" id="mountain_code" name="mountain_code" value="${mountain.mountain_code}">
						<div class="mountain_img_info">
							<img class="mountain_image" name="mountain_image" src="${mountain.mountain_img_src}" />
						</div>
						<div class="mountain_content_info">
							<span class="mountain_name">${mountain.mountain_name} </span>

							<h5 class="mountain_content">${mountain.mountain_address }</h5>
							<h5 class="mountain_content">${mountain.mountain_phone }</h5>
							<h5 class="mountain_content">산 평점  ★★★☆☆ </h5>

						</div>
				</div>
				<div class="row mountain_inner_container">
					<div class="nav-container">
						<span class="nav-menu notice">공지사항</span>
						<span class="nav-menu schedule">산행일정</span>
						<span class="nav-menu freeboard">자유게시판</span>
					</div>
					<div class="inner_content">
							<p class="climb-calendar-label">산행일정</p>
							<div class="row claendar-container">
								<div class="col-lg-1"></div>
								<div class="col-lg-10" id="calendar">
									
								</div>
								<div class="col-lg-1"></div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- Shop Section End -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>


</html>