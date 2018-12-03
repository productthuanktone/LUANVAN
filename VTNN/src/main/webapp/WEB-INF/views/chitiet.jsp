<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Hương Lúa</title>
<!-- Bootstrap core CSS -->
<link
	href='<c:url value="//resources/vendor/bootstrap/css/bootstrap.min.css"/>'
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href='<c:url value="//resources/vendor/fontawesome-free/css/all.min.css"/>'
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link
	href='<c:url value="//resources/vendor/magnific-popup/magnific-popup.css"/>'
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href='<c:url value="//resources/css/creative.min.css"/>'
	rel="stylesheet">
<link href='<c:url value="//resources/mydesign/Style.css"/>'
	rel="stylesheet">

</head>

<body id="page-top"style="height: 100%; min-width: 540px;">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav1">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="/VTNN/">Hương
				Lúa</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#about">Tin Tức Nông Nghiệp</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">Chăm Sóc Khách Hàng</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="#services">Kiểm Tra Đơn Hàng</a></li>
					<c:choose>
						<c:when test="${tendangnhap !=null}">
							<div class="btn-group">
								<button type="button" class="btn btn-danger dropdown-toggle cachdangnhap"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">${tendangnhap}</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="#">Thông Tin Cá Nhân</a>
									 <a class="dropdown-item" href="#">Thông Tin Giỏ Hàng</a>
									  <a class="dropdown-item" href="/VTNN/dangxuat">Đăng xuất</a>
									
					
									<!--   <a class="dropdown-item" href="/VTNN/dangnhap/dangxuat"></a> -->
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link js-scroll-trigger ponter"
						data-toggle="modal" data-target="#exampleModalCenter1"
						style="color: orange;">Đăng Ký</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigge ponter"
						data-toggle="modal" data-target="#exampleModalCenter1"
						style="color: orange;">Đăng Nhập ${error}</a></li>
							<br />
						</c:otherwise>
					</c:choose>
					<li class="nav-item"><a class="nav-link js-scroll-trigger" href="/VTNN/giohang/">Giỏ hàng <i class="fas fa-cart-arrow-down"></i><span class="icongiohang">${soluonggiohang}</span></a></li>
					<c:if test="${quyen==1}">
						<li class="nav-item quanly"><a class="btn btn-primary" href="/VTNN/admin/">Quản Lý</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>

	<header class="masthead1 text-center text-white d-flex">
		<div class="container my-auto">
			<div class="row">
				<div class="col-lg-10 mx-auto">
					<h1 class="text-uppercase" id="textkhuyenmai">
						<strong>KHUYẾN MÃI 10% TRÊN TẤT CẢ CÁC SẢN PHẨM </strong>
					</h1>
				</div>

			</div>
		</div>
	</header>

	<section class="formchitiet" id="about">
		<div class="container" id="minwidthchitiet">
			<div class="row"
				style="background-color: antiquewhite; height: 600px">
				<div class="col-md-4 col-lg-4 col-sm-4"
					style="background-color: #e8cfac;">
					<img class="hinh" data-hinh="${chitiet.getHinh().getHINH()}"src="<c:url value="//resources/img/sanpham/${chitiet.getHinh().getHINH() }"/>"
						id="imagechitiet"></<img>
				</div>
				<div class="col-md-5 col-lg-5 col-sm-5">
					<div>
						<h1 id="tensp" class="tensanpham" data-tensanpham="${chitiet.getSanpham().getTENSANPHAM()}">${chitiet.getSanpham().getTENSANPHAM()}</h1>
						<h6>
							Thương Hiệu:
							<p style="color: orange;">${chitiet.getNhasanxuat().getTENNHASANXUAT() }</p>
						</h6>
					</div>
					<hr>
					<div>
						<h5>Mô Tả</h5>
						<h6">${chitiet.getSanpham().getMOTA()}</h6>
					</div>
					<hr>
					<div>
						<label>Giá sản phẩm: </label>
						<p class="card-text gia" data-gia="${chitiet.getGia().getGIA()*(1-(chitiet.getKhuyenmai().getPHANTRAM()/100))}">${chitiet.getGia().getGIA()} VNĐ<br>
						<h6>Giảm ${chitiet.getKhuyenmai().getPHANTRAM()}% Còn:</h6>
						<h3 style="color: red;">${chitiet.getGia().getGIA()*(1-(chitiet.getKhuyenmai().getPHANTRAM()/100))} VNĐ</h3>
						</p>
					</div>
					<hr>
					<div style="margin-left: 13px;">
						<div class="row">
							<div><lable>Số lượng: </lable></div>			
							<div><input min="1"id="soluongsp" type="number" value="1"></div>			
						</div>
						<div class="row" style="margin-top: 5px;">
							<div>
								<a href="#" style="text-decoration: none;">
									<div class="alert alert-success" role="alert"><i class="fas fa-money-bill-alt"></i> MUA NGAY</div>
								</a>
							</div>
							<div>
								<a href="#" style="text-decoration: none;">
									<div class="alert alert-success btn-giohang" data-idchitiet="${chitiet.getMACHITIETSANPHAM()}" role="alert"><i class="fas fa-cart-plus"></i> THÊM VÀO
										GIỎ HÀNG</div>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-lg-3 col-sm-3"
					style="background-color: #e8cfac;">
					<div>
					<h6>Tùy chọn giao hàng</h6>
					<label style="font-size: 13px"><i class="fas fa-globe-asia"></i> Xã Thạnh Phước, huyện Giồng Riềng, tỉnh Kiên Giang.</label>
					<label style="color: #1a9cb7; margin-left: 60%"data-toggle="modal" data-target="#exampleModalCenter1">THAY ĐỔI <i class="fas fa-exchange-alt"></i></label>
					</div>
					<hr>
					<div>
						<h6><i class="fas fa-bus"></i> Giao Hàng Tiêu Chuẩn</h6>
						<label style="font-size: 13px">1-3 Ngày</label>
						<label  style="font-size: 15px;color: red;"><i class="fas fa-hand-holding-usd"></i> Thanh toán khi nhận hàng</label>
					</div>
					<hr>
					<div>
					<h6>Đổi Trả</h6>
					<label style="font-size: 13px"><i class="far fa-clock"></i> Đổi trả trong vòng 7 ngày</label>
					<label style="font-size: 13px; color: red;">Đối với các sẩn phẩm còn đủ chắc lượng</label>
					</div>
					<hr>
					<div>
						<div class="row">
						<div class="col-4">
							<label class="footertt">Đánh Giá Tích Cực</label>
							<h2>79%</h2>
						</div>
						<div class="col-4">
							<label class="footertt">Giao đúng hạn</label>
							<h2>90%</h2>
						</div>
						<div class="col-4">
							<label class="footertt">Chất lượng</label>
							<h6><i class="fas fa-star-half-alt"></i><i class="fas fa-star-half-alt"></i><i class="fas fa-star-half-alt"></i><i class="fas fa-star-half-alt"></i><i class="fas fa-star-half-alt"></i></h6>
						</div>
						</div>
					</div>
					</div>
			</div>
		</div>
	</section>
	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Hương Lúa</h2>
					<hr class="my-4">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-gem text-primary mb-3 sr-icon-1"></i>
						<h3 class="mb-3">Sản Phẩm Chất Lượng</h3>
						<p class="text-muted mb-0">Sản phẩm chất lượng quốc tế.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-paper-plane text-primary mb-3 sr-icon-2"></i>
						<h3 class="mb-3">Giao Hàng Nhanh</h3>
						<p class="text-muted mb-0">Giao hàng đúng ngày, đúng thời điểm.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-code text-primary mb-3 sr-icon-3"></i>
						<h3 class="mb-3">Sản Phẩm Mới</h3>
						<p class="text-muted mb-0">Chúng tôi luôn cập nhật sản phẩm mới.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-heart text-primary mb-3 sr-icon-4"></i>
						<h3 class="mb-3">An Toàn Sức Khỏe</h3>
						<p class="text-muted mb-0">Sản phẩm luôn bảo vệ sức khỏe của bạn.</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section id="contact" class="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<h2 class="section-heading">Liên Hệ Ngay!</h2>
					<hr class="my-4">
					<p class="mb-5">Chúng tôi luôn sẳn sàn phục vụ quý khách</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 ml-auto text-center">
					<i class="fas fa-phone fa-3x mb-3 sr-contact-1"></i>
					<p>01263241992</p>
				</div>
				<div class="col-lg-4 mr-auto text-center">
					<i class="fas fa-envelope fa-3x mb-3 sr-contact-2"></i>
					<p>
						<a href="mailto:your-email@your-domain.com">huonglua@gmail.com</a>
					</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Bootstrap core JavaScript -->
	<script src='<c:url value="/resources/vendor/jquery/jquery.min.js"/>'></script>
	<script
		src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>'></script>

	<!-- Plugin JavaScript -->
	<script
		src='<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>'></script>
	<script
		src='<c:url value="/resources/vendor/scrollreveal/scrollreveal.min.js"/>'></script>
	<script
		src='<c:url value="/resources/vendor/magnific-popup/jquery.magnific-popup.min.js"/>'></script>

	<!-- Custom scripts for this template -->
	<script src='<c:url value="/resources/js/creative.min.js"/>'></script>
</body>
<jsp:include page="modal.jsp"></jsp:include>
<script src='<c:url value="/resources/mydesign/ajax.js"/>'></script>
</html>

