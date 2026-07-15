package testCases.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_014_CopyingPasswordTxtTest extends BaseClass {

	@Test(groups = { "master", "login" })
	void validate_password_copy_function_blocked() {

		logger.info("******* Starting TC_LF_014_CopyingPasswordTxtTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();

			String pwd = p.getProperty("password");
			lp.setPassword(pwd);

			act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

			act.moveToElement(getDriver().findElement(By.xpath("//input[@id='input-email']"))).click();

			act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

			String input = lp.getTxtEmail().getAttribute("value");

			if (input.equals(pwd)) {
				Assert.assertTrue(false, "password input copy action is available! " + input);
			} else {
				Assert.assertTrue(true);
			}

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_LF_014_CopyingPasswordTxtTest *******");

	}

}
