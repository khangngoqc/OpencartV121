package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class BasePage extends BaseClass {

	Actions act = new Actions(getDriver());

	public BasePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "(//a[@title='My Account'])[1]")
	WebElement lnkMyAccount;
	@FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
	WebElement lnkRegister;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
	WebElement lnkLogin;
	@FindBy(xpath = "//a[@id='wishlist-total']")
	WebElement WishListLnk;
	@FindBy(xpath = "//a[@title='Shopping Cart']")
	WebElement shoppingCartLnk;
	@FindBy(xpath = "//a[@title='Checkout']")
	WebElement checkoutLnk;

	@FindBy(xpath = "//div[@id='cart']//button[@data-toggle='dropdown']")
	WebElement cartBtn;
	@FindBy(xpath = "//span[@id='cart-total']")
	WebElement cartTotalTxt;
	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']//td[2]//a")
	List<WebElement> cartProductNames;
	@FindBy(xpath = "(//button[@title='Remove'])")
	List<WebElement> removeBtns;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTxtBox;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@id='search']")
	WebElement searchComponent;
	@FindBy(xpath = "//div[@class='row']//ul//a[contains(.,'Site Map')]")
	WebElement SiteMapLink;
	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement pageHeading;
	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	WebElement navBarDesktopMenu;
	@FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
	WebElement showAllDesktopsMenuItem;

	// actions
	public void clickMyAccount() {
		click(lnkMyAccount);
	}

	public void clickRegister() {
		click(lnkRegister);
	}

	public LoginPage clickLogin() {
		click(lnkLogin);

		return new LoginPage();
	}

	public WishListPage clickWishListLnk() {
		click(WishListLnk);

		return new WishListPage();
	}

	public ShoppingCartPage clickShoppingCartLnk() {
		click(shoppingCartLnk);

		return new ShoppingCartPage();
	}

	public CheckoutPage clickCheckoutLnk() {
		click(checkoutLnk);

		return new CheckoutPage();
	}

	public void clickSearch() {
		searchBtn.click();
	}

	public SearchPage searchAProduct(String keyword) {

		setSearchInput(keyword);
		clickSearch();

		return new SearchPage();
	}

	public SiteMapPage clickSiteMapLink() {
		SiteMapLink.click();
		return new SiteMapPage();
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public void input(WebElement ele, String string) {
		ele.sendKeys(string);
	}

	public void clearInput(WebElement ele) {
		ele.clear();
	}

	public void setSearchInput(String keyword) {
		searchTxtBox.clear();
		searchTxtBox.sendKeys(keyword);
	}

	public SearchPage clickSearchBtn() {
		click(searchBtn);
		return new SearchPage();
	}

	public void clickCartBtn() {
		click(cartBtn);
	}

	public boolean findInDOM(String string) {
		return getDriver().getPageSource().toLowerCase().contains(string.toLowerCase());
	};

	public void clearCart() {
		try {
			for(WebElement btn : removeBtns) {
				click(cartBtn);
				click(btn);
			}

		} catch (Exception e) {
			System.out.println("Out of product to remove!");
			return;
		}
	}

	// getters
	public String getPageTitle() {
		return getDriver().getTitle();
	}

	public String getElementText(WebElement e) {
		return e.getText();
	}

	public String getPlaceholderValue(WebElement e) {
		return e.getAttribute("placeholder");
	}

	public boolean isDisplay(WebElement element) {

		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void refreshPage() {
		getDriver().navigate().refresh();
	}

	public void backToPreviousPage() {
		getDriver().navigate().back();
	}

	// validations
	public boolean isSearchComponentDisplay() {

		return isDisplay(searchComponent);
	}

	public boolean isPageHeadingDisplayed() {
		// System.out.println(pageHeading.getText());
		return isDisplay(pageHeading) && pageHeading.getText().contains(getDriver().getTitle());
	}

	public boolean isPageTitleDisplayed(String pageName) {
		System.out.println(getDriver().getTitle());
		return getDriver().getTitle().toLowerCase().contains(pageName.toLowerCase());
	}

	public boolean isPageURLDisplayed(String urlKeyword) {
		// System.out.println(getDriver().getCurrentUrl());
		return getDriver().getCurrentUrl().contains(urlKeyword.toLowerCase());
	}

	public void hoverNavBarDesktop() {
		act.moveToElement(navBarDesktopMenu).perform();
	}

	public DesktopsPage clickShowAllDesktopFromNavBarDesktopMenu() {
		click(showAllDesktopsMenuItem);
		return new DesktopsPage();
	}

	// getter
	public String getCartTotalText() {

		return cartTotalTxt.getText();
	}

	public int getAddedProductTotal() {
		String[] part = getCartTotalText().split(" item\\(s\\) - ");
		String total = part[0].trim();

		// debug output
		System.out.println("total: " + total);

		return Integer.parseInt(total);
	}

}
