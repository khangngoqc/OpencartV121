package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_021_ProductDisplayPageSocialOptionsTest extends BaseClass {

	String searchInput = "iMac";

	@Test(groups = { "master", "product display" })
	public void validate_social_options() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_021_ProductDisplayPageSocialOptionsTest ***");

			HomePage hp = new HomePage();

			/*
			 * hp.clickMyAccount();
			 * 
			 * LoginPage lp = hp.clickLogin();
			 * 
			 * MyAccountPage map = lp.loginAs(p.getProperty("email"),
			 * p.getProperty("password"));
			 */
			
			SearchPage sp = hp.searchAProduct(searchInput);
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			Assert.assertTrue(dp.isSocialOptionsAvailable(), "Failed to locate any social interactive option on page!| ");
			
			logger.info("***Finished TC_PDP_021_ProductDisplayPageSocialOptionsTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
