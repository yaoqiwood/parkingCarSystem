//访问用户媒体设备的兼容方法
			function getUserMedia(constraints, success, error) {
				if(navigator.mediaDevices.getUserMedia) {
					// 最新的标准API
					navigator.mediaDevices.getUserMedia(constraints).then(success).catch(error);
				} else if(navigator.webkitGetUserMedia) {
					// webkit核心浏览器
					navigator.webkitGetUserMedia(constraints, success, error)
				} else if(navigator.mozGetUserMedia) {
					// firfox浏览器
					navigator.mozGetUserMedia(constraints, success, error);
				} else if(navigator.getUserMedia) {
					// 旧版API
					navigator.getUserMedia(constraints, success, error);
				}
			}

			let video = document.getElementById('video');
			let canvas = document.getElementById('canvas');
			let context = canvas.getContext('2d');

			function success(stream) {
				// 兼容webkit核心浏览器
				let CompatibleURL = window.URL || window.webkitURL;
				// video.src = CompatibleURL.createObjectURL(stream);
				video.srcObject = stream;
				video.play();
			}

			function error(error) {
				console.log(`访问用户媒体设备失败${error.name}, ${error.message}`);
			}

			if(navigator.mediaDevices.getUserMedia || navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia) {
				// 调用用户媒体设备, 访问摄像头
				getUserMedia({
					video: {
						width: 480,
						height: 320
					}
				}, success, error);
			} else {
				alert('不支持访问用户媒体');
			}
function formatUnixtimestamp(unixtimestamp) {
		var unixtimestamp = new Date(unixtimestamp);
		var year = 1900 + unixtimestamp.getYear();
		var month = "0" + (unixtimestamp.getMonth() + 1);
		var date = "0" + unixtimestamp.getDate();
		var hour = "0" + unixtimestamp.getHours();
		var minute = "0" + unixtimestamp.getMinutes();
		var second = "0" + unixtimestamp.getSeconds();
		return year + "-" + month.substring(month.length - 2, month.length) + "-" + date.substring(date.length - 2, date.length) +
		" " + hour.substring(hour.length - 2, hour.length) + ":" +
		minute.substring(minute.length - 2, minute.length) + ":" +
		second.substring(second.length - 2, second.length);
}


/*var result = true;
var click = false;
var miao = 2000;*/
//
function postImage(carNum){
/*	if(result && click){*/
		/*result = false;*/
		context.drawImage(video,0,0,1000,390);
		let data = canvas.toDataURL();
		let img = document.createElement('img');
		img.src = data;
		$.ajax({
			url: "listcarInByPage.action",
			type: "POST",
			dataType: "json",
			data: {
				"data": carNum
			},
			success: function(data) {
				if(data.id == 0){
					$("#carId").val(data.car.carnumId);
					$("#carNum").val(data.car.carNumber);
					$("#carRole").val( data.car.carRoleId == 3 ? "白名单用户":data.car.carRoleId == 2 ? "月缴用户":"临时用户" );
					$("#carTime").val(formatUnixtimestamp(data.car.carnumCreateTime));
					var ttsAudio = document.getElementById('tts_autio_id');
					var ttsDiv = document.getElementById('bdtts_div_id');
					var ttsText = "欢迎"+data.car.carNumber+$("#carRole").val();
					// 这样就可实现播放内容的替换了
					ttsDiv.removeChild(ttsAudio);
					var au1 = '<audio id="tts_autio_id" autoplay="autoplay">';
					var sss = '<source id="tts_source_id" src="http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=5&text='+ttsText+'" type="audio/mpeg">';
					var eee = '<embed id="tts_embed_id" height="0" width="0" src="">';
					var au2 = '</audio>';
					ttsDiv.innerHTML = au1 + sss + eee + au2;
					
					ttsAudio = document.getElementById('tts_autio_id');
					ttsAudio.play();
					
					zuiAlert(ttsText,"success");

					$.ajax({
						url: "http://localhost:8080/parking.web.mgr/fresh.action",
						type: "POST",
						data: {},
						success: function(data) {},
						error: function(msg) {}
					});
					/*miao = 8000;*/
					initInfo();
					setTimeout(function(){
						clearInfo();
					},8000);
				}
				/*else{
					miao = 2000;
				}
				result = true;*/
			},
			error: function(msg) {
				alert("请联系管理员");
				}
			});
	/*}*/
	/*setTimeout(function(){
		postImage();
	},miao);*/
}

/*setTimeout(function(){
	postImage();
},5000);*/

/*$("#data").click(function(){
	if(click){
		click = false;
	}else{
		click = true;
	}
});*/

$("#carNumOne").click(function(){
	postImage("闽AG891Z");
});
$("#carNumTwo").click(function(){
	postImage("闽AUY111");
});
$("#carNumThree").click(function(){
	postImage("闽ACC117");
});

function initInfo(){
	$.ajax({
		url: "placeCountInf.action",
		type: "POST",
		data: {},
		dataType: "json",
		success: function(data) {
			$("#placeCount").html(data.placeCount);
			$("#placeEmptyCount").html((data.placeCount-data.placeHasCount));
			$("#placeHasCount").html(data.placeHasCount);
		},
		error: function(msg) {}
	});
}

function clearInfo(){
	$("#carId").val("");
	$("#carNum").val("");
	$("#carTime").val("");
	$("#carRole").val("");
}

initInfo();