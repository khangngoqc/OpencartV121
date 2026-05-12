package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPrivacyPolicy;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confMsg;

	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]") WebElement firstNameWarning;
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]") WebElement lastNameWarning;
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]") WebElement EmailWarning;
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]") WebElement TelephoneWarning;
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]") WebElement PasswordWarning;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement PolicyWarning;
	
	
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setPasswordConfirm(String pwdc) {
		txtPasswordConfirm.sendKeys(pwdc);
	}

	public void clickPrivacyPolicy() {
		chkPrivacyPolicy.click();
	}

	public void clickContinue() {
		//sol 1
		btnContinue.click();
		
		//sol2
		//btnContinue.submit();
		
		//sol3
		//Actions act = new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
	
		//sol4
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//sol5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//sol6
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
		
	}

	public String getConfirmMessage() {

		try {
			return confMsg.getText();

		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	//Check if warning is Display with WebElement as parameter
	public boolean isWarningDisplayed(WebElement e) {
		try {
			return e.isDisplayed();
			
		} catch (Exception ex) {
			return false;
		
		}
	}

	//getters
	public WebElement getTelephoneWarning() {
		return TelephoneWarning;
	}

	public WebElement getFirstNameWarning() {
		return firstNameWarning;
	}

	public WebElement getLastNameWarning() {
		return lastNameWarning;
	}

	public WebElement getEmailWarning() {
		return EmailWarning;
	}

	public WebElement getPasswordWarning() {
		return PasswordWarning;
	}

	public WebElement getPolicyWarning() {
		return PolicyWarning;
	}


	

}
