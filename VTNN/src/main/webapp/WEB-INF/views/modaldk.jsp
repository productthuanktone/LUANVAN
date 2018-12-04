<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="exampleModalCenter2"
	aria-labelledby="exampleModalCenterTitle" disabled="false">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Đăng Ký Tài Khoản</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:if test="${error !=null }">
					<h6 style="color: red;">${error}</h6>
				</c:if>
			</div>
			<div class="modal-body">
				<form action="/VTNN/dangnhap/dangky" method="post">
					<div class="form-group">
						<div class="form-groups">
							<label for="inputEmail4">Email</label> <input type="email" name="email"
								class="form-control" id="inputEmail4" placeholder="Nhập email của bạn">
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
							<label for="inputPassword4">mật khẩu</label> <input name ="matkhau1"
									type="password" class="form-control" id="inputPassword4"
									placeholder="Nhập mật khẩu mới">
							</div>
							<div class="form-group col-md-6">
							<label for="inputPassword4">Nhập lại</label> <input name="matkhau2"
									type="password" class="form-control" id="inputPassword4"
									placeholder="Nhập lại mật khẩu">
							</div>
						</div>
						
					</div>
					<div class="form-row">
							<div class="form-group col-md-6">
							<label for="inputPassword4">Họ tên</label> <input name ="hoten"
									type="text" class="form-control" id="inputPassword4"
									placeholder="Nhập họ tên">
							</div>
							<div class="form-group col-md-6">
							<label for="inputPassword4">Số điện thoại</label> <input name ="sodienthoai"
									type="text" class="form-control" id="inputPassword4"
									placeholder="Nhập số điện thoại">
							</div>
					</div>
					<div class="form-group">
							<label for="inputEmail4">Địa chỉ</label> <input type="text" name="diachi"
								class="form-control" id="inputEmail4" placeholder="Nhập địa chỉ">
						</div>
					<div class="form-row">
						
						<div class="form-group col-md-4">
							<label for="inputState">Giới tính</label> 
							<select id="inputState"
								class="form-control" name="gioitinh">
								<option value="1" selected>Nam</option>
								<option value="0">Nữ</option>
							</select>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Sign in</button>
				</form>
			</div>
		</div>
	</div>
</div>
