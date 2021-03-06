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
    <link rel="stylesheet" href="css/configure.css">
    <link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
    <title>configure</title>
</head>

<body>
    <div class="col-xs-12 no-padding panel panel-primary container-fluid">
        <div class="panel-heading center">
            配置参数管理
        </div>

        <div class="panel-body container-fluid ">
            <div class="row">
                <div class="col-xs-12 col-sm-6 col-md-3 scan">
                    <div class="input-group">
                        <span class="input-group-addon">参数名</span>
                        <input type="text" id="configureName" class="form-control" placeholder="参数名">
                    </div>
                    <br>
                </div>
                <div class="col-xs-12 col-md-4 scan">
                    <button class="btn btn-info rightBigSpace" id="addBtn" type="button">增加</button>
                    <button class="btn btn-primary " id="Search_Btn" type="button">搜索</button>
                </div>
                <br>
            </div>

            <table class="table table-bordered  table-hover" id="table">
                <thead>
                    <tr>
                        <th style="text-align:center">配置ID</th>
                        <th style="text-align:center">配置名</th>
                        <th style="text-align:center">配置参数</th>
                        <th style="text-align:center">配置状态</th>
                        <th style="text-align:center">配置创建时间</th>
                        <th style="text-align:center">操作</th>
                    </tr>
                    </tr>
                </thead>
                <tbody id="tbody">
                    <!-- <tr>
                        <td>1</td>
                        <td>Sunshine</td>
                        <td>Sunday</td>
                        <td>catouse</td>
                        <td>catouse</td>
                        <td>
                            <button class="btn btn-info " type="button">修改</button>
                            <button class="btn btn-warning " type="button">禁用</button>
                            <button class="btn btn-danger " type="button">删除</button>
                        </td>
                    </tr> -->
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


        <div class="addPanelBox" id="addPanelBox">
            <div class="panel panel-primary">
                <div class="panel-heading">添加菜单配置</div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">配置名</span>
                    <input type="text" class="form-control" id = "addConfigureName" placeholder="配置名">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">配置参数</span>
                    <input type="text" class="form-control" id = "addConfigureValue" placeholder="配置参数">
                </div>
                <div class="center bottomSpace">
                    <button class="btn btn-primary" type="button" id="btnConfirm">确定</button>
                    <button class="btn btn-info" type="button" id="btnCancel">取消</button>
                </div>
            </div>
        </div>

        <div class="updatePanelBox" id="updatePanelBox">
            <div class="panel panel-primary">
                <div class="panel-heading">修改配置</div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">配置ID</span>
                    <input type="text" disabled id = "upConfigID" class="form-control" placeholder="配置名">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">配置名:</span>
                    <input type="text" id = upConfigName class="form-control" placeholder="配置名">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">配置参数</span>
                    <input type="text" class="form-control" id = "upConfigParamter" placeholder="配置参数">
                </div>
                <div class="center bottomSpace">
                    <button class="btn btn-primary" type="button" id="upBtnConfirm">确定</button>
                    <button class="btn btn-info" type="button" id="upBtnCancel">取消</button>
                </div>
            </div>
        </div>
        <div class="backWhite" id="backWhite"></div>
</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="js/common.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/configure.js"></script>

</html>