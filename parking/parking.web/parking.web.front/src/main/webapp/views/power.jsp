<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<style>
html, body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}
.left {
	position: absolute;
	top: 100px;
	left: 400px;
	width: 250px;
	background-color: #696969;
}
.first {
	width: 100%;
	height: 40px;
	text-align: center;
	background-color: #414141;
	color: white;
	padding-top: 10px;
	border-bottom: 1px solid #5A5A5A;
}

.second {
	width: 100%;
	height: 40px;
	text-align: center;
	background-color: #616161;
	color: white;
	padding-top: 10px;
	border-bottom: 1px solid #5A5A5A;
	display: none;
}
.field{
	position: absolute;
	top: 50px;
	left: 430px;
	width: 150px;
	height: 30px;
}
.btn{
	position: absolute;
	top: 320px;
	left: 150px;
	width: 150px;
	height: 30px;
	cursor: pointer;
}
.diving{
    width: 400px;
	height: 400px;
	overflow-y:auto;
}
</style>

</head>

<body>
	  <span>
	  	<select id="roleId" class="field">
	  		<option value="1">管理人员</option>
	  	</select>
	  </span>
	  <div class="diving">
		<div id="left" class="left">
				<div class="item">
					<div class="first">后台管理</div>
					<div class="second" aaa="index3.html">页面管理</div>
					<div class="second" aaa="index4.html">日志管理</div>
				</div>
				<div class="item">
					<div class="first">前台管理</div>
					<div class="second" aaa="index2.jsp">用户管理</div>
					<div class="second" aaa="index6.html">商品管理</div>
					<div class="second" aaa="index7.html">商品流转</div>
				</div>
		</div>
		 </div>
      <span>
      	<input id="btn" type="button" value="保存" class="btn"/>
      </span>
</body>
   <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="3rd/zui/js/zui.min.js"></script>
<script type="text/javascript" src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/power.js"></script>
</html>
    