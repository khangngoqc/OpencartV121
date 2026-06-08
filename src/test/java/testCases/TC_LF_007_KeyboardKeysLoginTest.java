package testCases;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_007_KeyboardKeysLoginTest extends BaseClass {

	@Test(groups = { "login", "master" })
	public void verify_login_with_keyboard_keys() {
		logger.info("***Starting TC_LF_007_KeyboardKeysLoginTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			// navigate to Email input field
			for (int i = 0; i < 23; i++) {
				act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			}

			// input email
			act.sendKeys(p.getProperty("email")).perform();

			// navigate to password input field
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

			// input password
			act.sendKeys(p.getProperty("password")).perform();

			// navigate to Login button
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

			act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

			// MyAccountPage actions
			MyAccountPage map = new MyAccountPage();
			boolean targetPage = map.isMyAccountHeadingExist();

			// validation
			Assert.assertEquals(targetPage, true, "Login Failed");
			
			
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LF_007_KeyboardKeysLoginTest ***");

	}

}
