<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>临时月缴用户统计</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="3rd/zui/css/zui.min.css">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet"
	href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
<link rel="stylesheet" href="css/incomeMonth.css">
<style type="text/css">

</style>

</head>

<body>
	<div class="col-xs-12 no-padding panel panel-primary ">
		<div class="panel-heading center">临时月缴用户统计</div>

		<div class="panel-body container-fluid">
			<div class="row">
				<div class="col-md-3 col-sm-6 col-xs-12">
		            <div class="info-box bg-danger">
		                <div class="info-box-icon">
		                    <i class="icon icon-user"></i>
		                </div>
		                <div class="info-box-content">
		                    <span class="info-box-text">临时用户收入</span>
		                    <span class="info-box-number" id="sumCasual" >90
		                        <small>个</small>
		                    </span>
		                </div>
		            </div>
		        </div>
		        <div class="col-md-3 col-sm-6 col-xs-12">
		            <div class="info-box bg-warning">
		                <div class="info-box-icon">
		                    <i class="icon icon-moon"></i>
		                </div>
		                <div class="info-box-content">
		                    <span class="info-box-text">月缴用户收入</span>
		                    <span class="info-box-number" id="sumMonth">8
		                        <small>个</small>
		                    </span>
		                </div>
		            </div>
		        </div>
			</div>
		</div>
		<div class="col-md-6  col-xs-12">
			<div id="main" style="width: 600px;height:400px;"></div>
		</div>
		<div class="col-md-6  col-xs-12">
			<table class="table table-bordered  table-hover" id="tb">
				<thead>
					<tr>
                        <th style="text-align:center">序号</th>
                        <th style="text-align:center">用户类型</th>
                        <th style="text-align:center">车牌号</th>
                        <th style="text-align:center">消费</th>
                        <th style="text-align:center">操作记录</th>
                        <th style="text-align:center">操作时间</th>
                    </tr>
				</thead>
				<tbody id="tbody">
					<tr class="tr">
						<td>1</td>
						<td>临时用户</td>
						<td>京A22222</td>
						<td>10</td>
						<td>1小时</td>
						<td>2019-01-22</td>
					</tr>
					<tr class="tr">
						<td>2</td>
						<td>月缴用户</td>
						<td>京A33333</td>
						<td>15</td>
						<td>2小时</td>
						<td>2019-01-23</td>
					</tr>

				</tbody>
			</table>
			<div class="floatRight">
				<ul id="myPager" class="pager" data-ride="pager"
					data-elements="prev_icon,page_of_total_text,next_icon">
					<li class="pager-item-left pager-item-right"><a
						id="lastPageBtn" class="pager-item" data-page="0"><i
							class="icon icon-double-angle-left"></i></a></li>
					<li>
						<div class="pager-label">
							第 <strong id="CurPageView">1</strong>/<strong id="TotalPageView">1</strong>
							页
						</div>
					</li>
					<li class="pager-item-left"><a id="nextPageBtn"
						class="pager-item" data-page="1"><i
							class="icon icon-double-angle-right"></i></a></li>
				</ul>
			</div>
		</div>

	</div>
	
</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/echarts.common.min.js"></script>
<script src="js/shine.js"></script>
<script src="js/incomeMonth.js"></script>

</html>