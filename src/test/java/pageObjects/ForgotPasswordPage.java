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

	
	public WebElement getPageHeading() {
		return pageHeading;
	}
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
}
