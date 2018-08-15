package dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StaticProvider {

	@DataProvider(name="test1")
	@Test
	public static Object[][] getLoginData(){
		/*//Object [][] data = new Object [rowCount][colCount];
		//Object [][] data = new Object [2][2];
		Object [][] data = new Object [1][1];
		data [0][0] =  "MuthuKrishnan.Vaithyanathan@catalina.com";
		data [0][1] = "ayAY123";
		
		//data[1][0] = "garima.sharma@catalina.com";
		//data[1][1] = "ayAY123";
		
		return data;*/
		
		return new Object[][]{{ "MuthuKrishnan.Vaithyanathan@catalina.com", "ayAY123" }};
		
		
	
}
}