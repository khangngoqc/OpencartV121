package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountEditPage;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_020_PolicyCheckboxTest extends BaseClass {

	@Test(groups = { "register", "master" })
	public void validate_policy_checkbox_status() {

		logger.info("******* Starting TC_RF_020_PolicyCheckboxTest *******");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Click on MyAccount link");

			hp.clickRegister();
			logger.info("Click on Register link");

			AccountRegistrationPage repage = new AccountRegistrationPage(driver);

			logger.info("Get check box status");
			boolean checkboxStatus =  repage.isPrivacyPolicyChecked();
						
			if (checkboxStatus == false) {
				Assert.assertTrue(true);	
			}else {
				Assert.fail();
				logger.info("The checkbox is checked");
			}
			
			
		
		} catch (Exception e) {
			logger.error("Test failed...");
			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_RF_020_PolicyCheckboxTest *******");

	}

}
