//时间控件
function formatUnixtimestamp(unixtimestamp) {
	var unixtimestamp = new Date(unixtimestamp);
	var year = 1900 + unixtimestamp.getYear();
	var month = "0" + (unixtimestamp.getMonth() + 1);
	var date = "0" + unixtimestamp.getDate();
	var hour = "0" + unixtimestamp.getHours();
	var minute = "0" + unixtimestamp.getMinutes();
	var second = "0" + unixtimestamp.getSeconds();
	return year + "-" + month.substring(month.length - 2, month.length) + "-"
			+ date.substring(date.length - 2, date.length) + " "
			+ hour.substring(hour.length - 2, hour.length) + ":"
			+ minute.substring(minute.length - 2, minute.length) + ":"
			+ second.substring(second.length - 2, second.length);
}
// 定义搜索变量
var searchTimeSt = "";
var searchTimeEn = "";
var searchName = "";
// 定义分页变量
var start = 1;// 开始
var end = 5;// 结束
var count = 0;// 一共多少条
var currPage = 1;// 当前第几页
var allPage = 0;// 一共多少页
var limit = 5;// 每页显示多少条
// 初始化分页器
$('#myPager1').pager({
	page : currPage,
	recTotal : count,
	recPerPage : limit,
});
// 初始化
function initCome() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-income.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			// 首先清空
			var arr = $(".tr");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			}
			// tb1
			var sumAmount = data.sumAmount;
			var countAmount = data.countAmount;
			var $sumAmount = $("#sumAmount");
			var $countAmount = $("#countAmount");
			$sumAmount.html(sumAmount);
			$countAmount.html(countAmount);
			var $sumDaily = $("#sumDaily");
			$sumDaily.html(sumAmount / 4);
			// tb
			var incomeList = data.incomeList;
			var c = data.count;
			var $tb = $("#tb");
			for (var i = 0; i < incomeList.length; i++) {
				var $tr = $("<tr class='tr' align='center'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(incomeList[i].amountLogId);
				var $td2 = $("<td></td>");
				$td2.html(incomeList[i].amountLogCarnum);
				var $td3 = $("<td></td>");
				$td3.html(incomeList[i].amountLogMoney);
				var $td4 = $("<td></td>");
				$td4.html(incomeList[i].amountLogDesc);
				var $td5 = $("<td></td>");
				$td5.html(formatUnixtimestamp(new Date(incomeList[i].amountLogDescCreateTime)));
				$tr.append($td1);
				$tr.append($td2);
				$tr.append($td3);
				$tr.append($td4);
				$tr.append($td5);
				$("#tb").append($tr);
			}
			// 图表
			var myChart = echarts.init(document.getElementById('main1'),'shine');
			var app = {};
			option = null;
			var posList = [ 'left', 'right', 'top', 'bottom', 'inside','insideTop', 'insideLeft', 'insideRight', 'insideBottom','insideTopLeft', 'insideTopRight', 'insideBottomLeft','insideBottomRight' ];
			app.config = {
				rotate : 90,
				align : 'left',
				verticalAlign : 'middle',
				position : 'insideBottom',
				distance : 15,
				onChange : function() {
					var labelOption = {
						normal : {
							rotate : app.config.rotate,
							align : app.config.align,
							verticalAlign : app.config.verticalAlign,
							position : app.config.position,
							distance : app.config.distance
						}
					};
					myChart.setOption({
						series : [ {
							label : labelOption
						}, {
							label : labelOption
						}, {
							label : labelOption
						}, {
							label : labelOption
						} ]
					});
				}
			};
			//
			var labelOption = {
				normal : {
					show : true,
					position : app.config.position,
					distance : app.config.distance,
					align : app.config.align,
					verticalAlign : app.config.verticalAlign,
					rotate : app.config.rotate,
					formatter : '{c}  {name|{a}}',
					fontSize : 16,
					rich : {name : {textBorderColor : '#fff'}}
				}
			};
			//
			option = {
				color : [ '#F1A325', '#3280FC', '#03B8CF', '#EA644A' ],
				tooltip : {
					trigger : 'axis',
					axisPointer : {
						type : 'shadow'
					}
				},
				legend : {
					data : [ '停车场总收入', '总停车数', 'Desert', 'Wetland' ]
				},
				toolbox : {
					show : true,
					orient : 'vertical',
					left : 'right',
					top : 'center',
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar', 'stack', 'tiled' ]
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				xAxis : [ {
					type : 'category',
					axisTick : {
						show : false
					},
					data : [ '1月', '2月', '3月', '4月' ]
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					name : '停车场总收入',
					type : 'bar',
					barGap : 0,
					label : labelOption,
					data : [ 320, 332, sumAmount, 334 ]
				}, {
					name : '总停车数',
					type : 'bar',
					label : labelOption,
					data : [ 22, 18, countAmount, 23 ]
				} ]
			};
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}
			// 显示page
			count = c;
			$('#myPager1').data('zui.pager').set(currPage, count, limit);
			if (incomeList.length == 0) {
				alert("暂无数据");
			}
		},
		error : function(msg) {
			alert("请联系管理员...");
		}
	});
}
// 初始化
initCome();
// 页码监听
$('#myPager1').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		console.log('页码从', oldState.page, '变更为', state.page);
		// tempData.CurrentPage = state.page;
		currPage = state.page;
		initCome();
	}
});
// 月缴分类
// 初始化分页器
$('#myPager2').pager({
	page : currPage,
	recTotal : count,
	recPerPage : limit,
});
// 初始化
function initMonth() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-incomeMonth.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			// 首先清空
			var arr = $(".tr2");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			}
			var sumCasual = data.sumCasual;
			var sumMonth = data.sumMonth;
			var $sumCasual = $("#sumCasual");
			var $sumMonth = $("#sumMonth");
			$sumCasual.html(sumCasual);
			$sumMonth.html(sumMonth);
			//
			var incomeMonthList = data.incomeMonthList;
			var c = data.count;
			var $tb2 = $("#tb2");
			for (var i = 0; i < incomeMonthList.length; i++) {
				var $tr2 = $("<tr class='tr2' align='center'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(incomeMonthList[i].amountLogId);
				var $td2 = $("<td></td>");
				$td2.html(incomeMonthList[i].carnumRoleId == 1 ? "临时用户" : "月缴用户");
				var $td3 = $("<td></td>");
				$td3.html(incomeMonthList[i].amountLogCarnum);
				var $td4 = $("<td></td>");
				$td4.html(incomeMonthList[i].amountLogMoney);
				var $td5 = $("<td></td>");
				$td5.html(incomeMonthList[i].amountLogDesc);
				var $td6 = $("<td></td>");
				$td6.html(formatUnixtimestamp(new Date(incomeMonthList[i].amountLogDescCreateTime)));
				$tr2.append($td1);
				$tr2.append($td2);
				$tr2.append($td3);
				$tr2.append($td4);
				$tr2.append($td5);
				$tr2.append($td6);
				$("#tb2").append($tr2);
			}
			// 图表
			var myChart = echarts.init(document.getElementById('main2'),'shine');
			option = {
				legend : {},
				tooltip : {},
				dataset : {
					source : [ [ '缴费机', '临时用户收入', '月缴用户收入' ],
							[ '1月数据', 43.3, 85.8 ], [ '2月数据', 83.1, 73.4 ],
							[ '3月数据', sumCasual, sumMonth ],
							[ '4月数据', 72.4, 53.9 ] ]
				},
				xAxis : {
					type : 'category'
				},
				yAxis : {},
				series : [ {
					type : 'bar'
				}, {
					type : 'bar'
				} ]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
			// 显示page
			count = c;
			$('#myPager2').data('zui.pager').set(currPage, count, limit);
			if (incomeMonthList.length == 0) {
				alert("暂无数据");
			}
		},
		error : function(msg) {
			alert("请联系管理员...");
		}
	});
}
initMonth();
// 页码监听
$('#myPager2').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		currPage = state.page;
		initMonth();
	}
});

