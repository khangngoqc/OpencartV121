package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

import java.util.Objects;

public class BasePage extends BaseClass{

	Actions act = new Actions(getDriver());

	public BasePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath ="//div[@id='search']") WebElement searchComponent;
	@FindBy(xpath = "//div[@class='row']//ul//a[contains(.,'Site Map')]") WebElement SiteMapLink;
	@FindBy(xpath = "//div[@id='content']//h1") WebElement pageHeading;
	@FindBy(xpath = "//a[normalize-space()='Desktops']") WebElement navBarDesktopMenu;
	@FindBy(xpath = "//a[normalize-space()='Show AllDesktops']") WebElement showAllDesktopsMenuItem;

	public SiteMapPage clickSiteMapLink(){
		SiteMapLink.click();
		return new SiteMapPage();
	}

	public void click(WebElement ele){
		ele.click();
	}



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

		return element.isDisplayed();
	}
	
	public void refreshPage() {
		getDriver().navigate().refresh();
	}
	
	public void backToPreviousPage() {
		getDriver().navigate().back();
	}

	public boolean isSearchComponentDisplay(){

		return isDisplay(searchComponent);
	}

	public boolean isPageHeadingDisplayed(){
		//System.out.println(pageHeading.getText());
		return isDisplay(pageHeading) && pageHeading.getText().contains(getDriver().getTitle());
	}

	public boolean isPageTitleDisplayed(String pageName){
		return getDriver().getTitle().toLowerCase().contains(pageName.toLowerCase());
	}

	public boolean isPageURLDisplayed(String urlKeyword){
		//System.out.println(getDriver().getCurrentUrl());
		return getDriver().getCurrentUrl().contains(urlKeyword.toLowerCase());
	}

	public void hoverNavBarDesktop(){
		act.moveToElement(navBarDesktopMenu).perform();
	}

	public DesktopsPage clickShowAllDesktopFromNavBarDesktopMenu(){
		click(showAllDesktopsMenuItem);
		return new DesktopsPage();
	}



}
