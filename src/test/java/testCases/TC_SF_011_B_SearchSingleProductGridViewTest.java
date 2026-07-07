package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_011_B_SearchSingleProductGridViewTest extends BaseClass {
	
	@Test(groups = {"master", "search"})
	void validate_single_search_result_grid_view() {

		logger.info("******* Starting TC_SF_011_B_SearchSingleProductGridViewTest *******");
		
		try {
		
			String searchProductTitle = "iMac";
			
			HomePage hp = new HomePage();
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			sp.inputSearchCriteria(searchProductTitle);
			sp.clickSearchBtn();
			
			//validate grid view
			sp.clickGridViewBtn();
			Assert.assertTrue(sp.isListGridEnable(), "Product should be displayed in Grid view successfully.");
			
			sp.clickAddToCart();
			Assert.assertTrue(sp.isAlertBannerDisplayed(), "Add to Cart button should work normally in List view.");
			Assert.assertTrue(sp.getAlertBannerText().contains("Success: You have added"), "Add to Cart button should work normally in List view.");
			
			sp.refreshPage();
			
			sp.clickAddToWishList();
			Assert.assertTrue(sp.isAlertBannerDisplayed(), "Add to Wish List button should work normally in List view.");
			Assert.assertTrue(sp.getAlertBannerText().contains("You must login"), "Add to Wish List button should work normally in List view.");
			
			sp.refreshPage();
			
			sp.clickCompareToThisProduct();
			Assert.assertTrue(sp.isAlertBannerDisplayed(), "Compare this product button should work normally in List view.");
			Assert.assertTrue(sp.getAlertBannerText().contains("Success: You have added") && sp.isCompareProductLinkDisplayed(), "Compare this product button should work normally in List view.");
			
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_011_B_SearchSingleProductGridViewTest *******");
		
		
	}
	
	
}
