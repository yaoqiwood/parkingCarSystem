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
		<link rel="stylesheet" href="css/monthProduct.css">
		<link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
		<title>自动日结算</title>
	</head>

	<body>
		<div class="col-xs-12 no-padding panel panel-primary container-fluid">
			<div class="panel-heading center">
				自动日结算
			</div>

			<div class="panel-body container-fluid ">
				<div class="row">
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon">日期选择</span>
							<input type="text" id="startTime" class="form-control form-date" placeholder="选择或者输入一个日期：yyyy-MM-dd">
							<span class="input-group-addon">至</span>
							<input type="text" id="endTime" class="form-control form-date" placeholder="选择或者输入一个日期：yyyy-MM-dd">
						</div>
						<br>
					</div>
					<div class="left">
						<button id="selBtn" class="btn btn-primary rightBigSpace" type="button">搜索</button>
						<button id="showAll" class="btn btn-danger " type="button">全部显示</button>
					</div>
					<br>
				</div>

				<table class="table table-bordered  table-hover" id="table">
					<thead>
						<tr>
							<th style="text-align:center">序号</th>
							<th style="text-align:center">结算日期</th>
							<th style="text-align:center">结算金额</th>
							<th style="text-align:center">结算时间</th>
						</tr>
						</tr>
					</thead>
					<tbody align="center">
						<tr class="tr"></tr>
					</tbody>
				</table>
				<div class="floatRight">
					<ul id="myPager" class="pager" data-ride="pager" data-elements="prev_icon,page_of_total_text,next_icon">
						<li class="pager-item-left pager-item-right">
							<a id="lastPageBtn" class="pager-item" data-page="0"><i class="icon icon-double-angle-left"></i></a>
						</li>
						<li>
							<div class="pager-label">第 <strong id="CurPageView">1</strong>/<strong id="TotalPageView">1</strong> 页
							</div>
						</li>
						<li class="pager-item-left">
							<a id="nextPageBtn" class="pager-item" data-page="1"><i class="icon icon-double-angle-right"></i></a>
						</li>
					</ul>
				</div>
			</div>
	</body>
	<script src="3rd/zui/js/jquery-2.2.4.min.js"></script>
	<script src="3rd/zui/js/zui.min.js"></script>
	<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
	<script src="js/table_funs.js"></script>
	<script src="js/dayCount.js"></script>
</html>