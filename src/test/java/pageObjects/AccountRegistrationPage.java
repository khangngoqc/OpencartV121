package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage() {
		super();
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
	@FindBy(xpath="//h1[normalize-space()='Register Account']") WebElement pageHeading;

	//warning locators
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]") WebElement firstNameWarning;
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]") WebElement lastNameWarning;
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]") WebElement EmailWarning;
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]") WebElement TelephoneWarning;
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]") WebElement PasswordWarning;
	@FindBy(xpath="//div[contains(text(),'Password confirmation does not match password!')]") WebElement PasswordConfirmWarning;
	@FindBy(xpath="//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]") WebElement PolicyWarning;
	@FindBy(xpath="//div[contains(text(),'Warning: E-Mail Address is already registered!')]") WebElement UsedEmailWarning;
	
	@FindBy(xpath="//a[normalize-space()='login page']") WebElement lnkLoginPage;
	@FindBy(xpath="//b[normalize-space()='Privacy Policy']") WebElement lnkPrivacyPolicy;
	@FindBy(xpath="//div[@class='modal-conent']h4[normalize-space()='Privacy Policy']") WebElement puPrivacyPolicyHeading;
	
	//right column buttons
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']") WebElement btnLogin;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']") WebElement btnRegister;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Edit Account']") WebElement btnEditAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Forgotten Password']") WebElement btnForgottenPassword;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='My Account']") WebElement btnMyAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Address Book']") WebElement btnAddressBook;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Wish List']") WebElement btnWishList ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Order History']") WebElement btnOrderHistory ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Downloads']") WebElement btnDownloads ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Recurring payments']") WebElement btnRecurringPayments ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Reward Points']") WebElement btnRewardPoints ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Returns']") WebElement btnReturns ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Transactions']") WebElement btnTransactions ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']") WebElement btnNewsletter;
	
	
	@FindBy(xpath = "//a[@class='list-group-item']") List<WebElement> groupItems;
	
	
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
	
	//right column buttons click methods
	public void clickLoginPageLink() {
		lnkLoginPage.click();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

	public void clickRegister() {
		btnRegister.click();
	}
	
	public void clickForgottenPasswod() {
		btnForgottenPassword.click();
	}
	
	public void clickMyAccount() {
		btnMyAccount.click();
	}
	
	public void clickAddressBook() {
		btnAddressBook.click();
	}
	
	public void clickWishList() {
		btnWishList.click();
	}
	
	public void clickOrderHistory() {
		btnOrderHistory.click();
	}
	
	public void clickDownloads() {
		btnDownloads.click();
	}
	
	public void clickRecurringPayments() {
		btnRecurringPayments.click();
	}
	
	public void clickRewardPoints() {
		btnRewardPoints.click();
	}
	
	public void clickReturns() {
		btnReturns.click();
	}
	
	public void clickTransactions() {
		btnTransactions.click();
	}
	
	public void clickNewsletter() {
		btnNewsletter.click();
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
	
	
	public WebElement getPuPrivacyPolicyHeading() {
		return puPrivacyPolicyHeading;
	}
	
	public WebElement getPageHeading() {
		return pageHeading;
	}

	public List<WebElement> getGroupItems() {
		return groupItems;
	}

	


	

}
