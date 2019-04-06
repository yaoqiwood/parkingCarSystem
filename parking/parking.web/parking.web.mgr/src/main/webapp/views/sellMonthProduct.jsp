<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="3rd/zui/css/zui.min.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="3rd/layer/theme/default/layer.css">
    <link rel="stylesheet" href="css/monthProduct.css">
    <link rel="stylesheet" href="css/noBorder.css">
    <link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
    <link rel="stylesheet" href="css/newcss.css">
    <title>月缴业务显示</title>
</head>

<body>
    <div class="col-xs-12 no-padding panel panel-primary container-fluid">
        <div class="panel-heading center">
            	<i class="icon-yen"></i> &nbsp;业务办理
        </div>

        <div class="panel-body container-fluid ">
            <div class="row">
                <div class="col-xs-7 col-sm-8 col-md-6 scan">
                    <div class="input-group">
                        <span class="input-group-addon">车牌号</span>
                        <input type="text" id="carNum" class="form-control" >
                    </div>
                </div>
                <div class="col-xs-5 col-sm-4 col-md-2 scan">
                      <button class="btn btn-info rightBigSpace" id="buyBtn" type="button">购买</button>
                </div>
            </div>

            <table class="table table-bordered  table-hover" id="table">
                <thead>
                    <tr>
                    	<th style="text-align:center">选择</th>
                        <th style="text-align:center">序号</th>
                        <th style="text-align:center">月缴产品</th>
                        <th style="text-align:center">价格</th>
                    </tr>
                </thead>
                <tbody align="center">
                	<tr class="tr"></tr>
                </tbody>
            </table>

        </div>

        <div class="addPanelBox" id="adddialog">
            <div class="panel panel-primary">
                <div class="panel-heading">购买产品</div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">请支付：</span>
                    <input type="text" disabled class="form-control" id="money" >
                </div>
                <div class="center bottomSpace">
                    <button class="btn btn-primary" type="button" id="addcommit">支付</button>
                    <button class="btn btn-info" type="button" id="addcancel">返回</button>
                </div>
            </div>
        </div>
        <div class="backWhite" id="backWhite"></div>
</body>
<script src="3rd/zui/js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/sellMonthProduct.js"></script>

</html>