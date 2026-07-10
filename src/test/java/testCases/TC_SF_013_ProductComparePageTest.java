package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_013_ProductComparePageTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void product_comparison_navigate() {

		logger.info("******* Starting TC_SF_013_ProductComparePageTest *******");
		
		try {
		
			String searchProductTitle = "Mac";
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchProductTitle);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			
			ProductComparePage pcp = sp.clickProductCompareLink();
			Assert.assertTrue(pcp.getPageTitle().contains("Product Comparison"),"Failed to navigate to Product Compare page.");
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_013_ProductComparePageTest *******");
		
		
	}
	
}
