package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage() 
	{
		super();
	}
	
	
	@FindBy(xpath = "(//a[@title='My Account'])[1]") WebElement lnkMyAccount;
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]") WebElement lnkRegister;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]") WebElement lnkLogin;
	@FindBy(xpath = "(//a[normalize-space()='Logout'])[1]") WebElement lnkLogout;
	
	
	
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
	
	public void clickLogout() {
		lnkLogout.click();
	}

	
	
	//elements getter
	public WebElement getLnkLogout() {
		return lnkLogout;
	}
	
	
	
}
