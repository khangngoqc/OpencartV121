package testCases.Register;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_025_BreadscrumbHeadingURLTitleTest extends BaseClass {

	@Test(groups = { "master", "register" })
	void validate_breadcrumbs_heading_url_title() {

		logger.info("******* Starting TC_RF_025_BreadscrumbHeadingURLTitleTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickRegister();

			
			AccountRegistrationPage rp = new AccountRegistrationPage();
			
			List<WebElement> breadcrumbsLinks = getDriver().findElements(By.xpath("//ul[@class='breadcrumb']//a"));

			logger.info("validate breadcrumbs links...");
			for (WebElement a : breadcrumbsLinks) {
				
				//logger.info(a.getText());
				Assert.assertTrue(a.isDisplayed(), "One of the breadcrumbs is not displayed! " + a.getText());
				
			}
			
			logger.info("validate Page Heading...");
			if(rp.getPageHeading().isDisplayed()) {
				Assert.assertTrue(true, "Page Heading is not displayed! " + rp.getPageHeading().getText());
			}
			
			logger.info("validate Page URL...");
			if(getDriver().getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/register")) {
				Assert.assertTrue(true, "Page URL is not displayed! " + getDriver().getCurrentUrl());
			}
			
			logger.info("validate Page Title...");
			if(getDriver().getTitle().equals("Register Account")) {
				Assert.assertTrue(true, "Page Title is not displayed! " + getDriver().getTitle());
			}
			
			
			
			
		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_RF_025_BreadscrumbHeadingURLTitleTest *******");

	}

}
