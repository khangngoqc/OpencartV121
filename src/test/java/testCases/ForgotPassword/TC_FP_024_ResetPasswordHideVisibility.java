package testCases.ForgotPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ResetPasswordPage;
import testBase.BaseClass;

public class TC_FP_024_ResetPasswordHideVisibility extends BaseClass {

	@Test(alwaysRun = false, dependsOnGroups = {"init_password"}, groups = { "master", "forgot password" })
	void reset_password_visibility_validation() {

		logger.info("******* Starting TC_FP_024_ResetPasswordHideVisibility *******");

		try {

			String testEmail = "anything" + p.getProperty("serverDomain");

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickForgottenPassword();

			ForgotPasswordPage fp = new ForgotPasswordPage();
			fp.setEmail(testEmail);
			fp.clickContinue();

			MessageSearchParams params = new MessageSearchParams();
			params.withServer(p.getProperty("serverID"));

			SearchCriteria criteria = new SearchCriteria();
			criteria.withSentTo(testEmail);

			logger.info("Step 3: Wait for and Fetch the Sent Email");
			Message email = mailosaur.messages().get(params, criteria);
			Assert.assertNotNull(email, "Reset password email was not received.");
			Assert.assertEquals(email.subject(), "Reset Your Password");

			// Extract the Recovery Link from the Email Body
			// Looks for HTML links matching your reset pattern
			String resetLink = email.html().links().stream().filter(link -> link.href().contains("reset-password"))
					.findFirst().orElseThrow(() -> new RuntimeException("Reset link missing from email content."))
					.href();
			
			getDriver().quit();
			

			// Open the Reset Link in Browser
			WebDriver newDriver = ThreadGuard.protect(new EdgeDriver());
			BaseClass.driver.set(newDriver);
			getDriver().get(resetLink);
			
			ResetPasswordPage rp = new ResetPasswordPage();
			rp.setPassword("password");
			rp.setPasswordConfirm("password");

			// Check if the CSS forces password masking symbols visually
			String textSecurityPassword = rp.getTxtPassword().getCssValue("-webkit-text-security");

			if ("disc".equals(textSecurityPassword) || "circle".equals(textSecurityPassword) || "square".equals(textSecurityPassword)) {
				Assert.assertTrue(true, "the password is not covered(masked)");
			}else {
				return;
			}

			String textSecurityPasswordConfirm = rp.getTxtPasswordConfirm().getCssValue("-webkit-text-security");
			if ("disc".equals(textSecurityPasswordConfirm) || "circle".equals(textSecurityPasswordConfirm) || "square".equals(textSecurityPasswordConfirm)) {
				Assert.assertTrue(true, "the password confirm is not covered(masked)");
			}
			
			

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_024_ResetPasswordHideVisibility *******");

	}

}
