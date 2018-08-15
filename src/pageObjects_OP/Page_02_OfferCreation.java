package pageObjects_OP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_02_OfferCreation {

	public WebDriver driver1;

	// select the option to navigate inside the the application

	// instantiate the page factory
	public Page_02_OfferCreation(WebDriver driver) throws Exception {
		this.driver1 = driver;

		PageFactory.initElements(driver1, this);
	}
	// Functions/methods

}
