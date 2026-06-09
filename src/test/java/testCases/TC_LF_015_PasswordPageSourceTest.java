package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_015_PasswordPageSourceTest extends BaseClass {

	@Test(groups = { "master", "login" })
	void validate_password_copy_function_blocked() {

		logger.info("******* Starting TC_LF_015_PasswordPageSourceTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();

			String pwd = p.getProperty("password");
			lp.setPassword(pwd);

			String inputType = lp.getTxtPassword().getAttribute("type");
			logger.info(inputType);
			
			String pageSource = getDriver().getPageSource();
			
			if (inputType.equals("password") && !pageSource.contains(pwd)) {
				Assert.assertTrue(true);
			}else{
				Assert.assertTrue(false, "Validation Failed: Password field is clear text!");
			}
			

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_LF_015_PasswordPageSourceTest *******");

	}

}
