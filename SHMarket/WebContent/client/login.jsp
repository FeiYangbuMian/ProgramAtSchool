<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.net.URLDecoder" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head> 
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录表单界面</title>
<link rel="stylesheet" type="text/css" href="beautiful/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="beautiful/css/htmleaf-demo.css">
<style type="text/css">
.login-page {
	width: 360px;
	padding: 2% 0 0;
	margin: auto;
}
.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
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
	background: #8DDD;
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
.container .info h1 {
	margin: 0 0 0;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
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
	background: linear-gradient(to left, #BBBBBB, #8DDDBB);
	font-family: "Roboto", sans-serif;
}
.shake_effect {
	-webkit-animation-name: shake;
	animation-name: shake;
	-webkit-animation-duration: 1s;
	animation-duration: 1s;
}
@-webkit-keyframes shake {
		  from, to {
		    -webkit-transform: translate3d(0, 0, 0);
		    transform: translate3d(0, 0, 0);
		  }

		  10%, 30%, 50%, 70%, 90% {
		    -webkit-transform: translate3d(-10px, 0, 0);
		    transform: translate3d(-10px, 0, 0);
		  }

		  20%, 40%, 60%, 80% {
		    -webkit-transform: translate3d(10px, 0, 0);
		    transform: translate3d(10px, 0, 0);
		  }
		}

		@keyframes shake {
		  from, to {
		    -webkit-transform: translate3d(0, 0, 0);
		    transform: translate3d(0, 0, 0);
		  }

		  10%, 30%, 50%, 70%, 90% {
		    -webkit-transform: translate3d(-10px, 0, 0);
		    transform: translate3d(-10px, 0, 0);
		  }
		  
		  20%, 40%, 60%, 80% {
		    -webkit-transform: translate3d(10px, 0, 0);
		    transform: translate3d(10px, 0, 0);
		  }
		}
p.center {
	color: #fff;
	font-family: "Microsoft YaHei";
}
.code 
{
 background:url(code_bg.jpg);
 font-family:Arial;
 font-style:italic;
 color:blue;
 font-size:30px;
 border:0;
 padding:2px 3px;
 letter-spacing:3px;
 font-weight:bolder;
 float:left;
 cursor:pointer;
 width:100%;
 height:60px;
 line-height:60px;
 text-align:center;
 vertical-align:middle;
}
a 
{
 text-decoration:none;
 font-size:12px;
 color:#288bc4;
}
a:hover 
{
 text-decoration:underline;
}
</style>
<script type="text/javascript">
var code;
function createCode() 
{
 code = "";
 var codeLength = 6; //验证码的长度
 var checkCode = document.getElementById("checkCode");
 //所有候选组成验证码的字符，当然也可以用中文的
 var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); 
 for(var i = 0; i < codeLength; i++) 
 {
  var charNum = Math.floor(Math.random() * 52);
  code += codeChars[charNum];
 }
 if(checkCode) 
 {
  checkCode.className = "code";
  checkCode.innerHTML = code;
 }
}
function validateCode() 
{
 var u="s";
 var inputCode=document.getElementById("inputCode").value;
 if(inputCode.length <= 0) 
 {
  alert("请输入验证码！");
  document.getElementById("codecheck").value=u;
 }
 else if(inputCode.toUpperCase() != code.toUpperCase()) 
 {
	alert("验证码输入有误！");	
	document.getElementById("codecheck").value=u;
 }
}  
</script>
</head>
<body onload="createCode()">
	<div class="htmleaf-container">
		<header class="htmleaf-header">
		<h1>
			有朋自远方来，不亦说乎 <span>Welcome here!</span>
		</h1>
		</header>
		<div id="wrapper" class="login-page">
			<div id="login_form" class="form">
				<form action="user/clientuserManagerAction!userLogin" method="post" >
					<input type="text" name="user.userName" placeholder="用户名" id="userName">
					<input type="password" name="user.userPwd" placeholder="密    码" id="userPwd">
					<input type="hidden" name="codecheck" id="codecheck"/>
					<input style="float:left;width: 50%" type="text"  id="inputCode" onchange="validateCode()" placeholder="验证码"/>  
					<div class="code" id="checkCode" onclick="createCode()" style="width: 50%" ></div>   
					<div style="display: flex;width: 100%;margin-bottom: 10px;"><div style="width:50%"><input name="identity" type="radio" value="1">管理员</div>
   						  <div style="width:50%" ><input name="identity" type="radio" value="0" checked="checked">用户</div> </div>
					<button type="submit" id="login">登录</button>
	 			</form>
				<p class="message">
					还没有账户?<a href="client/addUser.jsp">立刻创建</a><br>
					(⊙﹏⊙) ?<a href="client/forgetPwd.jsp" >忘记密码？</a>
				</p>
				<s:if test="msg != null">
					<font color="red">${msg }</font>
				</s:if>
			</div>
		</div>
	</div>
	<script src="beautiful/js/jquery-2.1.1.min.js" ></script>
	<script type="text/javascript">
	function check_login(){
	 var name=$("#userName").val();
	 var pass=$("#userPwd").val();
	if(name=="" || pass==""){
	  	$("#login_form").removeClass('shake_effect');  
	  	setTimeout(function() {
	  		 $("#login_form").addClass('shake_effect')
	 	 },1);  
	 }
	}
	$(function(){
		$("#login").click(function(){
			check_login();
			return true;
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