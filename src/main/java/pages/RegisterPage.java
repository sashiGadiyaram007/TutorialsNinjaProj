package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesForNewsLetterOption;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	
	
	
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmail(String emailText) {
		
		emailField.sendKeys(emailText);
		
	}
	
	public void enterTelephone(String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
		
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void selectPrivacyPolicy() {
		
		privacyPolicyCheckBox.click();		
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		
		continueButton.click();
		return new AccountSuccessPage(driver);
		
	}
	
	public void SelectYesNewsLetterOption() {
		yesForNewsLetterOption.click();
	}
	
	public String getWarningMessageText() {
		
		return warningMessage.getText();
		
	}
	
	public String getFirstNameWarning() {
		
		return firstNameWarning.getText();
	}
	
	public String getLastNameWarning() {
		
		return lastNameWarning.getText();
	}
	
	public String getEmailWarning() {
		
		return emailWarning.getText();
	}
	
	public String getTelephoneWarning() {
		
		return telephoneWarning.getText();
	}
	
	public String getPasswordWarning() {
		
		return passwordWarning.getText();
	}


}
