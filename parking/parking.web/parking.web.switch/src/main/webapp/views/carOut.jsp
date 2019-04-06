<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title></title>
		<link rel="stylesheet" href="3rd/zui/css/zui.min.css"/>
		<link rel="stylesheet" href="css/common.css"/>
		<link rel="stylesheet" href="css/barrierGateDemo.css"/>
		<link rel="stylesheet" href="css/flipTimer.css">
	</head>

	<body>
		<div class="col-md-12 nav">
        <h3 class="nav-h3-title float-left">Demo智能停车场道闸端</h3>
        <h3 class="nav-h3-time float-left" id="time">9:26</h3>
    </div>
    <div class="container-fluid container-middle">
        <div class="col-xs-4 col-md-4 container-left">
            <h2 class="font-white">XX停车场</h2>
            <div class="container-box Boxbkcolor">
                <div class="container-box-innerText">
                    <h4 class="font-white" id="placeCount" id="placeCount">总停车位：0</h4>
                    <h4 class="font-white" id="placeEmptyCount" id="placeEmptyCount">空停车位：0</h4>
                    <h4 class="font-white" id="placeHasCount" id="placeHasCount">使用停车位：0</h4>
                </div>
            </div>

            <div class="container-left-innerUnder">
                <table class = "font-white">
                    <tr>
                        <td>序号：</td>
                        <td><input class="form-control" type="text" id="carId"></td>
                    </tr>
                    <tr>
                        <td>车牌号：</td>
                        <td><input disabled class="form-control" type="text" id="carNum"></td>
                    </tr>
                    <tr>
                        <td>入场时间：</td>
                        <td><input disabled class="form-control" type="text" id="carTime"></td>
                    </tr>
                    <tr>
                        <td>用户类型：</td>
                        <td><input disabled class="form-control" type="text" id="carRole"></td>
                    </tr>
                </table>
            </div>

        </div>
        <div class="col-xs-7 col-md-7 container-center">
        	<video id="video" width="1000" height="390"></video>
			<canvas id="canvas" width="1000" height="390" style="display: none"></canvas>
			<div id="face"></div>
        </div>
        
        <div id="bdtts_div_id">
			<audio id="tts_autio_id" autoplay="autoplay">
				<source id="tts_source_id" src="http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=5&text=播报内容" type="audio/mpeg">
				<embed id="tts_embed_id" height="0" width="0" src="">
			</audio>
		</div>
</body>
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
<script type="text/javascript" src="js/carOut.js"> </script>
</html>


    