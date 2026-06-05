package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LG_001_LogoutByHeaderMenuTest extends BaseClass {

	@Test(groups = {"logout", "master"})
	public void verify_logout() {
		logger.info("***Starting TC_LG_001_LogoutByHeaderMenuTest ***");

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
			map.clickMyAccount();
			map.clickLogoutMA();
			
			LogoutPage lop = new LogoutPage(driver);
			lop.clickMyAccount();
			
			//logout validation
			Assert.assertEquals(lop.getLnkLoginMA().isDisplayed(), true, "Logout Failed");

			lop.clickContinue();
			
			//homepage navigate validation
			if(driver.getCurrentUrl().contains("home")){
				Assert.assertTrue(true, "Fail to navigate to Homepage!");
				
			}
			
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LG_001_LogoutByHeaderMenuTest ***");

	}

}
