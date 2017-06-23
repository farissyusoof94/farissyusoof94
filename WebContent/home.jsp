<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"          
import="UPS.Bean.*"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
   <html>  
      <head>         
      	<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">          
      	<title>User Logged Successfully</title>   
      	<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
        <!-- CSS Files comes here -->
        <link rel="stylesheet" href="css/bootstrap.css" media="screen">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/owl.carousel.css" rel="stylesheet" media="screen">
        <link href="css/owl.theme.css" rel="stylesheet" media="screen">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css" media="screen">   
        
        
        <div class="preloader"> 
    <!--      <style>
       body 
	{
		background:url(image/bc.jpg) no-repeat center center fixed; 
		min-height: 800px;
		-webkit-background-size: cover;
  		-moz-background-size: cover;
  		-o-background-size: cover;
 		background-size: cover;
	}
        </style> -->
      </head>         
      <body>
                 
                     
   		
     	  <div class="preloader"> 
       		 <!--Background -->
			 <!-- image is set in the CSS as a background image -->
			<div class="backgroundcover" style="height: 780px;"></div>
		<!-- End  Background -->
	
		<!-- Start Header -->
		<header class="header" id="home" class="navbar navbar-inverse navbar-fixed-top" role="banner">
	  	<div class="container">
	    	<div class="navbar-header">
	      		<button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
	        		<span class="sr-only">Toggle navigation</span>
	        		<span class="icon-bar"></span>
	        		<span class="icon-bar"></span>
	        		<span class="icon-bar"></span>
	      		</button>
	     <!-- Your Logo -->
              <a href="" class="navbar-brand"><img src="images/UPS.png" height="49px" width="242px" alt="SAVO" style="margin-top: 15px;"/></a>
	    </div>
	    <!-- Start Navigation -->
	    <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	      <ul class="nav navbar-nav menu">
	        <li>
	          <a href="home.jsp">Home</a>
	        </li>
	        <li>
	          <a href="customerdetails.jsp">View Customer Order </a>
	        </li>
	      </ul>
	    </nav>
	  </div>
	</header>
	<!-- End Header -->
	
	<!-- Start main Section	-->
	<section id="main"  class="section main" style="margin-top: 0px;">
		<div class="container">
			<div class="row">
				<div class="col-md-5"></div>
				<div class="col-md-7">
					<div class="lp-element">
						<h1 data-scroll-reveal="wait 0.25s, then enter top and move 40px over 1s">Ukhwah Printing System (UPS)</h1>
						<center>               
						<%UserBean currentStaff = (UserBean) session.getAttribute("currentSessionStaff");%>              
                                                
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--End Main -->
	
    	<script src="library/jquery-2.0.3.min.js"></script>
    	<script src="library/jquery.easing.min.js"></script>
   	 	<script src="library/owl.carousel.min.js"></script>
    	<script src="library/scrollreveal.js"></script>
    	<script src="library/jquery.prettyPhoto.js"></script>
    	<script src="library/jquery.scrollto.min.js"></script>
    	<script src="library/waypoints.min.js"></script>
    	<script src="js/notify.js"></script>
    	<script src="js/function.js"></script>   
   	 </body>      
 </html> 