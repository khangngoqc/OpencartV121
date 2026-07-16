package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class BasePage extends BaseClass{

	public BasePage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath ="//div[@id='search']") WebElement searchComponent;
	@FindBy(xpath = "//div[@class='row']//ul//a[contains(.,'Site Map')]") WebElement SiteMapLink;

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



}
