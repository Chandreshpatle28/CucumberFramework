package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef 
{
	public WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		loginPg = new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);

	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
		loginPg.enterEmail(emailadd);
		loginPg.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPg.clickOnLoginButton();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);;
		}

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPg.clickOnLogoutButton();
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}
	
	
	////////ADD NEW CUSTOMERS FEATURES///////////////
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   String actualTitle = addNewCustPg.getPageTitle();
	   String expectedTitle = "Dashboard / nopCommerce administration";
	   
	   if(actualTitle.equals(expectedTitle))
	   {
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertTrue(false);
	   }
	   
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
	    addNewCustPg.clickOnCustomersMenu();
	}

	@When("click on Customers Menu items")
	public void click_on_customers_menu_items() {
	    addNewCustPg.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	    addNewCustPg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	   String actualTitle = addNewCustPg.getPageTitle();
	   String expectedTitle = "Add a new customer / nopCommerce administration";
	   
	   if(actualTitle.equals(expectedTitle))
	   {
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertTrue(false);
	   }
	   
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	   addNewCustPg.enterEmail("test@gmail.com");
	   addNewCustPg.enterPassword("test");
	   addNewCustPg.enterFirstName("Tester");
	   addNewCustPg.enterLastName("Baba");
	   addNewCustPg.enterGender("male");
	   addNewCustPg.enterDob("12/12/1990");
	   addNewCustPg.enterCompanyName("Netflix");
	   addNewCustPg.enterAdminContent("Admin Content");
	   addNewCustPg.enterManagerOfVendor("Vendor 1");
	}

	@When("click on save button")
	public void click_on_save_button() {
	    addNewCustPg.clickOnSave();
	}

	@Then("User can view confrimation message {string}")
	public void user_can_view_confrimation_message(String expectedConfirmationmessage) {
	   
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		
		if(bodyTagText.contains(expectedConfirmationmessage)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}




}
