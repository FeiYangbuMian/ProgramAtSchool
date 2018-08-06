<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 *{margin:0;
 padding:0;
 list-style:none;}
 .wrap{height:400px;
 width:1200px;
 margin:60px auto;
 overflow: hidden;
 position: relative;
 margin:100px auto;}
 .wrap ul{position:absolute;} 
 .wrap ul li{height:170px;}
 .wrap ol{position:absolute;
 right:5px;
 bottom:10px;}
 .wrap ol li{height:20px; width: 20px;
 background:#ccc;
 border:solid 1px #666;
 margin-left:5px;
 color:#000;
 float:left;
 line-height:center;
 text-align:center;
 cursor:pointer;}
 .wrap ol .on{background:#E97305;
 color:#fff;}
 div{ 
  height:80px;
}
.y1{   
font-family:serif; 
font-size:30px;
text-decoration:none; 
CURSOR: hand;
background-color: #44c1a5;
margin-top:12px;
height:50px;
width: 1200px; 
margin-left: 60px;
color:white;
}
  .z1{
  margin-left:100px;
  margin-top:25px;
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
 
</style>
<script type="text/javascript">
window.onload = function() {
    var wrap = document.getElementById('wrap'),
    pic = document.getElementById('pic').getElementsByTagName("li"),
    list = document.getElementById('list').getElementsByTagName('li'),
    index = 0,
    timer = null;

    // 定义并调用自动播放函数
    timer = setInterval(autoPlay, 2000);//参数一是函数，参数二隔多久执行

    // 鼠标划过整个容器时停止自动播放
    wrap.onmouseover = function() {
        clearInterval(timer);//停止执行
    }

    // 鼠标离开整个容器时继续播放至下一张
    wrap.onmouseout = function() {
        timer = setInterval(autoPlay, 2000);
    }
    // 遍历所有数字导航实现划过切换至对应的图片
    for (var i = 0; i < list.length; i++) {
        list[i].onmouseover = function() {
            clearInterval(timer);
            index = this.innerText - 1;
            changePic(index);
        };
    };

    function autoPlay() {
        if (++index >= pic.length) 
        	index = 0;
        changePic(index);
    }

    // 定义图片切换函数
    function changePic(curIndex) {
        for (var i = 0; i < pic.length; ++i) {
            pic[i].style.display = "none";
            list[i].className = "";
        }
        pic[curIndex].style.display = "block";
        list[curIndex].className = "on";
    }
};
 
 </script> 
</head>
<link rel="stylesheet" type="text/css"
	href="beautiful/css/init.css" />
<link rel="stylesheet" type="text/css"
	href=" beautiful/css/index.css">
<link rel="stylesheet" type="text/css"
	href=" beautiful/css/compatible.css">
 
<body>
<div class="y1">  

<a href="" title="第一页哦" style="padding:0 35px" ></a>
<a href="index.jsp" title="第一页哦" style="padding:0 35px" >首页 </a>
<s:if test="session == null">
<a href="client/login.jsp" title="看看有啥检漏的"  style="padding:0 35px">购买二手商品 </a>
<a href="client/login.jsp" title="看看有啥不用的" style="padding:0 35px" >发布商品</a>
<a href="client/login.jsp" title="有不懂的加客服的QQ和微信" style="padding:0 35px" >客服 </a>
</s:if>
<s:else>
<a href="" title="第一页哦" style="padding:0 35px" ></a>
<a href="goods/clientaddAction!showGoodsAllClient" title="看看有啥检漏的"  style="padding:0 35px">购买二手商品 </a>
<a href="client/insertGoods.jsp" title="看看有啥不用的" style="padding:0 35px" >发布商品</a>
<a href="client/customSer.jsp" title="有不懂的加客服的QQ和微信" style="padding:0 35px" >客服 </a>
</s:else>
<s:if test="session == null">
	<a href="client/login.jsp" title="请先登录" >登录</a>/
</s:if>
<s:else>
	<a href="client/loginOut.jsp" title="退出登录" >退出登录</a>/
</s:else>
<a href="client/addUser.jsp" title="没注册的话，先注册吧" >注册</a>
</div>
<nav class="categories"><include file="com/itshixun/struts/goodsManagerAction.xml"></include>
        <ul class="clearfix">
            <li class="catgg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                    <h2>闲置数码 </h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsDigital"> 
                    <h2> 闲置数码</h2>
                </a>
			</s:else>
            </li>
              <li class="catg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                    <h2>平板电脑 </h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsPad"> 
                    <h2> 平板电脑</h2>
                </a>
			</s:else>
            </li>
            <li class="catg">
                <a href="#">
                    <h2> 手机</h2>
                </a>
            </li>
            <li class="catg">
                <a href="#">
                    <h2>相机</h2>
                </a>
            </li> 
            <li class="catg">
                <a href="#">
                    <h2>笔记本</h2>
                </a>
            </li> 
            <li class="catgg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                    <h2>家居日用</h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsFitting"> 
                    <h2>家居日用 </h2>
                </a>
			</s:else>
            </li>
              <li class="catg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                    <h2>四件套</h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsFour"> 
                    <h2>四件套 </h2>
                </a>
			</s:else>
            </li>
            <li class="catg">
                <a href="#"> 
                    <h2> 地毯</h2>
                </a>
            </li>
            <li class="catg">
                <a href="#">  
                    <h2>家纺家饰</h2>
                </a>
            </li>
             <li class="catg">
                <a href="#">  
                    <h2>家用电器</h2>
                </a>
            </li>
            <li class="catgg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                   <h2>护肤品 </h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsSkincare">
                    <h2>护肤品 </h2>
                </a>
			</s:else>
            </li>
              <li class="catg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                   <h2>乳液 </h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsCream">
                    <h2>乳液 </h2>
                </a>
			</s:else>
            </li>
            <li class="catg">
                <a href="#"> 
                    <h2> 爽肤水</h2>
                </a>
            </li>
            <li class="catg">
                <a href="#"> 
                    <h2> 面膜</h2>
                </a>
            </li>
           <li class="catg">
                <a href="#">  
                    <h2> 精华</h2>
                </a>
            </li>
            <li class="catgg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                   <h2>化妆品 </h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsMakeup"> 
                    <h2>化妆品 </h2>
                </a>
			</s:else>
            </li>
             <li class="catg">
            <s:if test="session == null">
				<a href="client/login.jsp"> 
                   <h2>口红</h2>
                </a>
			</s:if>
			<s:else>
				<a href="goods/clientaddAction!showGoodsLip"> 
                    <h2>口红 </h2>
                </a>
			</s:else>
            </li>
            <li class="catg">
                <a href="#"> 
                    <h2> 粉底液</h2>
                </a>
            </li>
            <li class="catg">
                <a href="#"> 
                    <h2> 眉笔</h2>
                </a>
            </li>
            <li class="catg">
                <a href="#"> 
                    <h2> 眼影</h2>
                </a>
            </li> 
                    </ul>
        <div class="z1" >
        <s:if test="session == null">
				 <a href="client/login.jsp" style="padding:0 80px">
            <img src="img/fabu.jpg" />
        </a>
			</s:if>
			<s:else>
				 <a href="client/insertGoods.jsp" style="padding:0 80px">
            <img src="img/fabu.jpg" />
        </a>
			</s:else>
       <s:if test="session == null">
				 <a href="client/login.jsp">
            <img src="img/grxz.jpg" />
        </a>
			</s:if>
			<s:else>
			<s:url action="clientaddAction!selectGoodsByUserId" namespace="/goods" var="select">
				<s:param name="goods.userId" value="#session.loginUser.userId"></s:param>
			</s:url>
			<s:a href="%{#select}"><img src="img/grxz.jpg"/></s:a> 
			</s:else>
       
    </div>
   <div class="wrap" id='wrap'>
 <ul id="pic">
 <li><img src="img/liu1.jpg" alt=""></li>
 <li><img src="img/liu2.jpg" alt=""></li>
 <li><img src="img/liu3.jpg" alt=""></li>
 <li><img src="img/liu4.jpg" alt=""></li> 
 </ul>
 <ol id="list">
 	<li class="on">1</li>
 	<li>2</li>
 	<li>3</li>
 	<li>4</li>
 </ol>
 </div>
    </nav>
</body>
</html>