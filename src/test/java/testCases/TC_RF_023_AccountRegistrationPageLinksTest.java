package testCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_RF_023_AccountRegistrationPageLinksTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_on_page_links() {

		logger.info("******* Starting TC_RF_023_AccountRegistrationPageLinksTest *******");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage rp = new AccountRegistrationPage(driver);
			
			boolean linksStatus = brokenLinksCheck();
			
			Assert.assertEquals(linksStatus, true, "Broken link dectected!");
			
			

		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_RF_023_AccountRegistrationPageLinksTest *******");

	}

}
