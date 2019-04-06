<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>停车场后台管理系统</title>
<!-- zui css -->
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<!-- app css -->
<link rel="stylesheet" href="css/frameApp-mgr.css">
<link rel="stylesheet" href="css/login.css">
	<style>
			#image {
				position: relative;
				max-width: 100%;
			}
	</style>
</head>
<body class="bg-primary">
<br>
	<div class="page page-login text-center">
		<div class="panel">
			<div class="panel-body "   >
				<div class="logo">
					<a href="#">管理员登录</a>
				</div>
				<form action="#">
					<div class="form-group">
						<input id="name" type="text" class="form-control" placeholder="ID/帐号">
					</div>
					<div class="form-group">
						<input id="password" type="password" class="form-control " placeholder="密码">
					</div>
					<div class="form-group">
						<input style="display:inline-block;" id="code" class="form-control lookimage" placeholder="验证码" id="imageCode"  autocomplete="off" />
						<div id="image" class="popover bottom  lookimage">
							<div class="arrow  lookimage"></div>
							<h3 class="popover-title lookimage">验证码</h3>
							<div class="popover-content lookimage">
								<img id="vercode" class="lookimage"  src="code.jpg" title="点击刷新" />
							</div>
						</div>
					</div>
					<button id="login" type="button" class="btn btn-lg btn-primary btn-block">登录</button>
				</form>
			</div>
		</div>
		<footer class="page-copyright page-copyright-inverse">
			<p>WEBSITE BY BEETLE</p>
			<p>© 2019. All RIGHT RESERVED.</p>
		</footer>
	</div>
	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>

	<!-- zui js -->
	<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
	<!-- app js -->
	<script type="text/javascript" src="js/app.js"></script>
	<script type="text/javascript" src="js/rsa.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<script src="js/table_funs.js"></script>
</body>
</html>