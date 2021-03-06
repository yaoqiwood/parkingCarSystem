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
    this.searchStartTime = "";
    this.searchEndTime = "";
};
account();
function init() {
    $.ajax({
        type : "POST",
        url : "dayCountPage.action",
        data : {
            "startTime" : tempData.searchStartTime,
            "endTime" : tempData.searchEndTime,
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
            var countList = msg.list;
            var num = msg.count;
            for (var i = 0; i < countList.length; i++) {
                var $tr = $("<tr class = 'tr' ></tr>");
                var $td1 = $("<td></td>").html(countList[i].dayCountId);
                var $td2 = $("<td></td>").html(formatUnixtimestamp(new Date(
                        countList[i].dayCountTime)));
                var $td3 = $("<td></td>").html(countList[i].dayCountMoney);
                var $td4 = $("<td></td>").html(
                        formatUnixtimestamp(new Date(
                                countList[i].dayCountCreateTime)));
                $tr.append($td1);
                $tr.append($td2);
                $tr.append($td3);
                $tr.append($td4);
                $("#table").append($tr);
            }
            tempData.Count = parseInt(num);
            refPager('#myPager');
        },
        error : function(msg) {
            alert("请联系管理员。。。");
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
$("#selBtn").click(function() {
    tempData.searchStartTime = $("#startTime").val();
    tempData.searchEndTime = $("#endTime").val();
    tempData.CurrentPage = 1;
    init();
});

// 全部显示按钮监听
$("#showAll").click(function() {
    tempData.searchStartTime = "";
    tempData.searchEndTime = "";
    tempData.CurrentPage = 1;
    init();
});

function account() {
    $.ajax({
        type : "POST",
        url : "addDayCount.action",
        dataType : "json",
        success : function(msg) {
            if (msg.type == 1) {
                if(confirm(msg.message)){
                    automaticDayAccount();
                }
            }
        },
        error : function(msg) {
            alert("请联系管理员。。。");
        }
    });
}



function automaticDayAccount(){
    $
    .ajax({
        type : "POST",
        url : "automaticDayAccount.action",
        dataType : "json",
        success : function(msg) {
            if(msg.type==1){
                alert(msg.message);
            }
            
        },
        error : function(msg) {
            alert("请联系管理员。。。");
        }
    });
}