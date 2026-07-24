package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_008_ProductComparePageSearchPageNavigationTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void adding_product_to_compare_homepage_featured_section() {
		
		logger.info("***Starting TC_PC_008_ProductComparePageSearchPageNavigationTest ***");

		String searchInput = "iMac";
 
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchInput);
			SearchPage sp = hp.clickSearch();
			ProductComparePage pc = sp.clickProductCompareLink();
			
			Thread.sleep(2000);
		
			Assert.assertTrue(pc.getPageTitle().contains("Product Comparison"), "Failed to navigate to Product Compare page!");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Starting TC_PC_008_ProductComparePageSearchPageNavigationTest ***");

		
	}

}
