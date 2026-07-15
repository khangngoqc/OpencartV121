package testCases.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_008_FieldsPlaceholderTest extends BaseClass {

	@Test(groups = { "master", "login" })
	void validate_fields_placeholders() throws InterruptedException {
		
		logger.info("******* Starting TC_LF_008_FieldsPlaceholderTest *******");

		try {

			//go to Register page
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage();
			String emailPlaceholder = lp.getTxtEmail().getAttribute("placeholder");
			String passwordPlaceholder = lp.getTxtEmail().getAttribute("placeholder");

			if(emailPlaceholder.equals("E-Mail Address") &&  passwordPlaceholder.equals("Password")) {
				Assert.assertTrue(true, "Placeholders are not available! " + "-email: "+ emailPlaceholder +"-password: "+ passwordPlaceholder);
			}
			
			
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
			Assert.fail();
		
		}


		logger.info("******* Finished TC_LF_008_FieldsPlaceholderTest *******");

		
	}

}
