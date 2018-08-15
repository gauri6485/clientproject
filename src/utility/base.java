package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import dataProviders.PropertyFileReader;
import pageObjects_OP.Page_00_AddRemoveProductFirstPage;

public class base {
	public WebDriver driver;
	public PropertyFileReader prop = new PropertyFileReader();;

	@BeforeClass
	public void getBrowser() throws Exception {
		System.out.println("hello..........class-------before getbrowser");
		System.setProperty("webdriver.chrome.driver", prop.getDriverPath());
		System.out.println("hello..........class-------after getbrowser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	public void loginOP() throws Exception {

		// driver.get("https://orlqqa-op.catmktg.com/");
		
		driver.get(prop.getApplicationUrl());
		Thread.sleep(2000);

		
	}

	 /* @AfterTest
	  public void tierDown() throws Exception { 
		  driver.close(); 
		  driver.quit();
		  System.out.println("-----------------------Closed the driver---------------");
		  
	  }*/
	 

}
