<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css"
 href="beautiful/css/comments.css" /> 
</head> 
<body>
<div class="Main">     
         <div class="Input_Box">     
           <textarea class="Input_text"></textarea>     
           <div class="faceDiv"> </div>     
           <div class="Input_Foot"> 
           <a class="imgBtn" href="javascript:void(0);"></a>
           <a class="postBtn">确定</a> </div>     
         </div>     
       </div>  
</body>
</html>