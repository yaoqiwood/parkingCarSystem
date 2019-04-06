var tempData = new data();
// 获取分页器实例对象

// =================================== URL Start
// ===========================================//
var url = "ref-menuManager.action";
var pageUrl = "cnt-menuManager.action";
var addUrl = "add-menuManager.action";
var upUrl = "up-menuManager.action";
var upStateUrl = "upState-menuManager.action";
var delUrl = "del-menuManager.action";
// =================================== URL End
// =============================================//

//仅选择日期
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
//页码初始化



// 数据
function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 10; // 行总数

    this.menuName = "";
    this.menuState = "";

    this.RefreshJSON = function () {
        var JSON = {};
        JSON.menuName = tempData.menuName;
        JSON.menuState = tempData.menuState;
        JSON.CurrentPage = tempData.CurrentPage;
        JSON.Limit = tempData.Limit;
        return JSON;
    };

    this.SearchJSON = function () {
        var JSON = {};
        JSON.menuName = tempData.menuName = $("#menuName").val();
        JSON.menuState = tempData.menuState = $("#menuState").val();
        JSON.CurrentPage = tempData.CurrentPage;
        JSON.Limit = tempData.Limit;
        return JSON;
    };

    this.AddJSON = function () {
        var JSON = {};
        JSON.addMenuName = $("#addMenuName").val();
        JSON.addParentID = $("#addParentID").val();
        JSON.addURL = $("#addURL").val();
        return JSON;
    }

    this.UpJSON = function () {
        var JSON = {};
        JSON.upMenuId = $("#upMenuId").val();
        JSON.upMenuName = $("#upMenuName").val();
        JSON.upParentID = $("#upParentID").val();
        JSON.upURL = $("#upURL").val();
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
        // console.log(tempData.Count)
    }
});

function noneTableParams() {
    $("#table").append(
        "<tr class = 'table_content'>" +
        "<td align = 'center' colspan = '7'>未检索到任何数据</td>"
        + "</tr>"
    )
}


// 表格填写方法
function fillTableBody(param) {
    var state = param.menuState == 0 ? "启用" : "禁用";
    $("#table").append(
        "<tr class = 'table_content' fid = '" + param.menuId + "'>" +
        "<td>" + param.menuId + "</td>" +
        "<td>" + param.menuParent + "</td>" +
        "<td>" + param.menuName + "</td>" +
        "<td>" + param.menuUrl + "</td>" +
        "<td>" + (param.menuState == 0 ? "未启用" : "已启用") + "</td>" +
        "<td>" + formatUnixtimestamp(new Date(param.menuUpdateTime)) + "</td>" +
        "<td>" + "<button class='btn btn-sm btn-info' id = 'updateBtn' type='button'><i class = 'icon icon-cog'></i>&nbsp;修改</button> " +
        "<button class='btn btn-sm btn-warning' type='button'><i class = 'icon icon-remove-circle'></i>&nbsp;" + (state) + "</button>"
        + "<button class='btn btn-sm btn-danger' id = 'deleteBtn' type='button'><i class = 'icon icon-times'></i>&nbsp;删除</button>"
        + "</td>" +
        +"</tr >"
    );
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
        $("#CurPageView").html(tempData.CurrentPage);
    });

    $("#table").click(function (event) {
        // console.log(event.target.parentElement.parentElement);
        var target = event.target.parentElement.parentElement;
        // console.log($(target).attr("fid"));
        var btnName = $(event.target).html().split(";")[1];
        if (btnName == "修改") {
            $("#updatePanelBox").css("display", "block");
            $(target.children).each(function (index, value) {
                // var timeArr = $(value).html().split("-");
                // console.log(timeArr);
                index == 0 ? $("#upMenuId").val($(value).html()) : "";
                index == 1 ? $("#upParentID").val($(value).html()) : "";
                index == 2 ? $("#upMenuName").val($(value).html()) : "";
                index == 3 ? $("#upURL").val($(value).html()) : "";
                dispalyOrNot("#backWhite");
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
                        dispalyOrNot("#backWhite");
                    },
                    error: function (param) {
                        // alert("发生错误");
                        zuiAlert('发生错误','danger');
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
                        // alert("发生错误");
                        zuiAlert('发生错误','danger');
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
            },
            error: function () {
                zuiAlert('发生错误','danger');
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
            // alert("发生错误");
            zuiAlert('发生错误','danger');

        }
    });
}



// 提示通用
function alertAddMessage(response, str) {
    // 后续用插件代替
    if (response.id == 1) {
        // alert(response.message);
        // 清空所有数据
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
        // alert(response.message);
        zuiAlert(response.message,'danger');
    } else if (response.id == 3) {
        zuiAlert(response.message,'danger');
    }
}