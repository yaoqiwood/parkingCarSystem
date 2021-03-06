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
<link rel="stylesheet" href="css/amechineLog.css">
<link rel="stylesheet" href="css/amountLog.css">

</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">
			<i class="icon icon-copy"></i>&nbsp;渠道明细
		</div>

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
	</div>
	<!-- <div class="panel panel-primary">
			<div class="panel-heading">
				<h4 class="panel-title">
					<i class="icon icon-bar-chart"></i> 访问URL总计分析 <a
						class="btn btn-link _f-right"> <i class="icon icon-refresh" ></i> 刷新</a>
				</h4>
			</div>
		</div> -->
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">
			<i class="icon icon-laptop"></i>&nbsp;自助终端分析
		</div>
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
	</div>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">
			<i class="icon icon-shopping-cart"></i>&nbsp;人工缴费分析
		</div>

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
	</div>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">
			<i class="icon icon-shopping-cart"></i>&nbsp;缴费渠道分析
		</div>
		<div class="panel-body container-fluid">
			<div class="col-md-6  col-xs-12">
				<div id="main6" style="width: 600px; height: 400px;"></div>
			</div>
			<div class="col-md-6  col-xs-12">
				<table class="table table-bordered  table-hover" id="tb6">
					<thead>
						<tr>
							<!-- <th style="text-align: center">自助终端收费</th>
							<th style="text-align: center">收费人员收费</th> -->
							<th style="text-align: center">分类统计</th>
							<th style="text-align: center">统计金额</th>
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
<script src="3rd/ECharts/js/westeros.js"></script>
<script src="js/shine.js"></script>
<script src="js/amechineLog.js"></script>
</html>