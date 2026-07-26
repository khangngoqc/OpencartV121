package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_012_ProductCompareBreadcrumbTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_breadcrumb() {
		
		logger.info("***Starting TC_PC_012_ProductCompareBreadcrumbTest ***");
 
		try {
			
			HomePage hp = new HomePage();
			hp.hoverNavBarDesktop();
			DesktopsPage dp = hp.clickShowAllDesktopFromNavBarDesktopMenu();
			
			ProductComparePage pc = dp.clickProductCompareLink();
			
			
			Thread.sleep(500);
		
			Assert.assertTrue(pc.isBreadcrumbWork(), "Breadcrumb test failed");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_012_ProductCompareBreadcrumbTest ***");

		
	}

}
