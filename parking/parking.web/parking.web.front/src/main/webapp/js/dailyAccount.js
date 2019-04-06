var tempData = new data();
var dayData = new data();
// 获取分页器实例对象

// 仅选择日期
initFormDate(".form-date");
// 选择时间
initTime(".form-time");
// 日期+时间
initDateTime(".form-datetime");
// 页码初始化
initPager("#myPager");

// 数据
function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 10; // 行总数
    // 定义搜索变量
    this.searchTime = "";
    this.searchStartTime = "";
    this.searchEndTime = "";
};

function automaticDailyAccount() {
    $.ajax({
        type : "POST",
        url : "automaticDailyAccount.action",
        dataType : "json",
        success : function (msg) {
            if (msg.type == 2) {
                layer.open({
                    type : 1,
                    title : "提示",
                    area: ['350px', '200px'],
                    content : "    "+msg.message,
                    btn : [ '确定', '关闭' ],
                    yes : function (index) {
                        automaticAccount();
                        layer.close(index);
                    },
                    cancel : function () {
                    }
                });
                // layer.confirm(msg.message, function (index) {
                // automaticAccount();
                // layer.close(index);
                // });
            }
        },
        error : function (msg) {
            zuiAlert("请联系管理员。。。", 'danger');
        }
    });
}

automaticDailyAccount();

function automaticAccount() {
    $.ajax({
        type : "POST",
        url : "automaticAccount.action",
        dataType : "json",
        success : function (msg) {
            if (msg.type == 1) {
                zuiAlert(msg.message, 'success');
                tempData.CurrentPage = 1;
                init();
                myChart.showLoading();
                $.ajax({
                    type : "post",
                    url : "showECharts.action",
                    dataType : "json",
                    success : function (data) {
                        myChart.hideLoading();
                        myChart.setOption({
                            xAxis : {
                                data : data.dateList
                            },
                            yAxis : {},
                            series : [ {
                                type : 'bar',
                                name : '早班结算',
                                data : data.morList
                            }, {
                                type : 'bar',
                                name : '中班结算',
                                data : data.midList
                            }, {
                                type : 'bar',
                                name : '晚班结算',
                                data : data.nigList
                            } ]
                        })
                    }
                })
            }
        },
        error : function (msg) {
            zuiAlert("请联系管理员。。。", 'danger');
        }
    });
}

