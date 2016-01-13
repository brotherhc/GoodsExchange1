<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!doctype html>
<html lang="en">
<head>
	<title>登录</title>
	<meta http-equiv="x-ua-compatible" content="IE=Edge"/>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<!-- basic styles -->
	<link href="${ctxStatic}/bootstrap/css/bootstrap.min.css"
		  rel="stylesheet" />
	<link rel="stylesheet" href="${ctxStatic}/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/css/my_css.css"
		  type="text/css" />

	<!--[if IE 7]>
	<link rel="stylesheet" href="${ctxStatic}/css/font-awesome-ie7.min.css" />
	<![endif]-->

	<!-- page specific plugin styles -->
	<!-- fonts -->

	<!--
            <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
            -->
	<link href="${ctxStatic}/css/font-gooleapis.css" type="text/css"
		  rel="stylesheet">
	<!-- ace styles -->

	<link rel="stylesheet" href="${ctxStatic}/css/ace.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${ctxStatic}/css/ace-skins.min.css" />
	<%--

            <!--[if lte IE 8]>
              <link rel="stylesheet" href="${ctxStatic}/css/ace-ie.min.css" />
            <![endif]-->

            --%>
	<!-- inline styles related to this page -->

	<!-- ace settings handler -->

	<script src="${ctxStatic}/js/ace-extra.min.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

	<!--[if lt IE 9]>
	<script src="${ctxStatic}/js/html5shiv.js"></script>
	<script src="${ctxStatic}/js/respond.min.js"></script>
	<![endif]-->

</head>

<body class="">
<div class="login-layout">
	<div class="main-container" style="padding-top:80px;">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i>
								<span class="red">Ace</span>
								<span class="white">后台管理系统</span>
							</h1>
							<h4 class="blue">&copy; 法佛科技</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box" class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i>
											请登录
										</h4>

										<div class="space-6"></div>

										<form action="${ctx}/admin/userLogin" method="post"
											  id="login_form">
											<fieldset>
												<label class="block clearfix"> <span
														class="block input-icon input-icon-right">
													<input
														type="text" class="form-control" placeholder="用户名或手机号"
														name="username" value="${mobile}" />
													<i class="icon-user"></i>
												</span> </label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
													type="password" name="password" class="form-control"
													placeholder="密码" /> <i class="icon-lock"></i> </span> </label>

												<label class="error ${empty message ? 'hide' : ''}" id="messageBox">${message}</label>
												<div class="space"></div>

												<div class="clearfix">
													<label class="inline"> <input type="checkbox" name="rememberMe" id="rememberMe"
																				  class="ace" /> <span class="lbl"> 记住我</span> </label>

													<button type="button" id="login_btn"
															class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登录
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>


									</div><!-- /widget-main -->
									<div class="toolbar clearfix">
										<div>
											<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">


											</a>
										</div>

										<div>
											<a href="register.html" onclick="" class="user-signup-link">
												现在,注册
												<i class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
							</div><!-- /widget-body -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">

								</div><!-- /widget-body -->
							</div><!-- /signup-box -->
						</div><!-- /login-box -->




					</div><!-- /position-relative -->
				</div>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div>
</div><!-- /.main-container -->
</div>
<script src="${ctxStatic}/jquery/jquery-1.9.1.min.js"></script>
<script src="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.js" type="text/javascript"></script>
<link href="${ctxStatic}/jquery-validation/1.11.0/jquery.validate.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">
	function show_box(id) {
		jQuery('.widget-box.visible').removeClass('visible');
		jQuery('#' + id).addClass('visible');
	}
	$(function(){

		$('.login-layout').css({"height":$(document).height()}); //$(document.body).height()

	});
	$(window).resize(function(){
		$('.login-layout').css({"height":$(document).height()});
	});
	$(function() {
		$("#login_form").validate({
			rules : {
				mobile : {
					required : true
				},
				password : {
					"required" : true
				}
			},
			messages : {
				mobile : {
					required : "请填写用户名."
				},
				password : {
					required : "请填写密码."
				}
			},
			errorContainer : "#messageBox"
		});
		$("#login_btn").bind("click", function(){
			$("#login_form").submit();
		});
	});
	function show_box(id) {
		jQuery('.widget-box.visible').removeClass('visible');
		jQuery('#' + id).addClass('visible');
	}
</script>
</body>
</html>

