package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
	
	public ForgotPasswordPage() {
		super();
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']") WebElement pageHeading;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmailAddress;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alertBanner;

	
	public WebElement getPageHeading() {
		return pageHeading;
	}
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void clickContinue() {
		btnContinue.click();
	}


	//getter
	public WebElement getAlertBanner() {
		return alertBanner;
	}

	
}
