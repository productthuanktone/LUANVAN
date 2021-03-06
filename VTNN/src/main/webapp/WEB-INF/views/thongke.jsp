<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<a class="nav-item nav-link active" id="nav-home-tab"
				data-toggle="tab" href="#nav-home" role="tab"
				aria-controls="nav-home" aria-selected="true">DOANH THU</a> <a
				class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
				href="#nav-profile" role="tab" aria-controls="nav-profile"
				aria-selected="false">Profile</a> <a class="nav-item nav-link"
				id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
				role="tab" aria-controls="nav-contact" aria-selected="false">Kho</a>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">


			<br>

			<div class="container">
				<div style="text-align: center; font-size: 30px;">THỐNG KÊ
					DOANH THU NGÀY TRONG THÁNG</div>
				<div class="row">
					<div class="form-row">
						<label for="exampleFormControlSelect1">Chọn tháng:</label> <select
							id="thang" class="form-control" id="exampleFormControlSelect1">
							<option value="1">tháng 1</option>
							<option value="2">tháng 2</option>
							<option value="3">tháng 3</option>
							<option value="4">tháng 4</option>
							<option value="5">tháng 5</option>
							<option value="6">tháng 6</option>
							<option value="7">tháng 7</option>
							<option value="8">tháng 8</option>
							<option value="9">tháng 9</option>
							<option value="10">tháng 10</option>
							<option value="11">tháng 11</option>
							<option value="12">tháng 12</option>
						</select>
					</div>
					<div class="form-row">
						<label for="exampleFormControlSelect2">Chọn năm:</label> <select
							id="nam" class="form-control" id="exampleFormControlSelect2">
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
						</select>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-chart-bar"></i> Doanh thu tháng
						</div>
						<div class="card-body">
							<canvas id="myBarChart" width="100%" height="50"></canvas>
						</div>
						<div class="card-footer small text-muted"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-profile" role="tabpanel"
			aria-labelledby="nav-profile-tab">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-chart-area"></i> Area Chart Example
				</div>
				<div class="card-body">
					<canvas id="myAreaChart" width="100%" height="30"></canvas>
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-contact" role="tabpanel"
			aria-labelledby="nav-contact-tab">
			<div class="container">
				<div style="text-align: center; font-size: 30px;">SẢN PHẨM TRONG KHO</div>
				<div class="col-lg-12">
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-chart-bar"></i>Kho sản phẩm
						</div>
						<div class="card-body">
							<canvas id="sanphamtrongkho" width="100%" height="50"></canvas>
						</div>
						<div class="card-footer small text-muted"></div>
					</div>
				</div>
			</div>
			</div>
	</div>


	<!-- Sticky Footer -->
	<footer class="sticky-footer">
		<div class="container my-auto">
			<div class="copyright text-center my-auto">
				<span>Copyright © Your Website 2018</span>
			</div>
		</div>
	</footer>

</div>
<!-- /.content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="login.html">Logout</a>
			</div>
		</div>
	</div>
</div>
<jsp:include page="FooterAdmin.jsp"></jsp:include>