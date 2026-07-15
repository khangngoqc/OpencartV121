package testCases.Register;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_012_KeyboardKeysRegistrationTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_registration_with_Keyboard() throws InterruptedException {
		
		logger.info("******* Starting TC_RF_012_KeyboardKeysRegistrationTest *******");

		try {

			//go to Register page
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();
			
			// navigate to First Name field
			for (int i = 0; i < 23; i++) {
				act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			}

			// First name input
			act.sendKeys(randomString()).perform();

			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

			// Last name input
			act.sendKeys(randomString()).perform();

			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

			// Email input
			act.sendKeys(randomString() + "@gmail.com").perform();

			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

			// Telephone input
			act.sendKeys(randomNumber()).perform();

			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

			// password and password confirm input
			String password = randomAlphaNumberString();
			act.sendKeys(password).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			act.sendKeys(password).perform();
			
			//move to the policy checkbox
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			//tick the policy checkbox
			act.keyDown(Keys.SPACE).keyUp(Keys.SPACE).perform();
			//move to Continue button
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			
			act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

			AccountRegistrationPage rp = new AccountRegistrationPage();
			
			if (rp.getConfirmMessage().equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} 
			
			
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
			Assert.fail();
			
		
		}


		logger.info("******* Finished TC_RF_012_KeyboardKeysRegistrationTest *******");

		
	}

}
