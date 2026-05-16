package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_014_RequiredMarkTest extends BaseClass {

	@Test(groups= {"register","master"})
	void validate_required_field_asterisk() {

		logger.info("******* Starting TC_RF_014_RequiredMarkTest *******");

		try {
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage(driver);
			
			//store label elements in to a List collection
			List<WebElement> requiredFieldLable = driver
					.findElements(By.xpath("//div[@class='form-group required']//label[@class='col-sm-2 control-label']"));


			for(WebElement e : requiredFieldLable) {
				
				//Execute JavaScript to get the property
				String script = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');";
				String requiredMark = (String) ((JavascriptExecutor) driver).executeScript(script, e);

				//logger.info(e.getText() + requiredMark);
				
				//check if the pseudo element of the label contains "*"
				if(!requiredMark.contains("*")) {
					Assert.fail();
					break;
				}
				
			}
			
			Assert.assertTrue(true);
						
		} catch (Exception e) {
			Assert.fail();
			logger.debug(e.getMessage());
		
		}
		
		
		logger.info("******* Finished TC_RF_014_RequiredMarkTest *******");
		
	}

}
