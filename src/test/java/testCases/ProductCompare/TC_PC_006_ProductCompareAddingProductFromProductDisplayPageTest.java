package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_006_ProductCompareAddingProductFromProductDisplayPageTest extends BaseClass{

	String searchInput = "iMac";
	
	@Test(groups = {"product compare", "master"})
	void adding_product_to_compare_product_display_page_related_product() {
		
		logger.info("***Starting TC_PC_006_ProductCompareAddingProductFromProductDisplayPageTest ***");

		
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchInput);
			SearchPage sp = hp.clickSearch();
			
			ProductDisplayPage dp = sp.clickFirstProductTitle();;
			
			Thread.sleep(2000);

			Assert.assertTrue(dp.isCompareThisProductBtnTooltipWork(), "Failed to dislpay button tooltip!");

			dp.clickCompareThisProductBtn();
			Assert.assertTrue(dp.isCompareThisProductAlertDisplayed_FirstProduct(), "Failed to dislpay alert banner!");
			
			String firstProductTitle = dp.getFirstProductTitle();
			
			ProductComparePage pc = dp.clickAlertProductComparisonProductLink();
			
			Assert.assertTrue(pc.getDriver().getPageSource().contains(firstProductTitle), "Failed to navigate to Product Compare page!");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Starting TC_PC_006_ProductCompareAddingProductFromProductDisplayPageTest ***");

		
	}

}
