<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>二手交易市场登录</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <link rel="stylesheet" href="css/demo.css" />
  <link rel="stylesheet" href="css/templatemo-style.css">
  
  <script type="text/javascript" src="js/modernizr.custom.86080.js"></script>
<style type="text/css">
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
 width:150px;
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
 var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
      'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
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
	var u="s"
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
	<body onload="createCode()" id="form1" runat="server" >
			<div id="particles-js"></div>
		
			<ul class="cb-slideshow">
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	            <li></li>
	        </ul>
			<div class="container-fluid">
				<div class="row cb-slideshow-text-container ">
					<div class= "tm-content col-xl-6 col-sm-8 col-xs-8 ml-auto section">
					
					
                    <form action="user/login.action" method="post" class="subscribe-form">
               	    	<div class="row form-section">
							<div class="col-md-7 col-sm-7 col-xs-7">
			                   <!--    <input name="username" type="text" class="form-control" id="contact_email" placeholder="请输入用户名" required/>
			                      <br>
			                      <input type="hidden" name="codecheck" id="codecheck"/>
			                      <input name="password" type="password" class="form-control" id="contact_email" placeholder="请输入密码" required/> -->
				  				   <br>
				  			  <div class="am-form-group" style="font-size:18px">
						                <input style="float:left;" type="text"  id="inputCode" onchange="validateCode()"/>  
						                <div class="code" id="checkCode" onclick="createCode()" >
						                
						                </div>  
	            </div>
				  				  <input name="identity" type="radio" value="1" checked="checked">管理员
   								  <input name="identity" type="radio" value="0">用户 
   								 <!--  <div  align="center">
									<button type="submit" class="tm-btn-subscribe" onclick ="WindowDialog1()" > 登 录 </button>
								  </div>
								  -->
				  			</div>
							
						</div>
                    </form>
                    
                    
					
					</div>
				</div>	
				
			</div>	
	</body>
	<script type="text/javascript" src="js/particles.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</html>