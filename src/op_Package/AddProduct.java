package op_Package;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects_OP.Page_00_AddRemoveProductFirstPage;

import utility.GeneralMethods;
import utility.base;


public class AddProduct extends base {

	// Declare class or instance variable

	public String Status = "PASS";
	public Integer countofancestry;
	public Integer countofHealth;
	public Integer Sum_Product;
	
	public String countofTotlProduct;
	public String fileNameWithDateTime;

	@Test
	public void addingProducts() throws Exception {

		try {

		
			loginOP();
			Thread.sleep(2000);
			Page_00_AddRemoveProductFirstPage p00 = new Page_00_AddRemoveProductFirstPage(driver);
			p00.addAncestry();
			Thread.sleep(2000);
		    p00.addHealthy();
			Thread.sleep(5000);
			//p00.countTotal();
			 countofancestry= Integer.valueOf(p00.getCountAncestry());
			 countofHealth= Integer.valueOf(p00.getCountHealth());
			  Sum_Product = countofancestry +countofHealth;
			 // System.out.println(Sum_Product);
			  countofTotlProduct = "Total ("+String.valueOf(Sum_Product)+")";

			  
			  //validation sceanrio-Verify the total count with product individaul count
			  
			  SoftAssert Assert = new SoftAssert();
		    Assert.assertTrue(p00.validateCountproduct(countofTotlProduct));
		    Thread.sleep(2000);
		    p00.checkoutButtonOnPage();
		    
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
