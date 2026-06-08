package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage {
	
	public ChangePasswordPage() {
		super();
	}
	
	//Locators
	@FindBy(xpath ="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath ="//input[@id='input-confirm']") WebElement txtPasswordConfirm;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btnLogout;

	
	//get field input value as String
	public String getValueAttribute(WebElement e) {
		return e.getAttribute("value");
	}

	//getters
	public void setPassword(String s) {
		txtPassword.sendKeys(s);
	}

	public void setPasswordConfirm(String s) {
		txtPasswordConfirm.sendKeys(s);
	}

	public void clickContinue() {
		btnContinue.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	


}
