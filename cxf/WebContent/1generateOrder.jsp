﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Courses</title>
<meta charset="utf-8">
<!--css-->
<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<link href='http://fonts.googleapis.com/css?family=PT+Serif+Caption:400,400italic' rel='stylesheet' type='text/css'>
<!--js-->
<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
<script type="text/javascript" src="js/superfish.js"></script>

<!--[if lt IE 8]>
      <div style=' clear: both; text-align:center; position: relative;'>
        <a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
          <img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
       </a>
     </div>
     
    <![endif]-->

<!--[if lt IE 9]>
   		<script src="js/html5.js"></script>
  		<link rel="stylesheet" href="css/ie.css"> 
         <link href='http://fonts.googleapis.com/css?family=PT+Serif+Caption:400italic' rel='stylesheet' type='text/css'>
       <link href='http://fonts.googleapis.com/css?family=PT+Serif+Caption:400' rel='stylesheet' type='text/css'>
	<![endif]-->
  <script>
   window.onload=function(){
	   $.ajax( {  
	       url:'<%=basePath%>GetProductServlet',// 跳转到 action  
	       data:{  },  
	     type:'post',  
	      cache:false,  
	     success:function(data) {  
	    	 var d = eval("("+data+")");
	    	var result="";
	    	var i=0;
			
	    	//alert(d[0].name);
	    	
	    	for(i=0;i<d.length;i++){ 
		     result+="<li><figure class=\"box-img\"><img src=\"images/page2-img2.jpg\"/></figure>";
	         result+="<div class=\"overflow\"><h4>商品名：";
	         result+=d[i].name;
	        // alert(result);
	         result+="</h4><h2>库存：";
	         result+=d[i].sku;
	         //alert(result);
	         result+="</h2><div>材质：";
	         result+=d[i].manufacture;
	         result+="</div><div ";
	         result+="\">价格：<span id=\"1";
	         result+=i;
	         result+="\">";
	         result+=d[i].cost;
	         result+="</span></br>数量：<input type=\"text\" id=\"";
	         result+=i;
	         result+="\"/>";
	         result+="</div><a class=\"btn\" onclick=\"requiredOrder(";
	         result+=i;
	         result+=")\">订单申请</a></div><div class=\"clear\"></div></li>";
	         
	    	}
	    	//alert(result);
	    	document.getElementById("content").innerHTML=result;
	    	 

	      },  
	      error : function() {  
	           // view("异常！");  
	           alert("异常！");  
	       }  
	 });
   }
   
   
   function requiredOrder(id){
	   
	   var id1 = "#1"+id;
	   var money  = $(id1).html();
	   var myamount=document.getElementById(id).value;
	   //alert(money);
	  // alert(amount);
	   var sum=money*myamount;
	   //alert(money);
	   $.ajax( {  
	       url:'<%=basePath%>SendOrderServlet',// 跳转到 action  
	       data:{
	    	   id:"1",
	    	   amount:myamount,
	    	   productid:"1",
	    	   money:sum
	       },  
	     type:'post',  
	      cache:false,  
	     success:function(data) {  
			alert(data);
	      },  
	      error : function() {  
	           // view("异常！");  
	           alert("异常！");  
	       }  
	 });
	   
   }
   
  </script>

</head>
<body>

<!--==============================header=================================-->
<header>
  <div class="line-top"></div>
  <div class="main">
    <div class="row-top">
      <h1><a href="index.html"><img alt="" src=""></a></h1>
      <nav>
        <ul class="sf-menu">
          <li class="active"><a  href="1generateOrder.jsp">发起订单</a></li>
          <li ><a href="3viewDeWaitOrder.jsp">未预转账订单</a> </li>
          <li><a href="2viewMyWaitOrder.jsp">未转账订单</a></li>
          <li><a href="4viewMyOngoingOrder.jsp">成功订单</a></li>
            <ul>
              <li><a href="#">dolores et</a></li>
              <li><a href="#">lorem ipsum dolo </a>
              <li><a href="#">sanctus est</a></li>
            </ul>
          </li>
         
        </ul>
      </nav>
      <div class="clear"></div>
    </div>
  </div>
</header>

<!--==============================content=================================-->





      <div class="padd-1">
        <h3>Product</h3>
      </div>
      <ul class="list-teachers">

<div id="content"></div>


       
      </ul>
    </article>
    <div class="clear"></div>
  </div>
</section>

<!--==============================footer=================================-->

</body>
</html>
