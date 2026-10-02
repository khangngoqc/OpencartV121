package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDisplayPage extends BasePage {

	public ProductDisplayPage() {
		super();
	}

	@FindBy(xpath = "//li[contains(normalize-space(),'Product Code')]")
	WebElement productModalText;
	@FindBy(xpath = "//a[normalize-space()='product comparison']")
	WebElement alerProductComparisonLnk;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBanner;
	@FindBy(xpath = "//a[normalize-space()='wish list']")
	WebElement alertWishListLnk;
	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	WebElement alertShoppingCartLnk;
	

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

	@FindBy(xpath = "//div[@id='tab-description']")
	WebElement productDescription;
	@FindBy(xpath = "//a[normalize-space()='Specification']")
	WebElement specificationTab;
	@FindBy(xpath = "//div[@id='tab-specification']")
	WebElement productSpecification;
	@FindBy(xpath = "//a[contains(.,'Reviews')]")
	WebElement reviewsTab;
	@FindBy(xpath = "//input[@id='input-name']")
	WebElement yourNameTxtbox;
	@FindBy(xpath = "//textarea[@id='input-review']")
	WebElement yourReviewTxtarea;
	@FindBy(xpath = "//input[@type='radio' and @name='rating']")
	List<WebElement> ratingRadioBtns;
	@FindBy(xpath = "//button[@id='button-review']")
	WebElement reviewContinueBtn;
	@FindBy(xpath = "//div[@id='tab-review']//div[@class='alert alert-success alert-dismissible']")
	WebElement reviewAlertSucces;
	@FindBy(xpath = "//div[@id='tab-review']//div[@class='alert alert-danger alert-dismissible']")
	WebElement reviewAlertDanger;
	@FindBy(xpath = "//p[normalize-space()='There are no reviews for this product.']")
	WebElement nonReviewText;

	@FindBy(xpath = "//div[@class='col-sm-4']//button[@data-original-title='Add to Wish List']")
	WebElement addToWishListBtn;
	@FindBy(xpath = "//div[@class='col-sm-4']//button[@data-original-title='Compare this Product']")
	WebElement productComparisonBtn;
	@FindBy(xpath = "//div[@class=\"col-sm-4\"]//ul//preceding-sibling::h1")
	WebElement productName;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Brand:')] ")
	WebElement productBrand;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Product Code:')]")
	WebElement productCode;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Points')]")
	WebElement productRewardPoints;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Availability:')]")
	WebElement productAvailability;
	@FindBy(xpath = "(//ul[@class='list-unstyled']//li//span[contains(.,'$')])[1]")
	WebElement productOriginalPrice;
	@FindBy(xpath = "//ul[@class='list-unstyled']//h2[contains(.,'$')]")
	WebElement productPrice;
	@FindBy(xpath = "//ul[@class='list-unstyled']//li[contains(.,'Ex Tax')]")
	WebElement productExTaxPrice;
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement quantityTxtBox;

	// Product Form
	@FindBy(xpath = "")
	WebElement formRadio;
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement formCheckbox1;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement formCheckbox2;
	@FindBy(xpath = "(//input[@type='text' and @class='form-control'])[1]")
	WebElement formTextInput;
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement formSelect;
	@FindBy(xpath = "//textarea[contains(@id,'input-option')]")
	WebElement formTextarea;
	@FindBy(xpath = "//button[contains(.,'Upload File')]")
	WebElement formUploadFile;
	@FindBy(xpath = "//input[@data-date-format='YYYY-MM-DD']")
	WebElement formDateInputTxtBox;
	@FindBy(xpath = "//div[@class='input-group date']//button[@type='button']")
	WebElement formDateInputBtn;
	@FindBy(xpath = "//div[@class='input-group time']//button[@type='button']")
	WebElement formTimeInput;
	@FindBy(xpath = "//div[@class='input-group datetime']//button[@type='button']")
	WebElement formDateTimeInput;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement addToCartBtn;
	@FindBy(xpath = "//span[@class='fa fa-stack']")
	List<WebElement> averageStar;
	@FindBy(xpath = "//a[contains(text(),' reviews')]")
	WebElement reviewsNumber;
	@FindBy(xpath = "//a[normalize-space()='Write a review']")
	WebElement writeAReviewLink;

	@FindBy(xpath = "//div[@class='alert alert-info']")
	WebElement minimumQuantityAlertBanner;

	@FindBy(xpath = "(//div[@class='product-thumb transition']//h4//a)[1]")
	WebElement firstProductTitle;
	@FindBy(xpath = "(//span[normalize-space()='Add to Cart'])[1]") WebElement firstRelatedProductAddToCartBtn;
	
	
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

	public void clickSpecificationTab() {
		click(specificationTab);
	}

	public void clickReviewsTab() {
		click(reviewsTab);
	}

	public void clickCompareThisProductBtn() {
		click(compareThisProductBtn);
	}

	public ProductComparePage clickAlertProductComparisonProductLink() {
		click(alerProductComparisonLnk);
		return new ProductComparePage();
	}

	public void addProductToCartByQuantity(int numberOfQuantity) throws InterruptedException {

		clearInput(quantityTxtBox);
		input(quantityTxtBox, Integer.toString(numberOfQuantity));
		// quantityTxtBox.sendKeys(Integer.toString(numberOfQuantity));

		Thread.sleep(1000);

		click(addToCartBtn);

	}

	public void addProductToCartByQuantity(String numberOfQuantity) throws InterruptedException {

		clearInput(quantityTxtBox);
		input(quantityTxtBox, numberOfQuantity);
		// quantityTxtBox.sendKeys(Integer.toString(numberOfQuantity));

		Thread.sleep(500);

		click(addToCartBtn);

	}

	public void clickRadio() {
		click(formRadio);
	}

	public void enableCheckbox1() {
		if (formCheckbox1.isEnabled() == false) {
			click(formCheckbox1);
		}
	}

	public void enableCheckbox2() {
		if (formCheckbox2.isEnabled() == false) {
			click(formCheckbox2);
		}
	}

	public void handleFormSelect(int index) {
		Select dropdown = new Select(formSelect);
		List<WebElement> selectOptions = dropdown.getOptions();
		// System.out.println(selectOptions.toString());

		int numberOfOptions = selectOptions.size();

		// System.out.println(selectOptions.size());

		if (index > numberOfOptions || index <= 0) {
			System.out.println(
					"Invalid index input! index should be in range of  0 < [index] <= " + numberOfOptions);
		} else {
			dropdown.selectByIndex(index - 1);
		}
	}
	
	public boolean isOptionSelected(String option) {
		Select dropdown = new Select(formSelect);
		String selected = dropdown.getFirstSelectedOption().getText();
		
		System.out.println("Selected option: " + selected);
		
		if(selected.contains(option)){
			return true;
		}
		
		return false;
	}

	public void inputFormTextarea(String text) {
		input(formTextarea, text);
	}

	public void uploadFormFile(String filePath) throws AWTException, InterruptedException {

		try {

			click(formUploadFile);

			// step1: copy(ctrl+C) the file path into the system clipboard
			StringSelection filePathSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

			// step2: paste(ctrl+V)
			Robot rb = new Robot();

			rb.keyPress(KeyEvent.VK_CONTROL); // For MAC: rb.keyPress(KeyEvent.VK_META);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);

			Thread.sleep(500);

			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(500);

			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);

			Thread.sleep(500);
			// step3: click on return/enter key
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);

			Thread.sleep(1000);
			Alert myAlert = getDriver().switchTo().alert();
			// myAlert.sendKeys("welcome");
			myAlert.accept(); // close alert with OK button

		} catch (Exception e) {
			System.out.println("Fail to updload file! | " + e.getMessage());
		}

	}

	public void InputFormDate(String date) {
		input(formDateInputTxtBox, date);
	}

	public void InputFormDate(int year, int month, int date) throws InterruptedException {
		WebElement datePickerButton = getDriver()
				.findElement(By.xpath("//div[@class='input-group date']//button[@type='button']"));
		WebElement monthYearNav = getDriver().findElement(By.xpath("(//th[@class='picker-switch'])[1]"));

		// WebElement yearNav =
		// driver.findElement(By.xpath("(//th[@class='picker-switch'])[2]"));

		((JavascriptExecutor) getDriver())
				.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", datePickerButton);

		datePickerButton.click();
		monthYearNav.click();

		if (year <= 0) {
			System.out.println("invalid year input! ");
			return;
		}

		int currentYear = java.time.Year.now().getValue();
		if (year < 1900 || year > (currentYear + 100)) {
			System.out.println("Year input out of bound! Input should be in range 1900 < [input] < currentYear + 100");
			return;
		}

		Thread.sleep(500);
		// select year
		navigateToYear(year);

		Thread.sleep(500);
		// select month
		navigateToMonth(month);

		Thread.sleep(500);
		// select date
		navigateToDate(date);
	}

	public void handleDatePicker(int year, String month, int date) throws InterruptedException {

		WebElement datePickerButton = getDriver()
				.findElement(By.xpath("//div[@class='input-group date']//button[@type='button']"));
		WebElement monthYearNav = getDriver().findElement(By.xpath("(//th[@class='picker-switch'])[1]"));

		// WebElement yearNav =
		// driver.findElement(By.xpath("(//th[@class='picker-switch'])[2]"));

		((JavascriptExecutor) getDriver())
				.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", datePickerButton);

		datePickerButton.click();
		monthYearNav.click();

		if (year <= 0) {
			System.out.println("invalid year input! ");
			return;
		}

		int currentYear = java.time.Year.now().getValue();
		if (year < 1900 || year > (currentYear + 100)) {
			System.out.println("Year input out of bound! Input should be in range 1900 < [input] < currentYear + 100");
			return;
		}

		Thread.sleep(500);
		// select year
		navigateToYear(year);

		Thread.sleep(500);
		// select month
		navigateToMonth(month);

		Thread.sleep(500);
		// select date
		navigateToDate(date);

	}

	private String extractYear() {

		String MonthYearString = getDriver()
				.findElement(By.xpath("(//div[contains(@class,'picker-open')]//th[@class='picker-switch'])[1]"))
				.getText();

		String currentYearString = getDriver()
				.findElement(By.xpath("(//div[contains(@class,'picker-open')]//th[@class='picker-switch'])[2]"))
				.getText();

		// String yearToYearString =
		// driver.findElement(By.xpath("(//th[@class='picker-switch'])[3]")).getText();
		// String[] yearRange = yearToYearString.trim().split("-");
		// String yearMin = yearRange[0];
		// yearMax = yearRange[0];

		return currentYearString;
	}

	private void navigateToYear(int year) {

		WebElement preBtn = getDriver().findElement(
				By.xpath("(//div[contains(@class,'picker-open')]//th[@class='prev'][contains(text(),'‹')])[2]"));
		WebElement nxtBtn = getDriver().findElement(
				By.xpath("(//div[contains(@class,'picker-open')]//th[@class='next'][contains(text(),'›')])[2]"));

		String defaultYearString = extractYear();
		int defaultYear = Integer.parseInt(defaultYearString);

		while (defaultYear > year) {
			preBtn.click();
			defaultYear = Integer.parseInt(extractYear());
		}

		while (defaultYear < year) {
			nxtBtn.click();
			defaultYear = Integer.parseInt(extractYear());
		}

	}

	private void navigateToMonth(int month) {

		if (month <= 0 || month > 12) {
			System.out.println("Invalid month input! Input should be in range of 1 <= [month] <= 12");
		}

		WebElement monthEle = getDriver()
				.findElement(By.xpath("(//div[contains(@class,'picker-open')]//span[@class='month'])[" + month + "]"));
		monthEle.click();

	}

	private void navigateToMonth(String month) {

		try {
			String monthInput = convertMonth(month);

			WebElement monthEle = getDriver().findElement(
					By.xpath("//div[contains(@class,'picker-open')]//span[@class='month'][normalize-space()='"
							+ monthInput.trim() + "']"));
			monthEle.click();
		} catch (Exception e) {
			System.out.println("Invalid month input! | " + month);
		}

	}

	private String convertMonth(String month) {
		HashMap<String, String> monthMap = new HashMap<String, String>();

		monthMap.put("January", "Jan");
		monthMap.put("February", "Feb");
		monthMap.put("March", "Mar");
		monthMap.put("April", "Apr");
		monthMap.put("May", "May");
		monthMap.put("June", "Jun");
		monthMap.put("July", "Jul");
		monthMap.put("August", "Aug");
		monthMap.put("September", "Sep");
		monthMap.put("October", "Oct");
		monthMap.put("November", "Nov");
		monthMap.put("December", "Dec");

		monthMap.put("1", "Jan");
		monthMap.put("2", "Feb");
		monthMap.put("3", "Mar");
		monthMap.put("4", "Apr");
		monthMap.put("5", "May");
		monthMap.put("6", "Jun");
		monthMap.put("7", "Jul");
		monthMap.put("8", "Aug");
		monthMap.put("9", "Sep");
		monthMap.put("10", "Oct");
		monthMap.put("11", "Nov");
		monthMap.put("12", "Dec");

		String vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid month...");
		}

		return vmonth;

	}

	private void navigateToDate(int date) {

		try {

			WebElement dateEle = getDriver().findElement(
					By.xpath("(//div[contains(@class,'picker-open')]//td[@class='day' and contains(text(),'" + date
							+ "')])[1]"));
			dateEle.click();

		} catch (Exception e) {
			System.out.println(e.getMessage() + "\n" + "Invalid date | " + date);
		}

	}

	public void InputFormTime(int hour, int min) {

		click(formTimeInput);

		navigateToHour(hour);
		navigateToMinute(min);

		click(formTimeInput); // close widget
	}

	private int extractHour() {

		WebElement hourEle = getDriver()
				.findElement(By.xpath("//div[contains(@class,'picker-open')]//span[@class='timepicker-hour']"));
		int hour = Integer.parseInt(hourEle.getText());

		return hour;
	}

	private int extractMinute() {

		WebElement minuteEle = getDriver()
				.findElement(By.xpath("//div[contains(@class,'picker-open')]//span[@class='timepicker-minute']"));
		int minute = Integer.parseInt(minuteEle.getText());

		return minute;
	}

	public void navigateToHour(int hour) {

		if (hour > 23 || hour < 0) {
			System.out.println("Invalid hour input!");
			return;
		}

		WebElement hourIncrementBtn = getDriver()
				.findElement(By.xpath("//div[contains(@class,'picker-open')]//a[@data-action='incrementHours']//span"));
		WebElement hourDecrementBtn = getDriver()
				.findElement(By.xpath("//div[contains(@class,'picker-open')]//a[@data-action='decrementHours']//span"));

		int currentHour = extractHour();

		while (currentHour > hour) {
			click(hourDecrementBtn);
			currentHour = extractHour();
		}

		while (currentHour < hour) {
			click(hourIncrementBtn);
			currentHour = extractHour();
		}

	}

	public void navigateToMinute(int min) {

		if (min > 59 || min < 0) {
			System.out.println("Invalid minute input!");
			return;
		}

		WebElement minIncrementBtn = getDriver().findElement(
				By.xpath("//div[contains(@class,'picker-open')]//a[@data-action='incrementMinutes']//span"));
		WebElement minDecrementBtn = getDriver().findElement(
				By.xpath("//div[contains(@class,'picker-open')]//a[@data-action='decrementMinutes']//span"));

		int currentMin = extractMinute();

		while (currentMin > min) {
			click(minDecrementBtn);
			currentMin = extractMinute();
		}

		while (currentMin < min) {
			click(minIncrementBtn);
			currentMin = extractMinute();
		}

	}

	public void inputFormDateTime(int year, int month, int date, int hour, int min) throws InterruptedException {

		click(formDateTimeInput);

		WebElement monthYearNav = getDriver()
				.findElement(By.xpath("(//div[contains(@class,'picker-open')]//th[@class='picker-switch'])[1]"));

		// WebElement yearNav =
		// driver.findElement(By.xpath("(//th[@class='picker-switch'])[2]"));

		monthYearNav.click();

		if (year <= 0) {
			System.out.println("invalid year input! ");
			return;
		}

		int currentYear = java.time.Year.now().getValue();
		if (year < 1900 || year > (currentYear + 100)) {
			System.out.println("Year input out of bound! Input should be in range 1900 < [input] < currentYear + 100");
			return;
		}

		navigateToYear(year);
		navigateToMonth(month);
		navigateToDate(date);

		WebElement timeAccordion = getDriver()
				.findElement(By.xpath("//li[@class='picker-switch accordion-toggle']//a[@class='btn']"));
		click(timeAccordion);

		Thread.sleep(500);

		navigateToHour(hour);
		navigateToMinute(min);

		click(formDateTimeInput); // close widget

	}

	public void inputYourName(String text) {
		input(yourNameTxtbox, text);
	}

	public void inputYourReview(String text) {
		input(yourReviewTxtarea, text);
	}

	public void selectRating(int point) {
		if (point < 1 || point > 5) {
			System.out.println(
					"Invalid rating [point] input " + point + " | Rating input should be in range of 1 to 5 .");
			return;
		}

		click(ratingRadioBtns.get(point - 1));

	}

	public void clickContinueBtn() {
		click(reviewContinueBtn);
	}

	public void writeAReview(String name, String review, int rating) {
		inputYourName(name);
		inputYourReview(review);
		selectRating(rating);
		clickContinueBtn();
	}

	public void clickWriteAReviewLink() {
		click(writeAReviewLink);
	}

	public void clickReviewCount() {
		click(reviewsNumber);
	}

	public void clickAddToWishListBtn() {
		click(addToWishListBtn);
	}

	public WishListPage clickAlertWishListLnk() {
		click(alertWishListLnk);

		return new WishListPage();
	}

	public void clickProductComparisonBtn() {
		click(productComparisonBtn);
	}

	public void clickFirstRelatedProductTitle() {
		click(firstProductTitle);
	}
	
	public ShoppingCartPage clickAlertShoppingCartLnk() {
		click(alertShoppingCartLnk);
		
		return new ShoppingCartPage();
	}
	
	public void clickFirstRelatedProductAddToCartBtn() {
		
		click(firstRelatedProductAddToCartBtn);
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

	public boolean isLightBoxViewDisplay() throws InterruptedException {

		Thread.sleep(1000);
		
		// debug output
		System.out.println("Lightbox image display status: " + isDisplay(lighBoxImage));
		System.out.println("Previous button display status: " + isDisplay(previousBtn));
		System.out.println("Next button display status: " + isDisplay(nextBtn));

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
	
	public boolean isProductRewardPointsDisplay(int point) {
		return isDisplay(productRewardPoints) && productRewardPoints.getText().contains(Integer.toString(point));
	}

	public boolean isProductAvailabilityDisplay(String availability) {

		// System.out.println("Availability display: " +
		// isDisplay(productAvailability));
		// System.out.println("Availability text display: " +
		// productAvailability.getText());

		return isDisplay(productAvailability) && productAvailability.getText().contains(availability);
	}
	
	public boolean isOriginalProductPriceDisplay(int price) {

		System.out.println("Original price display: " +
		isDisplay(productOriginalPrice));
		System.out.println("Original price text display: " +
				productOriginalPrice.getText());

		System.out.println("Original price text is stiked out: " +
				isElementStrikedOut(productOriginalPrice));

		
		return isDisplay(productOriginalPrice) && productOriginalPrice.getText().contains(Integer.toString(price)) && isElementStrikedOut(productOriginalPrice);
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

		// debug output
		System.out.println("product minimum quantity required: " + minimumQuantity);
		System.out.println("Banner display? " + isDisplay(minimumQuantityAlertBanner));
		System.out.println("Correct default minimum quantity display? " + validateDefaultWQuantity);

		return isDisplay(minimumQuantityAlertBanner) && validateDefaultWQuantity;
	}

	public boolean validateminimumQuantityAlertBannerTxt(String message) {
		return minimumQuantityAlertBanner.getText().equals(message);
	}

	public boolean isMinimumWarningQuantityExistInDOM() {
		return findInDOM("Minimum order amount for + " + productName.getText().trim() + " is 2!");
	}

	public boolean isCorrectProductDecriptionDisplay() {
		return isDisplay(productDescription)
				&& getElementText(productDescription).contains(getElementText(productName).trim());
	}

	public boolean isCorrectProductSpecificationDisplay() {
		return isDisplay(productSpecification)
				&& getElementText(productSpecification).contains(getElementText(productName).trim());
	}

	public boolean isDescGrammarCorrect() throws IOException {
		return grammarCheck(getElementText(productDescription));
	}

	public boolean isSpecGrammarCorrect() throws IOException {
		return grammarCheck(getElementText(productSpecification));
	}

	public boolean isSuccessMsgDisplay() {
		return isDisplay(reviewAlertSucces) && getElementText(reviewAlertSucces).trim()
				.contains("Thank you for your review. It has been submitted to the webmaster for approval.");
	}

	public boolean isNonReviewTextDisplay() {
		return isDisplay(nonReviewText);
	}

	public boolean isCorrectAlertMsgDisplay(String keyword) {
		return isDisplay(reviewAlertDanger) && getElementText(reviewAlertDanger).trim().contains(keyword);
	}

	public boolean isReviewsTabActive() {
		// System.out.println(reviewsTab.getAttribute("aria-expanded"));
		return reviewsTab.getAttribute("aria-expanded").equals("true");
	}

	public boolean isAverageStarDisplay() {
		for (WebElement e : averageStar) {
			if (isDisplay(e) != true) {
				return false;
			}
		}

		return true;
	}

	public boolean isReviewsNumberDisplay() {
		return isDisplay(reviewsNumber);
	}

	public boolean isReviewCountDisplay() {
		int reCount = getReviewsCount();

		if (isDisplay(nonReviewText) && reCount == 0) {
			return true;
		}

		System.out.println(reCount);

		return false;

	}

	public boolean isWishListSuccessAlertDisplay() {
		return isDisplay(alertBanner) && alertBanner.getText()
				.contains("Success: You have added " + productName.getText() + " to your wish list!");
	}

	public boolean isComparisonSuccessAlertDisplay() {
		return isDisplay(alertBanner) && alertBanner.getText()
				.contains("Success: You have added " + productName.getText() + " to your product comparison!");
	}
	
	public boolean isAddToCartSuccessAlertDisplay() {
		System.out.println(alertBanner.getText());
		
		return isDisplay(alertBanner) && alertBanner.getText()
				.contains("Success: You have added " + productName.getText() + " to your shopping cart!");
	}
	
	public boolean isAddToCartSuccessAlertDisplay(String productName) {
		System.out.println(alertBanner.getText());
		
		return isDisplay(alertBanner) && alertBanner.getText()
				.contains("Success: You have added " + productName + " to your shopping cart!");
	}

	public boolean isSocialOptionsAvailable() {

		String[] options = { "share", "retweet", "repost", "forward", "pinterest", "like", "comment", "subscribe",
				"follow", "connect", "viral", "trending", "buzz", "shoutout", "mention", "tag", "broadcast", "publish",
				"post", "tweet", "embed", "link", "syndicate", "distribute", "engage", "facebook" };

		for (String s : options) {
			if (findInDOM(s)) {
				System.out.println("Keyword found: " + s);
				try {
					getDriver().findElement(By.partialLinkText(s));
					return true;
				} catch (Exception e) {
					System.out.println("Cannot find interactive element related to " + s + " keyword.");
					continue;
				}

			}
		}

		return false;

	}

	public boolean isCorrectProductNameDisplay(String name) {

		System.out.println(name + " | " + productName.getText());

		return productName.getText().equals(name.trim());
	}

	// getters
	public String getFirstProductTitle() {
		return firstProductTitle.getText();
	}

	public String getQuantityValue() {
		return quantityTxtBox.getAttribute("value");
	}

	public int getReviewsCount() {
		String label = reviewsTab.getText(); // e.g. "Reviews (12)"
		String digits = label.replaceAll("[^0-9]", ""); // "12"
		return Integer.parseInt(digits);

	}
	
	public boolean isCorrectBulkPurchasePriceDisplay(int amount, float price) {
		try {
			
			WebElement bulkPurchase = getDriver().findElement(By.xpath("//ul[@class='list-unstyled']//li[contains(.,'"+ amount +" or more $')]"));
			//getLogger().info("STEP get bulkPurchase element of " + amount);
			
			System.out.println("isDisplay: "+ bulkPurchase.isDisplayed());
			System.out.println("isc contain expected value: "+ bulkPurchase.getText().contains(String.valueOf(price)));
			
			/*
			 * getLogger().info("isDisplay: "+ bulkPurchase.isDisplayed());
			 * getLogger().info("isc contain expected value: "+
			 * bulkPurchase.getText().contains(String.valueOf(price)));
			 */
			
			return isDisplay(bulkPurchase) && bulkPurchase.getText().contains(String.valueOf(price));
			
	
		} catch (Exception e) {
			 System.out.println(e.getMessage());
			 
		}	
		
		return false;
		
	}

}
