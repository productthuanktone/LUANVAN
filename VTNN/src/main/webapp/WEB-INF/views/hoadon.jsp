<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active" id="home-tab"
			data-toggle="tab" href="#tatca" role="tab" aria-controls="home"
			aria-selected="true">Tắt cả</a></li>
		<li class="nav-item"><a class="nav-link" id="profile-tab"
			data-toggle="tab" href="#chuaduyet" role="tab"
			aria-controls="profile" aria-selected="false">Chưa duyệt</a></li>
		<li class="nav-item"><a class="nav-link" id="contact-tab"
			data-toggle="tab" href="#daduyet" role="tab" aria-controls="contact"
			aria-selected="false">Đã duyệt</a></li>
		<li class="nav-item"><a class="nav-link" id="contact-tab"
			data-toggle="tab" href="#dahuy" role="tab" aria-controls="contact"
			aria-selected="false">Đã hủy</a></li>
	</ul>
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-table"></i>
		</div>
		<div class="tab-content" id="myTabContent">
			<div class="card-body tab-pane fade show active" id="tatca"
				role="tabpanel">
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
									<td><fmt:formatNumber type="number" pattern="###,###" value="${hoadon.getTONGGIA() }"/> VNĐ</td>
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
											<button type="button" class="btn btn-primary">Chi
												Tiết</button>
									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
			<div class="card-body tab-pane fade " id="chuaduyet" role="tabpanel">
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
										int a = 1;
									%>
							<c:forEach var="hoadonchuaduyet" items="${hoadonchuaduyet}">
								<tr>
									<td class="mauheader"><%=a++%></td>
									<td>${hoadonchuaduyet.getMAHOADON() }</td>
									<td>${hoadonchuaduyet.getTENKHACHHANG()	}</td>
									<td>${hoadonchuaduyet.getSODIENTHOAI()}</td>
									<td><fmt:formatNumber type="number" pattern="###,###" value="${hoadonchuaduyet.getTONGGIA() }"/> VNĐ</td>
									<td><c:if
											test="${hoadonchuaduyet.getHINHTHUCGIAOHANG()==0 }">
											<span class="noibat">Nhận ở địa chỉ giao</span>
										</c:if> <c:if test="${hoadonchuaduyet.getHINHTHUCGIAOHANG()==1 }">
											<span>Nhận Tại Cửa hàng</span>
										</c:if></td>
									<td>${hoadonchuaduyet.getTIMECREATE()}</td>
									<td><c:if test="${hoadonchuaduyet.getTINHTRANG()==0 }">
											<button type="button" class="btn btn-warning buttonhd">Chưa
												duyệt</button>
										</c:if> <c:if test="${hoadonchuaduyet.getTINHTRANG()==1 }">
											<button type="button" class="btn btn-success buttonhd">Đã
												duyệt</button>
										</c:if> <c:if test="${hoadonchuaduyet.getTINHTRANG()==2 }">
											<button type="button" class="btn btn-secondary buttonhd">Đã
												Hủy</button>
										</c:if></td>
									</td>
									<td><a
										href="/VTNN/hoadon/${hoadonchuaduyet.getMAHOADON() }">
											<button type="button" class="btn btn-primary">Chi
												Tiết</button>
									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>

			<div class="card-body tab-pane fad" id="daduyet" role="tabpanel"
				aria-labelledby="contact-tab">
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
										int b = 1;
									%>
							<c:forEach var="hoadondaduyet" items="${hoadondaduyet}">
								<tr>
									<td class="mauheader"><%=b++%></td>
									<td>${hoadondaduyet.getMAHOADON() }</td>
									<td>${hoadondaduyet.getTENKHACHHANG()	}</td>
									<td>${hoadondaduyet.getSODIENTHOAI()}</td>
									<td><fmt:formatNumber type="number" pattern="###,###" value="${hoadondaduyet.getTONGGIA() }"/> VNĐ</td>
									<td><c:if
											test="${hoadondaduyet.getHINHTHUCGIAOHANG()==0 }">
											<span class="noibat">Nhận ở địa chỉ giao</span>
										</c:if> <c:if test="${hoadondaduyet.getHINHTHUCGIAOHANG()==1 }">
											<span>Nhận Tại Cửa hàng</span>
										</c:if></td>
									<td>${hoadondaduyet.getTIMECREATE()}</td>
									<td><c:if test="${hoadondaduyet.getTINHTRANG()==0 }">
											<button type="button" class="btn btn-warning buttonhd">Chưa
												duyệt</button>
										</c:if> <c:if test="${hoadondaduyet.getTINHTRANG()==1 }">
											<button type="button" class="btn btn-success buttonhd">Đã
												duyệt</button>
										</c:if> <c:if test="${hoadondaduyet.getTINHTRANG()==2 }">
											<button type="button" class="btn btn-secondary buttonhd">Đã
												Hủy</button>
										</c:if></td>
									</td>
									<td><a href="/VTNN/hoadon/${hoadondaduyet.getMAHOADON() }">
											<button type="button" class="btn btn-primary">Chi
												Tiết</button>
									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
			<div class="card-body tab-pane fad" id="dahuy" role="tabpanel"
				aria-labelledby="contact-tab">
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
										int c = 1;
									%>
							<c:forEach var="hoadondahuy" items="${hoadondahuy}">
								<tr>
									<td class="mauheader"><%=c++%></td>
									<td>${hoadondahuy.getMAHOADON() }</td>
									<td>${hoadondahuy.getTENKHACHHANG()	}</td>
									<td>${hoadondahuy.getSODIENTHOAI()}</td>
									<td><fmt:formatNumber type="number" pattern="###,###" value="${hoadondahuy.getTONGGIA() }"/> VNĐ</td>
									<td><c:if test="${hoadondahuy.getHINHTHUCGIAOHANG()==0 }">
											<span class="noibat">Nhận ở địa chỉ giao</span>
										</c:if> <c:if test="${hoadondahuy.getHINHTHUCGIAOHANG()==1 }">
											<span>Nhận Tại Cửa hàng</span>
										</c:if></td>
									<td>${hoadondahuy.getTIMECREATE()}</td>
									<td><c:if test="${hoadondahuy.getTINHTRANG()==0 }">
											<button type="button" class="btn btn-warning buttonhd">Chưa
												duyệt</button>
										</c:if> <c:if test="${hoadondahuy.getTINHTRANG()==1 }">
											<button type="button" class="btn btn-success buttonhd">Đã
												duyệt</button>
										</c:if> <c:if test="${hoadondahuy.getTINHTRANG()==2 }">
											<button type="button" class="btn btn-secondary buttonhd">Đã
												Hủy</button>
										</c:if></td>
									</td>
									<td><a href="/VTNN/hoadon/${hoadondahuy.getMAHOADON() }">
											<button type="button" class="btn btn-primary">Chi
												Tiết</button>
									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
		</div>
	</div>

	<div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div>
</div>


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