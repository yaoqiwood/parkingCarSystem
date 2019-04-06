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
	//获取终端ID
	var mechineId = 1;
	//定义搜索变量
	var searchName = "";
	//定义分页变量
	var start = 1;//开始
	var end = 5;//结束
	var count = 0;//一共多少条
	var currPage = 1;//当前第几页
	var allPage = 0;//一共多少页
	var limit = 5;//每页显示多少条
	//初始化
	function init() {
		start = (currPage - 1) * limit + 1;
		end = currPage * limit;
		$.ajax({
			url : "do-payment.ajax",
			type : "POST",
			data : {
				"name" : searchName
			},
			dataType : "json",
			success : function(data) {
				console.log(data);
				//首先清空
				var arr = $(".tr");
				for (var i = arr.length - 1; i >= 0; i--) {
					$(arr[i]).remove();
				}
				var id = data.id;
				var queryRecord = data.queryRecord;
				var money = data.money;
				if (id == 0) {
					var $tb = $("#tb");
					var $tr = $("<tr class='tr' align='center'></tr>");
					var $td1 = $("<td></td>");
					$td1.html(queryRecord.carRecordId);
					var $td2 = $("<td></td>");
					$td2.html(queryRecord.carNum);
					var $td3 = $("<td></td>");
					$td3.html(formatUnixtimestamp(new Date(
							queryRecord.carRecordComeTime)));
					var $td4 = $("<td></td>");
					$td4.html(formatUnixtimestamp(new Date(
							queryRecord.carRecordOutTime)));
					//var $td5 = $("<td><input id='WIDout_trade_no' name='WIDout_trade_no' value='201932151758178' /></td>");
					var $td5 = $("<td id='WIDout_trade_no' name='WIDout_trade_no'></td>");
					$td5.html(GetDateNow());
					//var $td6 = $("<td><input id='WIDsubject' name='WIDsubject' value='停车场缴费订单'/></td>");
					var $td6 = $("<td id='WIDsubject' name='WIDsubject'></td>");
					$td6.html("停车订单");
					var $td7 = $("<td id='WIDtotal_amount' name='WIDtotal_amount'></td>");
					$td7.html(money);
					var $td8 = $("<td id='WIDbody' name='WIDbody'></td>");
					$td8.html("");
					var $td9 = $("<td><input class='btn btn-warning' type='button' value='缴费'/> </td>");
					//var $td9 = $("<td><input class='btn btn-warning' type='submit' id='btn' value='缴费'/> </td>");
					
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$tr.append($td5);
					$tr.append($td6);
					$tr.append($td7);
					$tr.append($td8);
					$tr.append($td9);
					$("#tb").append($tr);
				} else {
					alert("暂无数据");
				}
			},
			error : function(msg) {
				alert("请联系管理员...");
			}
		});
	}
	//页码监听
	$('#myPager').on('onPageChange', function(e, state, oldState) {
		if (state.page !== oldState.page) {
			console.log('页码从', oldState.page, '变更为', state.page);
			currPage = state.page;
			init();
		}
	});
	//搜索
	$("#selectBtn").click(function() {
		searchName = $("#name").val();
		if (searchName == "") {
			alert("车牌不能为空！");
		} else {
			init();
		}
	});
	//缴费
	$("#tb").click(function(event) {
		var $tar = $(event.target);
		//禁用
		if ($tar.val() == "缴费") {
			arr = $tar.parent().parent().children();
			var id = arr[0].innerHTML;
			var carNo = arr[1].innerHTML;
			var tradeNo = document.getElementById("WIDout_trade_no");
			var subject = document.getElementById("WIDsubject");
			var totalAmount = document.getElementById("WIDtotal_amount");
			var body = document.getElementById("WIDbody");
			$.ajax({
				url : "do-alipay.ajax",
				type : "POST",
				data : {
					"id" : id,
					"carNo" : carNo,
					"mechineId" : mechineId,
					"out_trade_no" : tradeNo.innerHTML,
					"subject" : subject.innerHTML,
					"total_amount" : totalAmount.innerHTML,
					"body" : body.innerHTML
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