<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="3rd/zui/css/zui.min.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/incomeChannel.css">
    <link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
    <title>收费渠道统计</title>

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
			z-index: 3;
			;
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
		/* roleAdminCss */
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

.row {
	position: relative;
	left: 25%;
}
	</style>

</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">收费渠道统计</div>
			<div class="panel-body container-fluid">
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
			            <div class="info-box bg-danger">
			                <div class="info-box-icon">
			                    <i class="icon icon-user"></i>
			                </div>
			                <div class="info-box-content">
			                    <span class="info-box-text">自助终端收入</span>
			                    <span class="info-box-number" id="sumTerminal" >
			                        <small></small>
			                    </span>
			                </div>
			            </div>
			        </div>
			        <div class="col-md-3 col-sm-6 col-xs-12">
			            <div class="info-box bg-warning">
			                <div class="info-box-icon">
			                    <i class="icon icon-moon"></i>
			                </div>
			                <div class="info-box-content">
			                    <span class="info-box-text">收费人员收入</span>
			                    <span class="info-box-number" id="sumManual">
			                        <small></small>
			                    </span>
			                </div>
			            </div>
			        </div>
				</div>
			</div>
		</div>
		<div class="col-md-6  col-xs-12">
			<div id="main" style="width: 600px;height:400px;"></div>
		</div>
		<div class="col-md-6  col-xs-12">
			<table class="table table-bordered  table-hover" id="tb1">
				<thead>
					<tr>
                        <th style="text-align:center">自助终端收费</th>
                        <th style="text-align:center">收费人员收费</th>
                    </tr>
				</thead>
				<tbody id="tbody">
					<tr class="tr1">
						<td>zhangsan</td>
						<td>692.4</td>
					</tr>

				</tbody>
			</table> 
		</div>

	</div>
	

</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<!-- <script src="js/table_funs.js"></script> -->
<!-- <script src="js/tableDemo.js"></script> -->
<!-- <script src="js/common.js"></script> -->
<!-- <script src="js/configure.js"></script> -->
<script src="js/table_funs.js"></script>
<<<<<<< .mine
<script src="js/tableDemo.js"></script>
<!-- <script src="js/common.js"></script> -->
<!-- <script src="js/configure.js"></script> -->
||||||| .r206
=======
<script src="js/echarts.common.min.js"></script>
<script src="js/shine.js"></script>
>>>>>>> .r211
<script>
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
//初始化分页器
$('#myPager').pager({
    page: currPage,
    recTotal: count,
    recPerPage: limit,
});
//初始化
function init() {
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
			var arr1 = $(".tr1");
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
			var $tb1 = $("#tb1");
			var $tr1 = $("<tr class='tr' align='left'></tr>");
			var $td8 = $("<td></td>");
			$td8.html(sumTerminal);
			var $td9 = $("<td></td>");
			$td9.html(sumManual);
			$tr1.append($td8);
			$tr1.append($td9);
			$("#tb1").append($tr1);
			
			//图表
			var myChart = echarts.init(document.getElementById('main'),'shine');
			option = {
				legend: {},
				tooltip: {},
				dataset: {
					source: [
						['缴费机', '临时用户收入', '月缴用户收入'],
						['1月数据', 43.3, 85.8],
						['2月数据', 83.1, 73.4],
						['3月数据', sumTerminal, sumManual],
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
			alert("请联系管理员...");
		}
	});
}
init();
//页码监听
$('#myPager').on('onPageChange', function (e, state, oldState) {
	if (state.page !== oldState.page) {
		console.log('页码从', oldState.page, '变更为', state.page);
		//tempData.CurrentPage = state.page;
		currPage = state.page;
		init();
	}
});

</script>
</html>