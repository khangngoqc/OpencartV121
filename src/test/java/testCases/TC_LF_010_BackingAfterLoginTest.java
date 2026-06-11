package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_010_BackingAfterLoginTest extends BaseClass {

	@Test(groups = {"login", "master"})
	public void verify_backing_after_logout() {
		logger.info("***Starting TC_LF_010_BackingAfterLoginTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage actions
			LoginPage lp = new LoginPage();
			lp.setEmail(p.getProperty("email1"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// MyAccountPage actions
			MyAccountPage map = new MyAccountPage();
			map.clickLogoutBtnGrp();
			
			getDriver().navigate().back(); //backing on browser
			getDriver().navigate().refresh(); //refresh page to validate login status

			boolean targetPage = map.isMyAccountHeadingExist();

			// validation
			Assert.assertEquals(targetPage, false, "Logout faieled");

		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LF_010_BackingAfterLoginTest ***");

	}

}