// 初始化分页器
$('#myPager3').pager({
	page : currPage,
	recTotal : count,
	recPerPage : limit,
});
// 初始化
function initProduct() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-incomeProduct.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			// 首先清空
			var arr = $(".tr3");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			}
			//
			var monthProduct = data.monthProduct;
			var seasonProduct = data.seasonProduct;
			var halfyearProduct = data.halfyearProduct;
			var yearProduct = data.yearProduct;
			var $monthProduct = $("#monthProduct");
			var $seasonProduct = $("#seasonProduct");
			var $halfyearProduct = $("#halfyearProduct");
			var $yearProduct = $("#yearProduct");
			$monthProduct.html(monthProduct);
			$seasonProduct.html(seasonProduct);
			$halfyearProduct.html(halfyearProduct);
			$yearProduct.html(yearProduct);
			//
			var incomeProductList = data.incomeProductList;
			var c = data.count;
			var $tb = $("#tb");
			for (var i = 0; i < incomeProductList.length; i++) {
				var $tr3 = $("<tr class='tr3' align='center'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(incomeProductList[i].carServiceId);
				var $td2 = $("<td></td>");
				$td2.html(incomeProductList[i].carNum);
				var $td3 = $("<td></td>");
				$td3.html(incomeProductList[i].monthProduct);
				var $td4 = $("<td></td>");
				$td4.html(incomeProductList[i].monthProductMonth);
				var $td5 = $("<td></td>");
				$td5.html(incomeProductList[i].monthProductMoney);
				var $td6 = $("<td></td>");
				$td6.html(formatUnixtimestamp(new Date(
						incomeProductList[i].carServiceCreateTime)));
				$tr3.append($td1);
				$tr3.append($td2);
				$tr3.append($td3);
				$tr3.append($td4);
				$tr3.append($td5);
				$tr3.append($td6);
				$("#tb3").append($tr3);
			}
			// 图表
			var myChart = echarts.init(document.getElementById('main3'),
					'shine');
			//
			option = {
				title : {
					text : '月缴产品统计',
					subtext : '',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					left : 'left',
					data : [ '包月产品收入', '季度产品收入', '半年产品收入', '年度产品收入' ]
				},
				series : [ {
					name : '产品收入',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : [ {
						value : yearProduct,
						name : '年度产品收入'
					}, {
						value : seasonProduct,
						name : '季度产品收入'
					}, {
						value : monthProduct,
						name : '包月产品收入'
					}, {
						value : halfyearProduct,
						name : '半年产品收入'
					} ],
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
			// 显示page
			count = c;
			$('#myPager3').data('zui.pager').set(currPage, count, limit);
			if (incomeProductList.length == 0) {
				alert("暂无数据");
			}
		},
		error : function(msg) {
			alert("请联系管理员...");
		}
	});
}
initProduct();
// 页码监听
$('#myPager3').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		currPage = state.page;
		initProduct();
	}
});
//
// 初始化分页器
$('#myPager4').pager({
	page : currPage,
	recTotal : count,
	recPerPage : limit,
});
// 初始化
function initMechine() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-incomeMechine.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			// 首先清空
			var arr = $(".tr4");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			}
			// tb1
			var sumMechineA = data.sumMechineA;
			var sumMechineB = data.sumMechineB;
			var sumMechineC = data.sumMechineC;
			var sumMechineD = data.sumMechineD;
			var $sumMechineA = $("#sumMechineA");
			var $sumMechineB = $("#sumMechineB");
			var $sumMechineC = $("#sumMechineC");
			var $sumMechineD = $("#sumMechineD");
			$sumMechineA.html(sumMechineA + sumMechineB + sumMechineC + sumMechineD);
			$sumMechineB.html(sumMechineB);
			$sumMechineC.html(sumMechineC);
			$sumMechineD.html(sumMechineD);

			// tb
			var incomeMechineList = data.incomeMechineList;
			var c = data.count;
			var $tb4 = $("#tb4");
			for (var i = 0; i < incomeMechineList.length; i++) {
				var $tr4 = $("<tr class='tr4' align='left'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(incomeMechineList[i].mechineLogId);
				var $td2 = $("<td></td>");
				$td2.html(incomeMechineList[i].selfMechineNum);
				var $td3 = $("<td></td>");
				$td3.html(incomeMechineList[i].carNum);
				var $td4 = $("<td></td>");
				$td4.html(incomeMechineList[i].mechineLogMoney);
				var $td5 = $("<td></td>");
				$td5.html(incomeMechineList[i].mechineLogDesc);
				var $td6 = $("<td></td>");
				$td6.html(formatUnixtimestamp(new Date(incomeMechineList[i].mechineLogCreateTime)));
				$tr4.append($td1);
				$tr4.append($td2);
				$tr4.append($td3);
				$tr4.append($td4);
				$tr4.append($td5);
				$tr4.append($td6);
				$("#tb4").append($tr4);
			}
			// 显示page
			count = c;
			$('#myPager4').data('zui.pager').set(currPage, count, limit);
			if (incomeMechineList.length == 0) {
				alert("暂无数据");
			}
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main4'),
					'shine');
			option = {
				legend : {},
				tooltip : {},
				dataset : {
					source : [
							[ '缴费机', 'A出口缴费机收入', 'B出口缴费机收入', 'C出口缴费机收入','D出口缴费机收入' ],
							[ '1月数据', 43.3, 85.8, 93.7, 80 ],
							[ '2月数据', 83.1, 73.4, 55.1, 50 ],
							[ '3月数据', sumMechineA, sumMechineB, sumMechineC,
									sumMechineD ],
							[ '4月数据', 72.4, 53.9, 39.1, 39 ] ]
				},
				xAxis : {
					type : 'category'
				},
				yAxis : {},
				// Declare several bar series, each will be mapped
				// to a column of dataset.source by default.
				series : [ {
					type : 'bar'
				}, {
					type : 'bar'
				}, {
					type : 'bar'
				}, {
					type : 'bar'
				} ]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		},
		error : function(msg) {
			alert("请联系管理员...");
		}
	});
}
initMechine();
// 页码监听
$('#myPager4').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		console.log('页码从', oldState.page, '变更为', state.page);
		// tempData.CurrentPage = state.page;
		currPage = state.page;
		initMechine();
	}
});

