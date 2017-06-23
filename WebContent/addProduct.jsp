<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "UPS.Bean.*" %>
       
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="UPS.*"%>
<!DOCTYPE html>
<html lang="en" class="app" style="height: 810px;">
<head>
<meta charset="utf-8" />
<title>Add Product | UPS</title>
<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="css/app.v2.css" type="text/css" />
<link rel="stylesheet" href="css/font.css" type="text/css" cache="false" />
<link rel="stylesheet" href="js/calendar/bootstrap_calendar.css" type="text/css" cache="false" />


</head>
<body>
<%UserBean currentStaff = (UserBean) session.getAttribute("currentSessionStaff");
  customerBean currentCustomer = (customerBean) session.getAttribute("currentSessionCustomer");
  createOrder currentOrder = (createOrder) session.getAttribute("currentSessionOrder");
%>
<%!
		Connection conn;
	    Statement stmt;
	    ResultSet result;
	    String qry;
	    String bookid;
	    String custid;
	    String productid;
	%>
	<%
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","UPS", "faris");
	if (request.getParameter("id") != null && request.getParameter("id") != "") {
		productid = request.getParameter("id");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			stmt = conn.createStatement();
			qry = "SELECT * FROM product WHERE productid = '"+productid+"'";	
			result = stmt.executeQuery(qry);
		   } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	}
	%>

<section class="vbox" style="height: 770px;">
  <header class="bg-dark header navbar navbar-fixed-top-xs">
    <div class="navbar-header aside-md"> <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen" data-target="#nav"> <i class="fa fa-bars"></i> </a> <a href="#" class="navbar-brand" data-toggle="fullscreen"><img src="images\UPS.png" class="m-r-sm"></a> <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user"> <i class="fa fa-cog"></i> </a> </div>
    <div class="nav navbar-nav hidden-xs"><small class="tagline"></small></div>
    <ul class="nav navbar-nav navbar-right hidden-xs nav-user">
      <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"> You logged in as &nbsp;<strong><%= currentStaff.getRole() %></strong> <b class="caret"></b> </a>
        <ul class="dropdown-menu animated fadeInRight">
          <span class="arrow top"></span>
          <li class="divider"></li>
          <li> <a href="login1.jsp">Logout</a> </li>
        </ul>
      </li>
    </ul>
    <style>

</style>
  </header>
  <section>
    <section class="hbox stretch"> <!-- .aside -->
      <aside class="bg-dark lter aside-md hidden-print" id="nav">
        <section class="vbox">
          
          <section class="w-f scrollable">
            <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="7px" data-color="#f29337"> <!-- nav -->
              <nav class="nav-primary hidden-xs">
                <ul class="nav">
                  <li class="active"> <a href="home.jsp" class="parent active"> <i class="fa fa-home icon"> </i> <span class="menuTxt">HOME</span> </a> </li>
                     <li > <a class="parent"> <i class="fa fa-user icon"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span class="menuTxt">Customer & Order Management</span> </a> 
                  	<ul class="nav lt">
                      <li > <a href="createCustomer.jsp" > <i class="fa fa-angle-right"></i> <span>Add Customer & Order</span> </a> 
		        </li>
					  <li > <a href="customerdetails.jsp" > <i class="fa fa-angle-right"></i> <span>View Customer & Order</span> </a> 
					  <ul class="nav bg">
                          <li > <a href="customerdetails.jsp"  > <i class="fa fa-angle-right"></i> <span>View Customer & Order Details</span> </a> </li>
                          <li > <a href="custList.jsp"  > <i class="fa fa-angle-right"></i> <span>View Customer Details</span> </a> </li>
                          <li > <a href="viewOrder.jsp" > <i class="fa fa-angle-right"></i> <span>View Order Details</span> </a> </li>
                        </ul>
                    </ul>
                  </li>
                    
              </nav>
              <!-- / nav --> </div>
	      	    <div class="slimScrollRail" style="width: 7px;height: 100%;position: absolute;top: 0px;display: block;border-radius: 7px;background: #71243d;opacity: 1;z-index: 90;right: 0px;"></div>

          </section>

