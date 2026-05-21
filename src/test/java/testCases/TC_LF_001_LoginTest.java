package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_001_LoginTest extends BaseClass {

	@Test(groups = {"Sanity", "Master"})
	public void verify_login() {
		logger.info("***Starting TC002_LoginTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage actions
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// MyAccountPage actions
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountHeadingExist();

			// validation
			Assert.assertEquals(targetPage, true, "Login Failed");
			// Assert.assertTrue(targetPage);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***Finished TC002_LoginTest ***");

	}

}
