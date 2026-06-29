package testCases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_021_ForgottenPasswordBreadcrumbTest extends BaseClass {

	@Test(groups = { "master", "forgot password" })
	void forgotten_password_breadcrumb_validation() {

		logger.info("******* Starting TC_FP_021_ForgottenPasswordBreadcrumbTest *******");

		try {

			HomePage hp = new HomePage();
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage();
			lp.clickBtnGrpForgottenPassword();

			Thread.sleep(1000);
			
			ForgotPasswordPage fp = new ForgotPasswordPage();
			
			//Breadcrumb validation
			List<WebElement> breadcrumbsLinks = getDriver().findElements(By.xpath("//ul[@class='breadcrumb']//a"));

			logger.info("validate breadcrumbs links...");
			for (WebElement a : breadcrumbsLinks) {
				
				logger.info(a.getText());
				Assert.assertTrue(a.isDisplayed(), "One of the breadcrumbs is not displayed! " + a.getText());
				
			}
			

		} catch (Exception e) {

			Assert.fail(e.getMessage());

		}

		logger.info("*******Finished TC_FP_021_ForgottenPasswordBreadcrumbTest *******");

	}

}
