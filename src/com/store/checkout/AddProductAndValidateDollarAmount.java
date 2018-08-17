package com.store.checkout;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.store.pageobjects.Page_00_AddRemoveProductFirstPage;
import com.store.pageobjects.Page_01_OrderSummary;
import com.store.utility.GeneralMethods;
import com.store.utility.base;

public class AddProductAndValidateDollarAmount extends base {

	// Declare class or instance variable

	public String Status = "PASS";
	public Integer countofancestry;
	public Integer countofHealth;
	public Integer Sum_Product;
	public String dollar_total;
	public String countofTotlProduct;
	public String fileNameWithDateTime;

	@Test
	public void addingProducts() throws Exception {

		try {

			// open the browser and launch 23andMe application
			launchApplication();

			Page_00_AddRemoveProductFirstPage p00 = new Page_00_AddRemoveProductFirstPage(driver);
			p00.addAncestry();
			GeneralMethods sy = new GeneralMethods();
			sy.sync();
			p00.addHealthy();
			sy.sync();

			countofancestry = Integer.valueOf(p00.getCountAncestry());
			countofHealth = Integer.valueOf(p00.getCountHealth());
			Sum_Product = countofancestry + countofHealth;
			// System.out.println(Sum_Product);
			countofTotlProduct = "Total (" + String.valueOf(Sum_Product) + ")";

			dollar_total = p00.getDollarValue();
			// validation sceanrio-Verify the total count with product
			// individaul count
			p00.checkoutButtonOnPage();
			sy.sync();
			Page_01_OrderSummary p01 = new Page_01_OrderSummary(driver);
			SoftAssert Assert = new SoftAssert();
			Assert.assertTrue(p01.validateDollarAmonut(dollar_total));
			Thread.sleep(2000);

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
		System.out.println("Test Case Status is --" + Status);

	}

}