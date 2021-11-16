<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../../resources/css/group/groupview.css" rel="stylesheet" type="text/css">
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
				
				<div class="group_information row ml-0">
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
							<span class="group_count">그룹원 수 :&nbsp;&nbsp;${memcount} / ${group.group_count}</span>
							<h5 class="group_content">${group.group_content }</h5><br>
							<br>
							<h6 class="group_point">그룹 포인트 : ${group.group_point }</h6>
							<div class="group_hash">
								#
								<c:forTokens var="hash" items="${group.groupHashList}" delims=",">
									<c:choose>
											<c:when test="${hash >= 1 && hash <13}">
												<label class="region">
													<c:choose>
														<c:when test="${hash == 1}">
															서울
														</c:when>
														<c:when test="${hash == 2}">
															경기
														</c:when>
														<c:when test="${hash == 3}">
															인천
														</c:when>
														<c:when test="${hash == 4}">
															대전
														</c:when>
														<c:when test="${hash == 5}">
															대구
														</c:when>
														<c:when test="${hash == 6}">
															충청
														</c:when>
														<c:when test="${hash == 7}">
															경상
														</c:when>
														<c:when test="${hash == 8}">
															전라
														</c:when>
														<c:when test="${hash == 9}">
															광주
														</c:when>
														<c:when test="${hash == 10}">
															울산
														</c:when>
														<c:when test="${hash == 11}">
															부산
														</c:when>
														<c:when test="${hash == 12}">
															제주
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 12 && hash <19}">
												<label class="age">
													<c:choose>
														<c:when test="${hash == 13}">
															10대
														</c:when>
														<c:when test="${hash == 14}">
															20대
														</c:when>
														<c:when test="${hash == 15}">
															30대
														</c:when>
														<c:when test="${hash == 16}">
															40대
														</c:when>
														<c:when test="${hash == 17}">
															50대
														</c:when>
														<c:when test="${hash == 18}">
															60대
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 18 && hash <23}">
												<label class="age">
													<c:choose>
														<c:when test="${hash == 19}">
															아침산행
														</c:when>
														<c:when test="${hash == 20}">
															평일산행
														</c:when>
														<c:when test="${hash == 21}">
															야간산행
														</c:when>
														<c:when test="${hash == 22}">
															주말산행
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 22 && hash <27}">
												<label class="type">
													<c:choose>
														<c:when test="${hash == 23}">
															트래킹
														</c:when>
														<c:when test="${hash == 24}">
															평일산행
														</c:when>
														<c:when test="${hash == 25}">
															야간산행
														</c:when>
														<c:when test="${hash == 26}">
															주말산행
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash == 27 || hash == 28}">
												<label class="features">
													<c:choose>
														<c:when test="${hash == 27}">
															친목
														</c:when>
														<c:when test="${hash == 28}">
															맛집탐방
														</c:when>
													</c:choose>
												</label>
											</c:when>
											<c:when test="${hash > 28 && hash <32}">
												<label class="grade">
													<c:choose>
														<c:when test="${hash == 29}">
															초급자
														</c:when>
														<c:when test="${hash == 30}">
															중급자
														</c:when>
														<c:when test="${hash == 31}">
															고급자
														</c:when>
													</c:choose>
												</label>
											</c:when>
									</c:choose>
									
								</c:forTokens>
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