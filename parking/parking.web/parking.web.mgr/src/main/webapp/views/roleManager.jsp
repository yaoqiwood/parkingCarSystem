<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="3rd/layer/theme/default/layer.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/roleManager.css">
<link rel="stylesheet" href="css/newcss.css">
<title>roleManager</title>
</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary container-fluid">
		<div class="panel-heading center"><i class="icon-user"></i>&nbsp;角色管理</div>

		<div class="panel-body container-fluid ">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-4 scan">
					<div class="input-group">
						<span class="input-group-addon">角色名</span> <input type="text"
							id="roleName" class="form-control" >
					</div>
				</div>
				<div class="col-xs-12 col-sm-8 col-md-4 scan">
					<div class="input-group">
						<span class="input-group-addon">状态</span> <select id="roleState"
							class="form-control scan-text">
							<option value="">请选择</option>
							<option value="1">启用</option>
							<option value="0">禁用</option>
						</select>
					</div>
				</div>
				<div class="col-xs-6 col-sm-2 col-md-2 scan">
					<button class="btn btn-info" id="addBtn" type="button">增加</button>
				</div>
				<div class="col-xs-6 col-sm-2 col-md-2 scan">
					<button class="btn btn-primary " id="Search_Btn" type="button">搜索</button>
				</div>
			</div>

			<table class="table table-bordered  table-hover" id="table">
				<thead>
					<tr>
						<th style="text-align: center">角色ID</th>
						<th style="text-align: center">角色名</th>
						<th style="text-align: center">角色状态</th>
						<th style="text-align: center">角色创建时间</th>
						<th style="text-align: center">操作</th>
					</tr>
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
					<li class="pager-item-left"><a id="nextPageBtn" class="pager-item" data-page="1"><i
							class="icon icon-double-angle-right"></i></a></li>
				</ul>
			</div>
		</div>
	</div>



	<div class="backWhite" id="addPanelBox">
		<div class="panelBox">
			<div class="panel panel-primary">
				<div class="panel-heading">添加角色</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">角色名</span> <input type="text"
						class="form-control" id="addRoleName" >
				</div>
				<div class="center bottomSpace">
					<button class="btn btn-primary" type="button" id="btnConfirm">确定</button>
					<button class="btn btn-info" type="button" id="btnCancel">取消</button>
				</div>
			</div>
		</div>
	</div>

	<div class="backWhite" id="updatedialog" >
		<div class="panelBox">
			<div class="panel panel-primary">
				<div class="panel-heading">修改角色</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">角色ID</span> <input type="text"
						disabled class="form-control" id="upRoleId" placeholder="角色ID">
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">角色名</span> <input type="text"
						class="form-control" id="upRoleName" >
				</div>
				<div class="center bottomSpace">
					<button class="btn btn-primary" type="button" id="upBtnConfirm">确定</button>
					<button class="btn btn-info" type="button" id="upBtnCancel">取消</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="backWhite" id="configdialog" >
		<div class="panelBox">
			<div class="panel panel-primary">
				<div class="panel-heading">修改角色</div>
				<div class="panel-body input-group">
					<div class="xiugai">
						<div class="search">
							<input id="updateName" type="text" class="rolescan search-input" readonly="readonly"/>
							<input id="updateId" type="hidden" />
							<button id="repeatRoleMenu" class="btn btn-block search-input" type="button">重新加载</button>
							<button id="commitRoleMenu" class="btn btn-block search-input" type="button">确认修改</button>
							<button id="clearRoleMenu" class="btn btn-block search-input" type="button">清空</button>
							<button id="checkRoleMenu" class="btn btn-block search-input" type="button">全选</button>
							<button id="cannelRoleMenu" class="btn btn-block search-input" type="button">返回</button>
						</div>
			
						<div class="panel">
							<div class="configtree">
								<ul class="tree" data-ride="tree">
									
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/common.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/roleManager.js"></script>
</html>