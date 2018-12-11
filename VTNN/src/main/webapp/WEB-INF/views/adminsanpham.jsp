<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">

	<div class="container-fluid">
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Danh Sách Sản Phẩm
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered cachgiuatable" id="dataTable"
						width="100%" cellspacing="0">
						<thead class="mauheader">
							<tr>
								<th>STT</th>
								<th>Hình Sản Phẩm</th>
								<th>Tên Sản Phẩm</th>
								<th>Nhà Sản Xuất</th>
								<th>Danh Mục</th>
								<th>Khuyến Mãi</th>
								<th>Mô Tả</th>
								<th>Đơn vị tính</th>
								<th>Giá</th>
								<th>Số Lượng</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>STT</th>
								<th>Hình Sản Phẩm</th>
								<th>Tên Sản Phẩm</th>
								<th>Nhà Sản Xuất</th>
								<th>Danh Mục</th>
								<th style="width: 150px;">Khuyến Mãi</th>
								<th>Mô Tả</th>
								<th>Đơn vị tính</th>
								<th style="width: 100px;">Giá</th>
								<th>Số Lượng</th>
								<th></th>
							</tr>
						</tfoot>
						<tbody>
							<%
										int i = 1;
									%>
							<c:forEach var="listsanpham" items="${listsanpham }">
								<tr>
									<td><%=i++%></td>
									<td><img class="hinhgiohang" alt="hinh"
											src='<c:url value="/resources/img/sanpham/${listsanpham.getHinh().getHINH() }"/>' /></td>
									<td class="idsp" data-idsp="${listsanpham.getMACHITIETSANPHAM() }">${listsanpham.getSanpham().getTENSANPHAM()}</td>
									<td>${listsanpham.getNhasanxuat().getTENNHASANXUAT()}</td>
									<td>${listsanpham.getDanhMucSanPham().getTENDANHMUC() }</td>
									<td>${listsanpham.getKhuyenmai().getTENKHUYENMAI() }(${listsanpham.getKhuyenmai().getPHANTRAM()}%)</td>
									<td><p>${listsanpham.getSanpham().getMOTA() }</p></td>
									<td>${listsanpham.getDonvitinh().getTENDONVITINH()}</td>
									<td> <fmt:formatNumber type="number" pattern="###,###" value="${listsanpham.getGia().getGIA()}" /> VNĐ</td>
									<td>${listsanpham.getSOLUONG()}</td>
									<td style="width: 250px;"><a class="btn btn-secondary buttonhd xoa" data-toggle="modal" data-target="#exampleModalCenter11" style="width: 97px;">Xóa</a>
												<div class="modal fade" id="exampleModalCenter11"
													aria-labelledby="exampleModalCenterTitle" disabled="false">
														<div class="modal-dialog modal-dialog-centered" role="document">
															<div class="modal-content">
																<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLongTitle">Thông Báo</h5>
																<button type="button" class="close" data-dismiss="modal"
																	aria-label="Close">
																	<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">
															<form class="modalsp" action="/VTNN/adminsanpham/" method="get">
																<h2>Bạn có chắc xóa không ?</h2>
															<button type="submit" class="btn btn-primary">Xóa</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									<a href="/VTNN/adminsanpham/chinhsua/${listsanpham.getMACHITIETSANPHAM() }" type="button" class="btn btn-success" >Chỉnh Sửa</a>
									</td>
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