<footer class="footer lt hidden-xs b-t b-dark">
            <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-dark btn-icon"> <i class="fa fa-angle-left text"></i> <i class="fa fa-angle-right text-active"></i> </a>
          </footer>
        </section>
      </aside>
      <!-- /.aside -->
      
      <section id="content">
        <section class="vbox">
          <section class="scrollable padder" style="
	  padding-right:50px;
	  padding-left:50px;">
            
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
              <li><a href="index.html"><i class="fa fa-home"></i>Customer & Order Management</a></li>
            </ul>
            <div class="m-b-md">
             
             <section class="panel panel-default">
              <header class="panel-heading font-bold">Add Product Form</header>
              <div class="panel-body" style"
	      padding-right:0px;
	      padding-left:0px;">
                <form class="form-horizontal" name = "productBean" action = "productServlet">
                <%
                      		while(result.next()){
                      			productid = result.getString("productid");
                      	%>
                  <div class="form-group">

		 
		 <div class="form-group">
                    <label class="col-sm-3 control-label" style="font-size:180%;">Product Information</label>
                    
                  </div>
				   <div class="line line-dashed line-lg pull-in"></div>
				    <div class="form-group">
                    <label class="col-sm-2 control-label">Product ID</label>
                    <div class="col-sm-2">
                     
                      <input type="text" class="form-control"   readonly="readonly" name = "productid" value="<%= result.getString("productid") %>" >
                    </div>
		  
		  <label class="col-sm-2 control-label">Order ID</label>
                    <div class="col-sm-2">
                     
                      <input type="text" class="form-control"   readonly="readonly" name = "bookid" value=<%= currentOrder.getbookid() %>>
                    </div>
		  
		  
		  </div>
		  
				   <div class="line line-dashed line-lg pull-in"></div>
				    <div class="form-group">
                    <label class="col-sm-2 control-label">Product Name</label>
                    <div class="col-sm-2">
                     
                      <input type="text" class="form-control"   readonly="readonly" name = "productname" value="<%= result.getString("productname") %>" >
                    </div>
                    
                     
		  
		  

				    <div class="form-group">
                    <label class="col-sm-2 control-label">Product Price (RM)</label>
                    <div class="col-sm-2">
                     
                      <input type="text" class="form-control"   readonly="readonly" name = "productprice" id="productprice" value="<%= result.getString("productprice") %>" >
                    </div>
					</div>
				   <div class="line line-dashed line-lg pull-in"></div>
					
					<div class="form-group">
                    <label class="col-sm-2 control-label">Quantity</label>
                   <div class="col-sm-2">
                       <input type="text" class="form-control" name="quantity" id="quantity" required>
                    </div>
					</div>
					
                  <div class="line line-dashed line-lg pull-in"></div>
                  
                  <div class="form-group">
				    <label class="col-sm-2 control-label">Sleeve Text</label>
                   <div class="col-sm-2">
                       <input type="text" class="form-control" name="sleeve_text" id="sleeve_text" required>
                    </div>
                    
                    <label class="col-sm-2 control-label">Back Text</label>
                   <div class="col-sm-2">
                       <input type="text" class="form-control" name="back_text" id="back_text" required>
                    </div>
                   </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                   
                    <div class="form-group">
				    <label class="col-sm-2 control-label">Description</label>
                      <textarea rows="5" cols="40" name="description" id="description" required></textarea>
                      
                    </div>
                  
               
                    
				     <div class="line line-dashed line-lg pull-in"></div>
				  
				
					

			
                  <div class="form-group">
                    <div class="col-sm-11" align = "right">
					<br> <br>

                      <input type="submit" value="Submit" class="btn btn-s-md btn-primary btn-rounded" onclick="Order Success!">
                     
                     
                    </div>
                  </div></div>
	<%
                      		}
                %>
                     
             </form>    
        </div>
	</section>
	</section>
</section>
        <a href="#" class="hide nav-off-screen-block" data-

toggle="class:nav-off-screen" data-target="#nav"></a> </section>
      <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">Notification</div>
      </aside>
    </section>
  </section>
</section>



<!-- App --> 
<script src="js/app.v2.js"></script> 
<script src="js/charts/easypiechart/jquery.easy-pie-chart.js" 

cache="false"></script> 
<script src="js/charts/sparkline/jquery.sparkline.min.js" 

cache="false"></script> 
<script src="js/charts/flot/jquery.flot.min.js" cache="false"></script> 
<script src="js/charts/flot/jquery.flot.tooltip.min.js" 

cache="false"></script> 
<script src="js/charts/flot/jquery.flot.resize.js" cache="false"></script> 
<script src="js/charts/flot/jquery.flot.orderBars.js" cache="false"></script> 
<script src="js/charts/flot/jquery.flot.pie.min.js" cache="false"></script> 
<script src="js/charts/flot/jquery.flot.grow.js" cache="false"></script> 
<script src="js/charts/flot/jquery.flot.time.js" cache="false"></script> 
<script src="js/calendar/bootstrap_calendar.js" cache="false"></script> 
<script src="js/calendar/demo.js" cache="false"></script> 
<script src="js/sortable/jquery.sortable.js" cache="false"></script> 
<script src="js/script.js"></script>
	
</body>
</html>