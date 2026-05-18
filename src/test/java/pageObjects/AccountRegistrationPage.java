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
	@FindBy(xpath="//div[contains(text(),'Password confirmation does not match password!')]") WebElement PasswordConfirmWarning;
	@FindBy(xpath="//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]") WebElement PolicyWarning;
	@FindBy(xpath="//div[contains(text(),'Warning: E-Mail Address is already registered!')]") WebElement UsedEmailWarning;
	
	
	@FindBy(xpath="//a[normalize-space()='Edit Account']") WebElement btnEditAccount;
	
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void clearEmail() {
		txtEmail.clear();;
	}

	
	public void setTelephone(String phone) {
		txtTelephone.sendKeys(phone);
	}

	public void clearTelephone() {
		txtTelephone.clear();
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
	
	public boolean isPrivacyPolicyChecked() {
		return chkPrivacyPolicy.isSelected();
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
	
	public void clickEditAccount() {
		btnEditAccount.click();
	}

	public String getConfirmMessage() {

		try {
			return confMsg.getText();

		} catch (Exception e) {
			return e.getMessage();
		}

	}
	
	//get element's placeholder value
	public String getPlaceHolderValue(WebElement e) {
		return e.getAttribute("placeholder");
	}
	
	//Check if warning is Display with WebElement as parameter
	public boolean isWarningDisplayed(WebElement e) {
		try {
			return e.isDisplayed();
			
		} catch (Exception ex) {
			return false;
		
		}
	}
	
	//fields elements getters
	public WebElement getTelephoneWarning() {
		return TelephoneWarning;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtTelephone() {
		return txtTelephone;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getTxtPasswordConfirm() {
		return txtPasswordConfirm;
	}
	

	//warnings elements getters
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
	
	public WebElement getPasswordConfirmWarning() {
		return PasswordConfirmWarning;
	}

	public WebElement getPolicyWarning() {
		return PolicyWarning;
	}

	public WebElement getUsedEmailWarning() {
		return UsedEmailWarning;
	}


	

}
