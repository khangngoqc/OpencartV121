package pageObjects;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

	@FindBy(xpath = "//ul[@class='breadcrumb']//li//a")
	List<WebElement> breadcrumbLinks;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBanner;
	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	WebElement alertShoppingCartLnk;

	@FindBy(xpath = "//div[@id='content']//h2")
	WebElement pageHeading2;
	@FindBy(xpath = "//p[normalize-space()='Your wish list is empty.']")
	WebElement emptyStateText;
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]/a")
	List<WebElement> productImages;
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]/a")
	List<WebElement> productNames;
	@FindBy(xpath = "//*[@id=\"content\"]/div/table/tbody/tr/td[3]")
	List<WebElement> productModels;
	@FindBy(xpath = "//*[@id=\"content\"]/div/table/tbody/tr/td[4]")
	List<WebElement> productStocks;
	@FindBy(xpath = "//*[@id=\"content\"]/div/table/tbody/tr/td[5]")
	List<WebElement> productUnitPrices;
	@FindBy(xpath = "//a[@data-original-title='Remove']")
	List<WebElement> removeFromWishListBtns;

	public WishListPage() {
		super();
	}

	// actions
	public ProductDisplayPage clickProductImageByIndex(int index) {

		try {

			if (index <= 0 || index > productImages.size()) {
				System.out.println("Invalid index input! " + index + " of " + productImages.size());
				return null;
			}

			productImages.get(index - 1).click();

			return new ProductDisplayPage();

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
		}

		return null;

	}
	
	public void removeProducByIndex(int index) {

		try {

			if (index <= 0 || index > removeFromWishListBtns.size()) {
				System.out.println("Invalid index input! " + index + " of " + removeFromWishListBtns.size());
				return;
			}

			click(removeFromWishListBtns.get(index - 1));


		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
		}

		return;

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

	public void clickAddToCartOf(String productName) {
		WebElement addToCartBtn = getDriver().findElement(
				By.xpath("//tr[contains(.,'" + productName + "')]//button[@data-original-title='Add to Cart']"));
		click(addToCartBtn);
	}

	public ShoppingCartPage clickAlertShoppingCartLnk() {
		click(alertShoppingCartLnk);

		return new ShoppingCartPage();
	}

	public void clearWishList() {
		try {
			for (WebElement btn : removeFromWishListBtns) {
				Thread.sleep(500);
				getDriver().findElement(By.xpath("(//a[@data-original-title='Remove'])[1]")).click();
			}

		} catch (Exception e) {
			System.out.println("Out of product to remove!");
			return;
		}
	}

	public MyAccountPage clickContinueBtn() {

		click(continueBtn);

		return new MyAccountPage();
	}

	// validations
	public boolean isPageHeadingDisplay() {
		System.out.println(pageHeading2.getText());
		return isDisplay(pageHeading2) && pageHeading2.getText().trim().equals("My Wish List");
	}

	public boolean isAddToCartSuccessAlertDisplay(String productName) {
		return isDisplay(alertBanner)
				&& alertBanner.getText().contains("Success: You have added " + productName + " to your shopping cart!");
	}

	public boolean isProductAdded(String productName) {

		try {
			for (WebElement e : productNames) {
				if (e.getText().contains(productName)) {
					return true;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean isBreadcrumbWork() throws InterruptedException {

		for (int i = 0; i < breadcrumbLinks.size(); i++) {

			System.out.println(breadcrumbLinks.get(i).getText());

			if (!breadcrumbLinks.get(i).isDisplayed()) {
				return false;

			} else if (i == 0) {
				click(breadcrumbLinks.get(i));
				if (!Objects.requireNonNull(getDriver().getCurrentUrl()).contains("home")) {

					System.out.println(getDriver().getCurrentUrl());

					return false;
				}
				Thread.sleep(2000);

				getDriver().navigate().back();

			} else if (i == (breadcrumbLinks.size() - 1)) {
				click(breadcrumbLinks.get(i));
				if (!Objects.requireNonNull(getDriver().getCurrentUrl().contains("wishlist"))) {

					System.out.println(Objects.requireNonNull(getDriver().getCurrentUrl()));
					System.out.println(breadcrumbLinks.get(i).getText().toLowerCase());
					System.out.println(getDriver().getCurrentUrl());
					System.out.println("Account check: " + !Objects.requireNonNull(getDriver().getCurrentUrl())
							.contains(breadcrumbLinks.get(i).getText().toLowerCase()));
					System.out.println("Wishlist check: "
							+ !Objects.requireNonNull(getDriver().getCurrentUrl()).contains("wishlist"));

					return false;
				}

				Thread.sleep(2000);

				getDriver().navigate().back();

			} else {
				click(breadcrumbLinks.get(i));
				if (!Objects.requireNonNull(
						getDriver().getCurrentUrl().contains(breadcrumbLinks.get(i).getText().toLowerCase()))) {

					System.out.println(Objects.requireNonNull(getDriver().getCurrentUrl()));
					System.out.println(breadcrumbLinks.get(i).getText().toLowerCase());
					System.out.println(getDriver().getCurrentUrl());
					System.out.println("Account check: " + !Objects.requireNonNull(getDriver().getCurrentUrl())
							.contains(breadcrumbLinks.get(i).getText().toLowerCase()));
					System.out.println("Wishlist check: "
							+ !Objects.requireNonNull(getDriver().getCurrentUrl()).contains("wishlist"));

					return false;
				}
				Thread.sleep(2000);

				getDriver().navigate().back();

			}
		}

		return true;
	}

	public boolean isEmptyWishListTextDisplay() {
		return isDisplay(emptyStateText);
	}

	public boolean isWishListedProductDisplayed(int index, String id, String name, String model, String stock,
			String uprice) {

		String productImage = getProductImageLinkByIndex(index);
		String productName = getProductNameByIndex(index);
		String productModel = getProductModelByIndex(index);
		String productUnitPrice = getProductUnitPriceByIndex(index);

		boolean isCorrectImage = productImage.contains(id);
		boolean isCorrectName = productName.contains(name);
		boolean isCorrectModel = productModel.contains(model);
		boolean isCorrectUnitPrice = productUnitPrice.contains(uprice);

		if (isCorrectImage) {
			if (isCorrectName) {
				if (isCorrectModel) {
					if (isCorrectUnitPrice) {
						return true;
					} else {
						System.out.println("Incorrect unit price.");
						return false;
					}
				} else {
					System.out.println("Incorrect stock status.");
					return false;
				}
			} else {
				System.out.println("Incorrect name.");
				return false;
			}
		} else {
			System.out.println("Incorrect image.");
			return false;
		}

	}
	
	public boolean isModifySuccessAlertBannerDisplay(){
		
		boolean modifySuccessMessage = alertBanner.getText().contains("Success: You have modified your wish list!");
		
		return isDisplay(alertBanner) && modifySuccessMessage;
	}

	// getters

	public String getProductImageLinkByIndex(int index) {

		try {

			if (index <= 0 || index > productImages.size()) {
				System.out.println("Invalid " + index + " | expected: 1 <= index < " + productImages.size());
				return null;
			}

			System.out.println(productImages.get(index - 1).getAttribute("href"));

			return productImages.get(index - 1).getAttribute("href");

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
			return null;
		}

	}

	public String getProductNameByIndex(int index) {

		try {

			if (index <= 0 || index > productNames.size()) {
				System.out.println("Invalid " + index + " | expected: 1 <= index < " + productNames.size());
				return null;
			}

			System.out.println(productNames.get(index - 1).getText());

			return productNames.get(index - 1).getText();

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
			return null;
		}

	}

	public String getProductModelByIndex(int index) {

		try {

			if (index <= 0 || index > productModels.size()) {
				System.out.println("Invalid " + index + " | expected: 1 <= index < " + productModels.size());
				return null;
			}

			System.out.println(productModels.get(index - 1).getText());

			return productModels.get(index - 1).getText();

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
			return null;
		}

	}

	public String getProductStockByIndex(int index) {

		try {

			if (index <= 0 || index > productStocks.size()) {
				System.out.println("Invalid " + index + " | expected: 1 <= index < " + productStocks.size());
				return null;
			}

			System.out.println(productStocks.get(index - 1).getText());

			return productStocks.get(index - 1).getText();

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
			return null;
		}

	}

	public String getProductUnitPriceByIndex(int index) {

		try {

			if (index <= 0 || index > productUnitPrices.size()) {
				System.out.println("Invalid " + index + " | expected: 1 <= index < " + productUnitPrices.size());
				return null;
			}

			System.out.println(productUnitPrices.get(index - 1).getText());

			return productUnitPrices.get(index - 1).getText();

		} catch (Exception e) {

			System.out.println("Invalid index input!" + index);
			return null;
		}

	}

}
