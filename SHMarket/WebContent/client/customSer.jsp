<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>   
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
<style type="text/css">
.y1{
width:1200px;
margin-top:40px;
background-color:  #44c1a5;
height:100%;
margin-left: 60px;
color:white;
} 
td{
width:300px;
}
th{
width:200px;
height:50px;
}
  a{
  color:white;
  }
  a:link {
  color:white; text-decoration:none; 
  }  
 a:hover 
 {
  color:grey; text-decoration:none; 
 } 
 table{
 margin-left: 150px;
 margin-top:50px;
 }
</style>
<script type='text/javascript'  src='beautiful/js/jquery-2.1.1.min.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#r").hide();
		var i = 0;
		$("#reply").click(function() {
			if (i == 1) {
				$("#r").hide();
				i = 0;
			} else {
				$("#r").show();
				i = 1;
			}
		});
	});
</script>
</head>
<body> 
<div class="y1">
  <div class="q1">
  <a href="goods/clientaddAction"><img src="img/fh.jpg"/></a>
  </div>
<s:form action="comments/registerCommentsAction!registerComments" method="post">
<s:hidden name="comments.userId" label="发帖人"  value="%{#session.loginUser.userId}"></s:hidden><br> 
<s:textarea name="comments.content" label="内容"></s:textarea> 
<s:submit value="提交" ></s:submit>
</s:form>
<s:if test="commentsList == null">
	${msg } 
 </s:if>
 <s:else>
 <table >
        <tr>
         <th>编号</th><th>内容</th><th>日期</th><th>操作</th></tr>
     <s:iterator value="commentsList" var="m" status="sign">
  <tr>
  <th><s:property value="#sign.count"/></th>
  <th><s:property value="#m.content"/></th>
  <th><s:date name="#m.writeTime"/></th>
	<th>
  	<s:url action="registerReplyAction!selectReply" namespace="/reply" var="select">
  		<s:param name="reply.commentId" value="#m.commentId"></s:param>
  		<s:param name="comments.userId" value="#m.userId"></s:param>
	</s:url>
	<s:a href="%{#select}" id="reply">查看回复</s:a>
	</th>
  </tr>
 </s:iterator>
 </table >
 </s:else>
 <s:if test="replyList.size() == 0"> 
<th></th>
${msg}
 </s:if>
 <s:else>
  <table >
  <tr> <th>管理员留言</th>  </tr>
        <tr> 
         <th>编号</th><th>内容</th><th>日期</th></tr>
     <s:iterator value="replyList" var="r" status="sign">
  <tr>
  <th><s:property value="#sign.count"/></th>
  <th><s:property value="#r.replyContent"/></th>
  <th><s:date name="#r.writeTime"/></th>
  </tr>
 </s:iterator>
 </table>
 </s:else>
	</div>
	 
</body>
</html>