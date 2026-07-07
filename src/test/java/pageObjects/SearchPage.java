package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {

	public SearchPage() {
		super();
	}

	@FindBy(xpath = "//input[@placeholder='Search']") WebElement searchTxtbox;
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']") WebElement alertBanner;
	
	@FindBy(xpath = "//div[@class='caption']//h4")
	List <WebElement> searchProductTitles;
	
	@FindBy(xpath = "//button[@id='list-view']") WebElement listViewBtn;
	@FindBy(xpath = "//button[@id='grid-view']") WebElement gridViewBtn;
	@FindBy(xpath = "//button//span[normalize-space()='Add to Cart']") WebElement addToCartBtn;
	@FindBy(xpath = "//button[@data-original-title='Add to Wish List']") WebElement addToWishListBtn;
	@FindBy(xpath = "//button[@data-original-title='Compare this Product']") WebElement compareThisProductBtn;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement resultMessage;
	
	@FindBy(xpath = "//input[@id='input-search']") WebElement searchCriteriaTxtbox;
	@FindBy(xpath = "//input[@id='button-search']") WebElement searchBtn;
	@FindBy(xpath = "//select[@name='category_id']") WebElement categoryDropdown;
	@FindBy(xpath = "//input[@name='sub_category']") WebElement subCategoryCheckbox;
	
	@FindBy(xpath="//div/a[contains(text(),'Product Compare')]") WebElement compareProductLink;
	


	public boolean isSearchProductExist(String productName) {

		try {
			
			for (WebElement element : searchProductTitles) {
				if(element.getText().contains(productName)) {
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
		if(subCategoryCheckbox.isSelected()) {
			return;
		}else {
			subCategoryCheckbox.click();			
		}
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
	public boolean isAlertBannerDisplayed() {
		return alertBanner.isDisplayed();
	}
	
	public String getAlertBannerText() {
		return alertBanner.getText();
	}
	
	public boolean isListViewEnable() {
		return getDriver().findElement(By.xpath("//div[@class='row']//div[contains(@class,'product-layout product-list')]")).isDisplayed();
	}
	
	public boolean isListGridEnable() {
		return getDriver().findElement(By.xpath("//div[@class='row']//div[contains(@class,'product-layout product-grid')]")).isDisplayed();
	}
	
	public boolean isCompareProductLinkDisplayed() {
		return isDisplay(compareProductLink);
	}
	
}
