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
    page: currPage,
    recTotal: count,
    recPerPage: limit,
});
//初始化
function init() {
	start = (currPage - 1) * limit + 1;
	end = currPage * limit;
	$.ajax({
		url : "do-incomeChannel.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			//首先清空
			/* var arr = $(".tr");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			} */
			var arr1 = $(".tr1");
			for (var i = arr1.length - 1; i >= 0; i--) {
				$(arr1[i]).remove();
			}
			//tb1
			var sumTerminal = data.sumTerminal;
			var sumManual = data.sumManual;
			var $sumTerminal = $("#sumTerminal");
			var $sumManual = $("#sumManual");
			$sumTerminal.html(sumTerminal);
			$sumManual.html(sumManual);
			var $tb1 = $("#tb1");
			var $tr1 = $("<tr class='tr' align='left'></tr>");
			var $td8 = $("<td></td>");
			$td8.html(sumTerminal);
			var $td9 = $("<td></td>");
			$td9.html(sumManual);
			$tr1.append($td8);
			$tr1.append($td9);
			$("#tb1").append($tr1);
			
			//图表
			var myChart = echarts.init(document.getElementById('main'),'shine');
			option = {
				legend: {},
				tooltip: {},
				dataset: {
					source: [
						['缴费机', '临时用户收入', '月缴用户收入'],
						['1月数据', 43.3, 85.8],
						['2月数据', 83.1, 73.4],
						['3月数据', sumTerminal, sumManual],
						['4月数据', 72.4, 53.9]
					]
				},
				xAxis: {
					type: 'category'
				},
				yAxis: {},
				// Declare several bar series, each will be mapped
				// to a column of dataset.source by default.
				series: [{
						type: 'bar'
					},
					{
						type: 'bar'
					}
				]
			};
			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
			/* var incomeMonthList = data.incomeMonthList;
			var c = data.count;
			var $tb = $("#tb");
			for (var i = 0; i < incomeMonthList.length; i++) {
				var $tr = $("<tr class='tr' align='left'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(incomeMonthList[i].amountLogId);
				var $td2 = $("<td></td>");
				$td2.html(incomeMonthList[i].carnumRoleId == 1 ? "临时用户" : "月缴用户");
				var $td3 = $("<td></td>");
				$td3.html(incomeMonthList[i].amountLogCarnum);
				var $td4 = $("<td></td>");
				$td4.html(incomeMonthList[i].amountLogMoney);
				var $td5 = $("<td></td>");
				$td5.html(incomeMonthList[i].amountLogDesc);
				var $td6 = $("<td></td>");
				$td6.html(formatUnixtimestamp(new Date(
						incomeMonthList[i].amountLogDescCreateTime)));
				$tr.append($td1);
				$tr.append($td2);
				$tr.append($td3);
				$tr.append($td4);
				$tr.append($td5);
				$tr.append($td6);
				$("#tb").append($tr);
			}
			//显示page
			count = c;
			$('#myPager').data('zui.pager').set(currPage, count, limit);
			if (incomeMonthList.length == 0) {
				alert("暂无数据");
			} */
		},
		error : function(msg) {
			alert("请联系管理员...");
		}
	});
}
init();
//页码监听
$('#myPager').on('onPageChange', function (e, state, oldState) {
	if (state.page !== oldState.page) {
		console.log('页码从', oldState.page, '变更为', state.page);
		//tempData.CurrentPage = state.page;
		currPage = state.page;
		init();
	}
});