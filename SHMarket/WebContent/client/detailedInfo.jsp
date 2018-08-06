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
    <title>校园二手街|校园二手市场表情</title>
        <meta name="keywords" content="">
        <meta name="description" content="" />
        <link rel="stylesheet" href="beautiful/css/init.css"/>
        <link rel="stylesheet" href="beautiful/css/detail.css"/>
    <style type="text/css">
    .o1{
    zoom: 1;
    width:  1268.05px;
    text-align: center;
    margin-left: 0px;
    }
     .y1{   
     font-family:serif; 
     font-size:18px;
     text-decoration:none; 
     CURSOR: hand;
     background-color: #44c1a5; 
     height:30px;
     width: 1200px;  
     color:white;
}
    </style>
    </head>
<body class="detail">
    <div class="container">
    <div class="header">
        <div class=" ">
         <div class="y1">  
      <a href="" title="第一页哦" style="padding:0 35px" ></a>
      <a href="goods/clientaddAction!showGoodsDigital" title=" " style="padding:0 35px" >闲置数码 </a>
      <a href="goods/clientaddAction!showGoodsFitting" title=" "  style="padding:0 35px">家居日用</a>
      <a href="goods/clientaddAction!showGoodsSkincare" title=" " style="padding:0 35px" >护肤品</a>
      <a href="goods/clientaddAction!showGoodsMakeup" title=" " style="padding:0 35px" >化妆品</a>
</div>
        </div>
            </div>
    <div class="ershou-details">
        <div class="ershou-photos">
            <div class="big-photos">
                <ul class="clearfix">
                	<li><img src="client/GoodsPhoto/<s:property value='goods.goodPhoto'/>"/></li></ul>
            </div>
            <div class="slide-dots">
            </div>
        </div>
        <div class="ershou-info">
            <div class="ershou-hd">
                <h2 class="ershou-title"><s:property value="goods.goodName"/></h2>
                <div class="ershou-place">
                    <span>发布时间：<s:property value="goods.pubDate"/></span>
                </div>
            </div>
            <div class="ershou-address">
                <p>交易方式：<span><s:property value="goods.tradeType"/></span></p>
            </div>
            <div class="ershou-price">
                <span class="yen">&#65509;</span><span class="price">￥<s:property value="goods.goodPrice"/></span>
            </div>

            <section class="ershou-detail">
                <ul>
                    <li class="ershou-seller">
                        <div class="name avatar">
                            <div>
                            	<s:if test="user.userPhoto == 0">
									<img src="client/UserPhoto/cat.jpg"
									style="width: 100%;height: 100%">
								</s:if> 
								<s:else>
									<img
									src="client/UserPhoto/<s:property value='user.userPhoto'/>"
									style="width: 100%;height: 100%" />
								</s:else>
							</div>
                        </div>
                         <div>
                         用户可爱的头像哦
                         </div>
                    </li>
                    <li class="ershou-contact">
                        <div class="name"><div><span>详情</span></div></div>
                        <div class="value telqq"><p><s:property value="goods.goodInfo"/><br>(联系我们的时候，耐心一点哦)</p></div>
                    </li>
                    <li class="ershou-contact">
                        <div class="name"><div><span>联系方式</span></div></div>
                        <div class="value telqq">
                              <p><span>手机</span><s:property value="user.userPhone"/></p>
                       </div>
                    </li>
                    <li class="ershou-contact">
                        <div class="name"><div><span>联系方式</span></div></div>
                        <div class="value telqq">
                              <p><span>QQ</span><s:property value="user.userQQ"/></p>
                       </div>
                    </li>
                </ul>
            </section>
        </div>
    </div>
    <div>
	 <s:url action="../orders/clientregisterOrdersAction!selectOneOrdersClient" var="insert">
		<s:param name="orders.goodId" value="goods.goodId"></s:param>
		<s:param name="orders.userId" value="#session.loginUser.userId"></s:param>
		<s:param name="orders.price" value="goods.goodPrice"></s:param>
	</s:url>
	<s:a href="%{#insert}" cssStyle="color:blue;float: right;margin-right: 50px;">购买商品</s:a> 
    </div>
    <footer class="clearfix copyright">
				<br>
    
</footer>
</div>
        <script src="http://www.ischoolbar.com/App/Public/js/util.js?v=201505252216"></script>
        <script src="http://www.ischoolbar.com/App/Public/js/index.js?v=201505252216"></script>
        <script>  
	    </script>
</body>
</html>