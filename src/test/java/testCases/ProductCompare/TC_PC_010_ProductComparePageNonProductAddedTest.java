package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_010_ProductComparePageNonProductAddedTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_without_adding_any_product() {
		
		logger.info("***Starting TC_PC_010_ProductComparePageNonProductAddedTest ***");

		String searchInput = "iMac";
 
		try {
			
			HomePage hp = new HomePage();
			hp.hoverNavBarDesktop();
			DesktopsPage dp = hp.clickShowAllDesktopFromNavBarDesktopMenu();
			
			ProductComparePage pc = dp.clickProductCompareLink();
			
			Thread.sleep(500);
		
			Assert.assertTrue(pc.isNonProductAddedMessageDisplayed(), "You have not chosen any products to compare.' should be displayed on the page.");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_010_ProductComparePageNonProductAddedTest ***");

		
	}

}
