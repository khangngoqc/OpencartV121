package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_022_ProductComparePageHeadingURLTitleTest extends BaseClass {

	@Test(groups = { "master", "logout", "product compare" })
	void validate__heading_url_title() {
		
		String searchKeyword = "iMac";

		logger.info("******* Starting TC_PC_022_BreadscrumbHeadingURLTitleTest *******");

		try {

			HomePage hp = new HomePage();
			hp.setSearchInput(searchKeyword);
			SearchPage sp = hp.clickSearch();
			
			sp.clickCompareThisProductBtn();
			ProductComparePage cp = sp.clickProductCompareLink();
			
			Assert.assertTrue(cp.isPageHeadingDisplayed(), "Incorrect page heading!");
			Assert.assertTrue(cp.isPageTitleDisplayed("Product Comparison"), "Incorrect page title!");
			Assert.assertTrue(cp.isPageURLDisplayed("compare"), "Incorrect page url display!");
		
			
		} catch (Exception e) {

			logger.debug(e.getMessage());
			Assert.fail();

		}

		logger.info("******* Finished TC_PC_022_BreadscrumbHeadingURLTitleTest *******");

	}

}
