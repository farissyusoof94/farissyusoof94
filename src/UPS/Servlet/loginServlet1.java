package UPS.Servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import UPS.Bean.UserBean;
import UPS.DataAccess.loginDao1;
/**
 * Servlet implementation class loginServlet1
 */
@WebServlet("/loginServlet1")
public class loginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {  
			
			   UserBean user = new UserBean();    
			   user.setstaffId(request.getParameter("staffId"));   
			   user.setPassword(request.getParameter("password"));  
			   
			   user = loginDao1.login(user); 
			   
			   if (user.isValid() && user.ismanager()) {  
				   
				   		HttpSession session = request.getSession(true);    
				   		session.setAttribute("currentSessionStaff", user); 
				   		response.sendRedirect("home.jsp"); // logged-in page    
			   }  
			   else if (user.isValid() && !user.ismanager()) {
				   
				   		HttpSession session = request.getSession(true);  
				   		session.setAttribute("currentSessionManager", user); 
				   		//execute sql 
				   		response.sendRedirect("homeManager.jsp"); // logged-in page   
			   
			   }
			   else    
				   		response.sendRedirect("loginInvalid.jsp"); // error page  
			   }  
		
			  catch (Throwable theException) {   
				  System.out.println(theException);   
			  } 
	    }
}     