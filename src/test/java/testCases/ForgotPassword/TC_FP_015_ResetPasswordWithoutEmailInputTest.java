package testCases.ForgotPassword;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_015_ResetPasswordWithoutEmailInputTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void non_email_input_reset_password()  {

		logger.info("******* Starting TC_FP_015_ResetPasswordWithoutEmailInputTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickForgottenPassword();

			//click continue without entering an email
			ForgotPasswordPage fp = new ForgotPasswordPage();
			fp.clickContinue();

			String alert = wait.until(ExpectedConditions.visibilityOf(fp.getAlertBanner())).getText();
			
			Assert.assertEquals(alert, "E-Mail must be between 4 and 20 characters!", "Incorrect process visual cue display!");

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_015_ResetPasswordWithoutEmailInputTest *******");

	}

}
