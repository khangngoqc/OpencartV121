package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_016_ChangingPasswordLoginTest extends BaseClass {

	@Test(groups = { "master", "login" })
	void validate_login_after_changing_password() {

		logger.info("******* TC_LF_016_ChangingPasswordLoginTest *******");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			//login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email2"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			
			MyAccountPage mac = new MyAccountPage(driver);
			mac.clickChangePassword(); //go to Change Password page
			
			String newPwd = "newPassword";
			ChangePasswordPage cpp = new ChangePasswordPage(driver);
			cpp.setPassword(newPwd);
			cpp.setPasswordConfirm(newPwd);
			cpp.clickContinue(); // back to MyAccountPage
			
			mac.clickLogout(); // go to LogoutPage (logged out)
			
			LogoutPage lop = new LogoutPage(driver);
			lop.clickMyAccount();
			lop.clickLogin(); // go to LoginPage
			
			//try login with old password
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			//validate with old password
			logger.info("validate with old password");
			String warning = lp.getLoginWaring().getText();
			if(warning.equals("Warning: No match for E-Mail Address and/or Password.")) {
				Assert.assertTrue(true, "Warning did not display! " + warning);
			}else if(mac.isMyAccountHeadingExist()) {
				Assert.assertTrue(false, "Password was not reset! Login successfully with old password.");
				return;
			}
			
			//try login with new password
			logger.info("try login with new password");
			lp.getTxtPassword().clear();
			lp.setPassword(newPwd);
			lp.clickLogin();
			
			if(mac.isMyAccountHeadingExist()) {
				logger.info("validate MyAccountPage heading after loign with new password");
				Assert.assertTrue(true, "Login failed with new password! " + lp.getLoginWaring());	
			}
			

			
		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_LF_016_ChangingPasswordLoginTest *******");

	}

}
