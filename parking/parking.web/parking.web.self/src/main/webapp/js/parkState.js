//获取版本号,设置title
document.title = '路径文字描述(全部)V' + fengmap.VERSION;

var start = {
	x: 12958916.285,
	y: 4861347.77,
	groupID: 1
}

// 定义全局map变量
var map;
var fmapID = '90868';
// 导航对象
var navi;
var groupControl;
// 导航开关
var navigation = true;

if (navi) {
	// 清空导航信息
	$("#description").html("");
	navi.stop();
	navi = null;
}

function createrNavi(coord) {
	if (!navi) {
		//初始化导航对象
		navi = new fengmap.FMNavigation({
			map: map,
			locationMarkerUrl: 'image/green.png',
			//设置Marker尺寸
			locationMarkerSize: 12,
			//设置跟随定位的默认为true
			followPosition: true,
			//设置地图是否选择，默认false
			followAngle: true,
			//导航跟随显示级别
			scaleLevel: 0,
			// 设置导航线的样式
			lineStyle: {
				// 导航线样式
				lineType: fengmap.FMLineType.FMARROW,
				// 设置线的宽度
				lineWidth: 6,
				//设置线的颜色
				// godColor: '#FF0000',
				//设置边线的颜色
				// godEdgeColor: '#920000',
			}
		});
	}

	//添加起点
	navi.setStartPoint({
		x: coord[0].x,
		y: coord[0].y,
		groupID: coord[0].groupID,
		url: 'image/start.png',
		size: 32
	});

	//添加终点
	navi.setEndPoint({
		x: coord[1].x,
		y: coord[1].y,
		groupID: coord[1].groupID,
		url: 'image/end.png',
		size: 32
	});

	navi.locationMarker.setPosition(coord[0]);

	var cnt = 0;
	var length = 3;

	// 添加导航事件
	navi.on('walking', function (data) {
		if (!fm) return;
		var v = new fm.Vector3(1, 0, 0);
		v.applyAxisAngle(new fm.Vector3(0, 1, 0), Math.PI - navi.locationMarker.o3d_.rotation.z);

		var scalar = Math.sin(cnt += .6) * Math.random() * length;
		v.multiplyScalar(scalar);
		var point = {
			x: data.point.x + v.x,
			y: data.point.y + v.z,
			groupID: data.groupID,
			zOffset: 2.5
		};
		redMarker.setPosition(point);
	});

	//导航路径结束事件
	navi.on('complete', function () {
		navigation = true;
		oNavigation.classList.remove('btn-primary');
	});

	// 画出导航线
	navi.drawNaviLine();
};

// 楼层控制控件配置参数
var ctlOpt = new fengmap.controlOptions({
	// 默认在左下角
	position: fengmap.controlPositon.LEFT_BOTTOM,
	// 默认显示楼层的个数
	showBtnCount: 7,
	// 设置x,y的位置偏移量
	offset: {
		x: 20,
		y: 80
	}
});

map = new fengmap.FMMap({
	// 渲染dom
	container: document.getElementById('fengMap'),
	// 地图数据位置
	mapServerURL: './3rd/fengniao/data/' + 90868,
	// 主题数据位置
	/*
	 * mapThemeURL: './data/theme', //设置主题 defaultThemeName: '2001',
	 */
	// 默认比例尺级别设置为20级
	defaultMapScaleLevel: 20,
	// 对不可见图层启用透明设置 默认为true
	focusAlphaMode: true,
	// 关闭聚焦层切换的动画显示
	focusAnimateMode: false,
	// 对不聚焦图层启用透明设置，当focusAlphaMode = true时有效
	focusAlpha: 0.3,
	// 开启2维，3维切换的动画显示
	viewModeAnimateMode: true,
	// 设置倾斜角，默认倾斜角为60度
	defaultTiltAngle: 30,
	// 开发者申请应用下web服务的key
	key: 'f4323575f8c2329b650da78857ba8126',
	// 开发者申请应用名称
	appName: '请输入您的appName',
});

// 打开Fengmap服务器的地图数据和主题
map.openMapById(fmapID);

function search() {
	$.ajax({
		url: "search.action",
		type: "POST",
		data: {},
		dataType: "json",
		success: function (data) {
			if (data.id == 0) {
				fengmap.MapUtil.search(map, [data.car.placePsId], {
					ID: data.car.placeUrl
				}, function (result) {
					var models = result;
					if (models.length <= 0)
						return;

					var model = models[0];
					console.log(model.mapCoord.x);
					console.log(model.mapCoord.y);
					// 起点终点坐标
					var points = [start, {
						x: model.mapCoord.x,
						y: model.mapCoord.y,
						groupID: data.car.placePsId
					}];

					// 地图加载完执行画导航路径
					createrNavi(points);

					// 展示开始导航
					$("#navigation").show();
				});
			} else {
				zuiAlert(data.message, "danger");
			}
		},
		error: function (msg) {
		}
	});
}


map.on('loadComplete', function () {
	// 默认楼层加载完后不显示，需自定义设置要显示的楼层和聚焦层
	map.visibleGroupIDs = map.groupIDs;
	map.focusGroupID = map.groupIDs[0];
	layerGroup.init(map.listGroups, map.focusGroupID);
});

$("#inverse-btn").click(function () {
	search();
});

$("#inverse-back").click(function() {
//   返回 
	window.location.replace("http://localhost:8080/parking.web.self");
});
