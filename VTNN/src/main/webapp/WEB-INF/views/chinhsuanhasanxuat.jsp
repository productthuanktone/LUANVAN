<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div id="content-wrapper">
	<div class="container">
		<form action="/VTNN/nhasanxuat/chinhsua" method="post" class="formchinhsua">
		<h1 style="   text-align: center;">Chỉnh Sửa Nhà Sản Xuất</h1>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputEmail4">Tên Nhà Sản Xuất</label>
					 <input type="text" name="tennsx"class="form-control" id="inputEmail4"  value="${nhasanxuat.getTENNHASANXUAT() }">
					 <input type="hidden" name="id" value="${nhasanxuat.getMANHASANXUAT() }">
				</div>
				<div class="form-group col-md-6">
					<label for="inputEmail4">Địa Chỉ</label>
					 <input type="text" name="diachi"class="form-control" id="inputEmail4" placeholder="nhập địa chỉ" value="${nhasanxuat.getDIACHI() }">
				</div>
				
				</div>
				<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputEmail4">Số Điện Thoại</label>
							 <input type="text" name="sodienthoai"class="form-control" id="inputEmail4" placeholder="nhập số điện thoại" value="${nhasanxuat.getSODIENTHOAI() }">
						</div>
						<div class="form-group col-md-6">
							<label for="inputEmail4">Email</label>
							 <input type="text" name="email"class="form-control" id="inputEmail4" placeholder="nhập email" value="${nhasanxuat.getEMAIL() }">
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
