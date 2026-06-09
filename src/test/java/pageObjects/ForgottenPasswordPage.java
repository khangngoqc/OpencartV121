package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage extends BasePage{
	
	public ForgottenPasswordPage() {
		super();
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")WebElement pageHeading;

	public WebElement getPageHeading() {
		return pageHeading;
	}
	
	
}
