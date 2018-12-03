<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="HeaderAdmin.jsp"></jsp:include>
<div class="container">
<div id="lablehoadon">
	<h1>Hóa Đơn</h1>
	<h6>Khách Hàng: ${hoadon.getTENKHACHHANG() }</h6>
</div>
<div class="modal-body">
	<table class="tablehd table table-bordered cachgiuatable">
		<thead>
			<tr>
				<th>STT</th>
				<th>Tên Sản Phẩm</th>
				<th>Giá</th>
				<th>Số Lượng</th>
				<th>Tổng Giá</th>
			</tr>
		</thead>
		<tbody>
			<% int a =1; %>
			<c:forEach var="chitiet" items="${listchitiet}">
				<tr>
					<td><%=a++%></td>
					<td>${chitiet.getChiTietSanPham().getSanpham().getTENSANPHAM()}</td>
					<td>${chitiet.getChiTietSanPham().getGia().getGIA() }</td>
					<td>${chitiet.getSOLUONG()}</td>
					<td>${chitiet.getTONGGIA()}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
<h5>
	Tổng Giá:<span style="color: red;"> ${hoadon.getTONGGIA()}</span> VNĐ
</h5>
<c:if test="${$hethang !=''}">
<h1>${hethang}</h1>
</c:if>
<div class="modal-footer">
	<a href="/VTNN/hoadon/duyenhoadon/1/${hoadon.getMAHOADON() }" type="button" class="btn btn-success">Duyệt Đơn Hàng</a>
	<a href="/VTNN/hoadon/duyenhoadon/2/${hoadon.getMAHOADON() }" type="button" class="btn btn-warning " >Hủy Hóa Đơn</a>
	<a href="/VTNN/hoadon/" type="button" class="btn btn-secondary" >Thoát</a>
	
</div>
</div>
<jsp:include page="FooterAdmin.jsp"></jsp:include>