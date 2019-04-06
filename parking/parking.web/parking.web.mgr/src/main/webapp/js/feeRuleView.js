var tempData = new data();
// 获取分页器实例对象

// =================================== URL Start
// ===========================================//
var url = "ref-feeRuleView.action";
var pageUrl = "cnt-feeRuleView.action";
var upCInfUrl = "upCI-feeRuleView.action";
var viewTaddUrl = "VTadd-feeRuleView.action";
var addUrl = "add-feeRuleView.action";
var upUrl = "up-feeRuleView.action";
var upStateUrl = "upState-feeRuleView.action";
var delUrl = "del-feeRuleView.action";
// =================================== URL End
// =============================================//

// 仅选择日期
initFormDate(".form-date");
// 选择时间
initTime(".form-time");
// 日期+时间
initDateTime(".form-datetime");
// 页码初始化
initPager("#myPager");
// 按键监听
BtnListener();
// 刷新分页器总页
RefreshTableDataAndPage(url, pageUrl);
// 刷新最大值
tempData.maxTime = viewMaxTime();

// 数据
function data() {
	this.CurrentPage = 1;
	this.TotalPage = 0;
	this.Limit = 5;
	this.Count = 10; // 行总数

	this.ruleMoney = "";
	this.ruleBeginTime = "";
	this.ruleEndTime = "";

	this.maxTime = "";

	this.RefreshJSON = function () {
		var JSON = {};
		JSON.ruleMoney = tempData.ruleMoney;
		JSON.CurrentPage = tempData.CurrentPage;
		JSON.Limit = tempData.Limit;
		return JSON;
	};

	this.SearchJSON = function () {
		var JSON = {};
		JSON.ruleMoney = tempData.ruleMoney = $("#ruleMoney").val();
		JSON.CurrentPage = tempData.CurrentPage;
		JSON.Limit = tempData.Limit;
		return JSON;
	};

	this.AddJSON = function () {
		var JSON = {};
		JSON.addTimeLapE = $("#addTimeLapE").val();
		JSON.ruleHourMoney = $("#ruleHourMoney").val();
		return JSON;
	}

	this.UpJSON = function () {
		var JSON = {};
		JSON.upRuleID = $("#upRuleID").val();
		JSON.upTimeLapE = $("#upTimeLapE").val();
		JSON.upRuleMoney = $("#upRuleMoney").val();
		return JSON;
	}

	this.UpStateJSON = function (State, Fid) {
		var JSON = {};
		JSON.upState = State;
		JSON.Fid = Fid;
		return JSON;
	}

	this.DelJSON = function (Fid) {
		var JSON = {};
		JSON.Fid = Fid;
		return JSON;
	}
};

// 页码监听
$('#myPager').on('onPageChange', function (e, state, oldState) {
	if (state.page !== oldState.page) {
		tempData.CurrentPage = state.page;
		RefreshTableDataAndPage(url, pageUrl);
	}
});

function noneTableParams() {
	$("#table").append(
		"<tr class = 'table_content'>" +
		"<td align = 'center' colspan = '6'>未检索到任何数据</td>"
		+ "</tr>"
	)
}


// 表格填写方法
function fillTableBody(param) {
	var state = param.feeRuleState == 0 ? "启用" : "禁用";
	var tempTimeS = (parseInt(param.feeRuleTime.split("-")[0]) / 60 / 60);
	var tempTimeE = (parseInt(param.feeRuleTime.split("-")[1]) / 60 / 60);
	var tempState = param.feeRuleTime.split("-")[1] != tempData.maxTime ? "disabled" : "";

	$("#tbody").append(
		"<tr class = 'table_content' fid = '" + param.feeRuleId + "'>" +
		"<td>" + param.feeRuleId + "</td>" +
		"<td>" + (tempTimeS + "-" + tempTimeE) + "</td>" +
		"<td>" + param.feeRuleMoney + "</td>" +
		"<td>" + (param.feeRuleState == 0 ? "未启用" : "已启用") + "</td>" +
		"<td>" + formatUnixtimestamp(new Date(param.feeRuleCreateTime)) + "</td>" +
		"<td>" + "<button " + (tempState) + " class='btn btn-sm ' id = 'updateBtn' type='button'><i class = 'icon icon-cog'></i>&nbsp;修改</button> " +
		"<button class='btn btn-sm ' type='button'><i class = 'icon icon-remove-circle'></i>&nbsp;" + (state) + "</button>"
		+ "<button class='btn btn-sm ' id = 'deleteBtn' type='button'><i class = 'icon icon-times'></i>&nbsp;删除</button>"
		+ "</td>" +
		+"</tr >"
	);
};

function viewMaxTime() {
	var max;
	$.ajax({
		type: "POST",
		url: viewTaddUrl,
		async: false,
		success: function (response) {
			var json = JSON.parse(response);
			max = json.max;
		}
	});
	return max;
}

