package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
	
	@FindBy(xpath = "//div[@id='content']//h2") WebElement pageHeading2;
	
	public WishListPage() {
		super();
	}
	
	public boolean isPageHeadingDisplay() {
		System.out.println(pageHeading2.getText());
		return isDisplay(pageHeading2) && pageHeading2.getText().trim().equals("My Wish List");
	}

}
