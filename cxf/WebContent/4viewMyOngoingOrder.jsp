<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  function Visible(){
	var ui =document.getElementById("d1");
	ui.style.visibility="visible";
}
  function getunpayorder(){
	  $.ajax({
		  url:'<%=basePath%>GetPayOrderServlet',
		  data:{id:'1'},
		  success:function(data){
			  var data = eval("("+data+")");
			  var body = "";
			  if(data.length>0){
				  for(var i=0;i<data.length;i++){
					  var productid = data[i].product.id;
					  var content = "";
					  content+="<li>"
			          +"<figure class=\"box-img\"><img src=\"images/page2-img2.jpg \"/></figure>"
			          +"<div class=\"overflow\">"
			          +"<h4>name</h4>"
			          +"<h2>id:"+productid+"</h2>"
			          +"<div> amount:"+data[i].amount+" </div> "
			          +"<div> cost: "+data[i].money+"</div> "
			          +"<div> time: "+new Date(data[i].timeStamp).toString()+"</div> "
			          +"</div>"
			          +"<div class=\"clear\"></div>"
			          +"</li>";
			          body+=content;
				  }
				 $('#list').html(body);
			  }
		  }
	  });
  }
  $(document).ready(function(){
	  getunpayorder();
  });
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
           <li><a  href="1generateOrder.jsp">发起订单</a></li>
          <li ><a href="3viewDeWaitOrder.jsp">未预转账订单</a> </li>
          <li><a href="2viewMyWaitOrder.jsp">未转账订单</a></li>
          <li class="active"><a href="4viewMyOngoingOrder.jsp">成功订单</a></li>
         
        </ul>
      </nav>
      <div class="clear"></div>
    </div>
  </div>
</header>

<!--==============================content=================================-->





      <div class="padd-1">
        <h3>我的已付款订单</h3>
      </div>
      <ul class="list-teachers" id="list">


                <!-- <li>
          <figure class="box-img"><img src="images/page2-img2.jpg " alt="" /></figure>
          <div class="overflow">
            <h4>name</h4>
             <h2>status</h2>
            <div> amount: </div> 
            <div> cost: </div> 
            <div> sku: </div> 
            <div> time: </div> 
            <a href="#" class="btn">接收</a><a href="#" class="btn">转账</a> </div>
          <div class="clear"></div>
        </li> -->
       
      </ul>
    </article>
    <div class="clear"></div>
  </div>
</section>

<!--==============================footer=================================-->

</body>
</html>
