<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="3rd/layer/theme/default/layer.css">
<link rel="stylesheet" href="css/dailyAccount.css">
<link rel="stylesheet" href="css/newcss.css">
<title>收费日结算</title>
</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary container-fluid">
		<div class="panel-heading center">
			<i class="icon-pie-chart"></i>&nbsp;收费日结算
		</div>

		<div class="panel-body container-fluid ">
			<div class="col-md-6 ">
				<div id="main" style="width: 650px; height: 330px;"></div>
			</div>

			<div class="col-md-6 no-padding">
				<div class="scan">
					<button class="btn btn-block btn-info" id="morningAccountBtn" type="button">早班统计</button>
				</div>
				<div class=" scan">
					<button class="btn btn-block btn-warning" id="middleAccountBtn" type="button">中班统计</button>
				</div>
				<div class=" scan">
					<button class="btn btn-block btn-danger" id="eveningAccountBtn" type="button">晚班统计</button>
				</div>
				<div class="scan">
					<button class="btn btn-block btn-primary" id="initBtn" type="button">全部统计</button>
				</div>
				<table class="table table-bordered  table-hover" id="table">
					<thead>
						<tr>
							<th style="text-align: center">序号</th>
							<th style="text-align: center">结算班次</th>
							<th style="text-align: center">结算日期</th>
							<th style="text-align: center">结算金额</th>
							<th style="text-align: center">结算时间</th>
						</tr>
					</thead>
					<tbody align="center">
						<tr class="tr"></tr>
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
	</div>

	<div class="col-xs-12 no-padding panel panel-primary container-fluid">
			<div class="panel-heading center">
				<i class="icon-pie-chart"></i>&nbsp;自动日结算
			</div>

			<div class="panel-body container-fluid ">
				<div class="col-md-6" >
					<div id="lineChart" style="width: 650px; height: 330px;"></div>
				</div>
				<div class="col-md-6 no-padding">
					<div class="searchtime">
						<div class="input-group" >
							<span class="input-group-addon">日期选择</span> 
							<input type="text" id="startTime" class="form-control form-date"/> 
							<span class="input-group-addon">至</span> 
							<input type="text" id="endTime" class="form-control form-date"/>
						</div>
					</div>
				 
					<div class="scan">
						<button id="selBtn" class="btn btn-block btn-primary" type="button">搜索</button>
					</div>
					<div class="scan">
						<button id="showAll" class="btn btn-block btn-danger" type="button">刷新</button>
					</div>

					<table class="table table-bordered  table-hover" id="dayTable">
						<thead>
							<tr>
								<th style="text-align: center">序号</th>
								<th style="text-align: center">结算日期</th>
								<th style="text-align: center">结算金额</th>
								<th style="text-align: center">结算时间</th>
							</tr>
							</tr>
						</thead>
						<tbody align="center">
							<tr class="dayTr"></tr>
						</tbody>
					</table>
					<div class="floatRight">
						<ul id="daymyPager" class="pager" data-ride="pager"
							data-elements="prev_icon,page_of_total_text,next_icon">
							<li class="pager-item-left pager-item-right"><a
								id="lastPageBtn" class="pager-item" data-page="0"><i
									class="icon icon-double-angle-left"></i></a></li>
							<li>
								<div class="pager-label">
									第 <strong id="CurPageView">1</strong>/<strong
										id="TotalPageView">1</strong> 页
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
</body>
<script src="3rd/zui/js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/table_funs.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="3rd/ECharts/js/echarts.js"></script>
<script src="3rd/ECharts/js/westeros.js"></script>
<script src="js/dailyAccount.js"></script>
</html>