package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_LG_005_MALogoutOptionTest extends BaseClass {

	@Test(groups = {"logout", "master"})
	public void verify_logout_btn_before_login () {
		logger.info("***Starting TC_LG_005_MALogoutOptionTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();

			boolean isLogoutAbsent = wait.until(ExpectedConditions.invisibilityOf(hp.getLnkLogout()));
			
			// validation
			Assert.assertEquals(isLogoutAbsent, true, "Logout option should not be displayed under 'My Account' menu.");

			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LG_005_MALogoutOptionTest ***");

	}

}
