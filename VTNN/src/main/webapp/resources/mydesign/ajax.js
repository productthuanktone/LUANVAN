$(document).ready(
		function() {
			$(".btn-giohang").click(function(){	
				var machitiet = $(".btn-giohang").attr("data-idchitiet");
				var soluong = $("#soluongsp").val();
				//alert(machitiet+"song luong"+soluong);
				$.ajax({
					url : "/VTNN/api/themgiohang",
					type : "GET",
					data : {
						machitiet : machitiet,
						soluong : soluong

					},
					success : function(value) {
						//alert("saasdasd");
						$(".icongiohang").html("<p>"+value+"</p>");
					}
					
				});
			});
			

});