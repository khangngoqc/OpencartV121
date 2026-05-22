package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgottenPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_006_ForgottenPasswordLinkTest extends BaseClass {

	@Test(groups = { "master", "login" })
	public void validate_forgotten_password() {
		logger.info("***Starting TC_LF_006_ForgottenPasswordLinkTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			logger.info("validate login page url");
			Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=account/login", "Failed to get to the Login Page!");
			
			LoginPage lp = new LoginPage(driver);
			boolean linkDisplay = lp.getLnkForgottenPassword().isDisplayed();
			logger.info("validate forgotten password link displayment");
			Assert.assertEquals(linkDisplay, true, "The Forgotten Password link does not display!");
			
			//navigate to Forgotten Password page
			lp.getLnkForgottenPassword().click(); 
			
			ForgottenPasswordPage fpp = new ForgottenPasswordPage(driver);
			boolean headingDisplay = fpp.getPageHeading().isDisplayed();
			logger.info("validate page heading display on Forgotten Password page");
			Assert.assertEquals(headingDisplay, true, "Failed to get to the Forgotten Password Page!");
			
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finsihed TC_LF_006_ForgottenPasswordLinkTest ***");

	}
}
