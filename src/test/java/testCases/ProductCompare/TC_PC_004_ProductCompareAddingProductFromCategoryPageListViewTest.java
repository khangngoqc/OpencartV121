package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_004_ProductCompareAddingProductFromCategoryPageListViewTest extends BaseClass{

	@Test(groups = {"product compare", "master"})
	void adding_product_to_compare_list_view_category() {
		
		logger.info("***Starting TC_PC_004_ProductCompareAddingProductFromCategoryPageListViewTest ***");

		
		try {
			
			HomePage hp = new HomePage();
			hp.hoverNavBarDesktop();
			DesktopsPage dp = hp.clickShowAllDesktopFromNavBarDesktopMenu();
			dp.clickListViewBtn();
			Thread.sleep(2000);


			Assert.assertTrue(dp.isCompareThisProductBtnTooltipWork(), "Failed to display button tooltip!");

			dp.clickCompareThisProductBtn();
			Assert.assertTrue(dp.isCompareThisProductAlertDisplayed_FirstProduct(), "Failed to display alert banner!");
			
			String firstProductTitle = dp.getFirstProductTitle();
			
			ProductComparePage pc = dp.clickProductCompareLink();
			
			Assert.assertTrue(dp.getDriver().getPageSource().contains(firstProductTitle), "Failed to navigate to Product Compare page!");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Starting TC_PC_004_ProductCompareAddingProductFromCategoryPageListViewTest ***");

		
	}

}
