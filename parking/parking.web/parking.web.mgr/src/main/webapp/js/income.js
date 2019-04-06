//时间控件
	function formatUnixtimestamp(unixtimestamp) {
		var unixtimestamp = new Date(unixtimestamp);
		var year = 1900 + unixtimestamp.getYear();
		var month = "0" + (unixtimestamp.getMonth() + 1);
		var date = "0" + unixtimestamp.getDate();
		var hour = "0" + unixtimestamp.getHours();
		var minute = "0" + unixtimestamp.getMinutes();
		var second = "0" + unixtimestamp.getSeconds();
		return year + "-" + month.substring(month.length - 2, month.length)
				+ "-" + date.substring(date.length - 2, date.length) + " "
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
			url : "do-income.ajax",
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
				/* var arr1 = $(".tr1");
				for (var i = arr1.length - 1; i >= 0; i--) {
					$(arr1[i]).remove();
				} */
				//tb1
				var sumAmount = data.sumAmount;
				var countAmount = data.countAmount;
				var $sumAmount = $("#sumAmount");
				var $countAmount = $("#countAmount");
				$sumAmount.html(sumAmount);
				$countAmount.html(countAmount);
				/* var $tb1 = $("#tb1");
				var $tr1 = $("<tr class='tr' align='center'></tr>");
				var $td8 = $("<td></td>");
				$td8.html(sumAmount);
				var $td9 = $("<td></td>");
				$td9.html(countAmount);
				$tr1.append($td8);
				$tr1.append($td9);
				$("#tb1").append($tr1); */
				//tb
				var incomeList = data.incomeList;
				var c = data.count;
				var $tb = $("#tb");
				if( c == 0 ){
					$('#myPager').data('zui.pager').set(1, 1,limit);
					$("#tb").append($("<tr class='tr' align='center'><td colspan='5'>未搜索到相关数据</td></tr>"));
					
					//图表
					var myChart = echarts.init(document.getElementById('main'), 'shine');
					var app = {};
					option = null;
					var posList = [
						'left', 'right', 'top', 'bottom',
						'inside',
						'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
						'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
					];

					app.config = {
						rotate: 90,
						align: 'left',
						verticalAlign: 'middle',
						position: 'insideBottom',
						distance: 15,
						onChange: function() {
							var labelOption = {
								normal: {
									rotate: app.config.rotate,
									align: app.config.align,
									verticalAlign: app.config.verticalAlign,
									position: app.config.position,
									distance: app.config.distance
								}
							};
							myChart.setOption({
								series: [{
									label: labelOption
								}, {
									label: labelOption
								}, {
									label: labelOption
								}, {
									label: labelOption
								}]
							});
						}
					};

					var labelOption = {
						normal: {
							show: true,
							position: app.config.position,
							distance: app.config.distance,
							align: app.config.align,
							verticalAlign: app.config.verticalAlign,
							rotate: app.config.rotate,
							formatter: '{c}  {name|{a}}',
							fontSize: 16,
							rich: {
								name: {
									textBorderColor: '#fff'
								}
							}
						}
					};

					option = {
						color: ['#F1A325', '#3280FC', '#03B8CF', '#EA644A'],
						tooltip: {
							trigger: 'axis',
							axisPointer: {
								type: 'shadow'
							}
						},
						legend: {
							data: ['停车场总收入', '总停车数', 'Desert', 'Wetland']
						},
						toolbox: {
							show: true,
							orient: 'vertical',
							left: 'right',
							top: 'center',
							feature: {
								mark: {
									show: true
								},
								dataView: {
									show: true,
									readOnly: false
								},
								magicType: {
									show: true,
									type: ['line', 'bar', 'stack', 'tiled']
								},
								restore: {
									show: true
								},
								saveAsImage: {
									show: true
								}
							}
						},
						calculable: true,
						xAxis: [{
							type: 'category',
							axisTick: {
								show: false
							},
							data: ['1月', '2月', '3月', '4月']
						}],
						yAxis: [{
							type: 'value'
						}],
						series: [{
								name: '停车场总收入',
								type: 'bar',
								barGap: 0,
								label: labelOption,
								data: [0, 0, 0, 0]
							},
							{
								name: '总停车数',
								type: 'bar',
								label: labelOption,
								data: [0, 0, 0, 0]
							}
						]
					};;
					if(option && typeof option === "object") {
						myChart.setOption(option, true);
					}
				}else{
					for (var i = 0; i < incomeList.length; i++) {
						var $tr = $("<tr class='tr' align='center'></tr>");
						var $td1 = $("<td></td>");
						$td1.html(incomeList[i].amountLogId);
						var $td2 = $("<td></td>");
						$td2.html(incomeList[i].amountLogCarnum);
						var $td3 = $("<td></td>");
						$td3.html(incomeList[i].amountLogMoney);
						var $td4 = $("<td></td>");
						$td4.html(incomeList[i].amountLogDesc);
						var $td5 = $("<td></td>");
						$td5.html(formatUnixtimestamp(new Date(
								incomeList[i].amountLogDescCreateTime)));
						$tr.append($td1);
						$tr.append($td2);
						$tr.append($td3);
						$tr.append($td4);
						$tr.append($td5);
						$("#tb").append($tr);
					}
					//图表
					var myChart = echarts.init(document.getElementById('main'), 'shine');
					var app = {};
					option = null;
					var posList = [
						'left', 'right', 'top', 'bottom',
						'inside',
						'insideTop', 'insideLeft', 'insideRight', 'insideBottom',
						'insideTopLeft', 'insideTopRight', 'insideBottomLeft', 'insideBottomRight'
					];

					app.config = {
						rotate: 90,
						align: 'left',
						verticalAlign: 'middle',
						position: 'insideBottom',
						distance: 15,
						onChange: function() {
							var labelOption = {
								normal: {
									rotate: app.config.rotate,
									align: app.config.align,
									verticalAlign: app.config.verticalAlign,
									position: app.config.position,
									distance: app.config.distance
								}
							};
							myChart.setOption({
								series: [{
									label: labelOption
								}, {
									label: labelOption
								}, {
									label: labelOption
								}, {
									label: labelOption
								}]
							});
						}
					};

					var labelOption = {
						normal: {
							show: true,
							position: app.config.position,
							distance: app.config.distance,
							align: app.config.align,
							verticalAlign: app.config.verticalAlign,
							rotate: app.config.rotate,
							formatter: '{c}  {name|{a}}',
							fontSize: 16,
							rich: {
								name: {
									textBorderColor: '#fff'
								}
							}
						}
					};

					option = {
						color: ['#F1A325', '#3280FC', '#03B8CF', '#EA644A'],
						tooltip: {
							trigger: 'axis',
							axisPointer: {
								type: 'shadow'
							}
						},
						legend: {
							data: ['停车场总收入', '总停车数', 'Desert', 'Wetland']
						},
						toolbox: {
							show: true,
							orient: 'vertical',
							left: 'right',
							top: 'center',
							feature: {
								mark: {
									show: true
								},
								dataView: {
									show: true,
									readOnly: false
								},
								magicType: {
									show: true,
									type: ['line', 'bar', 'stack', 'tiled']
								},
								restore: {
									show: true
								},
								saveAsImage: {
									show: true
								}
							}
						},
						calculable: true,
						xAxis: [{
							type: 'category',
							axisTick: {
								show: false
							},
							data: ['1月', '2月', '3月', '4月']
						}],
						yAxis: [{
							type: 'value'
						}],
						series: [{
								name: '停车场总收入',
								type: 'bar',
								barGap: 0,
								label: labelOption,
								data: [320, 332, sumAmount, 334]
							},
							{
								name: '总停车数',
								type: 'bar',
								label: labelOption,
								data: [22, 18, countAmount, 23]
							}
						]
					};;
					if(option && typeof option === "object") {
						myChart.setOption(option, true);
					}
					//显示page
					count = c;
					$('#myPager').data('zui.pager').set(currPage, count, limit);
				}
					//显示page
					//count = c;
					/*if (incomeList.length == 0) {
						alert("暂无数据");
					}*/
			},
			error : function(msg) {
				alert("请联系管理员...");
			}
		});
	}
	//初始化
	init();
	//页码监听
	$('#myPager').on('onPageChange', function(e, state, oldState) {
		if (state.page !== oldState.page) {
			console.log('页码从', oldState.page, '变更为', state.page);
			//tempData.CurrentPage = state.page;
			currPage = state.page;
			init();
		}
	});