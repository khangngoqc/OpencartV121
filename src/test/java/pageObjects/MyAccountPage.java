package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage() {
		super();
	}

	//Header Elements
	@FindBy(xpath = "(//a[@title='My Account'])[1]") WebElement lnkMyAccount;
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]") WebElement lnkRegister;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]") WebElement lnkLogin;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") WebElement lnkLogoutMA;
	
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement maHeading;
	
	@FindBy(xpath = "//a[normalize-space()='Change your password']") WebElement lnkChangePassword;
	
	//right column buttons
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
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btnGrpLogout;

		

	public boolean isMyAccountHeadingExist() {
		try {
			return maHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickChangePassword() {
		lnkChangePassword.click();
	}
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickLogoutMA() {
		lnkLogoutMA.click();
	}
	
	public void clickLogoutBtnGrp() {
		btnGrpLogout.click();
	}
	
	
	
	
	

}
