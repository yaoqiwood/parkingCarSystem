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
		<link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
		<style type="text/css">
			.panel {
				border: 0;
				-webkit-box-shadow: 0 0 0 rgba(255, 255, 255, 0);
			}
		</style>
	</head>

	<body>
		<div class="col-xs-12 no-padding panel panel-primary ">
			<div class="panel-heading center">车位查询</div>

			<div class="panel-body container-fluid">
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-3 scan">
						<div class="input-group">
							<span class="input-group-addon">车位</span> <input type="text" id="name" class="form-control">
						</div>
					</div>
					
					<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">区域</span> <select id="place"
							class="form-control scan-text">
							<option value="">请选择</option>
							<option >A区</option>
							<option >B区</option>
							<option >C区</option>
						</select>
						</div>
					</div>
					
					<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">楼层</span> <select id="floor"
							class="form-control scan-text">
							<option value="">请选择</option>
							<option >1楼</option>
							<option >2楼</option>
							<option >3楼</option>
						</select>
						</div>
					</div>
					
					<div class="col-xs-12 col-md-3 scan ">
						<button class="btn btn-info" id="addBtn" type="button">添加</button>
						<button class="btn btn-primary" id="selectBtn" type="button">搜索</button>
					</div>
				</div>
				<br />
				<table class="table table-bordered  table-hover" id="tb">
					<thead>
						<tr>
							<th style="text-align: center">序号</th>
							<th style="text-align: center">区域</th>
							<th style="text-align: center">车位</th>
							<th style="text-align: center">楼层</th>
							<th style="text-align: center">操作</th>
						</tr>
					</thead>
					<tbody id="tbody">

					</tbody>
				</table>
				<div class="floatRight">
					<ul id="myPager" class="pager" data-ride="pager" data-elements="prev_icon,page_of_total_text,next_icon">
						<li class="pager-item-left pager-item-right">
							<a id="lastPageBtn" class="pager-item" data-page="0"><i class="icon icon-double-angle-left"></i></a>
						</li>
						<li>
							<div class="pager-label">
								第 <strong id="CurPageView">1</strong>/<strong id="TotalPageView">1</strong> 页
							</div>
						</li>
						<li class="pager-item-left">
							<a id="nextPageBtn" class="pager-item" data-page="1"><i class="icon icon-double-angle-right"></i></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- 添加用户模块 -->
		<div class="backWhite" id="adddialog">
			<div class="panelBox" >
				<div class="panel panel-primary">
				<div class="panel-heading">添加</div>
					<div class="panel-body input-group">
						<span class="input-group-addon">车位</span> <input type="text" class="form-control" id="addname" />
					</div>
					<div class="panel-body input-group">
						<span class="input-group-addon">区域</span> 
						<select id="addplace" class="form-control scan-text">
							<option value="">请选择</option>
							<option >A区</option>
							<option >B区</option>
							<option >C区</option>
						</select>
					</div>
					<div class="panel-body input-group">
						<span class="input-group-addon">楼层</span> 
						<select id="addfloor" class="form-control scan-text">
							<option value="">请选择</option>
							<option >1楼</option>
							<option >2楼</option>
							<option >3楼</option>
						</select>
					</div>
				<div class="center bottomSpace">
					<button class="btn btn-primary" type="button" id="addcommit">确定</button>
					<button class="btn btn-info" type="button" id="addcancel">取消</button>
				</div>
				</div>
			</div>
		</div>
		
		<!-- 修改用户模块 -->
		<div class="backWhite" id="updatedialog">
			<div class="panelBox">
				<div class="panel panel-primary">
					<div class="panel-heading">修改</div>
					<div class="panel-body input-group">
						<span class="input-group-addon">车位</span> <input type="text" class="form-control" readonly="readonly" id="dname" />
					</div>
					<div class="panel-body input-group">
						<span class="input-group-addon">区域</span> 
						<select id="dplace" class="form-control scan-text">
							<option value="">请选择</option>
							<option >A区</option>
							<option >B区</option>
							<option >C区</option>
						</select>
					</div>
					<div class="panel-body input-group">
						<span class="input-group-addon">楼层</span> 
						<select id="dfloor" class="form-control scan-text">
							<option value="">请选择</option>
							<option >1楼</option>
							<option >2楼</option>
							<option >3楼</option>
						</select>
					</div>
					<input type="hidden" id="did"/>
					<div class="center bottomSpace">
						<button class="btn btn-primary" type="button" id="commit">确定</button>
						<button class="btn btn-info" type="button" id="cancel">取消</button>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
	<script type="text/javascript" src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
	<script type="text/javascript" src="js/myjs.js"></script>
	<script type="text/javascript" src="js/carPlace.js"></script>

</html>
    