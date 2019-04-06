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
		url : "do-incomeManual.ajax",
		type : "POST",
		data : {
			"offset" : start,
			"limit" : limit
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			//首先清空
			var arr = $(".tr");
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove();
			}
			
			//tb1
			var incomeManualList = data.incomeManualList;
			//获取数组
			if(incomeManualList.length != 0){
				var name = [incomeManualList[0].adminName];
				for(var i = 0; i < incomeManualList.length; i++){
					var ele = incomeManualList[i].adminName;
					if(name.indexOf(ele) == -1) {
						name.push(ele);
					}
				}
				var income = [incomeManualList[0].sumMoney ];
				for(var i = 0; i < incomeManualList.length; i++){
					var ele = incomeManualList[i].sumMoney;
					if(income.indexOf(ele) == -1) {
						income.push(ele);
					}
				}
				
				//图表
				var dom = document.getElementById("main");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
				app.title = '人员管理';
				
				option = {
					color: ['#3398DB'],
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: [{
						type: 'category',
						data: name,
						axisTick: {
							alignWithLabel: true
						}
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
						name: '直接访问',
						type: 'bar',
						barWidth: '60%',
						data: income
					}]
				};;
				if(option && typeof option === "object") {
					myChart.setOption(option, true);
				}
			}else{
				
				//图表
				var dom = document.getElementById("main");
				var myChart = echarts.init(dom);
				var app = {};
				option = null;
				app.title = '人员管理';
				
				option = {
					color: ['#3398DB'],
					tooltip: {
						trigger: 'axis',
						axisPointer: { // 坐标轴指示器，坐标轴触发有效
							type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis: [{
						type: 'category',
						data: [0, 0, 0, 0, 0],
						axisTick: {
							alignWithLabel: true
						}
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
						name: '直接访问',
						type: 'bar',
						barWidth: '60%',
						data: [0, 0, 0, 0, 0]
					}]
				};;
				if(option && typeof option === "object") {
					myChart.setOption(option, true);
				}
			}
			
			
			
			
			/* for (var i = 0; i < incomeManualList.length; i++) {
				var $tb1 = $("#tb1");
				var $tr1 = $("<tr class='tr' align='left'></tr>");
				var $td8 = $("<td></td>");
				$td8.html(incomeManualList[i].adminId);
				var $td9 = $("<td></td>");
				$td9.html(incomeManualList[i].adminName);
				var $td10 = $("<td></td>");
				$td10.html(incomeManualList[i].sumMoney);
				$tr1.append($td8);
				$tr1.append($td9);
				$tr1.append($td10);
				$("#tb1").append($tr1);  
			} */
			//tb
			var queryIncomeManual = data.queryIncomeManual;
			var c = data.count;
			var $tb = $("#tb");
			for (var i = 0; i < queryIncomeManual.length; i++) {
				var $tr = $("<tr class='tr' align='left'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(queryIncomeManual[i].amountLogId);
				var $td2 = $("<td></td>");
				$td2.html(queryIncomeManual[i].adminName);
				var $td3 = $("<td></td>");
				$td3.html(queryIncomeManual[i].amountLogCarnum);
				var $td4 = $("<td></td>");
				$td4.html(queryIncomeManual[i].amountLogMoney);
				var $td5 = $("<td></td>");
				$td5.html(queryIncomeManual[i].amountLogDesc);
				var $td6 = $("<td></td>");
				$td6.html(formatUnixtimestamp(new Date(
						queryIncomeManual[i].amountLogDescCreateTime)));
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
			if (queryIncomeManual.length == 0) {
				alert("暂无数据");
			}
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