package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_019_LoginPageLinksTest extends BaseClass {

	@Test(groups = {"login", "master"})
	public void verify_loginpage_links() {
		logger.info("***Starting TC_LF_019_LoginPageLinksTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			

			// LoginPage actions
			LoginPage lp = new LoginPage();
			lp.clickContine();
			
			AccountRegistrationPage rp = new AccountRegistrationPage();
			Assert.assertEquals(rp.getPageTitle(), "Register Account", "Navigated to Account Registration Page Failed! "); //ER-1
			
			
			rp.clickLoginPageLink();
			
			boolean linksStatus = brokenLinksCheck();

			
			Assert.assertEquals(linksStatus, true, "Broken link detected! "); //ER-2

			
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LF_019_LoginPageLinksTest ***");

	}

}
