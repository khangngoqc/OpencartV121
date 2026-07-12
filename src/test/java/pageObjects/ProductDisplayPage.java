package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage{
	
	public ProductDisplayPage() {
		super();
	}
	
	@FindBy(xpath="//li[contains(normalize-space(),'Product Code')]") WebElement productModalText;
	
	
	public String getProductModelTexts() {
		
		String productCode = productModalText.getText().split(":")[1].trim();
		
		return productCode;
	}

	
}
