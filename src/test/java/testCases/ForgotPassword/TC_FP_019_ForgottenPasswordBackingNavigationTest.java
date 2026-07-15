package testCases.ForgotPassword;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_019_ForgottenPasswordBackingNavigationTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void forgotten_password_backing_navigation_validation() {

		logger.info("******* Starting TC_FP_019_ForgottenPasswordBackingNavigationTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickForgottenPassword();

			Thread.sleep(1000);
			
			ForgotPasswordPage fp = new ForgotPasswordPage();
			
			getDriver().navigate().back();
			
			assertTrue(getDriver().getCurrentUrl().contains("login"), "Falied to navigate back to Login page!");


		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_019_ForgottenPasswordBackingNavigationTest *******");

	}

}
