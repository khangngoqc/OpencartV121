package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_020_ProductDisplayPageProductComparisonTest extends BaseClass {

	String searchInput = "iMac";

	@Test(groups = { "master", "product display" })
	public void validate_product_comparison() throws InterruptedException {
		try {
			logger.info("***Starting TC_PDP_020_ProductDisplayPageProductComparisonTest ***");

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
			
			dp.clickProductComparisonBtn();
			
			Assert.assertTrue(dp.isComparisonSuccessAlertDisplay(), "Unexpected alert message! | ");
			
			ProductComparePage pcp = dp.clickAlertProductComparisonProductLink();

			Assert.assertTrue(pcp.isPageHeadingDisplay() && pcp.isProductAdded(searchInput), "Failed to locate page heading! | ");
			Assert.assertTrue(pcp.isProductAdded(searchInput), "Failed to locate compared product! | ");
			
			logger.info("***Finished TC_PDP_020_ProductDisplayPageProductComparisonTest ***");

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
