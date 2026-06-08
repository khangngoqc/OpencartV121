package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_003_InvalidEmailLoginTest extends BaseClass {

	@Test(groups = { "login", "master", "functionality" })
	public void verify_login_with_invalid_email() {
		logger.info("***Starting TC_LF_003_InvalidEmailLoginTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage actions
			LoginPage lp = new LoginPage();
			lp.setEmail("invalid@gmail.com");
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			boolean warning = lp.getLoginWaring().isDisplayed();
			Assert.assertEquals(warning, true, "Warning does not display!");

			// MyAccountPage actions
			MyAccountPage map = new MyAccountPage();
			boolean targetPage = map.isMyAccountHeadingExist();

			// validation
			Assert.assertEquals(targetPage, false, "Login bypassed with invalid email.");
			// Assert.assertTrue(targetPage);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LF_003_InvalidEmailLoginTest ***");

	}

}
