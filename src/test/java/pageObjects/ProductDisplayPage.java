package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage {

	public ProductDisplayPage() {
		super();
	}

	@FindBy(xpath = "//li[contains(normalize-space(),'Product Code')]")
	WebElement productModalText;
	@FindBy(xpath = "//a[normalize-space()='product comparison']")
	WebElement alerProductComparisonLink;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBanner;

	@FindBy(xpath = "//ul[@class='thumbnails']//li[1]")
	WebElement mainThumbnail;
	@FindBy(xpath = "//ul[@class='thumbnails']//img")
	List<WebElement> thumbnails;

	@FindBy(xpath = "//img[@class='mfp-img']")
	WebElement lighBoxImage;
	@FindBy(xpath = "//button[@title='Next (Right arrow key)']")
	WebElement nextBtn;
	@FindBy(xpath = "//button[@title='Previous (Left arrow key)']")
	WebElement previousBtn;
	@FindBy(xpath = "//button[normalize-space()='×']")
	WebElement closeBtn;

	@FindBy(xpath = "//div[@class=\"col-sm-4\"]//ul//preceding-sibling::h1")
	WebElement productName;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Brand:')] ")
	WebElement productBrand;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Product Code:')]")
	WebElement productCode;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Availability:')]")
	WebElement productAvailability;
	@FindBy(xpath = "//ul[@class='list-unstyled']//h2[contains(.,'$')]")
	WebElement productPrice;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Ex Tax')]")
	WebElement productExTaxPrice;
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement quantityTxtBox;
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='alert alert-info']") WebElement minimumQuantityAlertBanner;

	@FindBy(xpath = "(//div[@class='product-thumb transition']//h4//a)[1]")
	WebElement firstProductTitle;

	@FindBy(xpath = "(//button[@data-original-title='Compare this Product'])[2]")
	WebElement compareThisProductBtn;
	@FindBy(xpath = "//div[@role='tooltip' and contains(., 'Compare')]")
	WebElement hoveringTooltip;

	public String getProductModelTexts() {

		String productCode = productModalText.getText().split(":")[1].trim();

		return productCode;
	}

	public void clickMainThumbnail() {
		click(mainThumbnail);
	}

	public boolean clickNThumbnail(int noOfThumbnail) throws InterruptedException {
		if (noOfThumbnail > thumbnails.size() || noOfThumbnail < 0) {
			System.out.println("Invalid noOfthumbnail! noOfthumbnail should be in range of 0 < noOfthumbnail < "
					+ thumbnails.size());
			return false;

		} else {

			System.out.println("valid input");
			Thread.sleep(500);

			WebElement thumbnailElement = getDriver()
					.findElement(By.xpath("(//ul[@class='thumbnails']//img)[" + noOfThumbnail + "]"));

			// click(thumbnailElement);
			thumbnailElement.click();

			return true;

		}
	}

	public void clickNextBtn() {
		click(nextBtn);
	}

	public void clickPreviousBtn() {
		click(previousBtn);
	}

	public void clickCloseBtn() {
		click(closeBtn);
	}

	public void clickCompareThisProductBtn() {
		click(compareThisProductBtn);
	}

	public ProductComparePage clickAlertProductComparisonProductLink() {
		click(alerProductComparisonLink);
		return new ProductComparePage();
	}

	public void addProductToCartByQuantity(int numberOfQuantity) throws InterruptedException {

		clearInput(quantityTxtBox);
		input(quantityTxtBox, Integer.toString(numberOfQuantity));
		//quantityTxtBox.sendKeys(Integer.toString(numberOfQuantity));
		
		Thread.sleep(500);
		
		click(addToCartBtn);

	}
	
	public void addProductToCartByQuantity(String numberOfQuantity) throws InterruptedException {

		clearInput(quantityTxtBox);
		input(quantityTxtBox, numberOfQuantity);
		//quantityTxtBox.sendKeys(Integer.toString(numberOfQuantity));
		
		Thread.sleep(500);
		
		click(addToCartBtn);

	}

	// validations
	public boolean isCompareThisProductBtnTooltipWork() throws InterruptedException {
		return isHoveringTooltipWork(compareThisProductBtn, "Compare this Product");
	}

	public boolean isHoveringTooltipWork(WebElement e, String text) throws InterruptedException {
		((JavascriptExecutor) getDriver())
				.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", e);

		Thread.sleep(500);

		act.moveToElement(e).pause(java.time.Duration.ofMillis(500)).perform();

		if (!hoveringTooltip.isDisplayed()) {
			return false;
		}

		if (!hoveringTooltip.getText().equals(text)) {
			System.out.println(hoveringTooltip.getText());
			return false;
		}

		return true;
	}

	public boolean isCompareThisProductAlertDisplayed(String productName) {
		String successMessage = alertBanner.getText();

		if (!successMessage.contains("Success: You have added " + productName + " to your product comparison!")) {
			return false;
		}

		return true;
	}

	public boolean isCompareThisProductAlertDisplayed_FirstProduct() {
		String successMessage = alertBanner.getText();

		if (!successMessage
				.contains("Success: You have added " + getFirstProductTitle() + " to your product comparison!")) {
			return false;
		}

		return true;
	}

	public boolean isLightBoxViewDisplay() {

		// debug output
		// System.out.println("Lightbox image display status: " +
		// isDisplay(lighBoxImage));
		// System.out.println("Previous button display status: " +
		// isDisplay(previousBtn));
		// System.out.println("Next button display status: " + isDisplay(nextBtn));

		return isDisplay(lighBoxImage) && isDisplay(previousBtn) && isDisplay(nextBtn);
	}

	public boolean isNextBtnWork() {
		try {

			// clickMainThumbnail();

			Thread.sleep(500);

			// get counterElement
			WebElement counterElement = getDriver().findElement(By.xpath("//div[@class='mfp-counter']"));
			String counterText = counterElement.getText(); // "1 of 5"
			System.out.println(counterText);

			// Extract the total number using split
			String[] parts = counterText.split(" of ");
			int total = Integer.parseInt(parts[1].trim());

			System.out.println("Total: " + total);

			for (int p = 1; p <= total; p++) {

				WebElement counterElement_counting = getDriver().findElement(By.xpath("//div[@class='mfp-counter']"));
				String counterText_counting = counterElement.getText(); // "1 of 5"
				String[] parts_counting = counterText_counting.split(" of ");

				WebElement nextBtn = getDriver().findElement(By.xpath("//button[@title='Next (Right arrow key)']"));
				nextBtn.click();

				int currentImage = Integer.parseInt(parts_counting[0].trim());
				System.out.println(currentImage + " of " + total);
			}

			return true;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean isPreviousBtnWork() {
		try {

			// clickMainThumbnail();

			Thread.sleep(500);

			// get counterElement
			WebElement counterElement = getDriver().findElement(By.xpath("//div[@class='mfp-counter']"));
			String counterText = counterElement.getText(); // "1 of 5"
			System.out.println(counterText);

			// Extract the total number using split
			String[] parts = counterText.split(" of ");
			int total = Integer.parseInt(parts[1].trim());

			System.out.println("Total: " + total);

			for (int p = total; p >= 0; p--) {

				WebElement counterElement_counting = getDriver().findElement(By.xpath("//div[@class='mfp-counter']"));
				String counterText_counting = counterElement.getText(); // "1 of 5"
				String[] parts_counting = counterText_counting.split(" of ");

				WebElement nextBtn = getDriver().findElement(By.xpath("//button[@title='Next (Right arrow key)']"));
				nextBtn.click();

				int currentImage = Integer.parseInt(parts_counting[0].trim());
				System.out.println(currentImage + " of " + total);
			}

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean isLightBoxNavBtnsWork() throws InterruptedException {

		/*
		 * clickMainThumbnail(); Thread.sleep(500);
		 */
		return isNextBtnWork() && isPreviousBtnWork();
	}

	public boolean isCloseBtnWork() {
		try {
			clickCloseBtn();

			return !isLightBoxViewDisplay();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;

		}
	}

	public boolean isCorrectThumbnailDisplay(int noOfThumbnail) throws InterruptedException {

		try {

			if (clickNThumbnail(noOfThumbnail)) {

				Thread.sleep(500);

				// get counterElement
				WebElement counterElement = getDriver().findElement(By.xpath("//div[@class='mfp-counter']"));
				String counterText = counterElement.getText(); // "1 of 5"
				System.out.println(counterText);

				// Extract the current image number using split
				String[] parts = counterText.split(" of ");
				int currentImage = Integer.parseInt(parts[0].trim());

				return noOfThumbnail == currentImage;

			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean isProductNameDisplay(String name) {
		return isDisplay(productName) && productName.getText().contains(name);
	}

	public boolean isProductBrandDisplay(String brand) {
		return isDisplay(productBrand) && productBrand.getText().contains(brand);
	}

	public boolean isProductCodeDisplay(String code) {
		return isDisplay(productCode) && productCode.getText().contains(code);
	}

	public boolean isProductAvailabilityDisplay(String availability) {

		// System.out.println("Availability display: " +
		// isDisplay(productAvailability));
		// System.out.println("Availability text display: " +
		// productAvailability.getText());

		return isDisplay(productAvailability) && productAvailability.getText().contains(availability);
	}

	public boolean isProductPriceDisplay(String price) {

		// System.out.println("Availability display: " +
		// isDisplay(productAvailability));
		// System.out.println("Availability text display: " +
		// productAvailability.getText());

		return isDisplay(productPrice) && productPrice.getText().contains(price);
	}

	public boolean isProductExTaxPriceDisplay(String price) {

		// System.out.println("Availability display: " +
		// isDisplay(productAvailability));
		// System.out.println("Availability text display: " +
		// productAvailability.getText());

		return isDisplay(productExTaxPrice) && productExTaxPrice.getText().contains(price);
	}

	public boolean isDefaultQuantityDisplay() {
		return Integer.parseInt(getQuantityValue()) == 1;
	}

	public boolean isAddToCartByQuantityWork(int numberOfQuantity) throws InterruptedException {

		int beforeAddedTotal = getAddedProductTotal();

		addProductToCartByQuantity(numberOfQuantity);
		
		Thread.sleep(500);

		int afterAddedTotal = getAddedProductTotal();

		// debug output
		System.out.println("bf: " + beforeAddedTotal);
		System.out.println("af: " + afterAddedTotal);

		return beforeAddedTotal <= afterAddedTotal;
	}
	
	public boolean isMinimumQuantityDisplay() {
		
		
		String[] parts = minimumQuantityAlertBanner.getText().split(" of ");
		String minimumQuantity = parts[1].trim();
		
		boolean validateDefaultWQuantity = Integer.parseInt(getQuantityValue()) == Integer.parseInt(minimumQuantity);
		
		//debug output
		System.out.println("product minimum quantity required: " + minimumQuantity);
		System.out.println("Banner display? " +  isDisplay(minimumQuantityAlertBanner));
		System.out.println("Correct default minimum quantity display? " +  validateDefaultWQuantity);
		
		return isDisplay(minimumQuantityAlertBanner) && validateDefaultWQuantity ;
	}

	// getters
	public String getFirstProductTitle() {
		return firstProductTitle.getText();
	}

	public String getQuantityValue() {
		return quantityTxtBox.getAttribute("value");
	}

}
