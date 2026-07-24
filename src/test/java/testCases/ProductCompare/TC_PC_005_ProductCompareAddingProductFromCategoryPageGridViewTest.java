package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import testBase.BaseClass;

public class TC_PC_005_ProductCompareAddingProductFromCategoryPageGridViewTest extends BaseClass{

	@Test(groups = {"product compare", "master"})
	void adding_product_to_compare_grid_view_category() {
		
		logger.info("***Starting TC_PC_005_ProductCompareAddingProductFromCategoryPageGridViewTest ***");

		
		try {
			
			HomePage hp = new HomePage();
			hp.hoverNavBarDesktop();
			DesktopsPage dp = hp.clickShowAllDesktopFromNavBarDesktopMenu();
			dp.clickGridViewBtn();
			Thread.sleep(2000);

			Assert.assertTrue(dp.isCompareThisProductBtnTooltipWork(), "Failed to dislpay button tooltip!");

			dp.clickCompareThisProductBtn();
			Assert.assertTrue(dp.isCompareThisProductAlertDisplayed_FirstProduct(), "Failed to dislpay alert banner!");
			
			String firstProductTitle = dp.getFirstProductTitle();
			
			ProductComparePage pc = dp.clickProductCompareLink();
			
			Assert.assertTrue(dp.getDriver().getPageSource().contains(firstProductTitle), "Failed to navigate to Product Compare page!");
						
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Starting TC_PC_005_ProductCompareAddingProductFromCategoryPageGridViewTest ***");

		
	}

}
