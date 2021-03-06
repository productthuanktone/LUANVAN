// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';
$(document)
		.ready(
				function() {
					$("#thang,#nam")
							.hover(
									function() {
										var dataTongtien = [];
										var thang = $("#thang").val();
										var nam = $("#nam").val();
										$
												.ajax({
													url : "/VTNN/thongke/thongkesanphamthang",
													type : "GET",
													data : {
														thang : thang,
														nam : nam
													},
													success : function(value) {
														// alert(value);
														obj = JSON.parse(value);
														// alert(obj[29].tongtien);
														var i;
														for (i = 0; i < 30; i++) {
															dataTongtien[i] = obj[i].tongtien;
														}

														// Bar Chart Example
														var ctx = document
																.getElementById("myBarChart");
														var myLineChart = new Chart(
																ctx,
																{
																	type : 'bar',
																	data : {
																		labels : [
																				"1",
																				"2",
																				"3",
																				"4",
																				"5",
																				"6",
																				"7",
																				"8",
																				"9",
																				"10",
																				"11",
																				"12",
																				"13",
																				"14",
																				"15",
																				"16",
																				"17",
																				"18",
																				"19",
																				"20",
																				"21",
																				"22",
																				"23",
																				"24",
																				"25",
																				"26",
																				"27",
																				"28",
																				"29",
																				"30" ],
																		datasets : [ {
																			label : "Revenue",
																			backgroundColor : "rgba(2,117,216,1)",
																			borderColor : "rgba(2,117,216,1)",
																			data : dataTongtien,
																		} ],
																	},
																	options : {
																		scales : {
																			xAxes : [ {
																				time : {
																					unit : 'month'
																				},
																				gridLines : {
																					display : false
																				},
																				ticks : {
																					maxTicksLimit : 30
																				}
																			} ],
																			yAxes : [ {
																				ticks : {
																					min : 0,
																					max : 50000000,
																					maxTicksLimit : 30
																				},
																				gridLines : {
																					display : true
																				}
																			} ],
																		},
																		legend : {
																			display : false
																		}
																	}
																});
													}
												});
									});

				});
var dataSanPham = [];
var datasoluong = [];
$.ajax({
	url : "/VTNN/thongke/thongkesanphamtrongkho",
	type : "GET",
	data : {},
	success : function(value) {
		obj = JSON.parse(value);
		for (var i = 0; i < obj.length; i++) {
			dataSanPham[i] = obj[i].sanpham;
			datasoluong[i] = obj[i].soluong;
		}
		// alert(dataSanPham);
		// Bar Chart Example
		var ctx = document.getElementById("sanphamtrongkho");
		var myLineChart = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : dataSanPham,
				datasets : [ {
					label : "Revenue",
					backgroundColor : "rgba(2,117,216,1)",
					borderColor : "rgba(2,117,216,1)",
					data : datasoluong,
				} ],
			},
			options : {
				scales : {
					xAxes : [ {
						time : {
							unit : 'month'
						},
						gridLines : {
							display : false
						},
						ticks : {
							maxTicksLimit : 30
						}
					} ],
					yAxes : [ {
						ticks : {
							min : 0,
							max : 500,
							maxTicksLimit : 30
						},
						gridLines : {
							display : true
						}
					} ],
				},
				legend : {
					display : false
				}
			}
		});
	}
});
