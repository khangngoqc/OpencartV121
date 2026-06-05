package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}


	//header elements
	@FindBy(xpath = "(//a[@title='My Account'])[1]") WebElement lnkMyAccount;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement lnkLoginMA;
	
	
	@FindBy(xpath = "//h1[normalize-space()='Account Logout']") WebElement lgHeading;
	
	
	@FindBy(xpath = "//a[normalize-space()='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//a[normalize-space()='Change your password']") WebElement lnkChangePassword;
	
	
	

	public boolean isAccountLogoutHeadingExist() {
		try {
			return lgHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickLogin() {
		lnkLoginMA.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
	}

	public WebElement getLnkLoginMA() {
		return lnkLoginMA;
	}
	
	
	

	
}
