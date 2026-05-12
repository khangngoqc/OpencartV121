package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "(//a[@title='My Account'])[1]") WebElement lnkMyAccount;
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]") WebElement lnkRegister;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]") WebElement lnkLogin;
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement txtSearch;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']") WebElement btnSearch;
	
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void setSearchInput(String keyword) {
		txtSearch.sendKeys(keyword);
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
}
