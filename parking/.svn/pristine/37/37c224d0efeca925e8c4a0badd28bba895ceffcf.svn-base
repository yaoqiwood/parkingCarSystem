<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>收支明细</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
<link rel="stylesheet" href="css/amountLog.css">

</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">
			<i class="icon-dollar"></i>&nbsp;收支明细
		</div>

		<div class="panel-body container-fluid">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-primary ">
						<div class="info-box-icon">
							<i class="icon icon-yen"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">总收入</span> <span
								class="info-box-number" id="sumAmount">320 <small>元</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-warning">
						<div class="info-box-icon">
							<i class="icon icon-circle-arrow-down"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">总停车数</span> <span
								class="info-box-number" id="countAmount">90 <small>次</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-info ">
						<div class="info-box-icon">
							<i class="icon icon-user"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">临时用户收入</span> <span
								class="info-box-number" id="sumCasual">8 <small>元</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-danger">
						<div class="info-box-icon">
							<i class="icon icon-group"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">月缴用户收入</span> <span
								class="info-box-number" id="sumMonth">18 <small>元</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-success">
						<div class="info-box-icon">
							<i class="icon icon-moon"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">包月产品收入</span> <span
								class="info-box-number" id="monthProduct">18 <small>元</small>
							</span>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6 col-xs-12">
					<div class="info-box bg-black">
						<div class="info-box-icon">
							<i class="icon icon-desktop"></i>
						</div>
						<div class="info-box-content">
							<span class="info-box-text">季度产品收入</span> <span
								class="info-box-number" id="seasonProduct">53 <small>元</small>
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
							<span class="info-box-text">半年产品收入</span> <span
								class="info-box-number" id="halfyearProduct">385 <small>元</small>
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
							<span class="info-box-text">年度产品收入</span> <span
								class="info-box-number" id="yearProduct">550 <small>元</small>
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
			<i class="icon icon-paste"></i>&nbsp;总收入分析
		</div>
		<div class="panel-body container-fluid">

			<div class="col-md-6  col-xs-12">
				<div id="main1" style="width: 600px; height: 400px;"></div>
			</div>

			<div class="col-md-6  col-xs-12">
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
					<ul id="myPager1" class="pager" data-ride="pager"
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
			<i class="icon icon-sitemap"></i>&nbsp;用户分析
		</div>
		<div class="panel-body container-fluid">
			<div class="col-md-6  col-xs-12">
				<div id="main2" style="width: 600px; height: 400px;"></div>
			</div>

			<div class="col-md-6  col-xs-12">
				<table class="table table-bordered  table-hover" id="tb2">
					<thead>
						<tr>
							<th style="text-align: center">序号</th>
							<th style="text-align: center">用户类型</th>
							<th style="text-align: center">车牌号</th>
							<th style="text-align: center">消费</th>
							<th style="text-align: center">操作记录</th>
							<th style="text-align: center">操作时间</th>
						</tr>
					</thead>

					<tbody id="tbody">
						<tr class="tr2">
							<td>1</td>
							<td>临时用户</td>
							<td>京A22222</td>
							<td>10</td>
							<td>1小时</td>
							<td>2019-01-22</td>
						</tr>
					</tbody>
				</table>

				<div class="floatRight">
					<ul id="myPager2" class="pager" data-ride="pager"
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
			<i class="icon icon-list-ol"></i>&nbsp;产品分析
		</div>
		<div class="panel-body container-fluid">

			<div class="col-md-6  col-xs-12">
				<div id="main3" style="width: 600px; height: 400px;"></div>
			</div>
			<div class="col-md-6  col-xs-12">
				<table class="table table-bordered  table-hover" id="tb3">
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
						<tr class="tr3">
							<td>1</td>
							<td>京A22222</td>
							<td>月度产品</td>
							<td>1</td>
							<td>300</td>
							<td>2019-01-22</td>
						</tr>

					</tbody>
				</table>
				<div class="floatRight">
					<ul id="myPager3" class="pager" data-ride="pager"
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
<script src="js/table_funs.js"></script>
<script src="js/echarts.common.min.js"></script>
<script src="3rd/ECharts/js/westeros.js"></script>
<script src="js/shine.js"></script>
<script src="js/amountLog.js"></script>
</html>