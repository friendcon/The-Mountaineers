<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/head.jsp"></jsp:include>
<link href="../../resources/css/group/groupcreate.css" rel="stylesheet" type="text/css">
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
						<h2>Create Climb Group</h2>
						<h5 class="create_content">&nbsp;&nbsp;같은 성향의 그룹을 찾을 수 없다면 나에게 맞는 그룹을 만들어보세요.</h5>
						<hr>
					</div>
				</div>
				<form>
					<div class="row group_input">
						<h3>
							<label for="group_name">그룹 이름</label>
						</h3>
						<span class="box int_id">
							<input type="text" id="group_name" name="group_name" class="int" maxlength="30"
							placeholder="그룹 이름을 입력하세요.">
						</span>
						<div class="error_next_box"></div>
					</div>
					<div class="row group_input">
						<h3>
							<label for="group_content">그룹 설명</label>
						</h3>
						<span class="box int_id">
							<input type="text" id="group_content" name="group_content" class="int" maxlength="30"
							placeholder="그룹에 대한 설명을 자유롭게해주세요.">
						</span>
						<div class="error_next_box"></div>
					</div>
					<div class="row group_input">
						<h3>
							<label for="group_count">그룹원 수</label>
						</h3>
						<span class="box int_id">
							<input type="text" id="group_count" name="group_count" class="int" maxlength="30"
							placeholder="그룹 정원을 입력해주세요.">
						</span>
						<div class="error_next_box"></div>
					</div>
					<div class="row group_input">
						<h3>
							<label for="group_count">그룹성향</label>
							<p>&nbsp;나와 비슷한 산행 성향을 가진 그룹원을 모집하기를 원한다면, 그룹 성향을 선택해주세요!</p>
						</h3>
						<div>
							<label class="check_box_label" for="nightclimb"><input type="checkbox" id="nightclimb" value="1">야간산행</label>
							<label class="check_box_label" for="morningclimb"><input type="checkbox" id="morningclimb" value="2">아침산행</label>
							<label class="check_box_label" for="weekendclimb"><input type="checkbox" id="weekendclimb" value="3">주말산행</label>
							<label class="check_box_label" for="weekdayclimb"><input type="checkbox" id="weekdayclimb" value="4">평일산행</label>
							<label class="check_box_label" for="food"><input type="checkbox" id="food" value="5">맛집탐방</label>
							<label class="check_box_label" for="community"><input type="checkbox" id="community" value="6">친목</label>
							<label class="check_box_label" for="tracking"><input type="checkbox" id="tracking" value="7">트래킹</label>
							<label class="check_box_label" for="bagpacking"><input type="checkbox" id="bagpacking" value="8">백패킹</label>
							<label class="check_box_label" for="climbing"><input type="checkbox" id="climbing" value="9">클라이밍</label>
							<label class="check_box_label" for="climb"><input type="checkbox" id="climb" value="10">등산</label>
							<label class="check_box_label" for="easy"><input type="checkbox" id="easy" value="11">초보자</label>
							<label class="check_box_label" for="middle"><input type="checkbox" id="middle" value="12">중급자</label>
							<label class="check_box_label" for="difficult"><input type="checkbox" id="difficult" value="13">고급자</label>
							<label class="check_box_label" for="camping"><input type="checkbox" id="camping" value="14">캠핑</label>
						</div>
						
						<div class="error_next_box"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>
	<!-- Shop Section End -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
<jsp:include page="../common/script.jsp"></jsp:include>

</html>