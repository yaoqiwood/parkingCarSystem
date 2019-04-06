<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>路径文字描述</title>
<link rel="stylesheet" href="3rd/fengniao/lib/bootstrap.min.css">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link href="3rd/fengniao/css/style.css" rel="stylesheet">
<link href="css/iconfont.css" rel="stylesheet">
<link rel="stylesheet" href="css/common.css">
</head>

<body>
	<div id="fengMap"></div>
<div class="col-xs-12 no-padding panel panel-primary">
	<div class="panel-heading center"><i class="icon-desktop"></i>&nbsp;停车场查看</div>
</div>

	<!-- 楼层按钮组 -->
	<div class="btn-group-vertical group-layer" data-toggle="buttons">
		<span id="top" class="btn btn-default"><i class="icon iconfont">&#8743;</i></span>
		<div class="btn-group-vertical layer-list" data-toggle="buttons"></div>
		<span id="down" class="btn btn-default disabled"><i class="icon iconfont">&#8744;</i></span>
	</div>
</body>
<script src="3rd/fengniao/lib/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/fengniao/lib/fengmap.min.js"></script>
<script src="3rd/fengniao/lib/bootstrap.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!-- 右边导航控件，基于Jquery库   -->
<script src="js/layerGroup.js"></script>
<script src="js/layerList.js"></script>
<script src="js/parkState.js"></script>

</html>