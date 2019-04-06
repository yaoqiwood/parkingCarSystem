$(document).resize(function () {
	$("#p-iframe").width( $(document).width() - $("#z-sideBar").width() - 3);
	$("#z-sideBar").position().left < 0 ? $("#p-iframe").width($("#p-iframe").width() + 230) : "";
});

$(function(){
    $("#p-iframe").width( $(document).width() - $("#z-sideBar").width() - 3);
    $("#z-sideBar").position().left < 0 ? $("#p-iframe").width($("#p-iframe").width() + 230) : "";
});


$("#z-sideBar").resize(function () {
	$("#p-iframe").width($(document).width() - $("#z-sideBar").width() - 3);
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
