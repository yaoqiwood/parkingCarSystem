<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
	<title>缴费信息</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="css/global.css">
	<!-- <link rel="stylesheet" href="css/main.css"> -->
	<link rel="stylesheet" href="3rd/assets/css/main.css" />
	<!-- <link rel="stylesheet" href="css/selfPayment.css"> -->
	<link rel="stylesheet" href="3rd/CarNumPlugin/css/CarNumPlugin.css">
	<style type="text/css">
		.iframe {
			/* border:2px solid black; */
			position: relative;
			/* left: 25%; */
			width: 300px;
			height: 300px;
			margin-top: 100px;
			margin-left: 100px;
		}

		.iframe_in {
			width: 935px;
			margin: 0 auto;
			padding-top: 12px;
		}

		.carnum-plugin {
			margin-top: 100px;
			margin-left: 100px;
			height: 330px;
		}

		.btn-center {
			text-align: center;
		}

		.text-heading {
			text-align: center;
		}

		body {
			/* background-color: #f3f3f3; */
		}

		.table_btn {
			height: 175px;
		}

		.right-btn-box {
			margin-top: 168px;
			margin-left: 100px;
		}


		.field {
			padding-right: 18px;
			padding-left: 18px;
			margin-top: 10px;
		}

		.btn_Click {
			width: 186px;
			/* position: relative; */
			/* left: 60%; */
			margin-top: 20px;
		}

		.btn_group {
			text-align: center;
		}


		.col-black {
			color: black;
		}

		#main {
			height: 500px;
		}

		body .layui-layer-setmybg .layui-layer-content {
			background-color: #2A2F4A;
			color: #fff;
		}

		.back {
			/* float: left; */
			margin-left: 18px;
		}
	</style>
</head>

<body>
	<div id="body">
		<!-- Wrapper -->
		<div id="wrapper">

			<!-- Header -->
			<!-- Note: The "styleN" class below should match that of the banner element. -->
			<header id="header" class="alt style2">
				<a href="index.html" class="logo"><strong>智能停车系统</strong> <span></span></a>
			</header>

			<!-- Main -->
			<div id="main">
				<div class="iframe_in flex_col flex_col_2 flex_wrap">
					<div class="field half first">
						<label for="name">序号：</label>
						<input type="text" name="carId" id="carId" disabled="disabled">
					</div>
					<div class="field half">
						<label for="email">车牌号：</label>
						<input type="text" name="carNo" id="carNo" disabled="disabled">
					</div>
					<div class="field half first">
						<label for="name">进入时间</label>
						<input type="text" name="carIn" id="carIn" disabled="disabled">
					</div>
					<div class="field half">
						<label for="email">离开时间：</label>
						<input type="text" name="carOut" id="carOut" disabled="disabled">
					</div>
					<div class="field half first">
						<label for="name">商户订单号：</label>
						<input type="text" name="WIDout_trade_no" id="WIDout_trade_no" disabled="disabled">
					</div>
					<div class="field half">
						<label for="email">订单名称：</label>
						<input type="text" name="WIDsubject" id="WIDsubject" disabled="disabled">
					</div>
					<div class="field half first">
						<label for="name">付款金额：</label>
						<input type="text" name="WIDtotal_amount" id="WIDtotal_amount" disabled="disabled">
					</div>
					<div class="field half">
						<label for="email">商品描述：</label>
						<input type="text" name="WIDbody" id="WIDbody" disabled="disabled">
					</div>
				</div>
				<div class="btn_group">
					<input type="button" value="立即付款" class="button special btn_Click" id="btn">
					<input id="payState" value="${message}" type="hidden" />
					<input class="btn btn-primary back" type="button" id="backBtn" value = "返回首页">
				</div>
				
			</div>
		</div>
		<!-- <div class="btn-center">
		</div> -->

</body>
<!-- Scripts -->
<!-- <script src="js/jquery.min.js"></script> -->
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/flexible.js"></script>
<script src="3rd/CarNumPlugin/js/layer.js" type="text/javascript"></script>
<!-- <script src="3rd/layer/layer.js" type="text/javascript"></script> -->

<script src="3rd/CarNumPlugin/js/index.js" type="text/javascript"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/jquery.scrollex.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/util.js"></script>
<script src="js/main.js"></script>
<script src="3rd/CarNumPlugin/js/layer.js" type="text/javascript"></script>
<script src="3rd/CarNumPlugin/js/index.js" type="text/javascript"></script>
<script src="js/table_funs.js"></script>
<script src="js/payment.js"></script>

</html>