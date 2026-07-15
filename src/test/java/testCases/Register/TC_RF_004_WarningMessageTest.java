package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_004_WarningMessageTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void verify_required_field_warning() {
		
		logger.info("******* Starting TC_RF_004_WarningMessageTest *******");
		
		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage();
			rp.clickContinue();

			boolean[] warningsDiplayed = new boolean[] { rp.isWarningDisplayed(rp.getFirstNameWarning()),
					rp.isWarningDisplayed(rp.getLastNameWarning()), rp.isWarningDisplayed(rp.getEmailWarning()),
					rp.isWarningDisplayed(rp.getPasswordWarning()), rp.isWarningDisplayed(rp.getPolicyWarning())};
		
			for(boolean warning : warningsDiplayed) {
				//logger.debug(warning);
				Assert.assertTrue(warning, "One or more warning was not displayed");
			}

			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		
		}
	
		logger.info("******* Finished TC_RF_004_WarningMessageTest *******");
		
	}

}
