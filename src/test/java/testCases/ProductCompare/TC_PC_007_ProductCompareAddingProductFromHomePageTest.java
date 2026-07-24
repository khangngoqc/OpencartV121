package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_007_ProductCompareAddingProductFromHomePageTest extends BaseClass{
	
	@Test(groups = {"product compare", "master"})
	void adding_product_to_compare_homepage_featured_section() {
		
		logger.info("***Starting TC_PC_007_ProductCompareAddingProductFromHomePageTest ***");

		
		try {
			
			HomePage hp = new HomePage();
			
			Thread.sleep(2000);

			Assert.assertTrue(hp.isCompareThisProductBtnTooltipWork(), "Failed to dislpay button tooltip!");

			hp.clickCompareThisProductBtn();
			Assert.assertTrue(hp.isCompareThisProductAlertDisplayed_FirstProduct(), "Failed to dislpay alert banner!");
			
			String firstProductTitle = hp.getFirstProductTitle();
			
			ProductComparePage pc = hp.clickAlertProductComparisonProductLink();
			
			Assert.assertTrue(pc.getDriver().getPageSource().contains(firstProductTitle), "Failed to navigate to Product Compare page!");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Starting TC_PC_007_ProductCompareAddingProductFromHomePageTest ***");

		
	}

}
