// 刷新表页
function RefreshTable(url, data, bodyClass) {
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (response) {
            response = JSON.parse(response);
            // 清空表内容
            emptyTableBody(bodyClass);
            // 依托内容 填充数据
            response.length == 0 ? noneTableParams():"";
            $.each(response, function (index, value) {
                fillTableBody(value);
            })
        }
    });
};

// 刷新表页总数
function CountTableData(url, data) {
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (response) {
            response = JSON.parse(response);
            var Count = response.count;
            tempData.Count = Count;
            // 页面总数刷新
            refPager('#myPager');
        }
    });
};

function emptyTableBody(U_class) {
    $("." + U_class).each(function () {
        $(this).remove();
    });
};

// 初始化分页器
function initPager(param) {
    // 手动进行初始化'#myPager'
    $(param).pager({
        page: tempData.CurrentPage,
        recTotal: tempData.Count,
        recPerPage: tempData.Limit,
    });
}



// 刷新页
function refPager(param) {
    tempData.Count = parseInt(tempData.Count);
    $(param).data('zui.pager').set(tempData.CurrentPage, tempData.Count, tempData.Limit);
}

function dispalyOrNot(param) {
    $(param).css("display", ($(param).css("display") == "block" ? "none" : "block"));
}

function RefreshTableDataAndPage(url, pageUrl) {
    RefreshTable(url, tempData.RefreshJSON(), "table_content");
    CountTableData(pageUrl, tempData.RefreshJSON(), "TotalPageView");
};

// 上一页
function lastPage(url, pageUrl) {
    tempData.CurrentPage > 1 ? tempData.CurrentPage -= 1 : true;
    RefreshTableDataAndPage(url, pageUrl);
};

// 下一页
function nextPage(url, pageUrl) {
    tempData.CurrentPage < tempData.TotalPage ? tempData.CurrentPage += 1 : true;
    RefreshTableDataAndPage(url, pageUrl);
};


// 日期插件初始化
function initFormDate(plugin) {
    $(plugin).datetimepicker(
        {
            language: "zh-CN",
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0,
            format: "yyyy-mm-dd"
        }
    );
}

// 时间插件初始化
function initTime(plugin) {
    $(plugin).datetimepicker({
        language: "zh-CN",
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0,
        format: 'hh:ii'
    });
}

// 时间日期初始化
function initDateTime(plugin) {
    $(plugin).datetimepicker(
        {
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1,
            format: "yyyy-mm-dd hh:ii"
        }
    );
}

// zui提示消息框 success danger
function zuiAlert(message,mType) {  
    new $.zui.Messager(message, {
        type: mType     // 定义颜色主题
    }).show();
}


// 针对className清空数据
function emptyClassName(className) {  
    $(className).each(function (value) {
        $(this).val("");
    });
}