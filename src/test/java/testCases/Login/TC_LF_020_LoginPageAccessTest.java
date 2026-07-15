package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_020_LoginPageAccessTest extends BaseClass {

	@Test(groups = {"login", "master"})
	public void verify_loginpage_access_links() {
		logger.info("***Starting TC_LF_020_LoginPageAccessTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage rp = new AccountRegistrationPage();
			rp.clickLoginPageLink();

			LoginPage lp = new LoginPage();
			Assert.assertEquals(lp.getPageTitle(), "Account Login", "Navigated to Login Page through Registration Page Failed! ");
			
			lp.clickLoginBtnGrp();
			Assert.assertEquals(lp.getPageTitle(), "Account Login", "Navigated to Login Page through Login option from the Right Column options Failed! "); 
			
			lp.clickMyAccount();
			lp.clickLoginMA();
			Assert.assertEquals(lp.getPageTitle(), "Account Login", "Navigated to Login Page through Login option from the My Account menu Failed! "); 
			

			
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LF_020_LoginPageAccessTest ***");

	}

}
