<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta http-equiv="Content-Type"
	content="text/html; charset=utf-8;charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Tables</title>

<!-- Bootstrap core CSS-->
<link
	href='<c:url value="/resources/admin/vendor/bootstrap/css/bootstrap.min.css"/>'
	rel="stylesheet">

<!-- Custom fonts for this template-->
<link
	href='<c:url value="/resources/admin/vendor/fontawesome-free/css/all.min.css"/>'
	type="text/css">

<!-- Page level plugin CSS-->
<link
	href='<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.css"/>'
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href='<c:url value="/resources/admin/css/sb-admin.css"/>'
	rel="stylesheet">
<link href='<c:url value="/resources/mydesign/Style.css"/>'
	rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="/VTNN/">Quản Lý Hương Lúa</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span
					class="badge badge-danger">9+</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="alertsDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span
					class="badge badge-danger">7</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="messagesDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a> <a
						class="dropdown-item" href="#">Activity Log</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Quản Lý</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/VTNN/hoadon/">
					<i class="fas fa-fw fa-chart-area"></i> <span>Danh Sách Hóa
						Đơn</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="pagesDropdown1"
				data-toggle="dropdown"><span>Sản Phẩm</span> </a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown1">
					<a class="dropdown-item" href="/VTNN/adminsanpham/">Danh Sách
						Sản Phẩm</a> <a class="dropdown-item"
						href="/VTNN/adminsanpham/themsanpham">Thêm Sản Phẩm</a>
					<div class="dropdown-divider"></div>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="pagesDropdown2"
				data-toggle="dropdown"><span>Nhà Sản Xuất</span> </a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown2">
					<a class="dropdown-item" href="/VTNN/nhasanxuat/">Danh Sách Nhà
						Sản Xuất</a> <a class="dropdown-item"
						href="/VTNN/nhasanxuat/themnhasanxuat">Thêm Nhà Sản Xuất</a>
					<div class="dropdown-divider"></div>
				</div></li>
				<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="pagesDropdown3"
				data-toggle="dropdown"><span>Khuyến Mãi</span> </a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown3">
					<a class="dropdown-item" href="/VTNN/khuyenmai/">Danh Sách Khuyến Mãi</a> <a class="dropdown-item"
						href="/VTNN/khuyenmai/themkhuyenmai">Thêm Khuyến Mãi</a>
					<div class="dropdown-divider"></div>
				</div></li>
			<c:if test="${quyen==1 }">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="pagesDropdown2"
					data-toggle="dropdown"><span>Nhân Viên</span> </a>
					<div class="dropdown-menu" aria-labelledby="pagesDropdown2">
						<a class="dropdown-item" href="/VTNN/nhasanxuat/">Danh sách
							nhân viện Sản Xuất</a> <a class="dropdown-item"
							href="/VTNN/nhasanxuat/themnhasanxuat">Thêm nhân viên</a>
						<div class="dropdown-divider"></div>
					</div></li>
			</c:if>


			<li class="nav-item"><a class="nav-link" href="/VTNN/thongke/">
					<i class="fas fa-fw fa-chart-area"></i> <span>Thống kê</span>
			</a></li>
			
		</ul>