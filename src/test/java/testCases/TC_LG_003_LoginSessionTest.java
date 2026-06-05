package testCases;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LG_003_LoginSessionTest extends BaseClass {

	@Test(groups = {"logout", "master"})
	public void verify_login_browser_session() {
		logger.info("***Starting TC_LG_003_LoginSessionTest ***");

		try {
			// HomePage actions
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage actions
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			Thread.sleep(2000);
			
			//save cookies after login
			Set<Cookie> savedCookies = driver.manage().getCookies();
			
			driver.quit();
			
			//Re-initialize the driver variable with a brand new session(use Firefox/Edge since Chrome block cookie setting )
			driver = new EdgeDriver();
			driver.get("https://tutorialsninja.com/demo/index.php?route=account/account");
			
			Thread.sleep(2000);
			
			//Add savedCookies back to new session	
			for (Cookie cookie : savedCookies) {
				driver.manage().addCookie(cookie);
			}
			
			//refresh page
			driver.navigate().refresh();
			
			Thread.sleep(2000);
			
			// MyAccountPage actions
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountHeadingExist();

			// validation
			Assert.assertEquals(targetPage, true, "User session was not saved");
			// Assert.assertTrue(targetPage);

		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LG_003_LoginSessionTest ***");

	}

}
