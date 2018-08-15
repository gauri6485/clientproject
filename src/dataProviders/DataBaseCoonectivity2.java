package dataProviders;

import java.sql.Connection;
import java.sql.Statement;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseCoonectivity2 {
	public ResultSet rs;
	public Connection con;
	public Statement stmt;
	public String query ="jj" ;

	public String myAgent;
    
	
	public void dbCoonection() throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://qa-db2.qa.cellfire.com:3306/optimusprime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		//Database Username		
		String username = "qauser";	
        
		//Database Password		
		String password = "q@us3r";				

			
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.cj.jdbc.Driver");			
   
   		//Create Connection to DB		
    	 con = DriverManager.getConnection(dbUrl,username,password);
  
  		System.out.println("connection with db");		
}
	 


	public String getUPC() throws ClassNotFoundException, SQLException {
		this.dbCoonection();
		 //Create Statement Object		
	   Statement stmt = con.createStatement();					
	 //Query to Execute		
	 		String query = "select *  from optimusprime.upclist;";
			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String myName = rs.getString(1);								        
                    String myAge = rs.getString(2);					                               
                    System. out.println(myName+"  "+myAge);		
            }		
			 // closing DB Connection		
			con.close();	
		
		return myAgent;

	}

	public String latestUPC() throws ClassNotFoundException, SQLException {
		String myName = null;
		this.dbCoonection();
		 //Create Statement Object		
	   Statement stmt = con.createStatement();					
	 //Query to Execute		
	 		String query = "select *  from optimusprime.upclist order by created_on desc limit 1;";
			// Execute the SQL Query. Store results in ResultSet		
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		if (rs.first())
		{
	        										        
                     myName = rs.getString(2);					                               
                  //  System. out.println(myName);	
		}
            		
			 // closing DB Connection		
			con.close();	
		
		
		return myName;

	}
}

