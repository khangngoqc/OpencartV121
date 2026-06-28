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
			
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage();
			
			//store label elements in to a List collection
			boolean isMarked = rp.mandatoryFieldsMarked();
			
			Assert.assertTrue(isMarked, "Mandatory field is not marked!");
						
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		
		logger.info("******* Finished TC_RF_014_RequiredMarkTest *******");
		
	}

}
