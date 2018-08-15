package dataProviders;

import java.sql.Connection;
import java.sql.Statement;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseCoonectivity {
	public ResultSet rs;
	private Connection con;
	public Statement stmt;
	public String query ;

	public String myAgent;
@Test
	
	public void dbCoonection() throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://qa-db2.qa.cellfire.com:3306/optimusprime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		//Database Username		
		String username = "qauser";	
        
		//Database Password		
		String password = "q@us3r";				

		//Query to Execute		
		String query = "select *  from optimusprime.upclist;";	
        
 	    //Load mysql jdbc driver		
   	    Class.forName("com.mysql.cj.jdbc.Driver");			
   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

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
}
	


	/*public String getUPC() throws ClassNotFoundException, SQLException {
		this.dbCoonection();
		 // Query to Execute
		String query ="select * from  optimusprime.upclist;"; 
		
		 //Create Statement Object 
		 Statement stmt = con.createStatement();
		 
		  // Execute the SQL Query. Store results in ResultSet ResultSet rs =
		 stmt.executeQuery(query);
		 
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myAgent;

	}*/

	// closing DB Connection

}