<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>支付宝电脑网站支付</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
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
	z-index: 3;;
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
	<div id="body">
	
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">支付宝电脑网站支付</div>

		<!-- <form name=alipayment action=pays method=post target="_blank"> -->
			<div class="panel-body container-fluid">
				<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">商户订单号 ：</span> 
						<input id="WIDout_trade_no" name="WIDout_trade_no" class="form-control"/>
						
					</div>
				</div>

				<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">订单名称 ：</span> 
						<input id="WIDsubject" name="WIDsubject" class="form-control"/>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">付款金额 ：</span> 
						<input id="WIDtotal_amount" name="WIDtotal_amount" class="form-control"/>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-3 scan">
					<div class="input-group">
						<span class="input-group-addon">商品描述：</span>
						<input id="WIDbody" name="WIDbody" class="form-control"/>
					</div>
				</div>

				<div class="col-xs-12 col-md-4 scan ">
					<button class="btn btn-primary" id="btn" type="btn">付 款</button>
				</div>

			</div>
		<!-- </form> -->
	</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
<script type="text/javascript"
	src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script language="javascript">
	var btn = document.getElementById("btn");
	btn.onclick = function() {
		var tradeNo = document.getElementById("WIDout_trade_no");
		//alert("商户订单号= "+tradeNo.value);
		var subject = document.getElementById("WIDsubject");
		//alert(subject.value);
		var totalAmount = document.getElementById("WIDtotal_amount");
		alert(totalAmount.value);
		var body = document.getElementById("WIDbody");
		$.ajax({
			url : "do-alipay.ajax",
			type : "POST",
			data : {
				"out_trade_no" : tradeNo.value,
				"subject" : subject.value,
				"total_amount" : totalAmount.value,
				"body" : body.value
			},
			dataType : "json",
			success : function(data) {
				console.log(data);
				var result = data.result;
				var $body = $("#body");
				$body.html(result);
			},
			error : function(msg) {
				alert("请联系管理员...");
			}
		}); 
		alert(222);
	}  

	var tabs = document.getElementsByName('tab');
	var contents = document.getElementsByName('divcontent');

	(function changeTab(tab) {
		for (var i = 0, len = tabs.length; i < len; i++) {
			tabs[i].onmouseover = showTab;
		}
	})();

	function showTab() {
		for (var i = 0, len = tabs.length; i < len; i++) {
			if (tabs[i] === this) {
				tabs[i].className = 'selected';
				contents[i].className = 'show';
			} else {
				tabs[i].className = '';
				contents[i].className = 'tab-content';
			}
		}
	}

	function GetDateNow() {
		var vNow = new Date();
		var sNow = "";
		sNow += String(vNow.getFullYear());
		sNow += String(vNow.getMonth() + 1);
		sNow += String(vNow.getDate());
		sNow += String(vNow.getHours());
		sNow += String(vNow.getMinutes());
		sNow += String(vNow.getSeconds());
		sNow += String(vNow.getMilliseconds());
		document.getElementById("WIDout_trade_no").value = sNow;
		document.getElementById("WIDsubject").value = "停车场缴费订单";
		document.getElementById("WIDtotal_amount").value = "0.01";
	}
	GetDateNow();
</script>


</html>