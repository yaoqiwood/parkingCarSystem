var tempData = new data();
// 获取分页器实例对象

// =================================== URL Start
// ===========================================//
var url = "ref-roleManager.action";
var pageUrl = "cnt-roleManager.action";
var addUrl = "add-roleManager.action";
var upUrl = "up-roleManager.action";
var upStateUrl = "upState-roleManager.action";
var delUrl = "del-roleManager.action";
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

	this.roleName = "";
	this.roleState = "";

	this.RefreshJSON = function() {
		var JSON = {};
		JSON.roleName = tempData.roleName;
		JSON.roleState = tempData.roleState;
		JSON.CurrentPage = tempData.CurrentPage;
		JSON.Limit = tempData.Limit;
		return JSON;
	};

	this.SearchJSON = function() {
		var JSON = {};
		JSON.roleName = tempData.roleName = $("#roleName").val();
		JSON.roleState = tempData.roleState = $("#roleState").val();
		JSON.CurrentPage = tempData.CurrentPage;
		JSON.Limit = tempData.Limit;
		return JSON;
	};

	this.AddJSON = function() {
		var JSON = {};
		JSON.addRoleName = $("#addRoleName").val();
		return JSON;
	}

	this.UpJSON = function() {
		var JSON = {};
		JSON.upRoleId = $("#upRoleId").val();
		JSON.upRoleName = $("#upRoleName").val();
		return JSON;
	}

	this.UpStateJSON = function(State, Fid) {
		var JSON = {};
		JSON.upState = State;
		JSON.Fid = Fid;
		return JSON;
	}

	this.DelJSON = function(Fid) {
		var JSON = {};
		JSON.Fid = Fid;
		return JSON;
	}
};

// 页码监听
$('#myPager').on('onPageChange', function(e, state, oldState) {
	if (state.page !== oldState.page) {
		tempData.CurrentPage = state.page;
		RefreshTableDataAndPage(url, pageUrl);
	}
});

function noneTableParams() {
	$("#table").append("<tr class = 'table_content'>" + "<td align = 'center' colspan = '10'>未检索到任何数据</td>" + "</tr>")
}

// 表格填写方法
function fillTableBody(param) {
	var state = param.adminRoleState == 0 ? "启用" : "禁用";
	$("#table").append(
					"<tr class = 'table_content' fid = '"
							+ param.adminRoleId
							+ "'>"
							+ "<td>"
							+ param.adminRoleId
							+ "</td>"
							+ "<td>"
							+ param.adminRoleName
							+ "</td>"
							+ "<td>"
							+ (param.adminRoleState == 0 ? "未启用" : "已启用")
							+ "</td>"
							+ "<td>"
							+ formatUnixtimestamp(new Date(param.adminRoleCreateTime))
							+ "</td>"
							+ "<td>"
							+ "<button class='btn btn-sm btn-info' id = 'updateBtn' type='button'><i class = 'icon icon-cog'></i>&nbsp;修改</button> "
							+ "<button class='btn btn-sm btn-warning' type='button'><i class = 'icon icon-remove-circle'></i>&nbsp;"
							+ (state)
							+ "</button>"
							+ "<button class='btn btn-sm btn-danger' id = 'deleteBtn' type='button'><i class = 'icon icon-times'></i>&nbsp;删除</button>"
							+ "<button class='btn btn-sm btn-danger' id = 'deleteBtn' type='button'><i class = 'icon icon-list'></i>&nbsp;配置权限</button></td>"
							+ +"</tr >");
};

//更新对应角色的对应权限
var updateRoleMenu = function() {
$.ajax({
	type : "POST",
	url : "roleMenuInf.action",
	data : {"roleId":$("#updateId").val()},
	success : function(msg) {
		var list = eval("("+msg+")").list;
		var arr = $('i');
		if(list.length > 0){
			for (var i = 0; i < list.length; i++) {
				for (var j = 0; j < arr.length; j++) {
					if($(arr[j]).attr('menuId') == list[i].adminRoleMenuMenuId){
						if(list[i].adminRoleMenuState ==1 ){
							$(arr[j]).addClass('icon-toggle-on');
							$(arr[j]).removeClass('icon-toggle-off');
						}else{
							$(arr[j]).removeClass('icon-toggle-on');
							$(arr[j]).addClass('icon-toggle-off');
						}
					}
				}
			}
		}else{
			for (var i = 0; i < arr.length; i++) {
				$(arr[i]).removeClass('icon-toggle-on');
				$(arr[i]).addClass('icon-toggle-off');
			}
		}
	},
	error : function(param) {
		zuiAlert("发生错误");
	}
});
}

