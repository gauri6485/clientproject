package com.store.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.dataproviders.PropertyFileReader;


public class Page_02_ErrorMessage_OrderSummary {
	
	public WebDriver driver1;
	PropertyFileReader prop = new PropertyFileReader();
	

	

	
	// shipping address
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[2]/div/div[1]/div[1]/label")
	public WebElement orderSummaryInvalidFirstName;
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[2]/div/div[1]/div[2]/label")
	public WebElement orderSummaryInvalidLastName;
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[2]/div/div[3]/label")
	public WebElement orderSummaryInvalidAddress;
	
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[2]/div/div[5]/label")
	public WebElement orderSummaryInvalidCity;
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[2]/div/div[6]/div[2]/div/label")
	public WebElement orderSummaryInvalidZip;
	
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[3]/div[2]/div[1]/label")
	public WebElement orderSummaryInvalidEmail;
	
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[3]/div[2]/div[2]/label/span")
	public WebElement orderSummaryInvalidPhone;
	
	
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[4]/button")
	public WebElement orderSummaryContinueShipping;
	
	// instantiate the page factor
	public Page_02_ErrorMessage_OrderSummary(WebDriver driver) throws Exception {
		this.driver1 = driver;

		PageFactory.initElements(driver1, this);
	}

	public void continueToShipping1(){
		
		orderSummaryContinueShipping.click();
		
	}
	

public boolean validateFirstNameError(String expectedString) throws Exception {
	
	String first_name = orderSummaryInvalidFirstName.getText();
	
		if ((first_name.equalsIgnoreCase(expectedString))) {
			System.out.println("testcase  for valdiation of error message label for  FirstName is passed ");
			 System.out.println(first_name);
			 System.out.println(expectedString);
			return true;
		} else {
			System.out.println("testcase  for valdiation of error message label for  FirstName is failed  ");
			// System.out.println(count_total);
			// System.out.println(expectedString);
			return false;

		}
}
		public boolean validateLasttNameError(String expectedString) throws Exception {
			
			String last_name = orderSummaryInvalidLastName.getText();
			
				if ((last_name.equalsIgnoreCase(expectedString))) {
					System.out.println("testcase  for valdiation of error message label for  LastName is passed ");
					
					return true;
				} else {
					System.out.println("testcase  for valdiation of error message label for  LastName is failed  ");
					
					return false;

				}
		}
				public boolean validateAddressError(String expectedString) throws Exception {
					
					String address_label = orderSummaryInvalidAddress.getText();
					
						if ((address_label.equalsIgnoreCase(expectedString))) {
							System.out.println("testcase  for valdiation of error message label for  Address is passed ");
							
							return true;
						} else {
							System.out.println("testcase  for valdiation of error message label for  Address is failed  ");
							
							return false;

						}
				}
						public boolean validateCityError(String expectedString) throws Exception {
							
							String city_label = orderSummaryInvalidCity.getText();
							
								if ((city_label.equalsIgnoreCase(expectedString))) {
									System.out.println("testcase  for valdiation of error message label for  city is passed ");
									
									return true;
								} else {
									System.out.println("testcase  for valdiation of error message label for  city is failed  ");
									
									return false;

								}
						}
								
								
	public boolean validateZipError(String expectedString) throws Exception {
							
							String zip_label = orderSummaryInvalidZip.getText();
							
								if ((zip_label.equalsIgnoreCase(expectedString))) {
									System.out.println("testcase  for valdiation of error message label for  zip is passed ");
									
									return true;
								} else {
									System.out.println("testcase  for valdiation of error message label for  zip  is failed  ");
									// System.out.println(count_total);
									// System.out.println(expectedString);
									return false;

								}
						}
	
	public boolean validateEmailError(String expectedString) throws Exception {
		
		String email_label = orderSummaryInvalidEmail.getText();
		
			if ((email_label.equalsIgnoreCase(expectedString))) {
				System.out.println("testcase  for valdiation of error message label for  email is passed ");
				
				return true;
			} else {
				System.out.println("testcase  for valdiation of error message label for  email is failed  ");
				
				return false;

			}
	}
	public boolean validatePhoneError(String expectedString) throws Exception {
		
		String phone_label = orderSummaryInvalidPhone.getText();
		
			if ((phone_label.equalsIgnoreCase(expectedString))) {
				System.out.println("testcase  for valdiation of error message label for  phone is passed ");
				
				return true;
			} else {
				System.out.println("testcase  for valdiation of error message label for  phone is failed  ");
			
				return false;

			}
	}
							
								

}
	


