<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="../../resources/css/group/groupschedulecreate.css" rel="stylesheet" type="text/css">
<link href="../../resources/css/group/groupview.css" rel="stylesheet" type="text/css">
<link href="../../resources/css/group/groupcreate.css" rel="stylesheet" type="text/css">
<title>The Mountaineers</title>
<jsp:include page="../common/head.jsp"></jsp:include>
<jsp:include page="../common/script.jsp"></jsp:include>
<script type="text/javascript" src="../../resources/js/group/group_schedule_create.js"></script>
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
				<div class="row group_inner_container">
					<div class="nav-container">
						<span class="nav-menu notice">공지사항</span>
						<span class="nav-menu schedule">산행일정</span>
						<span class="nav-menu freeboard">자유게시판</span>
					</div>
					<div class="inner_content">
							<p class="climb-calendar-label">산행일정</p>
							<div class="schedule-container">
								<form action="/group/scheduleCreate" method="post">
									<input type="hidden" name="group_no" value="${group_no}" />
									<div>
										<h5>
											<label for="climb_title">산행 제목</label>
										</h5>
										<span class="box int_id">
											<input type="text" id="climb_title" name="climb_title" class="int" maxlength="30"
											placeholder="산행 제목을 입력하세요.">
										</span>
										<div class="error_next_box"></div>
									</div>
									<div>
										<h5>
											<label for="climb_schedule">산행 일정</label>
										</h5>
										<div class="schedule">
											<div class="schedule_start">
												<span class="box">
													<input type="text" id="startdate" name="start_date" class="int"
													placeholder="산행 시작 날짜를 입력하세요.">
												</span>
											</div>
											~
											<div class="schedule_finish">
												<span class="box">
													<input type="text" id="findate" name="finish_date" class="int"
													placeholder="산행 종료 날짜를 입력하세요.">
												</span>
											</div>
										</div>
										
										<div class="error_next_box"></div>
									</div>
									<div>
										<h5>
											<label for="climb_content">산행 내용</label>
										</h5>
										<span class="box int_content">
											<textarea type="text" id="climb_content" name="climb_content" class="int"
											rows="5" placeholder="산행 내용을 입력하세요"></textarea>
										</span>
										<div class="error_next_box"></div>
									</div>
									<div class="sch_Reg_button">
										<button class="box" type="submit" id="scheduleRegBtn">
											<span>산행 일정 등록</span>
										</button>
									</div>
								</form>
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