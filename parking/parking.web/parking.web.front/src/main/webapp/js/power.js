function init(){
	var roleId = document.getElementById("roleId");
	$.ajax({
		type:"post",
		url:"listMenuupdate.action",
		 dataType:"json",
		data:{"roleId" : 1},
		success:function(data){
			var msg = JSON.stringify(data);
			var obj = eval("(" + msg +")");
			if(obj.id == 0 ){
				var list = obj.menus;
				//通过dom方式添加到侧边栏中
			     var left =document.getElementById("left");
			     var arr= left.children;
			     for(var i = arr.length - 1 ; i>= 0 ; i--){
			     	arr[i].remove();
			     }
			     //添加数据
			     for(var i = 0 ; i < list.length ; i++){
			     	var div = document.createElement("div");
			     	div.className = "item";
			     	//添加一级菜单
			     	var divFirst = document.createElement("div");
			     	divFirst.className = "first";
			     	divFirst.innerHTML = list[i].menuName;
			     	div.appendChild(divFirst);
			     	var check = document.createElement("input");
			     	check.className = "checkItem1";
			     	check.type="checkbox";
			     	check.setAttribute("adminId" , list[i].adminRoleId);
			     	divFirst.appendChild(check);
			     	if(list[i].adminRoleState == 1){
			     		check.checked = "checked";
			     	}
			     	//添加二级菜单
			     	var listSecond = list[i].menuInfs;
			     	for(var j = 0 ; j < listSecond.length ; j ++){
			     		var divSecond= document.createElement("div");
			     		divSecond.className = "second";
			     		divSecond.innerHTML = listSecond[j].menuName;
			     		divSecond.setAttribute("jm" , listSecond[j].menuUrl);
			     		div.appendChild(divSecond);
			     		var check = document.createElement("input");
				     	check.className = "checkItem2";
				     	check.type="checkbox";
				     	check.setAttribute("adminId" , listSecond[j].adminRoleId);
				     	divSecond.appendChild(check);
				     	if(listSecond[j].adminRoleState == 1){
				     		check.checked = "checked";
				     	}
			     	}
			     	left.appendChild(div);
			     }
			}
			
		},
		error:function(msg){
			alert("请联系管理员");
		}
	});
}
init();
var left = document.getElementById("left");
left.onclick = function(event) {
	var tar = event.target;
	if (tar.className == "first") {
		// alert("点击到一级了...");
		var arr = tar.parentElement.children;
		for (var i = 0; i < arr.length; i++) {
			if (arr[i].className == "second") {
				if (arr[i].style.display == "block") {
					arr[i].style.display = "none";
				} else {
					arr[i].style.display = "block";
				}
			}
		}
	}
	if($(tar).attr("class") == "checkItem1"){
		var b=$(tar).prop("checked");
		var arr = $(tar).parent().parent().children().children();
		for(var i=0;i<arr.length;i++){
			if(arr[i].className == "checkItem2"){
				$(arr[i]).prop("checked" , b);
			}
		}
	}
	if(tar.className == "checkItem2"){
		var b=$(tar).prop("checked");
		var arr = $(tar).parent().parent().children().children();
		if(b){
			for(var i=0;i<arr.length;i++){
				if(arr[i].className == "checkItem1"){
					$(arr[i]).prop("checked" , b);
				}
			}
		}
	}
	if (tar.className == "second") {
		var msg = tar.getAttribute("jm");
		// alert(msg);
		var iframe = document.getElementById("iframe");
		iframe.src = msg;
	}

};
var btn = document.getElementById("btn");
btn.onclick = function() {
	var arr = document.getElementsByClassName("checkItem1");	
	var arr1 = document.getElementsByClassName("checkItem2");	
	var b = window.confirm("确定要修改吗");
	var list = [];
	for(var i = arr.length - 1 ; i >= 0 ; i--){
		if( b == true){
		if(arr[i].checked == true){
			var adminId = arr[i].getAttribute("adminId");
			list.push(adminId);
		}	
		}
	}
	for(var i = arr1.length - 1 ; i >= 0 ; i--){
		if( b == true){
		if(arr1[i].checked == true){
			var adminId = arr1[i].getAttribute("adminId");
			list.push(adminId);
		}	
		}
	}
	$.ajax({
		type:"POST",
		url:"listbtn.action",
		dataType:"json",
		data:{"roleId" : 1 , "list" : list.join(",")},
		success:function(data){
			var msg = JSON.stringify(data);
			var obj = eval("(" + msg +")");
			if(obj.id==0){
				alert(obj.message);
				init();
			}else{
				alert(obj.message);
			}
			
		},
		error:function(msg){
			alert("请联系管理员");
		}
	});
}
var roleId = document.getElementById("roleId");
roleId.onclick = function() {
	init();
}