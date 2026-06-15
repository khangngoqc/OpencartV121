package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LG_009_BreadscrumbHeadingURLTitleTest extends BaseClass {

	@Test(groups = { "master", "logout" })
	void validate_breadcrumbs_heading_url_title() {

		logger.info("******* Starting TC_LG_009_BreadscrumbHeadingURLTitleTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lg = new LoginPage();
			lg.setEmail(p.getProperty("email"));
			lg.setPassword(p.getProperty("password"));
			lg.clickLogin();

			MyAccountPage map = new MyAccountPage();
			map.clickLogoutBtnGrp();
			
			LogoutPage lp = new LogoutPage();
			
			List<WebElement> breadcrumbsLinks = getDriver().findElements(By.xpath("//ul[@class='breadcrumb']//a"));

			logger.info("validate breadcrumbs links...");
			for (WebElement a : breadcrumbsLinks) {
				
				//logger.info(a.getText());
				Assert.assertTrue(a.isDisplayed(), "One of the breadcrumbs is not displayed! " + a.getText());
				
			}
			
			logger.info("validate Page Heading...");
			if(lp.getLgHeading().isDisplayed()) {
				Assert.assertTrue(true, "Page Heading is not displayed! " + lp.getLgHeading().getText());
			}
			
			logger.info("validate Page URL...");
			if(getDriver().getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/logout")) {
				Assert.assertTrue(true, "Page URL is not displayed! " + getDriver().getCurrentUrl());
			}
			
			logger.info("validate Page Title...");
			if(getDriver().getTitle().equals("Account Logout")) {
				Assert.assertTrue(true, "Page Title is not displayed! " + getDriver().getTitle());
			}
			
		
			
		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_LG_009_BreadscrumbHeadingURLTitleTest *******");

	}

}
