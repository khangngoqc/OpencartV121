package testCases.ForgotPassword;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_022_ForgottenPasswordLoginInputCarryOverTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void forgotten_password_loign_input_carry_over_validation() {

		logger.info("******* Starting TC_FP_022_ForgottenPasswordLoginInputCarryOverTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			String email = "myemail@gmail.com";
			lp.setEmail(email);
			
			lp.clickBtnGrpForgottenPassword();

			Thread.sleep(1000);
			
			ForgotPasswordPage fp = new ForgotPasswordPage();
			String input = fp.getElementText(fp.getTxtEmailAddress());
			
			Assert.assertEquals(input,email , "Login page input did not get carry over!");
			
			

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_022_ForgottenPasswordLoginInputCarryOverTest *******");

	}

}
