package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_024_RegistrationWithoutConfirmPasswordTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_registration_without_filling_passwordConfirm() {

		logger.info("******* Starting TC_RF_024_RegistrationWithoutConfirmPasswordTest *******");

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
			//rp.setPasswordConfirm(pwd);

			rp.clickPrivacyPolicy();
			rp.clickContinue();

			boolean warningDisplay = rp.isWarningDisplayed(rp.getPasswordConfirmWarning());

			Assert.assertTrue(warningDisplay, "the warning was not displayed");

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_RF_024_RegistrationWithoutConfirmPasswordTest *******");

	}

}
