package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage() {
		super();
	}
	
	//Header Elements
	@FindBy(xpath = "(//a[@title='My Account'])[1]") WebElement lnkMyAccount;
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]") WebElement lnkRegister;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]") WebElement lnkLogin;
	
	@FindBy(xpath = "//h2[normalize-space()='New Customer']") WebElement headingNewCustomer;
	@FindBy(xpath = "//h2[normalize-space()='Returning Customer']") WebElement headingReturningCustomer;
	

	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement btnContinue;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement loginWarning;
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']") WebElement lnkForgottenPassword;
	
	//right column buttons
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']") WebElement btnGrpLogin;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']") WebElement btnGrpRegister;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Edit Account']") WebElement btnGrpEditAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Forgotten Password']") WebElement btnGrpForgottenPassword;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='My Account']") WebElement btnGrpMyAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Address Book']") WebElement btnGrpAddressBook;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Wish List']") WebElement btnGrpWishList ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Order History']") WebElement btnGrpOrderHistory ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Downloads']") WebElement btnGrpDownloads ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Recurring payments']") WebElement btnGrpRecurringPayments ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Reward Points']") WebElement btnGrpRewardPoints ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Returns']") WebElement btnGrpReturns ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Transactions']") WebElement btnGrpTransactions ;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']") WebElement btnGrpNewsletter;
	
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickContine() {
		btnContinue.click();
	}
	
	public void clickLoginBtnGrp() {
		btnGrpLogin.click();
	}
	
	public void clickRegisterBtnGrp() {
		btnGrpRegister.click();
	}
	
	public void clickBtnGrpForgottenPassword() {
		btnGrpForgottenPassword.click();
	}
	
	public void clickForgottenPassword() {
		lnkForgottenPassword.click();
	}
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegisterMA() {
		lnkRegister.click();
	}
	
	public void clickLoginMA() {
		lnkLogin.click();
	}
	
	
	//getter
	public WebElement getLoginWaring() {
		return loginWarning;
	}

	public WebElement getLnkForgottenPassword() {
		return lnkForgottenPassword;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}
	
	public WebElement getHeadingNewCustomer() {
		return headingNewCustomer;
	}

	public WebElement getHeadingReturningCustomer() {
		return headingReturningCustomer;
	}
	
	
	
	
	
	
	
	
}
