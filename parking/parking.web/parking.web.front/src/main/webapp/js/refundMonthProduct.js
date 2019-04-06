var tempData = new data();
// 获取分页器实例对象

// 仅选择日期
initFormDate(".form-date");
// 选择时间
initTime(".form-time");
// 日期+时间
initDateTime(".form-datetime");
// 页码初始化
initPager("#myPager");

//数据
function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 10; // 行总数
    // 定义搜索变量
    this.searchName = "";
};

function init() {
	$
			.ajax({
				type : "POST",
				url : "carServicePage.action",
				data : {
					"carNum" : tempData.searchName,
					"rowPage" : tempData.Limit,
					"pageCount" : tempData.CurrentPage
				},
				dataType : "json",
				success : function(msg) {
					var arr = $(".tr");
					for (var i = arr.length - 1; i >= 0; i--) {
						$(arr[i]).remove();
					}
					// 添加数据
					var serList = msg.list;
					var num = msg.count;
					if(num>0){
					    for (var i = 0; i < serList.length; i++) {
	                        var $tr = $("<tr class = 'tr' ></tr>");
	                        var $td1 = $("<td></td>").html(serList[i].carServiceId);
	                        var $td2 = $("<td></td>").html(serList[i].monthProduct);
	                        if (serList[i].carServiceState == 1) {
	                            var $td3 = $("<td></td>").html("正在使用中");
	                        } else if (serList[i].carServiceState == 2) {
	                            var $td3 = $("<td></td>").html("未使用");
	                        } else if (serList[i].carServiceState == 3) {
	                            var $td3 = $("<td></td>").html("已退费");
	                        } else {
	                            var $td3 = $("<td></td>").html("已过期");
	                        }
	                        var $td4 = $("<td></td>").html(
	                                formatUnixtimestamp(new Date(
	                                        serList[i].carServiceCreateTime)));
	                        var $td5 = $("<td></td>");
	                        $refbtn = $("<input class = 'btn btn-danger rightSpace' value = '退费'   type = 'button' />");
	                        $refbtn.attr("ser_id", serList[i].carServiceId);
	                        $td5.append($refbtn);
	                        $tr.append($td1);
	                        $tr.append($td2);
	                        $tr.append($td3);
	                        $tr.append($td4);
	                        $tr.append($td5);
	                        $("#table").append($tr);
	                    }
	                    tempData.Count = parseInt(num);
	                    refPager('#myPager');
					}else{
					    var $tr = $("<tr class = 'tr'><td colspan='5'>未搜索到相关数据</td></tr>");
                        $("#table").append($tr);
                        $('#myPager').data('zui.pager').set(1,1,tempData.Limit);
					}
					
				},
				error : function(msg) {
					zuiAlert("请联系管理员。。。",'danger');
				}
			});
}

//页码监听
$('#myPager').on('onPageChange', function (e, state, oldState) {
    if (state.page !== oldState.page) {
        console.log('页码从', oldState.page, '变更为', state.page);
        tempData.CurrentPage = state.page;
        init();
    }
});

init();

// 查询按钮监听
$("#selectBtn").click(function() {
	tempData.searchName = $("#carNum").val();
	if($("#carNum").val()==""){
	    zuiAlert("请输入车牌号",'danger');
	}else{
	    if (isVehicleNumber($("#carNum").val())) {
	        tempData.CurrentPage = 1;
	        init();
	    }else{
	        zuiAlert("请输入正确车牌号格式", 'danger');
	    }
	}
});
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

// 退费弹窗中的返回按钮监听
$("#addcancel").click(function() {
	$("#adddialog").css("display", "none");
});

// 表里面的按钮监听
$("#table").click(function(event) {
	var $tar = $(event.target);
	var arr = $tar.parent().parent().children();
	if ($tar.val() == "退费") {
	    layer.confirm('您确定要退费么？', function (index) {
	        var $ser_id = $tar.attr("ser_id");
            $.ajax({
                type : "POST",
                url : "refundMonthProduct.action",
                data : {
                    "ser_id" : $ser_id
                },
                dataType : "json",
                success : function(msg) {
                    if (msg.type == 1) {
                        $("#adddialog").css("display", "block");
                        $("#money").val(msg.money);
                        tempData.CurrentPage = 1;
                        init();
                    } else {
                        layer.alert(msg.message);
                    }
                },
                error : function(msg) {
                    layer.alert("请联系管理员。。。");
                }
            });
	        layer.close(index);
	    });
		
	}
});

//判断是否是车牌号的方法
function isVehicleNumber(vehicleNumber) {
    var result = false;
    if (vehicleNumber.length == 7) {
        var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        result = express.test(vehicleNumber);
    }
    return result;
}