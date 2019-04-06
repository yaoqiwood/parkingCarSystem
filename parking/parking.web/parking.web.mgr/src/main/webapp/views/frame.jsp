<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>后台管理</title>
    <!-- zui css -->
    <link rel="stylesheet" href="3rd/zui/css/zui.min.css">
    <link rel="stylesheet" href="3rd/layer/theme/default/layer.css">
    <!-- app css -->
    <link rel="stylesheet" href="css/frameApp-mgr.css">
    <link rel="stylesheet" href="css/frame.css">
	<style type="text/css">
		.main-header{
			height: 50px;
		}
	.diving2 {
			position: absolute;
			left: 0px;
			top: 0px;
			background-color: rgba(225, 225, 225, 0);
			width: 100%;
			height: 100%;
			display: none ;
			z-index: 999;
			}
		.modal-content{
			position: absolute;
			top: 100px;
			left: 400px;
			width: 500px;
			height: 280px;
			background-color: white;
			border: 2px solid white;
			border-radius: 10px;
			display: none ;
			z-index: 999;
		}
	</style>
</head>

<body>
    <div class="wrapper">
        <header class="main-header">
            <nav class="navbar navbar-fixed-top bg-primary">
                <div class="navbar-header">
                    <a class="navbar-toggle" href="javascript:;" data-toggle="collapse"
                        data-target=".navbar-collapse"><i class="icon icon-th-large"></i></a>
                    <a class="sidebar-toggle" href="javascript:;" data-toggle="push-menu"><i
                            class="icon icon-bars"></i></a>
                    <a class="navbar-brand" href="#">
                        <span class="logo">后台管理</span>
                        <span class="logo-mini">后台管理</span>
                    </a>
                </div>
                <div class="collapse navbar-collapse">
                    <div class="container-fluid">
                        <ul class="nav navbar-nav">
                            <li><a href="javascript:;" data-toggle="push-menu"><i class="icon icon-bars"></i></a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
            
                            <li class="dropdown">
                                <a href="javascript:;" data-toggle="dropdown"><i class="icon icon-user"></i> 欢迎管理员：${admin.adminName} <span
                                        class="caret"></span></a>
                                <ul class="dropdown-menu xy-down">
                                    <li><a id="out"><i class="icon icon-times " >&nbsp;注销</i></a></li>
                                    <li><a id="changePassword"><i class="icon icon-cog " >&nbsp;修改密码</i></a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
        <aside class="main-sidebar" id = "z-sideBar">
            <section class="sidebar">
                <ul id="tree" class="sidebar-menu" data-widget="tree">
          
                </ul>
            </section>
        </aside>
        <iframe class="content-wrapper"  frameborder=0  id ="p-iframe" src="hello">
           
        </iframe>
    </div>
    
    <div id="diving2" class="diving2"></div>
		
		<div _ngcontent-c1="" class="modal-content" id="updatePwd">
			<div _ngcontent-c1="" class="modal-header">
				<button _ngcontent-c1="" class="close" type="button">
					<span _ngcontent-c1="" aria-hidden="true">×</span></button>
				<h4 _ngcontent-c1="" class="modal-title">
				<i _ngcontent-c1="" class="icon icon-edit"></i>&nbsp;修改密码</h4></div>
			<div _ngcontent-c1="" class="modal-body">
				<div _ngcontent-c1="" class="row info-msg" style="color: red;">
					<p _ngcontent-c1=""> 温馨提示:若您要修改密码，必须同时输入旧密码和新密码才能修改成功！
				</div>
				<div _ngcontent-c1="" class="row">
				</div>
				<div _ngcontent-c1="" class="row" >
					<div _ngcontent-c1="" class=" _edit-item">
						<div class="input-control has-label-left-lg has-icon-right">
							<input _ngcontent-c1="" class="form-control ng-untouched ng-pristine ng-valid" id="oldpwd" minlength="5" name="oldPasswd" type="password">
							<label _ngcontent-c1="" class="input-control-label-left text-right" for="oldPasswd">旧 密 码:</label>
							<label _ngcontent-c1="" class="input-control-icon-left" for="oldPasswd">
							<i _ngcontent-c1="" class="icon icon-key"></i></label>
							<!---->
						</div>
						<!---->
					</div>
				</div>
				<div _ngcontent-c1="" class="row">
					<div _ngcontent-c1="" class=" _edit-item">
						<div _ngcontent-c1="" class="input-control has-label-left-lg has-icon-right">
							<input _ngcontent-c1="" class="form-control ng-untouched ng-pristine ng-valid" id="newpwd" minlength="5" name="newPasswd" type="password">
							<label _ngcontent-c1="" class="input-control-label-left text-right" for="newPasswd">新 密 码:</label><label _ngcontent-c1="" class="input-control-icon-left" for="newPasswd">
								<i _ngcontent-c1="" class="icon icon-key"></i></label>
							<!---->
						</div>
						<!---->
					</div>
					<div _ngcontent-c1="" class=" _edit-item">
						<div _ngcontent-c1="" class="input-control has-label-left-lg has-icon-right">
							<input _ngcontent-c1="" class="form-control ng-untouched ng-pristine ng-valid" id="surepwd" minlength="5" name="newPasswd2" type="password">
							<label _ngcontent-c1="" class="input-control-label-left text-right" for="newPasswd2">确认密码:</label>
							<label _ngcontent-c1="" class="input-control-icon-left" for="newPasswd2">
								<i _ngcontent-c1="" class="icon icon-key"></i></label>
							<!---->
						</div>
						<!---->
					</div>
				</div>
			</div>
			<div _ngcontent-c1="" class="modal-footer">
				<button _ngcontent-c1="" class="btn btn-primary" title="保存" id="commit"><i _ngcontent-c1="" class="icon icon-save"></i> 保存 </button>
				<button _ngcontent-c1="" class="btn btn-danger" title="取消" type="button" id="cancel"><i _ngcontent-c1="" class="icon icon-times"></i> 取消 </button></div>
		</div>

    <!-- jquery js -->
    <script src="js/jquery-2.2.4.min.js"></script>
    <!-- zui js -->
    <script src="3rd/zui/js/zui.min.js"></script>
    <!-- app js -->
	<script src="3rd/layer/layer.js"></script>
    <script src="js/frameApp-mgr.js"></script>
    <script src="js/table_funs.js"></script>
    <script src="js/frame.js"></script>
</body>

</html>