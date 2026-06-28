package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_016_ForgottenPasswordEmailPlaceholderTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void email_field_placeholder_validation()  {

		logger.info("******* Starting TC_FP_016_ForgottenPasswordEmailPlaceholderTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickForgottenPassword();

			//Check for email field placeholder value
			ForgotPasswordPage fp = new ForgotPasswordPage();
			String placeholder = fp.getPlaceholderValue(fp.getTxtEmailAddress());
			
			Assert.assertEquals(placeholder, "E-Mail Address", "Incorrect field placeholder display!");

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_016_ForgottenPasswordEmailPlaceholderTest *******");

	}

}
