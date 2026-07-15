package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductComparePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_014_A_SearchProductSortTest extends BaseClass {

	
	@Test(groups = {"master", "search"})
	void product_comparison_navigate() {

		logger.info("******* Starting TC_SF_014_A_SearchProductSortTest *******");
		
		try {
		
			String searchProductTitle = "Mac";
			
			HomePage hp = new HomePage();
			hp.setSearchInput(searchProductTitle);
			hp.clickSearch();
			
			SearchPage sp = new SearchPage();
			Assert.assertTrue(sp.getSearchResultCount()>1, "More than on products should be displayed in the search result page.");

			sp.selectSortByDropdown("Name (A - Z)");
			Assert.assertTrue(sp.isProductTitlesSortedAtoZ(), "Search product should be sort by Name A - Z");

			sp.selectSortByDropdown("Name (Z - A)");
			Assert.assertTrue(sp.isProductTitlesSortedZtoA(), "Search product should be sort by Name Z - A");
			
			sp.selectSortByDropdown("Price (Low > High)");
			Assert.assertTrue(sp.isProductPriceSortedLowtoHigh(), "Search product should be sort by Price (Low > High)");
			
			sp.selectSortByDropdown("Price (High > Low)");
			Assert.assertTrue(sp.isProductPriceSortedHightoLow(), "Search product should be sort by Price (High > Low)");
			
			sp.selectSortByDropdown("Model (A - Z)");
			Assert.assertTrue(sp.isProductModelSortedAtoZ(), "Search product should be sort by Model (A - Z)");
			
			sp.selectSortByDropdown("Model (Z - A)");
			Assert.assertTrue(sp.isProductModelSortedZtoA(), "Search product should be sort by Model (Z - A)");

			
		} catch (Exception e) {
		
			logger.debug(e.getMessage());
			Assert.fail(e.getMessage());
		
		}
		
		logger.info("******* Finished TC_SF_014_A_SearchProductSortTest *******");
		
		
	}
	
}
