package testCases.Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_012_A_SearchMultipleProductListViewTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void validate_multiple_search_results_list_view() {

		logger.info("******* Starting TC_SF_012_A_SearchMultipleProductListViewTest *******");
		
		try {
		
			String searchProductTitle = "Mac";
			
			HomePage hp = new HomePage();
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			sp.inputSearchCriteria(searchProductTitle);
			
			//validate list view
			sp.clickSearchBtn();
			sp.clickListViewBtn();
			Assert.assertTrue(sp.isListViewEnable(), "Product should be displayed in List view successfully.");
			
			
			//More than one product display
			Assert.assertTrue(sp.getSearchResultCount()>1, "More than one products should be displayed in the search result page in List View");
			
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
			Assert.assertTrue(sp.getAlertBannerText().contains("Success: You have added"), "Compare this product button should work normally in List view.");
			
			//navigate to product page - Image
			String firstProductTitle = sp.getFirstSearchProductTitle();
			
			ProductDisplayPage detailPage = sp.clickFirstProductImage();
			System.out.println(firstProductTitle);
			System.out.println(detailPage.getPageTitle());
			Assert.assertTrue(detailPage.getPageTitle().contains(firstProductTitle.trim()), "Failed to navigate to Product Display page! - Image");
			
			sp.backToPreviousPage();
			//Thread.sleep(3000);
			
			//navigate to product page - Image
			ProductDisplayPage detailPage2 = sp.clickFirstProductTitle();
			Assert.assertTrue(detailPage2.getPageTitle().contains(firstProductTitle.trim()), "Failed to navigate to Product Display page! - Title");
			
			
			
			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_012_A_SearchMultipleProductListViewTest *******");
		
		
	}
	
}