// 监听
function BtnListener() {
	// 添加配置信息
	$("#btnConfirm").click(function() {
		// 增加参数函数
		addParamFunc();
	});

	$("#addBtn").click(function() {
		dispalyOrNot("#addPanelBox");
		dispalyOrNot("#backWhite");
	});

	// 取消添加框按钮
	$("#btnCancel").click(function() {
		dispalyOrNot("#addPanelBox");
		dispalyOrNot("#backWhite");
	});

	// 搜索
	$("#Search_Btn").click(function() {
		tempData.CurrentPage = 1;
		tempData.SearchJSON();
		RefreshTableDataAndPage(url, pageUrl);
	});

	$("#table").click(
			function(event) {
				var target = event.target.parentElement.parentElement;
				var btnName = $(event.target).html().split(";")[1];
				if (btnName == "修改") {
					$("#updatedialog").css("display", "block");
					$(target.children).each(function(index, value) {
								var timeArr = $(value).html().split("-");
								index == 0 ? $("#upRoleId") .val($(value).html()) : "";
								index == 1 ? $("#upRoleName").val($(value).html()) : "";
							});
				} else if (btnName == "禁用" || btnName == "启用") {
					if (confirm("是否要" + btnName)) {
						$.ajax({
							type : "POST",
							url : upStateUrl,
							data : tempData.UpStateJSON(btnName == "禁用" ? "0" : "1", $(target).attr("fid")),
							success : function(response) {
								response = JSON.parse(response);
								alertAddMessage(response);
								dispalyOrNot("#backWhite")
							},
							error : function(param) {
								zuiAlert("发生错误");
							}
						});
					}
				} else if (btnName == "删除") {
					if (confirm("是否要删除？")) {
						$.ajax({
							type : "POST",
							url : delUrl,
							data : tempData.DelJSON($(target).attr("fid")),
							success : function(response) {
								response = JSON.parse(response);
								alertAddMessage(response);
								dispalyOrNot("#backWhite");
							},
							error : function(param) {
								zuiAlert("发生错误");
							}
						});
					}
				} else if (btnName == "配置权限") {
					var lilist = $('li');
					for (var i = 0; i < lilist.length; i++) {
						$(lilist[i]).removeClass('open in');
					}
					$("#configdialog").css("display", "block");
					var roleId= $($(event.target).parent().parent().children()[0]).html().trim();
					var roleName= $($(event.target).parent().parent().children()[1]).html().trim();
					$("#updateName").val(roleName);$("#updateId").val(roleId);
					updateRoleMenu();
				}
			})

	// 修改窗口取消
	$("#upBtnCancel").click(function() {
		dispalyOrNot("#updatedialog");
		dispalyOrNot("#backWhite");
	})

	// 修改窗口确认
	$("#upBtnConfirm").click(function() {
		$.ajax({
			type : "POST",
			url : upUrl,
			data : tempData.UpJSON(),
			success : function(response) {
				response = JSON.parse(response);
				alertAddMessage(response, "addPanelBox");
				if(response.id == 1){
					$("#updatedialog").css("display","none");
				}
			},
			error : function() {
				zuiAlert("发生错误");
			}
		});
	});
}

// 增加参数函数
function addParamFunc() {
	$.ajax({
		type : "POST",
		url : addUrl,
		data : tempData.AddJSON(),
		success : function(response) {
			response = JSON.parse(response);
			alertAddMessage(response, "updatePanelBox");
		},
		error : function(param) {
			zuiAlert("发生错误");
		}
	});
}

