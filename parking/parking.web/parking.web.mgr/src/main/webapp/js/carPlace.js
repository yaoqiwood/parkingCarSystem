//定义搜索变量
var searchName="";
var searchFloor ="";
// 定义分页变量
var currPage = 1;
var limit = 5;
//ajax推送信息（用于表格的状态修改操作）
function postAjax(url,data){
	var result = false;
	 $.ajax({
		url : url,
		async: false,
		type : "POST",
		data : data,
		success : function(msg) { 
			var obj = eval("(" + msg + ")"); 
			alert(obj.message);
			if (obj.id == 0) {
				currPage = 1;
				init();
				result = true;
			}
		},
		error : function(msg) {
			alert("请联系管理员");
		}
	});
	return result;
}
//查询方法
function init() {
	var start = (currPage - 1) * limit + 1;
	var end = currPage * limit;
	$.ajax({
		url: "listPlaceByPage.action",
		type: "POST",
		dataType:"json",
		data: {
			"name": searchName,
			"floor" : searchFloor,
			"start": start,
			"end": end
		},
		success: function(data) {
			var msg = JSON.stringify(data);
			var obj = eval("(" + msg + ")");
			// 首先清空数据
			var arr = $(".tr")
			for(var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove()
			};
			// 添加数据
			var list = obj.list;
			var c = obj.count;
			if(c == 0) {
				$('#myPager').data('zui.pager').set(1, 1,limit);
				$("#tb").append($("<tr class='tr' align='center'><td colspan='5'>未搜索到相关数据</td></tr>"));
			} else{
				for(var i = 0; i < list.length; i++) {
					var $tr = $("<tr class='tr'></tr>");
					$tr.append($("<td>"+ list[i].placeId +"</td>"));
					$tr.append($("<td>"+ list[i].placeUrl +"</td>"));
					$tr.append($("<td>"+ list[i].placeNumber +"</td>"));
					$tr.append($("<td>"+ list[i].placePsId +"</td>"));
					$tr.append($("<td><button placeId='" + list[i].placeId + "' class='btn btn-sm btn-danger' type='button'><i class='icon icon-trash'></i>&nbsp;删除</button></td>"));
					$("#tb").append($tr);
				};
			}
			$('#myPager').data('zui.pager').set(currPage, c, limit);
		},
		error: function(msg) {
			alert("请联系管理员");
		}
	});
}

//页码监听
$('#myPager').on('onPageChange', function (e, state, oldState) {
	if (state.page !== oldState.page) {
		currPage = state.page;
		init();
	}
});
//搜所
$("#selectBtn").click(function() {
	searchName = $("#name").val();
	searchFloor =$("#floor").val();
	currPage = 1;
	init();
});
function empty(){
	 $("#name").val("");
	 $("#floor").val("");
}
//首次刷新
init();
//表格监听
$("#tb").click(function(event) {
	var placeId = $(event.target).attr("placeId");
	switch ($(event.target).text().trim()) {
    	case ("删除"):
    		if (confirm("确定要删除吗")) {
    			postAjax("delCarplace.action", { "placeId" : placeId });
    		}
        	break;
    	default:
    		break;
	 }
});

// 添加操作
$("#addBtn").click(function() {
	$("#addname").val("");
	$("#addnum").val("");
	$("#addfloor").val("");
	$("#adddialog").css("display", "block");
});
// 设置添加弹框的添加按钮监听
$("#addcommit").click(function() {
	var $addname = $("#addname");
	var $addnum = $("#addnum");
	var $addfloor= $("#addfloor");
	if ($addname.val()== "" || $addnum.val()=="" || $addfloor.val() == "") {
		alert("不可为空，请输入正确！！");return;
	}
	var result = postAjax("addPlace.action", {
		"addname" : $addname.val(),
		"addnum":$addnum.val(),
		"addfloor" : $addfloor.val()
	});
	if(result){
		$("#adddialog").css("display", "none");
	}
});
$("#addcancel").click(function() {
	$("#adddialog").css("display", "none");
});