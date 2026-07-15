package testCases.Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_021_BreadscrumbHeadingURLTitleTest extends BaseClass {

	@Test(groups = { "master", "login" })
	void validate_breadcrumbs_heading_url_title() {

		logger.info("******* Starting TC_LF_021_BreadscrumbHeadingURLTitleTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			
			LoginPage lp = new LoginPage();
			
			List<WebElement> breadcrumbsLinks = getDriver().findElements(By.xpath("//ul[@class='breadcrumb']//a"));

			logger.info("validate breadcrumbs links...");
			for (WebElement a : breadcrumbsLinks) {
				
				logger.info(a.getText());
				Assert.assertTrue(a.isDisplayed(), "One of the breadcrumbs is not displayed! " + a.getText());
				
			}
			
			logger.info("validate Page Heading...");
			if(lp.getHeadingReturningCustomer().isDisplayed()) {
				Assert.assertTrue(true, "Returning Custormer heading is not displayed! " + lp.getHeadingReturningCustomer().getText());
			}
			
			if(lp.getHeadingNewCustomer().isDisplayed()) {
				Assert.assertTrue(true, "New Custormer heading is not displayed! " + lp.getHeadingNewCustomer().getText());
			}
			
			
			logger.info("validate Page URL...");
			if(getDriver().getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/login")) {
				Assert.assertTrue(true, "Page URL is not displayed! " + getDriver().getCurrentUrl());
			}
			
			logger.info("validate Page Title...");
			if(getDriver().getTitle().equals("Account Login")) {
				Assert.assertTrue(true, "Page Title is not displayed! " + getDriver().getTitle());
			}
			
			
				
		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_LF_021_BreadscrumbHeadingURLTitleTest *******");

	}

}
