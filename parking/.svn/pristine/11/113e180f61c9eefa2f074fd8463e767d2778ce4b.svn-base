<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title></title>
		<link rel="stylesheet" href="3rd/zui/css/zui.min.css"/>
		<link rel="stylesheet" href="css/common.css"/>
		<link rel="stylesheet" href="css/barrierGateDemo.css"/>
		<link rel="stylesheet" href="css/flipTimer.css">
		<style type="text/css">
			.infodiv{
				width: 120px;
				display: inline-block;
				font-weight: 600;
				font-size: 18px;
			}
			table tr td:first-child{
				font-weight: 600;
				font-size: 18px;
				text-align: right;
			}
			.center{
				height: 40px;
				padding: 7px;
			}
			
			.container-center{
				margin-top: 20px;
				height: 600px;
			}
			
			/* .container-left-innerUnder{
				margin-top: 55px;
			} */
			
			.date{
				height: 40px;
				font-size: 30px;
				color: white;
				margin-top: 8px;
			}
		</style>
	</head>

	<body>
	<!-- <div class="col-md-12 nav">
        <h3 class="nav-h3-title float-left" id="time"></h3>
        <h3 class="nav-h3-time">车辆收费</h3>
    </div> -->
    <div class="container-fluid container-middle">
        <div class="col-xs-12 col-md-5 container-left">
            <div class="Boxbkcolor center">
                <div class="infodiv">
                    <span class="font-white" >总停车位：</span><span class="font-white" id="placeCount">0</span>
                </div>
                <div class="infodiv">
                    <span class="font-white">空停车位：</span><span class="font-white" id="placeEmptyCount">0</span>
                </div>
                <div class="infodiv">
                     <span class="font-white">使用停车位：</span><span class="font-white" id="placeHasCount">0</span>
                </div>
                <div class="infodiv">
                	<i class="icon icon-star" id="carNumOne"></i>
                    <i class="icon icon-star" id="carNumTwo"></i>
                    <i class="icon icon-star" id="carNumThree"></i>
                </div>
            </div>
            
            <div class="" id="data">
            	<div class="date" align="center">
            		<span>2019</span>
            		<span>-</span>
            		<span>03</span>
            		<span>-</span>
            		<span>14</span>
            	</div>
            	<div class="date" align="center">
            		<span>星期四</span>
            		<span>晴</span>
            		<i class="icon icon-sun icon-2x"></i>
            	</div>
            	<div class="dowebok" style="margin-top: 5px;">
					<div class="hours"></div>
					<div class="minutes"></div>
					<div class="seconds"></div>
				</div>
            </div>

            <div class="container-left-innerUnder">
                <table class ="font-white">
                    <tr>
                        <td>序号：</td>
                        <td><input disabled class="form-control" type="text" id="carId"></td>
                    </tr>
                    <tr>
                        <td>车牌号：</td>
                        <td><input disabled class="form-control" type="text" id="carNum"></td>
                    </tr>
                    <tr>
                        <td>入场时间：</td>
                        <td><input disabled class="form-control" type="text" id="comeTime"></td>
                    </tr>
                    <tr>
                        <td>出场时间：</td>
                        <td><input disabled class="form-control" type="text" id="outTime"></td>
                    </tr>
                     <tr>
                        <td>用户类型：</td>
                        <td><input disabled class="form-control" type="text" id="userType"></td>
                    </tr>
                     <tr>
                        <td>缴费金额：</td>
                        <td><input disabled class="form-control" type="text" id="money"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input  class="form-control" type="button" value="付费" id="pay"></td>
                    </tr>
                </table>
            </div>

        </div>
        <div class="col-xs-12 col-md-6 container-center">
        	<video id="video" width="1200" height="600" style="margin-top: -4px;"></video>
			<canvas id="canvas" width="1200" height="600" style="display: none"></canvas>
			<div id="face"></div>
        </div>
        
        <div id="bdtts_div_id">
			<audio id="tts_autio_id" autoplay="autoplay">
				<source id="tts_source_id" src="" type="audio/mpeg">
				<embed id="tts_embed_id" height="0" width="0" src="">
			</audio>
		</div>
	</body>
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/jquery.flipTimer.js"></script>
<script src="js/payment.js"></script>
<script>
$(function(){
	$('.dowebok').flipTimer({
		seconds: true
	});
});
</script>
</html>