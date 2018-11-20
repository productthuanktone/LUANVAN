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
	href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>'
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href='<c:url value="/resources/vendor/fontawesome-free/css/all.min.css"/>'
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link
	href='<c:url value="/resources/vendor/magnific-popup/magnific-popup.css"/>'
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href='<c:url value="/resources/css/creative.min.css"/>'
	rel="stylesheet">
<link href='<c:url value="/resources/mydesign/Style.css"/>'
	rel="stylesheet">

</head>

<body id="page-top" style=""height: 100%; min-width: 540px;"">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top">Hương
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
						href="#services">Kiểm Tra Đơn Hàng</a></li>

					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/VTNN/giohang/">Giỏ hàng <i
							class="fas fa-cart-arrow-down"></i><span class="icongiohang">${soluonggiohang}</span></a></li>
					<c:choose>
						<c:when test="${tendangnhap !=null}">
							<div class="btn-group cachdangnhap">
								<button type="button" class="btn btn-danger dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">${tendangnhap}</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="#">Thông Tin Cá Nhân</a> <a
										class="dropdown-item" href="#">Thông Tin Giỏ Hàng</a> <a
										class="dropdown-item" href="#">Something else here</a>
									<div class="dropdown-divider"></div>
									<form action="/VTNN/dangxuat" method="post">
										<button type="submit">Đăng Xuất</button>
									</form>
									<!--   <a class="dropdown-item" href="/VTNN/dangnhap/dangxuat"></a> -->
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<li class="nav-item cachdangnhap"><a class="btn btn-primary"
								href="/VTNN/dangnhap/">Đăng Nhập</a></li>
							<li class="nav-item"><a class="btn btn-primary"
								href="/VTNN/dangnhap/">Đăng Ký</a></li>
							<br />
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<header class="masthead text-center text-white d-flex">
		<div class="container my-auto">
			<div class="row">
				<div class="col-lg-10 mx-auto">
					<h1 class="text-uppercase">
						<strong>CHUYÊN KINH DOANH VẬT TƯ VÀ MÁY NÔNG NGHIỆP</strong>
					</h1>
					<hr>
				</div>
				<div class="col-lg-8 mx-auto">
					<p class="text-faded mb-5">Chúng tôi cam kết sẻ mang lại cho
						bạn sản phẩm tốt nhất.</p>
					<a class="btn btn-primary btn-xl js-scroll-trigger" href="#about">Mua
						Sản Phẩm</a>
				</div>
			</div>
		</div>
	</header>

	<section class="bg-primary" id="about">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
				<c:forEach var="danhmuc" items="${danhmucs}">
					<a href="/VTNN/sanpham/${danhmuc.getMADANHMUC() }">
						<div class="alert alert-success" role="alert">${danhmuc.getTENDANHMUC() }</div>
					</a>
				</c:forEach>
				</div>
				<div class="col-md-10" id="backgroundsanpham">
					<!-- <hr class="dark my-4"> -->
					<div class="row">
						<c:forEach var="listsanpham" items="${listsanpham }">
							<a href="/VTNN/chitiet/${listsanpham.getMACHITIETSANPHAM() }"
								style="color: black; text-decoration: none;">
								<div class="col-md-4 col-lg-3 col-sm-6"
									style="margin-bottom: 30px; margin-top: 5px;">
									<div class="card"
										style="width: 18rem; background-color: #00ffff7d;">
										<img class="card-img-top"
											src='<c:url value="/resources/img/sanpham/${listsanpham.getHinh().getHINH() }"/>'
											alt="Card image cap" style="width: 286px; height: 250px">
										<div class="card-body">
											<h5 class="card-title" style="height: 48px">${listsanpham.getSanpham().getTENSANPHAM() }</h5>
											<p class="card-text">${listsanpham.getGia().getGIA()}
												VNĐ<br>
											<h6>Giảm ${listsanpham.getKhuyenmai().getPHANTRAM()}%
												Còn :</h6>
											<h3 style="color: red;">${listsanpham.getGia().getGIA()*(1-(listsanpham.getKhuyenmai().getPHANTRAM()/100))}
												VNĐ</h3>
											</p>
											<a href="/VTNN/chitiet/${listsanpham.getMACHITIETSANPHAM() }"
												class="btn btn-primary">Xem Chi Tiết</a>
										</div>
									</div>
								</div>
							</a>
						</c:forEach>

					</div>
				</div>
			</div>
	</section>

	<section id="services">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">At Your Service</h2>
					<hr class="my-4">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-gem text-primary mb-3 sr-icon-1"></i>
						<h3 class="mb-3">Sturdy Templates</h3>
						<p class="text-muted mb-0">Our templates are updated regularly
							so they don't break.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-paper-plane text-primary mb-3 sr-icon-2"></i>
						<h3 class="mb-3">Ready to Ship</h3>
						<p class="text-muted mb-0">You can use this theme as is, or
							you can make changes!</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-code text-primary mb-3 sr-icon-3"></i>
						<h3 class="mb-3">Up to Date</h3>
						<p class="text-muted mb-0">We update dependencies to keep
							things fresh.</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box mt-5 mx-auto">
						<i class="fas fa-4x fa-heart text-primary mb-3 sr-icon-4"></i>
						<h3 class="mb-3">Made with Love</h3>
						<p class="text-muted mb-0">You have to make your websites with
							love these days!</p>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="p-0" id="portfolio">
		<div class="container-fluid p-0">
			<div class="row no-gutters popup-gallery">
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="img/portfolio/fullsize/1.jpg"> <img
						class="img-fluid" src="img/portfolio/thumbnails/1.jpg" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-category text-faded">Category</div>
								<div class="project-name">Project Name</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="img/portfolio/fullsize/2.jpg"> <img
						class="img-fluid" src="img/portfolio/thumbnails/2.jpg" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-category text-faded">Category</div>
								<div class="project-name">Project Name</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="img/portfolio/fullsize/3.jpg"> <img
						class="img-fluid" src="img/portfolio/thumbnails/3.jpg" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-category text-faded">Category</div>
								<div class="project-name">Project Name</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="img/portfolio/fullsize/4.jpg"> <img
						class="img-fluid" src="img/portfolio/thumbnails/4.jpg" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-category text-faded">Category</div>
								<div class="project-name">Project Name</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="img/portfolio/fullsize/5.jpg"> <img
						class="img-fluid" src="img/portfolio/thumbnails/5.jpg" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-category text-faded">Category</div>
								<div class="project-name">Project Name</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a class="portfolio-box" href="img/portfolio/fullsize/6.jpg"> <img
						class="img-fluid" src="img/portfolio/thumbnails/6.jpg" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-category text-faded">Category</div>
								<div class="project-name">Project Name</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>

	<section class="bg-dark text-white">
		<div class="container text-center">
			<h2 class="mb-4">Free Download at Start Bootstrap!</h2>
			<a class="btn btn-light btn-xl sr-button"
				href="http://startbootstrap.com/template-overviews/creative/">Download
				Now!</a>
		</div>
	</section>

	<section id="contact" class="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<h2 class="section-heading">Let's Get In Touch!</h2>
					<hr class="my-4">
					<p class="mb-5">Ready to start your next project with us?
						That's great! Give us a call or send us an email and we will get
						back to you as soon as possible!</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 ml-auto text-center">
					<i class="fas fa-phone fa-3x mb-3 sr-contact-1"></i>
					<p>123-456-6789</p>
				</div>
				<div class="col-lg-4 mr-auto text-center">
					<i class="fas fa-envelope fa-3x mb-3 sr-contact-2"></i>
					<p>
						<a href="mailto:your-email@your-domain.com">feedback@startbootstrap.com</a>
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
<div class="modal fade" id="exampleModalCenter1"
	aria-labelledby="exampleModalCenterTitle" disabled="false">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Đăng nhập</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:if test="${error !=null }">
					<h6 style="color: red;">${error}</h6>
				</c:if>
			</div>
			<div class="modal-body">
				<form action="/VTNN/dangnhap/" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Địa chỉ Email:</label> <input
							type="email" name="tendangnhap" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Enter email"> <small id="emailHelp"
							class="form-text text-muted">Đảm bảo quyền riêng tư của
							bạn.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Mật Khẩu</label> <input
							type="password" name="matkhau" class="form-control"
							id="exampleInputPassword1" placeholder="Password">
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Nhớ
							mật khẩu</label>
					</div>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
</div>

</html>