package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_008_ConfirmPasswordTest extends BaseClass {

	@Test(groups= {"master", "register"})
	void validate_different_confirm_password() {

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage(driver);
			rp.setFirstName(randomString());
			rp.setLastName(randomString());
			rp.setEmail(randomString() + "@gmail.com");
			rp.setTelephone(randomNumber());
			rp.setPassword("12345");
			rp.setPasswordConfirm("abcde");
			rp.clickPrivacyPolicy();

			rp.clickContinue();

			boolean warningsDisplay = rp.isWarningDisplayed(rp.getPasswordConfirmWarning());

			Assert.assertTrue(warningsDisplay);

		} catch (Exception e) {
			
			logger.error("Test failed...");
			logger.debug(e.getMessage());
			Assert.fail();
			
		}

	}

}
