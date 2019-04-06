var tempData = new data();
// 获取分页器实例对象

// =================================== URL Start
// ===========================================//
var url = "ref-configure.action";
var pageUrl = "cnt-configure.action";
var addUrl = "add-configure.action";
var upUrl = "up-configure.action";
var upStateUrl = "upState-configure.action";
var delUrl = "del-configure.action";
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


// 数据
function data() {
	this.CurrentPage = 1;
	this.TotalPage = 0;
	this.Limit = 5;
	this.Count = 10; // 行总数

	this.configureName = "";

	this.RefreshJSON = function () {
		var JSON = {};
		JSON.configureName = tempData.configureName;
		JSON.CurrentPage = tempData.CurrentPage;
		JSON.Limit = tempData.Limit;
		return JSON;
	};

	this.SearchJSON = function () {
		var JSON = {};
		JSON.configureName = tempData.configureName = $("#configureName").val();
		JSON.CurrentPage = tempData.CurrentPage;
		JSON.Limit = tempData.Limit;
		return JSON;
	};

	this.AddJSON = function () {
		var JSON = {};
		JSON.addConfigureName = $("#addConfigureName").val();
		JSON.addConfigureValue = $("#addConfigureValue").val();
		return JSON;
	}

	this.UpJSON = function () {
		var JSON = {};
		JSON.upConfigID = $("#upConfigID").val();
		JSON.upConfigName = $("#upConfigName").val();
		JSON.upConfigParamter = $("#upConfigParamter").val();
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
		console.log('页码从', oldState.page, '变更为', state.page);
		tempData.CurrentPage = state.page;
		RefreshTableDataAndPage(url, pageUrl);
	}
});

function noneTableParams() {
    $("#table").append(
        "<tr class = 'table_content'>" +
        "<td align = 'center' colspan = '10'>未检索到任何数据</td>"
        +"</tr>"
    )
}

// 表格填写方法
function fillTableBody(param) {
	var state = param.pcfState == 0 ? "启用" : "禁用";
	$("#table").append(
		"<tr class = 'table_content' fid = '" + param.pcfId + "'>" + "<td>" + param.pcfId + "</td>" + "<td>" + param.pcfName + "</td>" + "<td>" + param.pcfParameter + "</td>"
		+ "<td>" + (param.pcfState == 0 ? "未启用" : "已启用") + "</td>" + "<td>" + formatUnixtimestamp(new Date(param.pcfCreateTime)) + "</td>" 
		+"<td>" + "<button class='btn btn-sm btn-info' id = 'updateBtn' type='button'><i class = 'icon icon-cog'></i>&nbsp;修改</button> " 
        +"<button class='btn btn-sm btn-warning' type='button'><i class = 'icon icon-remove-circle'></i>&nbsp;" + (state) + "</button>"
        + "<button class='btn btn-sm btn-danger' id = 'deleteBtn' type='button'><i class = 'icon icon-times'></i>&nbsp;删除</button>"
        + "</td>"  +"</tr >");
};

// 监听
function BtnListener() {
	// 添加配置信息
	$("#btnConfirm").click(function () {
		// 增加参数函数
		addParamFunc();
	});

	$("#addBtn").click(function () {
		dispalyOrNot("#addPanelBox");
		dispalyOrNot("#backWhite");
	});

	// 取消添加框按钮
	$("#btnCancel").click(function () {
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
		// console.log(event.target.parentElement.parentElement);
		var target = event.target.parentElement.parentElement;
		// console.log($(target).attr("fid"));
		var btnName = $(event.target).html().split(";")[1];
		if (btnName == "修改") {
			$("#updatePanelBox").css("display", "block");
			dispalyOrNot("#backWhite");
			$(target.children).each(function (index, value) {
				index == 0 ? $("#upConfigID").val($(value).html()) : "";
				index == 1 ? $("#upConfigName").val($(value).html()) : "";
				index == 2 ? $("#upConfigParamter").val($(value).html()) : "";
			});
		}

		if (btnName == "禁用" || btnName == "启用") {
			if (confirm("是否要" + btnName)) {
				$.ajax({
					type: "POST",
					url: upStateUrl,
					data: tempData.UpStateJSON(btnName == "禁用" ? "0" : "1", $(target).attr("fid")),
					success: function (response) {
						response = JSON.parse(response);
						alertAddMessage(response);
						// dispalyOrNot("#backWhite");
					},
					error: function (param) {
						// alert("发生错误");
						zuiAlert("发生错误", 'danger');
					}
				});
			}
		}
		if (btnName == "删除") {
			if (confirm("是否要删除？")) {
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
						zuiAlert("发生错误", 'danger');
					}
				});
			}
		}
	})

	// 修改窗口取消
	$("#upBtnCancel").click(function () {
		dispalyOrNot("#updatePanelBox");
		dispalyOrNot("#backWhite");
	})

	// 修改窗口确认
	$("#upBtnConfirm").click(function () {
		$.ajax({
			type: "POST",
			url: upUrl,
			data: tempData.UpJSON(),
			success: function (response) {
				response = JSON.parse(response);
				alertAddMessage(response, "addPanelBox");
				dispalyOrNot("#backWhite");
			},
			error: function () {
				// alert("发生错误");
				zuiAlert("发生错误", 'danger');
			}
		});
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
			alert("发生错误");
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
		// 隐藏对话框
		$("#updatePanelBox").css("display", "none");
		$("#addPanelBox").css("display", "none");
		dispalyOrNot("#backWhite");
	} else if (response.id == 0) {
		zuiAlert(response.message, 'danger');
		// alert(response.message);
	} else if (response.id == 3) {
		// alert(response.message);
		zuiAlert(response.message, 'danger');
	}
}