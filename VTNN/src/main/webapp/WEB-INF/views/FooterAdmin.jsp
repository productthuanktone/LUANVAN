<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="login.html">Logout</a>
			</div>
		</div>
	</div>
</div>

<!-- Bootstrap core JavaScript-->
<script
	src="<c:url value="/resources/admin/vendor/jquery/jquery.min.js"/>"></script>
<script
	src="<c:url value="/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script
	src="<c:url value="/resources/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Page level plugin JavaScript-->
<script
	src="<c:url value="/resources/admin/vendor/datatables/jquery.dataTables.js"/>"></script>
<script
	src="<c:url value="/resources/admin/vendor/datatables/dataTables.bootstrap4.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/resources/admin/js/sb-admin.min.js"/>"></script>
<script
	src="<c:url value="/resources/admin/js/demo/chart-area-demo.js"/>"></script>
<script
	src="<c:url value="/resources/admin/js/demo/chart-bar-demo.js"/>"></script>
<script
	src="<c:url value="/resources/admin/js/demo/chart-pie-demo.js"/>"></script>
<!-- Demo scripts for this page-->
<script
	src="<c:url value="/resources/admin/js/demo/datatables-demo.js"/>"></script>
<script src='<c:url value="/resources/mydesign/ajax.js"/>'></script>
</body>

</html>
</html>