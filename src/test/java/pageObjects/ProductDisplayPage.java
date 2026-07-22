package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage{
	
	public ProductDisplayPage() {
		super();
	}
	
	@FindBy(xpath="//li[contains(normalize-space(),'Product Code')]") WebElement productModalText;
	@FindBy(xpath = "//a[normalize-space()='product comparison']")
    WebElement alerProductComparisonLink;
	
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement alertBanner;
    
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
	
	   public void clickCompareThisProductBtn() {
	        click(compareThisProductBtn);
	    }

	    public ProductComparePage clickAlertProductComparisonProductLink() {
	        click(alerProductComparisonLink);
	        return new ProductComparePage();
	    }

	    //validations
	    public boolean isCompareThisProductBtnTooltipWork() throws InterruptedException {
	        return isHoveringTooltipWork(compareThisProductBtn, "Compare this Product");
	    }

	    public boolean isHoveringTooltipWork(WebElement e, String text) throws InterruptedException {
	        ((JavascriptExecutor) getDriver()).executeScript(
	                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", e);

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

	        if (!successMessage.contains("Success: You have added " + getFirstProductTitle() + " to your product comparison!")) {
	            return false;
	        }

	        return true;
	    }

	    //getters
	    public String getFirstProductTitle() {
	        return firstProductTitle.getText();
	    }

	
}
