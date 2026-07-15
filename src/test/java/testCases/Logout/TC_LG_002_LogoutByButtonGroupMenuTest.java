package testCases.Logout;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LG_002_LogoutByButtonGroupMenuTest extends BaseClass {

	@Test(groups = {"logout", "master"})
	public void verify_logout_through_btn_group() {
		logger.info("***Starting TC_LG_002_LogoutByButtonGroupMenuTest ***");

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
			map.clickMyAccount();
			map.clickLogoutBtnGrp();
			
			LogoutPage lop = new LogoutPage();
			lop.clickMyAccount();
			
			//logout validation
			Assert.assertEquals(lop.getLnkLoginMA().isDisplayed(), true, "Logout Failed");

			lop.clickContinue();
			
			//homepage navigate validation
			if(getDriver().getCurrentUrl().contains("home")){
				Assert.assertTrue(true, "Fail to navigate to Homepage!");
				
			}
			
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LG_002_LogoutByButtonGroupMenuTest ***");

	}

}
