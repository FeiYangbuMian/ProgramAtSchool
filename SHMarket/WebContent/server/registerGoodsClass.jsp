<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head> 
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>后台管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>
<style type="text/css">
body {
	background: linear-gradient(to left, #8dddbb,#8ddddd );
	font-family: "Roboto", sans-serif;
}
ul li{
	list-style: none;
}
</style>
</head>
<body style="display: block;width:100%;height: 100%">
	<header class="am-topbar admin-header"  style="border-bottom-width: 1px;padding-bottom: 0px;
   			 margin-top: 20px; margin-bottom: 20px; ">
	  <div class="sideMenu am-icon-dashboard" style=" margin: 10px 0 0 0;width:18%; display: inline-block;padding-left: 40px;">
				欢迎系统管理员：admin
			</div>
	<div class="am-collapse am-topbar-collapse" id="topbar-collapse" style="display:inline-block; width: 70%;float: right;">
		<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
			<li class="am-dropdown tognzhi" data-am-dropdown>
			</li>
			<li class="kuanjie" style="margin-left: 0px">
				<a href="user/userManagerAction!selectUser" >用户管理</a>
			 	<a href="orders/registerOrdersAction!selectOrders">订单管理</a>
			 	<a href="goods/addAction!showGoodsAll">产品管理</a>
			 	<a href="#">个人中心</a>
			 	<a href="#">系统设置</a>
			 </li>
		</ul>
	</div>
	</header>
	<div class="am-cf admin-main">
		<div class="nav-navicon admin-main admin-sidebar" style="top:85px;padding-bottom: 0;padding-top: 0;">
			<!-- <div class="sideMenu am-icon-dashboard" style=" margin: 10px 0 0 0;">
				欢迎系统管理员：admin
			</div> -->
				<div class="sideMenu" >
			<h3 class="am-icon-users">
					<em></em> <a href="user/userManagerAction!selectUser">用户管理</a>
					
				</h3>
				<ul>
					<li><a href="user/userManagerAction!selectUser">用户列表</a></li>
					<li><a href="comments/registerCommentsAction!selectComments">用户留言</a></li>
				</ul>
				<h3 class="am-icon-flag" style="margin-top: 0px;">
					<em></em> <a href="goods/addAction!showGoodsAll">商品管理</a>
				</h3>
				<ul>
					<li><a href="goods/addAction!showGoodsAll">商品列表</a></li>
					<li><a href="goodsClass/registerGoodsClassAction!selectGoodsClass">商品分类列表</a></li>
					<li><a href="server/registerGoodsClass.jsp">添加商品分类列表</a></li>
					
					<li><a href="goods/addAction!showGoodsStation">商品回收站</a></li>
				</ul>
				<h3 class="am-icon-cart-plus">
					<em></em> <a href="orders/registerOrdersAction!selectOrders"> 订单管理</a>
				</h3>
				<ul>
					<li><a href="orders/registerOrdersAction!selectOrders">订单列表</a></li>
					<li><a href="server/registerOrders.jsp">添加订单</a></li>
					<li><a href="orders/registerOrdersAction!obligationOrdersStation">已付款单列表</a></li>
					<li><a href="orders/registerOrdersAction!deliveredOrdersStation">已发货单列表</a></li>
					<li><a href="orders/registerOrdersAction!receivedOrdersStation">已收货单列表</a></li>
					<li><a href="orders/registerOrdersAction!unvaluedOrdersStation">待评价列表</a></li>
					<li><a href="orders/registerOrdersAction!evaluatedOrdersStation">已评价列表</a></li>
				</ul>
				
			</div>
			<!-- sideMenu End -->
			<script type="text/javascript">
				jQuery(".sideMenu").slide({
					titCell : "h3", //鼠标触发对象
					targetCell : "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
					effect : "slideDown", //targetCell下拉效果
					delayTime : 300, //效果时间
					triggerTime : 150, //鼠标延迟触发时间（默认150）
					defaultPlay : true,//默认是否执行效果（默认true）
					returnDefault : true//鼠标从.sideMen移走后返回默认状态（默认false）
				});
			</script>
		</div>	
		<!-- 下面这个div里面东西换掉，别的应该不需要动 -->
		<div class="admin-biaogelist">
			<div class="listbiaoti am-cf">
				<ul class="am-icon-flag on">栏目名称</ul>
				<dl class="am-icon-home" style="float: right;">
					当前位置：<a href="server/registerGoodsClass.jsp">添加商品分类</a>
				</dl>
			</div>
			<div class="htmleaf-container" align="center" >
			<div id="wrapper" class="login-page">
			<div id="login_form" class="form">
				<form action="goodsClass/registerGoodsClassAction!registerGoodsClass" method="post">
				<div class="am-form-group am-cf">
				  <div class="zuo">商品分类名称:</div>
				  <div class="you">
				     <input type="text" name="goodsClass.className" width="300"  style="width: 260px" placeholder="请输入商品分类名称">
				  </div>
				</div>
			
			
			       <h3></h3>
			      <div class="am-form-group am-cf">
			         <div class="you" style="margin-left: 11%;">
			         <form action="goodsClass/registerGoodsClassAction!registerGoodsClass" method="post">
			           <button type="submit" class="am-btn am-btn-success am-radius">发布并关闭窗口</button>
			           <span>${error }</span>
			         </form>
			         </div> 
			      </div>			    
				</form>
				<s:if test="msg != null">
					<font color="red">${msg }</font>
				</s:if>
			</div>
		</div>
		</div>
	</div>
	</div>
	<div  class="foods">
	<ul>
		版权所有@2018. 修改版<a href="#" target="_blank" title="去首页">去首页</a>
		- Welcome Here<a href="#" target="_blank" title="联系我们" >联系我们</a>
	</ul>
	<dl>
		<a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
	</dl>
</div>
</body>
</html>