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
		url : "do-incomeProduct.ajax",
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
			var monthProduct = data.monthProduct;
			var seasonProduct = data.seasonProduct;
			var halfyearProduct = data.halfyearProduct;
			var yearProduct = data.yearProduct;
			var $monthProduct = $("#monthProduct");
			var $seasonProduct = $("#seasonProduct");
			var $halfyearProduct = $("#halfyearProduct");
			var $yearProduct = $("#yearProduct");
			$monthProduct.html(monthProduct);
			$seasonProduct.html(seasonProduct);
			$halfyearProduct.html(halfyearProduct);
			$yearProduct.html(yearProduct);
			
			
			var incomeProductList = data.incomeProductList;
			var c = data.count;
			var $tb = $("#tb");
			for (var i = 0; i < incomeProductList.length; i++) {
				var $tr = $("<tr class='tr' align='center'></tr>");
				var $td1 = $("<td></td>");
				$td1.html(incomeProductList[i].carServiceId);
				var $td2 = $("<td></td>");
				$td2.html(incomeProductList[i].carNum);
				var $td3 = $("<td></td>");
				$td3.html(incomeProductList[i].monthProduct);
				var $td4 = $("<td></td>");
				$td4.html(incomeProductList[i].monthProductMonth);
				var $td5 = $("<td></td>");
				$td5.html(incomeProductList[i].monthProductMoney);
				var $td6 = $("<td></td>");
				$td6.html(formatUnixtimestamp(new Date(
						incomeProductList[i].carServiceCreateTime)));
				$tr.append($td1);
				$tr.append($td2);
				$tr.append($td3);
				$tr.append($td4);
				$tr.append($td5);
				$tr.append($td6);
				$("#tb").append($tr);
			}
			var myChart = echarts.init(document.getElementById('main'),'shine');
			//
			option = {
				title: {
					text: '月缴产品统计',
					subtext: '',
					x: 'center'
				},
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
					orient: 'vertical',
					left: 'left',
					data: ['包月产品收入', '季度产品收入', '半年产品收入', '年度产品收入']
				},
				series: [{
					name: '产品收入',
					type: 'pie',
					radius: '55%',
					center: ['50%', '60%'],
					data: [{
							value: yearProduct,
							name: '年度产品收入'
						},
						{
							value: seasonProduct,
							name: '季度产品收入'
						},
						{
							value: monthProduct,
							name: '包月产品收入'
						},
						{
							value: halfyearProduct,
							name: '半年产品收入'
						}
					],
					itemStyle: {
						emphasis: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
			
			//显示page
			count = c;
			$('#myPager').data('zui.pager').set(currPage, count, limit);
			if (incomeProductList.length == 0) {
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
