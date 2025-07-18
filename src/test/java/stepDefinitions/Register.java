package stepDefinitions;


import java.util.Date;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;
	
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driverFactory=new DriverFactory();
		driver=driverFactory.getDriver();
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=homePage.selectRegisterOption();
		    
	}

	@When("User enters details into below fields")
	public void user_enters_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		commonUtils=new CommonUtils();
		registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephon"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
			 
	}
	
	@When("User enters details into below fields with duplicate email")
	public void user_enters_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephon"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		
		registerPage.selectPrivacyPolicy();
		
	   
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccessPage = registerPage.clickOnContinueButton();
		
	    
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	    
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		registerPage.SelectYesNewsLetterOption();
		    
	}

	@Then("User account should get a proper warning about duplicate email")
	public void user_account_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	    
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
		//Intentionally Kept Blank
	    
	}

	@Then("User should get proper warning message for every mandatory fields")
	public void user_should_get_proper_warning_message_for_every_mandatory_fields() {
		
		
		
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());
		
		  
	}
	
	

}
