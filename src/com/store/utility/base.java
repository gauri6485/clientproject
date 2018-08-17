package com.store.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.store.dataproviders.PropertyFileReader;

public class base {
	public WebDriver driver;
	public PropertyFileReader prop = new PropertyFileReader();
	

	@BeforeClass
	public void getBrowser() throws Exception {		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver\\" + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
	}

	public void launchApplication() throws Exception {
		driver.get(prop.getApplicationUrl());
		GeneralMethods wait = new GeneralMethods();
		wait.sync();
	}

	
	  @AfterClass
	  public void tierDown() throws Exception { 
		  driver.close();
		  driver.quit();
		  System.out.println("-----------------------Closed the driver---------------");	  
	 }
}