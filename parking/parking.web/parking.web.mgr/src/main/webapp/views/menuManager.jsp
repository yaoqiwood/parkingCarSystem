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
    <link rel="stylesheet" href="css/menuManager.css">
    <link rel="stylesheet" href="3rd/layer/theme/default/layer.css">
    <link rel="stylesheet" href="3rd/zui/lib/datetimepicker/datetimepicker.min.css">
    <link rel="stylesheet" href="css/newcss.css">
    <title>menuManager</title>
</head>

<body>
    <div class="col-xs-12 no-padding panel panel-primary container-fluid">
        <div class="panel-heading center">
            	<i class="icon icon-columns"></i>&nbsp;菜单配置
        </div>

        <div class="panel-body container-fluid ">
            <div class="row">
                <div class="col-xs-12 col-sm-4 col-md-5 scan">
                    <div class="input-group">
                        <span class="input-group-addon">状态</span>
                        <select id="menuState" class="form-control scan-text">
                            <option value="">请选择</option>
                            <option value="0">未启用</option>
                            <option value="1">启用</option>
                        </select>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-4 col-md-5 scan">
                    <div class="input-group">
                        <span class="input-group-addon">菜单名</span>
                        <input type="text" id="menuName" class="form-control" >
                    </div>
                </div>
                <div class="col-xs-6 col-sm-2 col-md-1 scan">
                    <button class="btn btn-block btn-info" id="addBtn" type="button">增加</button>
                </div>
                <div class="col-xs-6 col-sm-2 col-md-1 scan">
                    <button class="btn btn-block btn-primary " id="Search_Btn" type="button">搜索</button>
                </div>
            </div>

            <table class="table table-bordered  table-hover" id="table">
                <thead>
                    <tr>
                        <th style="text-align:center">菜单ID</th>
                        <th style="text-align:center">父级菜单ID</th>
                        <th style="text-align:center">菜单名</th>
                        <th style="text-align:center">URL</th>
                         <th style="text-align:center">图标</th>
                        <th style="text-align:center">状态</th>
                        <th style="text-align:center">创建时间</th>
                        <th style="text-align:center">操作</th>
                    </tr>
                    </tr>
                </thead>
                <tbody id="tbody">
                
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
                    <span class="input-group-addon">菜单名</span>
                    <input type="text" class="form-control" id="addMenuName" placeholder="菜单名">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">父级ID</span>
                    <input type="text" class="form-control" id="addParentID" placeholder="父级ID">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">URL</span>
                    <input type="text" class="form-control" id="addURL" placeholder="链接">
                </div>
                <div class="center bottomSpace">
                    <button class="btn btn-primary" type="button" id="btnConfirm">确定</button>
                    <button class="btn btn-info" type="button" id="btnCancel">取消</button>
                </div>
            </div>
        </div>

        <div class="updatePanelBox" id="updatePanelBox">
            <div class="panel panel-primary">
                <div class="panel-heading">修改菜单配置</div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">菜单ID</span>
                    <input type="text" disabled id="upMenuId" class="form-control" placeholder="">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">菜单名</span>
                    <input type="text" id="upMenuName" class="form-control" placeholder="">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">父级ID</span>
                    <input type="text" class="form-control" id="upParentID" placeholder="父级ID">
                </div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">URL</span>
                    <input type="text" class="form-control" id="upURL" placeholder="链接">
                </div>
                <div class="center bottomSpace">
                    <button class="btn btn-primary" type="button" id="upBtnConfirm">确定</button>
                    <button class="btn btn-info" type="button" id="upBtnCancel">取消</button>
                </div>
            </div>
        </div>
        
        <div class="itemPanelBox" id="itemBox">
            <div class="panel panel-primary">
                <div class="panel-heading">修改菜单配置</div>
                <div class="panel-body input-group">
                    <span class="input-group-addon">图标名</span>
                    <input type="text" id="itemName" class="form-control" readonly="readonly" />
                    <input type="hidden" id="itemId" />
                </div>
                <div class="panel-body item-body input-group">
						<ul>
					<li title="resize"><i class="icon icon-resize"></i> resize</li>
					<li title="expand-full"><i class="icon icon-expand-full"></i> expand-full</li>
			<li title="collapse-full"><i class="icon icon-collapse-full"></i> collapse-full</li>
			<li title="yinyang"><i class="icon icon-yinyang"></i> yinyang</li>
			<li title="window"><i class="icon icon-window"></i> window</li>
			<li title="window-alt"><i class="icon icon-window-alt"></i> window-alt</li>
			<li title="carousel"><i class="icon icon-carousel"></i> carousel</li>
			<li title="spinner-snake"><i class="icon icon-spinner-snake"></i> spinner-snake</li>
			<li title="spinner-indicator"><i class="icon icon-spinner-indicator"></i> spinner-indicator</li>
			<li title="check-board"><i class="icon icon-check-board"></i> check-board</li>
			<li title="bar-chart"><i class="icon icon-bar-chart"></i> bar-chart</li>
			<li title="github"><i class="icon icon-github"></i> github</li>
			<li title="dot-circle"><i class="icon icon-dot-circle"></i> dot-circle</li>
			<li title="cube-alt"><i class="icon icon-cube-alt"></i> cube-alt</li>
			<li title="cubes"><i class="icon icon-cubes"></i> cubes</li>
			<li title="file-pdf"><i class="icon icon-file-pdf"></i> file-pdf</li>
			<li title="file-word"><i class="icon icon-file-word"></i> file-word</li>
			<li title="file-excel"><i class="icon icon-file-excel"></i> file-excel</li>
			<li title="file-powerpoint"><i class="icon icon-file-powerpoint"></i> file-powerpoint</li>
			<li title="file-image"><i class="icon icon-file-image"></i> file-image</li>
			<li title="file-archive"><i class="icon icon-file-archive"></i> file-archive</li>
			<li title="file-audio"><i class="icon icon-file-audio"></i> file-audio</li>
			<li title="file-movie"><i class="icon icon-file-movie"></i> file-movie</li>
			<li title="file-code"><i class="icon icon-file-code"></i> file-code</li>
			<li title="circle-o-notch"><i class="icon icon-circle-o-notch"></i> circle-o-notch</li>
			<li title="qq"><i class="icon icon-qq"></i> qq</li>
			<li title="wechat"><i class="icon icon-wechat"></i> wechat</li>
			<li title="history"><i class="icon icon-history"></i> history</li>
			<li title="circle-thin"><i class="icon icon-circle-thin"></i> circle-thin</li>
			<li title="sliders"><i class="icon icon-sliders"></i> sliders</li>
			<li title="newspaper-o"><i class="icon icon-newspaper-o"></i> newspaper-o</li>
			<li title="calculator"><i class="icon icon-calculator"></i> calculator</li>
			<li title="paint-brush"><i class="icon icon-paint-brush"></i> paint-brush</li>
			<li title="area-chart"><i class="icon icon-area-chart"></i> area-chart</li>
			<li title="pie-chart"><i class="icon icon-pie-chart"></i> pie-chart</li>
			<li title="line-chart"><i class="icon icon-line-chart"></i> line-chart</li>
			<li title="toggle-off"><i class="icon icon-toggle-off"></i> toggle-off</li>
			<li title="toggle-on"><i class="icon icon-toggle-on"></i> toggle-on</li>
			<li title="diamond"><i class="icon icon-diamond"></i> diamond</li>
			<li title="venus"><i class="icon icon-venus"></i> venus</li>
			<li title="mars"><i class="icon icon-mars"></i> mars</li>
			<li title="server"><i class="icon icon-server"></i> server</li>
			<li title="music"><i class="icon icon-music"></i> music</li>
			<li title="search"><i class="icon icon-search"></i> search</li>
			<li title="envelope"><i class="icon icon-envelope"></i> envelope</li>
			<li title="heart"><i class="icon icon-heart"></i> heart</li>
			<li title="star"><i class="icon icon-star"></i> star</li>
			<li title="star-empty"><i class="icon icon-star-empty"></i> star-empty</li>
			<li title="user"><i class="icon icon-user"></i> user</li>
			<li title="film"><i class="icon icon-film"></i> film</li>
			<li title="th-large"><i class="icon icon-th-large"></i> th-large</li>
			<li title="th"><i class="icon icon-th"></i> th</li>
			<li title="th-list"><i class="icon icon-th-list"></i> th-list</li>
			<li title="check"><i class="icon icon-check"></i> check</li>
			<li title="times"><i class="icon icon-times"></i> times</li>
			<li title="zoom-in"><i class="icon icon-zoom-in"></i> zoom-in</li>
			<li title="zoom-out"><i class="icon icon-zoom-out"></i> zoom-out</li>
			<li title="off"><i class="icon icon-off"></i> off</li>
			<li title="cog"><i class="icon icon-cog"></i> cog</li>
			<li title="trash"><i class="icon icon-trash"></i> trash</li>
			<li title="home"><i class="icon icon-home"></i> home</li>
			<li title="file-o"><i class="icon icon-file-o"></i> file-o</li>
			<li title="time"><i class="icon icon-time"></i> time</li>
			<li title="download-alt"><i class="icon icon-download-alt"></i> download-alt</li>
			<li title="download"><i class="icon icon-download"></i> download</li>
			<li title="upload"><i class="icon icon-upload"></i> upload</li>
			<li title="inbox"><i class="icon icon-inbox"></i> inbox</li>
			<li title="play-circle"><i class="icon icon-play-circle"></i> play-circle</li>
			<li title="repeat"><i class="icon icon-repeat"></i> repeat</li>
			<li title="refresh"><i class="icon icon-refresh"></i> refresh</li>
			<li title="list-alt"><i class="icon icon-list-alt"></i> list-alt</li>
			<li title="lock"><i class="icon icon-lock"></i> lock</li>
			<li title="flag"><i class="icon icon-flag"></i> flag</li>
			<li title="headphones"><i class="icon icon-headphones"></i> headphones</li>
			<li title="volume-off"><i class="icon icon-volume-off"></i> volume-off</li>
			<li title="volume-up"><i class="icon icon-volume-up"></i> volume-up</li>
			<li title="qrcode"><i class="icon icon-qrcode"></i> qrcode</li>
			<li title="barcode"><i class="icon icon-barcode"></i> barcode</li>
			<li title="tag"><i class="icon icon-tag"></i> tag</li>
			<li title="tags"><i class="icon icon-tags"></i> tags</li>
			<li title="book"><i class="icon icon-book"></i> book</li>
			<li title="bookmark"><i class="icon icon-bookmark"></i> bookmark</li>
			<li title="print"><i class="icon icon-print"></i> print</li>
			<li title="camera"><i class="icon icon-camera"></i> camera</li>
			<li title="font"><i class="icon icon-font"></i> font</li>
			<li title="bold"><i class="icon icon-bold"></i> bold</li>
			<li title="italic"><i class="icon icon-italic"></i> italic</li>
			<li title="header"><i class="icon icon-header"></i> header</li>
			<li title="underline"><i class="icon icon-underline"></i> underline</li>
			<li title="strikethrough"><i class="icon icon-strikethrough"></i> strikethrough</li>
			<li title="eraser"><i class="icon icon-eraser"></i> eraser</li>
			<li title="align-justify"><i class="icon icon-align-justify"></i> align-justify</li>
			<li title="align-left"><i class="icon icon-align-left"></i> align-left</li>
			<li title="list"><i class="icon icon-list"></i> list</li>
			<li title="picture"><i class="icon icon-picture"></i> picture</li>
			<li title="pencil"><i class="icon icon-pencil"></i> pencil</li>
			<li title="map-marker"><i class="icon icon-map-marker"></i> map-marker</li>
			<li title="adjust"><i class="icon icon-adjust"></i> adjust</li>
			<li title="tint"><i class="icon icon-tint"></i> tint</li>
			<li title="edit"><i class="icon icon-edit"></i> edit</li>
			<li title="share"><i class="icon icon-share"></i> share</li>
			<li title="checked"><i class="icon icon-checked"></i> checked</li>
			<li title="arrows"><i class="icon icon-arrows"></i> arrows</li>
			<li title="step-backward"><i class="icon icon-step-backward"></i> step-backward</li>
			<li title="fast-backward"><i class="icon icon-fast-backward"></i> fast-backward</li>
			<li title="backward"><i class="icon icon-backward"></i> backward</li>
			<li title="play"><i class="icon icon-play"></i> play</li>
			<li title="pause"><i class="icon icon-pause"></i> pause</li>
			<li title="stop"><i class="icon icon-stop"></i> stop</li>
			<li title="forward"><i class="icon icon-forward"></i> forward</li>
			<li title="fast-forward"><i class="icon icon-fast-forward"></i> fast-forward</li>
			<li title="step-forward"><i class="icon icon-step-forward"></i> step-forward</li>
			<li title="eject"><i class="icon icon-eject"></i> eject</li>
			<li title="chevron-left"><i class="icon icon-chevron-left"></i> chevron-left</li>
			<li title="chevron-right"><i class="icon icon-chevron-right"></i> chevron-right</li>
			<li title="plus-sign"><i class="icon icon-plus-sign"></i> plus-sign</li>
			<li title="minus-sign"><i class="icon icon-minus-sign"></i> minus-sign</li>
			<li title="remove-sign"><i class="icon icon-remove-sign"></i> remove-sign</li>
			<li title="check-circle"><i class="icon icon-check-circle"></i> check-circle</li>
			<li title="question-sign"><i class="icon icon-question-sign"></i> question-sign</li>
			<li title="info-sign"><i class="icon icon-info-sign"></i> info-sign</li>
			<li title="remove-circle"><i class="icon icon-remove-circle"></i> remove-circle</li>
			<li title="check-circle-o"><i class="icon icon-check-circle-o"></i> check-circle-o</li>
			<li title="ban-circle"><i class="icon icon-ban-circle"></i> ban-circle</li>
			<li title="arrow-left"><i class="icon icon-arrow-left"></i> arrow-left</li>
			<li title="arrow-right"><i class="icon icon-arrow-right"></i> arrow-right</li>
			<li title="arrow-up"><i class="icon icon-arrow-up"></i> arrow-up</li>
			<li title="arrow-down"><i class="icon icon-arrow-down"></i> arrow-down</li>
			<li title="share-alt"><i class="icon icon-share-alt"></i> share-alt</li>
			<li title="resize-full"><i class="icon icon-resize-full"></i> resize-full</li>
			<li title="resize-small"><i class="icon icon-resize-small"></i> resize-small</li>
			<li title="plus"><i class="icon icon-plus"></i> plus</li>
			<li title="minus"><i class="icon icon-minus"></i> minus</li>
			<li title="asterisk"><i class="icon icon-asterisk"></i> asterisk</li>
			<li title="exclamation-sign"><i class="icon icon-exclamation-sign"></i> exclamation-sign</li>
			<li title="gift"><i class="icon icon-gift"></i> gift</li>
			<li title="leaf"><i class="icon icon-leaf"></i> leaf</li>
			<li title="eye-open"><i class="icon icon-eye-open"></i> eye-open</li>
			<li title="eye-close"><i class="icon icon-eye-close"></i> eye-close</li>
			<li title="warning-sign"><i class="icon icon-warning-sign"></i> warning-sign</li>
			<li title="plane"><i class="icon icon-plane"></i> plane</li>
			<li title="calendar"><i class="icon icon-calendar"></i> calendar</li>
			<li title="random"><i class="icon icon-random"></i> random</li>
			<li title="comment"><i class="icon icon-comment"></i> comment</li>
			<li title="chevron-up"><i class="icon icon-chevron-up"></i> chevron-up</li>
			<li title="chevron-down"><i class="icon icon-chevron-down"></i> chevron-down</li>
			<li title="shopping-cart"><i class="icon icon-shopping-cart"></i> shopping-cart</li>
			<li title="folder-close"><i class="icon icon-folder-close"></i> folder-close</li>
			<li title="folder-open"><i class="icon icon-folder-open"></i> folder-open</li>
			<li title="resize-v"><i class="icon icon-resize-v"></i> resize-v</li>
			<li title="resize-h"><i class="icon icon-resize-h"></i> resize-h</li>
			<li title="bar-chart-alt"><i class="icon icon-bar-chart-alt"></i> bar-chart-alt</li>
			<li title="camera-retro"><i class="icon icon-camera-retro"></i> camera-retro</li>
			<li title="key"><i class="icon icon-key"></i> key</li>
			<li title="cogs"><i class="icon icon-cogs"></i> cogs</li>
			<li title="comments"><i class="icon icon-comments"></i> comments</li>
			<li title="thumbs-o-up"><i class="icon icon-thumbs-o-up"></i> thumbs-o-up</li>
			<li title="thumbs-o-down"><i class="icon icon-thumbs-o-down"></i> thumbs-o-down</li>
			<li title="star-half"><i class="icon icon-star-half"></i> star-half</li>
			<li title="heart-empty"><i class="icon icon-heart-empty"></i> heart-empty</li>
			<li title="signout"><i class="icon icon-signout"></i> signout</li>
			<li title="pushpin"><i class="icon icon-pushpin"></i> pushpin</li>
			<li title="external-link"><i class="icon icon-external-link"></i> external-link</li>
			<li title="signin"><i class="icon icon-signin"></i> signin</li>
			<li title="trophy"><i class="icon icon-trophy"></i> trophy</li>
			<li title="upload-alt"><i class="icon icon-upload-alt"></i> upload-alt</li>
			<li title="lemon"><i class="icon icon-lemon"></i> lemon</li>
			<li title="phone"><i class="icon icon-phone"></i> phone</li>
			<li title="check-empty"><i class="icon icon-check-empty"></i> check-empty</li>
			<li title="bookmark-empty"><i class="icon icon-bookmark-empty"></i> bookmark-empty</li>
			<li title="phone-sign"><i class="icon icon-phone-sign"></i> phone-sign</li>
			<li title="credit"><i class="icon icon-credit"></i> credit</li>
			<li title="rss"><i class="icon icon-rss"></i> rss</li>
			<li title="hdd"><i class="icon icon-hdd"></i> hdd</li>
			<li title="bullhorn"><i class="icon icon-bullhorn"></i> bullhorn</li>
			<li title="bell"><i class="icon icon-bell"></i> bell</li>
			<li title="certificate"><i class="icon icon-certificate"></i> certificate</li>
			<li title="hand-right"><i class="icon icon-hand-right"></i> hand-right</li>
			<li title="hand-left"><i class="icon icon-hand-left"></i> hand-left</li>
			<li title="hand-up"><i class="icon icon-hand-up"></i> hand-up</li>
			<li title="hand-down"><i class="icon icon-hand-down"></i> hand-down</li>
			<li title="circle-arrow-left"><i class="icon icon-circle-arrow-left"></i> circle-arrow-left</li>
			<li title="circle-arrow-right"><i class="icon icon-circle-arrow-right"></i> circle-arrow-right</li>
			<li title="circle-arrow-up"><i class="icon icon-circle-arrow-up"></i> circle-arrow-up</li>
			<li title="circle-arrow-down"><i class="icon icon-circle-arrow-down"></i> circle-arrow-down</li>
			<li title="globe"><i class="icon icon-globe"></i> globe</li>
			<li title="wrench"><i class="icon icon-wrench"></i> wrench</li>
			<li title="tasks"><i class="icon icon-tasks"></i> tasks</li>
			<li title="filter"><i class="icon icon-filter"></i> filter</li>
			<li title="group"><i class="icon icon-group"></i> group</li>
			<li title="link"><i class="icon icon-link"></i> link</li>
			<li title="cloud"><i class="icon icon-cloud"></i> cloud</li>
			<li title="beaker"><i class="icon icon-beaker"></i> beaker</li>
			<li title="cut"><i class="icon icon-cut"></i> cut</li>
			<li title="copy"><i class="icon icon-copy"></i> copy</li>
			<li title="paper-clip"><i class="icon icon-paper-clip"></i> paper-clip</li>
			<li title="save"><i class="icon icon-save"></i> save</li>
			<li title="sign-blank"><i class="icon icon-sign-blank"></i> sign-blank</li>
			<li title="bars"><i class="icon icon-bars"></i> bars</li>
			<li title="list-ul"><i class="icon icon-list-ul"></i> list-ul</li>
			<li title="list-ol"><i class="icon icon-list-ol"></i> list-ol</li>
			<li title="table"><i class="icon icon-table"></i> table</li>
			<li title="magic"><i class="icon icon-magic"></i> magic</li>
			<li title="caret-down"><i class="icon icon-caret-down"></i> caret-down</li>
			<li title="caret-up"><i class="icon icon-caret-up"></i> caret-up</li>
			<li title="caret-left"><i class="icon icon-caret-left"></i> caret-left</li>
			<li title="caret-right"><i class="icon icon-caret-right"></i> caret-right</li>
			<li title="columns"><i class="icon icon-columns"></i> columns</li>
			<li title="sort"><i class="icon icon-sort"></i> sort</li>
			<li title="sort-down"><i class="icon icon-sort-down"></i> sort-down</li>
			<li title="sort-up"><i class="icon icon-sort-up"></i> sort-up</li>
			<li title="envelope-alt"><i class="icon icon-envelope-alt"></i> envelope-alt</li>
			<li title="undo"><i class="icon icon-undo"></i> undo</li>
			<li title="dashboard"><i class="icon icon-dashboard"></i> dashboard</li>
			<li title="comment-alt"><i class="icon icon-comment-alt"></i> comment-alt</li>
			<li title="comments-alt"><i class="icon icon-comments-alt"></i> comments-alt</li>
			<li title="bolt"><i class="icon icon-bolt"></i> bolt</li>
			<li title="sitemap"><i class="icon icon-sitemap"></i> sitemap</li>
			<li title="umbrella"><i class="icon icon-umbrella"></i> umbrella</li>
			<li title="paste"><i class="icon icon-paste"></i> paste</li>
			<li title="lightbulb"><i class="icon icon-lightbulb"></i> lightbulb</li>
			<li title="exchange"><i class="icon icon-exchange"></i> exchange</li>
			<li title="cloud-download"><i class="icon icon-cloud-download"></i> cloud-download</li>
			<li title="cloud-upload"><i class="icon icon-cloud-upload"></i> cloud-upload</li>
			<li title="bell-alt"><i class="icon icon-bell-alt"></i> bell-alt</li>
			<li title="coffee"><i class="icon icon-coffee"></i> coffee</li>
			<li title="file-text-o"><i class="icon icon-file-text-o"></i> file-text-o</li>
			<li title="building"><i class="icon icon-building"></i> building</li>
			<li title="double-angle-left"><i class="icon icon-double-angle-left"></i> double-angle-left</li>
			<li title="double-angle-right"><i class="icon icon-double-angle-right"></i> double-angle-right</li>
			<li title="double-angle-up"><i class="icon icon-double-angle-up"></i> double-angle-up</li>
			<li title="double-angle-down"><i class="icon icon-double-angle-down"></i> double-angle-down</li>
			<li title="angle-left"><i class="icon icon-angle-left"></i> angle-left</li>
			<li title="angle-right"><i class="icon icon-angle-right"></i> angle-right</li>
			<li title="angle-up"><i class="icon icon-angle-up"></i> angle-up</li>
			<li title="angle-down"><i class="icon icon-angle-down"></i> angle-down</li>
			<li title="desktop"><i class="icon icon-desktop"></i> desktop</li>
			<li title="laptop"><i class="icon icon-laptop"></i> laptop</li>
			<li title="tablet"><i class="icon icon-tablet"></i> tablet</li>
			<li title="mobile"><i class="icon icon-mobile"></i> mobile</li>
			<li title="circle-blank"><i class="icon icon-circle-blank"></i> circle-blank</li>
			<li title="quote-left"><i class="icon icon-quote-left"></i> quote-left</li>
			<li title="quote-right"><i class="icon icon-quote-right"></i> quote-right</li>
			<li title="spinner"><i class="icon icon-spinner"></i> spinner</li>
			<li title="circle"><i class="icon icon-circle"></i> circle</li>
			<li title="reply"><i class="icon icon-reply"></i> reply</li>
			<li title="folder-close-alt"><i class="icon icon-folder-close-alt"></i> folder-close-alt</li>
			<li title="folder-open-alt"><i class="icon icon-folder-open-alt"></i> folder-open-alt</li>
			<li title="expand-alt"><i class="icon icon-expand-alt"></i> expand-alt</li>
			<li title="collapse-alt"><i class="icon icon-collapse-alt"></i> collapse-alt</li>
			<li title="smile"><i class="icon icon-smile"></i> smile</li>
			<li title="frown"><i class="icon icon-frown"></i> frown</li>
			<li title="meh"><i class="icon icon-meh"></i> meh</li>
			<li title="gamepad"><i class="icon icon-gamepad"></i> gamepad</li>
			<li title="keyboard"><i class="icon icon-keyboard"></i> keyboard</li>
			<li title="flag-alt"><i class="icon icon-flag-alt"></i> flag-alt</li>
			<li title="flag-checkered"><i class="icon icon-flag-checkered"></i> flag-checkered</li>
			<li title="terminal"><i class="icon icon-terminal"></i> terminal</li>
			<li title="code"><i class="icon icon-code"></i> code</li>
			<li title="reply-all"><i class="icon icon-reply-all"></i> reply-all</li>
			<li title="star-half-full"><i class="icon icon-star-half-full"></i> star-half-full</li>
			<li title="location-arrow"><i class="icon icon-location-arrow"></i> location-arrow</li>
			<li title="crop"><i class="icon icon-crop"></i> crop</li>
			<li title="code-fork"><i class="icon icon-code-fork"></i> code-fork</li>
			<li title="unlink"><i class="icon icon-unlink"></i> unlink</li>
			<li title="question"><i class="icon icon-question"></i> question</li>
			<li title="info"><i class="icon icon-info"></i> info</li>
			<li title="shield"><i class="icon icon-shield"></i> shield</li>
			<li title="calendar-empty"><i class="icon icon-calendar-empty"></i> calendar-empty</li>
			<li title="rocket"><i class="icon icon-rocket"></i> rocket</li>
			<li title="chevron-sign-left"><i class="icon icon-chevron-sign-left"></i> chevron-sign-left</li>
			<li title="chevron-sign-right"><i class="icon icon-chevron-sign-right"></i> chevron-sign-right</li>
			<li title="chevron-sign-up"><i class="icon icon-chevron-sign-up"></i> chevron-sign-up</li>
			<li title="chevron-sign-down"><i class="icon icon-chevron-sign-down"></i> chevron-sign-down</li>
			<li title="html5"><i class="icon icon-html5"></i> html5</li>
			<li title="anchor"><i class="icon icon-anchor"></i> anchor</li>
			<li title="unlock-alt"><i class="icon icon-unlock-alt"></i> unlock-alt</li>
			<li title="bullseye"><i class="icon icon-bullseye"></i> bullseye</li>
			<li title="ellipsis-h"><i class="icon icon-ellipsis-h"></i> ellipsis-h</li>
			<li title="ellipsis-v"><i class="icon icon-ellipsis-v"></i> ellipsis-v</li>
			<li title="rss-sign"><i class="icon icon-rss-sign"></i> rss-sign</li>
			<li title="play-sign"><i class="icon icon-play-sign"></i> play-sign</li>
			<li title="minus-sign-alt"><i class="icon icon-minus-sign-alt"></i> minus-sign-alt</li>
			<li title="plus-sign-alt"><i class="icon icon-plus-sign-alt"></i> plus-sign-alt</li>
			<li title="check-minus"><i class="icon icon-check-minus"></i> check-minus</li>
			<li title="check-plus"><i class="icon icon-check-plus"></i> check-plus</li>
			<li title="level-up"><i class="icon icon-level-up"></i> level-up</li>
			<li title="level-down"><i class="icon icon-level-down"></i> level-down</li>
			<li title="check-sign"><i class="icon icon-check-sign"></i> check-sign</li>
			<li title="edit-sign"><i class="icon icon-edit-sign"></i> edit-sign</li>
			<li title="external-link-sign"><i class="icon icon-external-link-sign"></i> external-link-sign</li>
			<li title="share-sign"><i class="icon icon-share-sign"></i> share-sign</li>
			<li title="compass"><i class="icon icon-compass"></i> compass</li>
			<li title="collapse"><i class="icon icon-collapse"></i> collapse</li>
			<li title="collapse-top"><i class="icon icon-collapse-top"></i> collapse-top</li>
			<li title="expand"><i class="icon icon-expand"></i> expand</li>
			<li title="dollar"><i class="icon icon-dollar"></i> dollar</li>
			<li title="yen"><i class="icon icon-yen"></i> yen</li>
			<li title="file"><i class="icon icon-file"></i> file</li>
			<li title="file-text"><i class="icon icon-file-text"></i> file-text</li>
			<li title="sort-by-alphabet"><i class="icon icon-sort-by-alphabet"></i> sort-by-alphabet</li>
			<li title="sort-by-alphabet-alt"><i class="icon icon-sort-by-alphabet-alt"></i> sort-by-alphabet-alt</li>
			<li title="sort-by-attributes"><i class="icon icon-sort-by-attributes"></i> sort-by-attributes</li>
			<li title="sort-by-attributes-alt"><i class="icon icon-sort-by-attributes-alt"></i> sort-by-attributes-alt</li>
			<li title="sort-by-order"><i class="icon icon-sort-by-order"></i> sort-by-order</li>
			<li title="sort-by-order-alt"><i class="icon icon-sort-by-order-alt"></i> sort-by-order-alt</li>
			<li title="thumbs-up"><i class="icon icon-thumbs-up"></i> thumbs-up</li>
			<li title="thumbs-down"><i class="icon icon-thumbs-down"></i> thumbs-down</li>
			<li title="long-arrow-down"><i class="icon icon-long-arrow-down"></i> long-arrow-down</li>
			<li title="long-arrow-up"><i class="icon icon-long-arrow-up"></i> long-arrow-up</li>
			<li title="long-arrow-left"><i class="icon icon-long-arrow-left"></i> long-arrow-left</li>
			<li title="long-arrow-right"><i class="icon icon-long-arrow-right"></i> long-arrow-right</li>
			<li title="apple"><i class="icon icon-apple"></i> apple</li>
			<li title="windows"><i class="icon icon-windows"></i> windows</li>
			<li title="android"><i class="icon icon-android"></i> android</li>
			<li title="linux"><i class="icon icon-linux"></i> linux</li>
			<li title="sun"><i class="icon icon-sun"></i> sun</li>
			<li title="moon"><i class="icon icon-moon"></i> moon</li>
			<li title="archive"><i class="icon icon-archive"></i> archive</li>
			<li title="bug"><i class="icon icon-bug"></i> bug</li>
			<li title="zhifubao"><i class="icon icon-zhifubao"></i> zhifubao</li>
			<li title="zhifubao-square"><i class="icon icon-zhifubao-square"></i> zhifubao-square</li>
			<li title="taobao"><i class="icon icon-taobao"></i> taobao</li>
			<li title="weibo"><i class="icon icon-weibo"></i> weibo</li>
			<li title="renren"><i class="icon icon-renren"></i> renren</li>
			<li title="chrome"><i class="icon icon-chrome"></i> chrome</li>
			<li title="firefox"><i class="icon icon-firefox"></i> firefox</li>
			<li title="ie"><i class="icon icon-ie"></i> ie</li>
			<li title="opera"><i class="icon icon-opera"></i> opera</li>
			<li title="safari"><i class="icon icon-safari"></i> safari</li>
			<li title="node"><i class="icon icon-node"></i> node</li>
			<li title="layout"><i class="icon icon-layout"></i> layout</li>
			<li title="usecase"><i class="icon icon-usecase"></i> usecase</li>
			<li title="stack"><i class="icon icon-stack"></i> stack</li>
			<li title="branch"><i class="icon icon-branch"></i> branch</li>
			<li title="chat"><i class="icon icon-chat"></i> chat</li>
			<li title="chat-line"><i class="icon icon-chat-line"></i> chat-line</li>
			<li title="chat-dot"><i class="icon icon-chat-dot"></i> chat-dot</li>
			<li title="cube"><i class="icon icon-cube"></i> cube</li>
			<li title="database"><i class="icon icon-database"></i> database</li>
			<li title="chanzhi"><i class="icon icon-chanzhi"></i> chanzhi</li>
			<li title="chanzhi-pro"><i class="icon icon-chanzhi-pro"></i> chanzhi-pro</li>
			<li title="zsite"><i class="icon icon-zsite"></i> zsite</li>
			<li title="zsite-pro"><i class="icon icon-zsite-pro"></i> zsite-pro</li>
		</ul>
				
                </div>
                
                 <div class="center bottomSpace">
                    <button class="btn btn-primary" type="button" id="itemConfrim">确定</button>
                    <button class="btn btn-info" type="button" id="itemCancel">取消</button>
                </div>
            </div>
        </div>
        
</body>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="3rd/zui/js/zui.min.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="3rd/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="js/common.js"></script>
<script src="3rd/layer/layer.js"></script>
<script src="js/table_funs.js"></script>
<script src="js/menuManager.js"></script>
</html>