<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>分类管理</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="${ctxStatic}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${ctxStatic}/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/assets/css/my_css.css" type="text/css" />
	<!--[if IE 7]>
	<link rel="stylesheet" href="${ctxStatic}/assets/css/font-awesome-ie7.min.css" />
	<![endif]-->

	<!-- page specific plugin styles -->

	<!-- fonts -->

	<!--
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
    -->
	<link href="${ctxStatic}/assets/css/font-gooleapis.css" type="text/css" rel="stylesheet">
	<!-- ace styles -->

	<link rel="stylesheet" href="${ctxStatic}/assets/css/ace.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/assets/css/ace-skins.min.css" />

	<!--[if lte IE 8]>
	<link rel="stylesheet" href="${ctxStatic}/assets/css/ace-ie.min.css" />
	<![endif]-->

	<!-- inline styles related to this page -->

	<!-- ace settings handler -->

	<script src="${ctxStatic}/assets/js/ace-extra.min.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

	<!--[if lt IE 9]>
	<script src="${ctxStatic}/assets/js/html5shiv.js"></script>
	<script src="${ctxStatic}/assets/js/respond.min.js"></script>
	<![endif]-->







	<!-- basic scripts -->

	<!--[if !IE]> -->

	<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
-->
	<script src="${ctxStatic}/assets/js/jquery-2.0.3.min.js"></script>
	<!-- <![endif]-->

	<!--[if IE]>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery || document.write("<script src='${ctxStatic}/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
	<script type="text/javascript">
		window.jQuery || document.write("<script src='${ctxStatic}/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
	</script>
	<![endif]-->

	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='${ctxStatic}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
	</script>
	<script src="${ctxStatic}/assets/js/bootstrap.min.js"></script>
	<script src="${ctxStatic}/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
	<script src="${ctxStatic}/assets/js/excanvas.min.js"></script>
	<![endif]-->

	<script src="${ctxStatic}/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${ctxStatic}/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${ctxStatic}/assets/js/jquery.slimscroll.min.js"></script>
	<script src="${ctxStatic}/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${ctxStatic}/assets/js/jquery.sparkline.min.js"></script>
	<!--<script src="assets/js/flot/jquery.flot.min.js"></script>
    <script src="assets/js/flot/jquery.flot.pie.min.js"></script>
    <script src="assets/js/flot/jquery.flot.resize.min.js"></script>
-->
	<!-- ace scripts -->

	<script src="${ctxStatic}/assets/js/ace-elements.min.js"></script>
	<script src="${ctxStatic}/assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->

	<script type="text/javascript">
		jQuery(function($) {
			$('.easy-pie-chart.percentage').each(function(){
				var $box = $(this).closest('.infobox');
				var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
				var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
				var size = parseInt($(this).data('size')) || 50;
				$(this).easyPieChart({
					barColor: barColor,
					trackColor: trackColor,
					scaleColor: false,
					lineCap: 'butt',
					lineWidth: parseInt(size/10),
					animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
					size: size
				});
			})

			$('.sparkline').each(function(){
				var $box = $(this).closest('.infobox');
				var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
				$(this).sparkline('html', {tagValuesAttribute:'data-values', type: 'bar', barColor: barColor , chartRangeMin:$(this).data('min') || 0} );
			});


			$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('.tab-content')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				var w2 = $source.width();

				if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
				return 'left';
			}


			$('.dialogs,.comments').slimScroll({
				height: '300px'
			});


			//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
			//so disable dragging when clicking on label
			var agent = navigator.userAgent.toLowerCase();
			if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
				$('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				});

			$('#tasks').sortable({
						opacity:0.8,
						revert:true,
						forceHelperSize:true,
						placeholder: 'draggable-placeholder',
						forcePlaceholderSize:true,
						tolerance:'pointer',
						stop: function( event, ui ) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
							$(ui.item).css('z-index', 'auto');
						}
					}
			);
			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
				if(this.checked) $(this).closest('li').addClass('selected');
				else $(this).closest('li').removeClass('selected');
			});




			/*	var oBtn=$("a[title='修改']");

			 oBtn.each(function(index,e){
			 oBtn.eq(index).on("click",function(){
			 var oName=$(this).parents('tr').children('.name').html();
			 var oPrice=$(this).parents('tr').children('.price').html();
			 var oPass=$(this).parents('tr').children('.pass').html();
			 var oPoints=$(this).parents('tr').children('.points').html();
			 var oJfxfe=$(this).parents('tr').children('.jfxfe').html();
			 var oYxfe=$(this).parents('tr').children('.yxfe').html();
			 var oPhone=$(this).parents('tr').children('.phone').html();
			 window.location.href='x_xiugaiyonghu.html?data='+oName+'*'+oPass+'*'+oPoints+'*'+oPrice+'*'+oJfxfe+'*'+oYxfe+'*'+oPhone;
			 //alert(oName+'-'+oPrice+'-'+oTime)
			 });
			 })//x_taocanxiugai*/




		})

	</script>


	<!--[if IE]>
	<script type="text/javascript">
		window.jQuery || document.write("<script src='${ctxStatic}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
	</script>
	<![endif]-->



</head>

<body>
<div class="navbar navbar-default" id="navbar">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	</script>

	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand">
				<small>
					<i class="icon-leaf"></i>
					后台管理系统
				</small>
			</a><!-- /.brand -->
		</div><!-- /.navbar-header -->

		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="${ctxStatic}/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
									admin
								</span>

						<i class="icon-caret-down"></i>
					</a>

					<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="#">
								<i class="icon-cog"></i>
								设置
							</a>
						</li>

						<li>
							<a href="#">
								<i class="icon-user"></i>
								个人资料
							</a>
						</li>

						<li class="divider"></li>

						<li>
							<a href="#">
								<i class="icon-off"></i>
								退出
							</a>
						</li>
					</ul>
				</li>
			</ul><!-- /.ace-nav -->
		</div><!-- /.navbar-header -->
	</div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>

	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#">
			<span class="menu-text"></span>
		</a>

		<div class="sidebar" id="sidebar">
			<script type="text/javascript">
				try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
			</script>

			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="icon-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="icon-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="icon-group"></i>
					</button>

					<button class="btn btn-danger">
						<i class="icon-cogs"></i>
					</button>
				</div>

				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span>

					<span class="btn btn-info"></span>

					<span class="btn btn-warning"></span>

					<span class="btn btn-danger"></span>
				</div>
			</div><!-- #sidebar-shortcuts -->

			<ul class="nav nav-list">
				<li class="">
					<a href="${ctx}/user/index">
						<i class="icon-dashboard"></i>
						<span class="menu-text"> 控制台 </span>
					</a>
				</li>

				<li class="">
					<a href="${ctx}/Goods/select" class="dropdown-toggle">
						<i class="icon-asterisk"></i>
						<span class="menu-text"> 物品管理 </span>

					</a>
				</li>
				<li class="">
					<a href="${ctx}/Requirements/select" class="dropdown-toggle">
						<i class="icon-cog"></i>
						<span class="menu-users"> 需求管理 </span>
					</a>
				</li>
				<li class="">
					<a href="${ctx}/user/list" class="dropdown-toggle">
						<i class="icon-group"></i>
						<span class="menu-users"> 用户管理 </span>
					</a>
				</li>
				<li class="active">
					<a href="${ctx}/categories/selectcate" class="dropdown-toggle">
						<i class="icon-cogs"></i>
						<span class="menu-users"> 分类管理 </span>
					</a>
				</li>
				<li class="">
					<a href="${ctx}/attribute/select" class="dropdown-toggle">
						<i class="icon-credit-card"></i>
						<span class="menu-users"> 关键字系统 </span>
					</a>
				</li>

				<li class="">
					<a href="javascript:;" class="dropdown-toggle">
						<i class="icon-envelope"></i>
						<span class="menu-text"> 站内信 </span>
						<b class="arrow icon-angle-down"></b>
					</a>

					<ul class="submenu">
						<li class="">
							<a href="${ctx}/Message/select">
								<i class="icon-double-angle-right"></i>
								留言板
							</a>
						</li>
						<li class="">
							<a href="App_Message.html">
								<i class="icon-double-angle-right"></i>
								推送APP
							</a>
						</li>

						<li>
							<a href="email_Message.html">
								<i class="icon-double-angle-right"></i>
								邮箱提示
							</a>
						</li>
						<li>
							<a href="Tip_Message.html">
								<i class="icon-double-angle-right"></i>
								提示模板
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="${ctx}/Evaluate/select">
						<i class="icon-lightbulb"></i>
						<span class="menu-text"> 评论管理 </span>
					</a>
				</li>
				<li>
					<a href="${ctx}/Inform/select">
						<i class="icon-book"></i>
						<span class="menu-text"> 举报 </span>
					</a>
				</li>
			</ul><!-- /.nav-list -->

			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
			</div>

			<script type="text/javascript">
				try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
			</script>
		</div>

		<div class="main-content">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
				</script>

				<ul class="breadcrumb">
					<li>
						<i class="icon-home home-icon"></i>
						<a href="#">首页</a>
					</li>
					<li class="active">控制台</li>
				</ul><!-- .breadcrumb -->

				<div class="nav-search" id="nav-search">
					<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="搜索" class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
					</form>
				</div><!-- #nav-search -->
			</div>

			<div class="page-content">
				<div class="page-header">
					<h1>
						XXX后台管理
						<small>
							<i class="icon-double-angle-right"></i>
							三级分类列表
						</small>
					</h1>
				</div><!-- /.page-header -->
				<style type="text/css">
					.addClass-1{ display:none; width:100%; }
					.show{  }
				</style>
				<div class="row">
					<div class="col-xs-12">
						<!--<h3 class="header smaller lighter blue">jQuery dataTables</h3>-->
						<div class=" search_box">
							<div class="form-group clearfix">
								<!--<label for="firstname" class=" control-label text-right">搜索</label>-->
								<div class="col-sm-3 pt8">
									<input type="text" class="form-control" id="firstname"
										   placeholder="搜索">
									<a href="javascript:;" class="search_btn">
										<i class="icon-search nav-search-icon"></i>
									</a>
								</div>

								<div class="col-sm-2 add_btn">

									<a href="Classification_add.html" class="btn btn-success">
										<i class="icon-pencil align-top bigger-125"></i>
										增加类别
									</a>
								</div>

							</div>
						</div>

						<div class="table-responsive">
							<table id="sample-table-2" class="table table-striped table-bordered table-hover xhbClass">
								<thead>
								<tr>
									<th class="center">ID</th>
									<th>中文名字</th>
									<th>英文名称</th>
									<th class="hidden-480">等级</th>

									<th><i class="icon-money bigger-110 hidden-480"></i>
										父级名字
									</th>
									<th class="hidden-480">启用状态</th>
									<th class="hidden-480">更新时间</th>
									<th class="hidden-480">操作</th>
								</tr>
								</thead>

								<tbody>
									<c:forEach items="${list.list}" var="list">
								<tr>
									<td class="center ">${list.id}</td>

									<td class="name ">${list.name}</td>
									<td class="pass ">${list.ename}</td>
									<td class="points hidden-480 ">${list.level}</td>
									<td class="price ">${list.parentName}</td>
									<td class="jfxfe ">${list.disableState}</td>
									<td class="yxfe ">${list.updatedAt}</td>
									<td class=" ">
										<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">


											<a tag="edit"  href="Classification_add.html" style="cursor:pointer;" classTag="修改"  class="btn btn-xs btn-info" title="修改">
												<i class="icon-edit bigger-120"></i>
											</a>
											<button class="btn btn-xs btn-danger" classTag="删除" title="删除">
												<i class="icon-trash bigger-120"></i>
											</button>
										</div>

									</td>
								</tr>

								</c:forEach>
								</tbody>
							</table>



						</div>
						<div class="page " id="page">
							<ul class="pagination">
								<li class="disabled"><a href="#">&laquo;上一页</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">下一页&raquo;</a></li>
								<li class="cont_num">
									当前&nbsp;<input type="text" value="12"  >&nbsp;/&nbsp;<input type="text" value="12"  >&nbsp;条,，共 12 条
								</li>
							</ul>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					$(function(){
						// 删除
						var oDelete=$("button[classTag='删除']");
						oDelete.each(function(index,elements){

							$(this).on('click',function(){
								$(this).parents('tr').remove();
							});
						});


						// 控制子元素的显示隐藏
						var $oBtn=$('.target-class');
						var $AlladdClass=$('.addClass-1');

						/* 说明：
						 1.需要点击的元素加上class:
						 2.加多少个 就需要添加多少个tr并且每个tr都要加addClass-1与对应
						 */

						$oBtn.each(function(index, element) {
							$oBtn.eq(index).k=true;
							$oBtn.eq(index).on('click',function(){
								$AlladdClass.css('display','none')
								$AlladdClass.eq(index).css('display','table-row');
							});
						});

					})
				</script>

			</div><!-- /.page-content -->
		</div><!-- /.main-content -->

		<div class="ace-settings-container" id="ace-settings-container">
			<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
				<i class="icon-cog bigger-150"></i>
			</div>

			<div class="ace-settings-box" id="ace-settings-box">
				<div>
					<div class="pull-left">
						<select id="skin-colorpicker" class="hide">
							<option data-skin="default" value="#438EB9">#438EB9</option>
							<option data-skin="skin-1" value="#222A2D">#222A2D</option>
							<option data-skin="skin-2" value="#C6487E">#C6487E</option>
							<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
						</select>
					</div>
					<span>&nbsp; 选择皮肤</span>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
					<label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
					<label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
					<label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
					<label class="lbl" for="ace-settings-rtl">切换到左边</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
					<label class="lbl" for="ace-settings-add-container">
						切换窄屏
						<b></b>
					</label>
				</div>
			</div>
		</div><!-- /#ace-settings-container -->
	</div><!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
</div><!-- /.main-container -->


</body>
</html>

