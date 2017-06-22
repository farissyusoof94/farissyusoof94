package UPS.DataAccess;


import java.sql.*; 

import UPS.Bean.customerBean;
public class createCustomerDao { 
static Connection currentCon = null; 
static ResultSet rs = null; 

public static customerBean insert(customerBean cust) { 
// preparing some objects for connection 
System.out.println("STARTING");
Statement stmt = null; 


String custid = cust.getcustid();
String custname = cust.getcustname();
String custaddress = cust.getcustaddress();
String custphoneno = cust.getcustphoneno();
String custemail = cust.getcustemail();
//String staffId = cust.getstaffId();





String insertOwner = "INSERT INTO CUSTOMER (customerid, customername, customeraddress, customerphoneno, customeremail)" //, staffid) "
		           + "values ('"+custid+"','"+custname+"','"+custaddress+"','"+custphoneno+"','"+custemail+"')"; //, '"+staffId+"')";
 

System.out.println("Query: " + insertOwner);
try { 
// connect to DB 
currentCon = ConnectionManager.getConnection(); 
stmt = currentCon.createStatement(); 
rs = stmt.executeQuery(insertOwner ); 
boolean more = rs.next(); 

// if user does not exist set the isValid variable to false 

if (!more) 
{ 
	System.out.println("Sorry, you have entered invalid value"); 
    cust.setValid(false); 
} 
// if user exists set the isValid variable to true 

else if (more) {

	cust.setValid(true); 
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
		} 
	catch (Exception e) { } rs = null; 
	}
if (stmt != null) { 
		try { stmt.close(); 
		} 
		catch (Exception e) { 
			
		} stmt = null; 
		} 
if (currentCon != null) { 
	try { 
		currentCon.close(); 
		} catch (Exception e) { 
			
		}currentCon = null; 
		} 
} return cust; 
}
}