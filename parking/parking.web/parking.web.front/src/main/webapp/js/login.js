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
	var name = $("#name").val().trim();
//	var password = $("#password").val();
	var password = RSA($("#password").val().trim());
	var code = $("#code").val().trim();
	if(name != "" && $("#password").val().trim() != "" && code != ""){
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
				zuiAlert(obj.message, obj.id == 0?'success':'danger');
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