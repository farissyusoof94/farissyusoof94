<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%!
		Connection conn;
	    PreparedStatement pstmt;
	    String qry;
	    String custid;
%>
<%
	if (request.getParameter("id") != null && request.getParameter("id") != ""){
		custid = request.getParameter("id");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","UPS", "faris");
			qry = "DELETE FROM CUSTOMER WHERE customerid = '"+custid+"'";	
			pstmt = conn.prepareStatement(qry);
			
			pstmt.executeUpdate();
			response.sendRedirect("customerdetails(M).jsp");
		   } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	
	}
%>