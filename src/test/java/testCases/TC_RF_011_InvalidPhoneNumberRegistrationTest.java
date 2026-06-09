package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_011_InvalidPhoneNumberRegistrationTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_registration_with_invalid_phone_number() {
		logger.info("******* Starting TC_RF_011_InvalidPhoneNumberRegistrationTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage();
			rp.setFirstName(randomString());
			rp.setLastName(randomString());

			rp.setEmail(randomString() + "@gmail.com");

			String pwd = p.getProperty("password");
			rp.setPassword(pwd);
			rp.setPasswordConfirm(pwd);

			rp.clickPrivacyPolicy();

			String[] invalidData = { "1111", "abcde" };

			for (String p : invalidData) {

				rp.setTelephone(p);
				rp.clickContinue();

				if (rp.getConfirmMessage().equals("Your Account Has Been Created!")) {
					Assert.fail("test failed with one invalid phone number available!");
					break;
				}

				rp.clearEmail();

			}

			Assert.assertTrue(true);

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_RF_011_InvalidPhoneNumberRegistrationTest *******");

	}

}
