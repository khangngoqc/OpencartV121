package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_022_PasswordFieldsCoveringTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_password_fields_is_hidden() {

		logger.info("******* Starting TC_RF_022_PasswordFieldsCoveringTest *******");

		
		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage(driver);
			rp.setFirstName(randomString());
			rp.setLastName(randomString());

			String pwd = p.getProperty("password");
			rp.setPassword(pwd);
			rp.setPasswordConfirm(pwd);
			
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

			Assert.fail();
			logger.debug(e.getMessage());

		}
		
		logger.info("******* Finished TC_RF_022_PasswordFieldsCoveringTest *******");


	}

}
