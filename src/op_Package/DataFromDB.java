package op_Package;
import dataProviders.DataBaseCoonectivity2;
import org.testng.annotations.Test;
public class DataFromDB {
   
	
	@Test
	
	/*public void testing() throws Exception{
		
		DataBaseCoonectivity2 obj2 = new DataBaseCoonectivity2();
		System.out.println(obj2.getUPC());
	
	}
	*/
	
public void testing() throws Exception{
		
		DataBaseCoonectivity2 obj2 = new DataBaseCoonectivity2();
		System.out.println(obj2.latestUPC());
	
	}
	
}
