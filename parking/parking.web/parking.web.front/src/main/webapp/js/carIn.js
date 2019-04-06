function formatUnixtimestamp(unixtimestamp) {
	var unixtimestamp = new Date(unixtimestamp);
	var year = 1900 + unixtimestamp.getYear();
	var month = "0" + (unixtimestamp.getMonth() + 1);
	var date = "0" + unixtimestamp.getDate();
	var hour = "0" + unixtimestamp.getHours();
	var minute = "0" + unixtimestamp.getMinutes();
	var second = "0" + unixtimestamp.getSeconds();
	return year + "-" + month.substring(month.length - 2, month.length) + "-" + date.substring(date.length - 2, date.length) +
		" " + hour.substring(hour.length - 2, hour.length) + ":" +
		minute.substring(minute.length - 2, minute.length) + ":" +
		second.substring(second.length - 2, second.length);
}
function emty(){
	var $name = $("#name");
	$name.val("");
}
//定义搜索变量
var searchName = "";
// 定义分页变量
var currPage = 1;
var limit = 5;

function init() {
	var start = (currPage - 1) * limit + 1;
	var end = currPage * limit;
	$.ajax({
		url: "listcarInByPage.action",
		type: "POST",
		dataType:"json",
		data: {
			"name": searchName,
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
			var carnum = obj.carnum;
			if(searchName != null && obj.id ==1){
				alert(obj.message);
				return;
			}
			if(c == 0) {
				init();
			} else{
				alert("您的车位为" + carnum);
				alert(obj.message);
				for(var i = 0; i < admins.length; i++) {
					var $tr = $("<tr class='tr'></tr>");
					$tr.append($("<td>" + admins[i].carnumId + "</td>"));
					$tr.append($("<td>" + admins[i].carNumber + "</td>"));
					$tr.append($("<td>" + admins[i].carRoleName + "</td>"));
					$tr.append($("<td>" + formatUnixtimestamp(new Date(admins[i].carnumCreateTime)) + "</td>"));
					$tr.append($("<td>" + formatUnixtimestamp(new Date(admins[i].carnumUpdateTime)) + "</td>"));
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
//搜索
$("#selectBtn").click(function() {
	searchName = $("#name").val();
	currPage = 1;
	init();
	emty();
});