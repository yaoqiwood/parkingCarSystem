//时间控件
$(".form-date").datetimepicker(
{
    language:  "zh-CN",
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    minView: 2,
    forceParse: 0,
    format: "yyyy-mm-dd"
});
//时间戳 转 yyyy-mm-dd
function formatUnixtimestamp(unixtimestamp) {
	var unixtimestamp = new Date(unixtimestamp);
	var year = 1900 + unixtimestamp.getYear();
	var month = "0" + (unixtimestamp.getMonth() + 1);
	var date = "0" + unixtimestamp.getDate();
	var hour = "0" + unixtimestamp.getHours();
	var minute = "0" + unixtimestamp.getMinutes();
	var second = "0" + unixtimestamp.getSeconds();
	return year + "-" + month.substring(month.length - 2, month.length) + "-"
			+ date.substring(date.length - 2, date.length) + " "
			+ hour.substring(hour.length - 2, hour.length) + ":"
			+ minute.substring(minute.length - 2, minute.length) + ":"
			+ second.substring(second.length - 2, second.length);
}
//定义搜索变量
var searchTimeSt = "";
var searchTimeEn = "";
var searchName = "";
//定义分页变量
var start = 1;//开始
var end = 5;//结束
var count = 0;//一共多少条
var currPage = 1;//当前第几页
var allPage = 0;//一共多少页
var limit = 5;//每页显示多少条
//初始化分页器
$('#myPager').pager({
	page : currPage,
	recTotal : count,
	recPerPage : limit,
});
//初始化
function init() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-log.ajax",
		type : "POST",
		data : {
			"timeSt" : searchTimeSt,
			"timeEn" : searchTimeEn,
			"name" : searchName,
			"start" : start,
			"end" : limit
		},
		dataType : "json",
		success : function(data) {
			//首先清空
			var arr = $(".tr");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			}
			var logList = data.logList;
			var c = data.count;
			if( c == 0 ){
				$('#myPager').data('zui.pager').set(1, 1,limit);
				$("#tb").append($("<tr class='tr' align='center'><td colspan='4'>未搜索到相关数据</td></tr>"));
			}else{
				for (var i = 0; i < logList.length; i++) {
					var $tr = $("<tr class='tr' align='left'></tr>");
					var $td1 = $("<td></td>");
					$td1.html(logList[i].logId);
					var $td2 = $("<td></td>");
					$td2.html(formatUnixtimestamp(new Date(logList[i].logCreateTime)));
					var $td3 = $("<td></td>");
					$td3.html(logList[i].adminName);
					var $td4 = $("<td></td>");
					$td4.html(logList[i].logDesc);
					$tr.append($td1);
					$tr.append($td2);
					$tr.append($td3);
					$tr.append($td4);
					$("#tb").append($tr);
				}
				//显示page
				$('#myPager').data('zui.pager').set(currPage,c,limit);
			}
		},
		error : function(msg) {
			//alert("请联系管理员...");
			zuiAlert("请联系管理员...", 'danger');
		}
	});
}
//初始化
init();
// 当分液器被点击的时候 会走的方法
$('#myPager').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		//获取变化后的页数和变化前的页数
		//				console.log('页码从', oldState.page, '变更为', state.page);
		currPage = state.page;
		//$('#myPager').data('zui.pager').set(currPage, count, limit);
		init();
		//当前页 总数  Limit 
	}
});


//搜索
$("#selectBtn").click(function() {
	searchTimeSt = $("#timeSt").val();
	searchTimeEn = $("#timeEn").val();
	searchName = $("#name").val();
	//alert(searchTimeSt+":"+searchTimeEn+":"+searchDocType+":"+searchDocState);
	if(searchTimeSt>searchTimeEn){
		//alert("截止时间不能小于开始时间！");
		zuiAlert("截止时间不能小于开始时间！", 'danger');
	}else{
		start = 1;
		end = 5;
		currPage = 1;
		count = 0;
		allPage = 0;
		init();
	}	
});