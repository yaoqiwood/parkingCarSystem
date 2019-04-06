<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="3rd/zui/css/zui.min.css" />
		<link rel="stylesheet" href="3rd/zui/css/zui-theme.min.css" />
		<style type="text/css">
			.dialog{
					width:330px;
					height:250px;
					background-color:white;
					border: 1px solid #0284E6;
					position: absolute;
					top:100px;
					left: 400px;
					display: block;
				}
				.title{
					width: 100%;
					height: 50px;
					text-align: center;
					padding-top: 20px;
					background-color: #3F51B5;
					color: white;
				}
				.font{
					color: #888888;
				}
				.field{
					width: 130px;
					height: 25px;
				}
				.field1{
					width: 130px;
					height: 30px;
				}
				.btn{
					width: 100px;
					height: 30px;
				}
		</style>
	</head>
	<body>
		<div id="dialog" class="dialog">
			<div class="title">修改密码</div>
			<div class="content">
				<br />
			<table align="center" id="tb">
					<tr>
						<td><span class="font">旧密码：</span></td>
						<td><input id="oldpwd" class="field" type="text" /></td>
					</tr>
					<tr>
						<td><span class="font">新密码：</span></td>
						<td><input id="newpwd" class="field" type="text" /></td>
					</tr>
					<tr>
						<td><span class="font">确认密码：</span></td>
						<td><input id="surepwd" class="field" type="text" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input id="commit" class="btn" type="button" value="提交" />
							<input id="cancel" class="btn" type="button" value="返回" />
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
	<script type="text/javascript" src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
	<script type="text/javascript" src="js/updatePwd.js"></script>
</html>
    