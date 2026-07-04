package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage() {
		super();
	}

	@FindBy(xpath = "//div[@class='caption']//h4")
	List <WebElement> searchProductTitles;
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement resultMessage;
	@FindBy(xpath ="//input[@placeholder='Search']") WebElement SearchTxtbox;
	@FindBy(xpath ="//input[@id='input-search']") WebElement SearchCriteriaTxtbox;
	@FindBy(xpath="//input[@id='button-search']") WebElement SearchBtn;


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
		return getPlaceholderValue(SearchTxtbox);
	}
	public String searchCriteriaPlaceholder() {
		return getPlaceholderValue(SearchCriteriaTxtbox);
	}
	
	public void inputSearchCriteria(String keyword) {
		SearchCriteriaTxtbox.sendKeys(keyword);
	}
	
	public void clickSearchBtn() {
		SearchBtn.click();
	}

}
