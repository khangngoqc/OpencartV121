package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage() 
	{
		super();
	}
	
	@FindBy(xpath="//div[@class='caption']//h4") WebElement productName;
	
	public boolean isSearchProductExist() {

		try {
			return productName.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
}
