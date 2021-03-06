//判断是否点击验证码输入框，点击显示图片 未点击则隐藏
$("body").click(function(event) {
	if ($(event.target).hasClass("lookimage")) {
		$("#image").show(500);
	} else {
		$("#image").hide(500);
	}
});

//刷新验证码图片
$("#vercode").click(function(event) {
	$("#vercode").attr("src", "code.jpg?_data=" + new Date());
});

$("#login").click(function() {
	var name = $("#name").val();
//	var password = $("#password").val();
	var password = RSA($("#password").val());
	var code = $("#code").val();
	if(name != "" && $("#password").val() != "" && code != ""){
	$.ajax({
		type : "POST",
		url : "login.action",
		data : {
			"name" : name,
			"password" : password,
			"code" : code
		},
		success : function(msg) {
			var obj = eval("(" + msg + ")");
			zuiAlert(obj.message, 'danger');
			if (obj.id == 0) {
				if (obj.location != null) {
					document.location = obj.location;
				}
			}else{
				$("#vercode").attr("src", "code.jpg?_data=" + new Date());
			}
		},
		error : function(msg) {
		    zuiAlert("请联系管理员。。。", 'danger');
		}
	});
	}else{
		zuiAlert("输入不能为空","danger");
	}
});