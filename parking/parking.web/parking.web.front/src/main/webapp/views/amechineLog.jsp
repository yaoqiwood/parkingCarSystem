<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>渠道收入明细</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
<!-- <link rel="stylesheet" href="css/adminRole.css"> -->
<style type="text/css">
.panel {
	border: 0;
	-webkit-box-shadow: 0 0 0 rgba(255, 255, 255, 0);
}

#adddialog {
	display: none;
}

#updatedialog {
	display: none;
}

.pager-label {
	line-height: 12px;
}

/* roleAdminCss */
.panelBox {
	position: absolute;
	left: 50%;
	z-index: 3;;
	top: 10%;
	width: 400px;
	transform: translateX(-200px);
}

.table-radius {
	border: 1px solid #ccc;
	border-radius: 4px;
}

.middle {
	vertical-align: middle;
}

.pager-label {
	line-height: 15px;
}

#myPager {
	margin-right: 2px;
}

.backWhite {
	display: none;
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	background-color: rgba(255, 255, 255, 0.2);
	z-index: 2;
}

.bottomSpace {
	margin-bottom: 12px;
}

.scan {
	margin-bottom: 3px;
}

.scan .btn {
	width: 35%;
}

#tb button {
	margin: 0 3px 2px 0;
}

.info-box {
	display: block;
	min-height: 90px;
	width: 100%;
	border-radius: 4px;
	margin-bottom: 15px;
}

.info-box-icon {
	border-top-left-radius: 4px;
	border-top-right-radius: 0;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 4px;
	display: block;
	float: left;
	height: 90px;
	width: 90px;
	text-align: center;
	font-size: 45px;
	line-height: 90px;
}

.info-box-icon .icon {
	text-align: center;
	font-size: 45px;
}

.info-box-content {
	padding: 22px 10px;
	margin-left: 90px;
}

