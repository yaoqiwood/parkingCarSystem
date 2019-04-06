<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>缴费信息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
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
			z-index: 3;
			;
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
		/* roleAdminCss */
	</style>

</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">缴费信息</div>

		<div class="panel-body container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">demo</span> <input type="text" id="name" class="form-control">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">demo</span> <select id="role" class="form-control scan-text">
							<option value="">请选择</option>
						</select>
					</div>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-6 scan">
					<div class="input-group">
						<span class="input-group-addon">demo时间</span>
						<input id="startTime" type="text" class="form-control form-date" />
						<span class="input-group-addon">至</span>
						<input id="endtime" type="text" class="form-control form-date" />
					</div>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-4 scan">
					<div class="input-group">
						<span class="input-group-addon">状态demo</span> <select id="state" class="form-control scan-text">
							<option value="">请选择</option>
							<option value="1">启用</option>
							<option value="0">禁用</option>
						</select>
					</div>
				</div>
				<div class="col-xs-12 col-md-4 scan ">
					<button class="btn btn-info" id="addBtn" type="button">增加</button>
					<button class="btn btn-primary" id="selectBtn" type="button">搜索</button>
				</div>
			</div>

			<table class="table table-bordered  table-hover" id="tb">
				<thead>
					<tr>
						<th style="text-align: center">demo</th>
						<th style="text-align: center">demo</th>
						<th style="text-align: center">demo</th>
						<th style="text-align: center">demo</th>
						<th style="text-align: center">demo</th>
						<th style="text-align: center">demo</th>
						<th style="text-align: center">demo</th>
					</tr>
					</tr>
				</thead>
				<tbody id="tbody">
					<tr class="tr">
						<td>2</td>
						<td>lisi</td>
						<td>undefined</td>
						<td>123</td>
						<td>2019-02-27 09:42:44</td>
						<td>启用</td>
						<td><button adminid="2" class="btn btn-sm btn-info" type="button"><i
									class="icon icon-cog"></i>&nbsp;修改</button><button adminid="2"
								class="btn btn-sm btn-danger" type="button"><i
									class="icon icon-trash"></i>&nbsp;删除</button><button adminid="2"
								class="btn btn-sm btn-warning" type="button"><i
									class="icon icon-remove-circle"></i>&nbsp;禁用</button><button adminid="2"
								class="btn btn-sm btn-primary" type="button"><i
									class="icon icon-repeat"></i>&nbsp;重置密码</button><button adminid="2"
								class="btn btn-sm btn-danger" type="button"><i
									class="icon icon-times"></i>&nbsp;注销</button></td>
					</tr>

				</tbody>
			</table>
			<div class="floatRight">
				<ul id="myPager" class="pager" data-ride="pager" data-elements="prev_icon,page_of_total_text,next_icon">
					<li class="pager-item-left pager-item-right"><a id="lastPageBtn" class="pager-item" data-page="0"><i
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

	<!-- 添加demo模块 -->
	<div class="backWhite" id="adddialog">
		<div class="panelBox">
			<div class="panel panel-primary">
				<div class="panel-heading">demo</div>
				<div class="panel-body input-group">
					<span class="input-group-addon"> demo</span> <input type="text" class="form-control" id="addname" />
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">demo </span> <input type="text" class="form-control"
						id="addpassword" />
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">demo</span> <input type="text" class="form-control"
						id="addpasswordagain" />
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon"> demo</span>
					<select id="addRole" class="form-control scan-text">
						<option value="">demo</option>
					</select>
				</div>
				<div class="center bottomSpace">
					<button class="btn btn-primary" type="button" id="addcommit">确定</button>
					<button class="btn btn-info" type="button" id="addcancel">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 修改demo模块 -->
	<div class="backWhite" id="updatedialog">
		<div class="panelBox">
			<div class="panel panel-primary">
				<div class="panel-heading">demo</div>
				<div class="panel-body input-group">
					<span class="input-group-addon"> demo</span> <input type="text" class="form-control"
						id="updatename" />
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">demo </span> <input type="text" class="form-control"
						id="updatepassword" />
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon">demo</span> <input type="text" class="form-control"
						id="updatepasswordagain" />
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon"> demo</span>
					<select id="updateRole" class="form-control scan-text">
						<option value="-1">demo</option>
					</select>
				</div>
				<div class="panel-body input-group">
					<span class="input-group-addon"> demo</span>
					<select id="updateState" class="form-control scan-text">
						<option value="-1">demo</option>
						<option value="1">demo</option>
						<option value="0">demo</option>
					</select>
				</div>
				<input type="hidden" id="updateid" />
				<div class="center bottomSpace">
					<button class="btn btn-primary" type="button" id="updateCommit">确定</button>
					<button class="btn btn-info" type="button" id="updateCanel">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="3rd/ZUI/js/zui.min.js"></script>
<script type="text/javascript" src="3rd/ZUI/lib/datetimepicker/datetimepicker.min.js"></script>
<!-- <script type="text/javascript" src="js/myjs.js"></script> -->
<!-- <script type="text/javascript" src="js/adminRole.js"></script> -->

</html>