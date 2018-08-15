/*
 * package op_Package; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.testng.annotations.BeforeTest; import org.testng.annotations.Test; import
 * pageObjects_OP.Page_00_loginpage; import pageObjects_OP.Page_01_homepage;
 * import pageObjects_OP.Page_03_UPC;
 * 
 * public class Open_chrome_browser {
 * 
 * // class variables public WebDriver driver;
 * 
 * @BeforeTest public void open_browser() throws InterruptedException {
 * System.setProperty("webdriver.chrome.driver", "C://apps//chromedriver.exe");
 * //System.out.println("I am garima"); driver = new ChromeDriver();
 * 
 * // open gmail driver.get("https://orlqqa-op.catmktg.com/");
 * Thread.sleep(2000);
 * 
 * 
 * }
 * 
 * @Test public void Test_1_Login() throws Exception{ Page_00_loginpage p00 =
 * new Page_00_loginpage(driver);
 * 
 * p00.fn_email();
 * 
 * p00.fn_password(); p00.fn_loginbutton();
 * 
 * }
 * 
 * @Test public void Test_2_Offer_creation() throws Exception{ Page_01_homepage
 * p01 = new Page_01_homepage(driver); p01.fn_offer_creation();
 * p01.fn_new_offer();
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * }
 * 
 */