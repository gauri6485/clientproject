package com.store.checkout;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.store.pageobjects.Page_00_AddRemoveProductFirstPage;
import com.store.utility.GeneralMethods;
import com.store.utility.base;

public class AddProduct extends base {

	// Declare class or instance variable

	private String Status = "PASS";
	private String countofTotlProduct;
	private String fileNameWithDateTime;
	private Integer countofancestry;
	private Integer countofHealth;
	private Integer Sum_Product;


	@Test
	public void addingProducts() throws Exception {

		try {

			// open the browser and launch 23andMe application 
			launchApplication();
		
			// Instantiate home page -- Page00
			Page_00_AddRemoveProductFirstPage p00 = new Page_00_AddRemoveProductFirstPage(driver);
			
			//
			p00.addAncestry();
			GeneralMethods Synchronize = new GeneralMethods();
			Synchronize.sync();
			
			//
			p00.addHealthy();
			Synchronize.sync();
			
			// get quantity details.
			countofancestry = Integer.valueOf(p00.getCountAncestry());
			countofHealth = Integer.valueOf(p00.getCountHealth());
			
			// Add the product
			Sum_Product = countofancestry + countofHealth;
			
			// System.out.println(Sum_Product);
			countofTotlProduct = "Total (" + String.valueOf(Sum_Product) + ")";

			// Validation scenario-Verify the total count with product individual count

			SoftAssert Assert = new SoftAssert();
			Assert.assertTrue(p00.validateCountproduct(countofTotlProduct));
			Synchronize.sync();
			p00.checkoutButtonOnPage();

		} catch (Exception | AssertionError e) {
			Status = "FAILED";
			System.out.println("Test Status --" + Status);
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
