package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {

	public SearchPage() {
		super();
	}

	@FindBy(xpath = "//div[@class='caption']//h4")
	List <WebElement> searchProductTitles;
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement resultMessage;
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement searchTxtbox;
	@FindBy(xpath = "//input[@id='input-search']") WebElement searchCriteriaTxtbox;
	@FindBy(xpath = "//input[@id='button-search']") WebElement searchBtn;
	@FindBy(xpath = "//select[@name='category_id']") WebElement categoryDropdown;
	@FindBy(xpath = "//input[@name='sub_category']") WebElement subCategoryCheckbox;


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
	
}
