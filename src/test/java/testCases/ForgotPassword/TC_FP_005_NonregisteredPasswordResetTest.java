package testCases.ForgotPassword;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_005_NonregisteredPasswordResetTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void non_registration_account_reset_password() throws IOException, MailosaurException {

		logger.info("******* Starting TC_FP_005_PreloginLogoutOptionTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickForgottenPassword();

			ForgotPasswordPage fp = new ForgotPasswordPage();
			fp.setEmail("nonreg@gmail.com");
			fp.clickContinue();

			String alert = wait.until(ExpectedConditions.visibilityOf(fp.getAlertBanner())).getText();
			
			Assert.assertEquals(alert, "An email with a confirmation link has been sent your email address.", "Incorrect process visual cue display!");

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_005_PreloginLogoutOptionTest *******");

	}

}
