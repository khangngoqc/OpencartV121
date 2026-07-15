package testCases.Logout;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LG_008_LogoutLoginSequencingTest extends BaseClass {

	@Test(groups = {"logout", "master"})
	public void verify_login() {
		logger.info("***Starting TC_LG_008_LogoutLoginSequencingTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage actions
			LoginPage lp = new LoginPage();
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// MyAccountPage actions
			MyAccountPage map = new MyAccountPage();
			map.clickLogoutBtnGrp();

			LogoutPage lg = new LogoutPage();
			lg.clickMyAccount();
			lg.clickLogin();
			
			//login back with the same account
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			// validation
			boolean targetPage = map.isMyAccountHeadingExist();
			Assert.assertEquals(targetPage, true, "Same Account or Differnet Account should get loggedin.");

		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LG_008_LogoutLoginSequencingTest ***");

	}

}