function init() {
    console.log("1")
    $ .ajax({
                type : "POST",
                url : "dailyAccountPage.action",
                data : {
                    "time" : tempData.searchTime,
                    "rowPage" : tempData.Limit,
                    "pageCount" : tempData.CurrentPage
                },
                dataType : "json",
                success : function (msg) {
                    var arr = $(".tr");
                    for (var i = arr.length - 1; i >= 0; i--) {
                        $(arr[i]).remove();
                    }
                    // 添加数据
                    var accountList = msg.list;
                    var num = msg.count;
                    if (num > 0) {
                        for (var i = 0; i < accountList.length; i++) {
                            var $tr = $("<tr class = 'tr' ></tr>");
                            var $td1 = $("<td></td>").html(
                                    accountList[i].dailyAccountId);
                            var $td2 = $("<td></td>").html(
                                    accountList[i].dailyAccountTime);
                            var $td3 = $("<td></td>").html(
                                    accountList[i].dailyAccountDate);
                            var $td4 = $("<td></td>").html(
                                    accountList[i].dailyAccountMoney);
                            var $td5 = $("<td></td>")
                                    .html(
                                            formatUnixtimestamp(new Date(
                                                    accountList[i].dailyAccountCreateTime)));
                            $tr.append($td1);
                            $tr.append($td2);
                            $tr.append($td3);
                            $tr.append($td4);
                            $tr.append($td5);
                            $("#table").append($tr);
                        }
                        tempData.Count = parseInt(num);
                        refPager('#myPager');
                    } else {
                        var $tr = $("<tr class = 'tr'><td colspan='5'>未搜索到相关数据</td></tr>");
                        $("#table").append($tr);
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
$('#myPager').on('onPageChange', function (e, state, oldState) {
    if (state.page !== oldState.page) {
        console.log('页码从', oldState.page, '变更为', state.page);
        tempData.CurrentPage = state.page;
        init();
    }
});

init();

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

function account() {
    $.ajax({
        type : "POST",
        url : "dailyAccount.action",
        data : {
            "time" : tempData.searchTime,
        },
        dataType : "json",
        success : function (msg) {
            if (msg.type == 1) {
                zuiAlert(msg.message, 'success');
                tempData.searchTime = "";
                tempData.CurrentPage = 1;
                init();

            } else {
                zuiAlert(msg.message, 'danger');
            }
        },
        error : function (msg) {
            zuiAlert("请联系管理员。。。", 'danger');
        }
    });
}

// 返回按钮监听
$("#initBtn").click(function () {
    tempData.searchTime = "";
    tempData.CurrentPage = 1;
    init();
});

// 早班统计按钮监听
$("#morningAccountBtn").click(function () {
    tempData.searchTime = "早班";
    tempData.CurrentPage = 1;
    init();

});

// 中班统计按钮监听
$("#middleAccountBtn").click(function () {
    tempData.searchTime = "中班";
    tempData.CurrentPage = 1;
    init();
});

// 晚班统计按钮监听
$("#eveningAccountBtn").click(function () {
    tempData.searchTime = "晚班";
    tempData.CurrentPage = 1;
    init();
});

var myChart = echarts.init(document.getElementById('main'),'westeros');
myChart.setOption({
    title : {
        text : '日收费班次柱状图'
    },
    legend : {},
    dataZoom: [{
        type: 'inside',
        start: 0,
        end: 10
    }, {
        start: 0,
        end: 10,
        handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
        handleSize: '80%',
        handleStyle: {
            color: '#fff',
            shadowBlur: 3,
            shadowColor: 'rgba(0, 0, 0, 0.6)',
            shadowOffsetX: 2,
            shadowOffsetY: 2
        }
    }],
    tooltip : {},
    dataset : {
        dimensions : [ 'product', '早班结算', '中班结算', '晚班结算' ],
        source : []
    },
    xAxis : {
        type : 'category',
        data : []
    },
    yAxis : {},
    series : [ {
        type : 'bar',
        name : '早班结算',
        data : []
    }, {
        type : 'bar',
        name : '中班结算',
        data : []
    }, {
        type : 'bar',
        name : '晚班结算',
        data : []
    } ]
});
myChart.showLoading();
$.ajax({
    type : "post",
    url : "showECharts.action",
    dataType : "json",
    success : function (data) {
        myChart.hideLoading();
        myChart.setOption({
            xAxis : {
                data : data.dateList
            },
            yAxis : {},
            series : [ {
                type : 'bar',
                name : '早班结算',
                data : data.morList
            }, {
                type : 'bar',
                name : '中班结算',
                data : data.midList
            }, {
                type : 'bar',
                name : '晚班结算',
                data : data.nigList
            } ]
        })
    }
})

var myChartLine = echarts.init(document.getElementById('lineChart'),'westeros');
myChartLine.setOption({
    title : {
        text : '日收费折线图'
    },
    dataZoom: [{
        type: 'inside',
        start: 0,
        end: 10
    }, {
        start: 0,
        end: 10,
        handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
        handleSize: '80%',
        handleStyle: {
            color: '#fff',
            shadowBlur: 3,
            shadowColor: 'rgba(0, 0, 0, 0.6)',
            shadowOffsetX: 2,
            shadowOffsetY: 2
        }
    }],
    xAxis : {
        type : 'category',
        data : []
    },
    yAxis : {
        type : 'value'
    },
    series : [ {
        data : [],
        type : 'line'
    } ]
});
myChartLine.showLoading();
$.ajax({
    type : "post",
    url : "showLineCharts.action",
    dataType : "json",
    success : function (data) {
        console.log(data);
        myChartLine.hideLoading();
        myChartLine.setOption({
            xAxis : {
                data : data.dayList
            },
            yAxis : {},
            series : [ {
                type : 'line',
                data : data.moneyList
            } ]
        })
    }
})

// dayCount-------------------------------------------------------------
dayAccount();
function dayInit() {
    $
            .ajax({
                type : "POST",
                url : "dayCountPage.action",
                data : {
                    "startTime" : dayData.searchStartTime,
                    "endTime" : dayData.searchEndTime,
                    "rowPage" : dayData.Limit,
                    "pageCount" : dayData.CurrentPage
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
                        dayData.Count = parseInt(num);
                        console.log(dayData.Count);
                        $('#daymyPager').data('zui.pager').set(1, 1,
                                dayData.Limit);
                    } else {
                        var $tr = $("<tr class = 'dayTr'><td colspan='4'>未搜索到相关数据</td></tr>");
                        $("#dayTable").append($tr);
                        $('#daymyPager').data('zui.pager').set(1, 1,
                                dayData.Limit);
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
        dayData.CurrentPage = state.page;
        dayInit();
    }
});

dayInit();

// 搜索按钮监听
$("#selBtn")
        .click(
                function () {
                    dayData.searchStartTime = $("#startTime").val();
                    dayData.searchEndTime = $("#endTime").val();
                    if ($("#startTime").val() == ""
                            && $("#endTime").val() != ""
                            || $("#startTime").val() != ""
                            && $("#endTime").val() == "") {
                        zuiAlert("搜索时间区间不全", 'danger');
                    } else {
                        if ($("#startTime").val() >= $("#endTime").val()) {
                            zuiAlert("输入起始时间应小于结束时间", 'danger');
                        } else {
                            dayData.CurrentPage = 1;
                            dayInit();
                        }
                    }

                });

// 全部显示按钮监听
$("#showAll").click(function () {
    dayData.searchStartTime = "";
    dayData.searchEndTime = "";
    dayData.CurrentPage = 1;
    dayInit();
});

function dayAccount() {
    $.ajax({
        type : "POST",
        url : "addDayCount.action",
        dataType : "json",
        success : function (msg) {
            if (msg.type == 1) {
                layer.open({
                    type : 1,
                    title : "提示",
                    area: ['350px', '200px'],
                    content : "    "+msg.message,
                    btn : [ '确定', '关闭' ],
                    yes : function (index) {
                        automaticDayAccount();
                        layer.close(index);
                    },
                    cancel : function () {
                    }
                });
                // layer.confirm(msg.message, function (index) {
                // automaticDayAccount();
                // layer.close(index);
                // });
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
                dayData.CurrentPage = 1;
                dayInit();
                myChartLine.showLoading();
                $.ajax({
                    type : "post",
                    url : "showLineCharts.action",
                    dataType : "json",
                    success : function (data) {
                        console.log(data);
                        myChartLine.hideLoading();
                        myChartLine.setOption({
                            xAxis : {
                                data : data.dayList
                            },
                            yAxis : {},
                            series : [ {
                                type : 'line',
                                data : data.moneyList
                            } ]
                        })
                    }
                })
            }
        },
        error : function (msg) {
            zuiAlert("请联系管理员。。。", 'danger');
        }
    });
}
