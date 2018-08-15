package pageObjects_OP;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_03_UPC {

	public WebDriver driver1;

	// select the option to navigate inside the the application

	String list_name;

	@FindBy(xpath = "//button[text()='Ok']")
	public WebElement deleteUPCOkayButton;

	@FindBy(xpath = "//div[@class='col-md-2']//button[4]")
	public WebElement deleteUPCButton;

	@FindBy(xpath = "//div[@class='col-md-2']//button[2]")
	public WebElement cloneButton;

	@FindBy(xpath = "//button[text()='Clone']")
	public WebElement cloneButtonExisting;

	@FindBy(xpath = "//a[text()='Manage UPC list']")
	public WebElement manageUPCLisTab;

	// first element in the manage UPC table
	@FindBy(xpath = "//div[@class='ag-body-container']//div[1]//div[1]")
	public WebElement firstUPCManageList;

	@FindBy(xpath = "//a[contains(text(),'Create a New List')]")
	public WebElement createNewUPCButtonOnUPCManagement;

	@FindBy(xpath = "//input[@type='text' and @name='listName']")
	public WebElement createNewUPCName;

	@FindBy(xpath = "//button[text()='Create']")
	public WebElement newUPCCreateButton;

	@FindBy(xpath = "//*[@id='upcsManageApp']/div[3]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[1]/h3")
	// @FindBy(xpath="//h3[@id='upcsManageApp']")
	public WebElement getNewCreatedUPC;

	// instantiate the page factory
	public Page_03_UPC(WebDriver driver) throws Exception {
		this.driver1 = driver;

		PageFactory.initElements(driver1, this);
	}
	// Functions/methods

	public void createNewUPCList() {
		createNewUPCButtonOnUPCManagement.click();

	}

	public String generateRandomUPCNameList() {
		Random rand = new Random();
		int n = rand.nextInt(1000000);
		list_name = ("Testgarima" + n);
		createNewUPCName.sendKeys(list_name);
		return list_name;

	}

	public boolean validateNewCreatedUPCOnManageUPCList(String expectedString) throws Exception {
		String upc_created_manage_list = firstUPCManageList.getText();
		System.out.println("--managelist---------" + upc_created_manage_list);
		System.out.println("--managelist---------" + expectedString);
		
		if (upc_created_manage_list.equalsIgnoreCase(expectedString)) {
			System.out.println("testcase is passed");
			return true;
		} else {
			System.out.println("testcase is failed");
			return false;
		}

	}

	public void createNewUPCListButton() {

		newUPCCreateButton.click();

	}

	public boolean validateUPCCreated(String expectedString) throws Exception {
		Thread.sleep(5000);
		System.out.println("Inside fn_validate_upc_created");
		String UPC_created = getNewCreatedUPC.getText();
		System.out.println("-----created------" + UPC_created);
		System.out.println("----- expected upc string------" + expectedString);
		if (UPC_created.equalsIgnoreCase(expectedString)) {
			System.out.println("testcase is passed");
			return true;
		} else {
			System.out.println("testcase is failed");
			return false;
		}

	}

	public void manageUPCTab() throws Exception {
		manageUPCLisTab.click();
		Thread.sleep(5000);
		System.out.println("Clicked Manage UPC Tab");
	}

	public void selectUPCFromList() {
		firstUPCManageList.click();

	}

	public void buttonClickOnCloneUPC() throws Exception {

		cloneButton.click();
		Thread.sleep(3000);
		cloneButtonExisting.click();
	}

	public void buttonDeleteUPC() throws Exception {

		firstUPCManageList.click();
		Thread.sleep(3000);
		deleteUPCButton.click();
		Thread.sleep(2000);
		deleteUPCOkayButton.click();

	}

	public boolean validateUPCDeleted(String expectedString) throws Exception {

		System.out.println("Inside fn_validate_upc_delete");
		String UPC_list_after_deletion = firstUPCManageList.getText();

		if (!(UPC_list_after_deletion.equalsIgnoreCase(expectedString))) {
			System.out.println("testcase for validation for delete UPC is passed");
			return true;
		} else {
			System.out.println("testcase  for validation for delete UPC is failed");
			return false;
		}
	}

	public boolean validateClonedUPC(String expectedString) throws Exception {

		System.out.println("Inside fn_validate_upc_cloned");
		String UPC_list_cloned = getNewCreatedUPC.getText();

		if ((UPC_list_cloned.equalsIgnoreCase(expectedString))) {
			System.out.println("testcase for valdiation of cloned UPC is passed");
			// System.out.println(UPC_list_cloned);
			// System.out.println(expectedString);
			return true;
		} else {
			System.out.println("testcase  for valdiation of cloned UPC  is failed");
			// System.out.println(UPC_list_cloned);
			// System.out.println(expectedString);
			return false;

		}

	}
}