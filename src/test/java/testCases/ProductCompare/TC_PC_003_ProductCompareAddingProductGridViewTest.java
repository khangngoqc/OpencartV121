package testCases.ProductCompare;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_003_ProductCompareAddingProductGridViewTest extends BaseClass{
	
	String searchInput = "iMac";
	
	@Test(groups = {"product compare", "master"})
	void adding_product_to_compare_grid_view() {
		
		logger.info("***Starting TC_PC_003_ProductCompareAddingProductGridViewTest ***");

		
		try {
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchInput);
			SearchPage sp = hp.clickSearch();
			sp.clickGridViewBtn();
			sp.clickCompareToThisProduct();
			
			Assert.assertTrue(sp.isProductCompareBtnHoveringWork(), "Failed to dislpay button tooltip!");
			Assert.assertTrue(sp.isProductCompareAlertBannerWork(searchInput), "Failed to dislpay alert banner!");
			
			ProductComparePage pc = sp.clickProductCompareLink();
			
			Assert.assertTrue(sp.getDriver().getPageSource().contains(searchInput), "Failed to navigate to Product Compare page!");
			
			
		} catch (Exception e) {
			
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("***Starting TC_PC_003_ProductCompareAddingProductGridViewTest ***");

		
	}

}
