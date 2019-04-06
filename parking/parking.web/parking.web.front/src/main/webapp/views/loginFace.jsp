<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
	<video id="video" width="480" height="320">
	</video>
	<!-- <div>
		<button id="capture">拍照</button>
	</div> -->
	<canvas id="canvas" width="480" height="320" style="display: none"></canvas>
	<div id="face"></div>
	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script>
			//访问用户媒体设备的兼容方法
			function getUserMedia(constraints, success, error) {
				if(navigator.mediaDevices.getUserMedia) {
					//最新的标准API
					navigator.mediaDevices.getUserMedia(constraints).then(success).catch(error);
				} else if(navigator.webkitGetUserMedia) {
					//webkit核心浏览器
					navigator.webkitGetUserMedia(constraints, success, error)
				} else if(navigator.mozGetUserMedia) {
					//firfox浏览器
					navigator.mozGetUserMedia(constraints, success, error);
				} else if(navigator.getUserMedia) {
					//旧版API
					navigator.getUserMedia(constraints, success, error);
				}
			}

			let video = document.getElementById('video');
			let canvas = document.getElementById('canvas');
			let context = canvas.getContext('2d');

			function success(stream) {
				//兼容webkit核心浏览器
				let CompatibleURL = window.URL || window.webkitURL;
				//将视频流设置为video元素的源
				console.log(stream);

				//video.src = CompatibleURL.createObjectURL(stream);
				video.srcObject = stream;
				video.play();
			}

			function error(error) {
				console.log(`访问用户媒体设备失败${error.name}, ${error.message}`);
			}

			if(navigator.mediaDevices.getUserMedia || navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia) {
				//调用用户媒体设备, 访问摄像头
				getUserMedia({
					video: {
						width: 480,
						height: 320
					}
				}, success, error);
			} else {
				alert('不支持访问用户媒体');
			}
			
			

			var startTime = new Date().getTime();
			var interval = setInterval(function() {

				if(new Date().getTime() - startTime > 1000){
				
				context.drawImage(video, 0, 0, 480, 320);
				let data = canvas.toDataURL();
				let img = document.createElement('img');
				img.src = data;
				$.ajax({
					type : "POST",
					url : "faceLogin.action",
					data : {"data" :data},
					success : function(data) {
						var obj = eval("("+data+")");
						alert(obj.message);
						console.log(data);
						if(obj.id == 0){
								document.location = obj.location;
								clearInterval(interval);	
						}
					},
					error : function(msg) {
						alert("请联系管理员！");
					}
				});
				}
			},5000);
			

			/* $('#capture').click(function() {
				context.drawImage(video, 0, 0, 480, 320);
				let data = canvas.toDataURL();
				let img = document.createElement('img');
				img.src = data;
				/* document.body.appendChild(img); */
				/*$.ajax({
					type : "POST",
					url : "faceLogin.action",
					data : {"data" :data},
					success : function(data) {
						var obj = eval("("+data+")");
						alert(obj.message);
						console.log(data);
						if(obj.id == 0){
								document.location = obj.location;
						}
					},
					error : function(msg) {
						alert("请联系管理员！");
					}
				});
			}) */
		</script>
</body>
<script>
	</script>

</html>