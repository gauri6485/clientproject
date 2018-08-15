package pageObjects_OP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import dataProviders.PropertyFileReader;


public class Page_01_OrderSummary {
	
	public WebDriver driver1;
	PropertyFileReader prop = new PropertyFileReader();
	// login in the application

	//find elements on page -https://store.23andme.com/en-us/checkout/
	@FindBy(xpath = "//*[@class= 'spc-order-total-text']/child::div[2]")
	public WebElement orderSummaryDollarAmount;

	
	// shipping details elements
	@FindBy(xpath = "//*[@id='js-shipping-firstname']")
	public WebElement orderSummaryFirstName;
	
	@FindBy(xpath = "//*[@id='js-shipping-lastname']")
	public WebElement orderSummaryLastName;
	
	@FindBy(xpath = "//*[@id='js-shipping-company']")
	public WebElement orderSummaryCompany;
	
	@FindBy(xpath = "//*[@id='js-shipping-address']")
	public WebElement orderSummaryAddress;
	
	@FindBy(xpath = "//*[@id='js-shipping-address2']")
	public WebElement orderSummaryApartment;
	
	@FindBy(xpath = "//*[@id='js-shipping-city']")
	public WebElement orderSummaryCity;
	
	@FindBy(xpath = "//*[@id='js-shipping-zip']")
	public WebElement orderSummaryZip;
	
	// it is drop down we have to select value
	@FindBy(xpath = "//*[@id='js-shipping-state']")
	public WebElement orderSummarySelectState;

	@FindBy(xpath = "//*[@id='js-shipping-email']")
	public WebElement orderSummaryEmail;
	
	@FindBy(xpath = "//*[@id='js-shipping-phone']")
	public WebElement orderSummaryPhone;
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[3]/div/form/div[4]/button")
	//@FindBy(xpath = "//div[@class='spc-next']/button[@class='spc-next-button mod-ok']")
	public WebElement orderSummaryContinueShipping;
	
	
	@FindBy(xpath = "//*[@id='js-spc']/div/div/div/div[5]/div/form/div[2]/div[2]/div/button")
	//@FindBy(xpath = "//div[@class='spc-next']/button")
	public WebElement orderSummaryContinueBilling;
	
	
	// instantiate the page factory
	public Page_01_OrderSummary(WebDriver driver) throws Exception {
		this.driver1 = driver;

		PageFactory.initElements(driver1, this);
	}

	// methods
	
	// select value from drop down
	public void selectValueDropDown(){
		Select state = new Select (orderSummarySelectState);
		
		state.selectByVisibleText("California");
		//state.selectByIndex(13);
		state.selectByValue("CA");
	}
	
	
	public void enterShippingDetails(){
		orderSummaryFirstName.sendKeys("Garima");
		orderSummaryLastName.sendKeys("Sharma");
		orderSummaryAddress.sendKeys("470 Boynton ave");
		orderSummaryApartment.sendKeys(" APT 24");
		orderSummaryCity.sendKeys("San Jose");
		selectValueDropDown();
		orderSummaryZip.sendKeys("95117-1430");
	}
	
	public void enterContactInfo(){
		orderSummaryEmail.sendKeys("gauri6485@gmail.com");
		orderSummaryPhone.sendKeys("8608165820");
	}
	
	public void continueToShipping(){
		if (orderSummaryContinueShipping.isEnabled())
		{
		orderSummaryContinueShipping.click();
		}
		else
			System.out.println("Continue to shipping button is not enables even after ading shipping info");
	}
	
	public void continueToBilling(){
		orderSummaryContinueBilling.click();
	}
	public boolean validateDollarAmonut(String expectedString) throws Exception {

		
		String total_dollar = orderSummaryDollarAmount.getText();
		System.out.println(total_dollar+"odersummary dollar value");
		
		if ((total_dollar.equalsIgnoreCase(expectedString))) {
			System.out.println("testcase  for valdiation of dollar  amount on firstpage and orcer summary  is passed");
			// System.out.println(count_total);
			// System.out.println(expectedString);
			return true;
		} else {
			System.out.println("testcase  for valdiation of dollar  amount on firstpage and orcer summary  is passed");
			// System.out.println(count_total);
			// System.out.println(expectedString);
			return false;

		}

}
	
	
}
