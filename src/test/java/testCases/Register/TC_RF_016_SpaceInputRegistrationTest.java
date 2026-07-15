package testCases.Register;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_016_SpaceInputRegistrationTest extends BaseClass{
	
	@Test(groups= {"register", "master"})
	void validate_registration_with_space_input() {
		
		logger.info("******* Starting TC_RF_016_SpaceInputRegistrationTest *******");
				
		try {
		
			//go to Register page
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage rp = new AccountRegistrationPage();
			String space = "          ";
			rp.setFirstName(space);
			rp.setLastName(space);
			rp.setEmail(space);
			rp.setTelephone(space);
			rp.setPassword(space);
			rp.setPasswordConfirm(space);
			rp.clickPrivacyPolicy();
			rp.clickContinue();
			

			boolean[] warningsDiplayed = new boolean[] { rp.isWarningDisplayed(rp.getFirstNameWarning()),
					rp.isWarningDisplayed(rp.getLastNameWarning()), rp.isWarningDisplayed(rp.getEmailWarning()),
					rp.isWarningDisplayed(rp.getPasswordWarning())};
		
			for(boolean warning : warningsDiplayed) {
				logger.debug(warning);
				Assert.assertTrue(warning, "One or more warning was not displayed");
			}
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}
		
		logger.info("******* Finished TC_RF_016_SpaceInputRegistrationTest *******");

	}

	
}
