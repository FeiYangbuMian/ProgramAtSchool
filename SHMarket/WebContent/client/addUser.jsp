<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.net.URLDecoder" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<link rel="stylesheet" type="text/css"
	href="beautiful/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="beautiful/css/htmleaf-demo.css">
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
</style>
</head>
<body>
	<div class="htmleaf-container">
	<header class="htmleaf-header">
		<h1>
			有朋自远方来，不亦说乎 <span>Welcome here!</span>
		</h1>
		</header>	
		<div id="wrapper" class="login-page">
			<div id="login_form" class="form">
			<!-- 默认 -->
				<form action="user/clientuserManagerAction!insertUser" method="post" name="rigister">
					<input type="text" name="user.userName" placeholder="用户名" id="userName">
					<input type="password" name="user.userPwd" placeholder="密    码" id="userPwd">
					<input type="text" name="user.userEmail" placeholder="电子邮箱" id="inputEmail">
					<input  style="width: 49%; float: left;" type="text" name="code" placeholder="验证码"  id="code"/>
					<button style=" width:49%; float: right;" type="button" id="btn_code" >发送验证码</button>
					<button id="btn_rigister" type="submit">注册</button>
				</form>
				<p class="message">
					已经有账户了?<a href="client/login.jsp">立刻登录</a>
				</p>
				<s:if test="msg != null">
			<s:property value="msg"></s:property>
		</s:if>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="beautiful/js/jquery.min.js"></script>
	<script type="text/javascript">
	/* 提交结果，执行ajax */
var demo;
function getcode(){
	   $.ajax({
	        type: "post",
	        url: "json/JsonAction!excuteAjax.action",
	        //需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
	        data: { //设置数据源
	            email: $("#inputEmail").val()
	            //这里不要加","  不然会报错，而且根本不会提示错误地方
	        },
	        dataType: "json",
	        //设置需要返回的数据类型
	        success: function(data) {
	            var d = eval("(" + data + ")"); //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
	            //得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
	            demo = d.code;
	            //alert(demo);
	        },
	        error: function() {
	            alert("找不到？");
	        } //这里不要加","
	    });
}
function check_register() {
    var name = $("#userName").val();
    var pass = $("#userPwd").val();
    var email = $("#inputEmail").val();
    var co=  $("#code").val();
    if (name == "" || pass == "" || email ==""||co==""){
        $("#login_form").removeClass('shake_effect');
        setTimeout(function() {
            $("#login_form").addClass('shake_effect')
        },
        1);
    }if(co!=demo){
    	alert("验证码错误！");
    } else{
    	document.myForm.submit();  
    }
}
$(function() {
	 $("#btn_code").click(function() {
		 getcode();
	     return false;
	    }) 
    $("#btn_rigister").click(function() {
        check_register();
        return false;
    }) 
    $('.message a').click(function() {
        $('form').animate({
            height: 'toggle',
            opacity: 'toggle'
        },
        'slow');
    });
})
</script>
</body>
</html>