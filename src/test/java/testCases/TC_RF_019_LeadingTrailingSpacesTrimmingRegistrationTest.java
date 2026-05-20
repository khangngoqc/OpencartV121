package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountEditPage;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_019_LeadingTrailingSpacesTrimmingRegistrationTest extends BaseClass {

	@Test(groups = { "register", "master" })
	public void verify_account_registration_with_leading_trailing() {

		logger.info("******* Starting TC_RF_019_LeadingTrailingSpacesTrimmingRegistrationTest *******");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Click on MyAccount link");

			hp.clickRegister();
			logger.info("Click on Register link");

			AccountRegistrationPage repage = new AccountRegistrationPage(driver);

			logger.info("set registration details");
			repage.setFirstName("   " + randomString().toUpperCase() + "   ");
			repage.setLastName("   " + randomString().toUpperCase() + "   ");
			repage.setEmail("   " + randomAlphaNumberString() + "@gmail.com" + "   ");
			repage.setTelephone("   " + randomNumber() + "   ");

			String password = randomAlphaNumberString();

			repage.setPassword(password);
			repage.setPasswordConfirm(password);

			repage.clickPrivacyPolicy();
			repage.clickContinue();
			
			repage.clickEditAccount();
			
			AccountEditPage aep = new AccountEditPage(driver);
			String[] infoFields = {
					aep.getValueAttribute(aep.getTxtFirstName()), 
					aep.getValueAttribute(aep.getTxtLastName()),
					aep.getValueAttribute(aep.getTxtEmail()),
					aep.getValueAttribute(aep.getTxtTelephone()),
					};
			
			for(String s : infoFields) {
				if (s.contains(" ")) {
					logger.debug("An info contains untrimmed spaces: " + s);
					Assert.assertTrue(false, "An info contains untrimmed spaces: " + s +" |");
					break;
					
				}
			}
			
			Assert.assertTrue(true);
			
		
		} catch (Exception e) {
			logger.error("Test failed...");
			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_RF_019_LeadingTrailingSpacesTrimmingRegistrationTest *******");

	}

}
