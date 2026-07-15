package testCases.Logout;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ThreadGuard;
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
			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage actions
			LoginPage lp = new LoginPage();
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			Thread.sleep(2000);
			
			//save cookies after login
			Set<Cookie> savedCookies = getDriver().manage().getCookies();
			
			getDriver().quit();
			
			//Re-initialize the driver variable with a brand new session(use Firefox/Edge since Chrome block cookie setting )
			WebDriver newDriver = ThreadGuard.protect(new EdgeDriver());
			BaseClass.driver.set(newDriver);
			getDriver().get("https://tutorialsninja.com/demo/index.php?route=account/account");
			
			Thread.sleep(2000);
			
			//Add savedCookies back to new session	
			for (Cookie cookie : savedCookies) {
				getDriver().manage().addCookie(cookie);
			}
			
			//refresh page
			getDriver().navigate().refresh();
			
			Thread.sleep(2000);
			
			// MyAccountPage actions
			MyAccountPage map = new MyAccountPage();
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
