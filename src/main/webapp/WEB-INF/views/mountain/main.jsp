<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../../resources/css/group/groupmain.css" rel="stylesheet" type="text/css">
<link href="../../resources/css/mountain/mountain.css" rel="stylesheet" type="text/css">
<title>The Mountaineers | Group Main</title>
<jsp:include page="../common/head.jsp"></jsp:include>
<jsp:include page="../common/script.jsp"></jsp:include>
<script type="text/javascript" src="../../resources/js/mountain/mountain.js"></script>
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
						<a href="./index.html"><i class="fa fa-home"></i> Home</a> <span>Mountain</span>
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
						<h2>Mountain Main</h2>
						<h5 class="create_content">&nbsp;&nbsp;산 정보를 조회해보세요!</h5>
						<hr>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<span class="box">
							<input type="text" id="mountain_search" name="keyword" class="int" maxlength="30"
							placeholder="산 이름을 입력하세요.">
								<button class="searchButton" id="mountainSearchBtn"><img class="buttonimg" src="../../resources/img/button/search.png"></button>
						</span>
						<hr>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 ml-4">
						<input type='hidden' class='lastmountain' id="lastmountain" name='lastmountain' value='nomountain'> 
						<div class="append_here" id="append_here">
							<c:forEach var="mountain" items="${mountains }" varStatus="status">
								<div class="mountain_container" data-mounno = "${mountain.mountain_code}">
									<div class="group_img">
										<img class="group_profile_image" name="group_profile_image" />
									</div>
									<div class="mountain_content_box">
										<h5><a href="/mountain/view?mountain_code=${mountain.mountain_code }"> ${mountain.mountain_name } </a></h5>
										<p>산 높이 : ${mountain.mountain_hight}m
											<br>
											${mountain.mountain_address}
											<br>
											${mountain.mountain_phone}</p>
									</div>
								</div>
							</c:forEach>
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