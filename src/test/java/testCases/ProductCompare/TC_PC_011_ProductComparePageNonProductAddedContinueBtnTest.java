package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_011_ProductComparePageNonProductAddedContinueBtnTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void validate_product_comparison_continue_btn() {
		
		logger.info("***Starting TC_PC_011_ProductComparePageNonProductAddedContinueBtnTest ***");

 
		try {
			
			HomePage hp = new HomePage();
			hp.hoverNavBarDesktop();
			DesktopsPage dp = hp.clickShowAllDesktopFromNavBarDesktopMenu();
			
			ProductComparePage pc = dp.clickProductCompareLink();
			HomePage hp2 = pc.clickContinueBtn();
			
			Thread.sleep(500);
		
			Assert.assertTrue(hp2.getPageTitle().contains("Your Store"), "Failed to navigation to Homepage");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Finished TC_PC_011_ProductComparePageNonProductAddedContinueBtnTest ***");

		
	}

}
