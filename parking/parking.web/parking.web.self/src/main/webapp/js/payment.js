
//获取终端ID
var mechineId = 1;
//支付页面js
var $payState = $("#payState");
	//alert($("#payState").val());
	if ($("#payState").val() == null || $("#payState").val() == '') {
		/* setTimeout(function(){
			zuiAlert("支付失败！", 'danger');
		},2000); */
	} else {
		/*var carId = "${id}";
		$("#carId").val(carId);
		var carNo = "${carNo}";
		$("#carNo").val(carNo);
		var comeTime = "${comeTime}";
		$("#carIn").val(formatUnixtimestamp(comeTime));
		var outTime = "${outTime}";
		$("#carOut").val(formatUnixtimestamp(outTime));
		var out_trade_no = "${out_trade_no}";
		$("#WIDout_trade_no").val(out_trade_no);
		var subject = "${subject}";
		$("#WIDsubject").val(subject);
		var total_amount = "${total_amount}";
		$("#WIDtotal_amount").val(total_amount);
		var body = "${body}";
		$("#WIDbody").val(body);*/
		
		setTimeout(function() {
			layer.open({
				  style: 'border:none; background-color:#2A2F4A; color:#fff;',
				  content: "支付成功！",
				  btn: '确定',
				  shadeClose: false
				});
			/* 
			zuiAlert("支付成功！"); */
			//zuiAlert("支付成功！", 'success');
		}, 1000);
	}

	
	function formatUnixtimestamp(unixtimestamp) {
		var unixtimestamp = new Date(unixtimestamp);
		var year = 1900 + unixtimestamp.getYear();
		var month = "0" + (unixtimestamp.getMonth() + 1);
		var date = "0" + unixtimestamp.getDate();
		var hour = "0" + unixtimestamp.getHours();
		var minute = "0" + unixtimestamp.getMinutes();
		var second = "0" + unixtimestamp.getSeconds();
		return year + "-" + month.substring(month.length - 2, month.length)
				+ "-" + date.substring(date.length - 2, date.length) + " "
				+ hour.substring(hour.length - 2, hour.length) + ":"
				+ minute.substring(minute.length - 2, minute.length) + ":"
				+ second.substring(second.length - 2, second.length);
	}
	//初始化
	function init() {
		$.ajax({
			url : "do-payment.ajax",
			type : "POST",
			data : { },
			dataType : "json",
			success : function(data) {
				var id = data.id;
				var queryRecord = data.queryRecord;
				var money = data.money;
				if (id == 0) {
					var $carId = $("#carId");
					var $carNo = $("#carNo");
					var $carIn = $("#carIn");
					var $carOut = $("#carOut");
					var $WIDout_trade_no = $("#WIDout_trade_no");
					var $WIDsubject = $("#WIDsubject");
					var $WIDtotal_amount = $("#WIDtotal_amount");
					var $WIDbody = $("#WIDbody");
					$carId.val(queryRecord.carRecordId);
					$carNo.val(queryRecord.carNum);
					$carIn.val(formatUnixtimestamp(new Date(queryRecord.carRecordComeTime)));
					$carOut.val(formatUnixtimestamp(new Date(
							queryRecord.carRecordOutTime)));
					$WIDout_trade_no.val(GetDateNow());
					$WIDsubject.val("停车订单");
					$WIDtotal_amount.val(money);
					$WIDbody.val("无");
					
				} else if(id == 4){
					layer.open({
						  style: 'border:none; background-color:#2A2F4A; color:#fff;',
						  content: data.message,
						  btn: '确定',
						  shadeClose: false
						});
				}else {
					layer.open({
						  style: 'border:none; background-color:#2A2F4A; color:#fff;',
						  content: "未所搜到该车停车记录",
						  btn: '确定',
						  shadeClose: false
						});
				}
			},
			error : function(msg) {
				layer.open({
					  style: 'border:none; background-color:#2A2F4A; color:#fff;',
					  content: "请联系管理员...",
					  btn: '确定',
					  shadeClose: false
					});
			}
		});
	}
	
	init();
	
	//缴费
	$("#btn").click(function() {
		//searchName = $("#name").val();
		var $carId = $("#carId");
		var $carNo = $("#carNo");
		var $carIn = $("#carIn");
		var $carOut = $("#carOut");
		var $WIDout_trade_no = $("#WIDout_trade_no");
		var $WIDsubject = $("#WIDsubject");
		var $WIDtotal_amount = $("#WIDtotal_amount");
		var $WIDbody = $("#WIDbody");
		//alert($carIn.html());
		if ($carNo.val().trim() == "") {
			layer.open({
				  style: 'border:none; background-color:#2A2F4A; color:#fff;',
				  content:"请先登录车牌！",
				  btn: '确定',
				  shadeClose: false
				});
		} else {
			$.ajax({
				url : "do-alipay.ajax",
				type : "POST",
				data : {
					"id" : $carId.val(),
					"carNo" : $carNo.val(),
					"mechineId" : mechineId,
					"out_trade_no" : $WIDout_trade_no.val(),
					"subject" : $WIDsubject.val(),
					"total_amount" : $WIDtotal_amount.val(),
					"body" : $WIDbody.val()
				},
				dataType : "json",
				success : function(data) {
					var result = data.result;
					var $body = $("#body");
					$body.html(result);
				},
				error : function(msg) {
					layer.open({
						  style: 'border:none; background-color:#2A2F4A; color:#fff;',
						  content:"请联系管理员...",
						  btn: '确定',
						  shadeClose: false
						});
				}
			});
		}

	});

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
		return sNow;
	}
	$("#backBtn").click(function() {
		window.location.replace("http://localhost:8080/parking.web.self");
	});