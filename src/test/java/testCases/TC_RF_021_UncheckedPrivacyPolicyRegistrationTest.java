package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_021_UncheckedPrivacyPolicyRegistrationTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_registration_without_checking_privacy_policy_checkbox() {

		logger.info("******* Starting TC_RF_021_UncheckedPrivacyPolicyRegistrationTest *******");

		
		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage();
			rp.setFirstName(randomString());
			rp.setLastName(randomString());

			rp.setEmail(randomAlphaNumberString() + "@gmail.com");

			rp.setTelephone(randomNumber());

			String pwd = p.getProperty("password");
			rp.setPassword(pwd);
			rp.setPasswordConfirm(pwd);
			
			rp.clickContinue();

			boolean warningDisplay = rp.isWarningDisplayed(rp.getPolicyWarning());

			Assert.assertTrue(warningDisplay, "the warning was not displayed");

		} catch (Exception e) {

			Assert.fail();
			logger.debug(e.getMessage());

		}
		
		logger.info("******* Finished TC_RF_021_UncheckedPrivacyPolicyRegistrationTest *******");


	}

}
