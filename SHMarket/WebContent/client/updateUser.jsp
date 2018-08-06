  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,maximum-scale=1,minimum-scale=1,initial-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<title>校园二手街|校园二手市场</title>
<meta name="keywords" content="">
<meta name="description" content="" />
<link rel="stylesheet" type="text/css"
	href="beautiful/css/normalize.css" />
<link rel="stylesheet" type="text/css" href=" beautiful/css/main.css">
<link rel="stylesheet" type="text/css" href=" beautiful/css/common.css">
<style type="text/css">
.y1 {
	color: white;
	font-family: serif;
	font-size: 30px;
	text-decoration: none;
	CURSOR: hand;
	background-color: #44c1a5;
	margin-top: 12px;
	height: 50px;
	width: 1200px;
	margin-left: 75px;
}

a:link {
	color: white;
	text-decoration: none;
}

a:hover {
	color: white;
	text-decoration: none;
}
img{
height:25px;
width:150px;
}
</style>
</head>
<body>
	<div class="y1">
		<a href="" title="第一页哦" style="padding: 0 35px"></a>
		<a href="index.jsp" title="第一页哦" style="padding: 0 35px">首页 </a>
		<a href="" title="看看有啥检漏的" style="padding: 0 35px">购买二手商品 </a> 
		<a href="client/insertGoods.jsp" title="看看有啥不用的" style="padding: 0 35px">发布商品</a>
		<a href="client/customSer.jsp" title="有不懂的加客服的QQ和微信" style="padding: 0 35px">客服 </a>
	</div>
	<div class="page">
		<div class="login-header header">
		<s:url action="clientaddAction!selectGoodsByUserId" namespace="/goods" var="select">
				<s:param name="goods.userId" value="%{#session.loginUser.userId}"></s:param>
		</s:url>
		<s:a href="%{#select}" cssStyle="float: left;"><img src="img/fh.jpg" /></s:a> 
		</div>
		<div class="section">
			<div class="login-top">
				<span class="title-line"></span> <span class="title-txt o-center">
					<img src="http://www.ischoolbar.com/App/Public/images/edit_pro.png" />
				</span>
			</div>
			<div class="wrap-tb">
				<s:form id="edit-form" action="user/clientuserManagerAction!updateUser"
					method="post">
					<table class="tb-wap">
					<s:hidden name="user.userId"
							value="%{#session.loginUser.userId}" ></s:hidden>
						<s:textfield name="user.userQQ" class="user-pass"
							autocomplete="off" value="%{#session.loginUser.userQQ}"
							label="QQ"></s:textfield>
						<s:textfield name="user.userPhone" class="user-pass"
							autocomplete="off" value="%{#session.loginUser.userPhone}"
							label="电话"></s:textfield>
						<s:textfield name="user.userEmail" class="user-pass"
							autocomplete="off" value="%{#session.loginUser.userEmail}"
							label="邮箱"></s:textfield>
						<s:textfield name="user.userAddress" class="user-pass"
							autocomplete="off" value="%{#session.loginUser.userAddress}"
							label="地址"></s:textfield>						
					</table>
					<s:submit id="edit-profile" cssClass="login-txt-box border-box edit-commit" value="修改"></s:submit>
				</s:form>
			</div>
		</div>
	</div>
	<script
		src="http://www.ischoolbar.com/App/Public/js/jquery2.1.1.min.js?v=201505252216"></script>
	<script
		src="http://www.ischoolbar.com/App/Public/js/jquery.validateform.js?v=201505252216"></script>
	<script
		src="http://www.ischoolbar.com/App/Public/js/main.js?v=201505252216"></script>
	<script>
		
	</script>
</body>
</html>