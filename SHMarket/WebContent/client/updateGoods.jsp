<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.net.URLDecoder" pageEncoding="UTF-8"%> 
<%@taglib prefix="s"  uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cmn-Hans">
<head>
<script>
function setImagePreview() {
var docObj=document.getElementById("doc");
var imgObjPreview=document.getElementById("preview");
if(docObj.files && docObj.files[0]){
//火狐下，直接设img属性
imgObjPreview.style.display = 'block';
imgObjPreview.style.width = '200px';
imgObjPreview.style.height = '120px';
//imgObjPreview.src = docObj.files[0].getAsDataURL();
//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
}else{
//IE下，使用滤镜
docObj.select();
var imgSrc = document.selection.createRange().text;
var localImagId = document.getElementById("localImag");
//必须设置初始大小
localImagId.style.width = "250px";
localImagId.style.height = "200px";
//图片异常的捕捉，防止用户修改后缀来伪造图片
try{
localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
}catch(e){
alert("您上传的图片格式不正确，请重新选择!");
return false;
}
imgObjPreview.style.display = 'none';
document.selection.empty();
}
return true;
}
</script> 
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录表单界面</title>
<link rel="stylesheet" type="text/css"
	href="beautiful/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="beautiful/css/htmleaf-demo.css">
<style type="text/css">
.login-page {
	width: 460px;
	padding: 2% 0 0;
	margin: auto;
}
.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 460px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}
.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}
.form button {
	font-family: "Microsoft YaHei", "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}
.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}
.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}
.form .message a {
	color: #4CAF50;
	text-decoration: none;
}
.form .register-form {
	display: none;
}
.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}
.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}
.container .info {
	margin: 50px auto;
	text-align: center;
}
.container .info h1 {
	margin: 0 0 0;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}
.container .info h3 {
	margin: 0 0 0;
	padding: 0;
	font-size: 50px;
	font-weight: 200;
	color: #1a1a1a;
}
.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}
.container .info span a {
	color: #000000;
	text-decoration: none;
}
.container .info span .fa {
	color: #EF3B3A;
}
body {
	background: #44c1a5 ;
	font-family: "Roboto", sans-serif;
	 
}
.shake_effect {
	-webkit-animation-name: shake;
	animation-name: shake;
	-webkit-animation-duration: 1s;
	animation-duration: 1s;
}
}
p.center {
	color: #fff;
	font-family: "Microsoft YaHei";
}
h3{
color:white;
}

</style>
</head>
<body>
	<div class="htmleaf-container">
	<div>
		<a href="goods/clientaddAction"><img src="img/fh.jpg" /></a>
	</div>
		<header class="htmleaf-header">
		<h3 align="center"> 修改商品  </h3>
		</header>
		<div id="wrapper" class="login-page">
			<div id="login_form" class="form">
	<s:form action="goods/clientaddAction!updateGoodsById" method="post">
		<s:textfield name="goods.goodName" label="商品名称"></s:textfield>
		<s:textfield name="goods.goodPrice" label="商品价格"></s:textfield>
		<s:hidden name="goods.userId"></s:hidden>
		<s:submit value="修改"></s:submit>
		
	</s:form>
			</div>
		</div>
	</div>
</body>
</html>