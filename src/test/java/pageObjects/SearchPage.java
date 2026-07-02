package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage() {
		super();
	}

	@FindBy(xpath = "//div[@class='caption']//h4")
	WebElement productTitle;
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement resultMessage;

	public boolean isSearchProductExist(String productName) {

		try {
				return (productTitle.isDisplayed() && productTitle.getText().contains(productName));
				
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public boolean isResultMessageDiplayed() {
		return isDisplay(resultMessage);
	}

}
