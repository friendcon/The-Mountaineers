<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../../resources/fullcalendar/main.css" rel="stylesheet" />
	<link href="../../resources/css/group/groupview.css" rel="stylesheet" type="text/css">
	<link href="../../resources/fullcalendar/main.min.css" rel="stylesheet" type="text/css">
	<title>The Mountaineers</title>
	<jsp:include page="../common/head.jsp"></jsp:include>
	<jsp:include page="../common/script.jsp"></jsp:include>
	<script src='https://cdn.jsdelivr.net/npm/moment@2.27.0/min/moment.min.js'></script>
	<script type="text/javascript" src="../../resources/fullcalendar/main.min.js"></script>
	<script type="text/javascript" src="../../resources/fullcalendar/locales-all.min.js"></script>
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
				
				<div class="group_information row ml-0">
						<div class="schedule-here">
						</div>
						
						<input type="hidden" id="group_no" name="group_no" value="${group.group_no}">
						<div class="group_img_info">
							<img class="group_profile_image" name="group_profile_image" src="/group/getImg/${group.group_no }" />
						</div>
						<div class="group_content_info">
							<span class="group_name">${group.group_name} </span>
							<span class="group_level">
								<c:if test="${group.group_level eq 1}">
									<label class="level1">Level 1</label>
								</c:if>
								<c:if test="${group.group_level eq 2}">
									<label class="level2">Level 2</label>
								</c:if>
								<c:if test="${group.group_level eq 3}">
									<label class="level3">Level 3</label>
								</c:if>
							</span>
							<span class="group_count">????????? ??? :&nbsp;&nbsp;${memcount} / ${group.group_count}</span>
							<h5 class="group_content">${group.group_content }</h5><br>
							<br>
							<h6 class="group_point">?????? ????????? : ${group.group_point }</h6>
							<div class="group_hash">
								#
								<c:forTokens var="hash" items="${group.groupHashList}" delims=",">
									<c:choose>
											<c:when test="${hash >= 1 && hash <13}">
												<label class="region">
													<c:choose>
														<c:when test="${hash == 1}">
															??????
														</c:when>
														<c:when test="${hash == 2}">
															??????
														</c:when>
														<c:when test="${hash == 3}">
															??????
														</c:when>
														<c:when test="${hash == 4}">
															??????
														</c:when>
														<c:when test="${hash == 5}">
															??????
														</c:when>
														<c:when test="${hash == 6}">
															??????
														</c:when>
														<c:when test="${hash == 7}">
															??????
														</c:when>
														<c:when test="${hash == 8}">
															??????
														</c:when>
														<c:when test="${hash == 9}">
															??????
														</c:when>
														<c:when test="${hash == 10}">
															??????
														</c:when>
														<c:when test="${hash == 11}">
															??????
														</c:when>
														<c:when test="${hash == 12}">
															??????
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 12 && hash <19}">
												<label class="age">
													<c:choose>
														<c:when test="${hash == 13}">
															10???
														</c:when>
														<c:when test="${hash == 14}">
															20???
														</c:when>
														<c:when test="${hash == 15}">
															30???
														</c:when>
														<c:when test="${hash == 16}">
															40???
														</c:when>
														<c:when test="${hash == 17}">
															50???
														</c:when>
														<c:when test="${hash == 18}">
															60???
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 18 && hash <23}">
												<label class="age">
													<c:choose>
														<c:when test="${hash == 19}">
															????????????
														</c:when>
														<c:when test="${hash == 20}">
															????????????
														</c:when>
														<c:when test="${hash == 21}">
															????????????
														</c:when>
														<c:when test="${hash == 22}">
															????????????
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 22 && hash <27}">
												<label class="type">
													<c:choose>
														<c:when test="${hash == 23}">
															?????????
														</c:when>
														<c:when test="${hash == 24}">
															????????????
														</c:when>
														<c:when test="${hash == 25}">
															????????????
														</c:when>
														<c:when test="${hash == 26}">
															????????????
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash == 27 || hash == 28}">
												<label class="features">
													<c:choose>
														<c:when test="${hash == 27}">
															??????
														</c:when>
														<c:when test="${hash == 28}">
															????????????
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 28 && hash <32}">
												<label class="grade">
													<c:choose>
														<c:when test="${hash == 29}">
															?????????
														</c:when>
														<c:when test="${hash == 30}">
															?????????
														</c:when>
														<c:when test="${hash == 31}">
															?????????
														</c:when>
													</c:choose>
												</label>
											</c:when>
									</c:choose>
									
								</c:forTokens>
							</div>
						</div>
				</div>
				<div class="row group_inner_container">
					<div class="nav-container">
						<span class="nav-menu notice">????????????</span>
						<span class="nav-menu schedule">????????????</span>
						<span class="nav-menu freeboard">???????????????</span>
					</div>
					<div class="inner_content">
							<p class="climb-calendar-label">????????????</p>
							<p class="climb-schedule-button">????????????</p>
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