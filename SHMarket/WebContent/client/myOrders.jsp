
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
<title>生成订单</title>
<style type="text/css">
body {
	/* 	font-family: "Oswald", "Open Sans", sans-serif; */
	font-family: "Microsoft YaHei", "Roboto", sans-serif;
	font-size: 16px;
	text-decoration: none;
	margin-top: 0px;
	margin-right: 0px;
	margin-left: 0px;
	margin-bottom: 0px;
	width: 100%;
	height: 100%;
	background: rgba(68, 193, 165, 0.2);
}

.mytable000 {
	width: 70%;
	border-collapse: collapse;
	margin: 0px auto;
	color: #44c1a5;
	height: 100px;
	border: dashed #44c1a5 1px;
	font-size: 16px;
}

.mytable001 {
	width: 70%;
	border-collapse: collapse;
	margin: 0px auto;
	/* margin-top: 50px; */
	box-shadow: 0 0 20px 0 rgba(68, 193, 165, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
	/* background: #44c1a5; */
	color: #44c1a5;
	height: 85px;
	border: solid #44c1a5 1px;
}

.mytbody001 {
	/* border: 1px solid #E7E7E7; */
	margin-top: 5px;
}

td {
	text-align: center;
	margin-left: 150px;
}

.mytr001 {
	background: inherit;
	height: 35px;
	color: #44c1a5;
}

.mytd001 {
	margin-left: 100px;
}

.mytr002 {
	height: 45px;
}

.mer_img {
	float: left;
	width: 35%;
	text-align: center;
}

.mer_txt {
	width: 65%;
	float: left;
	word-wrap: break-word;
}

.mycheckbox001 {
	margin-left: 10px;
}
/******************以下为 th 中的 td*****************************/
.mytdF001 {
	width: 30%;
}

.mytdF002 {
	width: 12%;
}

.mytdF003 {
	width: 16%;
}

.mytrF001 {
	height: 35px;
	/* 	font-weight: bold; */
}
/*****************************span*******************************/
.myspan002 {
	margin-left: 5px;
}

.myspan004 {
	border: 1px solid #E7E7E7;
}

.myspan005 {
	font-size: 9px;
}

.td001 {
	width: 15%
}

.td002 {
	width: 85%
}
</style>
</head>
<body>
	<div style="margin-top: 50px;">
		<div>
			<table style="width: 100%;">
				<tr style="background: #44c1a5">
					<td colspan="5" style="text-align: left;">
					<s:url action="../goods/clientaddAction!selectGoodsByUserId" var="select">
						<s:param name="goods.userId" value="#session.loginUser.userId"></s:param>
					</s:url>
					<s:a href="%{#select}"><img src="img/fh.jpg" /></s:a>
					</td>
				</tr>
			</table>
			<br>
		</div>
		<br>
		<div>
			<s:if test="ordersList != null ">
			<s:iterator var="order" value="ordersList">
				<table class="mytable001" cellspacing="0">
					<thead class="mythead001">
						<tr class="mytrF001"
							style="background-color: #44c1a5; color: white;">
							<td class="mytdF001">商品名称</td>
							<td class="mytdF002">订单价格</td>
							<td class="mytdF003">订单状态</td>
							<td class="mytdF003">下单时间</td>
						</tr>
					</thead>
					<tbody class="mytbody001">
						<tr class="mytr002">
							<td><s:property value="#order.goodName" /></td>
							<td><s:property value="#order.price" /></td>
							<td><s:property value="#order.orderStatu" /></td>
							<td><s:property value="#order.pubDate" /></td>
						</tr>
					</tbody>
					<tr>
						<s:url action="orders/clientregisterOrdersAction!deleteOrdersForUser" var="delete">
							<s:param name="user.userId" value="%{#session.loginUser.userId}"></s:param>
							<s:param name="orders.orderId" value="#order.orderId"></s:param>
						</s:url>
						<td colspan="4" style="text-align: right;"><s:a href="%{#delete}" cssClass="edit" cssStyle="text-decoration:none;color:#398171;">确认收货</s:a>&nbsp;</td>
					</tr>
				</table>
			</s:iterator>
			</s:if>
		</div>
	</div>
</body>
</html>