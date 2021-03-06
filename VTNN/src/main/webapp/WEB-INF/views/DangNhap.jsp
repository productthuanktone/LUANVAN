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

<body id="page-top" style="height: 100%; min-width: 540px;">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav1">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="/VTNN/">Hương Lúa</a>
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
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						data-toggle="modal" data-target="#exampleModalCenter1"
						style="color: orange;">Đăng Ký</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						data-toggle="modal" data-target="#exampleModalCenter1"
						style="color: orange;">Đăng Nhập</a></li>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/VTNN/giohang/"><i class="fas fa-cart-arrow-down"></i><span
							class="icongiohang"><p>${soluonggiohang}</p></span></a></li>
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

	<section id="about">
		<div class="container" id="formdangnhap">
			<c:if test="${error !=null }">
					<h1 style="color: red; width: 800px;">${error}</h1>
				</c:if>
			</div>
	</section>
	<section id="contact" class="footer" style="margin-top:370px">
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
<script src='<c:url value="/resources/mydesign/ajax.js"/>'></script>
</html>
