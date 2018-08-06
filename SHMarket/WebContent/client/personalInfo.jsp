<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
	href=" beautiful/css/compatible.css">
<style type="text/css">
.y1 {
    color:white;
	font-family: serif;
	font-size: 30px;
	text-decoration: none;
	CURSOR: hand;
	background-color: #44c1a5;
	margin-top: 12px;
	height: 50px;
	width: 1200px;
	margin: auto;
	text-align: center;
}

.z1 {
	margin-left: 100px;
	margin-top: 25px;
}

a {
	color: white;
}

a:link {
	color: white;
	text-decoration: none;
}

a:hover {
	color: grey;
	text-decoration: none;
}
</style>
<script type='text/javascript'  src='beautiful/js/jquery-2.1.1.min.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#p").hide();
		var i = 0;
		$("#pic").click(function() {
			if (i == 1) {
				$("#p").hide();
				i = 0;
			} else {
				$("#p").show();
				i = 1;
			}
		});
	});
</script>
</head>
<body>
	<div class="y1">
		<!-- <a href="" title=" " style="padding: 0 35px"></a> -->
		 <a href="goods/clientaddAction"
			title="第一页哦" style="padding: 0 35px">首页 </a>
		 <a href="goods/clientaddAction!showGoodsAllClient"
			title="看看有啥检漏的" style="padding: 0 35px">购买二手商品 </a> <a
			href="client/insertGoods.jsp" title="看看有啥不用的" style="padding: 0 35px">发布商品</a>
		<a href="client/customSer.jsp" title="有不懂的加客服的QQ和微信" style="padding: 0 35px">客服
		</a>
	</div>
	<div class="page profile-page" id="main">
		<div class="login-header">
			<a class="right fr"
				style="background-image: url(http://www.ischoolbar.com/App/Public/images/log_out.png)"
				href="client/loginOut.jsp"></a> <a class="left fl"
				href="http://www.ischoolbar.com"></a>
		</div>
		<div class="wrap-seller profile-seller group">
			<a href="client/updateUser.jsp" class="edit-btn">编辑</a>
			<table>
				<tr>
					<td rowspan="3" style="text-align: center; vertical-align: bottom;">
						<s:if test="#session.loginUser.userPhoto == 0">
							<img id="pic" src="client/UserPhoto/cat.jpg"
								style="width: 200px">
						</s:if> <s:else>
							<img id="pic" 
								src="client/UserPhoto/<s:property value='#session.loginUser.userPhoto'/>"
								style="width: 200px" />
						</s:else>
						<div id="p" >
							<s:form action="user/clientuserManagerAction!updateUserPhoto" method="post"  enctype="multipart/form-data" >
								<s:hidden name="user.userId" value="%{#session.loginUser.userId}" ></s:hidden>
								<s:file name="myfile" />
								<s:submit value="更改头像"></s:submit>
							</s:form>
						</div>
					</td>
					<td width="80px">昵称：</td>
					<td width="100px"><s:property
							value="%{#session.loginUser.userName}" /></td>
				</tr>
				<tr>
					<td>QQ：</td>
					<td><s:property value="%{#session.loginUser.userQQ}" /></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><s:property value="%{#session.loginUser.userPhone}" /></td>
				</tr>
			</table>
			<s:url action="../orders/clientregisterOrdersAction!selectOrdersByUserId" var="select">
					<s:param name="orders.userId" value="%{#session.loginUser.userId}"></s:param>
			</s:url>
			<s:a href="%{#select}" cssClass="edit" cssStyle="float:right;">我的订单</s:a>
		</div>
		
		<s:if test="list == null">
		
		<div class="no-goods">
			<div class="no-logo"></div>
			<p>这里空空如也</p>
			<a href="client/insertGoods.jsp">立即发布</a>
		</div>
	
	     </s:if>
	     <s:else>
		<div class="wrap-goods" id="off-list">
		       <s:iterator var="g" value="list ">
		        <ul class="wrap-listview" data-id="617">
		            <li>
		                    <dl class="group">
		                        <dt class="fl">		          
		                          <img src="client/GoodsPhoto/<s:property value='#g.goodPhoto'/>" height="60" width="80"/>
		                        </dt>
		                        <dd class="fl">
		                                <p class="goods-name">商品名称：<s:property value="#g.goodName"/></p>
		                                <p class="goods-price">￥<s:property value="#g.goodPrice"/></p>
		                                <p class="goods-time">发布时间：<s:property value="#g.pubDate"/></p>
		                         </dd>
		                    </dl>
		                <ul class="listview-attr group twoattr">
		                   <s:url action="../goods/clientaddAction!findGoodsById" var="myurl">
								<s:param name="goods.goodId" value="#g.goodId"></s:param>
							</s:url>
		                    <li style="width:100%"><s:a href="%{#myurl}" class="edit-goods">编辑</s:a></li>
		                </ul>
		            </li>
		        </ul>
		      </s:iterator> 
		    </div>   
	     </s:else>
	     
	   	    </div>
	   	     
	<script
		src="http://www.ischoolbar.com/App/Public/js/jquery2.1.1.min.js?v=201505252216"></script>
	<script
		src="http://www.ischoolbar.com/App/Public/js/template-native.js?v=201505252216"></script>
	<script
		src="http://www.ischoolbar.com/App/Public/js/profile_person.js?v=201505252216"></script>
	<script>
		
	</script>
	
	
</body>
</html>