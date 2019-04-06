//定义搜索变量
var searchName="";
var searchPlace ="";
var searchFloor ="";
// 定义分页变量
var currPage = 1;
var limit = 5;
var admins = null;
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
			"place" : searchPlace,
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
			var admins = obj.admins;
			var c = obj.count;
			if(c == 0) {
				$('#myPager').data('zui.pager').set(1, 1,limit);
				$("#tb").append($("<tr class='tr' align='center'><td colspan='5'>未搜索到相关数据</td></tr>"));
			} else{
				for(var i = 0; i < admins.length; i++) {
					var $tr = $("<tr class='tr'></tr>");
					$tr.append($("<td>"+ admins[i].placeId +"</td>"));
					$tr.append($("<td>"+ admins[i].subareaName +"</td>"));
					$tr.append($("<td>"+ admins[i].placeNumber +"</td>"));
					$tr.append($("<td>"+ admins[i].subareaFloor +"</td>"));
					$tr.append($("<td>"+
							"<button placePsId='" + admins[i].placePsId + "' class='btn btn-sm btn-info' type='button'><i class='icon icon-cog'></i>&nbsp;修改</button>"
							+
							"<button placeId='" + admins[i].placeId + "' class='btn btn-sm btn-danger' type='button'><i class='icon icon-trash'></i>&nbsp;删除</button>"
							+
					"</td>"));
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
	searchPlace =$("#place").val();
	searchFloor =$("#floor").val();
	currPage = 1;
	init();
	empty();
});
function empty(){
	 $("#name").val("");
	 $("#place").val("");
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
    	case ("修改"):
            var arr= $(event.target).parent().parent().children();
			var $dname = $("#dname");
			var $dplace = $("#dplace");
			var $dfloor= $("#dfloor");
			var $did= $("#did");
		    $dname.val($(arr[2]).html());
		    $dplace.val($(arr[1]).html());
		    $dfloor.val($(arr[3]).html());
		    $did.val($(event.target).attr("placePsId"));
		    $("#updatedialog").css("display", "block");
        	break;
    	default:
    		break;
	 }
});
$("#cancel").click(function() {
	$("#updatedialog").css("display", "none");
});
$("#commit").click(function() {
			var $dplace = $("#dplace");
			var $dfloor= $("#dfloor");
			var $did= $("#did");
			if($dplace.val() == "" || $dfloor.val() ==""){
				alert("不能为空，请输入正确！！");
				return;
			}
			var result = postAjax("motifyCarplace.action", {
							"placePsId" : $did.val(),
							"dplace" : $dplace.val(),
							"dfloor" :$dfloor.val()
						});
			if(result){
				$("#dialog").css("display", "none");
			}
			
});
// 添加操作
$("#addBtn").click(function() {
	var $addname= $("#addname");
	var $addplace= $("#addplace");
	var $addfloor= $("#addfloor");
	$addplace.val("");
	$addfloor.val("");
	$addname.val(""); 
	$("#adddialog").css("display", "block");
});
// 设置添加弹框的添加按钮监听
$("#addcommit").click(function() {
	var $addname= $("#addname");
	var $addplace= $("#addplace");
	var $addfloor= $("#addfloor");
	if ($addname.val()== "" || $addplace.val()=="" || $addfloor.val() == "") {
		alert("不可为空，请输入正确！！");return;
	}
	var result = postAjax("addPlace.action", {
		"addname" : $addname.val(),
		"addplace":$addplace.val(),
		"addfloor" : $addfloor.val()
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