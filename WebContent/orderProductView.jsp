<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"          
import="UPS.Bean.*"%>
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
<title>Owner & Pet Information Listing| VeterinaryFamily</title>
<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="css/app.v2.css" type="text/css" />	
<link rel="stylesheet" href="css/font.css" type="text/css" cache="false" />
<link rel="stylesheet" href="js/calendar/bootstrap_calendar.css" type="text/css" cache="false" />
<!--[if lt IE 9]> 
<script src="js/ie/html5shiv.js" cache="false"></script> 
<script src="js/ie/respond.min.js" cache="false"></script> 
<script src="js/ie/excanvas.js" cache="false"></script> 
<![endif]-->

</head>

<body>
<!--  UserBean currentStaff = (UserBean) session.getAttribute("currentSessionStaff");%> -->
<%UserBean currentStaff = (UserBean) session.getAttribute("currentSessionStaff");
UserBean currentDoctor = (UserBean) session.getAttribute("currentSessionDoctor");
  customerBean currentCustomer = (customerBean) session.getAttribute("currentSessionCustomer");
%>
 
	<%!
		Connection conn;
	    Statement stmt;
	    ResultSet result;
	    ResultSet result1;
	    String qry;
	    String qry1;
	    String bookid;
	%>
	<%
          	
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","UPS", "faris");
	if (request.getParameter("id") != null && request.getParameter("id") != "") {
		bookid = request.getParameter("id");
	try{
			
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			stmt = conn.createStatement();
			qry = "SELECT B.BOOKID, B.CUSTOMERID, B.BOOKDATE, B.COLLECTDATE, P.PRODUCTID, P.QUANTITY, P.PRICE, FROM BOOKING B INNER JOIN BOOKING_PRODUCT P ON B.BOOKID = P.BOOKID";
			result = stmt.executeQuery(qry);
		   } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
          <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
              <li><a href="#">Customer & Order Management</a></li>
            </ul>
            <div class="row">
              <div class="col-md-12" style="
	      padding-left:30px;
	      padding-right:10px;">
                <section class="panel panel-default" style=" width:1080px;
		border-left-width: 1px;
		border-right-width: 1px;
		border-top-width: -;
		padding-top: -;">
		
                  <header class="panel-heading">Customer & Order Listing </header>
                  <div class="row text-sm wrapper" style="padding-left: 20px;">
                   
                     <div align= "left" class="col-sm-8 m-b-xs">
                      <div>

                         <a href="createCustomer.jsp"  class="btn btn-s-md btn-primary btn-rounded">Add Customer Order</a>
                      </div>
                    </div>
                    
                     </div>
                  
         
                  
                  <div class="table-responsive">
                    <table class="table table-striped b-t b-light text-sm">
                      <thead>
                        <tr>
			  			  <th width="60">Order ID</th>
                          <th width="200">Customer ID</th>
			  			  <th width="700">Order Date</th>
                          <th width="110">Collect Date</th>
			  			  <th width="90">Product ID</th>
			 		 	  <th width="110">Quantity</th>
                          <th width="200">Price</th>
			  			  
                        </tr>
                      </thead>
                      <tbody>
                      	<%
                      		while(result.next()){
                      			bookid = result.getString("bookid");
                      	%>
                      	<tr>
                      		<td><%=bookid%></td>
                      		<td><%=result.getString("customerid")%></td>
                      		<td><%=result.getString("orderdate")%></td>
                      		<td><%=result.getString("collectdate")%></td>
                      		<td><%=result.getString("productid")%></td>
                      		 <td><%=result.getString("quantity")%></td>
  							<td><%=result.getString("price")%></td>
  							
  							
  							 
                      	</tr>
                      	<%
                      		}
                      	%>
                      	<%
                      		}
                      	%>
                      </tbody>
                    </table>
                  </div>
                  <footer class="panel-footer">
                    <div class="row">
                      <div class="col-sm-4 hidden-xs">
                        
                      
                      </div>
                      <div class="col-sm-4 text-center"> <small class="text-muted inline m-t-sm m-b-sm"></small> </div>
                      
                    </div>
                  </footer>
                </section>
              </div>
            </div>
          </section>
        </section>
        <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a> </section>
      <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">Notification</div>
      </aside>
    </section>
  </section>
</section>

<!-- App --> 
<script src="js/app.v2.js"></script> 
<script src="js/charts/easypiechart/jquery.easy-pie-chart.js" cache="false"></script> 
<script src="js/charts/sparkline/jquery.sparkline.min.js" cache="false"></script> 
<script src="js/charts/flot/jquery.flot.min.js" cache="false"></script> 
<script src="js/charts/flot/jquery.flot.tooltip.min.js" cache="false"></script> 
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