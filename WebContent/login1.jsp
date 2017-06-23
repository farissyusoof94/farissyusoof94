
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login | Ukhwah Printing System</title>
	<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link rel="stylesheet" href="css/app.v2.css" type="text/css" />
	<link rel="stylesheet" href="css/font.css" type="text/css" cache="false" />
	<!--[if lt IE 9]> 
	<script src="js/ie/html5shiv.js" cache="false"></script> 
	<script src="js/ie/respond.min.js" cache="false"></script> 
	<script src="js/ie/excanvas.js" cache="false"></script> 
	<![endif]-->
	
	<style>
	body 
	{
		background:url(image/bc.jpg) no-repeat center center fixed; 
		min-height: 800px;
		-webkit-background-size: cover;
  		-moz-background-size: cover;
  		-o-background-size: cover;
 		background-size: cover;
	}
	</style>
	</head>
	
	<body class="pattern">
		<section id="content" class="m-t-lg wrapper-md animated fadeInUp" style="margin-top: 0px;padding-top: 0px;">
 			 <div class="container aside-xxl"> <a class="navbar-brand block" href="home.jsp">&nbsp;&nbsp;</a>
 			 <center><img src="images\UPS.png"  style="width:300px;height:150px;"></center>
    			<section class="panel panel-default bg-white m-t-lg">
     				 <form action="loginServlet1" class="panel-body wrapper-lg">
        				<div class="form-group">
          					<label class="control-label">User ID</label>
          					<input type="text" name = "staffId" placeholder="User ID" class="form-control input-lg" required
          					padding-left: 10px;
          					padding-right: 10px;
          					height: 37px;
          					width: 362px;" style = "height: 37px;">
        				</div>
        	 <div class="form-group">
         	 	<label class="control-label">Password</label>
          	 	<input type="password" name = "password" id="inputPassword" placeholder="Password" class="form-control input-lg" required
          	 	padding-left: 10px;
          		padding-right: 10px;
          		height: 37px;
          		width: 362px;" style = "height: 37px;">
        	</div>
        
       
       
        <button type="submit" value = "submit" class="btn btn-primary">Sign in</button>
      </form>
    </section>
  </div>
</section>
<!-- footer -->
<footer id="footer">
  <div class="text-center padder">
    <p> <small style="color: #8a2f4c;">Ukhwah Printing System (UPS) &copy; 2017<br>
      All Rights Reserved.</small> </p>
  </div>
</footer>
<!-- / footer --> <script src="js/app.v2.js"></script> <!-- Bootstrap --> <!-- App -->
</body>
</html>