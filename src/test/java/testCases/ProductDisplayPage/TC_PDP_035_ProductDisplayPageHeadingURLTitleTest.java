package testCases.ProductDisplayPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PDP_035_ProductDisplayPageHeadingURLTitleTest extends BaseClass {

	String searchInput = "iMac";
	
	@Test(groups = { "master", "product display" })
	void validate__heading_url_title() {
		

		logger.info("******* Starting TC_PDP_035_ProductDisplayPageHeadingURLTitleTest *******");

		try {

			HomePage hp = new HomePage();
			SearchPage sp = hp.searchAProduct(searchInput);

			
			sp.clickCompareThisProductBtn();
			ProductDisplayPage dp = sp.clickFirstProductTitle();
			
			Assert.assertTrue(dp.isPageHeadingDisplayed(), "Incorrect page heading!");
			Assert.assertTrue(dp.isPageTitleDisplayed(searchInput), "Incorrect page title!");
			Assert.assertTrue(dp.isPageURLDisplayed("product/product"), "Incorrect page url display!");
		
			
		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_PDP_035_ProductDisplayPageHeadingURLTitleTest *******");

	}

}
