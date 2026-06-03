package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "Regression", "Master" })
	public void verify_account_registration() {

		logger.info("******* Starting TC001_AccountRegistrationTest *******");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Click on MyAccount link");

			hp.clickRegister();
			logger.info("Click on Register link");

			AccountRegistrationPage repage = new AccountRegistrationPage(driver);

			logger.info("set registration details");
			repage.setFirstName(randomString().toUpperCase());
			repage.setLastName(randomString().toUpperCase());
			repage.setEmail(randomString() + "@gmail.com");
			repage.setTelephone(randomNumber());

			String password = randomAlphaNumberString();

			repage.setPassword(password);
			repage.setPasswordConfirm(password);

			repage.clickPrivacyPolicy();
			repage.clickContinue();

			logger.info("Validating expected message");

			String confmsg = repage.getConfirmMessage();

			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed...");
				logger.debug("Debug logs...");
				Assert.fail();
			}

			// Assert.assertEquals(confmsg, "Your Account Has Been Created!");

		} catch (Exception e) {
			logger.error("Test failed...");
			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC001_AccountRegistrationTest *******");

	}

}
