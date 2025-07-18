 package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searcButton;
	
	
	public void clickOnMyAccount() {
		
	myAccountDropMenu.click();

 }
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	public void enterProductIntoSearchBox(String ProductText) {
		searchBoxField.sendKeys(ProductText);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		searcButton.click();
		return new SearchResultsPage(driver);
	}
	
}