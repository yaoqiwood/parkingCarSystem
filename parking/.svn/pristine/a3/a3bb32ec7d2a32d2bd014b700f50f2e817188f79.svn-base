var commit = document.getElementById("commit");
commit.onclick = function() {    
     var oldpwd = document.getElementById("oldpwd");
		var newpwd = document.getElementById("newpwd");
		var surepwd = document.getElementById("surepwd");
		var did = document.getElementById("did");
		if(newpwd.value != surepwd.value || newpwd.value == null || surepwd.value==null ||
				oldpwd.value == null){
			alert("请注意密码大小写");
		}else{
			$.ajax({
				url:"updatepwd.action",
				type:"POST",
				dataType:"json",
				data:{"oldpwd" : oldpwd.value ,"newpwd" : newpwd.value},
				success:function(data){
				 var msg = JSON.stringify(data);
	             var obj = eval("(" + msg +")");
	             if(obj.id==0){
	            	 alert(obj.message);
	             }else{
	            	 alert(obj.message);
	             }
				},
				error:function(msg){
					alert("请联系管理员");
				}
			});
		}
}