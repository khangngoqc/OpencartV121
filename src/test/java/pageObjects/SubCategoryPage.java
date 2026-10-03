package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubCategoryPage extends BasePage {

	public SubCategoryPage() {
		super();
	}

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBanner;
	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	WebElement alertShoppingCartLnk;

	@FindBy(xpath = "//div[@class='caption']//h4")
	List<WebElement> productTitles;
	@FindBy(xpath = "//button//span[normalize-space()='Add to Cart']")
	List<WebElement> addToCartBtns;

	public ProductDisplayPage clickAddToCartByIndex(int index) {
		try {
			if (index < 1 || index > addToCartBtns.size()) {
				System.out.println("Invalid " + index + " | expected: 1 <= index < " + addToCartBtns.size());
				return null;
			}
			click(addToCartBtns.get(index - 1));

			return new ProductDisplayPage();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ShoppingCartPage clickAlertShoppingCartLnk() {

		click(alertShoppingCartLnk);

		return new ShoppingCartPage();
	}

	// validation
	public boolean isAddToCartSuccessAlertDisplay(String productName) {
		return isDisplay(alertBanner)
				&& alertBanner.getText().contains("Success: You have added " + productName + " to your shopping cart!");
	}

	// getter
	public String getProductTitleByIndex(int index) {
		try {
			if (index < 1 || index > productTitles.size()) {
				System.out.println("Invalid " + index + " | expected: 1 <= index < " + addToCartBtns.size());
				return null;
			}
			return getElementText(productTitles.get(index - 1));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
