<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal fade" id="exampleModalCenter1"
	aria-labelledby="exampleModalCenterTitle" disabled="false">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Đăng nhập</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:if test="${error !=null }">
					<h6 style="color: red;">${error}</h6>
				</c:if>
			</div>
			<div class="modal-body">
				<form action="/VTNN/dangnhap/" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Địa chỉ Email:</label> <input
							type="email" name="tendangnhap" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"
							placeholder="Enter email"> <small id="emailHelp"
							class="form-text text-muted">Đảm bảo quyền riêng tư của
							bạn.</small>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Mật Khẩu</label> <input
							type="password" name="matkhau" class="form-control"
							id="exampleInputPassword1" placeholder="Password">
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Nhớ
							mật khẩu</label>
					</div>
					<button type="submit" class="btn btn-primary">Đăng nhập</button>
				</form>
			</div>
		</div>
	</div>
</div>
