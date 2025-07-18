package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private DriverFactory driverFactory;
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		
		driverFactory=new DriverFactory();
		driver=driverFactory.getDriver();
	    
	}

	@When("User search for valid product {string} into search box field")
	public void user_search_for_valid_product_into_search_box_field(String validProductText) {
		
		homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProductText);
		
		
	   
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		searchResultsPage=homePage.clickOnSearchButton();
		   
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		
		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		//Assert.fail();
	   
	}

	@When("User search for invalid product {string} into search box field")
	public void user_search_for_invalid_product_into_search_box_field(String invalidProductText) {
		
		homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProductText);
	    
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
	   
		Assert.assertEquals("There is no product that matches the search criteria.", searchResultsPage.getMessageText());
	    
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		
		homePage=new HomePage(driver);
		
	    
	}

}
