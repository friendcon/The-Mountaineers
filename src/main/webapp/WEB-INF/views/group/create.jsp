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
<link href="../../resources/css/group/groupcreate.css" rel="stylesheet" type="text/css">
<jsp:include page="../common/script.jsp"></jsp:include>
<script type="text/javascript" src="../../resources/js/group/create_page.js"></script>
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
				<form role="form" action="/group/new" method="post">
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
							<label for="group_count">그룹 공개 여부</label>
						</h3>
						<span class="box int_id">
							<div class="row">
								<div class="col-lg-6 text-center mt-1">
									<input name="group_open" id="groupopen" type="radio" value="0"/>
									<label for="groupopen">&nbsp;&nbsp;그룹 공개</label>
								</div>
								<div class="col-lg-6 text-center mt-1">
									<input name="group_open" id="groupclose" type="radio" value="1"/>
									<label for="groupclose">&nbsp;&nbsp;그룹 비공개</label>
								</div>
							</div>
						</span>
						<div class="error_next_box"></div>
					</div>
					<div class="row group_input">
						<h3>
							<label for="group_count">그룹성향</label>
							<p>&nbsp;나와 비슷한 산행 성향을 가진 그룹원을 모집하기를 원한다면, 그룹 성향을 선택해주세요!</p>
						</h3>
						<div class="for_check_box">
							<h5 class="create_content">&nbsp;&nbsp;아래 관심 있는 #해시태그를 선택하시면, 해시태그와 관련된 그룹을 확인하실 수 있습니다.</h5>
								<div class="region_container ml-2 mt-1">
									<h5>
										<label for="group_profile">지역</label>
									</h5>
									<label class="check_box_label region" id="region" for="seoul">
										<input type="checkbox" name="hashList" id="seoul" value="1">서울
									</label>
									<label class="check_box_label region" id="region" for="gygi">
										<input type="checkbox" name="hashList" id="gygi" value="2">경기
									</label>
									<label class="check_box_label region" id="region" for="incheon">
										<input type="checkbox" name="hashList" id="incheon" value="3">인천
									</label>
									<label class="check_box_label region" id="region" for="daejeon">
										<input type="checkbox" name="hashList" id="daejeon" value="4">대전
									</label>
									<label class="check_box_label region" id="region" for="daegu">
										<input type="checkbox" name="hashList" id="daegu" value="5">대구
									</label>
									<label class="check_box_label region" id="region" for="Chungcheong">
										<input type="checkbox" name="hashList" id="Chungcheong" value="6">충청
									</label>
									<label class="check_box_label region" id="region" for="Gyeongsang-do">
										<input type="checkbox" name="hashList" id="Gyeongsang-do" value="7">경상
									</label>
									<label class="check_box_label region" id="region" for="Jeolla-do">
										<input type="checkbox" name="hashList" id="Jeolla-do" value="8">전라
									</label>
									<label class="check_box_label region" id="region" for="Gwangju">
										<input type="checkbox" name="hashList" id="Gwangju" value="9">광주
									</label>
									<label class="check_box_label region" id="region" for="Ulsan">
										<input type="checkbox" name="hashList" id="Ulsan" value="10">울산
									</label>
									<label class="check_box_label region" id="region" for="busan">
										<input type="checkbox" name="hashList" id="busan" value="11">부산
									</label>
									<label class="check_box_label region" id="region" for="jeju">
										<input type="checkbox" name="hashList" id="jeju" value="12">제주
									</label>
								</div>
								<div class="age_container ml-2 mt-1">
									<h5>
										<label for="group_profile">그룹 연령대</label>
									</h5>
									<label class="check_box_label age" id="age" for="10age">
										<input type="checkbox" name="hashList" id="10age" value="13">10대
									</label>
									<label class="check_box_label age" id="age" for="20age">
										<input type="checkbox" name="hashList" id="20age" value="14">20대
									</label>
									<label class="check_box_label age" id="age" for="30age">
										<input type="checkbox" name="hashList" id="30age" value="15">30대
									</label>
									<label class="check_box_label age" id="age" for="40age">
										<input type="checkbox" name="hashList" id="40age" value="16">40대
									</label>
									<label class="check_box_label age" id="age" for="50age">
										<input type="checkbox" name="hashList" id="50age" value="17">50대
									</label>
									<label class="check_box_label age" id="age" for="60age">
										<input type="checkbox" name="hashList" id="60age" value="18">60대
									</label>
								</div>
								<div class="row">
									<div class="time_container ml-4 mt-1">
										<h5>
											<label for="group_profile">시간대별</label>
										</h5>
										<label class="check_box_label time" id="time" for="morning">
											<input type="checkbox" name="hashList" id="morning" value="19">아침산행
										</label>
										<label class="check_box_label time" id="time" for="weekday">
											<input type="checkbox" name="hashList" id="weekday" value="20">평일산행
										</label>
										<label class="check_box_label time" id="time" for="night">
											<input type="checkbox" name="hashList" id="night" value="21">야간산행
										</label>
										<label class="check_box_label time" id="time" for="weekend">
											<input type="checkbox" name="hashList" id="weekend" value="22">주말산행
										</label>
									</div>
									<div class="type_container ml-2 mt-1">
										<h5>
											<label for="group_profile">그룹 타입</label>
										</h5>
										<label class="check_box_label type" id="type" for="tracking">
											<input type="checkbox" name="hashList" id="tracking" value="23">트래킹
										</label>
										<label class="check_box_label type" id="type" for="bagpacking">
											<input type="checkbox" name="hashList" id="bagpacking" value="24">백패킹
										</label>
										<label class="check_box_label type" id="type" for="climbing">
											<input type="checkbox" name="hashList" id="climbing" value="25">클라이밍
										</label>
										<label class="check_box_label type" id="type" for="climb">
											<input type="checkbox" name="hashList" id="climb" value="26">등산
										</label>
									</div>
								</div>
								<div class="row mb-1">
									<div class="feature_container ml-4 mt-1">
										<h5>
											<label for="group_profile">그룹 특성</label>
										</h5>
										<label class="check_box_label features" id="features" for="community">
											<input type="checkbox" name="hashList" id="community" value="27">친목
										</label>
										<label class="check_box_label features" id="features" for="food">
											<input type="checkbox" name="hashList" id="food" value="28">맛집 탐방
										</label>
									</div>
									<div class="grade_container ml-4 mt-1">
										<h5>
											<label for="group_profile">등산 난이도</label>
										</h5>
										<label class="check_box_label grade" id="grade" for="easy">
											<input type="checkbox" name="hashList" id="easy" value="29">초급자
										</label>
										<label class="check_box_label grade" id="grade" for="middle">
											<input type="checkbox" name="hashList" id="middle" value="30">중급자
										</label>
										<label class="check_box_label grade" id="grade" for="difficult">
											<input type="checkbox" name="hashList" id="difficult" value="31">고급자
										</label>
									</div>
								</div>
						</div>
					</div>
					
					<div class="row group_input mt-2">
						<h3>
							<label for="group_profile">프로필사진</label>
						</h3>
						<div class="profile_wrap">
							<div class="profile_path">
								<span class="box">
									<input type="text" id="group_profile" name="group_img" class="int" readonly >
								</span>
							</div>
							<div class="profile_button">
								<span>
									<label class="int" for="file_hidden" id="file_label">프로필 사진 첨부</label>
									<input type="file" class="file_button please" id="file_hidden" name="uploadFile">
								</span>
							</div>
						</div>
						<div class="error_next_box mb-3"></div>
						<div class="uploadResult">
							
						</div>
					</div>
					
					
					<div class="btn_area">
						<button type="submit" id="createButton">
							<span>그룹생성하기</span>
						</button>
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