// 初始化分页器
$('#myPager5').pager({
	page : currPage,
	recTotal : count,
	recPerPage : limit,
});
// 初始化
function initManual() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-incomeManual.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			// 首先清空
			var arr = $(".tr5");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			}

			var incomeManualList = data.incomeManualList;
			var $sumManual = $("#sumManual");
			$sumManual.html(incomeManualList[0].sumMoney
					+ incomeManualList[1].sumMoney
					+ incomeManualList[2].sumMoney
					+ incomeManualList[3].sumMoney);
			// 图表
			// 获取数组
			if (incomeManualList.length != 0) {
				var name = [ incomeManualList[0].adminName ];
				for (var i = 0; i < incomeManualList.length; i++) {
					var ele = incomeManualList[i].adminName;
					if (name.indexOf(ele) == -1) {
						name.push(ele);
					}
				}
				var income = [ incomeManualList[0].sumMoney ];
				for (var i = 0; i < incomeManualList.length; i++) {
					var ele = incomeManualList[i].sumMoney;
					if (income.indexOf(ele) == -1) {
						income.push(ele);
					}
				}

				// 图表
				var dom = document.getElementById("main5");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
				app.title = '人员管理';

				option = {
					color : [ '#3398DB' ],
					tooltip : {
						trigger : 'axis',
						axisPointer : { // 坐标轴指示器，坐标轴触发有效
							type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					xAxis : [ {
						type : 'category',
						data : name,
						axisTick : {
							alignWithLabel : true
						}
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						name : '直接访问',
						type : 'bar',
						barWidth : '60%',
						data : income
					} ]
				};
				if (option && typeof option === "object") {
					myChart.setOption(option, true);
				}
			} else {
				// 图表
				var dom = document.getElementById("main5");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
				app.title = '人员管理';

				option = {
					color : [ '#3398DB' ],
					tooltip : {
						trigger : 'axis',
						axisPointer : { // 坐标轴指示器，坐标轴触发有效
							type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					xAxis : [ {
						type : 'category',
						data : [ 0, 0, 0, 0, 0 ],
						axisTick : {
							alignWithLabel : true
						}
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						name : '直接访问',
						type : 'bar',
						barWidth : '60%',
						data : [ 0, 0, 0, 0, 0 ]
					} ]
				};
				;
				if (option && typeof option === "object") {
					myChart.setOption(option, true);
				}
			}

			// tb
			var queryIncomeManual = data.queryIncomeManual;
			var c = data.count;
			var $tb5 = $("#tb5");
			for (var i = 0; i < queryIncomeManual.length; i++) {
				var $tr5 = $("<tr class='tr5' align='left'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(queryIncomeManual[i].amountLogId);
				var $td2 = $("<td></td>");
				$td2.html(queryIncomeManual[i].adminName);
				var $td3 = $("<td></td>");
				$td3.html(queryIncomeManual[i].amountLogCarnum);
				var $td4 = $("<td></td>");
				$td4.html(queryIncomeManual[i].amountLogMoney);
				var $td5 = $("<td></td>");
				$td5.html(queryIncomeManual[i].amountLogDesc);
				var $td6 = $("<td></td>");
				$td6.html(formatUnixtimestamp(new Date(
						queryIncomeManual[i].amountLogDescCreateTime)));
				$tr5.append($td1);
				$tr5.append($td2);
				$tr5.append($td3);
				$tr5.append($td4);
				$tr5.append($td5);
				$tr5.append($td6);
				$("#tb5").append($tr5);
			}

			// 显示page
			count = c;
			$('#myPager5').data('zui.pager').set(currPage, count, limit);
			if (queryIncomeManual.length == 0) {
				alert("暂无数据");
			}
		},
		error : function(msg) {
			alert("请联系管理员...");
		}
	});
}
initManual();
// 页码监听
$('#myPager5').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		console.log('页码从', oldState.page, '变更为', state.page);
		currPage = state.page;
		initManual();
	}
});

