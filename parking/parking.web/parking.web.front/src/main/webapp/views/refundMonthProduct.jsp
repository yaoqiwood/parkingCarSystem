<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="3rd/zui/css/zui.min.css">
    <link rel="stylesheet" href="3rd/layer/theme/default/layer.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/monthProduct.css">
    <link rel="stylesheet" href="css/noBorder.css">
    <link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
    <title>月缴退费</title>
</head>

<body>
    <div class="col-xs-12 no-padding panel panel-primary container-fluid">
        <div class="panel-heading center">
            月缴退费
        </div>

        <div class="panel-body container-fluid ">
            <div class="row">
                <div class="col-md-4">
                    <div class="input-group">
                        <span class="input-group-addon">车牌号</span>
                        <input type="text" id="carNum" class="form-control" >
                    </div>
                    <br>
                </div>
                <div class="left">
                    <button class="btn btn-primary" id="selectBtn" type="button">搜索</button>
                </div>
                <br>
            </div>

            <table class="table table-bordered  table-hover" id="table">
                <thead>
                    <tr>
                        <th style="text-align:center">序号</th>
                        <th style="text-align:center">月缴产品</th>
                        <th style="text-align:center">状态</th>
                        <th style="text-align:center">创建时间</th>
                        <th style="text-align:center">操作</th>
                    </tr>
                </thead>
                <tbody align="center">
                	<tr class="tr"></tr>
                </tbody>
            </table>
            <div class="floatRight">
                <ul id="myPager" class="pager" data-ride="pager" data-elements="prev_icon,page_of_total_text,next_icon">
                    <li class="pager-item-left pager-item-right"><a id="lastPageBtn" class="pager-item" data-page="0"><i
                                class="icon icon-double-angle-left"></i></a></li>
                    <li>
                        <div class="pager-label">第 <strong id="CurPageView">1</strong>/<strong
                                id="TotalPageView">1</strong>
                            页</div>
                    </li>
                    <li class="pager-item-left"><a id="nextPageBtn" class="pager-item" data-page="1"><i
                                class="icon icon-double-angle-right"></i></a></li>
                </ul>
            </div>

        </div>

        <div class="addPanelBox" id="adddialog">
            <div class="panel panel-primary">
                <div class="panel-heading">产品退费</div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">退还费用：</span>
                    <input type="text" disabled class="form-control" id="money" >
                </div>
                <div class="center bottomSpace">
                    <button class="btn btn-info" type="button" id="addcancel">返回</button>
                </div>
            </div>
        </div>
        <div class="backWhite" id="backWhite"></div>
</body>
<script src="3rd/zui/js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/table_funs.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="js/refundMonthProduct.js"></script>

</html>