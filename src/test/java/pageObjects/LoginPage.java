package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	@FindBy(xpath="//a[normalize-space()='Continue']") WebElement btnContinue;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']") WebElement btnRegister;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement loginWarning;
	
	
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
	
	public void clickRegister() {
		btnRegister.click();
	}
	
	public WebElement getLoginWaring() {
		return loginWarning;
	}
	
}
