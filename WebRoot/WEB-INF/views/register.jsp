<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="edge" />

	<meta charset="utf-8" />
	<title>注册</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- basic styles -->
	<link href="${ctxStatic}/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="${ctxStatic}/assets/css/font-awesome.min.css"
			/>
	<link rel="stylesheet" href="${ctxStatic}/assets/css/my_css.css"
		  type="text/css" />
	<!--[if IE 7]>
	<link rel="stylesheet" href="${ctxStatic}/assets/css/font-awesome-
ie7.min.css" />
	<![endif]-->

	<!-- page specific plugin styles -->
	<!-- fonts -->

	<!--
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open
+Sans:400,300" />
    -->
	<link href="${ctxStatic}/assets/css/font-gooleapis.css" type="text/css"
		  rel="stylesheet">
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

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media
queries -->

	<!--[if lt IE 9]>
	<script src="${ctxStatic}/assets/js/html5shiv.js"></script>
	<script src="${ctxStatic}/assets/js/respond.min.js"></script>
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
								<i class="icon-
leaf green"></i>
									<span
											class="red">Ace</span>
									<span
											class="white">后台管理系统</span>
							</h1>
							<h4 class="blue">&copy; 法
								佛科技</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								 class="login-box visible widget-box no-border">
								<div
										class="widget-body">


								</div>
							</div><!-- /widget-body
-->

							<div id="signup-box"
								 class="signup-box visible widget-box no-border">
								<div
										class="widget-body">
									<div
											class="widget-main">

										<h4 class="header green lighter bigger">

											<i class="icon-group blue"></i>

											注册账号

										</h4>


										<div class="space-6"></div>

										<p> 输入信息： </p>


										<form>
											<input type="hidden" id="agentKey" value="${ agentKey }">
											<fieldset>
												<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="用户名" name="username" id="username" />
															<i class="icon-user"></i>
														</span>
												</label>

												<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" id="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
												</label>

												<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="input" class="form-control" placeholder="手机号码" name="mobile" id="mobile"/>
															<i class="icon-phone"></i>
														</span>
												</label>

												<label class="block clearfix">
														<span class="block input-icon input-icon-right col-lg-4 cCode">
															<input type="input" id="captcha" class="form-control" placeholder="验证码" />
														</span>
													<div class="checkCode col-lg-4">
														<a href="javascript:void(0);" class="btn btn-info" id="getCode">获取验证码</a>
														<p class="mark">&nbsp;</p>
													</div>
												</label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="icon-refresh"></i>
														重置
													</button>
													<button type="button" onclick="register();" class="width-65 pull-right btn btn-sm btn-success">
														注册
														<i class="icon-arrow-right icon-on-right" ></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div
											class="toolbar center">
										<a
												href="${ctx}/admin/index"  class="back-to-login-link">

											<i class="icon-arrow-left"></i>

											返回登录

										</a>
									</div>
								</div><!--
/widget-body -->
							</div><!-- /signup-box -->
						</div><!-- /login-box -->




					</div><!-- /position-relative -->
				</div>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div>
</div><!-- /.main-container -->
</div>
<!-- basic scripts -->

<!--[if !IE]> -->


<script src="${ctxStatic}/assets/js/jquery-2.0.3.min.js"></script>



<!-- <![endif]-->

<!--[if IE]>

<script src="${ctxStatic}/assets/js/jquery-1.10.2.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
	window.jQuery || document.write("<script src='${ctxStatic}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
	window.jQuery || document.write("<script src='${ctxStatic}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='${ctxStatic}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<!-- inline scripts related to this page -->
<script src="${ctxStatic}/assets/js/myjs.js"></script>
<script type="text/javascript">
	function show_box(id) {
		jQuery('.widget-box.visible').removeClass('visible');
		jQuery('#' + id).addClass('visible');
	}
	$(function(){

		$('.login-layout').css({"height":$(document).height()});
//$(document.body).height()

	});
	$(window).resize(function(){
		$('.login-layout').css({"height":$(document).height()});
	});
	function show_box(id) {
		jQuery('.widget-box.visible').removeClass('visible');
		jQuery('#' + id).addClass('visible');
	}
	var timer=null;
	var n=60;
	$(function(){
		$('#getCode').on("click",function(){
			var mobile = $("#mobile").val();
			if (mobile == ''){
				alert('手机号码不能为空');
				return;
			}
//			if(!oCheck(mobile,'phone')){
//				alert('手机号码格式错误!');
//				return;
//			}
//			alert(mobile);
			$.ajax({
				type: "post",
				data: {mobile: mobile},
				url: "${ctx}/admin/getVerifyCode",
				success: function(result){
					alert(1);
					alert(result);
					alert(data.message);
					if(data.success == 1){
						$('.checkCode p').css
						({"display":"block"});
						clearInterval(timer);
						timer=setInterval
						(function(){
							$('#getCode').html(n+"秒后,重新发送");
							if(n==0){
								$('.checkCode p').css({"display":"none"});
								n=60;

								$('#getCode').html("重新发送");

								clearInterval(timer);
							}else{
								n--;
							}
						},1000);
					}
				},
				error: function(){
					alert("服务器异常，请联系管理员000");
				}
			});
		});
	});

	var register = function(){

		var username = $("#username").val();
		if (username == ''){
			alert('用户名不能为空');
			return;
		}
		var password = $("#password").val();
		if (password == ''){
			alert('密码不能为空');
			return;
		}
		//if(!oCheck(password,'passwordMiddle')){
		//alert('密码不能为纯数字或字母!');
		//return;
		//}
		var mobile = $("#mobile").val();
		if (mobile == ''){
			alert('手机号码不能为空');
			return;
		}
		if(!oCheck(mobile,'phone')){
			alert('手机号码格式错误!');
			return;
		}
		var captcha = $("#captcha").val();
		if (captcha == ''){
			alert('验证码不能为空！');
			return;
		}
		var data = {mobile: mobile, username:username, password:
				password, captcha: captcha};
		var agentKey = $("#agentKey").val();
		if (agentKey!='' && agentKey!=undefined){
			data['agentKey'] = agentKey;
		}
		$.ajax({
			type: "post",
			data: data,
			url: "${ ctx }/admin/register",
			success: function(data, textStatus){
				alert(data.message);
				if(data.success == 1){
					window.location.href="${ctx}/admin/index";
				}
			},
			error: function(){
				alert("<<<<<<<<<<<<<<<<<<<<<<")
				alert("服务器异常，请联系管理员");
			}
		});
	}
</script>
<%--判断用户输出的值--%>

</body>
</html>
