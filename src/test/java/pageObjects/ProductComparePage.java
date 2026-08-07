package pageObjects;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductComparePage extends BasePage {

	public ProductComparePage() {
		super();
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']//li//a")
	List<WebElement> breadcrumbLinks;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBanner;

	@FindBy(xpath = "(//p[normalize-space()='You have not chosen any products to compare.'])[1]")
	WebElement nonProductAddedMessage;
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//table")
	WebElement compareTable;
	@FindBy(xpath = "//td[normalize-space()='Product']/following-sibling::td")
	List<WebElement> comparedProducts;
	@FindBy(xpath = "(//input[@value='Add to Cart'])[1]")
	WebElement addToCartBtn;
	@FindBy(xpath = "(//a[contains(text(),'Remove')])[1]")
	WebElement removeBtn;

	public HomePage clickContinueBtn() {
		click(continueBtn);
		return new HomePage();
	}

	public void clickAddToCartBtn() {
		click(addToCartBtn);
	}

	public void addToCartAllProducts() throws InterruptedException {

		for (int i = 1; i <= comparedProducts.size(); i++) {
			Thread.sleep(500);
			getDriver().findElement(By.xpath("(//input[@value='Add to Cart'])[" + i + "]")).click();
		}

	}
	
	public void clickRemoveBtn() {
		click(removeBtn);
	}
	
	public void removeProducts(int numberOfProducts) throws InterruptedException {
		
		if(numberOfProducts > comparedProducts.size()) {
			System.out.println("Invalid numberOfProducts!");
			return;
		}else {
			for (int i = numberOfProducts; i > 0; i--) {
				Thread.sleep(500);
				getDriver().findElement(By.xpath("(//a[contains(text(),'Remove')])["+ i +"]")).click();
			}	
		}
		
	}

	// validations

	public boolean isNonProductAddedMessageDisplayed() {
		return isDisplay(nonProductAddedMessage);
	}

	public boolean isBreadcrumbWork() throws InterruptedException {

		for (int i = 0; i < breadcrumbLinks.size(); i++) {

			// System.out.println(breadcrumbLinks.get(i).getText());

			if (!breadcrumbLinks.get(i).isDisplayed()) {
				return false;

			} else if (i == 0) {
				click(breadcrumbLinks.get(i));
				if (!Objects.requireNonNull(getDriver().getCurrentUrl()).contains("home")) {
					// System.out.println(getDriver().getCurrentUrl());
					return false;
				}
				Thread.sleep(2000);

				getDriver().navigate().back();

			} else {
				click(breadcrumbLinks.get(i));
				if (!Objects.requireNonNull(getDriver().getCurrentUrl()).contains("compare")) {
					// System.out.println(getDriver().getCurrentUrl());
					return false;
				}
				Thread.sleep(2000);

				getDriver().navigate().back();

			}

		}

		return true;

	}

	public boolean isNProductAdded(int numberOfProduct) {
		// System.out.println(isDisplay(compareTable));
		// System.out.println((comparedProducts.size() == numberOfProduct) + " "
		// +comparedProducts.size());
		// System.out.println(isDisplay(addToCartBtn));
		// System.out.println(isDisplay(removeBtn));
		return isDisplay(compareTable) && (comparedProducts.size() == numberOfProduct) && isDisplay(addToCartBtn)
				&& isDisplay(removeBtn);
	}

	public boolean isProductAdded(String productName) {
		for (WebElement e : comparedProducts) {
			String B = e.getText().trim(); // Remove whitespace

			// Debug output
			System.out.println("A: " + productName);
			System.out.println("B: " + B);
			System.out.println("Match: " + B.equalsIgnoreCase(productName));

			if (B.equalsIgnoreCase(productName)) { // Use equalsIgnoreCase() instead
				return true;
			}
		}
		return false;
	}

	public boolean isAlertBannerDisplay() {
		return isDisplay(alertBanner);
	}

	public boolean isProductAddedToCart(String productName) throws InterruptedException {

		Thread.sleep(500);
		
		clickCartBtn();

		//getDriver().findElement(By.xpath("//div[@id='cart']//button[@data-toggle='dropdown']")).click();
		
		Thread.sleep(500);
		
		for (WebElement e : cartProductNames) {
			String B = e.getText().trim();

			// Debug output
			System.out.println("A: " + productName);
			System.out.println("B: " + B);
			System.out.println("Match: " + B.equalsIgnoreCase(productName));

			if (B.equalsIgnoreCase(productName)) { // Use equalsIgnoreCase() instead
				return true;
			}

		}

		return false;
	}

	public boolean allProductsAddedToCart() throws InterruptedException {

		Thread.sleep(500);
		
		clickCartBtn();

		//getDriver().findElement(By.xpath("//div[@id='cart']//button[@data-toggle='dropdown']")).click();
		
		Thread.sleep(500);

		List<String> texts1 = comparedProducts.stream().map(WebElement::getText).sorted().collect(Collectors.toList());

		List<String> texts2 = cartProductNames.stream().map(WebElement::getText).sorted().collect(Collectors.toList());

		boolean sameText = texts1.equals(texts2);
		
		return sameText;
	}

	// getters
	public int getComparedProductsCount() {
		try {
			return comparedProducts.size();

		} catch (NullPointerException e) {
			return 0;
		}
	}

	public String getAlertBannerText() {
		return alertBanner.getText();
	}

}
