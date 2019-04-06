$("#login")
		.click(
				function() {
					var $name1 = $("#name1");
					var $name2 = $("#name2");
					var $name3 = $("#name3");
					var $name4 = $("#name4");
					var $name5 = $("#name5");
					var $name6 = $("#name6");
					var $name7 = $("#name7");
					// alert($name2.html());
					searchName = $name1.html() + $name2.html() + $name3.html()
							+ $name4.html() + $name5.html() + $name6.html()
							+ $name7.html();
					// alert(searchName);
					if ($name1.html() == "" || $name2.html() == ""
							|| $name3.html() == "" || $name4.html() == ""
							|| $name5.html() == "" || $name6.html() == ""
							|| $name7.html() == "") {
						layer.open({
									style : 'border:none; background-color:#2A2F4A; color:#fff;',
									content : '请输入完整车牌！',
									btn : '确定',
									shadeClose : false
								});
					} else {
						$.ajax({
							url: "setcarnum.action",
							type: "POST",
							data: {
								"name": searchName
							},
							dataType: "json",
							success: function (data) {
								$("#welcomeuser").html("欢迎用户："+searchName);
								$("#welcomeuser").css("display","block");
								$("#welcomescan").css("display","none");
							},
							error: function (msg) {
							}
						});
					}
				});

function init(){
	$.ajax({
		url: "hascarnum.action",
		type: "POST",
		data: {},
		dataType: "json",
		success: function (data) {
			if(data.id == 0){
				$("#welcomeuser").html("欢迎用户："+data.carNum);
				$("#welcomeuser").css("display","block");
				$("#welcomescan").css("display","none");
			}else{
				$("#welcomeuser").css("display","none");
				$("#welcomescan").css("display","block");
			}
		},
		error: function (msg) {
		}
	});
}

function exit(){
	$.ajax({
		url: "exitcarnum.action",
		type: "POST",
		data: {},
		dataType: "json",
		success: function (data) {
			if(data.id == 0){
				init();
			}
		},
		error: function (msg) {
		}
	});
}

init();

$("#exit").click(function() {
	exit();
});