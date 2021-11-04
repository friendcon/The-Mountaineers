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

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>

	<!-- Offcanvas Menu Begin -->
	<div class="offcanvas-menu-overlay"></div>

	<!-- Offcanvas Menu End -->
<%-- 	<c:forEach var="list" items="${list }">
		<tr>
			<th>${list.mntiname }</th>
			
		</tr>
	</c:forEach>
 --%>


	<!-- Breadcrumb Begin -->
	<div class="breadcrumb-option">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb__links">
						<a href="./index.html"><i class="fa fa-home"></i> Home</a> <span>산정보</span>
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
				<div class="shop__sidebar">
					<div class="sidebar__categories">
						<div class="section-title">
							<h4>Categoriesㄴㄴㄴㄴ</h4>
						</div>
						<div class="categories__accordion">
							<div class="accordion" id="accordionExample">
								<div class="card">
									<div class="card-heading active">
										<a data-toggle="collapse" data-target="#collapseOne">Women</a>
									</div>
									<div id="collapseOne" class="collapse show"
										data-parent="#accordionExample">
										<div class="card-body">
											<ul>
												<li><a href="#">Coats</a></li>
												<li><a href="#">Jackets</a></li>
												<li><a href="#">Dresses</a></li>
												<li><a href="#">Shirts</a></li>
												<li><a href="#">T-shirts</a></li>
												<li><a href="#">Jeans</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="card">
									<div class="card-heading">
										<a data-toggle="collapse" data-target="#collapseTwo">Men</a>
									</div>
									<div id="collapseTwo" class="collapse"
										data-parent="#accordionExample">
										<div class="card-body">
											<ul>
												<li><a href="#">Coats</a></li>
												<li><a href="#">Jackets</a></li>
												<li><a href="#">Dresses</a></li>
												<li><a href="#">Shirts</a></li>
												<li><a href="#">T-shirts</a></li>
												<li><a href="#">Jeans</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="card">
									<div class="card-heading">
										<a data-toggle="collapse" data-target="#collapseThree">Kids</a>
									</div>
									<div id="collapseThree" class="collapse"
										data-parent="#accordionExample">
										<div class="card-body">
											<ul>
												<li><a href="#">Coats</a></li>
												<li><a href="#">Jackets</a></li>
												<li><a href="#">Dresses</a></li>
												<li><a href="#">Shirts</a></li>
												<li><a href="#">T-shirts</a></li>
												<li><a href="#">Jeans</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="card">
									<div class="card-heading">
										<a data-toggle="collapse" data-target="#collapseFour">Accessories</a>
									</div>
									<div id="collapseFour" class="collapse"
										data-parent="#accordionExample">
										<div class="card-body">
											<ul>
												<li><a href="#">Coats</a></li>
												<li><a href="#">Jackets</a></li>
												<li><a href="#">Dresses</a></li>
												<li><a href="#">Shirts</a></li>
												<li><a href="#">T-shirts</a></li>
												<li><a href="#">Jeans</a></li>
											</ul>
										</div>
									</div>
								</div>
								<div class="card">
									<div class="card-heading">
										<a data-toggle="collapse" data-target="#collapseFive">Cosmetic</a>
									</div>
									<div id="collapseFive" class="collapse"
										data-parent="#accordionExample">
										<div class="card-body">
											<ul>
												<li><a href="#">Coats</a></li>
												<li><a href="#">Jackets</a></li>
												<li><a href="#">Dresses</a></li>
												<li><a href="#">Shirts</a></li>
												<li><a href="#">T-shirts</a></li>
												<li><a href="#">Jeans</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="sidebar__filter">
						<div class="section-title">
							<h4>Shop by price</h4>
						</div>
						<div class="filter-range-wrap">
							<div
								class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
								data-min="33" data-max="99"></div>
							<div class="range-slider">
								<div class="price-input">
									<p>Price:</p>
									<input type="text" id="minamount"> <input type="text"
										id="maxamount">
								</div>
							</div>
						</div>
						<a href="#">Filter</a>
					</div>
					<div class="sidebar__sizes">
						<div class="section-title">
							<h4>Shop by size</h4>
						</div>
						<div class="size__list">
							<label for="xxs"> xxs <input type="checkbox" id="xxs">
								<span class="checkmark"></span>
							</label> <label for="xs"> xs <input type="checkbox" id="xs">
								<span class="checkmark"></span>
							</label> <label for="xss"> xs-s <input type="checkbox" id="xss">
								<span class="checkmark"></span>
							</label> <label for="s"> s <input type="checkbox" id="s">
								<span class="checkmark"></span>
							</label> <label for="m"> m <input type="checkbox" id="m">
								<span class="checkmark"></span>
							</label> <label for="ml"> m-l <input type="checkbox" id="ml">
								<span class="checkmark"></span>
							</label> <label for="l"> l <input type="checkbox" id="l">
								<span class="checkmark"></span>
							</label> <label for="xl"> xl <input type="checkbox" id="xl">
								<span class="checkmark"></span>
							</label>
						</div>
					</div>
					<div class="sidebar__color">
						<div class="section-title">
							<h4>Shop by size</h4>
						</div>
						<div class="size__list color__list">
							<label for="black"> Blacks <input type="checkbox"
								id="black"> <span class="checkmark"></span>
							</label> <label for="whites"> Whites <input type="checkbox"
								id="whites"> <span class="checkmark"></span>
							</label> <label for="reds"> Reds <input type="checkbox" id="reds">
								<span class="checkmark"></span>
							</label> <label for="greys"> Greys <input type="checkbox"
								id="greys"> <span class="checkmark"></span>
							</label> <label for="blues"> Blues <input type="checkbox"
								id="blues"> <span class="checkmark"></span>
							</label> <label for="beige"> Beige Tones <input type="checkbox"
								id="beige"> <span class="checkmark"></span>
							</label> <label for="greens"> Greens <input type="checkbox"
								id="greens"> <span class="checkmark"></span>
							</label> <label for="yellows"> Yellows <input type="checkbox"
								id="yellows"> <span class="checkmark"></span>
							</label>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-9 col-md-9">
				<div class="row">
		
		
		
	<c:forEach var="list" items="${list }">
	
					<div class="col-lg-4 col-md-6">
						<div class="product__item">
							<div class="product__item__pic set-bg" style="overflow: hidden">
							<c:forEach var="listImg" items="${listImg }">
							
							<c:set var="mntilistno" value="${list.mntilistno}" />
							<c:choose>
								<c:when test="${mntilistno==listImg.mntilistno }">
								<img src="${listImg.mnti_i_route }" 
								style="width: 100%; height: 100%;">
								</c:when>
								<%-- <c:when test="${mntilistno!=listImg.mntilistno }">
								<img src="/resources/img/noimg.jpg" 
								style="width: 100%; height: 100%;">
								</c:when> --%>
							</c:choose>
							
							
							<%-- <c:if test="${list.mntilistno==listImg.mntilistno }">
								<img src="${listImg.mnti_i_route }" 
								style="width: 100%; height: 100%;"> --%>
								<ul class="product__hover">
									<li><a href="img/shop/shop-2.jpg" class="image-popup"><span
											class="arrow_expand"></span></a></li>
									<li><a href="#"><span class="icon_heart_alt"></span></a></li>
									<li><a href="#"><span class="icon_bag_alt"></span></a></li>
								</ul>
								<%-- </c:if> --%>
								</c:forEach>	
							</div>
							<div class="product__item__text">
								<h6>
									<a href="#">${list.mntiadd }</a>
								</h6>
								<div class="rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="product__price">${list.mntiname }</div>
							</div>
						</div>
					</div>
			
		</c:forEach>		
	
			
		
					<div class="col-lg-12 text-center">
						<div class="pagination__option">
						<c:if test="${pageMaker.prev }">
						<a href='<c:url value="/mountain/list?page=${pageMaker.startPage-1 }"/>'>
						<i class="fa fa-angle-left"></i></a>
		</c:if>
				
						
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
							<a href='<c:url value="/mountain/list?page=${pageNum }"/>'>
							${pageNum }</a>
						</c:forEach>

							<!--다음 버튼  -->
							<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
								<a href='<c:url value="/mountain/list?page=${pageMaker.endPage+1 }"/>'>
								<i class="fa fa-angle-right"></i></a>							
							</c:if>
							
					
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
<jsp:include page="../common/script.jsp"></jsp:include>

</html>