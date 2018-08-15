package op_Package;
import utility.base;

import org.testng.annotations.Test;

import dataProviders.PropertyFileReader;
import dataProviders.StaticProvider;
import pageObjects_OP.Page_00_AddRemoveProductFirstPage;
public class LoginOptimusDataFromDataProviders extends base {
	
	PropertyFileReader prop = new PropertyFileReader();
	
	@Test (dataProvider="test1", dataProviderClass = StaticProvider.class)
    // Number of columns should match the number of input parameters
	
 public void loginTest(String Uid, String Pwd) throws Exception{
			// This method takes data as input parameters. The attribute dataprovider is mapped to "getData"
	 
	 System.out.println("UserName is "+ Uid);
	 System.out.println("Password is "+ Pwd);
	 driver.get("https://orlqqa-op.catmktg.com/");
		driver.get(prop.getApplicationUrl());
		Thread.sleep(2000);
			  
			  // Step-3: Login

		
		 Page_00_AddRemoveProductFirstPage p00 = new Page_00_AddRemoveProductFirstPage(driver); 
		 /* p00.enterEmail1(Uid);
		  p00.enterPassword1(Pwd); 
		  p00.loginButtonOptimusPrime(); */     
	 
		  }
	
	/*public void loginTest() throws Throwable{
		
		
		
	}*/
	
	}
	
	



