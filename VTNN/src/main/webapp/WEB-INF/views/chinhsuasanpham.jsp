<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">
	<div class="container">
		<form action="/VTNN/adminsanpham/updatectsp" method="post" class="formchinhsua">
		<h1>Chỉnh Sửa Chi Tiết Sản Phẩm</h1>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Tên Sản Phẩm</label>
					 <input type="text" name="tensp"class="form-control" id="inputEmail4" placeholder="tên sản phẩm" value="${sanpham.getSanpham().getTENSANPHAM() }">
					 <input type="hidden" name="id" value="${sanpham.getMACHITIETSANPHAM() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Hãng Sản Xuất</label>
					 <select id="inputState" class="form-control" name="nhasanxuat">
						<option value="${sanpham.getNhasanxuat().getMANHASANXUAT() }" selected>${sanpham.getNhasanxuat().getTENNHASANXUAT() }</option>
						<c:forEach  items="${nhasanxuat}" var="nhasanxuat">
						<c:if test="${nhasanxuat.getMANHASANXUAT()!=sanpham.getNhasanxuat().getMANHASANXUAT()}">
							<option value="${nhasanxuat.getMANHASANXUAT() }">${nhasanxuat.getTENNHASANXUAT()}</option>
						</c:if>
						
						</c:forEach>
					</select>
				</div>
				
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputPassword4">Số Lượng</label>
					 <input type="text"class="form-control" id="inputPassword4" placeholder="Số lượng" name="soluong" value="${sanpham.getSOLUONG() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Khuyến Mãi</label> 
					<select id="inputState"class="form-control" name="khuyenmai">
					<option value="${sanpham.getKhuyenmai().getMAKHUYENMAI() }" selected>${sanpham.getKhuyenmai().getTENKHUYENMAI() }</option>
						<c:forEach  items="${khuyenmai}" var="khuyenmai">
						<c:if test="${khuyenmai.getMAKHUYENMAI()!=sanpham.getKhuyenmai().getMAKHUYENMAI()}">
							<option value="${khuyenmai.getMAKHUYENMAI() }">${khuyenmai.getTENKHUYENMAI()}</option>
						</c:if>
						
						</c:forEach>
						
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputCity">Giá</label> 
					<input type="text"
						class="form-control" id="inputCity" name="gia" value="${sanpham.getGia().getGIA() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Danh Mục</label>
					 <select id="inputState"class="form-control" name="danhmuc">
						<option value="${sanpham.getDanhMucSanPham().getMADANHMUC() }" selected>${sanpham.getDanhMucSanPham().getTENDANHMUC()}</option>
						<c:forEach items="${danhmuc}" var="danhmuc">
						<c:if test="${danhmuc.getMADANHMUC()!=sanpham.getDanhMucSanPham().getMADANHMUC()}">
							<option value="${danhmuc.getMADANHMUC() }">${danhmuc.getTENDANHMUC()}</option>
						</c:if>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
				<label for="inputAddress">Mô Tả</label><br>
				 <textarea rows="4" cols="58" name="mota">${sanpham.getSanpham().getMOTA() }</textarea>
				 </div>
				 <div class="form-row col-md-6">
					<div class="col-md-6">
					<img name="hinh" id="hinh" class="card-img-top"src='<c:url value="/resources/img/sanpham/${sanpham.getHinh().getHINH() }"/>'alt="Card image cap" style="height: 182px;">
					</div>
					<div class="col-md-6">
					<input id="choofile" type="file" name="hinh" style="margin-left: -72px;">
					</div>
				</div>
				
			</div>
			<div><button id="buttonchinhsua" type="submit" class="btn btn-primary">Chỉnh Sửa</button></div>
		</form>
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