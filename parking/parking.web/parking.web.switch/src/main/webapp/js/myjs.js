//初始化分页器
$('#myPager').pager({
	page : 1,
	recPerPage : 5,
	recTotal : 1
});

// 初始化时间选择器组件
// 仅选择日期
$(".form-date").datetimepicker({
	language : "zh-CN",
	weekStart : 1,
	todayBtn : 1,
	autoclose : 1,
	todayHighlight : 1,
	startView : 2,
	minView : 2,
	forceParse : 0,
	format : "yyyy-mm-dd"
});