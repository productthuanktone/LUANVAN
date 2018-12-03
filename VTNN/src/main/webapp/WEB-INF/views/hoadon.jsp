<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">

	<div class="container-fluid">
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Danh Sách Hóa Đơn
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered cachgiuatable" id="dataTable"
						width="100%" cellspacing="0">
						<thead class="mauheader">
							<tr>
								<th>STT</th>
								<th>Mã Hóa Đơn</th>
								<th>Tên khách Hàng</th>
								<th>Số Điện Thoại</th>
								<th>Tổng Tiền</th>
								<th>Hình Thức Giao Hàng</th>
								<th>Ngày Đặt</th>
								<th>Duyệt Hóa Đơn</th>
								<th>Chi Tiết</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>STT</th>
								<th>Mã Hóa Đơn</th>
								<th>Tên khách Hàng</th>
								<th>Số Điện Thoại</th>
								<th>Tổng Tiền</th>
								<th>Hình Thức Giao Hàng</th>
								<th>Ngày Đặt</th>
								<th>Duyệt Hóa Đơn</th>
								<th>Chi Tiết</th>
							</tr>
						</tfoot>
						<tbody>
							<%
										int i = 1;
									%>
							<c:forEach var="hoadon" items="${hoadon }">
								<tr>
									<td class="mauheader"><%=i++%></td>
									<td>${hoadon.getMAHOADON() }</td>
									<td>${hoadon.getTENKHACHHANG()	}</td>
									<td>${hoadon.getSODIENTHOAI()}</td>
									<td>${hoadon.getTONGGIA() }</td>
									<td><c:if test="${hoadon.getHINHTHUCGIAOHANG()==0 }">
											<span class="noibat">Nhận ở địa chỉ giao</span>
										</c:if> <c:if test="${hoadon.getHINHTHUCGIAOHANG()==1 }">
											<span>Nhận Tại Cửa hàng</span>
										</c:if></td>
									<td>${hoadon.getTIMECREATE()}</td>
									<td><c:if test="${hoadon.getTINHTRANG()==0 }">
											<button type="button" class="btn btn-warning buttonhd">Chưa
												duyệt</button>
										</c:if> <c:if test="${hoadon.getTINHTRANG()==1 }">
											<button type="button" class="btn btn-success buttonhd">Đã
												duyệt</button>
										</c:if> <c:if test="${hoadon.getTINHTRANG()==2 }">
											<button type="button" class="btn btn-secondary buttonhd">Đã
												Hủy</button>
										</c:if></td>
									</td>
									<td><a href="/VTNN/hoadon/${hoadon.getMAHOADON() }">
											<button type="button" class="btn btn-primary"
												>Chi
												Tiết</button>
									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>

		<p class="small text-center text-muted my-5">
			<em>More table examples coming soon...</em>
		</p>

	</div>
	<!-- /.container-fluid -->

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
<jsp:include page="FooterAdmin.jsp"></jsp:include>