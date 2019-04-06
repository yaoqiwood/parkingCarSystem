function formatUnixtimestamp (unixtimestamp){
    var unixtimestamp = new Date(unixtimestamp);
    var year = 1900 + unixtimestamp.getYear();
    var month = "0" + (unixtimestamp.getMonth() + 1);
    var date = "0" + unixtimestamp.getDate();
    var hour = "0" + unixtimestamp.getHours();
    var minute = "0" + unixtimestamp.getMinutes();
    var second = "0" + unixtimestamp.getSeconds();
    return year + "-" + month.substring(month.length-2, month.length)  + "-" + date.substring(date.length-2, date.length)
        + " " + hour.substring(hour.length-2, hour.length) + ":"
        + minute.substring(minute.length-2, minute.length) + ":"
        + second.substring(second.length-2, second.length);
}
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
//定义搜索变量
var searchName="";
var searchStime ="";
var searchEtime ="";
// 定义分页变量
var currPage = 1;
var limit = 5;
//查询方法
function init() {
	var start = (currPage - 1) * limit + 1;
	var end = currPage * limit;
	$.ajax({
		url: "listwhiteListByPage.action",
		type: "POST",
		dataType:"json",
		data: {
			"name": searchName,
			"startTime" : searchStime,
			"endTime" : searchEtime,
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
			var admins = obj.admins;
			var c = obj.count;
			if(c == 0) {
				$('#myPager').data('zui.pager').set(1, 1,limit);
				$("#tb").append($("<tr class='tr' align='center'><td colspan='5'>未搜索到相关数据</td></tr>"));
			} else{
				for(var i = 0; i < admins.length; i++) {
					var $tr = $("<tr class='tr'></tr>");
					$tr.append($("<td>"+ admins[i].whiteListId +"</td>"));
					$tr.append($("<td>"+ admins[i].whiteListCarNum +"</td>"));
					$tr.append($("<td>"+ formatUnixtimestamp(new Date(admins[i].whiteListCreateTime)) +"</td>"));
					$tr.append($("<td>"+
							"<button whiteListId='" + admins[i].whiteListId + "' class='btn btn-sm btn-danger' type='button'><i class='icon icon-trash'></i>&nbsp;删除</button>"
							+ "</td>"));
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
	searchName =$("#name").val();
	searchStime =$("#startTime").val();
	searchEtime =$("#endTime").val();
	currPage = 1;
	init();
});
function empty(){
	$("#name").val("");
	$("#startTime").val("");
	$("#endTime").val("");
}
//首次刷新
init();
//表格监听
$("#tb").click(function(event) {
	var whiteListId = $(event.target).attr("whiteListId");
	switch ($(event.target).text().trim()) {
    	case ("删除"):
    		if (confirm("确定要删除吗")) {
    			postAjax("delWhiteList.action", { "whiteListId" : whiteListId });
    		}
        	break;
    	default:
    		break;
	 }
});
// 添加操作
$("#addBtn").click(function() {
	var $addname= $("#addname");
	$addname.val(""); 
	$("#adddialog").css("display", "block");
});
// 设置添加弹框的添加按钮监听
$("#addcommit").click(function() {
	var $addname= $("#addname");
	if ($addname.val()== "") {
		alert("不可为空，请输入正确！！");return;
	}
	var result = postAjax("addwhiteList.action", {
		"addname" : $addname.val()
		});
	if(result){
		var $adddialog = $("#adddialog");
		$adddialog.css("display", "none");
	}
});
$("#addcancel").click(function() {
	var $adddialog = $("#adddialog");
	$adddialog.css("display", "none");
});
