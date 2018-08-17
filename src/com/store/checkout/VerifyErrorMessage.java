package com.store.checkout;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.store.dataproviders.PropertyFileReader;
import com.store.pageobjects.Page_00_AddRemoveProductFirstPage;
import com.store.pageobjects.Page_02_ErrorMessage_OrderSummary;
import com.store.utility.GeneralMethods;
import com.store.utility.base;

public class VerifyErrorMessage extends base {

	// Declare class or instance variable

	public String Status = "PASS";
	public Integer countofancestry;
	public Integer countofHealth;
	public Integer Sum_Product;	
	public String countofTotlProduct;
	public String fileNameWithDateTime;
	public PropertyFileReader prop = new PropertyFileReader();
	
	@Test
	public void addingProducts() throws Exception {

		try {

		
			launchApplication();
			Thread.sleep(2000);
			Page_00_AddRemoveProductFirstPage p00 = new Page_00_AddRemoveProductFirstPage(driver);
			p00.addAncestry();
			Thread.sleep(2000);
		    p00.addHealthy();
		    GeneralMethods sy = new GeneralMethods();
			sy.sync();
			//p00.countTotal();
			 
		    p00.checkoutButtonOnPage();
		    sy.sync();
		    Page_02_ErrorMessage_OrderSummary p02= new Page_02_ErrorMessage_OrderSummary(driver);
		   //p01.enterShippingDetails();
		    //p01.enterContactInfo();
		    p02.continueToShipping1();
		    sy.sync();
		    
		   
		    String firstName_label = (prop.getFirstNameLabel());
		    String lasttName_label = (prop.getLastNameLabel());
		    String address_label = (prop.getAddressLabel());
		    String city_label = (prop.getCityLabel());
		    String zip_label = (prop.getZipLabel());
		    String email_label = (prop.getEmail());
		    String phone_label = (prop.getPhoneLabel());
		    
		    SoftAssert Assert = new SoftAssert();
		    Assert.assertTrue(p02.validateFirstNameError(firstName_label));
		    Assert.assertTrue(p02.validateLasttNameError(lasttName_label));
		    Assert.assertTrue(p02.validateAddressError(address_label));
		    Assert.assertTrue(p02.validateCityError(city_label));
		    Assert.assertTrue(p02.validateZipError(zip_label));
		    Assert.assertTrue(p02.validateEmailError(email_label));
		    Assert.assertTrue(p02.validatePhoneError(phone_label));
		    
		} catch (Exception | AssertionError e) {
			Status = "FAILED";
			System.out.println("Test Status --" + Status);
			System.out.println("Catched Exception strack trace" + e.getStackTrace());
			System.out.println("Catched Exception strack trace" + e.getMessage());

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			GeneralMethods fileName = new GeneralMethods();
			//System.out.println(fileName.getCurrentDateTime());
			fileNameWithDateTime = "addproduct" + "_" + fileName.getCurrentDateTime() + ".png";
			FileUtils.copyFile(screenshotFile, new File("C:\\selenium_failedscreenshots\\" + fileNameWithDateTime));

			 FileUtils.copyFile(screenshotFile, new
			 File("C:\\SoftwareTestingMaterial.png"));
		}
		System.out.println("Test Case Status is  --" + Status);
	}

}