// 初始化分页器
$('#myPager6').pager({
	page : currPage,
	recTotal : count,
	recPerPage : limit,
});
// 初始化
function initChannel() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-incomeChannel.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			// 首先清空
			var arr1 = $(".tr6");
			for (var i = arr1.length - 1; i >= 0; i--) {
				$(arr1[i]).remove();
			}

			// tb1
			var sumTerminal = data.sumTerminal;
			var sumManual = data.sumManual;
			var $sumTerminal = $("#sumTerminal");
			var $sumManual = $("#sumManual");
			$sumTerminal.html(sumTerminal);
			$sumManual.html(sumManual);
			var $tb6 = $("#tb6");
			var $tr6 = $("<tr class='tr6' align='left'></tr>");
			var $td8 = $("<td></td>");
			$td8.html(sumTerminal);
			var $td9 = $("<td></td>");
			$td9.html(sumManual);
			$tr6.append($td8);
			$tr6.append($td9);
			$("#tb6").append($tr6);

			// 图表
			var myChart = echarts.init(document.getElementById('main6'),
					'shine');
			option = {
				legend : {},
				tooltip : {},
				dataset : {
					source : [ [ '缴费机', '临时用户收入', '月缴用户收入' ],
							[ '1月数据', 43.3, 85.8 ], [ '2月数据', 83.1, 73.4 ],
							[ '3月数据', 175, 210 ], [ '4月数据', 72.4, 53.9 ] ]
				},
				xAxis : {
					type : 'category'
				},
				yAxis : {},
				// Declare several bar series, each will be mapped
				// to a column of dataset.source by default.
				series : [ {
					type : 'bar'
				}, {
					type : 'bar'
				} ]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
		},
		error : function(msg) {
			alert("请联系管理员...");
		}
	});
}
initChannel();
// 页码监听6
$('#myPager6').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		console.log('页码从', oldState.page, '变更为', state.page);
		// tempData.CurrentPage = state.page;
		currPage = state.page;
		initChannel();
	}
});