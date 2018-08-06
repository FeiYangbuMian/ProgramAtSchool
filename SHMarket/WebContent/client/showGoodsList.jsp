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
    <meta http-equiv="X-UA-Compatible" content="edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,maximum-scale=1,minimum-scale=1,initial-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <title>校园二手街|校园二手市场</title>
        <meta name="keywords" content="">
        <meta name="description" content="" />
        <link rel="stylesheet" href="beautiful/css/init.css"/>
        <link rel="stylesheet" href="beautiful/css/index.css"/>
        <style type="text/css">
        .y1{   
             font-family:serif; 
             font-size:18px;
             text-decoration:none; 
             CURSOR: hand;
			 background-color: #44c1a5;
             margin-top:12px;
             height:50px;
             width: 1200px; 
             margin-left: 60px;
             color:white;
}
        </style>
    </head>
<body >
    <div class="container">
    <div class="header">
        <div class="h-logo">  
        <a href="goods/clientaddAction"><img src="img/fh.jpg" /></a></div>
            </div>
    <form class="search-box searchgoods" action="" method="post">
        <div class="input-wr clearfix"> 
        </div>
    </form>
    <table width="100%" >
    <nav class="rank-rules">
        <ul class=" ">
            <li class="catg synthe active" style="width:20%">
                <div class="rank-icon"></div>
                <h2>商品名称</h2>
            </li>
            <li class="catg credit " style="width:20%">
                <div class="rank-icon"></div>
                <h2>商品照片</h2>
            </li>
            <li class="catg i-price " style="width:20%">
                <div class="rank-icon"  ></div>
                <h2>商品价格</h2>
            </li>
            <li class="catg hot " style="width:20%">
                <div class="rank-icon"></div>
                <h2>商品热度</h2>
            </li>
             <li class="catg hot" style="width:20%">
                <div class="rank-icon" ></div>
                <h2>详情</h2>
            </li>
        </ul>
    </nav>
    
	
    <div class="item-list">
        <!-- s:iterator为for循环 -->
		<s:iterator var="g" value="list ">
		
		<s:url action="clientaddAction!selectGoodsDetail" namespace="/goods" var="myurl1">
			<s:param name="goods.goodId" value="#g.goodId"></s:param>
		</s:url> 
           <tr align="center" >			
		   <td width="20%"><s:property value="#g.goodName" /></td>
		   <td width="20%"><img src="client/GoodsPhoto/<s:property value='#g.goodPhoto'/>" height="50" width="80" /></td>
		   <td width="20%"><s:property value="#g.goodPrice" /></td>
		   <td width="20%"><s:property value="#g.goodPraise" /></td>
		   <td width="20%" ><s:a href="%{#myurl1}" cssStyle="color:blue;">查看</s:a></td>					
	      </tr>
	     </s:iterator>
      </div>
      </table>
    <footer class="clearfix copyright">
				<br>
    
</footer>
</div>
        <script src="http://www.ischoolbar.com/App/Public/js/util.js?v=201505211453"></script>
        <script src="http://www.ischoolbar.com/App/Public/js/index.js?v=201505211453"></script>
        <script>
        
    </script>
</body>
</html>