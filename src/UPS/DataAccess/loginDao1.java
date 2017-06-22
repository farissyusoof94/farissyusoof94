package UPS.DataAccess;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import UPS.Bean.UserBean;

public class loginDao1 {
	 static Connection currentCon = null;     
	 static ResultSet rs = null;  
	 
	    public static UserBean login(UserBean bean) { 
	    	
	        // preparing some objects for connection  
	    	
	    	System.out.println("FIRST");        
	    	Statement stmt = null;  
	        String staffId = bean.getstaffId();         
	        String password = bean.getPassword();  
	        String searchQuery = "select * from staff where staffid ='"+staffId+"' AND password='"+password+"'"; 
	        
	        // "System.out.println" prints in the console; Normally used to trace the process        
	        
	        System.out.println("Your user name is " + staffId);        
	        System.out.println("Your password is " + password);        
	        System.out.println("Query: " + searchQuery);  
	        try {             
	        	
	        	// connect to DB 
	        	
	        	currentCon = ConnectionManager.getConnection();     
	        	stmt = currentCon.createStatement();          
	        	rs = stmt.executeQuery(searchQuery);           
	        	boolean more = rs.next();  
	        	
	          
	        	
	            // if user exists set the isValid variable to true
	        	
	         if (more && !password.equals("staff1")) {               
	        		     
	        			String staffid = rs.getString("staffid");
	        			String Password = rs.getString("password");
	        			String role = rs.getString("role");
	        		
	        			System.out.println("Welcome" + role);
	        		
	        			bean.setstaffId(staffId);
	        			bean.setPassword(password);
	        			bean.setRole(role);
	        			bean.setValid(true); 
	                      
	            }        
	        	
	        	else if (more && password.equals("staff1")) {
	        		
	        			String staffid = rs.getString("staffid");
	        			String Password = rs.getString("password");
	        			String role = rs.getString("role");
	        			
	        			System.out.println("Welcome" + role);
		        		
	        			bean.setstaffId(staffId);
	        			bean.setPassword(Password);
	        			bean.setRole(role);
	        			
	        			bean.setValid(true); 
	        			bean.setmanager(true);
	        	}
	        
  // if user does not exist set the isValid variable to false  
	        	
	        	else  {                
	        			System.out.println("Sorry, you are not a registered user!"); 
	        			bean.setValid(false); 
	        			bean.setmanager(false); 
	        	}  
	        }  
	        
	        catch (Exception ex) {  
	        	
	        		System.out.println("Log In failed: An Exception has occurred! " + ex);       
	        	
	        }  
	        
	        // some exception handling  
	        
	        finally {     
	        	
	        	if (rs != null) {   
	        		
	        		try {  
	        			
	        			rs.close(); 
	        			
	        		} catch (Exception e) {              
	        				
	        		}             
	        		rs = null;       
	        		}  
	            if (stmt != null) {           
	            	try {                  
	            		stmt.close();             
	            		} catch (Exception e) {               
	            			
	            		}              
	            	stmt = null;           
	            	}  
	            if (currentCon != null) {      
	            	try {                    
	            		currentCon.close();              
	            		} catch (Exception e) {        
	            			
	            		}  
	                currentCon = null;       
	                }      
	            }  
	        return bean;  
	    } 
}

