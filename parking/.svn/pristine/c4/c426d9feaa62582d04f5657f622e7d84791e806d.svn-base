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
						width: 800,
						height: 450
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
		return year + "-" + month.substring(month.length - 2, month.length)
				+ "-" + date.substring(date.length - 2, date.length) + " "
				+ hour.substring(hour.length - 2, hour.length) + ":"
				+ minute.substring(minute.length - 2, minute.length) + ":"
				+ second.substring(second.length - 2, second.length);
	}
	//获取终端ID
	var mechineId = 1;

//	//刷车牌
//	var result = true;
//	var miao = 2000;
//	var click = false;
	//

	function initInfo() {
		$("#carId").val("");
		$("#carNum").val("");
		$("#userType").val("");
		$("#comeTime").val("");
		$("#outTime").val("");
		$("#money").val("");
	}
	
	function postImage(carNum){
//		if(result && click){
//			result = false;
			context.drawImage(video,0,0,800,450);
			let data = canvas.toDataURL();
			let img = document.createElement('img');
			img.src = data;
			$.ajax({
				url: "do-payment.ajax",
				type: "POST",
				dataType: "json",
				data: {
					"data": carNum
				},
				success: function(msg) {
					if(msg.id == 0){
						var obj = msg.info;
						$("#carId").val(obj.carRecordId);
						$("#carNum").val(obj.carNum);
						$("#userType").val( obj.carRecordState == 3 ? "白名单用户":obj.carRecordState == 2 ? "月缴用户":"临时用户" );
						$("#comeTime").val(formatUnixtimestamp(obj.carRecordComeTime));
						$("#outTime").val(formatUnixtimestamp(obj.carRecordOutTime));
						$("#money").val(obj.carRecordMemo);
					}else if(msg.id == 4){
						var obj = msg.info;
						zuiAlert(msg.message,'success');
						$("#carId").val(obj.carRecordId);
						$("#carNum").val(obj.carNum);
						$("#userType").val( obj.carRecordState == 3 ? "白名单用户":obj.carRecordState == 2 ? "月缴用户":"临时用户" );
						$("#comeTime").val(formatUnixtimestamp(obj.carRecordComeTime));
						$("#outTime").val(formatUnixtimestamp(obj.carRecordOutTime));
						$("#money").val(obj.carRecordMemo);
						
						var ttsAudio = document.getElementById('tts_autio_id');
						var ttsDiv = document.getElementById('bdtts_div_id');
						var ttsText = msg.message;
						// 这样就可实现播放内容的替换了
						ttsDiv.removeChild(ttsAudio);
						var au1 = '<audio id="tts_autio_id" autoplay="autoplay">';
						var sss = '<source id="tts_source_id" src="http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=5&text='+ttsText+'" type="audio/mpeg">';
						var eee = '<embed id="tts_embed_id" height="0" width="0" src="">';
						var au2 = '</audio>';
						ttsDiv.innerHTML = au1 + sss + eee + au2;
							
						ttsAudio = document.getElementById('tts_autio_id');
						ttsAudio.play();
//						result = true;
						setTimeout(function(){
							initInfo();
						}, 8000);
					}else{
						zuiAlert("未找到该车停车信息");
//						result = true;
//						setTimeout(function(){
//							initInfo();
//						}, 3000);
					}
					
				},
				error: function(msg) {
					
				}
			});
//		}
//		setTimeout(function(){
//			postImage();
//		},miao);
}

//	setTimeout(function(){
//		postImage();
//	},5000);

	//缴费
	$("#pay").click(function() {
		if($("#carId").val() != ""){
			var sure = layer.open({offset: '100px',skin: 'layui-layer-lan',content:'确认缴费？',btn:  ['确定','取消'],
	           yes: function(){
	            	$.ajax({
	        			url : "do-alipay.ajax",
	        			type : "POST",
	        			data : {
	        				"mechineId":mechineId,
	        				"carRecordId" : $("#carId").val(),
	        				"carNum" : $("#carNum").val(),
	        				"money" : $("#money").val()
	        			},
	        			dataType : "json",
	        			success : function(msg) {
	        				zuiAlert(msg.message);
	        				if(msg.id == 0){
	        					$("#carId").val("");
	        					$("#carNum").val("");
	        					$("#userType").val("");
	        					$("#comeTime").val("");
	        					$("#outTime").val("");
	        					$("#money").val("");
	        					

	    						var ttsAudio = document.getElementById('tts_autio_id');
	    						var ttsDiv = document.getElementById('bdtts_div_id');
	    						var ttsText = "付款成功！祝您一路顺风~";
	    						// 这样就可实现播放内容的替换了
	    						ttsDiv.removeChild(ttsAudio);
	    						var au1 = '<audio id="tts_autio_id" autoplay="autoplay">';
	    						var sss = '<source id="tts_source_id" src="http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=5&text='+ttsText+'" type="audio/mpeg">';
	    						var eee = '<embed id="tts_embed_id" height="0" width="0" src="">';
	    						var au2 = '</audio>';
	    						ttsDiv.innerHTML = au1 + sss + eee + au2;
	    							
	    						ttsAudio = document.getElementById('tts_autio_id');
	    						ttsAudio.play();
	        				}
	        			},
	        			error : function(msg) {
	        				zuiAlert("请联系管理员...");
	        			}
	        		}); 
	            	layer.close(sure);
	            }
	        });
		}else{
			layer.open({offset: '100px',skin: 'layui-layer-lan',content:'请读取车辆信息！',btn:  ['确定']
	           /* yes: function(){
	            }*/
	        });
		}
	});

//	$("#data").click(function(){
//		if(click){
//			click = false;
//		}else{
//			click = true;
//		}
//	});
	
	$("#carNumOne").click(function(){
		postImage("闽AG891Z");
	});
	$("#carNumTwo").click(function(){
		postImage("闽AUY111");
	});
	$("#carNumThree").click(function(){
		postImage("闽ACC117");
	});