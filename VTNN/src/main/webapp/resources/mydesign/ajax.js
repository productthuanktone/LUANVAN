$(document).ready(
		function() {
			$(".btn-giohang").click(function() {
				var hinh = $(".hinh").attr("data-hinh");
				var tensanpham = $(".tensanpham").attr("data-tensanpham");
				var gia = $(".gia").attr("data-gia");
				var machitiet = $(".btn-giohang").attr("data-idchitiet");
				var soluong = $("#soluongsp").val();
				// alert(machitiet+" song luong "+soluong+"gia ="+gia+" Ten sp
				// ="+tensanpham+" hinh="+hinh);
				$.ajax({
					url : "/VTNN/api/themgiohang",
					type : "GET",
					data : {
						machitiet : machitiet,
						soluong : soluong,
						gia : gia,
						hinh : hinh,
						tensanpham : tensanpham,

					},
					success : function(value) {
						// alert("saasdasd");
						$(".icongiohang").html("<p>" + value + "</p>");
					}

				});
			});
			$(".btnxoa").click(
					function() {

						var self = $(this);
						var machitiet = $(this).closest("tr").find(".tensp")
								.attr("data-machitietsp");
						$.ajax({
							url : "/VTNN/api/xoasanphamtronggiohang",
							type : "GET",
							data : {
								machitiet : machitiet,
							},
							success : function(value) {
								// alert("saasdasd");
								self.closest("tr").remove();
								TongTien()
							}

						});
					});
			TongTien();
			function TongTien() {
				var tongtiensp = 0;
				$(".giatien")
						.each(
								function() {
									var gia = $(this).attr("data-giatien");
									var soluong = $(this).closest("tr").find(
											".soluongcuagiohang").val();
									tongtien = soluong * gia;
									$(this).html(tongtien);
									tongtiensp = tongtiensp + tongtien;
									var tongtiensp1 = parseFloat(tongtiensp)
											.toFixed().replace(
													/(\d)(?=(\d\d\d)+(?!\d))/g,
													"$1,");
									$("#tongtien").html(tongtiensp1 + "");
									// alert(soluong);
								});
			}

			$(".soluongcuagiohang").change(
					function() {
						var soluong = $(this).val();
						var gia = $(this).closest("tr").find(".giatien").attr(
								"data-giatien");
						var machitiet = $(this).closest("tr").find(".tensp")
								.attr("data-machitietsp");
						var tongtien = soluong * gia;
						$(this).closest("tr").find(".giatien").html(tongtien);
						TongTien();
						$.ajax({
							url : "/VTNN/api/thaydoisoluong",
							type : "GET",
							data : {
								machitiet : machitiet,
								soluong : soluong,
							},
							success : function(value) {
								// alert("saasdasd");
								$(".soluongcuagiohang").html(value);
							}

						});
					});
			$(".xoa").click(
					function() {
						var idspct = $(this).closest("tr").find(".idsp").attr(
								"data-idsp");
						var action = $(".modalsp").attr("action");
						var submitaction = action + idspct;
						$(".modalsp").attr("action", submitaction);

					});
			var files=[];
			$("#choofile").change(function(event){
				var hinh=$("#hinh").attr("src");
				var hinhthaydoi=$(this).val();
				alert(hinhthaydoi);
				files=event.target.files;
				forms=new FormData();
				forms.append("file",files[0]);
				$.ajax({
					url : "/VTNN/api/uploadfile",
					type : "POST",
					data :forms,
					contentType:false,
					processData:false,
					enctype:"multipart/form-data",
					success : function(value) {
						alert(value);
						
					}

				});
			});
		});