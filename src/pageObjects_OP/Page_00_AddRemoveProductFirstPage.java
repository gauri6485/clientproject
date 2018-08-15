package pageObjects_OP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.PropertyFileReader;

public class Page_00_AddRemoveProductFirstPage {

	public WebDriver driver1;
	PropertyFileReader prop = new PropertyFileReader();
	// login in the application

	//find elements on page -https://store.23andme.com/en-us/cart/
	@FindBy(xpath = "//*[@id='button-remove-ancestry-kit']")
	public WebElement productRemoveAncestryButton;

	
	@FindBy(xpath = "//*[@id='button-add-ancestry-kit']")
	public WebElement productAddAncestryButton;
	
	
	@FindBy(xpath = "//*[@id='text-ancestry-kit-count']")
	public WebElement productAncestryButtonCount;
	
	
	
	@FindBy(xpath = "//*[@id='button-remove-health-kit']")
	public WebElement productRemoveHealthButton;

	
	@FindBy(xpath = "//*[@id='button-add-health-kit']")
	public WebElement productAddHealthButton;

	@FindBy(xpath = "//*[@id='text-health-kit-count']")
	public WebElement productHealthButtonCount;
	
	
	@FindBy(xpath = "//*[@id='text_total_products']/strong")
	public WebElement totalButtonCount;
	
	
	@FindBy(xpath = "//*[@id='text_items_total_with_discount']")
	public WebElement dollarValueAmount;
	
	@FindBy(xpath = "//*[@id='ttam-body']/div[1]/div[1]/div[3]/div[6]/div/div[3]/form[1]/input[3]")
	public WebElement checkoutButton;
	
	
	
	// instantiate the page factory
	public Page_00_AddRemoveProductFirstPage(WebDriver driver) throws Exception {
		this.driver1 = driver;

		PageFactory.initElements(driver1, this);
	}

	// methods

	
	// login using data providers
	public void addAncestry() {

		productAddAncestryButton.click();

	}
	public void removeAncestry() {

		productRemoveAncestryButton.click();

	}
	public void addHealthy() {

		productAddHealthButton.click();

	}
	public void removeHealthy() {

		productRemoveHealthButton.click();

	}
	
	/*public void countTotal() {

		String count_total = totalButtonCount.getText();
		System.out.println(count_total);

	}*/
	
	
	public String getCountAncestry() {

		String count_total_ancestry = productAncestryButtonCount.getText();
		//System.out.println(count_total_ancestry);
        return count_total_ancestry;
	}

	
	public String getCountHealth() {

		String count_total_health = productHealthButtonCount.getText();
		//System.out.println(count_total_health);
		return count_total_health;

	}
	
	public String getDollarValue() {

		String count_total_dollar = dollarValueAmount.getText();
		//System.out.println(count_total_dollar);
		return count_total_dollar;

	}
	
	
	public void checkoutButtonOnPage() {
		if (checkoutButton.isEnabled())
		{
		checkoutButton.click();
		}
		else
		{
			System.out.println("checkout button is disabled even when we have product in cart");
		}

	}
	

	public void checkoutButtonOnPageDisabled() {
		if (checkoutButton.isEnabled())
		{
		checkoutButton.click();
		}
		else
		{
			System.out.println("checkout button is disabled  when we have  no product in cart, hence test case is passed");
		}

	}
	
	public boolean validateCountproduct(String expectedString) throws Exception {

		
		String count_total = totalButtonCount.getText();
		
		
		if ((count_total.equalsIgnoreCase(expectedString))) {
			System.out.println("testcase  for valdiation of count of product is passed");
			// System.out.println(count_total);
			// System.out.println(expectedString);
			return true;
		} else {
			System.out.println("testcase  for valdiation of count of product is failed");
			// System.out.println(count_total);
			// System.out.println(expectedString);
			return false;

		}

}
	
	public boolean validateCountproductAfterRemoving(String expectedString) throws Exception {

		
		String count_total = totalButtonCount.getText();
		
		
		if ((count_total.equalsIgnoreCase(expectedString))) {
			System.out.println("testcase  for valdiation of count of product after removing is passed");
			// System.out.println(count_total);
			// System.out.println(expectedString);
			return true;
		} else {
			System.out.println("testcase  for valdiation of count of product afetr removing is failed");
			// System.out.println(count_total);
			// System.out.println(expectedString);
			return false;

		}

}
}
