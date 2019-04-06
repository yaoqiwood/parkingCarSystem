var tempData = new data();
// 获取分页器实例对象

// 仅选择日期
initFormDate(".form-date");
// 选择时间
initTime(".form-time");
// 日期+时间
initDateTime(".form-datetime");
// 页码初始化
initPager("#daymyPager");

// 数据
function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 10; // 行总数
    // 定义搜索变量
    this.searchStartTime = "";
    this.searchEndTime = "";
};
dayAccount();
function dayInit() {
    $
            .ajax({
                type : "POST",
                url : "dayCountPage.action",
                data : {
                    "startTime" : tempData.searchStartTime,
                    "endTime" : tempData.searchEndTime,
                    "rowPage" : tempData.Limit,
                    "pageCount" : tempData.CurrentPage
                },
                dataType : "json",
                success : function (msg) {
                    var arr = $(".dayTr");
                    for (var i = arr.length - 1; i >= 0; i--) {
                        $(arr[i]).remove();
                    }
                    // 添加数据
                    var countList = msg.list;
                    var num = msg.count;
                    if (num > 0) {
                        for (var i = 0; i < countList.length; i++) {
                            var $tr = $("<tr class = 'dayTr' ></tr>");
                            var $td1 = $("<td></td>").html(
                                    countList[i].dayCountId);
                            var $td2 = $("<td></td>").html(
                                    formatUnixtimestamp(new Date(
                                            countList[i].dayCountTime)));
                            var $td3 = $("<td></td>").html(
                                    countList[i].dayCountMoney);
                            var $td4 = $("<td></td>").html(
                                    formatUnixtimestamp(new Date(
                                            countList[i].dayCountCreateTime)));
                            $tr.append($td1);
                            $tr.append($td2);
                            $tr.append($td3);
                            $tr.append($td4);
                            $("#dayTable").append($tr);
                        }
                        tempData.Count = parseInt(num);
                        refPager('#daymyPager');
                    } else {
                        var $tr = $("<tr class = 'dayTr'><td colspan='4'>未搜索到相关数据</td></tr>");
                        $("#dayTable").append($tr);
                        $('#myPager').data('zui.pager').set(1, 1,
                                tempData.Limit);
                    }

                },
                error : function (msg) {
                    zuiAlert("请联系管理员。。。", 'danger');
                }
            });
}

// 页码监听
$('#daymyPager').on('onPageChange', function (e, state, oldState) {
    if (state.page !== oldState.page) {
        console.log('页码从', oldState.page, '变更为', state.page);
        tempData.CurrentPage = state.page;
        dayInit();
    }
});

dayInit();

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

// 搜索按钮监听
$("#selBtn")
        .click(
                function () {
                    tempData.searchStartTime = $("#startTime").val();
                    tempData.searchEndTime = $("#endTime").val();
                    if ($("#startTime").val() == ""
                            && $("#endTime").val() != ""
                            || $("#startTime").val() != ""
                            && $("#endTime").val() == "") {
                        zuiAlert("搜索时间区间不全", 'danger');
                    } else if ($("#startTime").val() == ""
                            && $("#endTime").val() == "") {
                        zuiAlert("未输入搜索时间区间，自动帮您搜索所有数据", 'success');
                        tempData.CurrentPage = 1;
                        dayInit();
                    } else{
                        if($("#startTime").val()>=$("#endTime").val()){
                            zuiAlert("输入起始时间应小于结束时间", 'danger');
                        }else{
                            tempData.CurrentPage = 1;
                            dayInit();
                        }
                    }

                });

// 全部显示按钮监听
$("#showAll").click(function () {
    tempData.searchStartTime = "";
    tempData.searchEndTime = "";
    tempData.CurrentPage = 1;
    dayInit();
});

function dayAccount() {
    $.ajax({
        type : "POST",
        url : "addDayCount.action",
        dataType : "json",
        success : function (msg) {
            if (msg.type == 1) {
                if (confirm(msg.message)) {
                    automaticDayAccount();
                }
            }
        },
        error : function (msg) {
            zuiAlert("请联系管理员。。。", 'danger');
        }
    });
}

function automaticDayAccount() {
    $.ajax({
        type : "POST",
        url : "automaticDayAccount.action",
        dataType : "json",
        success : function (msg) {
            if (msg.type == 1) {
                zuiAlert(msg.message, 'success');
            }

        },
        error : function (msg) {
            zuiAlert("请联系管理员。。。", 'danger');
        }
    });
}


