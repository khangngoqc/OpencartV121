package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_011_ResetPasswordRightColumnTest extends BaseClass {

	@Test(alwaysRun = false, dependsOnGroups = {"init_password"}, groups = { "master", "forgot password" })
	public void reset_password_rightColumnOptions_validate() throws IOException, MailosaurException {

		logger.info("******* Starting TC_FP_011_ResetPasswordRightColumnTest *******");

		try {

			// String uniqueUser = "testuser_" + System.currentTimeMillis();
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

			//Locate right column options validation
			List<WebElement> rightColumnOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("column-options")));
			for (WebElement webElement : rightColumnOptions) {
				Assert.assertTrue(webElement.isDisplayed(), webElement.getText() + "option is missing!");
			}
			
			
			

		} catch (Exception e) {

			logger.info(e.getMessage());
			Assert.fail(e.getMessage());

		}

		logger.info("******* Finished TC_FP_011_ResetPasswordRightColumnTest *******");

	}

}
