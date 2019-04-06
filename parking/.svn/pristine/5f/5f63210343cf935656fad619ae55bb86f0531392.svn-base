<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/adminRole.css">
<link rel="stylesheet"
	href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
<style type="text/css">
.panel {
	border: 0;
	-webkit-box-shadow: 0 0 0 rgba(255, 255, 255, 0);
}
</style>
</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">车辆入场查询</div>

		<div class="panel-body container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">车牌</span> <input type="text"
							id="name" class="form-control">
					</div>
				</div>
				<div class="col-xs-12 col-md-4 scan ">
					<button class="btn btn-primary" id="selectBtn" type="button">搜索</button>
				</div>
			</div>
			<br />
			<table class="table table-bordered  table-hover" id="tb">
				<thead>
					<tr>
						<th style="text-align: center">序号</th>
						<th style="text-align: center">车牌</th>
						<th style="text-align: center">角色</th>
						<th style="text-align: center">入场时间</th>
						<th style="text-align: center">出场时间</th>
					</tr>
				</thead>
				<tbody id="tbody">

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
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
<script type="text/javascript"
	src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script type="text/javascript" src="js/myjs.js"></script>
<script type="text/javascript" src="js/carIn.js"></script>

</html>

