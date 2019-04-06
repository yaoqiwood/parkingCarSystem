<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>月缴用户产品包统计</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
<link rel="stylesheet" href="css/incomeProduct.css">
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

/* .pager-label {
	line-height: 15px;
} */

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
		<div class="panel-heading center">月缴用户产品包统计</div>

		<div class="panel-body container-fluid">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-primary ">
						<div class="info-box-icon">
							<i class="icon icon-moon"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">包月产品收入</span> <span
								class="info-box-number" id="monthProduct">320 <small>篇</small>
							</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-warning">
						<div class="info-box-icon">
							<i class="icon icon-leaf"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">季度产品收入</span> <span
								class="info-box-number" id="seasonProduct">90 <small>个</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-info ">
						<div class="info-box-icon">
							<i class="icon icon-cloud"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">半年产品收入</span> <span
								class="info-box-number" id="halfyearProduct">8 <small>个</small>
							</span>
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-danger">
						<div class="info-box-icon">
							<i class="icon icon-line-chart"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">年度产品收入</span> <span
								class="info-box-number" id="yearProduct">18953 <small>次</small>
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
			<table class="table table-bordered  table-hover" id="tb">
				<thead>
					<tr>
						<th style="text-align: center">序号</th>
						<th style="text-align: center">车牌号</th>
						<th style="text-align: center">产品名</th>
						<th style="text-align: center">产品月数</th>
						<th style="text-align: center">产品价格</th>
						<th style="text-align: center">购买时间</th>
					</tr>
				</thead>
				<tbody id="tbody">
					<tr class="tr">
						<td>1</td>
						<td>京A22222</td>
						<td>月度产品</td>
						<td>1</td>
						<td>300</td>
						<td>2019-01-22</td>
					</tr>
					<tr class="tr">
						<td>2</td>
						<td>京A33333</td>
						<td>季度产品</td>
						<td>3</td>
						<td>600</td>
						<td>2019-01-23</td>
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

</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/echarts.common.min.js"></script>
<script src="js/shine.js"></script>
<script src="js/incomeProduct.js"></script>
<script>


</script>
</html>