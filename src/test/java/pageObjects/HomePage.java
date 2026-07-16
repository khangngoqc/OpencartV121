package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage() 
	{
		super();
	}

	private Actions getActions() {
		if (act == null) {
			act = new Actions(getDriver()); // driver is ready by now
		}
		return act;
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
	
	public SearchPage clickSearch() {
		btnSearch.click();
		return new SearchPage();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

	public SearchPage searchWithKeyboard(String keyword) {
		for(int i = 1; i <= 8; i++) {
			getActions().keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		}

		getActions().sendKeys(keyword).perform();
		getActions().sendKeys(Keys.ENTER).perform();

		return new SearchPage();
	}
	
	//elements getter
	public WebElement getLnkLogout() {
		return lnkLogout;
	}
	
	
	
}
