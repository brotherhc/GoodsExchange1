<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <title>物品修改页面</title>
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

  <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
-->
  <script src="${ctxStatic}/assets/js/jquery-2.0.3.min.js"></script>
  <!-- <![endif]-->

  <!--[if IE]>
  <script src="${ctxStatic}/http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

  <!--[if lt IE 9]>
  <script src="${ctxStatic}/assets/js/html5shiv.js"></script>
  <script src="${ctxStatic}/assets/js/respond.min.js"></script>
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

        <li class="active">
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
        <li class="">
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
        <%--<li class="">--%>
          <%--<a href="x_change_list.html" class="dropdown-toggle">--%>
            <%--<i class="icon-bar-chart"></i>--%>
            <%--<span class="menu-users"> 交换列表 </span>--%>
          <%--</a>--%>
        <%--</li>--%>
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
              发布物品
            </small>
          </h1>
        </div><!-- /.page-header -->

        <div class="row">
          <div class="col-xs-12">
            <%--<form action="${ctx}/Goods/insert" method="post">--%>
            <form action="${ctx}/Goods/insert" method="post"class="form-horizontal" role="form">
              <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">选择分类:</label>
                <div class="col-sm-2">
                  <select class="form-control">
                    <option value="">一级分类</option>
                    <option value="">手机</option>
                    <option value="">电脑</option>
                    <option value="">电脑</option>
                    <option value="">电脑</option>
                    <option value="">默认选择</option>
                    <option value="">电脑</option>
                    <option value="">电脑</option>
                  </select>
                </div>
                <div class="col-sm-2">
                  <select class="form-control">
                    <option value="">二级分类</option>
                    <option value="">手机</option>
                    <option value="">电脑</option>
                    <option value="">电脑</option>
                    <option value="">电脑</option>
                    <option value="">默认选择</option>
                    <option value="">电脑</option>
                    <option value="">电脑</option>
                  </select>
                </div>
              </div>

              <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">标题:</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="firname" placeholder="">
                </div>
              </div>
              <c:forEach var="list"  items="${list}">
                <td>${list.categoryId}</td>
              <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">关键字：</label>
                <div class="col-sm-5 Options">
                  <div class="">关键字</div>
                  <div class="">关键字</div>
                  <div>关键字</div>
                  <div class="">关键字</div>
                  <div class="">关键字</div>
                  <div class="">关键字</div>
                  <div>关键字</div>
                  <div>关键字</div>
                  <div class="">关键字</div>


                </div>
              </div>
             </c:forEach>
              <!-- 配置文件 -->
              <script type="text/javascript" src="${ctxStatic}/ue/ueditor.config.js"></script>
              <!-- 编辑器源码文件 -->
              <script type="text/javascript" src="${ctxStatic}/ue/ueditor.all.js"></script>
              <!-- 实例化编辑器 -->
              <script type="text/javascript">
                var ue = UE.getEditor('container',{
                  toolbars: [
                    [


                      'bold', //加粗
                      'indent', //首行缩进
                      'italic', //斜体
                      'underline', //下划线
                      'strikethrough', //删除线
                      'subscript', //下标

                      'superscript', //上标

                      'source', //源代码


                      'selectall', //全选


                      'horizontal', //分隔线
                      'removeformat', //清除格式
                      'time', //时间
                      'date', //日期
                      'unlink', //取消链接
                      'insertrow', //前插入行
                      'insertcol', //前插入列
                      'insertparagraphbeforetable', //"表格前插入行"
                      'fontfamily', //字体
                      'fontsize', //字号
                      'simpleupload', //单图上传
                      'insertimage', //多图上传
                      'link', //超链接
                      'spechars', //特殊字符
                      'insertvideo', //
                      'justifyleft', //居左对齐
                      'justifyright', //居右对齐
                      'justifycenter', //居中对齐
                      'justifyjustify', //两端对齐
                      'forecolor', //字体颜色

                      'insertorderedlist', //有序列表
                      'insertunorderedlist', //无序列表


                      'imagecenter', //居中
                      'wordimage', //图片转存
                      'lineheight', //行间距
                      'edittip ', //编辑提示
                      'customstyle', //自定义标题
                      'autotypeset', //自动排版


                    ]
                  ]
                });
              </script>
              <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">内容描述：</label>
                <div class="col-sm-5">
                  <script id="container" name="description" style="height:240px" type="text/plain"></script>
                </div>
              </div>
              <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">图片上传：</label>
                <div class="col-sm-5">
                  <input type="file" class="form-control" id="lastname" name="Pics" placeholder="">
                </div>
              </div>
              <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">图片预览：</label>
                <div class="col-sm-5 upload-images-warp">
                  <ul>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-3.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-2.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-1.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-4.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-5.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-3.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-2.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-1.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-4.jpg"><span><i class="icon-remove red"></i></span></li>
                    <li><img src="${ctxStatic}/assets/images/gallery/image-5.jpg"><span><i class="icon-remove red"></i></span></li>
                  </ul>
                </div>
              </div>
              <script type="text/javascript">
                $(function(){
                  var aLi=$('.upload-images-warp ul li');
                  aLi.each(function(index, element) {
                    aLi.eq(index).mouseenter(function(){
                      $(this).find('span').eq(0).css("display","inline-block").on('click',function(){
                        aLi.eq(index).remove();

                      });
                    });

                    aLi.eq(index).mouseleave(function(){
                      $(this).find('span').css("display","none");
                    });

                  });
                });
              </script>
              <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">参考网址：</label>
                <div class="col-sm-5">
                  <input type="text" class="form-control" id="firstname" placeholder="https://www.baidu.com/" />
                  <br/>
                  <input type="text" class="form-control" id="firstname2" placeholder="https://www.baidu.com/" />
                  <br/>
                  <input type="text" class="form-control" id="firstname3" placeholder="https://www.baidu.com/" />
                </div>
              </div>
              <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">库存:</label>
                <div class="col-sm-2">
                  <input type="text" class="form-control" name="numbers" placeholder="2120">
                </div>
              </div>




              <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">状态设置:</label>
                <div class="col-sm-2">
                  <label class="checkbox-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios3"
                           value="option1" checked>  上线
                  </label>
                  <label class="checkbox-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios4"
                           value="option2"> 离线
                  </label>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                  <button type="submit" class="btn col-sm-2 btn-success">确认发布</button>
                  <div class="col-sm-6 publish_tip success">发布失败</div>

                </div>
              </div>
            </form>

          </div>
        </div>


      </div><!-- /.page-content -->
    </div><!-- /.main-content -->
    <%--<form action="${ctx}/Goods/insert" method="post">--%>
      <%--描述：    <input type="text" name="description"><br>--%>
      <%--属性：  <input type="text" name="attributes"><br>--%>
      <%--物品数量：<input type="text" name="numbers"><br>--%>
      <%--<input type="submit" value="提交数据">--%>
    <%--</form>--%>

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

<!-- basic scripts -->

<!--[if !IE]> -->

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


    /* 续费的选择 */

    if($('.Options>div').length>=1){
      $('.Options>div').each(function(index, element) {
        $('.Options>div').eq(index).on('click',function(){
          $(this).toggleClass('active');
        });
      });
    };

  })




</script>


<!--[if IE]>
<script type="text/javascript">
  window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->





<!--<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>-->

</body>
</html>