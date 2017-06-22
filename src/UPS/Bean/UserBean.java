package UPS.Bean;

public class UserBean {
	private String staffId;      
	private String password;  
	private String role;
     public boolean valid;   
     public boolean manager;

     public String getPassword() 
     {     
    	 return password; 
     }  
     public void setPassword(String newPassword) 
     {    
    	 password = newPassword; 
     }            
     public String getstaffId() 
     {  
    	 return staffId;  
     }  
     public void setstaffId(String newstaffId) 
     { 
    	 staffId = newstaffId;    
     }  
     public String getRole() 
     {  
    	 return role;  
     }  
     public void setRole(String newRole) 
     { 
    	 role = newRole;    
     }  
     public boolean isValid() 
     {     
        	  return valid;  
     }  
     public void setValid(boolean newValid) 
     {       
    	 valid = newValid; 
     }
	public void setmanager(boolean newmanager) {
		manager = newmanager;
	}
	public boolean ismanager() {
		return manager;
	} 
} 