<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>已付款订单</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  </head>

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a class="hidden-phone visible-tablet visible-desktop" onClick=balance()>查看账户余额</a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i>Admin
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="#">我的账户</a></li>
                            <li class="divider"></li>
                            <li><a tabindex="-1" class="visible-phone" href="#">设置</a></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="#">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="index.html"> <span class="second">AdvantWise</span></a>
        </div>
    </div>
    <div class="sidebar-nav">
        <form class="search form-inline">
            <input type="text" placeholder="搜索......">
        </form>

        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-user"></i>订单管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="/cxfcompany/payingOrder.jsp">未付款订单</a></li>
            <li ><a href="/cxfcompany/payedOrder.jsp">已付款订单</a></li>
        </ul>


    </div>
    

    
    <div class="content">
        
        <div class="header">
            
            <h1 class="page-title">已付款订单</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">主页</a> <span class="divider">/</span></li>
            <li class="active">已付款订单</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="btn-toolbar">
  <div class="btn-group">
  </div>
</div>
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th style="width: 10%;">订单ID</th>
          <th style="width: 12%;">用户名</th>
          <th style="width: 10%;">产品名</th>
          <th style="width: 10%;">数量</th>
          <th style="width: 15%;">材质</th>
          <th style="width: 10%;">费用</th>
        </tr>
      </thead>
      <tbody id="orderList">
    
      </tbody>
    </table>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">拒绝申请</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>确定拒绝该申请吗？</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" data-dismiss="modal">拒绝</button>
    </div>
</div>
<div class="modal small hide fade" id="photo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <img src="images/art1a.JPG">
</div>
<div class="modal small hide fade" id="img1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <img src="images/art1a.JPG">
</div>
<div class="modal small hide fade" id="img2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <img src="images/art1a.JPG">
</div>                   
            </div>
        </div>
    </div>
    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
    function balance(){
    	$.ajax({
    		url:'/cxfcompany/GetBalanceServlet',
    		type:'POST',
    		data:{
    			id:2
    		},
    		success:function(data){
    			alert("您的账户余额为"+data);
    		}
    	});
    }
    $(document).ready(function(){
    	 $.ajax({
    		url:'/cxfcompany/GetOrderListServlet',
    		type:'POST',
    		data:{
    			isPay:1
    		},
    		success:function(data){
    			var list = eval(data);
    			var html = "";
    			for(var i=0; i<list.length; i++){
    				var order = list[i];
    				html +="<tr>";
    				html +="<td>"+order.orderId+"</td>";
    				html +="<td>"+order.custommerName+"</td>";
    				html +="<td>"+order.productName+"</td>";
    				html +="<td>"+order.productManufacture+"</td>";
    				html +="<td>"+order.prodectNum+"</td>";
    				html +="<td>"+order.cost+"</td>";
    		    }
    			$('#orderList').html(html);
    		}
    	});
    });
    </script>
    
  </body>
</html>


