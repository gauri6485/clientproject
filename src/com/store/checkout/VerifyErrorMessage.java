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

			// open the browser and launch 23andMe application 
			launchApplication();
			GeneralMethods sy = new GeneralMethods();
			sy.sync();
			Page_00_AddRemoveProductFirstPage p00 = new Page_00_AddRemoveProductFirstPage(driver);
			p00.addAncestry();
			sy.sync();
		    p00.addHealthy();
		    sy.sync();
			p00.checkoutButtonOnPage();
		    sy.sync();
		 // Instantiate home page -- Page02
		    Page_02_ErrorMessage_OrderSummary p02= new Page_02_ErrorMessage_OrderSummary(driver);
		    p02.continueToShipping1();
		    sy.sync();
		    //Get expected error label for below fields
		    String firstName_label = (prop.getFirstNameLabel());
		    String lasttName_label = (prop.getLastNameLabel());
		    String address_label = (prop.getAddressLabel());
		    String city_label = (prop.getCityLabel());
		    String zip_label = (prop.getZipLabel());
		    String email_label = (prop.getEmail());
		    String phone_label = (prop.getPhoneLabel());
		    //Validating the scenario where when user does not enter shipping information 
		    //and clicked on the continue to shipping by mistake then system should give specific error messages
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
			System.out.println(fileName.getCurrentDateTime());
			fileNameWithDateTime = Thread.currentThread().getStackTrace()[1].getMethodName() + "_" + fileName.getCurrentDateTime() + ".png";
			FileUtils.copyFile(screenshotFile,new File(System.getProperty("user.dir") + "\\screenshots\\" + fileNameWithDateTime));

		}
		System.out.println("Test Case Status is  --" + Status);
	}

}
