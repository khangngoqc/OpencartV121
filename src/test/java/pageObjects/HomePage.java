package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage() {
		super();
	}

	private Actions getActions() {
		if (act == null) {
			act = new Actions(getDriver()); // driver is ready by now
		}
		return act;
	}

	@FindBy(xpath = "(//a[@title='My Account'])[1]")
	WebElement lnkMyAccount;
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
	WebElement lnkRegister;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
	WebElement lnkLogin;
	@FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
	WebElement lnkLogout;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBanner;
	@FindBy(xpath = "//a[normalize-space()='product comparison']")
	WebElement alerProductComparisonLink;

	@FindBy(xpath = "(//div[@class='product-thumb transition']//h4//a)[1]")
	WebElement firstProductTitle;

	@FindBy(xpath = "(//button[@data-original-title='Compare this Product'])[1]")
	WebElement compareThisProductBtn;
	@FindBy(xpath = "//div[@role='tooltip' and contains(., 'Compare')]")
	WebElement hoveringTooltip;

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

	public SearchPage searchWithKeyboard(String keyword) throws InterruptedException {
		for (int i = 1; i <= 8; i++) {
			getActions().keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		}

		getActions().sendKeys(keyword).perform();
		getActions().keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		getActions().keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

		Thread.sleep(2000);

		return new SearchPage();
	}
	
	public ProductComparePage clickAlertProductComparisonProductLink() {
		click(alerProductComparisonLink);
		return new ProductComparePage();
	}
	
	public void clickCompareThisProductBtn() {
		click(compareThisProductBtn);
	}

	// validations
	public boolean isCompareThisProductBtnTooltipWork() throws InterruptedException {
		return isHoveringTooltipWork(compareThisProductBtn, "Compare this Product");
	}

	public boolean isHoveringTooltipWork(WebElement e, String text) throws InterruptedException {
		((JavascriptExecutor) getDriver())
				.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", e);

		Thread.sleep(500);

		act.moveToElement(e).pause(java.time.Duration.ofMillis(500)).perform();

		if (!hoveringTooltip.isDisplayed()) {
			return false;
		}

		if (!hoveringTooltip.getText().equals(text)) {
			System.out.println(hoveringTooltip.getText());
			return false;
		}

		return true;
	}

	public boolean isCompareThisProductAlertDisplayed(String productName) {
		String successMessage = alertBanner.getText();

		if (!successMessage.contains("Success: You have added " + productName + " to your product comparison!")) {
			return false;
		}

		return true;
	}
	
	public boolean isCompareThisProductAlertDisplayed_FirstProduct() {
		String successMessage = alertBanner.getText();

		if (!successMessage
				.contains("Success: You have added " + getFirstProductTitle() + " to your product comparison!")) {
			return false;
		}

		return true;
	}

	// elements getter
	public WebElement getLnkLogout() {
		return lnkLogout;
	}
	
	public String getFirstProductTitle() {
		return firstProductTitle.getText();
	}

}
