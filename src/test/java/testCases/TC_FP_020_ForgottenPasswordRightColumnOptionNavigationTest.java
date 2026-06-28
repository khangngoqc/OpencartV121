package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_020_ForgottenPasswordRightColumnOptionNavigationTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void forgotten_password_rightColumnOption_navigation_validation() {

		logger.info("******* Starting TC_FP_020_ForgottenPasswordRightColumnOptionNavigationTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickBtnGrpForgottenPassword();

			Thread.sleep(1000);
			
			ForgotPasswordPage fp = new ForgotPasswordPage();
			
			
			assertTrue(getDriver().getCurrentUrl().contains("forgotten"), "Falied to navigate back to Forgotten Password page!");


		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_020_ForgottenPasswordRightColumnOptionNavigationTest *******");

	}

}
