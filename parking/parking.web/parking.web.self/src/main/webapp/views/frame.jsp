<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
	<title>自助终端</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="3rd/assets/css/main.css" />
	<link rel="stylesheet" href="css/font-awesome.4.6.0.css">
	<link rel="stylesheet" href="3rd/CarNumPlugin/css/CarNumPlugin.css">
	<link rel="stylesheet" href="css/index.css">
</head>

<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
		<header id="header" class="alt">
			<a href="index.html" class="logo"><strong class="parkStrong">智能停车场</strong> <span></span></a>
			
		</header>
		<section id="banner" class="major">
			<div class="inner">
				<header class="">
					<div class="wel_title" id="welcomeuser">欢迎用户：XXX</div>
					<div class="input-plugin" id="welcomescan">
						<div class="panel-body">
							<div class="car_input">
								<ul class="clearfix ul_input col-black">
									<div class="che_tit">输入车牌</div>
									<li class="input_pro"><span id="name1"></span></li>
	                                    <li class="input_pp input_zim"><span id="name2"></span></li>
	                                    <li class="input_pp"><span id="name3"></span></li>
	                                    <li class="input_pp"><span id="name4"></span></li>
	                                    <li class="input_pp"><span id="name5"></span></li>
	                                    <li class="input_pp"><span id="name6"></span></li>
	                                    <li class="input_pp"><span id="name7"></span></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="user_hr"></div>
					<h2 class="user-h2"> 这里是智能停车场</h2>
					<div class="btn-center">
						<button id="login" class="btn btn-primary">点击记录车牌</button>
						<button id="exit" class="btn btn-primary">退出</button>
					</div>
				</header>
			</div>
		</section>

		<!-- Main -->
		<div id="main">

			<!-- One -->
			<section id="one" class="tiles">
				<article>
					<span class="image">
						<img src="img/pic01.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="payment" class="link">自助缴费</a></h3>
						<p>Self service payment</p>
					</header>
				</article>
				<article>
					<span class="image">
						<img src="img/pic02.jpg" alt="" />
					</span>
					<header class="major">
						<h3><a href="parkState" class="link">反向寻车</a></h3>
						<p>Reverse vehicle searching</p>
					</header>
				</article>
			</section>
		</div>
	</div>

	<!-- Scripts -->
	<script src="3rd/assets/js/jquery.min.js"></script>
	<script src="3rd/assets/js/jquery.scrolly.min.js"></script>
	<script src="3rd/assets/js/jquery.scrollex.min.js"></script>
	<script src="3rd/CarNumPlugin/js/layer.js" type="text/javascript"></script>
	<script src="3rd/CarNumPlugin/js/index.js" type="text/javascript"></script>
	<script src="3rd/assets/js/skel.min.js"></script>
	<script src="3rd/assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="3rd/assets/js/main.js"></script>
	<!-- <script src="js/index.js"></script> -->
	<script src="js/frame.js"></script>
</body>

</html>