package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static java.awt.SystemColor.text;

public class SearchPage extends BasePage {

	public SearchPage() {
		super();
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTxtbox;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertBanner;

	@FindBy(xpath = "//div[@class='caption']//h4//a")
	List<WebElement> searchProductTitles;
	@FindBy(xpath = "//p[@class='price']")
	List<WebElement> searchProductPrices;

	@FindBy(xpath = "//button[@id='list-view']")
	WebElement listViewBtn;
	@FindBy(xpath = "//button[@id='grid-view']")
	WebElement gridViewBtn;
	@FindBy(xpath = "//button//span[normalize-space()='Add to Cart'][1]")
	WebElement addToCartBtn;
	@FindBy(xpath = "//button[@data-original-title='Add to Wish List'][1]")
	WebElement addToWishListBtn;
	@FindBy(xpath = "//button[@data-original-title='Compare this Product'][1]")
	WebElement compareThisProductBtn;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement resultMessage;

	@FindBy(xpath = "//input[@id='input-search']")
	WebElement searchCriteriaTxtbox;
	@FindBy(xpath = "//input[@id='button-search']")
	WebElement searchBtn;
	@FindBy(xpath = "//select[@name='category_id']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//input[@name='sub_category']")
	WebElement subCategoryCheckbox;

	@FindBy(xpath = "//div/a[contains(text(),'Product Compare')]")
	WebElement compareProductLink;
	@FindBy(xpath = "//select[@id='input-sort']")
	WebElement sortByDropdown;
	@FindBy(xpath = "//select[@id='input-limit']") WebElement NumberOfResultShowDropdown;

	@FindBy(xpath = "//div[@class='product-thumb']")
	List<WebElement> searchResultItems;
	@FindBy(xpath = "(//div[@class='product-thumb']//div[@class='image'])[1]")
	WebElement firstSearchProductImage;
	@FindBy(xpath = "(//div[@class='caption']//h4//a)[1]")
	WebElement firstSearchProductTitle;

	public boolean isSearchProductExist(String productName) {

		try {

			for (WebElement element : searchProductTitles) {
				if (element.getText().contains(productName)) {
					return true;
				}
			}
			return false;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public void clickListViewBtn() {
		listViewBtn.click();
	}

	public void clickGridViewBtn() {
		gridViewBtn.click();
	}

	public boolean isResultMessageDiplayed() {
		return isDisplay(resultMessage);
	}

	public int searchProductCount() {
		return searchProductTitles.size();
	}

	public String searchTxtBoxPlaceholder() {
		return getPlaceholderValue(searchTxtbox);
	}

	public String searchCriteriaPlaceholder() {
		return getPlaceholderValue(searchCriteriaTxtbox);
	}

	public void inputSearchCriteria(String keyword) {
		searchCriteriaTxtbox.sendKeys(keyword);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public void selectCategory(String category) {
		Select dropdown = new Select(categoryDropdown);
		dropdown.selectByContainsVisibleText(category);
	}

	public void checkSubCategoryCheckBox() {
		if (subCategoryCheckbox.isSelected()) {
			return;
		} else {
			subCategoryCheckbox.click();
		}
	}

	public void selectSortByDropdown(String option) {
		Select dropdown = new Select(sortByDropdown);
		dropdown.selectByContainsVisibleText(option);
	}

	public boolean isProductTitlesSortedAtoZ() {
		return isSortedAtoZWebElement(searchProductTitles);
	}

	public boolean isProductTitlesSortedZtoA() {
		return isSortedZtoA(searchProductTitles);
	}

	public boolean isProductPriceSortedLowtoHigh() {
		return isSortedLowtoHigh(searchProductPrices);
	}

	public boolean isProductPriceSortedHightoLow() {
		return isSortedHightoLow(searchProductPrices);
	}
	
	public boolean isProductModelSortedAtoZ() {
		return isSortedAtoZString(getSearchProductsModel());
	}

	public boolean isProductModelSortedZtoA() {
		return isSortedZtoAString(getSearchProductsModel());
	}

	
	private boolean isSortedLowtoHigh(List<WebElement> list) {
		if (list == null) {
			return false;
		}

		for (int i = 0; i < list.size() - 1; i++) {

			String a = list.get(i).getText();
			String priceTextA = a.split("\n")[0].trim();
			String numericTextA = priceTextA.replaceAll("[^0-9]", "");
			int x = Integer.parseInt(numericTextA);

			String b = list.get(i + 1).getText();
			String priceTextB = b.split("\n")[0].trim();
			String numericTextB = priceTextB.replaceAll("[^0-9]", "");
			int y = Integer.parseInt(numericTextB);

			// Case-sensitive comparison (Low-High)
			if (x - y > 0) {
				return false;
			}
		}

		return true;
	}

	private boolean isSortedHightoLow(List<WebElement> list) {
		if (list == null) {
			return false;
		}

		for (int i = 0; i < list.size() - 1; i++) {
			String a = list.get(i).getText();
			String priceTextA = a.split("\n")[0].trim();
			String numericTextA = priceTextA.replaceAll("[^0-9]", "");
			int x = Integer.parseInt(numericTextA);

			String b = list.get(i + 1).getText();
			String priceTextB = b.split("\n")[0].trim();
			String numericTextB = priceTextB.replaceAll("[^0-9]", "");
			int y = Integer.parseInt(numericTextB);

			// Case-sensitive comparison (High-Low)
			if (x - y < 0) {
				return false;
			}
		}

		return true;
	}

	private boolean isSortedAtoZWebElement(List<WebElement> list) {
		if (list == null | list.size() <= 1) {
			return false;
		}

		for (int i = 0; i < list.size() - 1; i++) {
			// Case-sensitive comparison (A-Z)
			if (list.get(i).getText().compareToIgnoreCase(list.get(i + 1).getText()) > 0) {
				return false;
			}
		}

		return true;
	}
	
	private boolean isSortedAtoZString(List<String> list) {
		if (list == null | list.size() <= 1) {
			return false;
		}

		for (int i = 0; i < list.size() - 1; i++) {
			// Case-sensitive comparison (A-Z)
			if (list.get(i).compareToIgnoreCase(list.get(i + 1)) > 0) {
				return false;
			}
		}

		return true;
	}

	private boolean isSortedZtoA(List<WebElement> list) {
		// A list with 0 or 1 elements is always sorted
		if (list == null | list.size() <= 1) {
			return false;
		}

		for (int i = 0; i < list.size() - 1; i++) {
			// If the current element is smaller than the next, it is not Z-A
			if (list.get(i).getText().compareToIgnoreCase(list.get(i + 1).getText()) <= 0) {
				return false;
			}
		}

		return true;
	}
	
	private boolean isSortedZtoAString(List<String> list) {
		// A list with 0 or 1 elements is always sorted
		if (list == null | list.size() <= 1) {
			return false;
		}

		for (int i = 0; i < list.size() - 1; i++) {
			// If the current element is smaller than the next, it is not Z-A
			if (list.get(i).compareToIgnoreCase(list.get(i + 1)) <= 0) {
				return false;
			}
		}

		return true;
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}

	public void clickAddToWishList() {
		addToWishListBtn.click();
	}

	public void clickCompareToThisProduct() {
		compareThisProductBtn.click();
	}

	public ProductComparePage clickProductCompareLink() {
		compareProductLink.click();
		return new ProductComparePage();
	}

	public boolean isAlertBannerDisplayed() {
		return alertBanner.isDisplayed();
	}

	public String getAlertBannerText() {
		return alertBanner.getText();
	}

	public boolean isListViewEnable() {
		return getDriver()
				.findElement(By.xpath("//div[@class='row']//div[contains(@class,'product-layout product-list')]"))
				.isDisplayed();
	}

	public boolean isGridViewEnable() {
		return getDriver()
				.findElement(By.xpath("//div[@class='row']//div[contains(@class,'product-layout product-grid')]"))
				.isDisplayed();
	}

	public boolean isCompareProductLinkDisplayed() {
		return isDisplay(compareProductLink);
	}

	public int getSearchResultCount() {
		return searchResultItems.size();
	}

	public ProductDisplayPage clickFirstProductImage() {
		firstSearchProductImage.click();
		return new ProductDisplayPage();
	}

	public ProductDisplayPage clickFirstProductTitle() {
		firstSearchProductTitle.click();
		return new ProductDisplayPage();
	}

	public String getFirstSearchProductTitle() {
		return firstSearchProductTitle.getText();
	}

	public List<String> getSearchProductsModel(){
		
		ProductDisplayPage productPage = new ProductDisplayPage();
		
		List<String> productCodeList = new ArrayList<>(); 
		
		for(WebElement e : searchProductTitles)
		 {
			 e.click();
			 String productCode = productPage.getProductModelTexts();
			 productCodeList.add(productCode);
			 productPage.backToPreviousPage();
			 
		 }
		
		return productCodeList;
		
	}

	public boolean isNumberOfResultsShowWork(int NumberOfResult)
	{
		Select dropdown = new Select(NumberOfResultShowDropdown);
		dropdown.selectByContainsVisibleText(Integer.toString(NumberOfResult));

		String showingText = getDriver().findElement(By.xpath("//div[@class='row']/div[@class='col-sm-6 text-right']")).getText();
		//System.out.println(showingText);

		Pattern pattern = Pattern.compile("(\\d+)\\s+Pages\\)");
		Matcher matcher = pattern.matcher(showingText);

		if (matcher.find()) {
			int totalPage = Integer.parseInt(matcher.group(1));
			//System.out.println("Total pages: " + totalPage);

			for(int i = 1; i <= totalPage; i++){
				if(i > 1){
					WebElement activePage = getDriver().findElement(By.xpath("//ul[@class='pagination']//a[contains(text(),'"+ i +"')]"));
					activePage.click();
				}

				if(i < totalPage && searchResultItems.size() < NumberOfResult){
					return false;
				}
			}

		}

		return true;
    }

}
