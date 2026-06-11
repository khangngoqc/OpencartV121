package testCases;

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

public class TC_LG_004_LogoutAndBackingTest extends BaseClass {

	@Test(groups = {"logout", "master"})
	public void verify_logout_backing() {
		logger.info("***Starting TC_LG_004_LogoutAndBackingTest ***");

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

			MyAccountPage mac = new MyAccountPage();
			mac.clickLogoutBtnGrp();
			
			Thread.sleep(1000);
			
			//backing on browser
			getDriver().navigate().back();;
			
			Thread.sleep(1000);
			
			//refresh page
			getDriver().navigate().refresh();
			
			Thread.sleep(2000);
			
			boolean targetPage = getDriver().getCurrentUrl().contains("login");

			// validation
			Assert.assertEquals(targetPage, true, "User should not get logged in.");

			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			Assert.fail();
		}

		logger.info("***Finished TC_LG_004_LogoutAndBackingTest ***");

	}

}
