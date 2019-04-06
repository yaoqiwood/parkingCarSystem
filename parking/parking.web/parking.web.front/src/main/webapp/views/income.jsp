<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>收入统计</title>
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

.row {
	position: relative;
	left: 25%;
}
</style>

</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">收入统计</div>

		<div class="panel-body container-fluid">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-warning">
						<div class="info-box-icon">
							<i class="icon icon-align-left"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">停车场总收入</span> <span
								class="info-box-number" id="sumAmount" >8 <small>个</small>
							</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-primary">
						<div class="info-box-icon">
							<i class="icon icon-circle-arrow-up"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">总停车数</span> <span
								class="info-box-number" id="countAmount">90 <small>个</small>
							</span>
						</div>
					</div>
				</div>
				
			</div>

			<table class="table table-bordered  table-hover" id="tb">
				<thead>
					<tr>
						<th style="text-align: center">序号</th>
						<th style="text-align: center">车牌号</th>
						<th style="text-align: center">消费</th>
						<th style="text-align: center">操作记录</th>
						<th style="text-align: center">操作时间</th>
					</tr>
				</thead>
				<tbody id="tbody">
					<tr class="tr">
						<td>1</td>
						<td>京A22222</td>
						<td>10</td>
						<td>1小时</td>
						<td>2019-01-22</td>
					</tr>

				</tbody>
			</table>
			<div class="floatRight">
				<ul id="myPager" class="pager" data-ride="pager"
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

</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/table_funs.js"></script>
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
	//初始化分页器
	$('#myPager').pager({
		page : currPage,
		recTotal : count,
		recPerPage : limit,
	});
	//初始化
	function init() {
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
				console.log(data);
				//首先清空
				var arr = $(".tr");
				for (var i = arr.length - 1; i >= 0; i--) {
					$(arr[i]).remove();
				}
				/* var arr1 = $(".tr1");
				for (var i = arr1.length - 1; i >= 0; i--) {
					$(arr1[i]).remove();
				} */
				//tb1
				var sumAmount = data.sumAmount;
				var countAmount = data.countAmount;
				var $sumAmount = $("#sumAmount");
				var $countAmount = $("#countAmount");
				$sumAmount.html(sumAmount);
				$countAmount.html(countAmount);
				/* var $tb1 = $("#tb1");
				var $tr1 = $("<tr class='tr' align='center'></tr>");
				var $td8 = $("<td></td>");
				$td8.html(sumAmount);
				var $td9 = $("<td></td>");
				$td9.html(countAmount);
				$tr1.append($td8);
				$tr1.append($td9);
				$("#tb1").append($tr1); */
				//tb
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
					$td5.html(formatUnixtimestamp(new Date(
							incomeList[i].amountLogDescCreateTime)));
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$("#tb").append($tr);
				}
				//显示page
				count = c;
				$('#myPager').data('zui.pager').set(currPage, count, limit);
				if (incomeList.length == 0) {
					alert("暂无数据");
				}
			},
			error : function(msg) {
				alert("请联系管理员...");
			}
		});
	}
	//初始化
	init();
	//页码监听
	$('#myPager').on('onPageChange', function(e, state, oldState) {
		if (state.page !== oldState.page) {
			console.log('页码从', oldState.page, '变更为', state.page);
			//tempData.CurrentPage = state.page;
			currPage = state.page;
			init();
		}
	});
</script>
</html>