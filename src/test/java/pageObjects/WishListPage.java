package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

	@FindBy(xpath = "//div[@id='content']//h2")
	WebElement pageHeading2;
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]/a")
	List<WebElement> productImages;
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]/a")
	List<WebElement> productNames;

	public WishListPage() {
		super();
	}

	// actions
	public ProductDisplayPage clickProductImageByIndex(int index) {

		try {

			if (index <= 0 || index > productImages.size()) {
				System.out.println("Invalid index input! " + index +  " of " + productImages.size());
				return null;
			}

			productImages.get(index - 1).click();

			return new ProductDisplayPage();

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
		}

		return null;

	}
	
	
	public ProductDisplayPage clickProductNameByIndex(int index) {

		try {

			if (index <= 0 || index > productNames.size()) {
				System.out.println("Invalid index input!" + index);
				return null;
			}

			productNames.get(index - 1).click();

			return new ProductDisplayPage();

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
		}

		return null;

	}

	// validations
	public boolean isPageHeadingDisplay() {
		System.out.println(pageHeading2.getText());
		return isDisplay(pageHeading2) && pageHeading2.getText().trim().equals("My Wish List");
	}

	// getters
	public String getProductNameByIndex(int index) {

		try {

			if (index <= 0 || index > productNames.size()) {
				System.out.println("Invalid index input!" + index);
				return null;
			}
			
			System.out.println(productNames.get(index - 1).getText());

			return productNames.get(index - 1).getText();


		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
		}

		return null;
		
	}

}
