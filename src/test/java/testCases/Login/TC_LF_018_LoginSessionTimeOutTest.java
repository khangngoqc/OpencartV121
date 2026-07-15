package testCases.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_018_LoginSessionTimeOutTest extends BaseClass {

	@Test(groups = {"login", "master"})
	public void verify_login_login_session_timeout() {
		logger.info("***Starting TC_LF_018_LoginSessionTimeOutTest ***");

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
			//check session cookie is not null
			Cookie validCookie = getDriver().manage().getCookieNamed("OCSESSID");
			Assert.assertNotNull(validCookie, "OCSESSID cookie should exist after login");
			//insert invalid cookie
			Cookie expiredCookie = new Cookie("OCSESSID", "INVALID_EXPIRED_SESSION_ID_12345");
			getDriver().manage().addCookie(expiredCookie);
						
			
			//refresh page
			getDriver().navigate().refresh();
			
			// validation
			boolean isErrorDisplayed = getDriver().findElement(By.xpath("//*[contains(text(), 'Invalid session ID')]")).isDisplayed();
			//logger.info(isErrorDisplayed);
			
			boolean isRedirectToLogin = getDriver().getCurrentUrl().contains("route=account/login");
			Assert.assertEquals((isRedirectToLogin || isErrorDisplayed), true , "Application failed to handle the expired/invalid login session correctly!");

			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LF_018_LoginSessionTimeOutTest ***");

	}

}