// 监听
function BtnListener() {
	// 添加配置信息
	$("#btnConfirm").click(function () {
	    if(isNum($("#addTimeLapE").val())){
	        if($("#addTimeLapE").val().length<3){
	            if(isNum($("#ruleHourMoney").val())){
	                if($("#ruleHourMoney").val().length<5){
	                 // 增加参数函数
	                    addParamFunc();
	                }else{
	                    zuiAlert('金额不能超过5位数','danger');
	                }
	            }else{
	                zuiAlert('金额只能输入正整数','danger');
	            }
	        }else{
	            zuiAlert('小时数不能超过3位数','danger');
	        }
	    }else{
	        zuiAlert('小时数只能输入正整数','danger');
	    }
		
	});

	$("#addBtn").click(function () {
		dispalyOrNot("#addPanelBox");
		$.ajax({
			type: "POST",
			url: viewTaddUrl,
			success: function (response) {
				var json = JSON.parse(response);
				$("#addTimeLapS").val(parseInt(json.max / 60 / 60));
			},
			error: function (param) {
			}
		});
	});

	// 取消添加框按钮
	$("#btnCancel").click(function () {
	    emptyClassName(".form-control");
		dispalyOrNot("#addPanelBox");
		dispalyOrNot("#backWhite");
	});

	// 搜索
	$("#Search_Btn").click(function () {
		tempData.CurrentPage = 1;
		tempData.SearchJSON();
		RefreshTableDataAndPage(url, pageUrl);
	});

	$("#table").click(function (event) {
		var target = $(event.target).parent().parent();
		var btnName = $(event.target).text().trim();
		if (btnName == "修改") {
		    layer.confirm("是否要" + btnName, function (index) {
		        $("#updatePanelBox").css("display", "block");
	            $.ajax({
	                type: "POST",
	                url: upCInfUrl,
	                data: { "feeRuleId": $(target).attr("fid") },
	                success: function (response) {
	                    var msg = JSON.parse(response);
	                    $("#upRuleID").val(msg.feeRuleId);
	                    $("#upTimeLapS").val(parseInt(msg.feeRuleTime.split("-")[0]) / 60 / 60);
	                    $("#upTimeLapE").val(parseInt(msg.feeRuleTime.split("-")[1]) / 60 / 60);
	                    $("#upRuleMoney").val(msg.feeRuleMoney);
	                },
	                error: function (param) {
	                    zuiAlert("发生错误", "danger");
	                }
	            });
		        layer.close(index);
		    });
			
		}

		if (btnName == "禁用" || btnName == "启用") {
		    layer.confirm("是否要" + btnName, function (index) {
		        $.ajax({
                    type: "POST",
                    url: upStateUrl,
                    data: tempData.UpStateJSON(btnName == "禁用" ? "0" : "1",
                        $(target).attr("fid")),
                    success: function (response) {
                        response = JSON.parse(response);
                        alertAddMessage(response);
                    },
                    error: function (param) {
                        zuiAlert("发生错误", "danger");
                    }
                });
                layer.close(index);
            });
		}
		if (btnName == "删除") {
		    layer.confirm("是否要" + btnName, function (index) {
		        $.ajax({
                    type: "POST",
                    url: delUrl,
                    data: tempData.DelJSON($(target).attr("fid")),
                    success: function (response) {
                        response = JSON.parse(response);
                        alertAddMessage(response);
                        dispalyOrNot("#backWhite");
                    },
                    error: function (param) {
                        zuiAlert("发生错误", "danger");
                    }
                });
		        layer.close(index);
		    });
		}
	})

	// 修改窗口取消
	$("#upBtnCancel").click(function () {
		dispalyOrNot("#updatePanelBox");
		dispalyOrNot("#backWhite");
	})

	// 修改窗口确认
	$("#upBtnConfirm").click(function () {
	    if(isNum($("#upTimeLapE").val())){
            if($("#upTimeLapE").val().length<3){
                if(isNum($("#upRuleMoney").val())){
                    if($("#upRuleMoney").val().length<5){
                        $.ajax({
                            type: "POST",
                            url: upUrl,
                            data: tempData.UpJSON(),
                            success: function (response) {
                                response = JSON.parse(response);
                                alertAddMessage(response, "addPanelBox");
                            },
                            error: function () {
                                zuiAlert("发生错误", "danger");
                            }
                        });
                    }else{
                        zuiAlert('金额不能超过5位数','danger');
                    }
                }else{
                    zuiAlert('金额只能输入正整数','danger');
                }
            }else{
                zuiAlert('小时数不能超过3位数','danger');
            }
        }else{
            zuiAlert('小时数只能输入正整数','danger');
        }
	});
}

// 增加参数函数
function addParamFunc() {
	$.ajax({
		type: "POST",
		url: addUrl,
		data: tempData.AddJSON(),
		success: function (response) {
			response = JSON.parse(response);
			alertAddMessage(response, "updatePanelBox");
		},
		error: function (param) {
		    zuiAlert("发生错误", "danger");
		}
	});
}


// 提示通用
function alertAddMessage(response, str) {
	// 后续用插件代替
	if (response.id == 1) {
		// alert(response.message);
		emptyClassName(".form-control");
		// 搜索参数清空
		tempData.SearchJSON();
		zuiAlert(response.message, 'success');
		tempData.CurrentPage = 1;
		RefreshTableDataAndPage(url, pageUrl);
		tempData.maxTime = viewMaxTime();
		// 隐藏对话框
		$("#updatePanelBox").css("display", "none");
		$("#addPanelBox").css("display", "none");
		dispalyOrNot("#backWhite");
	} else if (response.id == 0) {
		zuiAlert(response.message, 'success');
	} else if (response.id == 3) {
		zuiAlert(response.message, 'danger');
	}
	
	
}
//只允许正整数的方法
function isNum(vehicleNumber) {
    var result = false;
    var express = /^[1-9]\d*$/;
    result = express.test(vehicleNumber);
    return result;
}