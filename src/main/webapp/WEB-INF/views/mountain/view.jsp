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

	<script type="text/javascript" src="../../resources/js/mountain/mountainView.js"></script>
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
						<input type="hidden" id="mountain_code" name="mountain_code" value="${mountain.mountain_code}">
						<div class="mountain_img_info">
							<img class="mountain_image" name="mountain_image" src="${mountain.mountain_img_src}" />
						</div>
						<div class="mountain_content_info">
							<button type="button" class="btn btn-primary rounded-pill viewpath" id="climbauth">????????????????????????</button>
							<span class="mountain_name">${mountain.mountain_name} </span>
							<h5 class="mountain_content">??? ?????? : ${mountain.mountain_hight }</h5>
							<h5 class="mountain_content">??? ??????  ??????????????? </h5><br>
							<h5 class="mountain_content">${mountain.mountain_address }</h5>
							<h5 class="mountain_content">${mountain.mountain_phone }</h5>

						</div>
				</div>
				<input type="hidden" id="mountain_x" value="${mountain.mountain_x}" />
				<input type="hidden" id="mountain_y" value="${mountain.mountain_y}" />
				<div class="row mountain_inner_container">
					<div class="nav-container">
						<span class="nav-menu notice">????????????</span>
						<span class="nav-menu schedule">????????????</span>
						<span class="nav-menu freeboard">???????????????</span>
					</div>
					<div class="inner_content">
							<p class="climb-calendar-label">??????</p>
							<div class="row">
								<div class="col-lg-2"></div>
								<div class="col-lg-8" id="map"></div>
								<div class="col-lg-2"></div>
							</div>
							<p class="climb-calendar-label">?????????</p>
							<div class="row">
								<div class="col-lg-2"></div>
								<!-- <div class="col-lg-8" id="map2"></div> -->
								<div class="col-lg-2"></div>
							</div>
							<div class="row">
								<div class="col-lg-2"></div>
								<div class="col-lg-8" class="pathList">
									<c:forEach var="path" items="${path}" varStatus="status">
										<div class="path_container" id="path-container${status.count}">
											<input type="hidden" id="pathNum${status.count}">
											<button type="button" data-pathcount="${status.count}" class="btn btn-sm btn-success rounded-pill viewpath" >view</button>
											<p class="path_count">${status.count}?????? ?????????</p>
											<span class="path_level">
												<c:if test="${path.climb_path_difficult eq '??????'}">
													<label class="level1">??????</label>
												</c:if>
												<c:if test="${path.climb_path_difficult eq '??????'}">
													<label class="level2">??????</label>
												</c:if>
												<c:if test="${path.climb_path_difficult eq '?????????'}">
													<label class="level3">?????????</label>
												</c:if>
											</span>
											<h6 class="path_name">${path.climb_path_name} (${path.climb_path_length}km)</h6>
											<p class="climb-time">?????? ?????? : ${path.climb_path_uptime} &nbsp;&nbsp;&nbsp; /  &nbsp;&nbsp;&nbsp;?????? ?????? : ${path.climb_path_downtime} </p>
											<input type="hidden" class="pathstring" id="path${status.count}" name ="path${status.count}" value="${path.climb_path_XY}">
										</div>
									</c:forEach>
								</div>
								<div class="col-lg-2"></div>
							</div>
					</div>
				</div>
				
							<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=13ced59236edab8d9f8aad2858084915&autoload=false"></script>
							<script type="text/javascript">
								
								
								kakao.maps.load(function() {
									let checkClick = false;
									let pathViewButton = document.getElementsByClassName('viewpath');
									/**/
									
									var x = document.getElementById("mountain_y").value;
									var y = document.getElementById("mountain_x").value;
			
									var mapContainer = document.getElementById('map'), // ????????? ????????? div 
								    mapOption = { 
								        center: new kakao.maps.LatLng(x, y), // ????????? ????????????
								        level: 4 // ????????? ?????? ??????
								    };
									var pathContainer = document.getElementById('map2'),
									mapOption2 = { 
								        center: new kakao.maps.LatLng(x, y), // ????????? ????????????
								        level: 3 // ????????? ?????? ??????
								    };
									
									var map = new kakao.maps.Map(mapContainer, mapOption);
									var polyline;
									
									var addEvents;
									
									
									for(var i=0; i<pathViewButton.length; i++) {
										var countFor = i+1;
										pathViewButton[i].addEventListener("click", addEvents = function(i){
											console.log(countFor);
											var btn = this.dataset.pathcount;
											console.log(btn);

											var container_id = "path-container" + btn;
											var path_container = document.getElementById(container_id);

											if(checkClick == true) {
												polyline.setMap(null);
												checkClick = false;
												return;
											}
											
											var pathId = "path" + btn;
											console.log(pathId);
											var xyArr = document.getElementById(pathId).value.split("/");
											var linePath = [];

											for(var j=0; j<xyArr.length-1; j++) {
												var splitPoint = xyArr[j].split(",");
												var point = new kakao.maps.LatLng(splitPoint[0], splitPoint[1]);
												linePath.push(point);
											}
											
											polyline = new kakao.maps.Polyline({
											    path: linePath,
											    strokeWeight: 5, 
											    strokeColor: '#FFAE00', 
											    strokeOpacity: 0.7, 
											    strokeStyle: 'solid'
											});
											checkClick = true;
											polyline.setMap(map);
										});
									}
									
									var markerPosition  = new kakao.maps.LatLng(x, y); 

									var marker = new kakao.maps.Marker({
									    position: markerPosition
									});

									marker.setMap(map);
									
								})
								
							</script>
			</div>
		</div>
	</div>
	</section>
	<!-- Shop Section End -->
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
</body>


</html>