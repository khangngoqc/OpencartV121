package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_012_InvalidLoginSpamTest extends BaseClass {

	@Test(groups = { "login", "master" })
	public void verify_invalid_login_spam() {
		logger.info("***Starting TC_LF_012_InvalidLoginSpamTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage actions
			LoginPage lp = new LoginPage();
			lp.setEmail(p.getProperty("email1"));
			lp.setPassword("invalidpassword");
			lp.clickLogin();

			String expWarning = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";

			for (int i = 0; i <= 4; i++) {
				lp.clickLogin();
			}

			String warning = lp.getLoginWaring().getText();
			
			// validation
			Assert.assertEquals(warning, expWarning, "multi falied login attempts did not display!");

		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LF_012_InvalidLoginSpamTest ***");

	}

}
