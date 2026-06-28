package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_018_ForgottenPasswordInvalidEmailInputTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void forgotten_password_invalid_email_input_validation() {

		logger.info("******* Starting TC_FP_018_ResetPasswordInvalidEmailInputTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickForgottenPassword();

			// input invalid emails 
			ForgotPasswordPage fp = new ForgotPasswordPage();

			String[] invalidEmail = { randomString(), randomString() + "@", randomString() + "@gmail" };
			

			for (String e : invalidEmail) {

				fp.setEmail(e);
				fp.clickContinue();

				String alert = wait.until(ExpectedConditions.visibilityOf(fp.getAlertBanner())).getText();

				Assert.assertEquals(alert, "E-Mail Address does not appear to be valid!", "Field level warning message informing the User to provide a valid formatted email address should be displayed");

				fp.clearEmail();
				
				Thread.sleep(2000);
				

			}


		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_018_ResetPasswordInvalidEmailInputTest *******");

	}

}
