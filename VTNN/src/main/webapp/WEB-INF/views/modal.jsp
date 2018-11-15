<div class="modal fade" id="exampleModalCenter"tabindex="-1" role="dialog"aria-labelledby="exampleModalCenterTitle"aria-hidden="true">
													<div class="modal-dialog modal-dialog-centered"
														role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLongTitle">Hóa Đơn </h5>
																<hr>
																<h6 class="modal-title">Khách Hàng: Nguyễn Văn Thuận</h6>
																<button type="button" class="close" data-dismiss="modal"aria-label="Close">
																	<span aria-hidden="true">&times;</span>
																</button>
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
															<c:forEach var="chitiet" items="${listchitiet }">
															<tr>
																	<td><%=a++%></td>
																	<td></td>
																	<td>130,000</td>
																	<td>2</td>
																	<td>260,000</td>
																</tr>
															</c:forEach>
																
															</tbody>
															</table>
															</div>
															<h5>Tổng Giá:<span style="color: red;">260,000</span> VNĐ</h5>
															<div class="modal-footer">
															
																<button type="button" class="btn btn-secondary"data-dismiss="modal">Thoát</button>
																<button type="button" class="btn btn-success">Duyệt Đơn Hàng</button>
															</div>
														</div>
													</div>
												</div>