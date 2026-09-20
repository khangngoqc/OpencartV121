package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage() {
		super();
	}

	@FindBy(xpath = "//form/div/table/tbody/tr/td[1]/a")
	List<WebElement> productImages;
	@FindBy(xpath = "//form/div/table/tbody/tr/td[2]/a")
	List<WebElement> productNames;

	// actions
	public ProductDisplayPage clickProductImageByIndex(int index) {

		try {

			if (index <= 0 || index > productImages.size()) {
				System.out.println("Invalid index input!" + index);
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

		System.out.println("In cart product count: " + productNames.size());

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