// 提示通用
function alertAddMessage(response, str) {
	// 后续用插件代替
	if (response.id == 1) {
		//zuiAlert(response.message);
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
	} else if (response.id == 3) {
		zuiAlert(response.message, 'danger');
	}
}

// 边框加载的方法
var siderLoad = function(ul, arr) {
	for (var i = 0; i < arr.length; i++) {
		var $li = $("<li></li>");
		if (arr[i].menuBeans != null && arr[i].menuBeans.length > 0) {
			var $a = $("<i class='list-toggle icon icon-toggle-off'></i><span>" + arr[i].menuName + "</span><i menuId='"+ arr[i].menuId +"' parentId='"+arr[i].menuParent+"' class='icon icon-toggle-off'></i>");
			$li.append($a);
			var $ul = $("<ul></ul>");
			siderLoad($ul, arr[i].menuBeans);
			$li.append($ul);
		}else{
			var $a = $("<span>" + arr[i].menuName + "</span><i menuId='"+ arr[i].menuId +"' parentId='"+arr[i].menuParent+"' class='icon icon-toggle-off'></i>");
			$li.append($a);
		}
		ul.append($li);
	}
}

// 加载当前菜单信息
$.ajax({
	type : "POST",
	url : "menuInfo.action",
	data : {},
	success : function(msg) {
		var obj = eval("(" + msg + ")");
		siderLoad($(".tree"), obj.list);
	},
	error : function(param) {
		zuiAlert("发生错误");
	}
});

//激活或取消全选的方法
$(".tree").click(function(event){
	if($(event.target).hasClass('icon')){
		var arr = $('#configdialog i');
		if($(event.target).hasClass('icon-toggle-on')){
			$(event.target).removeClass('icon-toggle-on');
			$(event.target).addClass('icon-toggle-off');
			for (var i = 0; i < arr.length; i++) {
				if($(arr[i]).attr('parentId') == $(event.target).attr('menuId')){
					$(arr[i]).removeClass('icon-toggle-on');
					$(arr[i]).addClass('icon-toggle-off');
				}
			}
		}else{
			$(event.target).addClass('icon-toggle-on');
			$(event.target).removeClass('icon-toggle-off');
			for (var i = 0; i < arr.length; i++) {
				if($(arr[i]).attr('menuId') == $(event.target).attr('parentId')){
					$(arr[i]).addClass('icon-toggle-on');
					$(arr[i]).removeClass('icon-toggle-off');
				}
			}
		}
	}
})

//重新加载
$("#repeatRoleMenu").click(function(event){
	updateRoleMenu();
});

//确认修改
$("#commitRoleMenu").click(function(event){
	var arr = $('#configdialog i');
	var list = [];
	for (var i = 0; i < arr.length; i++) {
		if(!$(arr[i]).hasClass('list-toggle')){
			var menuId = $(arr[i]).attr("menuId");
			if($(arr[i]).hasClass('icon-toggle-on')){
				list.push(menuId+"%%"+1);
			}else{
				list.push(menuId+"%%"+0);
			}
		}
	}
	$.ajax({
		type : "POST",
		url : "roleMenuUpdate.action",
		data : {"roleId":$("#updateId").val(),"updateInf":list.join(',')},
		success : function(msg) {
			var obj = eval("("+msg+")");
			if(obj.id == 0){
				$("#configdialog").css("display", "none");
				zuiAlert(obj.message, 'success');
			}else{
				zuiAlert(obj.message, 'danger');
			}
		},
		error : function(param) {
			zuiAlert("发生错误");
		}
	});
});

//清空所有
$("#clearRoleMenu").click(function(event){
	var arr = $('#configdialog i');
	for (var i = 0; i < arr.length; i++) {
		$(arr[i]).removeClass('icon-toggle-on');
		$(arr[i]).addClass('icon-toggle-off');
	}
});

//全选所有
$("#checkRoleMenu").click(function(event){
	var arr = $('#configdialog i');
	for (var i = 0; i < arr.length; i++) {
		$(arr[i]).addClass('icon-toggle-on');
		$(arr[i]).removeClass('icon-toggle-off');
	}
});

//返回
$("#cannelRoleMenu").click(function(event){
	$("#configdialog").css("display", "none");
});

