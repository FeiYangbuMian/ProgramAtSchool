<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.net.URLDecoder" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>修改密码</title>
<link rel="stylesheet" type="text/css"
	href="beautiful/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="beautiful/css/htmleaf-demo.css">
<style type="text/css">
.login-page {
	width: 660px;
	padding: 2% 0 0;
	margin: auto;
}
.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 100px auto 100px;
	padding: 45px;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}
.form p{
	margin: 5px
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
	background: #8DDD;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
	margin-top: 10px;
}
.form button:hover, .form button:active, .form button:focus {
	background: #BBBBBB;
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
.container .info span a {
	color: #000000;
	text-decoration: none;
}
.container .info span .fa {
	color: #EF3B3A;
}
body {
	background: linear-gradient(to left, #BBBBBB, #8DDDBB);
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
</style>
</head>
<body>
	<div class="htmleaf-container">
		<div id="wrapper" class="login-page">
			<div id="my_form" class="form">
				<form action="user/clientuserManagerAction!updatePwd" method="post" id="myForm">
				<s:hidden name="user.userId"
							value="%{#session.loginUser.userId}" ></s:hidden>
					<p>密码:</p><input type="password" name="user.userPwd" id="userPwd">
					<p>确认密码:</p><input type="password" name="user.userPwd_" id="userPwd_">
					<button id="btn_updatePwd">修改</button>
				</form>
				<s:if test="msg != null">
					<font color="red">${msg }</font>
				</s:if>
			</div>
		</div>
	</div>
	<script src="beautiful/js/jquery-2.1.1.min.js" ></script>
	<script type="text/javascript">
	function checkFrom(){
	 var pass=$("#userPwd").val();
	 var pass1=$("#userPwd_").val();
	 if(pass!=pass1||pass==""||pass1=="") {
	  	$("#my_form").removeClass('shake_effect');  
	  	setTimeout(function() {
	  		 $("#my_form").addClass('shake_effect')
	 	 },1);  
	 }else {
		// window.location.href='server/success.jsp';
		 document.getElementById("myForm").submit();  
	 }
	}
	$(function(){
		$("#btn_updatePwd").click(function(){
			checkFrom();
			return false;
		})
		$('.message a').click(function () {
		    $('form').animate({
		        height: 'toggle',
		        opacity: 'toggle'
		    }, 'slow');
		});
	})
	</script>
</body>
</html>