.info-box-text {
	display: block;
	font-size: 14px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.info-box-number {
	display: block;
	font-weight: bold;
	font-size: 18px;
}
/* table info */
.table-info {
	margin-bottom: 0;
}

.table-info td:nth-child(2n-1) {
	font-weight: 600;
}
</style>

</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">渠道收入明细</div>

		<div class="panel-body container-fluid">
			<div class="row">
				
				
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-black">
						<div class="info-box-icon">
							<i class="icon icon-desktop"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">自助缴费收入</span> <span
								class="info-box-number" id="sumMechineA">53 <small>元</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-important">
						<div class="info-box-icon">
							<i class="icon icon-android"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">人工缴费收入</span> <span
								class="info-box-number" id="sumManual">385 <small>元</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-special">
						<div class="info-box-icon">
							<i class="icon icon-time"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">渠道收入</span> <span
								class="info-box-number" id="sumDaily">550 <small>元</small>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">
					<i class="icon icon-bar-chart"></i> 访问URL总计分析 <a
						class="btn btn-link _f-right"> <i class="icon icon-refresh" ></i> 刷新</a>
				</h4>
			</div>
		</div> -->

		<div class="panel-heading center">自助终端分析</div>
		<div class="panel-body container-fluid">
			<div class="col-md-6  col-xs-12">
				<div id="main4" style="width: 600px; height: 400px;"></div>
			</div>
			<div class="col-md-6  col-xs-12">
				<table class="table table-bordered  table-hover" id="tb4">
					<thead>
						<tr>
							<th style="text-align: center">序号</th>
							<th style="text-align: center">自助终端名称</th>
							<th style="text-align: center">车牌号</th>
							<th style="text-align: center">消费</th>
							<th style="text-align: center">消费内容</th>
							<th style="text-align: center">消费时间</th>
						</tr>
					</thead>
					<tbody id="tbody">
						
					</tbody>
				</table>
				<div class="floatRight">
					<ul id="myPager4" class="pager" data-ride="pager"
						data-elements="prev_icon,page_of_total_text,next_icon">
						<li class="pager-item-left pager-item-right"><a
							id="lastPageBtn" class="pager-item" data-page="0"><i
								class="icon icon-double-angle-left"></i></a></li>
						<li>
							<div class="pager-label">
								第 <strong id="CurPageView">1</strong>/<strong id="TotalPageView">1</strong>
								页
							</div>
						</li>
						<li class="pager-item-left"><a id="nextPageBtn"
							class="pager-item" data-page="1"><i
								class="icon icon-double-angle-right"></i></a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="panel-heading center">人工缴费分析</div>
		<div class="panel-body container-fluid">
			<div class="col-md-6  col-xs-12">
				<div align="center">收费人员统计</div>
				<div id="main5" style="width: 600px; height: 400px;"></div>
			</div>
			<div class="col-md-6  col-xs-12">
				<table class="table table-bordered  table-hover" id="tb5">
					<thead>
						<tr>
							<th style="text-align: center">序号</th>
							<th style="text-align: center">收费人员</th>
							<th style="text-align: center">车牌号</th>
							<th style="text-align: center">消费</th>
							<th style="text-align: center">操作记录</th>
							<th style="text-align: center">操作时间</th>
						</tr>
					</thead>
					<tbody id="tbody">
						
					</tbody>
				</table>
				<div class="floatRight">
					<ul id="myPager5" class="pager" data-ride="pager"
						data-elements="prev_icon,page_of_total_text,next_icon">
						<li class="pager-item-left pager-item-right"><a
							id="lastPageBtn" class="pager-item" data-page="0"><i
								class="icon icon-double-angle-left"></i></a></li>
						<li>
							<div class="pager-label">
								第 <strong id="CurPageView">1</strong>/<strong id="TotalPageView">1</strong>
								页
							</div>
						</li>
						<li class="pager-item-left"><a id="nextPageBtn"
							class="pager-item" data-page="1"><i
								class="icon icon-double-angle-right"></i></a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="panel-heading center">缴费渠道分析</div>
			<div class="panel-body container-fluid">
				<div class="col-md-6  col-xs-12">
				<div id="main6" style="width: 600px;height:400px;"></div>
			</div>
			<div class="col-md-6  col-xs-12">
				<table class="table table-bordered  table-hover" id="tb6">
					<thead>
						<tr>
	                        <th style="text-align:center">自助终端收费</th>
	                        <th style="text-align:center">收费人员收费</th>
	                    </tr>
					</thead>
					<tbody id="tbody">
						
					</tbody>
				</table> 
			</div>
		</div>
	</div>

</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/echarts.common.min.js"></script>
<script src="js/shine.js"></script>
<script>
	//时间控件
	function formatUnixtimestamp(unixtimestamp) {
		var unixtimestamp = new Date(unixtimestamp);
		var year = 1900 + unixtimestamp.getYear();
		var month = "0" + (unixtimestamp.getMonth() + 1);
		var date = "0" + unixtimestamp.getDate();
		var hour = "0" + unixtimestamp.getHours();
		var minute = "0" + unixtimestamp.getMinutes();
		var second = "0" + unixtimestamp.getSeconds();
		return year + "-" + month.substring(month.length - 2, month.length)
				+ "-" + date.substring(date.length - 2, date.length) + " "
				+ hour.substring(hour.length - 2, hour.length) + ":"
				+ minute.substring(minute.length - 2, minute.length) + ":"
				+ second.substring(second.length - 2, second.length);
	}
	//定义搜索变量
	var searchTimeSt = "";
	var searchTimeEn = "";
	var searchName = "";
	//定义分页变量
	var start = 1;//开始
	var end = 5;//结束
	var count = 0;//一共多少条
	var currPage = 1;//当前第几页
	var allPage = 0;//一共多少页
	var limit = 5;//每页显示多少条
	
	//
	//初始化分页器
	$('#myPager4').pager({
		page : currPage,
		recTotal : count,
		recPerPage : limit,
	});
	//初始化
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
				console.log(data);
				//首先清空
				var arr = $(".tr4");
				for (var i = arr.length - 1; i >= 0; i--) {
					$(arr[i]).remove();
				}
				/* var arr1 = $(".tr1");
				for (var i = arr1.length - 1; i >= 0; i--) {
					$(arr1[i]).remove();
				} */
				//tb1
				var sumMechineA = data.sumMechineA;
				var sumMechineB = data.sumMechineB;
				var sumMechineC = data.sumMechineC;
				var sumMechineD = data.sumMechineD;
				var $sumMechineA = $("#sumMechineA");
				var $sumMechineB = $("#sumMechineB");
				var $sumMechineC = $("#sumMechineC");
				var $sumMechineD = $("#sumMechineD");
				$sumMechineA.html(sumMechineA+sumMechineB+sumMechineC+sumMechineD);
				$sumMechineB.html(sumMechineB);
				$sumMechineC.html(sumMechineC);
				$sumMechineD.html(sumMechineD);

				//tb
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
					$td6.html(formatUnixtimestamp(new Date(
							incomeMechineList[i].mechineLogCreateTime)));
					$tr4.append($td1);
					$tr4.append($td2);
					$tr4.append($td3);
					$tr4.append($td4);
					$tr4.append($td5);
					$tr4.append($td6);
					$("#tb4").append($tr4);
				}
				//显示page
				count = c;
				$('#myPager4').data('zui.pager').set(currPage, count, limit);
				if (incomeMechineList.length == 0) {
					zuiAlert("暂无数据");
				}
				// 基于准备好的dom，初始化echarts实例
				var myChart = echarts.init(document.getElementById('main4'),
						'shine');
				option = {
					legend : {},
					tooltip : {},
					dataset : {
						source : [
								[ '缴费机', 'A出口缴费机收入', 'B出口缴费机收入', 'C出口缴费机收入',
										'D出口缴费机收入' ],
								[ '1月数据', 43.3, 85.8, 93.7, 80 ],
								[ '2月数据', 83.1, 73.4, 55.1, 50 ],
								[ '3月数据', sumMechineA, sumMechineB,
										sumMechineC, sumMechineD ],
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
				zuiAlert("请联系管理员...");
			}
		});
	}
	initMechine();
	//页码监听
	$('#myPager4').on('onPageChange', function(e, state, oldState) {
		if (state.page !== oldState.page) {
			console.log('页码从', oldState.page, '变更为', state.page);
			//tempData.CurrentPage = state.page;
			currPage = state.page;
			initMechine();
		}
	});

	//
	//初始化分页器
	$('#myPager5').pager({
		page : currPage,
		recTotal : count,
		recPerPage : limit,
	});
	//初始化
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
				console.log(data);
				//首先清空
				var arr = $(".tr5");
				for (var i = arr.length - 1; i >= 0; i--) {
					$(arr[i]).remove();
				}
				
				var incomeManualList = data.incomeManualList;
				var $sumManual = $("#sumManual");
				$sumManual.html(incomeManualList[0].sumMoney+incomeManualList[1].sumMoney+incomeManualList[2].sumMoney+incomeManualList[3].sumMoney);
				//图表
				//获取数组
				if(incomeManualList.length != 0){
					var name = [incomeManualList[0].adminName];
					for(var i = 0; i < incomeManualList.length; i++){
						var ele = incomeManualList[i].adminName;
						if(name.indexOf(ele) == -1) {
							name.push(ele);
						}
					}
					var income = [incomeManualList[0].sumMoney ];
					for(var i = 0; i < incomeManualList.length; i++){
						var ele = incomeManualList[i].sumMoney;
						if(income.indexOf(ele) == -1) {
							income.push(ele);
						}
					}
					
					//图表
					var dom = document.getElementById("main5");
					var myChart = echarts.init(dom);
					var app = {};
					option = null;
					app.title = '人员管理';
					
					option = {
						color: ['#3398DB'],
						tooltip: {
							trigger: 'axis',
							axisPointer: { // 坐标轴指示器，坐标轴触发有效
								type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
							}
						},
						grid: {
							left: '3%',
							right: '4%',
							bottom: '3%',
							containLabel: true
						},
						xAxis: [{
							type: 'category',
							data: name,
							axisTick: {
								alignWithLabel: true
							}
						}],
						yAxis: [{
							type: 'value'
						}],
						series: [{
							name: '直接访问',
							type: 'bar',
							barWidth: '60%',
							data: income
						}]
					};;
					if(option && typeof option === "object") {
						myChart.setOption(option, true);
					}
				}else{
					
					//图表
					var dom = document.getElementById("main5");
					var myChart = echarts.init(dom);
					var app = {};
					option = null;
					app.title = '人员管理';
					
					option = {
						color: ['#3398DB'],
						tooltip: {
							trigger: 'axis',
							axisPointer: { // 坐标轴指示器，坐标轴触发有效
								type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
							}
						},
						grid: {
							left: '3%',
							right: '4%',
							bottom: '3%',
							containLabel: true
						},
						xAxis: [{
							type: 'category',
							data: [0, 0, 0, 0, 0],
							axisTick: {
								alignWithLabel: true
							}
						}],
						yAxis: [{
							type: 'value'
						}],
						series: [{
							name: '直接访问',
							type: 'bar',
							barWidth: '60%',
							data: [0, 0, 0, 0, 0]
						}]
					};;
					if(option && typeof option === "object") {
						myChart.setOption(option, true);
					}
				}
				
				//tb
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
				
				//显示page
				count = c;
				$('#myPager5').data('zui.pager').set(currPage, count, limit);
				if (queryIncomeManual.length == 0) {
					zuiAlert("暂无数据");
				}
			},
			error : function(msg) {
				zuiAlert("请联系管理员...");
			}
		});
	}
	initManual();
	//页码监听
	$('#myPager5').on('onPageChange', function(e, state, oldState) {
		if (state.page !== oldState.page) {
			console.log('页码从', oldState.page, '变更为', state.page);
			//tempData.CurrentPage = state.page;
			currPage = state.page;
			initManual();
		}
	});
	
	//初始化分页器
	$('#myPager6').pager({
	    page: currPage,
	    recTotal: count,
	    recPerPage: limit,
	});
	//初始化
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
				//首先清空
				/* var arr = $(".tr");
				for (var i = arr.length - 1; i >= 0; i--) {
					$(arr[i]).remove();
				} */
				var arr1 = $(".tr6");
				for (var i = arr1.length - 1; i >= 0; i--) {
					$(arr1[i]).remove();
				}
				
				//tb1
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
				
				//图表
				var myChart = echarts.init(document.getElementById('main6'),'shine');
				option = {
					legend: {},
					tooltip: {},
					dataset: {
						source: [
							['缴费机', '临时用户收入', '月缴用户收入'],
							['1月数据', 43.3, 85.8],
							['2月数据', 83.1, 73.4],
							['3月数据', 175, 210],
							['4月数据', 72.4, 53.9]
						]
					},
					xAxis: {
						type: 'category'
					},
					yAxis: {},
					// Declare several bar series, each will be mapped
					// to a column of dataset.source by default.
					series: [{
							type: 'bar'
						},
						{
							type: 'bar'
						}
					]
				};
				// 使用刚指定的配置项和数据显示图表。
				myChart.setOption(option);
				/* var incomeMonthList = data.incomeMonthList;
				var c = data.count;
				var $tb = $("#tb");
				for (var i = 0; i < incomeMonthList.length; i++) {
					var $tr = $("<tr class='tr' align='left'></tr>");
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
					$td6.html(formatUnixtimestamp(new Date(
							incomeMonthList[i].amountLogDescCreateTime)));
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$("#tb").append($tr);
				}
				//显示page
				count = c;
				$('#myPager').data('zui.pager').set(currPage, count, limit);
				if (incomeMonthList.length == 0) {
					alert("暂无数据");
				} */
			},
			error : function(msg) {
				zuiAlert("请联系管理员...");
			}
		});
	}
	initChannel();
	//页码监听6
	$('#myPager6').on('onPageChange', function (e, state, oldState) {
		if (state.page !== oldState.page) {
			console.log('页码从', oldState.page, '变更为', state.page);
			//tempData.CurrentPage = state.page;
			currPage = state.page;
			initChannel();
		}
	});
</script>
</html>