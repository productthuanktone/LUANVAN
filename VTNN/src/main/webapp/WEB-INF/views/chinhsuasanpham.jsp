<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">
	<div class="container">
	<h1>Chỉnh Sửa Chi Tiết Sản Phẩm</h1>
		<form>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Tên Sản Phẩm</label> <input type="text"
						class="form-control" id="inputEmail4" placeholder="tên sản phẩm" value="${sanpham.getSanpham().getTENSANPHAM() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Hãng Sản Xuất</label> <select id="inputState"
						class="form-control">
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
					<label for="inputPassword4">Số Lượng</label> <input type="text"
						class="form-control" id="inputPassword4" placeholder="Số lượng" value="${sanpham.getSOLUONG() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Khuyến Mãi</label> 
					<select id="inputState"class="form-control">
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
						class="form-control" id="inputCity" value="${sanpham.getGia().getGIA() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputState">Danh Mục</label> <select id="inputState"
						class="form-control">
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
				 <textarea rows="4" cols="75">${sanpham.getSanpham().getMOTA() }</textarea>
				 </div>
				 <div class="form-row col-md-6">
					<div class="col-md-6">
					<img id="hinh" class="card-img-top"src='<c:url value="/resources/img/sanpham/${sanpham.getHinh().getHINH() }"/>'alt="Card image cap" style="    width: 295px;
    height: 182px;">
					</div>
					<div class="col-md-6">
					<input id="choofile" type="file" name="hinhanh">
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> Check me
						out </label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Sign in</button>
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