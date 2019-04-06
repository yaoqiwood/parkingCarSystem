//获取版本号,设置title
document.title = '路径文字描述(全部)V' + fengmap.VERSION;

// 定义全局map变量
var map;
var fmapID = '90868';
// 导航对象
var navi;
var groupControl;

map = new fengmap.FMMap({
	// 渲染dom
	container : document.getElementById('fengMap'),
	// 地图数据位置
	mapServerURL : './3rd/fengniao/data/' + 90868,
	// 主题数据位置
	/*
	 * mapThemeURL: './data/theme', //设置主题 defaultThemeName: '2001',
	 */
	// 默认比例尺级别设置为20级
	defaultMapScaleLevel : 20,
	// 对不可见图层启用透明设置 默认为true
	focusAlphaMode : true,
	// 关闭聚焦层切换的动画显示
	focusAnimateMode : false,
	// 对不聚焦图层启用透明设置，当focusAlphaMode = true时有效
	focusAlpha : 0.3,
	// 开启2维，3维切换的动画显示
	viewModeAnimateMode : true,
	// 设置倾斜角，默认倾斜角为60度
	defaultTiltAngle : 30,
	// 开发者申请应用下web服务的key
	key : 'f4323575f8c2329b650da78857ba8126',
	// 开发者申请应用名称
	appName : '请输入您的appName',
});

// 打开Fengmap服务器的地图数据和主题
map.openMapById(fmapID);

function usedPark(parkList) {
	// 先查询出模型对象，在改变搜索到的model的颜色为紫色，透明度为0.5
	var searchType = fengmap.FMNodeType.MODEL;
	for (var i = 0; i < parkList.length; i++) {
		// 搜索分析方法
		var request = {
			nodeType : searchType,
			ID : parkList[i].placeUrl
		};
		// 查询所有楼层下的类型为fengmap.FMNodeType.MODEL的ID=1的模型元素
		fengmap.MapUtil.search(map, [ parkList[i].placePsId ], request,
				function(result) {
					var models = result;
					if (models.length <= 0)
						return;

					var model = models[0];
					if (parkList[i].placeState == 1) {
						model.setColor('#000000', 0.5);
					} else if (parkList[i].placeState == 3) {
						model.setColor('#333333', 0.5); // 修改模型颜色
					} else if (parkList[i].placeState == 2) {
						model.setColor('#F7670C', 0.5); // 修改模型颜色
					}
				});
	}
}

// 查询方法
function init() {
	$.ajax({
		url : "listPlaceByPage.action",
		type : "POST",
		dataType : "json",
		data : {
			"name" : "",
			"floor" : "",
			"start" : 1,
			"end" : 100
		},
		success : function(data) {
			var msg = JSON.stringify(data);
			var obj = eval("(" + msg + ")");
			// 首先清空数据
			var arr = $(".tr")
			for (var i = arr.length - 1; i >= 0; i--) {
				$(arr[i]).remove()
			}
			;
			// 添加数据
			var list = obj.list;
			// var c = obj.count;
			// if (c != 0) {
			usedPark(list);
			// }
		},
		error : function(msg) {
			alert("请联系管理员");
		}
	});
};

map.on('loadComplete', function() {
	//默认楼层加载完后不显示，需自定义设置要显示的楼层和聚焦层
	map.visibleGroupIDs = map.groupIDs;
	map.focusGroupID = map.groupIDs[0];
	layerGroup.init(map.listGroups, map.focusGroupID);
	
	init();
});

$("#btn").click(function() {
	init();
});

var websocket = null;
// 判断当前浏览器是否支持WebSocket19
if ('WebSocket' in window) {
	websocket = new WebSocket("ws://localhost:8080/parking.web.mgr/WebSocketServer");
} else {
	alert('当前浏览器 Not support websocket')
}

//连接发生错误的回调方法
websocket.onerror = function () {
    console.log("WebSocket连接发生错误");
};

//连接成功建立的回调方法
websocket.onopen = function () {
	console.log("WebSocket连接成功");
}

//接收到消息的回调方法
websocket.onmessage = function (msg) {
//	var msg1 = JSON.stringify(msg.data);
//	var obj = eval("(" + msg1 + ")");
//	console.log(data.data.list);
//	var list = msg.list;
//	console.log(msg.data);
//	console.log(JSON.parse(msg.data));
	var list = JSON.parse(msg.data).list;
	usedPark(list);
}

//连接关闭的回调方法
websocket.onclose = function () {
	console.log("WebSocket连接关闭");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    closeWebSocket();
}

//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
}

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}

//发送消息
function send() {
    
}