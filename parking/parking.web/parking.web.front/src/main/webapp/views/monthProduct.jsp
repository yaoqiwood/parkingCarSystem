<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="3rd/layer/theme/default/layer.css">
<link rel="stylesheet" href="css/monthProduct.css">
<link rel="stylesheet" href="css/noBorder.css">
<link rel="stylesheet"
	href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
<title>月缴产品管理</title>
</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary container-fluid">
		<div class="panel-heading center">月缴产品管理</div>

		<div class="panel-body container-fluid ">
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">产品名</span> <input type="text"
							id="proName" class="form-control">
					</div>
					<br>
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon">日期选择</span> <input type="text"
							id="startTime" class="form-control form-date"> <span
							class="input-group-addon">至</span> <input type="text"
							id="endTime" class="form-control form-date">
					</div>
					<br>
				</div>
				<div class="center">
					<button class="btn btn-info rightBigSpace" id="addBtn"
						type="button">增加</button>
					<button class="btn btn-primary " id="selectBtn" type="button">搜索</button>
				</div>
				<br>
			</div>

			<table class="table table-bordered  table-hover" id="table">
				<thead>
					<tr>
						<th style="text-align: center">序号</th>
						<th style="text-align: center">产品名</th>
						<th style="text-align: center">创建时间</th>
						<th style="text-align: center">配置月份</th>
						<th style="text-align: center">收费标准</th>
						<th style="text-align: center">产品状态</th>
						<th style="text-align: center">操作</th>
					</tr>
				</thead>
				<tbody align="center">
					<tr class="tr">
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

		<div class="addPanelBox" id="adddialog">
			<div class="panel panel-primary">
				<div class="panel-heading">添加产品</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">产品名</span> <input type="text"
						class="form-control" id="addName">
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">配置月份</span> <input type="text"
						class="form-control" id="addmonth">
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">收费标准</span> <input type="text"
						class="form-control" id="addMoney" >
				</div>
				<div class="center bottomSpace">
					<button class="btn btn-primary" type="button" id="addcommit">确定</button>
					<button class="btn btn-info" type="button" id="addcancel">取消</button>
				</div>
			</div>
		</div>

		<div class="updatePanelBox" id="dialog">
			<div class="panel panel-primary">
				<div class="panel-heading">
					修改产品<input id="did" type="hidden" />
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">产品名</span> <input type="text"
						id="modName" class="form-control" >
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">月份:</span> <input type="text"
						id="modMonth" class="form-control" >
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">收费标准</span> <input type="text"
						class="form-control" id="modMoney" >
				</div>
				<div class="center bottomSpace">
					<button class="btn btn-primary" type="button" id="commit">确定</button>
					<button class="btn btn-info" type="button" id="cancel">取消</button>
				</div>
			</div>
		</div>
		<div class="backWhite" id="backWhite"></div>
</body>
<script src="3rd/zui/js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/monthProduct.js"></script>

</html>