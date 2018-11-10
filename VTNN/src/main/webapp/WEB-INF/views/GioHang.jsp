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
						href="#contact"><i class="fas fa-cart-arrow-down"></i><span
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
						<strong>GIỎ HÀNG CỦA BẠN</strong>
					</h1>
				</div>

			</div>
		</div>
	</header>

	<section class="formchitiet" id="about">
		<div class="container" id="minwidthchitiet">
			<div class="row"
				style="background-color: antiquewhite; height: 600px">
				<div class="col-md-8 col-lg-8 col-sm-8 formgiohang">
					<div>THÔNG TIN GIỎ HÀNG</div>
					<div>
						<table class="table" id="tablesp">
							<thead>
								<tr>
									<td>Hình Ảnh</td>
									<td>Tên Sản Phẩm</td>
									<td>Số Lượng</td>
									<td>Giá<span>(VNĐ)</span></td>
									<td></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="giohang" items="${giohang}">
									<tr>
										<td><img class="hinhgiohang" alt="hinh"
											src='<c:url value="/resources/img/sanpham/${giohang.getHinh() }"/>' /></td>
										<td class="tensp" data-machitietsp="${giohang.getMachitietsanpham() }">${giohang.getTensanpham() }</td>
										<td style="color: blue"><input min="1"class="soluongcuagiohang" type="number" value="${giohang.getSoluong() }"></td>
											<td style="color: red" class="giatien"
											data-giatien="${giohang.getGia()}"><p>${giohang.getGia()}</p></td>
										<td class="btnxoa"><i class="fa fa-times fa-lg"></i></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div>Tổng Tiền: <span id="tongtien"></span> VNĐ</div>
				</div>
				<div class="col-md-4 col-lg-4 col-sm-4 formgiohang2"
					style="background-color: #e8cfac;">
					<div>THÔNG TIN KHÁCH HÀNG</div>
					<div class="font-group" id="tablesp">
						<form action="" method="POST">
							<label for="tenkh">Tên khách hàng:</label> <input id="tenkh"
								name="tenkh" class="form-control"> <label for="sdt">Số
								điện thoại:</label> <input id="sdt" name="sdt" class="form-control">
							<div class="radio">
								<label><input type="radio" name="hinhthucgiaohang"
									checked="checked" value="1"> Nhận hàng tại
									cửa hàng</label>
							</div>
							<div class="radio">
								<label><input type="radio" name="hinhthucgiaohang"
									value="0"> Nhận hàng tại nhà</label>
							</div>
							<label for="diachigiaohang">Địa chỉ:</label> <input
								id="diachigiaohang" name="diachigiaohang" class="form-control">
							<div class="form-group">
								<label for="comment">Ghi chu:</label>
								<textarea class="form-control" rows="5" id="comment"
									name="mota"></textarea>
							</div>
							
							<input type="submit" class="btn btn-primary" value="Đặt Hàng">
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section id="contact" class="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
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
			</div>
			<div class="modal-body">
				<form action="/VTNN">
					<div class="form-group">
						<label for="exampleInputEmail1">Địa chỉ Email:</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter email"> <small
							id="emailHelp" class="form-text text-muted">Đảm bảo quyền
							riêng tư của bạn.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Mật Khẩu</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password">
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
<script src='<c:url value="/resources/mydesign/ajax.js"/>'></script>
</html>
