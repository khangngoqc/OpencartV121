package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement maHeading;
	
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath = "(//a[@title='My Account'])[1]") WebElement lnkMyAccount;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]") WebElement lnkLogin;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	@FindBy(xpath = "//a[normalize-space()='Change your password']") WebElement lnkChangePassword;
	
	

	public boolean isMyAccountHeadingExist() {
		try {
			return maHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickLogout() {
		lnkLogout.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}

	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
}
