<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">
	<div class="container">
		<form action="/VTNN/khuyenmai/themkhuyenmai" method="post" class="formchinhsua">
		<h1 style="   text-align: center;">Chỉnh Sửa Khuyến Mãi</h1>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Tên Khuyến mãi *</label>
					 <input type="text" name="tenkm"class="form-control" id="inputEmail4" >
					 <input type="hidden">
				</div>
				<div class="form-group col-md-6">
					<label for="inputEmail4">Giảm Giá (%)</label>
					 <input type="text" name="phantram"class="form-control" id="inputEmail4" placeholder="nhập địa chỉ">
				</div>
				
				</div>
				<div class="form-row">
				<div class="form-group col-md-6">
						<div class="form-group">
							<label for="inputEmail5">Ngày Bắt Đầu *</label>
							 <input type="date" name="ngaybatdau"class="form-control" id="inputEmail5">
						</div>
						<div class="form-group">
							<label for="inputEmail4">Ngày Kết Thúc *</label>
							 <input type="date" name="ngayketthuc"class="form-control" id="inputEmail4" placeholder="nhập email">
						</div>
						</div>
						<div class="form-group col-md-6">
									<div class="form-group">
									<label for="inputAddress">Mô Tả</label><br>
									<textarea rows="4" cols="56" name="mota"></textarea>
							</div>
						</div>
				</div>
				<c:if test="${loi!=null}">
						<div>${loi }</div>
					</c:if>
				
			<button id="buttonchinhsua" type="submit" class="btn btn-primary">Lưu</button>
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
