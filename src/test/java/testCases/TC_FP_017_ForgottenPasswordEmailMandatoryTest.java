package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_017_ForgottenPasswordEmailMandatoryTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void email_field_mandatory_marked_validation()  {

		logger.info("******* Starting TC_FP_017_ForgottenPasswordEmailMandatoryTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickForgottenPassword();

			//Check if the email field is marked with *
			ForgotPasswordPage fp = new ForgotPasswordPage();
			boolean isMarked = fp.mandatoryFieldsMarked();
			
			Assert.assertTrue(isMarked, "Mandatory field is not marked!");

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_017_ForgottenPasswordEmailMandatoryTest *******");

	}

}
