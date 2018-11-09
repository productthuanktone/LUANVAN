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
			TongTien();
			function TongTien() {
				var tongtiensp = 0;
				$(".giatien")
						.each(
								function() {
									var gia = $(this).text();
									tongtiensp = tongtiensp + parseFloat(gia);
									$(this).html(gia);
									var tongtiensp1 = parseFloat(tongtiensp)
											.toFixed().replace(
													/(\d)(?=(\d\d\d)+(?!\d))/g,
													"$1,");
									$("#tongtien").html(tongtiensp1 + "");
									// alert(num);
								});
			}

			$(".soluongcuagiohang").change(
					function() {
						var soluong = $(this).val();
						var gia = $(this).closest("tr").find(".giatien").attr(
								"data-giatien");
						var tongtien = soluong * gia;
						$(this).closest("tr").find(".giatien").html(tongtien);
						TongTien();
					});
		});