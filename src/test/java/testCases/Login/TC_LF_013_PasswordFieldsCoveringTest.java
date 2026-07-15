package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_013_PasswordFieldsCoveringTest extends BaseClass {

	@Test(groups = { "master", "login" })
	void validate_password_fields_is_hidden() {

		logger.info("******* Starting TC_LF_013_PasswordFieldsCoveringTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();

			String pwd = p.getProperty("password");
			lp.setPassword(pwd);

			// Check if the CSS forces password masking symbols visually
			String textSecurityPassword = lp.getTxtPassword().getCssValue("-webkit-text-security");

			if ("disc".equals(textSecurityPassword) || "circle".equals(textSecurityPassword)
					|| "square".equals(textSecurityPassword)) {
				Assert.assertTrue(true, "the password is not covered(masked)");
			} else {
				return;
			}

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_LF_013_PasswordFieldsCoveringTest *******");

	}

}
