$(document).resize(function () {
	$("#p-iframe").width( $(document).width() - $("#z-sideBar").width() - 5);
	$("#z-sideBar").position().left < 0 ? $("#p-iframe").width($("#p-iframe").width() + 230) : "";
	$("#p-iframe").height($("#p-iframe").height() - 100 );
});


$("#z-sideBar").resize(function () {
	$("#p-iframe").width($(document).width() - $("#z-sideBar").width() - 5);
})

// 边框加载的方法
var siderLoad = function (ul, arr) {

	for (var i = 0; i < arr.length; i++) {
		var $li = $("<li class='treeview'></li>");
		if (arr[i].menuParent == 0) {

			var $a = $("<a href='#' menu-url='" + arr[i].menuUrl + "'>"
					+ "<i class='icon icon-"+arr[i].menuMemo+"'></i>" + "<span>"
					+ arr[i].menuName + "</span>"
					+ "<span class='pull-right-container'>"
					+ "<i class='icon icon-angle-left'></i>" + "</span>"
					+ "</a>");

			$li.append($a);
		} else {

			var $a = $("<a href='#' menu-url='" + arr[i].menuUrl + "' menuId='"
					+ arr[i].id + "' >"
					+ "<i class='icon icon-"+arr[i].menuMemo+"'></i>"
					+ arr[i].menuName + "</a>");

			$li.append($a);
		}
		if (arr[i].menuBeans != null && arr[i].menuBeans.length > 0) {
			var $ul = $("<ul class='treeview-menu'></ul>");
			siderLoad($ul, arr[i].menuBeans);
			$li.append($ul);
		}
		ul.append($li);
	}

	$(".pointUrl").each(function () {
		$(this).click(function () {
			$("#p-iframe").attr("src", $(this).attr("url"));
		})
	})

}


$.ajax({
	url: "init-leftMenu.action",
	type: "POST",
	dataType: "json",
	data: {},
	success: function (data) {
		console.log(data);
		siderLoad($("#tree"), data);
	},
	error: function (msg) {
	    zuiAlert("请联系管理员。。。", 'danger');
	}
});

$("#tree").click(function(event) {
	var url = $(event.target).attr("menu-url");
	if (url !== null && url !== "null" && $(event.target).text() != '分类统计') {
		$("#p-iframe").attr("src", url);
	}
});


var out = document.getElementById("out");
out.onclick = function() {
    layer.confirm('确定要退出系统吗？', function (index) {
        location.href="cancel.action";
        layer.close(index);
    });
}
var changePassword = document.getElementById("changePassword");
changePassword.onclick = function() {
	var updatePwd = document.getElementById("updatePwd");
	updatePwd.style.display="block";
	var diving2 = document.getElementById("diving2");
	diving2.style.display="block";
	var oldpwd = document.getElementById("oldpwd");
	var newpwd = document.getElementById("newpwd");
	var surepwd = document.getElementById("surepwd");
	newpwd.value ='' ;
	surepwd.value ='';
	oldpwd.value = '';
}
var cancel = document.getElementById("cancel");
cancel.onclick = function() {
	var updatePwd = document.getElementById("updatePwd");
	updatePwd.style.display="none";
	var diving2 = document.getElementById("diving2");
	diving2.style.display="none";
}

var commit = document.getElementById("commit");
commit.onclick = function() {    
     var oldpwd = document.getElementById("oldpwd");
		var newpwd = document.getElementById("newpwd");
		var surepwd = document.getElementById("surepwd");
		if(newpwd.value == '' || surepwd.value =='' ||
				oldpwd.value == ''){
			zuiAlert("请注意密码大小写，请输入正确");
		}else if(newpwd.value != surepwd.value){
			zuiAlert("两次密码请输入相同");
		}else{
			$.ajax({
				url:"updatepwd.action",
				type:"POST",
				dataType:"json",
				data:{"oldpwd" : oldpwd.value ,"newpwd" : newpwd.value},
				success:function(data){
				 var msg = JSON.stringify(data);
	             var obj = eval("(" + msg +")");
	             if(obj.id==0){
	            	 zuiAlert(obj.message);
	             }else{
	            	 zuiAlert(obj.message);
	             }
	             var updatePwd = document.getElementById("updatePwd");
	         	updatePwd.style.display="none";
	         	var diving2 = document.getElementById("diving2");
	         	diving2.style.display="none";
				},
				error:function(msg){
					zuiAlert("请联系管理员");
				}
			});
		}
}

